package net.mcreator.allfiction.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.allfiction.ElementsAllfiction;

@ElementsAllfiction.ModElement.Tag
public class ProcedureAlibiBlocksplaceteleport extends ElementsAllfiction.ModElement {
	public ProcedureAlibiBlocksplaceteleport(ElementsAllfiction instance) {
		super(instance, 65);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") != null) {
			System.err.println("Failed to load dependency entity for procedure AlibiBlocksplaceteleport!");
			return;
		}
		if (dependencies.get("x") != null) {
			System.err.println("Failed to load dependency x for procedure AlibiBlocksplaceteleport!");
			return;
		}
		if (dependencies.get("y") != null) {
			System.err.println("Failed to load dependency y for procedure AlibiBlocksplaceteleport!");
			return;
		}
		if (dependencies.get("z") != null) {
			System.err.println("Failed to load dependency z for procedure AlibiBlocksplaceteleport!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		entity.setPositionAndUpdate(x, y, z);
	}
}
