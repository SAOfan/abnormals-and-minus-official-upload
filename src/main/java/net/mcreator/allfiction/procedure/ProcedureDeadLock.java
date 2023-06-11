package net.mcreator.allfiction.procedure;

import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.allfiction.ElementsAllfiction;

@ElementsAllfiction.ModElement.Tag
public class ProcedureDeadLock extends ElementsAllfiction.ModElement {
	public ProcedureDeadLock(ElementsAllfiction instance) {
		super(instance, 53);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DeadLock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
				? ((EntityPlayerMP) entity).getAdvancements()
						.getProgress(((WorldServer) entity.world).getAdvancementManager()
								.getAdvancement(new ResourceLocation("allfiction:thenonhumanwhoisjustimpartial")))
						.isDone()
				: false)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SATURATION, (int) 1000000, (int) 1, (false), (false)));
			if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) <= 4)) {
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).clearActivePotions();
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SATURATION, (int) 1000000, (int) 1, (false), (false)));
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, (int) 1200, (int) 255, (false), (false)));
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, (int) 1200, (int) 255, (false), (false)));
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			int i = (int) entity.posX;
			int j = (int) entity.posY;
			int k = (int) entity.posZ;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
