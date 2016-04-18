package carboniferous.world.biome;

import java.util.Random;

import carboniferous.entity.EntityDimetrodon;
import carboniferous.entity.EntityOrthacanthus;
import carboniferous.world.feature.WorldGenLepidodendron;
import carboniferous.world.feature.WorldGenSmallTrees;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenHighlands extends BiomeGenBaseCarboniferous {
	
    public BiomeGenHighlands(int par1) {
        super(par1);
        //this.minHeight = 0.1F;
        //this.maxHeight = 1.9F;
        this.setHeight(BiomeGenBaseCarboniferous.height_highlands);
        this.setBiomeName("Highlands");
        this.theBiomeDecorator.treesPerChunk = 4;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDimetrodon.class, 26, 2, 3));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityOrthacanthus.class, 12, 3, 5));
    }

    @Override
    public int getSkyColorByTemp(float var1) {
        return 0x669933;
    }

    @Override
    public WorldGenAbstractTree func_150567_a(Random random) {
        int i = random.nextInt(10);
        if (i == 0) {
            return (WorldGenAbstractTree)new WorldGenLepidodendron(false);
        }
        else {
            return (WorldGenAbstractTree)new WorldGenSmallTrees(false);
        }
    }
}
