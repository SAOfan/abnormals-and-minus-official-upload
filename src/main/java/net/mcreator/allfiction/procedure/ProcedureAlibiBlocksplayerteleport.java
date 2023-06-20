package net.mcreator.allfiction.procedure;

import net.minecraftforge.common.DimensionManager;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.world.Teleporter;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.block.material.Material;

import net.mcreator.allfiction.ElementsAllfiction;

import java.util.HashMap;

@ElementsAllfiction.ModElement.Tag
public class ProcedureAlibiBlocksplayerteleport extends ElementsAllfiction.ModElement {
	public ProcedureAlibiBlocksplayerteleport(ElementsAllfiction instance) {
		super(instance, 66);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AlibiBlocksplayerteleport!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AlibiBlocksplayerteleport!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AlibiBlocksplayerteleport!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AlibiBlocksplayerteleport!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			System.err.println("Failed to load dependency guistate for procedure AlibiBlocksplayerteleport!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AlibiBlocksplayerteleport!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		World world = (World) dependencies.get("world");
		if (!world.isRemote && world.getMinecraftServer() != null) {
			world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
					return world;
				}

				@Override
				public MinecraftServer getServer() {
					return world.getMinecraftServer();
				}

				@Override
				public boolean sendCommandFeedback() {
					return false;
				}

				@Override
				public BlockPos getPosition() {
					return new BlockPos((int) x, (int) y, (int) z);
				}

				@Override
				public Vec3d getPositionVector() {
					return new Vec3d(x, y, z);
				}
			}, (new Object() {
				public String getText() {
					GuiTextField textField = (GuiTextField) guistate.get("text:Playername");
					if (textField != null) {
						return textField.getText();
					}
					return "";
				}
			}.getText()));
		}
		if ((Blocks.LAVA.getDefaultState().getMaterial() == Material.ROCK)) {
			if (((entity instanceof EntityPlayer) || (entity instanceof EntityPlayerMP))) {
				if (((entity.dimension) == (0))) {
					if (((entity.dimension) == (-1))) {
						if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
							int dimensionID = -1;
							class TeleporterDirect extends Teleporter {
								public TeleporterDirect(WorldServer worldserver) {
									super(worldserver);
								}

								@Override
								public void placeInPortal(Entity entity, float yawrotation) {
								}

								@Override
								public boolean placeInExistingPortal(Entity entity, float yawrotation) {
									return true;
								}

								@Override
								public boolean makePortal(Entity entity) {
									return true;
								}
							}
							EntityPlayerMP _player = (EntityPlayerMP) entity;
							_player.mcServer.getPlayerList().transferPlayerToDimension(_player, dimensionID,
									new TeleporterDirect(_player.getServerWorld()));
							_player.connection.setPlayerLocation(DimensionManager.getWorld(dimensionID).getSpawnPoint().getX(),
									DimensionManager.getWorld(dimensionID).getSpawnPoint().getY() + 1,
									DimensionManager.getWorld(dimensionID).getSpawnPoint().getZ(), _player.rotationYaw, _player.rotationPitch);
						}
						if (!world.isRemote && world.getMinecraftServer() != null) {
							world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
									return world;
								}

								@Override
								public MinecraftServer getServer() {
									return world.getMinecraftServer();
								}

								@Override
								public boolean sendCommandFeedback() {
									return false;
								}

								@Override
								public BlockPos getPosition() {
									return new BlockPos((int) x, (int) y, (int) z);
								}

								@Override
								public Vec3d getPositionVector() {
									return new Vec3d(x, y, z);
								}
							}, "tp @p @p");
						}
					} else if (((entity.dimension) == (1))) {
						if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
							int dimensionID = 1;
							class TeleporterDirect extends Teleporter {
								public TeleporterDirect(WorldServer worldserver) {
									super(worldserver);
								}

								@Override
								public void placeInPortal(Entity entity, float yawrotation) {
								}

								@Override
								public boolean placeInExistingPortal(Entity entity, float yawrotation) {
									return true;
								}

								@Override
								public boolean makePortal(Entity entity) {
									return true;
								}
							}
							EntityPlayerMP _player = (EntityPlayerMP) entity;
							_player.mcServer.getPlayerList().transferPlayerToDimension(_player, dimensionID,
									new TeleporterDirect(_player.getServerWorld()));
							_player.connection.setPlayerLocation(DimensionManager.getWorld(dimensionID).getSpawnPoint().getX(),
									DimensionManager.getWorld(dimensionID).getSpawnPoint().getY() + 1,
									DimensionManager.getWorld(dimensionID).getSpawnPoint().getZ(), _player.rotationYaw, _player.rotationPitch);
						}
						if (!world.isRemote && world.getMinecraftServer() != null) {
							world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
									return world;
								}

								@Override
								public MinecraftServer getServer() {
									return world.getMinecraftServer();
								}

								@Override
								public boolean sendCommandFeedback() {
									return false;
								}

								@Override
								public BlockPos getPosition() {
									return new BlockPos((int) x, (int) y, (int) z);
								}

								@Override
								public Vec3d getPositionVector() {
									return new Vec3d(x, y, z);
								}
							}, "tp @p @p");
						}
					} else {
						if (!world.isRemote && world.getMinecraftServer() != null) {
							world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
									return world;
								}

								@Override
								public MinecraftServer getServer() {
									return world.getMinecraftServer();
								}

								@Override
								public boolean sendCommandFeedback() {
									return false;
								}

								@Override
								public BlockPos getPosition() {
									return new BlockPos((int) x, (int) y, (int) z);
								}

								@Override
								public Vec3d getPositionVector() {
									return new Vec3d(x, y, z);
								}
							}, "tp @p @p");
						}
					}
				} else if (((entity.dimension) == (-1))) {
					if (((entity.dimension) == (1))) {
						if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
							int dimensionID = 1;
							class TeleporterDirect extends Teleporter {
								public TeleporterDirect(WorldServer worldserver) {
									super(worldserver);
								}

								@Override
								public void placeInPortal(Entity entity, float yawrotation) {
								}

								@Override
								public boolean placeInExistingPortal(Entity entity, float yawrotation) {
									return true;
								}

								@Override
								public boolean makePortal(Entity entity) {
									return true;
								}
							}
							EntityPlayerMP _player = (EntityPlayerMP) entity;
							_player.mcServer.getPlayerList().transferPlayerToDimension(_player, dimensionID,
									new TeleporterDirect(_player.getServerWorld()));
							_player.connection.setPlayerLocation(DimensionManager.getWorld(dimensionID).getSpawnPoint().getX(),
									DimensionManager.getWorld(dimensionID).getSpawnPoint().getY() + 1,
									DimensionManager.getWorld(dimensionID).getSpawnPoint().getZ(), _player.rotationYaw, _player.rotationPitch);
						}
						if (!world.isRemote && world.getMinecraftServer() != null) {
							world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
									return world;
								}

								@Override
								public MinecraftServer getServer() {
									return world.getMinecraftServer();
								}

								@Override
								public boolean sendCommandFeedback() {
									return false;
								}

								@Override
								public BlockPos getPosition() {
									return new BlockPos((int) x, (int) y, (int) z);
								}

								@Override
								public Vec3d getPositionVector() {
									return new Vec3d(x, y, z);
								}
							}, "tp @p @p");
						}
					} else if (((entity.dimension) == (0))) {
						if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
							int dimensionID = 0;
							class TeleporterDirect extends Teleporter {
								public TeleporterDirect(WorldServer worldserver) {
									super(worldserver);
								}

								@Override
								public void placeInPortal(Entity entity, float yawrotation) {
								}

								@Override
								public boolean placeInExistingPortal(Entity entity, float yawrotation) {
									return true;
								}

								@Override
								public boolean makePortal(Entity entity) {
									return true;
								}
							}
							EntityPlayerMP _player = (EntityPlayerMP) entity;
							_player.mcServer.getPlayerList().transferPlayerToDimension(_player, dimensionID,
									new TeleporterDirect(_player.getServerWorld()));
							_player.connection.setPlayerLocation(DimensionManager.getWorld(dimensionID).getSpawnPoint().getX(),
									DimensionManager.getWorld(dimensionID).getSpawnPoint().getY() + 1,
									DimensionManager.getWorld(dimensionID).getSpawnPoint().getZ(), _player.rotationYaw, _player.rotationPitch);
						}
						if (!world.isRemote && world.getMinecraftServer() != null) {
							world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
									return world;
								}

								@Override
								public MinecraftServer getServer() {
									return world.getMinecraftServer();
								}

								@Override
								public boolean sendCommandFeedback() {
									return false;
								}

								@Override
								public BlockPos getPosition() {
									return new BlockPos((int) x, (int) y, (int) z);
								}

								@Override
								public Vec3d getPositionVector() {
									return new Vec3d(x, y, z);
								}
							}, "tp @p @p");
						}
					} else {
						if (!world.isRemote && world.getMinecraftServer() != null) {
							world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
									return world;
								}

								@Override
								public MinecraftServer getServer() {
									return world.getMinecraftServer();
								}

								@Override
								public boolean sendCommandFeedback() {
									return false;
								}

								@Override
								public BlockPos getPosition() {
									return new BlockPos((int) x, (int) y, (int) z);
								}

								@Override
								public Vec3d getPositionVector() {
									return new Vec3d(x, y, z);
								}
							}, "tp @p @p");
						}
					}
				} else if (((entity.dimension) == (1))) {
					if (((entity.dimension) == (-1))) {
						if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
							int dimensionID = -1;
							class TeleporterDirect extends Teleporter {
								public TeleporterDirect(WorldServer worldserver) {
									super(worldserver);
								}

								@Override
								public void placeInPortal(Entity entity, float yawrotation) {
								}

								@Override
								public boolean placeInExistingPortal(Entity entity, float yawrotation) {
									return true;
								}

								@Override
								public boolean makePortal(Entity entity) {
									return true;
								}
							}
							EntityPlayerMP _player = (EntityPlayerMP) entity;
							_player.mcServer.getPlayerList().transferPlayerToDimension(_player, dimensionID,
									new TeleporterDirect(_player.getServerWorld()));
							_player.connection.setPlayerLocation(DimensionManager.getWorld(dimensionID).getSpawnPoint().getX(),
									DimensionManager.getWorld(dimensionID).getSpawnPoint().getY() + 1,
									DimensionManager.getWorld(dimensionID).getSpawnPoint().getZ(), _player.rotationYaw, _player.rotationPitch);
						}
						if (!world.isRemote && world.getMinecraftServer() != null) {
							world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
									return world;
								}

								@Override
								public MinecraftServer getServer() {
									return world.getMinecraftServer();
								}

								@Override
								public boolean sendCommandFeedback() {
									return false;
								}

								@Override
								public BlockPos getPosition() {
									return new BlockPos((int) x, (int) y, (int) z);
								}

								@Override
								public Vec3d getPositionVector() {
									return new Vec3d(x, y, z);
								}
							}, "tp @p @p");
						}
					} else if (((entity.dimension) == (0))) {
						if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
							int dimensionID = 0;
							class TeleporterDirect extends Teleporter {
								public TeleporterDirect(WorldServer worldserver) {
									super(worldserver);
								}

								@Override
								public void placeInPortal(Entity entity, float yawrotation) {
								}

								@Override
								public boolean placeInExistingPortal(Entity entity, float yawrotation) {
									return true;
								}

								@Override
								public boolean makePortal(Entity entity) {
									return true;
								}
							}
							EntityPlayerMP _player = (EntityPlayerMP) entity;
							_player.mcServer.getPlayerList().transferPlayerToDimension(_player, dimensionID,
									new TeleporterDirect(_player.getServerWorld()));
							_player.connection.setPlayerLocation(DimensionManager.getWorld(dimensionID).getSpawnPoint().getX(),
									DimensionManager.getWorld(dimensionID).getSpawnPoint().getY() + 1,
									DimensionManager.getWorld(dimensionID).getSpawnPoint().getZ(), _player.rotationYaw, _player.rotationPitch);
						}
						if (!world.isRemote && world.getMinecraftServer() != null) {
							world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
									return world;
								}

								@Override
								public MinecraftServer getServer() {
									return world.getMinecraftServer();
								}

								@Override
								public boolean sendCommandFeedback() {
									return false;
								}

								@Override
								public BlockPos getPosition() {
									return new BlockPos((int) x, (int) y, (int) z);
								}

								@Override
								public Vec3d getPositionVector() {
									return new Vec3d(x, y, z);
								}
							}, "tp @p @p");
						}
					} else {
						if (!world.isRemote && world.getMinecraftServer() != null) {
							world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
									return world;
								}

								@Override
								public MinecraftServer getServer() {
									return world.getMinecraftServer();
								}

								@Override
								public boolean sendCommandFeedback() {
									return false;
								}

								@Override
								public BlockPos getPosition() {
									return new BlockPos((int) x, (int) y, (int) z);
								}

								@Override
								public Vec3d getPositionVector() {
									return new Vec3d(x, y, z);
								}
							}, "tp @p @p");
						}
					}
				}
			}
		}
	}
}
