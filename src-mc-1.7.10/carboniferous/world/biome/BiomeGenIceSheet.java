package carboniferous.world.biome;

import java.util.Random;

import carboniferous.entity.EntityAmmonite;
import carboniferous.entity.EntityCrab;
import carboniferous.entity.EntityDendrerpeton;
import carboniferous.entity.EntityDimetrodon;
import carboniferous.entity.EntityOrthacanthus;
import carboniferous.world.feature.WorldGenCalamites;
import carboniferous.world.feature.WorldGenLepidodendron;
import carboniferous.world.feature.WorldGenSmallTrees;
import carboniferous.world.feature.WorldGenWaterCalamites;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenIceSheet extends BiomeGenBaseCarboniferous {

	public BiomeGenIceSheet(int par1) {
		super(par1);
		this.setColor(0xfa9418);
		this.setBiomeName("Ice Sheet");
		this.temperature = 0.1F;
		this.setHeight(BiomeGenBaseCarboniferous.height_icesheet);
		this.waterColorMultiplier = 0x333300;
		this.topBlock = Blocks.snow;
		this.fillerBlock = Blocks.ice;
		this.spawnableCreatureList.clear();
	    this.spawnableMonsterList.clear();
	    this.spawnableWaterCreatureList.clear();
	}

	@Override
	public int getSkyColorByTemp(float par1) {
        return 26163;
    }
}
