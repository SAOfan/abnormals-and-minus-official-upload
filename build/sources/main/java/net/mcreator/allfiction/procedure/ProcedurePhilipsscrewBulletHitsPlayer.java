package net.mcreator.allfiction.procedure;

import net.minecraft.world.GameType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.allfiction.ElementsAllfiction;

@ElementsAllfiction.ModElement.Tag
public class ProcedurePhilipsscrewBulletHitsPlayer extends ElementsAllfiction.ModElement {
	public ProcedurePhilipsscrewBulletHitsPlayer(ElementsAllfiction instance) {
		super(instance, 4);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PhilipsscrewBulletHitsPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).clearActivePotions();
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clear();
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).addExperienceLevel(-((int) 9999));
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).setGameType(GameType.SURVIVAL);
	}
}
