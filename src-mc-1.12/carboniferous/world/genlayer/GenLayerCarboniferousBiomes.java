package carboniferous.world.genlayer;

import java.util.ArrayList;
import java.util.List;

import carboniferous.ModBiomes;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCarboniferousBiomes extends GenLayer {
    
	private static List<Biome> biomes = new ArrayList<Biome>();
	
	public static void registerBiome(Biome biome) {
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
                if(nextInt(8) == 0) {
                	var5[var7 + var6 * var3] = Biome.getIdForBiome(ModBiomes.CARBONIFEROUS_OCEAN);
                }
                else if(nextInt(6) == 0) {
                	var5[var7 + var6 * var3] = Biome.getIdForBiome(ModBiomes.RAINFOREST);
                }
                else if(nextInt(7) == 0) {//6
                	var5[var7 + var6 * var3] = Biome.getIdForBiome(ModBiomes.HIGHLANDS);
                }
                else if(nextInt(10) == 0) {//10
                	var5[var7 + var6 * var3] = Biome.getIdForBiome(ModBiomes.ICE_SHEET);
                }
                else {
                	var5[var7 + var6 * var3] = Biome.getIdForBiome(this.biomes.get(this.nextInt(biomes.size())));
                }
            }
        }

        return var5;
    }
}
