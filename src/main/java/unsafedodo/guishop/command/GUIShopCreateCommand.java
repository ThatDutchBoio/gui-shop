package unsafedodo.guishop.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import unsafedodo.guishop.GUIShop;
import unsafedodo.guishop.shop.Shop;
import java.util.LinkedList;

public class GUIShopCreateCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment){
        dispatcher.register(CommandManager.literal("guishop")
                .then(CommandManager.literal("create")
                    .requires(Permissions.require("guishop.create", 3))
                        .then(CommandManager.argument("shopName", StringArgumentType.string())
                            .then(CommandManager.argument("shopIcon", StringArgumentType.string()))
                                .executes(GUIShopCreateCommand::run))));
    }

    public static int run(CommandContext<ServerCommandSource> context){
        GUIShop.shops.addLast(new Shop(StringArgumentType.getString(context, "shopName"), new LinkedList<>(),  StringArgumentType.getString(context, "shopIcon")));
        context.getSource().sendFeedback(()-> Text.literal("Shop successfully created!").formatted(Formatting.GREEN), false);
        return 0;
    }
}
