package carboniferous.client.renderer.entity;

import carboniferous.client.model.ModelGiantSnail;
import carboniferous.lib.ResourceReference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGiantSnail extends RenderLiving {

	public RenderGiantSnail() {
		super(new ModelGiantSnail(), 0.8F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return ResourceReference.mobGiantSnail;
	}

}
