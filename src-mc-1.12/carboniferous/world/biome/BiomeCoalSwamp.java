package carboniferous.world.biome;

import java.util.Random;

import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

/**
 * @author ProPercivalalb
 **/
public class BiomeCoalSwamp extends BiomeCarboniferous {
    
	public BiomeCoalSwamp() {
		super(new BiomeProperties("Coal Swamp").setBaseHeight(-0.05F).setHeightVariation(0.10F).setTemperature(2.0F).setRainfall(2.0F).setWaterColor(0x333300));
        //this.waterColorMultiplier = 0x333300;
        this.decorator.treesPerChunk = 6;
        //this.spawnableCreatureList.add(new SpawnListEntry(EntityDendrerpeton.class, 25, 4, 4));
        //this.spawnableCreatureList.add(new SpawnListEntry(EntityCrab.class, 7, 3, 6));
        //this.spawnableCreatureList.add(new SpawnListEntry(EntityDimetrodon.class, 14, 1, 2));
        //this.spawnableMonsterList.add(new SpawnListEntry(EntityOrthacanthus.class, 27, 1, 3));
        //this.getBiomeDecorator().coralPerChunk = 1;
        //this.getBiomeDecorator().smallFernPerChunk = 8;
    }

	@Override
    public int getSkyColorByTemp(float f) {
        return 0x336633;
    }

	/**
	@Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
        int i = random.nextInt(35);
        if (i <= 6) {
            return (WorldGenAbstractTree)new WorldGenSmallTrees(false);
        }
        if (i > 6 && i <= 10) {
            return (WorldGenAbstractTree)new WorldGenCalamites(false);
        }
        if (i == 13) {
            return (WorldGenAbstractTree)new WorldGenCordaites(false);
        }
        else {
            return (WorldGenAbstractTree)new WorldGenLepidodendron(false);
        }
    }**/
}
