package draylar.goml;

import draylar.goml.cca.ClaimComponent;
import draylar.goml.cca.WorldClaimComponent;
import draylar.goml.command.ClaimCommand;
import draylar.goml.registry.Blocks;
import draylar.goml.registry.Items;
import nerdhub.cardinal.components.api.ComponentRegistry;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.event.WorldComponentCallback;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class GetOffMyLawn implements ModInitializer {

	public static final ComponentType<ClaimComponent> CLAIM = ComponentRegistry.INSTANCE.registerIfAbsent(
			id("claims"),
			ClaimComponent.class
	).attach(WorldComponentCallback.EVENT, WorldClaimComponent::new);

	public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(Items.GOGGLES));

	@Override
	public void onInitialize() {
		Blocks.init();
		Items.init();
		EventHandlers.init();
		ClaimCommand.init();
	}

	public static Identifier id(String name) {
		return new Identifier("goml", name);
	}
}
