package net.mcreator.allfiction.procedure;

import net.minecraft.world.World;
import net.minecraft.world.GameType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import net.mcreator.allfiction.ElementsAllfiction;

@ElementsAllfiction.ModElement.Tag
public class ProcedureStopAbnormalityOnKeyPressed extends ElementsAllfiction.ModElement {
	public ProcedureStopAbnormalityOnKeyPressed(ElementsAllfiction instance) {
		super(instance, 25);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure StopAbnormalityOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).setGameType(GameType.SURVIVAL);
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).clearActivePotions();
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
			}, "effect SAO_fan minecaft:unluck 1000000");
		}
	}
}
