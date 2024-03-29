/*
 * File: Chat.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2023 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitalskull.utils;

import dev.meinel.leo.vitalskull.VitalSkull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Chat {

    private static final VitalSkull main = JavaPlugin.getPlugin(VitalSkull.class);

    private Chat() {
        throw new IllegalStateException("Utility class");
    }

    public static void sendMessage(@NotNull CommandSender player,
            @NotNull Map<String, String> placeholders, @NotNull String message) {
        List<String> messages = getMessages(message);
        for (String string : messages) {
            for (Map.Entry<String, String> entry : placeholders.entrySet()) {
                if (string.contains(entry.getKey())) {
                    string = string.replace(entry.getKey(), entry.getValue());
                }
            }
            player.sendMessage(replaceColors(string));
        }
    }

    public static void sendMessage(@NotNull CommandSender player, @NotNull String message) {
        player.sendMessage(replaceColors(
                Objects.requireNonNull(main.getMessages().getMessagesConf().getString(message))));
    }

    private static List<String> getMessages(@NotNull String message) {
        List<String> messages;
        if (main.getMessages().getMessagesConf().isList(message)) {
            messages = Objects
                    .requireNonNull(main.getMessages().getMessagesConf().getStringList(message));
        } else {
            messages = new ArrayList<>();
            messages.add(main.getMessages().getMessagesConf().getString(message));
        }
        return messages;
    }

    // FIXME: Replace deprecated org.bukkit.ChatColor with alternative
    public static String replaceColors(@NotNull String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
