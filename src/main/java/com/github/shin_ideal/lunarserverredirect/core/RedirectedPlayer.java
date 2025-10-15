package com.github.shin_ideal.lunarserverredirect.core;

import java.util.UUID;

public abstract class RedirectedPlayer {

    private final UUID uuid;

    public RedirectedPlayer(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public abstract String getName();

    public abstract void sendMessage(String message);
}
