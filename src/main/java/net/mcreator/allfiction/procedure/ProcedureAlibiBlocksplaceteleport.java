package net.mcreator.allfiction.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.allfiction.ElementsAllfiction;

@ElementsAllfiction.ModElement.Tag
public class ProcedureAlibiBlocksplaceteleport extends ElementsAllfiction.ModElement {
	public ProcedureAlibiBlocksplaceteleport(ElementsAllfiction instance) {
		super(instance, 65);
	}
	
	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AlibiBlocksplaceteleport!");
			return;
		}
		int x = dependencies.get("x");
		int y = dependencies.get("y");
		int z = dependencies.get("z");
		print (x,y,z);
		
		entity.setPositionAndUpdate(x, y, z);
	}
}
