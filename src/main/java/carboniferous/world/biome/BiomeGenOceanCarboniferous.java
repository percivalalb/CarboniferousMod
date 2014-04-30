package carboniferous.world.biome;

import java.util.List;

import carboniferous.entity.EntityAmmonite;
import carboniferous.entity.EntityBrachiopod;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenOceanCarboniferous extends BiomeGenBaseCarboniferous {
   
	public BiomeGenOceanCarboniferous(int par1) {
        super(par1);
        this.setHeight(BiomeGenBaseCarboniferous.height_carboniferous_ocean);
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityBrachiopod.class, 30, 4, 4));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityAmmonite.class, 30, 4, 4));
        this.setBiomeName("Carboniferous Ocean");
    }

	@Override
    public int getSkyColorByTemp(float par1) {
        return 0x336666;
    }
}
