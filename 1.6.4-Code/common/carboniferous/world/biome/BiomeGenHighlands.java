package carboniferous.world.biome;

import java.util.Random;

import carboniferous.entity.EntityCrab;
import carboniferous.entity.EntityDimetrodon;
import carboniferous.entity.EntityOrthacanthus;
import carboniferous.world.feature.WorldGenLepidodendron;
import carboniferous.world.feature.WorldGenSmallTrees;

import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenHighlands extends BiomeGenBaseCarboniferous {
	
    public BiomeGenHighlands(int par1) {
        super(par1);
        this.minHeight = 0.1F;
        this.maxHeight = 1.9F;
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
    public WorldGenerator getRandomWorldGenForTrees(Random random) {
        int i = random.nextInt(10);
        if (i == 0) {
            return (WorldGenerator)new WorldGenLepidodendron(false);
        }
        else {
            return (WorldGenerator)new WorldGenSmallTrees(false);
        }
    }
}
