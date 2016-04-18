package carboniferous.world.biome;

import carboniferous.entity.EntityAmmonite;
import carboniferous.entity.EntityBrachiopod;
import carboniferous.entity.EntityCrab;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenRiverCarboniferous extends BiomeGenBaseCarboniferous {
	
    public BiomeGenRiverCarboniferous(int par1) {
        super(par1);
        this.setHeight(BiomeGenBaseCarboniferous.height_carboniferous_river);
        this.spawnableWaterCreatureList.clear();
        this.setBiomeName("Old River");
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityAmmonite.class, 20, 4, 4));
        //this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityTrilobite.class, 20, 4, 4));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityBrachiopod.class, 20, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCrab.class, 9, 3, 6));
    }

    @Override
    public int getSkyColorByTemp(float f) {
        return 0x336666;
    }
}
