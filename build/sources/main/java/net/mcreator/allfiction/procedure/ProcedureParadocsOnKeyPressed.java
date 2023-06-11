package net.mcreator.allfiction.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import net.mcreator.allfiction.potion.PotionTherefore;
import net.mcreator.allfiction.ElementsAllfiction;

@ElementsAllfiction.ModElement.Tag
public class ProcedureParadocsOnKeyPressed extends ElementsAllfiction.ModElement {
	public ProcedureParadocsOnKeyPressed(ElementsAllfiction instance) {
		super(instance, 50);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ParadocsOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
				? ((EntityPlayerMP) entity).getAdvancements()
						.getProgress(((WorldServer) entity.world).getAdvancementManager()
								.getAdvancement(new ResourceLocation("allfiction:contradictoryconjunction")))
						.isDone()
				: false)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionTherefore.potion, (int) 1000000, (int) 1));
			if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) >= 14)) {
				if (!entity.world.isRemote && entity.world.getMinecraftServer() != null) {
					entity.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return entity.world;
						}

						@Override
						public MinecraftServer getServer() {
							return entity.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return entity.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(entity.posX, entity.posY, entity.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return entity;
						}
					}, "kill @e[r=3,rm=1]");
				}
			}
		}
	}
}
