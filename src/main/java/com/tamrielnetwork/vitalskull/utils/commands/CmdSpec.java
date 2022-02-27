/*
 * VitalSkull is a Spigot Plugin that gives players the ability to get their own skull.
 * Copyright © 2022 Leopold Meinel
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

package com.tamrielnetwork.vitalskull.utils.commands;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CmdSpec {

	public static ItemStack getHeadItem(@NotNull Player player) {

		ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
		SkullMeta metaHead = (SkullMeta) playerHead.getItemMeta();
		metaHead.setOwningPlayer(player);
		playerHead.setItemMeta(metaHead);
		return playerHead;
	}

	public static boolean hasFreeInventorySlot(@NotNull Player player) {

		return player.getInventory().firstEmpty() != -1 || (Objects.requireNonNull(player.getActiveItem()).getAmount() > 1);
	}

	public static boolean isInvalidCmd(@NotNull CommandSender sender, @NotNull String perm) {

		if (Cmd.isInvalidSender(sender)) {
			return true;
		}
		return Cmd.isNotPermitted(sender, perm);
	}

}
