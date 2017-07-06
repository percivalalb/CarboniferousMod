package carboniferous.world.biome;

import java.util.Random;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;

/**
 * @author ProPercivalalb
 **/
public class BiomeCalamitesSwamp extends BiomeCarboniferous {

	public BiomeCalamitesSwamp() {
		super(new BiomeProperties("Calamites Swamp").setBaseHeight(-0.15F).setHeightVariation(0.15F).setTemperature(2.0F).setRainfall(2.0F).setWaterColor(0x333300));
		//this.setColor(0xfa9418);
		//this.waterColorMultiplier = 0x333300;
		this.decorator.treesPerChunk = 6;
		//this.getBiomeDecorator().smallFernPerChunk = 14;
        //this.getBiomeDecorator().coralPerChunk = 2;
		//this.spawnableCreatureList.add(new SpawnListEntry(EntityDendrerpeton.class, 30, 4, 4));
		//this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityAmmonite.class, 30, 4, 4));
		//this.spawnableCreatureList.add(new SpawnListEntry(EntityCrab.class, 10, 3, 6));
		//this.spawnableCreatureList.add(new SpawnListEntry(EntityDimetrodon.class, 24, 1, 2));
		//this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityOrthacanthus.class, 21, 2, 4));
	}

	@Override
	public int getSkyColorByTemp(float currentTemperature) {
        return 26163;
    }

	/**
	@Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
		int i = random.nextInt(30);
        if (i <= 6) {
            return (WorldGenAbstractTree)new WorldGenSmallTrees(false);
        }
        if (i > 6 && i <= 16) {
            return (WorldGenAbstractTree)new WorldGenWaterCalamites(false);
        }
        if (i > 16 && i <= 24) {
            return (WorldGenAbstractTree)new WorldGenCalamites(false);
        }
        else {
            return (WorldGenAbstractTree)new WorldGenLepidodendron(false);
        }
    }**/
}
