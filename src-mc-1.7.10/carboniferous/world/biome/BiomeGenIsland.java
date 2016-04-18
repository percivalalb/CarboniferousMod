package carboniferous.world.biome;

import java.util.Random;

import carboniferous.entity.EntityAmmonite;
import carboniferous.entity.EntityBrachiopod;
import carboniferous.entity.EntityCrab;
import carboniferous.entity.EntityOrthacanthus;
import carboniferous.world.feature.WorldGenLepidodendron;
import carboniferous.world.feature.WorldGenSigillaria;
import carboniferous.world.feature.WorldGenSmallTrees;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenIsland extends BiomeGenBaseCarboniferous {
  
	public BiomeGenIsland(int i) {
        super(i);
       // this.minHeight = -0.8F;
        //this.maxHeight = 0.8F;
        this.setHeight(BiomeGenBaseCarboniferous.height_island);
        this.theBiomeDecorator.treesPerChunk = 3;
        this.setBiomeName("Island");
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityAmmonite.class, 30, 4, 4));
        //this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityTrilobite.class, 30, 4, 4));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityBrachiopod.class, 30, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCrab.class, 32, 5, 7));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityOrthacanthus.class, 32, 2, 4));
    }

	@Override
    public int getSkyColorByTemp(float par1) {
        return 0x66cc99;
    }

	@Override
    public WorldGenAbstractTree func_150567_a(Random random) {
        int i = random.nextInt(10);
        if (i == 0) {
            return (WorldGenAbstractTree)new WorldGenLepidodendron(false);
        }
        if (i == 1) {
            return (WorldGenAbstractTree)new WorldGenSigillaria(false);
        }
        else {
            return (WorldGenAbstractTree)new WorldGenSmallTrees(false);
        }
    }
}
