package net.mcreator.allfiction.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.allfiction.potion.PotionBookmaker;
import net.mcreator.allfiction.ElementsAllfiction;

@ElementsAllfiction.ModElement.Tag
public class ProcedureForsakenGodPotionStartedapplied extends ElementsAllfiction.ModElement {
	public ProcedureForsakenGodPotionStartedapplied(ElementsAllfiction instance) {
		super(instance, 33);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ForsakenGodPotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).clearActivePotions();
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionBookmaker.potion, (int) 1000000, (int) 1, (false), (false)));
	}
}
