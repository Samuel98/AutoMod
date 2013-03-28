package uk.co.jacekk.bukkit.automod;

import java.util.Arrays;

import uk.co.jacekk.bukkit.baseplugin.v9_1.config.PluginConfigKey;

public class Config {
	
	public static final PluginConfigKey IGNORE_WORLDS			= new PluginConfigKey("ignore-worlds", Arrays.asList("world_nether", "world_the_end"));
	public static final PluginConfigKey BUILD_REMOVED_COMMANDS	= new PluginConfigKey("build-removed-commands", Arrays.asList());
	
}
