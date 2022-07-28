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
 * along with this program. If not, see https://github.com/LeoMeinel/VitalSkull/blob/main/LICENSE
 */

package com.tamrielnetwork.vitalskull;

import com.tamrielnetwork.vitalskull.commands.VitalSkullCmd;
import com.tamrielnetwork.vitalskull.files.Messages;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class VitalSkull
		extends JavaPlugin {

	private Messages messages;

	@Override
	public void onEnable() {
		Objects.requireNonNull(getCommand("skull"))
		       .setExecutor(new VitalSkullCmd());
		saveDefaultConfig();
		messages = new Messages();
		Bukkit.getLogger()
		      .info("VitalSkull v" + this.getDescription()
		                                 .getVersion() + " enabled");
		Bukkit.getLogger()
		      .info("Copyright (C) 2022 Leopold Meinel");
		Bukkit.getLogger()
		      .info("This program comes with ABSOLUTELY NO WARRANTY!");
		Bukkit.getLogger()
		      .info("This is free software, and you are welcome to redistribute it under certain conditions.");
		Bukkit.getLogger()
		      .info("See https://github.com/LeoMeinel/VitalSkull/blob/main/LICENSE for more details.");
	}

	@Override
	public void onDisable() {
		Bukkit.getLogger()
		      .info("VitalSkull v" + this.getDescription()
		                                 .getVersion() + " disabled");
	}

	public Messages getMessages() {
		return messages;
	}
}

