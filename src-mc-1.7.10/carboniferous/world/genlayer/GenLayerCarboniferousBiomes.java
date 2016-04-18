package carboniferous.world.genlayer;

import java.util.ArrayList;
import java.util.List;

import carboniferous.world.biome.BiomeGenBaseCarboniferous;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCarboniferousBiomes extends GenLayer {
    
	private static List<BiomeGenBase> biomes = new ArrayList<BiomeGenBase>();
	
	public static void registerBiome(BiomeGenBase biome) {
		if(!biomes.contains(biome)) {
			biomes.add(biome);
		}
	}
	
    public GenLayerCarboniferousBiomes(long var1, GenLayer var3) {
        super(var1);
        this.parent = var3;
    }

    public GenLayerCarboniferousBiomes(long var1) {
        super(var1);
    }

    @Override
    public int[] getInts(int var1, int var2, int var3, int var4) {
        int[] var5 = IntCache.getIntCache(var3 * var4);

        for (int var6 = 0; var6 < var4; ++var6) {
            for (int var7 = 0; var7 < var3; ++var7) {
                this.initChunkSeed((long)(var7 + var1), (long)(var6 + var2));
                if(nextInt(28) == 0) {
                	var5[var7 + var6 * var3] = BiomeGenBaseCarboniferous.carboniferousOcean.biomeID;
                }
                else if(nextInt(10) == 0) {
                	var5[var7 + var6 * var3] = BiomeGenBaseCarboniferous.rainforest.biomeID;
                }
                else {
                	var5[var7 + var6 * var3] = this.biomes.get(this.nextInt(biomes.size())).biomeID;
                }
            }
        }

        return var5;
    }
}
