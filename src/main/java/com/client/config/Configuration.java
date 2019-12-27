package com.client.config;

public class Configuration {
	
	public static boolean newFonts = false;

	/**
	 * Attack option priorities 0 -> Depends on combat level 1 -> Always right-click
	 * 2 -> Left-click where available 3 -> Hidden
	 */
	public static int playerAttackOptionPriority = 0;
	public static int npcAttackOptionPriority = 2;

	public static boolean debug = true;
	public static final boolean DUMP_SPRITES = false;

	public static int xpSize = 0;
	public static int xpSpeed = 0;
	public static int xpDuration = 0;
	public static int xpColour = 0;
	public static int xpGroup = 0;
	
	public static boolean renderLoginScene = true;
	public static final int LOGIN_SCREEN_WORLD_X = 3050;
	public static final int LOGIN_SCREEN_WORLD_Y = 9950;

	public static boolean enableSmoothShading = true;
	public static boolean enableTileBlending = true;
	public static boolean enableAntiAliasing = false;
	public static boolean enableFogRendering = false;
    public static boolean enableRainbowFog = false;
	public static boolean bountyHunter = true;
	public static boolean playerNames = false;
	public static boolean staffIcons = true;
	public static int chatColor = 0;
    public static int fogColor = 0xDCDBDF;
	public static long fogDelay = 500;
	public static final String CLIENT_TITLE = "Eldrax";
	public static final int CLIENT_VERSION = 5;
    public static Boolean LIVE_SERVER = true;
    public static String IP = "0.0.0.0"; //107.167.88.138
	public static final int PORT = 43594;
	
	public static final boolean THREADED_RENDERING = false;

	public static Boolean DUMP_DATA = false;
	public static int dumpID = 181;
	public static Boolean DUMP_OTHER = false;
	
	//The one in libs is unobfuscated, the one in deploy is obfuscated alright so i just run the jar in gradle tasks (do i have to clean it each time before?) No need to clean every time but if you run into any issues, try leaning and jarring alright awesome , thanks man :)

	/**
	 * Used to repack indexes Index 1 = Models Index 2 = Animations Index 3 =
	 * Sounds/Music Index 4 = Maps You can only do up to 300 files at a time
	 */
	public static boolean 
			repackIndexOne = false, 
			repackIndexTwo = false, 
			repackIndexThree = false,
			repackIndexFour = false, 
			repackIndexFive = false;
			

	public static final String CACHE_NAME = "Eldrax";

	public static final String CACHELINK = "https://www.dropbox.com/s/9qvpjhlqyn466g2/Eldrax.zip?dl=1"; //  cache link

    
    public static int CACHE_VERSION_LOADER = 2;
    
    /*
     * Discord Rich Presence Settings
     */
    public static String AppId = "463996796511715340";
    public static String line1 = "#1 osrs economy server";
    public static String line2 = "www.eldrax-ps.com";
    public static String image = "";
	
	/**
	 * Seasonal Events
	 */
	public static boolean HALLOWEEN = false;
	public static boolean CHRISTMAS = false;
	public static boolean CHRISTMAS_EVENT = false;
	public static boolean EASTER = false;

	public static boolean osbuddyGameframe = false;

	public static boolean oldGameframe = false;
	public static int gameWorld = 1;

	public static int xpPosition;
	public static boolean escapeCloseInterface = false;
	public static boolean inventoryContextMenu = true;
	public static int statMenuColor = 0xBABABA;
	public static boolean alwaysLeftClickAttack;
	public static boolean hideCombatOverlay;
	
	public static boolean displayEntityOverlaySpriteText = true;
	public static boolean displayObjectOverlaySpriteText = true;

	public static boolean enableTweening = true;

}
