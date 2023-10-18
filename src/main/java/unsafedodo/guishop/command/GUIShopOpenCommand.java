package unsafedodo.guishop.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import unsafedodo.guishop.gui.PagedShopGUI;
import unsafedodo.guishop.gui.ShopGUI;

import unsafedodo.guishop.gui.ShopListGUI;
import unsafedodo.guishop.shop.Shop;
import unsafedodo.guishop.util.CommonMethods;

public class GUIShopOpenCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment){
        dispatcher.register(CommandManager.literal("guishop")
                .then(CommandManager.literal("open")
                    .executes(GUIShopOpenCommand::run)));
        // dispatcher.register(CommandManager.literal("guishop")
        //         .then(CommandManager.literal("open")
        //             .executes(GUIShopOpenCommand::run)));
    }

    public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ShopListGUI shopListGUI = new ShopListGUI(context.getSource().getPlayer());
        shopListGUI.open();

        return 0;
        // if(selectedShop != null){
        //     if(selectedShop.getItems().size() > 0){
        //         if(selectedShop.getItems().size() <= PagedShopGUI.MAX_PAGE_ITEMS){
        //             ShopGUI shopGUI = new ShopGUI(EntityArgumentType.getPlayer(context, "playerName"), selectedShop);
        //             shopGUI.open();
        //         } else {
        //             PagedShopGUI pagedShopGUI = new PagedShopGUI(EntityArgumentType.getPlayer(context, "playerName"), selectedShop);
        //             pagedShopGUI.open();
        //         }
        //     }else{
        //         context.getSource().sendFeedback(()->Text.literal("The shop does not contain any items").formatted(Formatting.RED), false);
        //         return -1;
        //     }

        // }else
        //     context.getSource().sendFeedback(()-> Text.literal("Shop not found").formatted(Formatting.RED), false);
        // return 0;
    }
}
