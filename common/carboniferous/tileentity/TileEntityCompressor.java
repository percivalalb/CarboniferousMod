package carboniferous.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.logging.Level;

import carboniferous.api.Properties;
import carboniferous.core.helper.ItemStackHelper;
import carboniferous.recipe.CarboniferousRecipes;
import carboniferous.recipe.GrinderManager;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeDirection;

/**
 * @author ProPercivalalb
 **/
public class TileEntityCompressor extends TileEntityCarboniferous implements ISidedInventory {

	//Variables about the tank
	public int   numberOfSlots 	  	   = 29;
	
	private ItemStack[] contents = new ItemStack[numberOfSlots];
	public int grindTime;

	@Override
	public int getSizeInventory() {return contents.length;}
	@Override
    public ItemStack getStackInSlot(int par1) {return this.contents[par1];}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
        if (this.contents[par1] != null) {ItemStack itemstack;
        	if (this.contents[par1].stackSize <= par2) {
        		itemstack = this.contents[par1]; 
        		this.contents[par1] = null; 
        		return itemstack; 
        	}
            else {
                itemstack = this.contents[par1].splitStack(par2);
                if (this.contents[par1].stackSize == 0) {
                    this.contents[par1] = null;
                }
                return itemstack;
            }
        }
        else {
            return null;
        }
    }

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		if (this.contents[par1] != null) {
            ItemStack itemstack = this.contents[par1];
            this.contents[par1] = null;
            return itemstack;
        }
        else {
            return null;
        }
    }

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		this.contents[par1] = par2ItemStack;
        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    public boolean isInvNameLocalized() { return customName != null && customName.length() > 0; }
    public String getInvName() { return (this.isInvNameLocalized() ? this.customName : invName()); }
    public void setInvName(String customName) { this.customName = customName; }
	
	@Override
	public int getInventoryStackLimit() {return 64;}
	
	@Override
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;}
    
    @Override
    public void openChest() {}
    @Override
    public void closeChest() {}
    
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return true;
	}

	//The slots it can put the items in from a certain side
	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		switch(var1) {
		case 0: return new int[] {}; //Bottom
		case 1: return new int[] {}; //Top
		case 2: return new int[] {}; //
		case 3: return new int[] {}; //
		case 4: return new int[] {}; // 
		case 5: return new int[] {}; //
		default: return null;
		}
	}

	//Whether the items in valid going into a certain side
	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	//Weather the items going out are valid from a certain slot
	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return true;
	}
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
	    super.readFromNBT(par1NBTTagCompound);
	    NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
	    this.contents = new ItemStack[this.getSizeInventory()];

	    for (int i = 0; i < nbttaglist.tagCount(); ++i) {
	        NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
	        byte b0 = nbttagcompound1.getByte("Slot");

	        if (b0 >= 0 && b0 < this.contents.length) {
	            this.contents[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	        }
	    }
	}

	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
	    super.writeToNBT(par1NBTTagCompound);
	    NBTTagList nbttaglist = new NBTTagList();

	    for (int i = 0; i < this.contents.length; ++i) {
	        if (this.contents[i] != null) {
	            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	            nbttagcompound1.setByte("Slot", (byte)i);
	            this.contents[i].writeToNBT(nbttagcompound1);
	            nbttaglist.appendTag(nbttagcompound1);
	        }
	    }
	    
	    par1NBTTagCompound.setTag("Items", nbttaglist);
	}

	@Override
	public boolean shouldSendUpdates() {
		return true;
	}
	
	@Override
	public String invName() {
		return "container.compresser";
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		
	}
}
