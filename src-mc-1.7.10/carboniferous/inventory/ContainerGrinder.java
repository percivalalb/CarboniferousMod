package carboniferous.inventory;

import carboniferous.tileentity.TileEntityGrinder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
/**
 * @author ProPercivalalb
 **/
public class ContainerGrinder extends Container {

	private TileEntityGrinder grinder;
	private int lastGrindTime;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;
	
	public ContainerGrinder(InventoryPlayer par1InventoryPlayer, TileEntityGrinder par2TileEntityGrinder) {
        this.grinder = par2TileEntityGrinder;
        //Input
        this.addSlotToContainer(new Slot(par2TileEntityGrinder, 0, 24, 46));
        this.addSlotToContainer(new Slot(par2TileEntityGrinder, 1, 48, 46));
        //Output
        this.addSlotToContainer(new SlotGrinder(par1InventoryPlayer.player, par2TileEntityGrinder, 2, 93, 50));
        this.addSlotToContainer(new SlotGrinder(par1InventoryPlayer.player, par2TileEntityGrinder, 3, 111, 50));
        
        this.addSlotToContainer(new SlotGrindingStone(par2TileEntityGrinder, 4, 36, 24));//Grinding Stone
        this.addSlotToContainer(new Slot(par2TileEntityGrinder, 5, 140, 38));//Fuel
        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
        }
    }
	
	@Override
	public void addCraftingToCrafters(ICrafting par1ICrafting) {
	    super.addCraftingToCrafters(par1ICrafting);
	    par1ICrafting.sendProgressBarUpdate(this, 0, this.grinder.grindTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.grinder.grinderBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.grinder.currentItemBurnTime);
	}
	
	@Override
	public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastGrindTime != this.grinder.grindTime) {
                icrafting.sendProgressBarUpdate(this, 0, this.grinder.grindTime);
            }
            if (this.lastBurnTime != this.grinder.grinderBurnTime) {
                icrafting.sendProgressBarUpdate(this, 1, this.grinder.grinderBurnTime);
            }
            if (this.lastItemBurnTime != this.grinder.currentItemBurnTime) {
                icrafting.sendProgressBarUpdate(this, 2, this.grinder.currentItemBurnTime);
            }
        }

        this.lastGrindTime = this.grinder.grindTime;
        this.lastBurnTime = this.grinder.grinderBurnTime;
        this.lastItemBurnTime = this.grinder.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int value) {
        if (id == 0) {
        	this.grinder.grindTime = value;
        }
        if (id == 1) {
            this.grinder.grinderBurnTime = value;
        }

        if (id == 2) {
            this.grinder.currentItemBurnTime = value;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return grinder.isUseableByPlayer(entityplayer);
	}
	
	public int size() {
		return grinder.getSizeInventory();
	}
}
