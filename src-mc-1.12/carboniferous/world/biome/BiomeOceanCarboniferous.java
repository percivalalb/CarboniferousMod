package carboniferous.world.biome;

import net.minecraft.world.biome.Biome.BiomeProperties;

/**
 * @author ProPercivalalb
 **/
public class BiomeOceanCarboniferous extends BiomeCarboniferous {
   
	public BiomeOceanCarboniferous() {
		super(new BiomeProperties("Carboniferous Ocean").setBaseHeight(-3.0F).setHeightVariation(0.0F).setTemperature(2.0F).setRainfall(2.0F).setWaterColor(39219));
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        //this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityBrachiopod.class, 30, 4, 4));
        //this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityAmmonite.class, 30, 4, 4));
        //this.getBiomeDecorator().coralPerChunk = 6;
    }

	@Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0x336666;
    }
}
