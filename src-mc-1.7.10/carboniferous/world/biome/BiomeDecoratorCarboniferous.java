package carboniferous.world.biome;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIAMOND;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIRT;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GOLD;

import carboniferous.ModBlocks;
import carboniferous.world.feature.WorldGenAntHill;
import carboniferous.world.feature.WorldGenCoral;
import carboniferous.world.feature.WorldGenLimestone;
import carboniferous.world.feature.WorldGenSand;
import carboniferous.world.feature.WorldGenSediment;
import carboniferous.world.feature.WorldGenSpiderLair;
import carboniferous.world.feature.WorldGenVolcano;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

/**
 * @author ProPercivalalb
 **/
public class BiomeDecoratorCarboniferous extends BiomeDecorator {

	public WorldGenerator limestoneGen;
	public WorldGenerator sedimentGen;
	public WorldGenerator hermiteGen;
	public WorldGenerator pyriteGen;
	public WorldGenerator antHillGen;
	public WorldGenerator volcanoGen;
	public WorldGenerator coralGen;
	public int sedimentPerChunk;
	public int antHillsPerChunk;
	public int coralPerChunk;
	
	public BiomeDecoratorCarboniferous() {
		super();
		this.dirtGen = new WorldGenMinable(ModBlocks.dirt, 32, ModBlocks.multiBlock1);
		this.limestoneGen = new WorldGenLimestone(ModBlocks.multiBlock1, 3, 32, ModBlocks.multiBlock1);
		this.sedimentGen = new WorldGenSediment(6);
		this.clayPerChunk = 1;
		this.sandPerChunk = this.sandPerChunk2 = 1;
		this.reedsPerChunk = 0;
		this.sedimentPerChunk = 1;
		this.antHillsPerChunk = 1;
		this.coralPerChunk = 5;
	    this.goldGen = new WorldGenMinable(ModBlocks.multiBlock1, 11, 10, ModBlocks.multiBlock1);
	    this.diamondGen = new WorldGenMinable(ModBlocks.multiBlock1, 10, 10, ModBlocks.multiBlock1);
	    this.hermiteGen = new WorldGenMinable(ModBlocks.multiBlock1, 12, 5, ModBlocks.multiBlock1);
	    this.pyriteGen = new WorldGenMinable(ModBlocks.multiBlock1, 13, 2, ModBlocks.multiBlock1);
	    this.coalGen = new WorldGenMinable(ModBlocks.multiBlock3, 4, 15, ModBlocks.multiBlock1);
	    this.antHillGen = new WorldGenAntHill(true);
	    this.sandGen = new WorldGenSand(ModBlocks.sand, 5);
	    this.volcanoGen = new WorldGenVolcano(true);
	    this.coralGen = new WorldGenCoral(true);
	}
	
	@Override
	protected void genDecorations(BiomeGenBase p_150513_1_) {
		int i;
	    int j;
	    int k;
		for (i = 0; i < 1; ++i) {
            j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.volcanoGen.generate(this.currentWorld, this.randomGenerator, j, this.currentWorld.getHeightValue(j, k), k);
        }
		for (i = 0; i < this.coralPerChunk; ++i) {
            j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.coralGen.generate(this.currentWorld, this.randomGenerator, j, this.currentWorld.getTopSolidOrLiquidBlock(j, k), k);
        }
	    for (i = 0; i < 1; ++i) {
            j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
        	WorldGenSpiderLair burrows = new WorldGenSpiderLair(true);
        	burrows.generate(this.currentWorld, this.randomGenerator, j, 0, k);
        }
		for (i = 0; i < this.antHillsPerChunk; ++i) {
            j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.antHillGen.generate(this.currentWorld, this.randomGenerator, j, this.currentWorld.getHeightValue(j, k), k);
        }
		for (i = 0; i < this.sedimentPerChunk; ++i) {
            j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.sedimentGen.generate(this.currentWorld, this.randomGenerator, j, this.currentWorld.getTopSolidOrLiquidBlock(j, k), k);
        }
		super.genDecorations(p_150513_1_);
    }
	
	@Override
	protected void generateOres() {
	    this.genStandardOre1(20, this.limestoneGen, 0, 128);
	    this.genStandardOre1(10, this.dirtGen, 0, 128);
	    this.genStandardOre1(40, this.coalGen, 1, 128);
	    this.genStandardOre1(2, this.goldGen, 0, 32);
	    this.genStandardOre1(3, this.diamondGen, 0, 18);
		this.genStandardOre1(27, this.hermiteGen, 30, 60);
		this.genStandardOre1(20, this.pyriteGen, 1, 52);
		
    }
}
