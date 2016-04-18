package carboniferous.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import carboniferous.world.genlayer.GenLayerCarboniferous;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class WorldChunkMangerCarboniferous extends WorldChunkManager {
    
	private GenLayer genBiomes;

    /** A GenLayer containing the indices into BiomeGenBase.getBiome(] */
    private GenLayer biomeIndexLayer;

    /** The BiomeCache object for this world. */
    private BiomeCache biomeCache;

    /** A list of biomes that the player can spawn in. */
    private List biomesToSpawnIn;

    protected WorldChunkMangerCarboniferous() {
        this.biomeCache = new BiomeCache(this);
        this.biomesToSpawnIn = new ArrayList();
    }

    public WorldChunkMangerCarboniferous(long seed, WorldType worldType) {
        this();
        GenLayer[] var4 = GenLayerCarboniferous.createDim(seed, worldType);
        this.genBiomes = var4[0];
        this.biomeIndexLayer = var4[1];
    }

    public WorldChunkMangerCarboniferous(World world) {
        this(world.getSeed(), world.getWorldInfo().getTerrainType());
    }

    @Override
    public List getBiomesToSpawnIn() {
        return this.biomesToSpawnIn;
    }

    @Override
    public BiomeGenBase getBiomeGenAt(int x, int z) {
        return this.biomeCache.getBiomeGenAt(x, z);
    }

    @Override
    public float[] getRainfall(float[] listToReuse, int x, int z, int width, int length) {
        IntCache.resetIntCache();

        if (listToReuse == null || listToReuse.length < width * length)
            listToReuse = new float[width * length];

        int[] var6 = this.biomeIndexLayer.getInts(x, z, width, length);

        for (int var7 = 0; var7 < width * length; ++var7) {
            float var8 = (float)BiomeGenBase.getBiome(var6[var7]).getIntRainfall() / 65536.0F;

            if (var8 > 1.0F)
                var8 = 1.0F;

            listToReuse[var7] = var8;
        }

        return listToReuse;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getTemperatureAtHeight(float temp, int y) {
        return temp;
    }

    @Override
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] biomes, int x, int z, int width, int height) {
    	 IntCache.resetIntCache();

         if (biomes == null || biomes.length < width * height)
             biomes = new BiomeGenBase[width * height];

         int[] aint = this.genBiomes.getInts(x, z, width, height);

         try {
             for (int i1 = 0; i1 < width * height; ++i1)
                 biomes[i1] = BiomeGenBase.getBiome(aint[i1]);

             return biomes;
         }
         catch (Throwable throwable) {
             CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
             CrashReportCategory crashreportcategory = crashreport.makeCategory("RawBiomeBlock");
             crashreportcategory.addCrashSection("biomes[] size", Integer.valueOf(biomes.length));
             crashreportcategory.addCrashSection("x", Integer.valueOf(x));
             crashreportcategory.addCrashSection("z", Integer.valueOf(z));
             crashreportcategory.addCrashSection("w", Integer.valueOf(width));
             crashreportcategory.addCrashSection("h", Integer.valueOf(height));
             throw new ReportedException(crashreport);
         }
    }

    @Override
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] oldBiomeList, int x, int z, int width, int depth) {
        return this.getBiomeGenAt(oldBiomeList, x, z, width, depth, true);
    }

    @Override
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] listToReuse, int x, int y, int width, int depth, boolean par6) {
        IntCache.resetIntCache();

        if (listToReuse == null || listToReuse.length < width * depth)
            listToReuse = new BiomeGenBase[width * depth];

        if (par6 && width == 16 && depth == 16 && (x & 15) == 0 && (y & 15) == 0) {
            BiomeGenBase[] var9 = this.biomeCache.getCachedBiomes(x, y);
            System.arraycopy(var9, 0, listToReuse, 0, width * depth);
            return listToReuse;
        }
        else {
            int[] var7 = this.biomeIndexLayer.getInts(x, y, width, depth);

            for (int var8 = 0; var8 < width * depth; ++var8)
                listToReuse[var8] = BiomeGenBase.getBiome(var7[var8]);

            return listToReuse;
        }
    }

    @Override
    public boolean areBiomesViable(int x, int z, int radius, List allowed) {
    	IntCache.resetIntCache();
        int l = x - radius >> 2;
        int i1 = z - radius >> 2;
        int j1 = x + radius >> 2;
        int k1 = z + radius >> 2;
        int l1 = j1 - l + 1;
        int i2 = k1 - i1 + 1;
        int[] aint = this.genBiomes.getInts(l, i1, l1, i2);

        try {
            for (int j2 = 0; j2 < l1 * i2; ++j2) {
                BiomeGenBase biomegenbase = BiomeGenBase.getBiome(aint[j2]);

                if (!allowed.contains(biomegenbase))
                    return false;
            }

            return true;
        }
        catch (Throwable throwable) {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
            crashreportcategory.addCrashSection("Layer", this.genBiomes.toString());
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("radius", Integer.valueOf(radius));
            crashreportcategory.addCrashSection("allowed", allowed);
            throw new ReportedException(crashreport);
        }
    	
    }

    @Override
    public ChunkPosition findBiomePosition(int par1, int par2, int par3, List par4List, Random par5Random) {
    	IntCache.resetIntCache();
    	int var6 = par1 - par3 >> 2;
        int var7 = par2 - par3 >> 2;
        int var8 = par1 + par3 >> 2;
        int var9 = par2 + par3 >> 2;
        int var10 = var8 - var6 + 1;
        int var11 = var9 - var7 + 1;
        int[] var12 = this.genBiomes.getInts(var6, var7, var10, var11);
        ChunkPosition var13 = null;
        int var14 = 0;

        for (int var15 = 0; var15 < var12.length; ++var15)
        {
            int var16 = var6 + var15 % var10 << 2;
            int var17 = var7 + var15 / var10 << 2;
            BiomeGenBase var18 = BiomeGenBase.getBiome(var12[var15]);

            if (par4List.contains(var18) && (var13 == null || par5Random.nextInt(var14 + 1) == 0))
            {
                var13 = new ChunkPosition(var16, 0, var17);
                ++var14;
            }
        }

        return var13;
    }

    @Override
    public void cleanupCache() {
        this.biomeCache.cleanupCache();
    }
}
