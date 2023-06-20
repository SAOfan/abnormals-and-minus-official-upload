package net.mcreator.allfiction.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.allfiction.ElementsAllfiction;

@ElementsAllfiction.ModElement.Tag
public class ProcedurePhilipsscrewblockBulletHitsPlayer extends ElementsAllfiction.ModElement {
	public ProcedurePhilipsscrewblockBulletHitsPlayer(ElementsAllfiction instance) {
		super(instance, 2);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PhilipsscrewblockBulletHitsPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
				? ((EntityPlayerMP) entity).getAdvancements()
						.getProgress(((WorldServer) entity.world).getAdvancementManager()
								.getAdvancement(new ResourceLocation("allfiction:theloservicepresident")))
						.isDone()
				: false)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, (int) 5, (int) 255));
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).getFoodStats().setFoodLevel((int) 10);
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).clearActivePotions();
		}
	}
}
