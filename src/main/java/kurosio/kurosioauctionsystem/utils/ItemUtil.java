package kurosio.kurosioauctionsystem.utils;

import net.azisaba.itemstash.ItemStash;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class ItemUtil {

    public static void giveItemOrStash(Player player, ItemStack item) {
        Map<Integer, ItemStack> leftOver = player.getInventory().addItem(item);

        for (ItemStack left : leftOver.values()) {
            if (Bukkit.getPluginManager().isPluginEnabled("ItemStash")) {
                try {
                    ItemStash.getInstance().addItemToStash(player.getUniqueId(), left);
                    player.sendMessage("§eインベントリがいっぱいのため、アイテムがStashに送られました！");
                    continue;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            player.getWorld().dropItemNaturally(player.getLocation(), left);
            player.sendMessage("§cインベントリがいっぱいのため、アイテムが足元にドロップしました。");
        }
    }
}
