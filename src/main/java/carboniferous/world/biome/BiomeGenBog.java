package carboniferous.world.biome;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import carboniferous.entity.EntityCrab;
import carboniferous.entity.EntityDendrerpeton;
import carboniferous.entity.EntityDimetrodon;
import carboniferous.entity.EntityOrthacanthus;
import carboniferous.world.feature.WorldGenCalamites;
import carboniferous.world.feature.WorldGenCordaites;
import carboniferous.world.feature.WorldGenLepidodendron;
import carboniferous.world.feature.WorldGenSmallTrees;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenBog extends BiomeGenBaseCarboniferous {
    
	public BiomeGenBog(int i) {
        super(i);
        //this.minHeight = -0.25F;
        //this.maxHeight = -0.5F;
        this.setHeight(BiomeGenBaseCarboniferous.height_bog);
        this.waterColorMultiplier = 0x333300;
        this.setBiomeName("Bog");
        this.theBiomeDecorator.treesPerChunk = 6;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDendrerpeton.class, 25, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCrab.class, 7, 3, 6));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityOrthacanthus.class, 27, 1, 3));
    }

	@Override
    public int getSkyColorByTemp(float f) {
		return Color.getHSBColor(0.14F, 0.22F, 0.39F).getRGB();
    }

	@Override
    public WorldGenAbstractTree func_150567_a(Random random) {
        int i = random.nextInt(30);
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
    }
}
