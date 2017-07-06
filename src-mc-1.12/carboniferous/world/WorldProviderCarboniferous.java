package carboniferous.world;

import carboniferous.api.CarboniferousModAPI;
import carboniferous.api.CarboniferousSettings;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderCarboniferous extends WorldProvider {

	private float[] colorsSunriseSunset;
	
	public WorldProviderCarboniferous() {
        this.setDimension(CarboniferousSettings.DIM_ID);
        this.colorsSunriseSunset = new float[4];
    }
	
	@Override
	protected void init() {
        this.hasSkyLight = true;
        this.biomeProvider = new WorldChunkMangerCarboniferous(this.world.getSeed(), this.world.getWorldType());
    }
	
	@Override
	public DimensionType getDimensionType() {
		return CarboniferousModAPI.DIMENSION_TYPE;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
	    float f2 = 0.4F;
	    float f3 = MathHelper.cos(celestialAngle * 3.141593F * 2.0F) - 0.0F;
	    float f4 = -0.0F;
	    if ((f3 >= f4 - f2) && (f3 <= f4 + f2)) {
	    	float f5 = (f3 - f4) / f2 * 0.5F + 0.5F;
	    	float f6 = 1.0F - (1.0F - MathHelper.sin(f5 * 3.141593F)) * 0.99F;
	    	f6 *= f6;
	    	this.colorsSunriseSunset[0] = (f5 * 0.2F + 0.2F);
	    	this.colorsSunriseSunset[1] = (f5 * f5 * 0.1F + 0.1F);
	    	this.colorsSunriseSunset[2] = (f5 * f5 * 0.3F + 0.7F);
	    	this.colorsSunriseSunset[3] = f6;
	    	return this.colorsSunriseSunset;
	    }

	    return null;
	 }
	
	@Override
    public Vec3d getFogColor(float par1, float par2) {
        float var3 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (var3 < 0.0F) {
            var3 = 0.0F;
        }

        if (var3 > 1.0F) {
            var3 = 1.0F;
        }

        float var4 = 0.7529412F;
        float var5 = 0.84705883F;
        float var6 = 1.0F;
        var4 *= var3 * 0.94F + 0.06F;
        var5 *= var3 * 0.94F + 0.06F;
        var6 *= var3 * 0.91F + 0.09F;
        return new Vec3d((double)var4, (double)var5, (double)var6);
    }
	
	@Override
    protected void generateLightBrightnessTable() {
        float var1 = 0.0F;

        for (int var2 = 0; var2 <= 15; ++var2) {
            float var3 = 1.0F - (float)var2 / 15.0F;
            this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }
    }
	
	@Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkProviderCarboniferous(this.world, this.world.getSeed(), this.world.getWorldInfo().isMapFeaturesEnabled(), this.world.getWorldInfo().getGeneratorOptions());
    }
	
	@Override
	public String getSaveFolder() {
        return "Carboniferous";
    }
}
