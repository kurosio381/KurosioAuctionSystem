package kurosio.kurosioauctionsystem.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class AuctionQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        // 出品者がログアウトしてもオークションは継続するため、ここでは何もしません
    }
}