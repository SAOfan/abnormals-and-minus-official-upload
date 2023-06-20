package net.mcreator.allfiction.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.allfiction.gui.GuiAlibiBlockdesc;
import net.mcreator.allfiction.ElementsAllfiction;
import net.mcreator.allfiction.Allfiction;

@ElementsAllfiction.ModElement.Tag
public class ProcedureSkillAlibiBlock extends ElementsAllfiction.ModElement {
	public ProcedureSkillAlibiBlock(ElementsAllfiction instance) {
		super(instance, 71);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SkillAlibiBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SkillAlibiBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SkillAlibiBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SkillAlibiBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SkillAlibiBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).openGui(Allfiction.instance, GuiAlibiBlockdesc.GUIID, world, x, y, z);
	}
}
