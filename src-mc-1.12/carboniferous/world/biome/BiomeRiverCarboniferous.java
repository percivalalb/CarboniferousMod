package carboniferous.world.biome;

import net.minecraft.world.biome.Biome.BiomeProperties;

/**
 * @author ProPercivalalb
 **/
public class BiomeRiverCarboniferous extends BiomeCarboniferous {
	
    public BiomeRiverCarboniferous() {
    	super(new BiomeProperties("Old River").setBaseHeight(-0.5F).setHeightVariation(0.0F).setTemperature(0.1F).setRainfall(2.0F).setWaterColor(39219));
        this.spawnableWaterCreatureList.clear();
        //this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityAmmonite.class, 20, 4, 4));
        //this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityTrilobite.class, 20, 4, 4));
        //this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityBrachiopod.class, 20, 4, 4));
        //this.spawnableCreatureList.add(new SpawnListEntry(EntityCrab.class, 9, 3, 6));
    }

    @Override
    public int getSkyColorByTemp(float f) {
        return 0x336666;
    }
}
