/*
 * File: CmdSpec.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2022 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitalskull.utils.commands;

import dev.meinel.leo.vitalskull.VitalSkull;
import dev.meinel.leo.vitalskull.utils.Chat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class CmdSpec {

  private static final VitalSkull main = JavaPlugin.getPlugin(VitalSkull.class);
  private static final HashMap<UUID, Long> cooldownMap = new HashMap<>();

  private CmdSpec() {
    throw new IllegalStateException("Utility class");
  }

  public static ItemStack getHeadItem(@NotNull Player player) {
    ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
    SkullMeta metaHead = (SkullMeta) playerHead.getItemMeta();
    metaHead.setOwningPlayer(player);
    playerHead.setItemMeta(metaHead);
    return playerHead;
  }

  public static boolean isInvalidCmd(
      @NotNull CommandSender sender,
      @NotNull String perm) {
    return (Cmd.isInvalidSender(sender) ||
        Cmd.isNotPermitted(sender, perm) ||
        isOnCooldown(sender));
  }

  public static boolean hasFreeInventorySlot(@NotNull Player player) {
    return (player.getInventory().firstEmpty() != -1 ||
        (Objects.requireNonNull(player.getActiveItem()).getAmount() > 1));
  }

  private static void clearMap(@NotNull CommandSender sender) {
    Player senderPlayer = (Player) sender;
    cooldownMap.remove(senderPlayer.getUniqueId());
  }

  private static void doTiming(@NotNull CommandSender sender) {
    new BukkitRunnable() {
      @Override
      public void run() {
        clearMap(sender);
      }
    }
        .runTaskLaterAsynchronously(
            main,
            (main.getConfig().getLong("cooldown.time") * 20L));
  }

  private static boolean isOnCooldown(@NotNull CommandSender sender) {
    Player senderPlayer = (Player) sender;
    boolean isOnCooldown = main.getConfig().getBoolean("cooldown.enabled") &&
        !sender.hasPermission("vitalskull.cooldown.bypass") &&
        cooldownMap.containsKey(senderPlayer.getUniqueId());
    if (isOnCooldown) {
      String timeRemaining = String.valueOf(
          cooldownMap.get(senderPlayer.getUniqueId()) -
              System.currentTimeMillis() /
                  1000);
      Chat.sendMessage(
          sender,
          Map.of("%time-left%", timeRemaining),
          "cooldown-active");
      return true;
    }
    cooldownMap.put(
        senderPlayer.getUniqueId(),
        main.getConfig().getLong("cooldown.time") +
            System.currentTimeMillis() /
                1000);
    doTiming(sender);
    return false;
  }
}
