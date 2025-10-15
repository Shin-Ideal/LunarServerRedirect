package com.github.shin_ideal.lunarserverredirect.core.utils;

import com.github.shin_ideal.lunarserverredirect.core.RedirectedPlayer;
import com.lunarclient.apollo.Apollo;
import com.lunarclient.apollo.module.transfer.TransferModule;
import com.lunarclient.apollo.player.ApolloPlayer;

import java.util.Optional;

public class LunarTransferUtil {

    public static void transfer(RedirectedPlayer player, String address) {
        Optional<ApolloPlayer> apolloPlayer = Apollo.getPlayerManager().getPlayer(player.getUuid());

        if (!apolloPlayer.isPresent()) {
            player.sendMessage("Join with Lunar Client to test this feature!");
            return;
        }

        TransferModule transferModule = Apollo.getModuleManager().getModule(TransferModule.class);
        transferModule.transfer(apolloPlayer.get(), address);
    }
}
