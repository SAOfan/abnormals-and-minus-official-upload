package net.mcreator.allfiction.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.allfiction.potion.PotionBookmaker;
import net.mcreator.allfiction.potion.PotionAlteredGod;
import net.mcreator.allfiction.ElementsAllfiction;

import java.util.Iterator;

@ElementsAllfiction.ModElement.Tag
public class ProcedureAbnormality4OnKeyPressed extends ElementsAllfiction.ModElement {
	public ProcedureAbnormality4OnKeyPressed(ElementsAllfiction instance) {
		super(instance, 34);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Abnormality4OnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
				? ((EntityPlayerMP) entity).getAdvancements()
						.getProgress(
								((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("allfiction:hybridgodmode")))
						.isDone()
				: false)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).clearActivePotions();
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionAlteredGod.potion, (int) 1000000, (int) 1, (false), (false)));
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionBookmaker.potion, (int) 1000000, (int) 1, (false), (false)));
			if (((entity instanceof EntityPlayer)
					? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(Items.ENDER_PEARL, (int) (1)))
					: false)) {
				if (entity instanceof EntityPlayerMP) {
					Advancement _adv = ((MinecraftServer) ((EntityPlayerMP) entity).mcServer).getAdvancementManager()
							.getAdvancement(new ResourceLocation("allfiction:theendgod"));
					AdvancementProgress _ap = ((EntityPlayerMP) entity).getAdvancements().getProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemaningCriteria().iterator();
						while (_iterator.hasNext()) {
							String _criterion = (String) _iterator.next();
							((EntityPlayerMP) entity).getAdvancements().grantCriterion(_adv, _criterion);
						}
					}
				}
			}
		}
	}
}