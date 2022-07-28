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

package com.tamrielnetwork.vitalskull.files;

import com.tamrielnetwork.vitalskull.VitalSkull;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Messages {

	private final VitalSkull main = JavaPlugin.getPlugin(VitalSkull.class);
	private final File messagesFile;
	private final FileConfiguration messagesConf;

	public Messages() {
		messagesFile = new File(main.getDataFolder(), "messages.yml");
		saveMessagesFile();
		messagesConf = YamlConfiguration.loadConfiguration(messagesFile);
	}

	private void saveMessagesFile() {
		if (!messagesFile.exists()) {
			main.saveResource("messages.yml", false);
		}
	}

	public FileConfiguration getMessagesConf() {
		return messagesConf;
	}
}
