package carboniferous.core.util;

import net.minecraft.util.DamageSource;

public class DamageSourceBrachiopod extends DamageSource {

	public DamageSourceBrachiopod() {
		super("brachiopodDamage");
		this.setDamageBypassesArmor();
	}
	
	public DamageSource setDamageBypassesArmor() {
        return super.setDamageBypassesArmor();
    }
}
