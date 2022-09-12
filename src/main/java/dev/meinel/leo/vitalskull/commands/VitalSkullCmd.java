/*
 * File: VitalSkullCmd.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2022 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitalskull.commands;

import dev.meinel.leo.vitalskull.utils.commands.Cmd;
import dev.meinel.leo.vitalskull.utils.commands.CmdSpec;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class VitalSkullCmd implements CommandExecutor {

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args) {
        if (Cmd.isArgsLengthNotEqualTo(sender, args, 0)) {
            return false;
        }
        doOwnSkull(sender);
        return true;
    }

    private void doOwnSkull(@NotNull CommandSender sender) {
        if (CmdSpec.isInvalidCmd(sender, "vitalskull.skull")) {
            return;
        }
        Player senderPlayer = (Player) sender;
        Inventory senderInventory = senderPlayer.getInventory();
        ItemStack playerHead = CmdSpec.getHeadItem(senderPlayer);
        if (!(CmdSpec.hasFreeInventorySlot(senderPlayer))) {
            return;
        }
        senderInventory.addItem(playerHead);
    }
}
