package net.mcreator.allfiction.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.allfiction.potion.PotionTritagonist;
import net.mcreator.allfiction.potion.PotionProtagnist;
import net.mcreator.allfiction.potion.PotionDeuteragonist;
import net.mcreator.allfiction.ElementsAllfiction;

@ElementsAllfiction.ModElement.Tag
public class ProcedureStoryroleOnKeyPressed extends ElementsAllfiction.ModElement {
	public ProcedureStoryroleOnKeyPressed(ElementsAllfiction instance) {
		super(instance, 45);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure StoryroleOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
				? ((EntityPlayerMP) entity).getAdvancements()
						.getProgress(
								((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("allfiction:protagnst")))
						.isDone()
				: false)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionProtagnist.potion, (int) 1000000, (int) 1));
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.LUCK, (int) 1000000, (int) 6));
		}
		if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
				? ((EntityPlayerMP) entity).getAdvancements()
						.getProgress(
								((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("allfiction:euteragonist")))
						.isDone()
				: false)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionDeuteragonist.potion, (int) 1000000, (int) 1));
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.LUCK, (int) 1000000, (int) 4));
		}
		if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
				? ((EntityPlayerMP) entity).getAdvancements()
						.getProgress(
								((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("allfiction:tritagonit")))
						.isDone()
				: false)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionTritagonist.potion, (int) 1000000, (int) 1));
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.LUCK, (int) 1000000, (int) 2));
		}
	}
}
