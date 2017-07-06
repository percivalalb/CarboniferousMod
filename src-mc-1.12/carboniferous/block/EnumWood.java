package carboniferous.block;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum EnumWood implements IStringSerializable {
	
    LEPIDODENDRON(0, "lepidodendron", MapColor.WOOD),
    CALAMITES(1, "calamites", MapColor.OBSIDIAN),
    CORDAITES(2, "cordaites", MapColor.SAND),
    SIGILLARIA(3, "sigillaria", MapColor.DIRT);

    private static final EnumWood[] META_LOOKUP = new EnumWood[values().length];
    private final int meta;
    private final String name;
    private final String unlocalizedName;
    /** The color that represents this entry on a map. */
    private final MapColor mapColor;

    private EnumWood(int metaIn, String nameIn, MapColor mapColorIn) {
        this(metaIn, nameIn, nameIn, mapColorIn);
    }

    private EnumWood(int metaIn, String nameIn, String unlocalizedNameIn, MapColor mapColorIn) {
        this.meta = metaIn;
        this.name = nameIn;
        this.unlocalizedName = unlocalizedNameIn;
        this.mapColor = mapColorIn;
    }

    public int getMetadata() {
        return this.meta;
    }

    /**
     * The color which represents this entry on a map.
     */
    public MapColor getMapColor() {
        return this.mapColor;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static EnumWood byMetadata(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public String getName() {
        return this.name;
    }

    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    static {
        for(EnumWood blockplanks$enumtype : values())
            META_LOOKUP[blockplanks$enumtype.getMetadata()] = blockplanks$enumtype;
    }
}