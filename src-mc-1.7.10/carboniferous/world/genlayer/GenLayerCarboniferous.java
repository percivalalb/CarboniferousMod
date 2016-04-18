package carboniferous.world.genlayer;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerFuzzyZoom;
import net.minecraft.world.gen.layer.GenLayerRiverInit;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class GenLayerCarboniferous {
	
    public static GenLayer[] createDim(long var0, WorldType var2) {
        byte var3 = 4;

        if(var2 == WorldType.LARGE_BIOMES)
            var3 = 6;

        GenLayerCarboniferousBiomes var4 = new GenLayerCarboniferousBiomes(200L);
        GenLayerFuzzyZoom var8 = new GenLayerFuzzyZoom(2000L, var4);
        GenLayerZoom var9 = new GenLayerZoom(2001L, var8);
        var9 = new GenLayerZoom(2002L, var9);
        var9 = new GenLayerZoom(2003L, var9);
        GenLayer var5 = GenLayerZoom.magnify(1000L, var9, 0);
        GenLayerRiverInit var10 = new GenLayerRiverInit(100L, var5);
        var5 = GenLayerZoom.magnify(1000L, var10, var3 + 2);
        GenLayerRiver var11 = new GenLayerRiver(1L, var5);
        GenLayerSmooth var15 = new GenLayerSmooth(1000L, var11);
        GenLayer var6 = GenLayerZoom.magnify(1000L, var9, 0);
        GenLayerCarboniferousBiomes var14 = new GenLayerCarboniferousBiomes(200L, var6);
        var6 = GenLayerZoom.magnify(1000L, var14, 2);
        Object var12 = new GenLayerHills(1000L, var6);

        for (int var7 = 0; var7 < var3; ++var7)
        {
            var12 = new GenLayerZoom(1000L + (long)var7, (GenLayer)var12);
        }

        GenLayerSmooth var16 = new GenLayerSmooth(1000L, (GenLayer)var12);
        GenLayerRiverMix var13 = new GenLayerRiverMix(100L, var16, var15);
        GenLayerVoronoiZoom var17 = new GenLayerVoronoiZoom(10L, var13);
        var13.initWorldGenSeed(var0 + 1994L);
        var17.initWorldGenSeed(var0 + 1994L);
        return new GenLayer[] {var13, var17, var13};
    }
}

    