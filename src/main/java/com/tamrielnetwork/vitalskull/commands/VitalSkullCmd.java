/*
 * VitalSkull is a Spigot Plugin that gives players the ability to get their own skull.
 * Copyright © 2022 Leopold Meinel & contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see https://github.com/TamrielNetwork/VitalSkull/blob/main/LICENSE
 */

package com.tamrielnetwork.vitalskull.commands;

import com.tamrielnetwork.vitalskull.utils.commands.Cmd;
import com.tamrielnetwork.vitalskull.utils.commands.CmdSpec;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class VitalSkullCmd implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

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