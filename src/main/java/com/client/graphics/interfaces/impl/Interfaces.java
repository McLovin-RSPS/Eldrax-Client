package com.client.graphics.interfaces.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.client.Client;
import com.client.cache.graphics.Sprite;
import com.client.cache.graphics.font.TextDrawingArea;
import com.client.features.gameframe.ScreenMode;
import com.client.graphics.interfaces.RSInterface;
import com.client.utilities.ReflectionUtil;

public class Interfaces extends RSInterface {

	public static void loadInterfaces() {
		wrathRune();
		GrandExchange.initializeInterfaces(defaultTextDrawingAreas);
		settingsInterface(defaultTextDrawingAreas);
		GoldenScratchCardNew(defaultTextDrawingAreas);
		pointCounter(defaultTextDrawingAreas);
		mysteryBox(defaultTextDrawingAreas);
		shopWidget(defaultTextDrawingAreas);
		upgradeItems(defaultTextDrawingAreas);
		barrowsReward(defaultTextDrawingAreas);
		keybinding(defaultTextDrawingAreas);
		ancients(defaultTextDrawingAreas);
		runecraftingTable(defaultTextDrawingAreas);
		questTab(defaultTextDrawingAreas);
		caelTournamentSupplies(defaultTextDrawingAreas);
		infoTab(defaultTextDrawingAreas);
		safeBox(defaultTextDrawingAreas);
		helpDatabaseComponent(defaultTextDrawingAreas);
		helpComponent(defaultTextDrawingAreas);
		groundItemCustomizing(defaultTextDrawingAreas);
		staffInterface(defaultTextDrawingAreas);
		staffInterfaceBank(defaultTextDrawingAreas);
		teleportationInterface(defaultTextDrawingAreas);
		bank(defaultTextDrawingAreas);
		bankPin(defaultTextDrawingAreas);
		slayerInterface(defaultTextDrawingAreas);
		slayerInterfaceSub1(defaultTextDrawingAreas);
		slayerInterfaceSub2(defaultTextDrawingAreas);
		PVPInterface3(defaultTextDrawingAreas);
		PVPInterface(defaultTextDrawingAreas);
		PVPInterface2(defaultTextDrawingAreas);
		PVPInterface3(defaultTextDrawingAreas);
		clanChatTab(defaultTextDrawingAreas);
		clanChatSetup(defaultTextDrawingAreas);
		itemsKeptOnDeath(defaultTextDrawingAreas);
		SettingsWidget.widget(defaultTextDrawingAreas);
		emoteTab();
		bountyHunterWidget(defaultTextDrawingAreas);
		godWars(defaultTextDrawingAreas);
		spawnTab(defaultTextDrawingAreas);
		prayerBook(defaultTextDrawingAreas);
		equipmentScreen(defaultTextDrawingAreas);
		equipmentTab(defaultTextDrawingAreas);
		itemsOnDeathDATA(defaultTextDrawingAreas);
		itemsOnDeath(defaultTextDrawingAreas);
		Pestpanel(defaultTextDrawingAreas);
		Pestpanel2(defaultTextDrawingAreas);
		configureLunar(defaultTextDrawingAreas);
		achievements(defaultTextDrawingAreas);
		updateShopWidget(defaultTextDrawingAreas);
		teleportation(defaultTextDrawingAreas);
		preloadEquipmentWidget(defaultTextDrawingAreas);
		initializeTitleWidget(defaultTextDrawingAreas);
		initializeCommandHelp();
		addPestControlRewardWidget(defaultTextDrawingAreas);
		addModerateWidget(defaultTextDrawingAreas);
		addAntibotWidget(defaultTextDrawingAreas);
		ironmanWidget(defaultTextDrawingAreas);
		addGodwarsWidget(defaultTextDrawingAreas);
		barrowsKillcount(defaultTextDrawingAreas);
		lootingBag(defaultTextDrawingAreas);
		lootingBagAdd(defaultTextDrawingAreas);
		runePouch(defaultTextDrawingAreas);
		quickPrayers(defaultTextDrawingAreas);
		wellOfGoodWill(defaultTextDrawingAreas);
		listings(defaultTextDrawingAreas);
		tradingpost(defaultTextDrawingAreas);
		tradingSelect(defaultTextDrawingAreas);
		offer(defaultTextDrawingAreas);
		tradingSelected(defaultTextDrawingAreas);
		skotizo(defaultTextDrawingAreas);
		slayerOverlay(defaultTextDrawingAreas);
		prestigeInterface(defaultTextDrawingAreas);
		expLock(defaultTextDrawingAreas);
		addStaffSpecialWidget();
		skillTabWithHovers(defaultTextDrawingAreas);
		normals(defaultTextDrawingAreas);
		//statsComparatorInterface(defaultTextDrawingAreas);
		gambleInterface(defaultTextDrawingAreas);
		HitOrStay(defaultTextDrawingAreas);
		treasureHunter(defaultTextDrawingAreas);
	}
	
	
	 public static void treasureHunter(TextDrawingArea[] tda)
	  {
	    RSInterface iface = addInterface(47300);
	    addSprite(47301, 1073, "Interfaces/TreasureHunter/SPRITE");
	    addText(47302, "Treasure hunter", tda, 2, 16753920, true, true);
	    addButton(47003, 1015, "Interfaces/MysteryBox2/SPRITE", "Close");
	    addButton(47306, 2, "Interfaces/TreasureHunter/SPRITE", "Choose chest");
	    addButton(47307, 0, "Interfaces/TreasureHunter/SPRITE", "Buy keys");
	    addText(47308, "Keys: 0", tda, 1, 16753920, false, true);
	    addText(47309, "Receive a daily key or buy keys instead!", tda, 0, 16753920, true, true);
	    addSprite(47010, 528, "Interfaces/MysteryBox2/SPRITE");
	    addSprite(47011, 533, "Interfaces/MysteryBox2/SPRITE");
	    

	    setChildren(13, iface);
	    setBounds(47301, 11, 31, 0, iface);
	    setBounds(47302, 254, 40, 1, iface);
	    setBounds(47003, 483, 40, 2, iface);
	    setBounds(47306, 21, 118, 3, iface);
	    setBounds(47307, 208, 133, 4, iface);
	    setBounds(47308, 20, 39, 5, iface);
	    setBounds(47309, 254, 277, 6, iface);
	    
	    setBounds(47200, 11, 69, 7, iface);
	    
	    setBounds(47100, 18, 74, 8, iface);
	    
	    setBounds(47010, 253, 69, 9, iface);
	    setBounds(47011, 11, 67, 10, iface);
	    setBounds(47306, 174, 176, 11, iface);
	    setBounds(47306, 335, 118, 12, iface);
	    

	    RSInterface box = addInterface(47200);
	    box.width = 486;
	    setChildren(28, box);
	    
	    int x = 0;
	    for (int i = 0; i < 28; i++)
	    {
	      addSprite(47201, 532, "Interfaces/MysteryBox2/SPRITE");
	      
	      setBounds(47201, 0 + x, 0, i, box);
	      x += 2880;
	    }
	    RSInterface scroll = addInterface(47100);
	    scroll.width = 486;
	    addToItemGroup(47101, 1750, 1, 13, 10, false, null, null, null);
	    setChildren(1, scroll);
	    setBounds(47101, 0, 0, 0, scroll);
	  }

	public static void HitOrStay(TextDrawingArea[] tda) {
		String dir = "Interfaces/Gamble/SPRITE";
		int index = 28392;
		RSInterface main = addTabInterface(index);
		int frame = 0;

		setChildren(4, main);
		index++;

		newHoverButton(index, "Stay", 1, 2, dir);
		setBounds(index, 115, 275, frame, main);
		frame++;
		index++;

		newHoverButton(index, "Hit", 1, 2, dir);
		setBounds(index, 275, 275, frame, main);
		frame++;
		index++;

		addText(index, "Stay", tda, 1, 0xff0000);
		setBounds(index, 135, 280, frame, main);
		index++;
		frame++;

		addText(index, "Hit", tda, 1, 0x008000);
		setBounds(index, 301, 280, frame, main);
	}

	public static void gambleInterface(TextDrawingArea[] tda) {

		String dir = "Interfaces/Gamble/SPRITE";

		int id = 30891;
		int parentId = 30891;

		int frame = 0;

		RSInterface tab = addTabInterface(id);
		setChildren(29, tab);
		id++;

		addSprite(id, 0, dir);

		setBounds(id, 9, 10, frame, tab);
		frame++;
		id++;

		addConfigButton(id, parentId, 1, 2, dir, 68, 25, "", 1, 0, 444);
		setBounds(id, 191, 89, frame, tab);
		frame++;
		id++;

		addConfigButton(id, parentId, 1, 2, dir, 68, 25, "", 2, 0, 444);
		setBounds(id, 259, 89, frame, tab);
		frame++;
		id++;

		addConfigButton(id, parentId, 1, 2, dir, 68, 25, "", 3, 0, 444);
		setBounds(id, 191, 114, frame, tab);
		frame++;
		id++;

		addConfigButton(id, parentId, 1, 2, dir, 68, 25, "", 4, 0, 444);
		setBounds(id, 259, 114, frame, tab);
		frame++;
		id++;

		addConfigButton(id, parentId, 1, 2, dir, 68, 25, "", 5, 0, 444);
		setBounds(id, 191, 139, frame, tab);
		frame++;
		id++;

		addConfigButton(id, parentId, 1, 2, dir, 68, 25, "", 6, 0, 444);
		setBounds(id, 259, 139, frame, tab);
		frame++;
		id++;

		addConfigButton(id, parentId, 1, 2, dir, 68, 25, "", 7, 0, 444);
		setBounds(id, 191, 164, frame, tab);
		frame++;
		id++;

		addConfigButton(id, parentId, 1, 2, dir, 68, 25, "", 8, 0, 444);
		setBounds(id, 259, 164, frame, tab);
		frame++;
		id++;

		addTextButton(id, "55x2", "55x2", 16750623, 0xFFFFFF, true, true, tda, 0, 68, 25, 0, 6);
		setBounds(id, 191, 89, frame, tab);
		frame++;
		id++;

		addTextButton(id, "Flower Poker", "Flower Poker", 16750623, 0xFFFFFF, true, true, tda, 0, 68, 25, 0, 6);
		setBounds(id, 259, 89, frame, tab);
		frame++;
		id++;

		addTextButton(id, "Dice Duel", "Dice Duel", 16750623, 0xFFFFFF, true, true, tda, 0, 68, 25, 0, 6);
		setBounds(id, 191, 114, frame, tab);
		frame++;
		id++;

		addTextButton(id, "Black Jack", "Black Jack", 16750623, 0xFFFFFF, true, true, tda, 0, 68, 25, 0, 6);
		setBounds(id, 259, 114, frame, tab);
		frame++;
		id++;

		addTextButton(id, "Frosty Flower", "Frosty Flower", 16750623, 0xFFFFFF, true, true, tda, 0, 68, 25, 0, 6);
		setBounds(id, 191, 139, frame, tab);
		frame++;
		id++;

		addTextButton(id, "ABC Flower", "ABC Flower", 16750623, 0xFFFFFF, true, true, tda, 0, 68, 25, 0, 6);
		setBounds(id, 259, 139, frame, tab);
		frame++;
		id++;

		addTextButton(id, "Hot or Cold", "Hot or Cold", 16750623, 0xFFFFFF, true, true, tda, 0, 68, 25, 0, 6);
		setBounds(id, 191, 164, frame, tab);
		frame++;
		id++;

		addTextButton(id, "Random Game", "Random Game", 16750623, 0xFFFFFF, true, true, tda, 0, 68, 25, 0, 6);
		setBounds(id, 259, 164, frame, tab);
		frame++;
		id++;

		addText(id, id + "\\nHit and stand in this\\ngame trying to stay below\\n100 but having a number\\nthat is larger than your\\nopponents.", tda, 0, 16750623, true, true);
		setBounds(id, 255, 210, frame, tab);
		frame++;
		id++;

		addText(id, "Gambling Against:\\n" + id, tda, 0, 16750623, true, true);
		setBounds(id, 422, 283, frame, tab);
		frame++;
		id++;

		newHoverButton(id, "Decline", 1, 2, dir);
		setBounds(id, 191, 279, frame, tab);
		frame++;
		id++;

		newHoverButton(id, "Accept", 1, 2, dir);
		setBounds(id, 259, 279, frame, tab);
		frame++;
		id++;

		addText(id, "Decline", tda, 0, 0xff0000, true, true);
		setBounds(id, 225, 285, frame, tab);
		frame++;
		id++;

		addText(id, "Accept", tda, 0, 0x008000, true, true);
		setBounds(id, 293, 285, frame, tab);
		frame++;
		id++;

		addText(id, "Your Offer", tda, 2, 16750623, true, true);
		setBounds(id, 92, 62, frame, tab);
		frame++;
		id++;

		addText(id, "Choose a gamemode", tda, 2, 16750623, true, true);
		setBounds(id, 259, 62, frame, tab);
		frame++;
		id++;

		addText(id, "Opponents Offer", tda, 2, 16750623, true, true);
		setBounds(id, 425, 62, frame, tab);
		frame++;
		id++;

		RSInterface your_container = addTabInterface(id);
		setBounds(id, 25, 89, frame, tab);
		frame++;
		id++;

		RSInterface other_container = addTabInterface(id);
		setBounds(id, 357, 89, frame, tab);
		frame++;
		id++;

		int your_id = id;
		id += 10;
		addToItemGroup(your_id, 3, 10, 10, 10, false, null, null, null);
		interfaceCache[your_id].actions = new String[] { "Remove 1", "Remove 5", "Remove 10", "Remove All", "Remove X" };
		your_container.width = 120;
		your_container.height = 217;
		your_container.scrollMax = 1000;

		setChildren(1, your_container);
		setBounds(your_id, 0, 0, 0, your_container);

		int other_id = id;
		addToItemGroup(other_id, 3, 10, 10, 10, false, null, null, null);
		interfaceCache[other_id].actions = new String[] { "Remove 1", "Remove 5", "Remove 10", "Remove All", "Remove X" };
		id += 10;
		other_container.width = 120;
		other_container.height = 194;
		other_container.scrollMax = 1000;

		setChildren(1, other_container);
		setBounds(other_id, 0, 0, 0, other_container);

		addText(id, "Waiting for other player\\nto accept." + id, tda, 0, 16750623, true, true);
		setBounds(id, 255, 190, frame, tab);
		frame++;
		id++;

	}
	
	public static void printItf(int parentId, boolean recursive) {
		PrintStream ps = System.out;
		try {
			System.setOut(new PrintStream(new FileOutputStream("F:/rsi.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int childId : RSInterface.interfaceCache[parentId].children) {
			if(recursive && RSInterface.interfaceCache[childId].children != null) {
				ReflectionUtil.printValues(RSInterface.interfaceCache[childId]);
				System.out.println("CHILD ->");
				for(int childId2 : RSInterface.interfaceCache[childId].children) {
					ReflectionUtil.printValues(RSInterface.interfaceCache[childId2]);

					System.out.println("CHILD END");
				}
			} else {
				ReflectionUtil.printValues(RSInterface.interfaceCache[childId]);
			}
		}
		System.setOut(ps);
	}
	

    public static void runecraftingTable(TextDrawingArea[] tda) {
        RSInterface Interface = addInterface(27000); // Interface ID
        // Background here
        addSprite(27001, 1, "Random/runecraftingTable/BACKGROUND");

        // Buttons Begin
        addHoverButton(27002, "Random/runecraftingTable/SPRITE", 1, 82, 76, "Teleport to @gre@Air Altar", -1, 27002, 1);
        addHoverButton(27003, "Random/runecraftingTable/SPRITE", 1, 82, 76, "Teleport to @gre@Mind Altar", -1, 27003, 1);
        addHoverButton(27004, "Random/runecraftingTable/SPRITE", 1, 82, 76, "Teleport to @gre@Water Altar", -1, 27004, 1);
        addHoverButton(27005, "Random/runecraftingTable/SPRITE", 1, 82, 76, "Teleport to @gre@Earth Altar", -1, 27005, 1);
        addHoverButton(27006, "Random/runecraftingTable/SPRITE", 1, 82, 76, "Teleport to @gre@Fire Altar", -1, 27006, 1);
        addHoverButton(27007, "Random/runecraftingTable/SPRITE", 1, 82, 76, "Teleport to @gre@Cosmic Altar", -1, 27007, 1);
        addHoverButton(27008, "Random/runecraftingTable/SPRITE", 1, 82, 76, "Teleport to @gre@Chaos Altar", -1, 27008, 1);
        addHoverButton(27009, "Random/runecraftingTable/SPRITE", 1, 82, 76, "Teleport to @gre@Astral Altar", -1, 27009, 1);
        addHoverButton(27010, "Random/runecraftingTable/SPRITE", 1, 82, 76, "Teleport to @gre@Nature Altar", -1, 27010, 1);
        addHoverButton(27011, "Random/runecraftingTable/SPRITE", 1, 82, 76, "Teleport to @gre@Law Altar", -1, 27011, 1);
        addHoverButton(27012, "Random/runecraftingTable/SPRITE", 1, 82, 76, "Teleport to @gre@Death Altar", -1, 27012, 1);
        addHoverButton(27013, "Random/runecraftingTable/SPRITE", 1, 82, 76, "Teleport to @gre@Blood Altar", -1, 27013, 1);
        addHoverButton(27014, "Random/runecraftingTable/CLOSE", 1, 25, 25, "Close", -1, 27014, 1);
        setChildren(14, Interface); // Number of Sprites/buttons
        setBounds(27001, 7, 6, 0, Interface);
        setBounds(27002, 45, 61, 1, Interface); // 105122 - Action Button IDs
        setBounds(27003, 155, 61, 2, Interface); // 105123
        setBounds(27004, 265, 61, 3, Interface); // 105124
        setBounds(27005, 388, 61, 4, Interface); // 105125
        setBounds(27006, 40, 145, 5, Interface); // 105126
        setBounds(27007, 158, 145, 6, Interface);// 105127
        setBounds(27008, 266, 145, 7, Interface); // 105128
        setBounds(27009, 385, 145, 8, Interface); // 105129
        setBounds(27010, 38, 227, 9, Interface);// 105130
        setBounds(27011, 158, 227, 10, Interface); // 105131
        setBounds(27012, 265, 227, 11, Interface); // 105132
        setBounds(27013, 385, 227, 12, Interface);// 105133
        setBounds(27014, 477, 10, 13, Interface); // 105134
        // Set Bounds End
    }
	
	public static void mysteryBox(TextDrawingArea[] tda) {
		RSInterface iface = addInterface(47000);
		/* Base interface */
		//addSpriteLoader(47001, 1073);
		addSprite(47001, 1073, "interfaces/mysterybox/sprite");
		//addSprite(65001, 0, "interfaces/Teleporting/Background");
		addText(47002, "Mystery Box", tda, 2, 0xFFA500, true, true);
		addButton(47003, 527, "interfaces/mysterybox/sprite", "Close");
		addButton(47004, 810, "interfaces/mysterybox/sprite", "Spin!");
		addText(47005, "@gre@Spin!", tda, 2, 0xFFA500, true, true);
		addSprite(47006, 530, "interfaces/mysterybox/sprite");
		addSprite(47007, 531, "interfaces/mysterybox/sprite");
		addText(47008, "Feeling lucky?", tda, 2, 0xFFA500, true, true);
		addText(47009, "Sacrifice your box for a chance at something rare!", tda, 1, 0xFFA500, true, true);
		addSprite(47010, 528, "interfaces/mysterybox/sprite");
		addSprite(47011, 533, "interfaces/mysterybox/sprite");


		setChildren(13, iface);
		setBounds(47001, 10, 10, 0, iface);
		setBounds(47002, 253, 13, 1, iface);
		setBounds(47003, 473, 14, 2, iface);
		setBounds(47004, 218, 256, 3, iface);
		setBounds(47005, 253, 263, 4, iface);
		setBounds(47006, 17, 185, 5, iface);
		setBounds(47007, 33, 65, 6, iface);
		setBounds(47008, 253, 78, 7, iface);
		setBounds(47009, 253, 108, 8, iface);
		// Boxes
		setBounds(47200, 10, 187, 9, iface);
		// Items
		setBounds(47100, 17, 192, 10, iface);
		// Item selector
		setBounds(47010, 252, 187, 11, iface);
		setBounds(47011, 10, 185, 12, iface);

		/* Boxes */
		RSInterface box = addInterface(47200);
		box.width = 480;
		setChildren(Client.BOXES64, box);
		// 64 boxes in each sprite
		int x = 0;
		for(int i=0; i<Client.BOXES64; i++){
			//addSpriteLoader(47201, 1076);
			addSprite(47201, 532, "interfaces/mysterybox/sprite");
			//addSprite(47201, 0, "");
			setBounds(47201, 0 + x, 0, i, box);
			x += 2880;
		}

		/* Items */
		RSInterface scroll = addInterface(47100);
		scroll.width = 474;
		addToItemGroup(47101, 1750, 1, 13, 10, false, null, null, null);
		setChildren(1, scroll);
		setBounds(47101, 0, 0, 0, scroll);
	}
	private static void caelTournamentSupplies(TextDrawingArea[] tda) {
		RSInterface main = addInterface(55100);

		RSInterface widget = addInterface(55106);

		addSprite(55101, 0, "interfaces/twbase/sprite");

		addHoverButton(55102, "interfaces/twbase/sprite", 1, 16, 16, "Close Window", 0, 55104, 4);
		addHoveredButton(55104, "interfaces/twbase/sprite", 2, 16, 16, 55103);

		addText(55105, "Tournament Supplies", tda, 2, 0xE68A00, true, true);

		addInputField(55120, 50, 0xE68A00, "Search", 132, 23, false, true);

		addToItemGroup(55121, 8, 80, 25, 10, true, "Get 1", "Get 5", "Get 10", "Get 50", "Get 100", "Get X");

		setChildren(6, main);
		main.child(0, 55101, 13, 10);
		main.child(1, 55102, 475, 18);
		main.child(2, 55104, 475, 18);
		main.child(3, 55105, 250, 19);
		main.child(4, 55120, 180, 279);
		main.child(5, 55106, 12, 57);

		setChildren(1, widget);
		widget.child(0, 55121, 12, 12);

		widget.width = 450;

		widget.height = 223;

		widget.scrollMax = 450;
	}
	public static void wrathRune() {
		RSInterface rune = addTabInterface(28226);
		rune.totalChildren(1);
		addSprite(28228, 0, "Magic/wrath");
		setBounds(28228, 0, 0, 0, rune);
	}

	public static void normals(TextDrawingArea[] tda) {
		RSInterface p = addTabInterface(938);
		RSInterface rsinterface = interfaceCache[1151];
		RSInterface rsinterface2 = interfaceCache[12424];
		rsinterface2.height = 250;
		for (int i = 57; i < 58; i++) {
			
			// earth wave
			rsinterface2.childX[36] = 96;
			rsinterface2.childY[36] = 168;
			
			// enfeeble
			rsinterface2.childX[46] = 120;
			rsinterface2.childY[46] = 168;
			
			// teleother lumbridge
			rsinterface2.childX[53] = 144;
			rsinterface2.childY[53] = 168;
			
			// fire wave
			rsinterface2.childX[37] = 1;
			rsinterface2.childY[37] = 192;
			
			// entangle
			rsinterface2.childX[50] = 23;
			rsinterface2.childY[50] = 192;
			
			// stun
			rsinterface2.childX[47] = 47;
			rsinterface2.childY[47] = 193;
			
			// charge
			rsinterface2.childX[41] = 71;
			rsinterface2.childY[41] = 192;
			
			// teleother falador
			rsinterface2.childX[54] = 120;
			rsinterface2.childY[54] = 192;
			
			// teleblock
			rsinterface2.childX[55] = 0;
			rsinterface2.childY[55] = 218;
			
			// lvl-6 enchant
			rsinterface2.childX[57] = 47;
			rsinterface2.childY[57] = 218;
			
			// teleother camelot
			rsinterface2.childX[56] = 71;
			rsinterface2.childY[56] = 218;
		}
		rsinterface.childY[1] = 12;
		rsinterface.childX[1] = 14;
		addSpellSmall2_3(31674 + 975, 563, 566, 555, 554, 2, 2, 4, 5, 30012, 30015, 30004, 30003, 68, "Teleport to Kourend",
				"Teleports you to Kourend", tda, 10, 7, 5);
		addSpellLarge2(13674 + 975, 563, 560, 562, 1, 1, 1, 30012, 30009, 30011, 84, "Teleport to Bounty\\nTarget",
				"Teleports you near your Bounty\\nHunter Target", tda, 8, 7, 5);

		addSpellSmall2(22674 + 975, 565, 566, 564, 20, 20, 1, 30014, 30015, 30013, 92, "Lvl-7 Enchant",
				"For use on zenyte jewellery", tda, 12, 8, 5);
		
		addSpellSmaller(22644 + 975, 556, 21880, 7, 1, 30005, 28226, 80, "Wind Surge",
				"A very high level Air missile", tda, 0, 10, 2);
		
		addSpellSmall(22658 + 975, 555, 556, 21880, 10, 7, 1, 30004, 30005, 28226, 84, "Water Surge",
				"A very high level Water missile", tda, 2, 10, 2);
		
		addSpellSmall(22628 + 975, 557, 556, 21880, 10, 7, 1, 30006, 30005, 28226, 89, "Earth Surge",
				"A very high level Earth missile", tda, 4, 10, 2);
		
		addSpellSmall(22608 + 975, 554, 556, 21880, 10, 7, 1, 30003, 30005, 28226, 94, "Fire Surge",
				"A very high level Fire missile", tda, 6, 10, 2);
		
		setChildren(15, p);
		setBounds(31674 + 975, 84, 178, 0, p);
		setBounds(13674 + 975, 35, 228, 1, p);
		setBounds(22674 + 975, 132, 227, 2, p);
		setBounds(22644 + 975, 108, 202, 3, p);
		setBounds(22658 + 975, 156, 202, 4, p);
		setBounds(22628 + 975, 108, 227, 5, p);
		setBounds(22608 + 975, 156, 227, 6, p);
		setBounds(1151, 0, 0, 7, p);
		setBounds(22609 + 975, 5, 5, 8, p);
		setBounds(22629 + 975, 5, 5, 9, p);
		setBounds(22659 + 975, 5, 5, 10, p);
		setBounds(22645 + 975, 5, 5, 11, p);
		setBounds(31675 + 975, 5, 5, 12, p);
		setBounds(13675 + 975, 5, 5, 13, p);
		setBounds(22675 + 975, 5, 5, 14, p);
	}

	public static void closeButton(int id, int sprite2, int sprite1) {
		RSInterface tab = addInterface(id);
		tab.atActionType = 0;
		tab.type = 0;
		tab.sprite2 = Client.cacheSprite3[sprite2];
		tab.sprite1 = Client.cacheSprite3[sprite1];
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite2.myHeight;
		// tab.toggled = false;
		// tab.spriteOpacity = 255;d
	}

	public static void createSkillHover(int id, int x) {
		RSInterface hover = addInterface(id);
		hover.inventoryhover = true;
		hover.type = 8;
		hover.message = "TESTING!" + x;
		hover.contentType = x;
		hover.width = 60;
		hover.height = 32;
	}

	private static void skillTabWithHovers(TextDrawingArea[] tda) {
		int[] firstRow = {

				/** First row (enx. index 9) **/
				14918, 14919, 14920, 14921, 14922, 14923, 14924, 14933

		};
		int[] secondRow = {

				/** Second row (enx. index 8) **/
				14926, 14927, 14928, 14929, 14930, 14931, 14932, 14925

		};
		int[] thirdRow = {

				/** Third row (enx. index 8) **/
				14934, 14935, 14936, 14937, 14938, 14939, 14940

		};
		
		int[] firstColumnContent = {
				0, 2, 1, 4, 5, 6, 20, 22
		};
		
		int[] secondColumnContent = {
				3, 16, 15, 17, 12, 9, 18, 21
		};
		int[] thirdColumnContent = {
				14, 13, 10, 7, 11, 8, 19
		};

		RSInterface tab = addInterface(13917);
		tab.totalChildren(1 + firstRow.length + secondRow.length + thirdRow.length);
		int child = 1;
		setBounds(3917, 0, 0, 0, tab);
		for (int i = 0; i < firstRow.length; i++) {//Left column
			createSkillHover(firstRow[i], 206 + firstColumnContent[i]);
			setBounds(firstRow[i], 0, 2 + (32 * i), child++, tab);
		}
		for (int i = 0; i < secondRow.length; i++) {//Middle column
			createSkillHover(secondRow[i], 206 + secondColumnContent[i]);
			setBounds(secondRow[i], 60, 2 + (32 * i), child++, tab);
		}
		for (int i = 0; i < thirdRow.length; i++) {//Right column
			createSkillHover(thirdRow[i], 206 + thirdColumnContent[i]);
			setBounds(thirdRow[i], 120, 2 + (32 * i), child++, tab);
		}
		interfaceCache[18797].valueIndexArray[0][1] = 22;
		interfaceCache[18798].valueIndexArray[0][1] = 22;
		

		interfaceCache[18799].valueIndexArray[0][1] = 21;
		interfaceCache[18800].valueIndexArray[0][1] = 21;
		//printItf(3917, true);
		//230 CONSTRUCT
		//221 HUNTER
	}

	public static void equipmentScreen(TextDrawingArea[] wid) {
		RSInterface Interface = RSInterface.interfaceCache[1644];
		addButton(19144, 140, "Show Equipment Stats");
		removeSomething(19145);
		removeSomething(19146);
		removeSomething(19147);
		setBounds(19145, 40, 210, 24, Interface);
		setBounds(19146, 40, 210, 25, Interface);
		setBounds(19147, 40, 210, 26, Interface);
		RSInterface tab = addTabInterface(15106);
		addSprite3(15107, 116);

		addHoverButton_sprite_loader(15210, 142, 21, 21, "Close", 250, 15211, 3);
		addHoveredButton_sprite_loader(15211, 143, 21, 21, 15212);

		addText(15111, "Equip Your Character...", wid, 2, 0xFF9300, false, true);
		addText(15112, "Attack bonus", wid, 2, 0xFF9300, false, true);
		addText(15113, "Defence bonus", wid, 2, 0xFF9300, false, true);
		addText(15114, "Other bonuses", wid, 2, 0xFF9300, false, true);

		addText(16117, "0kg", wid, 1, 0xFF9300, false, true);

		for (int i = 1675; i <= 1684; i++) {
			textSize(i, wid, 1);
		}
		textSize(1686, wid, 1);
		textSize(1687, wid, 1);
		addChar(15125);
		tab.totalChildren(45);
		tab.child2(0, 15107, 5, 5);
		tab.child2(1, 15210, 477, 12);
		tab.child2(2, 15211, 477, 12);
		tab.child2(3, 15111, 15, 15);
		int Child = 4;
		int Y = 69;
		int xOff = 332;
		int xOff2 = 323;
		int yOff = 7;
		int yOff2 = 8;
		for (int i = 1675; i <= 1679; i++) {
			tab.child2(Child, i, 20 + xOff, Y - yOff2);
			Child++;
			Y += 14;
		}

		tab.child2(9, 1680, 20 + xOff, 161 - yOff2);
		tab.child2(10, 1681, 20 + xOff, 177 - yOff2);
		tab.child2(11, 1682, 20 + xOff, 192 - yOff2);
		tab.child2(12, 1683, 20 + xOff, 207 - yOff2);
		tab.child2(13, 1684, 20 + xOff, 221 - yOff2);
		tab.child2(14, 1686, 20 + xOff, 262 - yOff2);
		tab.child2(15, 15125, 192, 210);
		tab.child2(16, 15112, 16 + xOff, 55 - yOff2);
		tab.child2(17, 1687, 20 + xOff, 276 - yOff2);
		tab.child2(18, 15113, 16 + xOff, 147 - yOff2);
		tab.child2(19, 15114, 16 + xOff, 248 - yOff2);
		tab.child2(20, 1645, 104 + 295 - xOff2, 149 - 52 + yOff);
		tab.child2(21, 1646, 399 - xOff2, 163 + yOff);
		tab.child2(22, 1647, 399 - xOff2, 163 + yOff);
		tab.child2(23, 1648, 399 - xOff2, 58 + 146 + yOff);
		tab.child2(24, 1649, 26 + 22 + 297 - xOff2 - 2, 110 - 44 + 118 - 13 + 5 + yOff);
		tab.child2(25, 1650, 321 - xOff2 + 22, 58 + 154 + yOff);
		tab.child2(26, 1651, 321 - xOff2 + 134, 58 + 118 + yOff);
		tab.child2(27, 1652, 321 - xOff2 + 134, 58 + 154 + yOff);
		tab.child2(28, 1653, 321 - xOff2 + 48, 58 + 81 + yOff);
		tab.child2(29, 1654, 321 - xOff2 + 107, 58 + 81 + yOff);
		tab.child2(30, 1655, 321 - xOff2 + 58, 58 + 42 + yOff);
		tab.child2(31, 1656, 321 - xOff2 + 112, 58 + 41 + yOff);
		tab.child2(32, 1657, 321 - xOff2 + 78, 58 + 4 + yOff);
		tab.child2(33, 1658, 321 - xOff2 + 37, 58 + 43 + yOff);
		tab.child2(34, 1659, 321 - xOff2 + 78, 58 + 43 + yOff);
		tab.child2(35, 1660, 321 - xOff2 + 119, 58 + 43 + yOff);
		tab.child2(36, 1661, 321 - xOff2 + 22, 58 + 82 + yOff);
		tab.child2(37, 1662, 321 - xOff2 + 78, 58 + 82 + yOff);
		tab.child2(38, 1663, 321 - xOff2 + 134, 58 + 82 + yOff);
		tab.child2(39, 1664, 321 - xOff2 + 78, 58 + 122 + yOff);
		tab.child2(40, 1665, 321 - xOff2 + 78, 58 + 162 + yOff);
		tab.child2(41, 1666, 321 - xOff2 + 22, 58 + 162 + yOff);
		tab.child2(42, 1667, 321 - xOff2 + 134, 58 + 162 + yOff);
		tab.child2(43, 1688, 50 + 297 - xOff2 - 2, 110 - 13 + 5 + yOff);

		// Maxhits

		tab.child2(44, 16117, 87, 283);

		for (int i = 1675; i <= 1684; i++) {
			RSInterface rsi = interfaceCache[i];
			rsi.textColor = 0xFF9300;
			rsi.centerText = false;
		}
		for (int i = 1686; i <= 1687; i++) {
			RSInterface rsi = interfaceCache[i];
			rsi.textColor = 0xFF9300;
			rsi.centerText = false;
		}
	}

	public static void expLock(TextDrawingArea[] tda) {
		RSInterface tab = addInterface(37500);
		String dir = "interfaces/explock/sprite";
		String dir2 = "interfaces/prestige/playerstats/skills/img";
		addSprite(37501, 0, dir);
		addSpriteOnHover(37502, dir, 1, 2, 16, 16, "", -1, 3);
		addText(37505, "Exp Lock Manager", tda, 2, 0xFFA500, true, true);
		int x = 150, y = 10;
		tab.totalChildren(4);
		tab.child(0, 37501, x, y);
		tab.child(1, 37502, 177 + x, 4 + y);
		tab.child(2, 37505, 97 + x, 5 + y);
		tab.child(3, 37510, 10 + x, 30 + y);

		final String[] skillNames = { "Attack", "Defence", "Strength", "Hitpoints", "Ranged", "Prayer", "Magic" };

		RSInterface over = addInterface(37510);
		addSprite(37527, 4, dir);
		int xx = 0, yy = 0;
		over.totalChildren(42);
		for (int i = 0; i < 7; i++) {
			addButton(37511 + i, 3, dir, "Toggle @lre@" + skillNames[i]);
			addSprite(37519 + i, i, dir2);
			addText(37528 + i, Client.capitalize(skillNames[i]) + ":", tda, 0, 16748608, false, true);
			addText(37536 + i, "@gre@Unlocked", tda, 0, 16777215, false, true);
			addText(37544 + i, "@gre@99", tda, 0, 16777215, false, true);
			int[] g = centerSkillSprite(interfaceCache[37519 + i].sprite1);
			over.child(i, 37511 + i, xx, yy);
			over.child(i + 7, 37519 + i, xx + g[0], yy + g[1]);
			over.child(i + 14, 37527, xx + 32, yy + 7);
			over.child(i + 21, 37528 + i, xx + 35, yy + 10);
			over.child(i + 28, 37536 + i, xx + 125, yy + 10);
			over.child(i + 35, 37544 + i, xx + 90, yy + 10);
			xx += 117;
			if (xx == 117) {
				xx = 0;
				yy += 39;
			}
		}
	}

	public static void settingsInterface(TextDrawingArea[] tda){
		RSInterface tab = addInterface(39000);
		addSprite(39001, 1, "/interfaces/achievements/image");
		addText(39002, "Advanced Settings", tda, 2, 0xFFA500, true, true);
        addText(39020, "    Have something you would want to see added here? Please suggest it on our forums!", tda, 1, 0xFFA500, false, true);
        String dir = "/interfaces/prestige/sprite";
        addHoverButton(39021, dir, 1, 16, 16, "Close", -1, 39022, 1);
        addHoveredButton(39022, dir, 2, 16, 16, 39023);
        setChildren(6,tab);
		setBounds(39001,0,0,0,tab);
		setBounds(39002,253,15,1,tab);
		setBounds(39003,9,52,2,tab);
        setBounds(39020,5,310,3,tab);
        setBounds(39021,490,5,5,tab);
        setBounds(39022,490,5,4,tab);
		RSInterface scroll = addInterface(39003);
		scroll.width = 479;
		scroll.height = 248;
		scroll.scrollMax = 330;
		scroll.totalChildren(26);
		addText(39004, "Old Gameframe", tda, 2, 0xFFA500, false, true);
		addText(39005, "Game Timers", tda, 2, 0xFFA500, false, true);
		addText(39006, "Anti-aliasing", tda, 2, 0xFFA500, false, true);
		addText(39007, "Ground item names", tda, 2, 0xFFA500, false, true);
		addText(39008, "Fog", tda, 2, 0xFFA500, false, false);
		addText(39009, "Smooth shading", tda, 2, 0xFFA500, false, true);
		addText(39010, "Tile blending", tda, 2, 0xFFA500, false, true);
        addText(39019, "Inventory Menu", tda, 2, 0xFFA500, false, true);
		addText(39023, "Bounty Hunter", tda, 2, 0xFFA500, false, true);
		addText(39024, "Entity Target", tda, 2, 0xFFA500, false, true);
		addText(39028, "Chat effect", tda, 2, 0xFFA500, false, true);
		

		addText(39029, "Text/Sprites over Objects", tda, 2, 0xFFA500, false, true);
		addText(39030, "Text/Sprites over Entities", tda, 2, 0xFFA500, false, true);
		dropdownMenu(39031, 166,0, new String[]{"On", "Off"}, Dropdown.OBJECT_TEXTSPRITE, tda, 1);
		dropdownMenu(39032, 166,0, new String[]{"On", "Off"}, Dropdown.ENTITY_TEXTSPRITE, tda, 1);
		
		dropdownMenu(39011, 166,1, new String[]{"On", "Off"}, Dropdown.OLD_GAMEFRAME, tda, 1);
		dropdownMenu(39012, 166,0, new String[]{"On", "Off"}, Dropdown.GAME_TIMERS, tda, 1);
		dropdownMenu(39013, 166,1, new String[]{"On", "Off"}, Dropdown.ANTI_ALIASING, tda, 1);
		dropdownMenu(39014, 166,1, new String[]{"On", "Off"}, Dropdown.GROUND_ITEM_NAMES, tda, 1);
		dropdownMenu(39015, 166,0, new String[]{"Off", "On(Grey)","On(Sisle)", "On(Dark)","On(Marroon)", "On(Rainbow?)"}, Dropdown.FOG, tda, 1);
		dropdownMenu(39016, 166,0, new String[]{"On", "Off"}, Dropdown.SMOOTH_SHADING, tda, 1);
		dropdownMenu(39017, 166,0, new String[]{"On", "Off"}, Dropdown.TILE_BLENDING, tda, 1);
		dropdownMenu(39018, 166,1, new String[]{"Off", "On (Magenta)", "On (Lime green)", "On (Cyan)", "On (Red)"}, Dropdown.INVENTORY_CONTEXT_MENU, tda, 1);
		dropdownMenu(39025, 166,0, new String[]{"On", "Off"}, Dropdown.BOUNTY_HUNTER, tda, 1);
		dropdownMenu(39026, 166,0, new String[]{"On", "Off"}, Dropdown.TARGET_INTERFACE, tda, 1);
		dropdownMenu(39027, 166,0, new String[]{"Yellow(Default)", "Red","Green","Cyan","Purple","White","Flash 1","Flash 2", "Flash 3","Glow 1", "Glow 2","Glow 3"}, Dropdown.CHAT_EFFECT, tda, 1);
		RSInterface.interfaceCache[39027].inverted = true;
		RSInterface.interfaceCache[39032].inverted = true;
		int textLeft = 20;
		int dropdownLeft = 299;
		setBounds(39004,textLeft,0,0,scroll);
		setBounds(39005,textLeft,25,1,scroll);
		setBounds(39006,textLeft,50,2,scroll);
		setBounds(39007,textLeft,75,3,scroll);
		setBounds(39008,textLeft,100,4,scroll);
		setBounds(39009,textLeft,125,5,scroll);
		setBounds(39010,textLeft,150,6,scroll);
		setBounds(39028,textLeft,250,21,scroll);
		setBounds(39024,textLeft,225,20,scroll);
		setBounds(39023,textLeft,200,19,scroll);
        setBounds(39019,textLeft,175,18,scroll);

        setBounds(39029,textLeft,275,22,scroll);
        setBounds(39030,textLeft,300,23,scroll);
        
		setBounds(39011,dropdownLeft,0,17,scroll);
		setBounds(39012,dropdownLeft,25,16,scroll);
		setBounds(39013,dropdownLeft,50,15,scroll);
		setBounds(39014,dropdownLeft,75,14,scroll);
		setBounds(39015,dropdownLeft,100,13,scroll);
		setBounds(39016,dropdownLeft,125,12,scroll);
		setBounds(39017,dropdownLeft,150,11,scroll);
		setBounds(39018,dropdownLeft,175,10,scroll);
		setBounds(39025,dropdownLeft,200,9,scroll);
		setBounds(39026,dropdownLeft,225,8,scroll);
		setBounds(39027,dropdownLeft,250,7,scroll);

		setBounds(39031,dropdownLeft,275,25,scroll);
		setBounds(39032,dropdownLeft,300,24,scroll);
	}




	public static void prestigeInterface(TextDrawingArea[] tda) {
		RSInterface tab = addInterface(37300);
		String dir = "/interfaces/prestige/sprite";
		String dir2 = "/interfaces/prestige/playerstats/skills/img";
		addSprite(37301, 0, dir);
		addHoverButton(37302, dir, 1, 16, 16, "Close", -1, 37303, 1);
		addHoveredButton(37303, dir, 2, 16, 16, 37304);
		addText(37305, "Prestige Manager", tda, 2, 0xFFA500, true, true);
		addSprite(37306, 6, dir);
		addText(37307, "Attack:", tda, 2, 0xFFA500, true, true);
		addText(37308, "Current Prestige: @whi@0", tda, 0, 16748608, false, true);
		addText(37309, "Reward: @whi@1000 Points", tda, 0, 16748608, false, true);
		addText(37390, "Can Prestige: @whi@...", tda, 0, 16748608, false, true);
		addHoverButton(37391, dir, 7, 80, 31, "Prestige selected skill", 0, 37392, 1);
		addHoveredButton(37392, dir, 8, 80, 31, 37393);
		addText(37394, "Prestige", tda, 2, 16777215, true, true);
		int x = 10, y = 10;
		tab.totalChildren(13);
		tab.child(0, 37301, x, y);
		tab.child(1, 37302, 463 + x, 4 + y);
		tab.child(2, 37303, 463 + x, 4 + y);
		tab.child(3, 37305, 243 + x, 5 + y);
		tab.child(4, 37310, 10 + x, 30 + y);
		tab.child(5, 37306, 258 + x, 222 + y);
		tab.child(6, 37307, 366 + x, 226 + y);
		tab.child(7, 37308, 263 + x, 242 + y);
		tab.child(8, 37309, 263 + x, 257 + y);
		tab.child(9, 37390, 263 + x, 273 + y);
		tab.child(10, 37391, 389 + x, 255 + y);
		tab.child(11, 37392, 389 + x, 255 + y);
		tab.child(12, 37394, 429 + x, 262 + y);

		final String[] skillNames = { "attack", "defence", "strength", "hitpoints", "ranged", "prayer", "magic",
				"cooking", "woodcutting", "fletching", "fishing", "firemaking", "crafting", "smithing", "mining",
				"herblore", "agility", "thieving", "slayer", "farming", "runecraft", "hunter", "-unused-", "-unused-",
				"-unused-" };

		RSInterface over = addInterface(37310);
		addSprite(37359, 5, dir);
		int xx = 0, yy = 0, line = 0;
		over.totalChildren(110);
		for (int i = 0; i < 22; i++) {
			addButton(37311 + i, 3, dir, "Select @lre@" + skillNames[i]);
			addSprite(37335 + i, i, dir2);
			addText(37360 + i, Client.capitalize(skillNames[i]), tda, 0, 16748608, false, true);
			addText(37400 + i, "0", tda, 0, 16777215, false, true);
			int[] g = centerSkillSprite(interfaceCache[37335 + i].sprite1);
			int bonusY = 0;
			if (xx == 0 || xx == 117)
				bonusY = 5 * line;
			over.child(i, 37311 + i, xx, yy + bonusY);
			over.child(i + 22, 37335 + i, xx + g[0], yy + g[1] + bonusY);
			over.child(i + 44, 37359, xx + 32, yy + 7 + bonusY);
			over.child(i + 66, 37360 + i, xx + 35, yy + 10 + bonusY);
			over.child(i + 88, 37400 + i, xx + 102, yy + 10 + bonusY);
			xx += 117;
			if (xx == 468) {
				xx = 0;
				yy += 39;
				line++;
			}
		}
	}

	public static int[] centerSkillSprite(Sprite s) {
		int x = 15, y = 15;
		x -= (s.myWidth / 2);
		y -= (s.myHeight / 2);
		return new int[] { x, y };
	}

	public static void slayerOverlay(TextDrawingArea[] tda) {
		RSInterface rsInterface = addInterface(35424);
		addText(35425, "Abyssal Demon: 5", tda, 1, 0xF7FE2E, true, true);
		setChildren(1, rsInterface);
		rsInterface.child(0, 35425,
				Client.currentScreenMode == ScreenMode.FIXED ? 250 : (Client.currentGameWidth - 300), 10); // Assignment
	}
	

	private static void skotizo(TextDrawingArea[] tda) {
		RSInterface tab = addInterface(29230);
		tab.totalChildren(5);
		addSprite(29231, 0, "interfaces/skotizo/skotizom");
		tab.child(0, 29231, 36, 141);
		addSprites(29232, "interfaces/skotizo/skotizo", 3, 0);
		tab.child(1, 29232, 56, 128);
		addSprites(29233, "interfaces/skotizo/skotizo", 3, 0);
		tab.child(2, 29233, 56, 193);
		addSprites(29234, "interfaces/skotizo/skotizo", 3, 0);
		tab.child(3, 29234, 23, 160);
		addSprites(29235, "interfaces/skotizo/skotizo", 3, 0);
		tab.child(4, 29235, 88, 160);
	}
	

	public static void GoldenScratchCardNew(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(23200);
		String dir = "Interfaces/ScratchCard/BUTTON";


		RSInterface.addSprite(23201, 2, dir);// 20013
		RSInterface.addText(23202, "Scratch Card", tda, 2, 0xFF9900, true, true); // 20014
		RSInterface.addText(23203, "Match 3 to Win!", tda, 2, 0xFF9900, true, true); // 20014
		RSInterface.addText(23204, "Win Amazing Prizes!", tda, 0, 0xFF9900, true, true); // 20014

		addHoverButton(23205, dir, 3, 16, 16, "Close", -1, 23206, 1);
		addHoveredButton(23206, dir, 4, 16, 16, 23206);

		//  RSInterface.addButton(23205, 1595, 1596, "Scratch");
		//first button
		addHoverButton(23228, dir, 1, 70, 70, "Scratch", -1, 23229, 1);
		addHoveredButton(23229, dir, 2, 70, 70, 23230);

		//			 addHoverButton(13412, dir, 2, 132, 23, "Teleport", -1, 13413, 1);
		// addHoveredButton(13413, dir, 1, 132, 23, 13414);


		RSInterface.addText(23232, "$", tda, 2, 0xFF9900, true, true);
		//addToItemGroup(23207, 0, 1, 80, 30, false, null, null, null);
		//addToItemGroup(23207,  0, 1, 80, 30, false, null, null, null);
		//addToItemGroup(23207, 8, 8, 5, 5, false, null, null, null);
		RSInterface.addToItemGroup(23207, 1, 80, 30, 2, false, null, null, null);



		RSInterface.addText(23208, "Bonus Prize", tda, 2, 0xFF9900, true, true);
		RSInterface.addText(23209, "Guaranteed Win", tda, 2, 0xFF9900, true, true);


		//second Button
		addHoverButton(23219, dir, 1, 70, 70, "Scratch", -1, 23220, 1);
		addHoveredButton(23220, dir, 2, 70, 70, 23221);

		//   RSInterface.addButton(23210, 1595, 1596, "Scratch");
		//	RSInterface.addToItemGroup(23211, 0, 1, 80, 30, false, null, null, null);
		//	addToItemGroup(23211,  0, 1, 80, 30, false, null, null, null);
		RSInterface.addToItemGroup(23211, 1, 80, 30, 2, false, null, null, null);


		RSInterface.addText(23233, "$", tda, 2, 0xFF9900, true, true);


		//third button
		addHoverButton(23222, dir, 1, 70, 70, "Scratch", -1, 23223, 1);
		addHoveredButton(23223, dir, 2, 70, 70, 23224);
		//  RSInterface.addButton(23212, 1595, 1596, "Scratch");
		//RSInterface.addToItemGroup(23217, 0, 1, 80, 30, false, null, null, null);
		//	addToItemGroup(23217,  0, 1, 80, 30, false, null, null, null);
		RSInterface.addToItemGroup(23217, 1, 80, 30, 2, false, null, null, null);



		//Fourth button that last number handles the configs on buttons
		addHoverButton(23225, dir, 1, 70, 70, "Bonus", -1, 23226, 1);
		addHoveredButton(23226, dir, 2, 70, 70, 23227);
		//  RSInterface.addButton(23213, 1595, 1596, "Scratch");
		RSInterface.addText(23234, "$", tda, 2, 0xFF9900, true, true);
		//	RSInterface.addToItemGroup(23215, 0, 1, 80, 30, false, null, null, null);
		//	addToItemGroup(23215,  0, 1, 80, 30, false, null, null, null);
		RSInterface.addToItemGroup(23215, 1, 80, 30, 2, false, null, null, null);


		RSInterface.setChildren(23, tab);
		int startX = 150;
		int startY = 110;

		tab.child(0, 23201, 90, 15);
		tab.child(1, 23202, 255, 26);
		tab.child(2, 23203, 255, 55);
		tab.child(3, 23204, 255, 70);

		tab.child(4, 23208, 255, 198);
		tab.child(5, 23209, 255, 213);





		tab.child(6, 23228, startX, startY); //first button
		tab.child(7, 23229, startX, startY); //hover 

		tab.child(8, 23219,  startX + 75, startY); //second button
		tab.child(9, 23220,  startX + 75, startY); //hover

		tab.child(10, 23222,  startX + 150, startY); //third button
		tab.child(11, 23223,  startX + 150, startY); //hover

		tab.child(12, 23225, 227, 245); //last button
		tab.child(13, 23226, 227, 245); //hover

		tab.child(14, 23233, startX + 28 + 75, startY + 20);
		tab.child(15, 23232, startX + 28, startY + 20);
		tab.child(16, 23234, startX + 28 + 150, startY + 20);

		tab.child(17, 23207, startX + 15, startY + 11);
		tab.child(18, 23211, startX + 89, startY  + 11); //second
		tab.child(19, 23215, startX + 164, startY + 11);
		tab.child(20, 23217, 239, 255); //== to the bonus reward positioning item group

		tab.child(21, 23205, 392, 25);
		tab.child(22, 23206, 392, 25);



		//	    tab.child(4, 23205, startX, startY); first button
		//	    tab.child(9, 23210,  startX + 75, startY); second button
		//		    tab.child(13, 23213,  startX + 150, startY); //third button
		// 	    tab.child(12, 23212, 227, 245); fourth button

	}


	public static void tradingSelect(TextDrawingArea[] tda) {
		RSInterface Interface = addTabInterface(48599);
		RSInterface history = addTabInterface(48635);
		RSInterface offers = addTabInterface(48950);

		addSprite(48601, 7, "trading/sprite");
		addHover(48602, 3, 0, 48603, 1, "bank/bank", 17, 17, "Close Window");
		addHovered(48603, 2, "bank/bank", 17, 17, 48604);

		addText(48605, "Trading Post", 0xff9933, true, true, -1, tda, 2);

		addText(48606, "Coffer", 0xff9933, true, true, -1, tda, 2);
		addHoverButton(48607, "trading/sprite", 8, 143, 35, "Claim money", 0, 48608, 1);
		addHoveredButton(48608, "trading/sprite", 9, 143, 35, 48609);
		addText(48610, "", 0xff9933, true, true, -1, tda, 0);

		addText(48611, "Search for...", 0xff9933, true, true, -1, tda, 2);
		addHoverButton(48612, "trading/sprite", 10, 72, 32, "Search for a item", 0, 48613, 1);
		addHoveredButton(48613, "trading/sprite", 11, 72, 32, 48614);

		addHoverButton(48615, "trading/sprite", 10, 72, 32, "Search for a player", 0, 48616, 1);
		addHoveredButton(48616, "trading/sprite", 11, 72, 32, 48617);

		addHoverButton(48618, "trading/sprite", 10, 72, 32, "Recent offers", 0, 48619, 1);
		addHoveredButton(48619, "trading/sprite", 11, 72, 32, 48620);

		addHoverButton(48621, "trading/sprite", 12, 150, 35, "Click", 0, 48622, 1);
		addHoveredButton(48622, "trading/sprite", 13, 150, 35, 48623);

		addText(48624, "History", 0xff9933, true, true, -1, tda, 2);
		addText(48625, "My Offers...", 0xff9933, true, true, -1, tda, 2);

		addText(48626, "Item", 0xff9933, true, true, -1, tda, 2);
		addText(48627, "Player", 0xff9933, true, true, -1, tda, 2);
		addText(48628, "Recent", 0xff9933, true, true, -1, tda, 2);
		addText(48629, "Cancel Listing", 0xff9933, true, true, -1, tda, 2);

		setChildren(25, Interface);

		setBounds(48601, 8, 10, 0, Interface); // Base
		setBounds(48602, 471, 18, 1, Interface); // Close
		setBounds(48603, 471, 18, 2, Interface);

		setBounds(48605, 262, 20, 3, Interface); // Title

		setBounds(48606, 40, 50, 4, Interface); // Coffer text
		setBounds(48607, 19, 68, 5, Interface); // Coffer Button
		setBounds(48608, 19, 68, 6, Interface);
		setBounds(48610, 75, 80, 7, Interface); // Amount in coffer

		setBounds(48611, 59, 250, 8, Interface); // Text search for...
		setBounds(48612, 19, 270, 9, Interface); // Item Button
		setBounds(48613, 19, 270, 10, Interface);

		setBounds(48615, 96, 270, 11, Interface); // Player Button
		setBounds(48616, 96, 270, 12, Interface);

		setBounds(48618, 173, 270, 13, Interface); // Recent Button
		setBounds(48619, 173, 270, 14, Interface);

		setBounds(48621, 293, 270, 15, Interface); // Long button
		setBounds(48622, 293, 270, 16, Interface);

		setBounds(48624, 42, 104, 17, Interface); // Text History
		setBounds(48625, 289, 50, 18, Interface); // TextMy offers

		setBounds(48626, 55, 279, 19, Interface); // Text Item
		setBounds(48627, 132, 279, 20, Interface); // Text Player
		setBounds(48628, 208, 279, 21, Interface); // Text Recent
		setBounds(48629, 367, 279, 22, Interface); // Text List

		setBounds(48635, 30, 128, 23, Interface); // Interface history
		setBounds(48950, 260, 75, 24, Interface); // Interface my offers

		setChildren(20, history);
		for (int i = 48636, y = 5, id = 0; i < 48656; i++) {
			addText(i, "", 0xff9933, true, true, -1, tda, 0);
			setBounds(i, 94, y, id, history);
			if (id == 1 || id == 3 || id == 5 || id == 7 || id == 9 || id == 11 || id == 13 || id == 15 || id == 17)
				y += 20;
			else
				y += 10;
			id++;
		}

		history.scrollMax = 300;
		history.width = 193;
		history.height = 116;

		addText(48951, "Select an item", 0xff9933, true, true, -1, tda, 2);
		addText(48952, "from your", 0xff9933, true, true, -1, tda, 2);
		addText(48953, "inventory.", 0xff9933, true, true, -1, tda, 2);

		setChildren(3, offers);

		setBounds(48951, 108, 66, 0, offers); // Name
		setBounds(48952, 108, 80, 1, offers); // Price
		setBounds(48953, 108, 94, 2, offers); // sold

		// offers.scrollMax = 300;
		offers.width = 203;
		offers.height = 181;
	}

	public static void tradingpost(TextDrawingArea[] tda) {
		RSInterface Interface = addTabInterface(48600);
		RSInterface history = addTabInterface(48635);
		RSInterface offers = addTabInterface(48786);

		addSprite(48601, 7, "trading/sprite");
		addHover(48602, 3, 0, 48603, 1, "bank/bank", 17, 17, "Close Window");
		addHovered(48603, 2, "bank/bank", 17, 17, 48604);

		addText(48605, "Trading Post", 0xff9933, true, true, -1, tda, 2);

		addText(48606, "Coffer", 0xff9933, true, true, -1, tda, 2);
		addHoverButton(48607, "trading/sprite", 8, 143, 35, "Claim money", 0, 48608, 1);
		addHoveredButton(48608, "trading/sprite", 9, 143, 35, 48609);
		addText(48610, "100,000 GP", 0xff9933, true, true, -1, tda, 0);

		addText(48611, "Search for...", 0xff9933, true, true, -1, tda, 2);
		addHoverButton(48612, "trading/sprite", 10, 72, 32, "Search for a item", 0, 48613, 1);
		addHoveredButton(48613, "trading/sprite", 11, 72, 32, 48614);

		addHoverButton(48615, "trading/sprite", 10, 72, 32, "Search for a player", 0, 48616, 1);
		addHoveredButton(48616, "trading/sprite", 11, 72, 32, 48617);

		addHoverButton(48618, "trading/sprite", 10, 72, 32, "Recent offers", 0, 48619, 1);
		addHoveredButton(48619, "trading/sprite", 11, 72, 32, 48620);

		addHoverButton(48621, "trading/sprite", 12, 150, 35, "Click", 0, 48622, 1);
		addHoveredButton(48622, "trading/sprite", 13, 150, 35, 48623);

		addText(48624, "History", 0xff9933, true, true, -1, tda, 2);
		addText(48625, "My Offers...", 0xff9933, true, true, -1, tda, 2);

		addText(48626, "Item", 0xff9933, true, true, -1, tda, 2);
		addText(48627, "Player", 0xff9933, true, true, -1, tda, 2);
		addText(48648, "Recent", 0xff9933, true, true, -1, tda, 2);
		addText(48630, "List item for sale", 0xff9933, true, true, -1, tda, 2);

		setChildren(25, Interface);

		setBounds(48601, 8, 10, 0, Interface); // Base
		setBounds(48602, 471, 18, 1, Interface); // Close
		setBounds(48603, 471, 18, 2, Interface);

		setBounds(48605, 262, 20, 3, Interface); // Title

		setBounds(48606, 40, 50, 4, Interface); // Coffer text
		setBounds(48607, 19, 68, 5, Interface); // Coffer Button
		setBounds(48608, 19, 68, 6, Interface);
		setBounds(48610, 75, 80, 7, Interface); // Amount in coffer

		setBounds(48611, 59, 250, 8, Interface); // Text search for...
		setBounds(48612, 19, 270, 9, Interface); // Item Button
		setBounds(48613, 19, 270, 10, Interface);

		setBounds(48615, 96, 270, 11, Interface); // Player Button
		setBounds(48616, 96, 270, 12, Interface);

		setBounds(48618, 173, 270, 13, Interface); // Recent Button
		setBounds(48619, 173, 270, 14, Interface);

		setBounds(48621, 293, 270, 15, Interface); // Long button
		setBounds(48622, 293, 270, 16, Interface);

		setBounds(48624, 42, 104, 17, Interface); // Text History
		setBounds(48625, 289, 50, 18, Interface); // TextMy offers

		setBounds(48626, 55, 279, 19, Interface); // Text Item
		setBounds(48627, 132, 279, 20, Interface); // Text Player
		setBounds(48628, 208, 279, 21, Interface); // Text Recent
		setBounds(48630, 367, 279, 22, Interface); // Text List

		setBounds(48635, 30, 128, 23, Interface); // Interface history
		setBounds(48786, 260, 75, 24, Interface); // Interface my offers

		setChildren(20, history);
		for (int i = 48636, y = 5, id = 0; i < 48656; i++) {
			addText(i, "", 0xff9933, true, true, -1, tda, 0);
			setBounds(i, 94, y, id, history);
			if (id == 1 || id == 3 || id == 5 || id == 7 || id == 9 || id == 11 || id == 13 || id == 15 || id == 17)
				y += 20;
			else
				y += 10;
			id++;
		}

		history.scrollMax = 300;
		history.width = 193;
		history.height = 116;

		addListing(48847, false);
		addText(48788, "", 0xff9933, true, true, -1, tda, 0);
		addText(48789, "", 0xff9933, true, true, -1, tda, 0);
		addText(48790, "", 0xff9933, true, true, -1, tda, 0);

		addText(48792, "", 0xff9933, true, true, -1, tda, 0);
		addText(48793, "", 0xff9933, true, true, -1, tda, 0);
		addText(48794, "", 0xff9933, true, true, -1, tda, 0);

		addText(48796, "", 0xff9933, true, true, -1, tda, 0);
		addText(48797, "", 0xff9933, true, true, -1, tda, 0);
		addText(48798, "", 0xff9933, true, true, -1, tda, 0);

		addText(48800, "", 0xff9933, true, true, -1, tda, 0);
		addText(48801, "", 0xff9933, true, true, -1, tda, 0);
		addText(48802, "", 0xff9933, true, true, -1, tda, 0);

		addText(48804, "", 0xff9933, true, true, -1, tda, 0);
		addText(48805, "", 0xff9933, true, true, -1, tda, 0);
		addText(48806, "", 0xff9933, true, true, -1, tda, 0);

		addText(48808, "", 0xff9933, true, true, -1, tda, 0);
		addText(48809, "", 0xff9933, true, true, -1, tda, 0);
		addText(48810, "", 0xff9933, true, true, -1, tda, 0);

		addText(48812, "", 0xff9933, true, true, -1, tda, 0);
		addText(48813, "", 0xff9933, true, true, -1, tda, 0);
		addText(48814, "", 0xff9933, true, true, -1, tda, 0);

		addText(48816, "", 0xff9933, true, true, -1, tda, 0);
		addText(48817, "", 0xff9933, true, true, -1, tda, 0);
		addText(48818, "", 0xff9933, true, true, -1, tda, 0);

		addText(48820, "", 0xff9933, true, true, -1, tda, 0);
		addText(48821, "", 0xff9933, true, true, -1, tda, 0);
		addText(48822, "", 0xff9933, true, true, -1, tda, 0);

		addText(48824, "", 0xff9933, true, true, -1, tda, 0);
		addText(48825, "", 0xff9933, true, true, -1, tda, 0);
		addText(48826, "", 0xff9933, true, true, -1, tda, 0);

		addText(48828, "", 0xff9933, true, true, -1, tda, 0);
		addText(48829, "", 0xff9933, true, true, -1, tda, 0);
		addText(48830, "", 0xff9933, true, true, -1, tda, 0);

		addText(48832, "", 0xff9933, true, true, -1, tda, 0);
		addText(48833, "", 0xff9933, true, true, -1, tda, 0);
		addText(48834, "", 0xff9933, true, true, -1, tda, 0);

		addText(48836, "", 0xff9933, true, true, -1, tda, 0);
		addText(48837, "", 0xff9933, true, true, -1, tda, 0);
		addText(48838, "", 0xff9933, true, true, -1, tda, 0);

		addText(48840, "", 0xff9933, true, true, -1, tda, 0);
		addText(48841, "", 0xff9933, true, true, -1, tda, 0);
		addText(48842, "", 0xff9933, true, true, -1, tda, 0);

		addText(48844, "", 0xff9933, true, true, -1, tda, 0);
		addText(48845, "", 0xff9933, true, true, -1, tda, 0);
		addText(48846, "", 0xff9933, true, true, -1, tda, 0);

		setChildren(46, offers);

		setBounds(48788, 118, 10, 0, offers); // Name
		setBounds(48789, 51, 33, 1, offers); // Price
		setBounds(48790, 118, 23, 2, offers); // sold

		setBounds(48792, 118, 57, 3, offers); // Name y + 49
		setBounds(48793, 51, 80, 4, offers); // Price y + 48
		setBounds(48794, 118, 70, 5, offers); // sold y + 49

		setBounds(48796, 118, 104, 6, offers); // Name y + 49
		setBounds(48797, 51, 127, 7, offers); // Price y + 28
		setBounds(48798, 118, 117, 8, offers); // sold y + 49

		setBounds(48800, 118, 151, 9, offers); // Name y + 49
		setBounds(48801, 51, 174, 10, offers); // Price y + 28
		setBounds(48802, 118, 164, 11, offers); // sold y + 49

		setBounds(48804, 118, 198, 12, offers); // Name y + 49
		setBounds(48805, 51, 221, 13, offers); // Price y + 28
		setBounds(48806, 118, 211, 14, offers); // sold y + 49

		setBounds(48808, 118, 245, 15, offers); // Name y + 49
		setBounds(48809, 51, 268, 16, offers); // Price y + 48
		setBounds(48810, 118, 258, 17, offers); // sold y + 49

		setBounds(48812, 118, 292, 18, offers); // Name y + 49
		setBounds(48813, 51, 315, 19, offers); // Price y + 48
		setBounds(48814, 118, 305, 20, offers); // sold y + 49

		setBounds(48816, 118, 339, 21, offers); // Name y + 49
		setBounds(48817, 51, 362, 22, offers); // Price y + 48
		setBounds(48818, 118, 352, 23, offers); // sold y + 49

		setBounds(48820, 118, 386, 24, offers); // Name y + 49
		setBounds(48821, 51, 409, 25, offers); // Price y + 48
		setBounds(48822, 118, 399, 26, offers); // sold y + 49

		setBounds(48824, 118, 433, 27, offers); // Name y + 47
		setBounds(48825, 51, 456, 28, offers); // Price y + 47 fout
		setBounds(48826, 118, 446, 29, offers); // sold y + 47

		setBounds(48828, 118, 480, 30, offers); // Name y + 49
		setBounds(48829, 51, 503, 31, offers); // Price y + 48
		setBounds(48830, 118, 493, 32, offers); // sold y + 49

		setBounds(48832, 118, 527, 33, offers); // Name y + 49
		setBounds(48833, 51, 550, 34, offers); // Price y + 48
		setBounds(48834, 118, 540, 35, offers); // sold y + 49

		setBounds(48836, 118, 574, 36, offers); // Name y + 49
		setBounds(48837, 51, 597, 37, offers); // Price y + 48
		setBounds(48838, 118, 587, 38, offers); // sold y + 49

		setBounds(48840, 118, 621, 39, offers); // Name y + 49
		setBounds(48841, 51, 644, 40, offers); // Price y + 48
		setBounds(48842, 118, 634, 41, offers); // sold y + 49

		setBounds(48844, 118, 668, 42, offers); // Name y + 49
		setBounds(48845, 51, 691, 43, offers); // Price y + 48
		setBounds(48846, 118, 681, 44, offers); // sold y + 49

		setBounds(48847, 35, 2, 45, offers);

		offers.scrollMax = 710;
		offers.width = 203;
		offers.height = 181;
	}

	public static void offer(TextDrawingArea[] tda) {

		RSInterface rsi = addTabInterface(48500);
		addOffer(48501);
		rsi.totalChildren(1);
		rsi.child(0, 48501, 16, 8);
	}

	public static void addOffer(int index) {
		RSInterface rsi = interfaceCache[index] = new RSInterface();
		rsi.actions = new String[10];
		rsi.spritesX = new int[20];
		rsi.invStackSizes = new int[30];
		rsi.inv = new int[30];
		rsi.spritesY = new int[20];

		rsi.children = new int[0];
		rsi.childX = new int[0];
		rsi.childY = new int[0];

		rsi.actions[0] = "Offer 1";
		rsi.actions[1] = "Offer 5";
		rsi.actions[2] = "Offer 10";
		rsi.actions[3] = "Offer All";
		rsi.actions[4] = "Offer X";
		rsi.centerText = true;
		rsi.aBoolean227 = false;
		rsi.aBoolean235 = false;
		rsi.usableItemInterface = false;
		rsi.isInventoryInterface = false;
		rsi.aBoolean259 = true;
		rsi.textShadow = false;
		rsi.invSpritePadX = 10;
		rsi.invSpritePadY = 4;
		rsi.height = 7;
		rsi.width = 4;
		rsi.parentID = 48501;
		rsi.id = 48500;
		rsi.type = 2;
	}

	public static void tradingSelected(TextDrawingArea[] tda) {
		RSInterface Interface = addTabInterface(48598);
		RSInterface history = addTabInterface(48635);
		RSInterface offers = addTabInterface(48960);

		addSprite(48601, 7, "trading/sprite");
		addHover(48602, 3, 0, 48603, 1, "bank/bank", 17, 17, "Close Window");
		addHovered(48603, 2, "bank/bank", 17, 17, 48604);

		addText(48605, "Trading Post", 0xff9933, true, true, -1, tda, 2);

		addText(48606, "Coffer", 0xff9933, true, true, -1, tda, 2);
		addHoverButton(48607, "trading/sprite", 8, 143, 35, "Claim money", 0, 48608, 1);
		addHoveredButton(48608, "trading/sprite", 9, 143, 35, 48609);
		addText(48610, "100,000 GP", 0xff9933, true, true, -1, tda, 0);

		addText(48611, "Search for...", 0xff9933, true, true, -1, tda, 2);
		addHoverButton(48612, "trading/sprite", 10, 72, 32, "Search for a item", 0, 48613, 1);
		addHoveredButton(48613, "trading/sprite", 11, 72, 32, 48614);

		addHoverButton(48615, "trading/sprite", 10, 72, 32, "Search for a player", 0, 48616, 1);
		addHoveredButton(48616, "trading/sprite", 11, 72, 32, 48617);

		addHoverButton(48618, "trading/sprite", 10, 72, 32, "Recent offers", 0, 48619, 1);
		addHoveredButton(48619, "trading/sprite", 11, 72, 32, 48620);

		addHoverButton(48621, "trading/sprite", 12, 150, 35, "Click", 0, 48622, 1);
		addHoveredButton(48622, "trading/sprite", 13, 150, 35, 48623);

		addText(48624, "History", 0xff9933, true, true, -1, tda, 2);
		addText(48625, "My Offers...", 0xff9933, true, true, -1, tda, 2);

		addText(48626, "Item", 0xff9933, true, true, -1, tda, 2);
		addText(48627, "Player", 0xff9933, true, true, -1, tda, 2);
		addText(48628, "Recent", 0xff9933, true, true, -1, tda, 2);
		addText(48629, "Cancel Listing", 0xff9933, true, true, -1, tda, 2);

		setChildren(25, Interface);

		setBounds(48601, 8, 10, 0, Interface); // Base
		setBounds(48602, 471, 18, 1, Interface); // Close
		setBounds(48603, 471, 18, 2, Interface);

		setBounds(48605, 262, 20, 3, Interface); // Title

		setBounds(48606, 40, 50, 4, Interface); // Coffer text
		setBounds(48607, 19, 68, 5, Interface); // Coffer Button
		setBounds(48608, 19, 68, 6, Interface);
		setBounds(48610, 75, 80, 7, Interface); // Amount in coffer

		setBounds(48611, 59, 250, 8, Interface); // Text search for...
		setBounds(48612, 19, 270, 9, Interface); // Item Button
		setBounds(48613, 19, 270, 10, Interface);

		setBounds(48615, 96, 270, 11, Interface); // Player Button
		setBounds(48616, 96, 270, 12, Interface);

		setBounds(48618, 173, 270, 13, Interface); // Recent Button
		setBounds(48619, 173, 270, 14, Interface);

		setBounds(48621, 293, 270, 15, Interface); // Long button
		setBounds(48622, 293, 270, 16, Interface);

		setBounds(48624, 42, 104, 17, Interface); // Text History
		setBounds(48625, 289, 50, 18, Interface); // TextMy offers

		setBounds(48626, 55, 279, 19, Interface); // Text Item
		setBounds(48627, 132, 279, 20, Interface); // Text Player
		setBounds(48628, 208, 279, 21, Interface); // Text Recent
		setBounds(48629, 367, 279, 22, Interface); // Text List

		setBounds(48635, 30, 128, 23, Interface); // Interface history
		setBounds(48960, 260, 75, 24, Interface); // Interface my offers

		setChildren(20, history);
		for (int i = 48636, y = 5, id = 0; i < 48656; i++) {
			addText(i, "", 0xff9933, true, true, -1, tda, 0);
			setBounds(i, 94, y, id, history);
			if (id == 1 || id == 3 || id == 5 || id == 7 || id == 9 || id == 11 || id == 13 || id == 15 || id == 17)
				y += 20;
			else
				y += 10;
			id++;
		}

		history.scrollMax = 300;
		history.width = 193;
		history.height = 116;

		addSprite(48961, 14, "trading/sprite");
		addItemOnInterface(48962);
		addText(48963, "", 0xff9933, true, true, -1, tda, 2);
		addText(48964, "", 0xff9933, true, true, -1, tda, 1);
		addText(48965, "", 0xff9933, true, true, -1, tda, 1);
		addText(48966, "", 0xff9933, true, true, -1, tda, 0); // Guide: 50M
		addText(48967, "", 0xff9933, true, true, -1, tda, 0); // Listed: 0

		addHoverButton(48968, "trading/sprite", 10, 72, 32, "Set price", 0, 48969, 1);
		addHoveredButton(48969, "trading/sprite", 11, 72, 32, 48970);

		// addHoverButton(48971, "trading/sprite", 10, 72, 32, "Set quantity", 0, 48972,
		// 1);
		// addHoveredButton(48972, "trading/sprite", 11, 72, 32, 48973);

		addHoverButton(48974, "trading/sprite", 10, 72, 32, "Confirm offer", 0, 48975, 1);
		addHoveredButton(48975, "trading/sprite", 11, 72, 32, 48976);

		addText(48977, "Set", 0xff9933, true, true, -1, tda, 2);
		addText(48978, "price", 0xff9933, true, true, -1, tda, 2);
		// addText(48979, "Set", 0xff9933, true, true, -1, tda, 2);
		// addText(48980, "quantity", 0xff9933, true, true, -1, tda, 2);
		addText(48981, "Confirm", 0xff9933, true, true, -1, tda, 2);

		setChildren(14, offers);

		setBounds(48961, 0, 0, 0, offers); // background
		setBounds(48962, 91, 11, 1, offers); // item
		setBounds(48963, 108, 50, 2, offers); // name
		setBounds(48964, 108, 70, 3, offers); // price ea
		setBounds(48965, 108, 85, 4, offers); // quantity
		setBounds(48966, 175, 5, 5, offers); // guide
		setBounds(48967, 175, 20, 6, offers); // listed

		setBounds(48968, 72, 105, 7, offers); // Set price button
		setBounds(48969, 72, 105, 8, offers);

		// setBounds(48971, 114, 105, 9, offers); //Set quantity button
		// setBounds(48972, 114, 105, 10, offers);

		setBounds(48974, 72, 142, 9, offers); // confirm button
		setBounds(48975, 72, 142, 10, offers);

		setBounds(48977, 107, 108, 11, offers); // set
		setBounds(48978, 107, 118, 12, offers); // price
		// setBounds(48979, 149, 108, 13, offers); //set
		// setBounds(48980, 149, 118, 14, offers); //quantity

		setBounds(48981, 107, 151, 13, offers); // confirm

		// offers.scrollMax = 300;
		offers.width = 219;
		offers.height = 181;
	}

	public static void addItemOnInterface(int i) {
		RSInterface rsinterface = interfaceCache[i] = new RSInterface();
		rsinterface.actions = new String[5];
		rsinterface.spritesX = new int[20];
		rsinterface.invStackSizes = new int[30];
		rsinterface.inv = new int[30];
		rsinterface.spritesY = new int[20];
		rsinterface.children = new int[0];
		rsinterface.childX = new int[0];
		rsinterface.childY = new int[0];
		rsinterface.spritesY[0] = 0;
		// rsinterface.invStackSizes[0] = 0;
		for (int i2 = 0; i2 < 30; i2++)
			rsinterface.invStackSizes[i2] = 0;
		rsinterface.inv[0] = 0;
		rsinterface.spritesX[0] = 0;
		rsinterface.actions[0] = "Cancel";
		rsinterface.centerText = false;
		rsinterface.aBoolean227 = false;
		rsinterface.aBoolean235 = false;
		rsinterface.usableItemInterface = false;
		rsinterface.isInventoryInterface = false;
		rsinterface.aBoolean259 = false;
		rsinterface.textShadow = false;
		rsinterface.width = 6;
		rsinterface.mOverInterToTrigger = -1;
		rsinterface.invSpritePadX = 24;
		rsinterface.parentID = i;
		rsinterface.invSpritePadY = 24;
		rsinterface.type = 2;
		rsinterface.height = 5;
	}

	public static void listings(TextDrawingArea[] tda) {
		RSInterface Interface = addTabInterface(48000);
		RSInterface main = addTabInterface(48020);

		setChildren(18, Interface);
		addSprite(48001, 0, "trading/sprite");

		addHover(48002, 3, 0, 48003, 1, "bank/bank", 17, 17, "Close Window");
		addHovered(48003, 2, "bank/bank", 17, 17, 48004);
		addHoverButton(48005, "trading/sprite", 1, 88, 30, "Go back", 0, 48006, 1);
		addHoveredButton(48006, "trading/sprite", 2, 88, 30, 48007);
		addHoverButton(48008, "trading/sprite", 10, 72, 35, "Prev Page", 0, 48009, 1);
		addHoveredButton(48009, "trading/sprite", 11, 72, 35, 48010);
		addHoverButton(48011, "trading/sprite", 10, 72, 35, "Next Page", 0, 48012, 1);
		addHoveredButton(48012, "trading/sprite", 11, 72, 35, 48013); // 48045

		addText(48046, "Prev Page", 0xff9933, true, true, -1, tda, 1);
		addText(48047, "Next Page", 0xff9933, true, true, -1, tda, 1);

		addText(48014, "Quantity", tda, 0, 0xff981f, false, false);
		addText(48015, "Name", tda, 0, 0xff981f, false, false);
		addText(48016, "Price", tda, 0, 0xff981f, false, false);
		addText(48017, "Seller", tda, 0, 0xff981f, false, false);
		addText(48018, "Total Sold", tda, 0, 0xff981f, false, false);
		// addText(48019, "Title", tda, 2, 0xff981f, true, true);
		addText(48019, "Trading post", 0xff9933, true, true, -1, tda, 2); // 262, 20

		setBounds(48001, 9, 2, 0, Interface);
		setBounds(48002, 471, 12, 1, Interface); // Close
		setBounds(48003, 471, 12, 2, Interface);
		setBounds(48005, 19, 281, 3, Interface); // Go back
		setBounds(48006, 19, 281, 4, Interface);
		setBounds(48008, 331, 281, 5, Interface); // Modify
		setBounds(48009, 331, 281, 6, Interface);
		setBounds(48011, 413, 281, 7, Interface); // Refresh
		setBounds(48012, 413, 281, 8, Interface);

		setBounds(48014, 23, 42, 9, Interface); // Quantity
		setBounds(48015, 117, 42, 10, Interface); // Name
		setBounds(48016, 217, 42, 11, Interface); // Price
		setBounds(48017, 317, 42, 12, Interface); // Seller
		setBounds(48018, 414, 42, 13, Interface); // Total sold
		setBounds(48019, 262, 12, 14, Interface); // Titel
		setBounds(48020, 21, 50, 15, Interface); // Scroll

		setBounds(48046, 366, 288, 16, Interface); // Prev page
		setBounds(48047, 449, 288, 17, Interface); // Next Page

		addListing(48021, true);
		for (int i = 48022; i < 48046; i++) {
			addText(i, "", tda, 0, 0xff981f, true, false);
		}
		/*
		 * addItemOnInterface(28021); addText(28022, "Abyssal whip", tda, 0, 0xff981f,
		 * true, false); addText(28023, "100,000", tda, 0, 0xff981f, true, false);
		 * addText(28024, "Nighel", tda, 0, 0xff981f, true, false); addTextButton(28025,
		 * "Buy", "Buy", 0xFF981F, false, true, tda, 0, 400);
		 * 
		 * addItemOnInterface(28026); addText(28027, "Granite maul", tda, 0, 0xff981f,
		 * true, false); addText(28028, "10,000", tda, 0, 0xff981f, true, false);
		 * addText(28029, "Leroy the noob", tda, 0, 0xff981f, true, false);
		 * addTextButton(28030, "Buy", "Buy", 0xFF981F, false, true, tda, 0, 400);
		 */

		setChildren(25, main);

		setBounds(48021, 5, 10, 0, main); // Item

		setBounds(48022, 109, 20, 1, main); // Name
		setBounds(48023, 210, 20, 2, main); // Amount
		setBounds(48024, 310, 20, 3, main); // Seller
		setBounds(48025, 418, 20, 4, main); // Buy

		setBounds(48026, 109, 59, 5, main); // Name
		setBounds(48027, 210, 59, 6, main); // Amount
		setBounds(48028, 310, 59, 7, main); // Seller
		setBounds(48029, 418, 59, 8, main); // Buy

		setBounds(48030, 109, 95, 9, main); // Name
		setBounds(48031, 210, 95, 10, main); // Amount
		setBounds(48032, 310, 95, 11, main); // Seller
		setBounds(48033, 418, 95, 12, main); // Buy

		setBounds(48034, 109, 131, 13, main); // Name
		setBounds(48035, 210, 131, 14, main); // Amount
		setBounds(48036, 310, 131, 15, main); // Seller
		setBounds(48037, 418, 131, 16, main); // Buy

		setBounds(48038, 109, 170, 17, main); // Name
		setBounds(48039, 210, 170, 18, main); // Amount
		setBounds(48040, 310, 170, 19, main); // Seller
		setBounds(48041, 418, 170, 20, main); // Buy

		setBounds(48042, 109, 204, 21, main); // Name
		setBounds(48043, 210, 204, 22, main); // Amount
		setBounds(48044, 310, 204, 23, main); // Seller
		setBounds(48045, 418, 204, 24, main); // Buy

		main.width = 445;
		main.height = 227;
	}

	public static void addListing(int index, boolean search) {
		RSInterface rsi = interfaceCache[index] = new RSInterface();
		rsi.actions = new String[10];
		rsi.spritesX = new int[20];
		rsi.invStackSizes = new int[30];
		rsi.inv = new int[30];
		rsi.spritesY = new int[20];

		rsi.children = new int[0];
		rsi.childX = new int[0];
		rsi.childY = new int[0];
		if (!search)
			rsi.actions[0] = "Cancel";
		else {
			rsi.actions[0] = "Buy 1";
			rsi.actions[1] = "Buy 5";
			rsi.actions[2] = "Buy 10";
			rsi.actions[3] = "Buy All";
			rsi.actions[4] = "Buy X";
		}
		rsi.centerText = true;
		rsi.aBoolean227 = false;
		rsi.aBoolean235 = false;
		rsi.usableItemInterface = false;
		rsi.isInventoryInterface = false;
		rsi.aBoolean259 = true;
		rsi.textShadow = false; // 42, 82
		if (!search) {
			rsi.invSpritePadX = 0;
			rsi.invSpritePadY = 15;
		} else {
			rsi.invSpritePadX = 0;
			rsi.invSpritePadY = 5;
		}
		if (!search)
			rsi.height = 15;
		else
			rsi.height = 8;
		rsi.width = 1;
		rsi.parentID = index + 1;
		rsi.id = index;
		rsi.type = 2;
	}

	public static void groundItemCustomizing(TextDrawingArea[] tda) {
		RSInterface r = addInterface(37700);
		addSprite(37701, 2, "interfaces/grounditems/image");// they got saved as jpgs, need 2 convert lol il plz do
		addText(37702, "Ground items customizer", tda, 2, 0xFE9624, true, true);
		addHoverButton(37703, "interfaces/grounditems/image", 0, 16, 16, "Close", -1, 37704, 3);
		addHoveredButton(37704, "interfaces/grounditems/image", 1, 16, 16, 37705);
		addButton(37706, 4, "interfaces/grounditems/image", "Choose color");
		addText(37707, "Choose a color below!", tda, 2, 0xffffff, true, true);
		addButton(37708, 3, "interfaces/grounditems/image", "Enter Item Name");
		addText(37709, "Set Color To Item", tda, 0, 0xFE9624, true, true);
		addButton(37710, 3, "interfaces/grounditems/image", "Enter Minimum Item Value");
		addText(37711, "Enter Min. Value", tda, 0, 0xFE9624, true, true);
		addButton(37712, 3, "interfaces/grounditems/image", "Reset All Item Colors");
		addText(37713, "Reset All Colors", tda, 0, 0xFE9624, true, true);
		r.totalChildren(12);
		r.child(0, 37701, 130, 75);// opn skype need 2 send u some imgs
		r.child(1, 37702, 245, 85);
		r.child(2, 37703, 334, 85);
		r.child(3, 37704, 334, 85);
		r.child(4, 37706, 137, 215);
		r.child(5, 37707, 240, 195);
		r.child(6, 37708, 150, 120);
		r.child(7, 37709, 192, 125);
		r.child(8, 37710, 250, 120);
		r.child(9, 37711, 292, 125);
		r.child(10, 37712, 150, 150);
		r.child(11, 37713, 192, 155);
	}

	public static void helpDatabaseComponent(TextDrawingArea[] tda) {
		RSInterface widget = addInterface(59550);
		addSprite(59551, 8, "interfaces/helpinterface/image");
		addHoverButton(59552, "interfaces/helpinterface/image", 2, 16, 16, "Close", -1, 59553, 3);
		addHoveredButton(59553, "interfaces/helpinterface/image", 3, 16, 16, 59554);
		addText(59555, "Bug Database", tda, 2, 0xFF981F, true, true);
		addText(59556, "Username/Date", tda, 1, 0xFF981F, false, true);
		addText(59557, "Line2", tda, 1, 0xFF981F, true, true);
		addText(59558, "Line3", tda, 1, 0xFF981F, true, true);
		addText(59559, "Line4", tda, 1, 0xFF981F, true, true);
		addText(59560, "Line5", tda, 1, 0xFF981F, true, true);

		setChildren(10, widget);
		setBounds(59551, 0, 2, 0, widget);
		setBounds(59552, 375, 8, 1, widget);
		setBounds(59553, 375, 8, 2, widget);
		setBounds(59570, 120, 30, 3, widget);
		setBounds(59555, 256, 8, 4, widget);
		setBounds(59556, 20, 225, 5, widget);
		setBounds(59557, 256, 245, 6, widget);
		setBounds(59558, 256, 265, 7, widget);
		setBounds(59559, 256, 285, 8, widget);
		setBounds(59560, 256, 305, 9, widget);

		RSInterface scroll = addInterface(59570);
		scroll.scrollMax = 400;
		scroll.width = 255;
		scroll.height = 170;
		setChildren(60, scroll);

		int yPosition = 0;
		int index = 0;
		for (int i = 0; i < 80; i += 4) {
			addText(59573 + i, "", tda, 1, 0xFF981F, false, true);
			addButton(59574 + i, 10, "interfaces/helpinterface/image", 13, 10, "View Request", 1);
			addButton(59575 + i, 9, "interfaces/helpinterface/image", 16, 15, "Remove Request", 1);
			setBounds(59573 + i, 4, yPosition + 3, index++, scroll);
			setBounds(59574 + i, 225, yPosition + 5, index++, scroll);
			setBounds(59575 + i, 240, yPosition + 3, index++, scroll);
			yPosition += 20;
		}
	}

	private static void barrowsKillcount(TextDrawingArea[] tda) {
		RSInterface barrow = addInterface(27500);
		addText(27501, "Brothers", tda, 2, 0xFD851A, true, true);
		addText(27502, "Ahrim", tda, 0, 0xFD851A, true, true);
		addText(27503, "Dharok", tda, 0, 0xFD851A, true, true);
		addText(27504, "Guthan", tda, 0, 0xFD851A, true, true);
		addText(27505, "Karil", tda, 0, 0xFD851A, true, true);
		addText(27506, "Torag", tda, 0, 0xFD851A, true, true);
		addText(27507, "Verac", tda, 0, 0xFD851A, true, true);
		addText(27508, "Killcount", tda, 2, 0xFD851A, true, true);
		addText(27509, "0", tda, 0, 0xFD851A, true, true);
		setChildren(9, barrow);
		setBounds(27501, 470, 42, 0, barrow);
		for (int index = 1; index < 7; index++)
			setBounds(27501 + index, 470, 45 + index * 14, index, barrow);
		setBounds(27508, 470, 15, 7, barrow);
		setBounds(27509, 470, 30, 8, barrow);
	}

	private static final void addStaffSpecialWidget() {
		RSInterface magic = interfaceCache[328];
		RSInterface spec = addInterface(28500);
		setChildren(magic.children.length + 1, spec);
		spec.children[0] = 7800;
		spec.childX[0] = 22;
		spec.childY[0] = 202;
		for (int i = 0; i < magic.children.length; i++) {
			spec.children[1 + i] = magic.children[i];
			spec.childX[1 + i] = magic.childX[i];
			spec.childY[1 + i] = magic.childY[i];
		}
	}

	public static void pointCounter(TextDrawingArea[] tda) {
		RSInterface widget = addInterface(42300);
		setChildren(1, widget);
		addText(42302, "Points:", tda, 0, 0xFD851A, false, true);
		setBounds(42302, 15, 28, 0, widget);
	}

	public static void ironmanWidget(TextDrawingArea[] tda) {
		RSInterface widget = addInterface(42400);
		addSprite(42401, 1, "interfaces/ironman/image");
		addClickableSprites(42402, "Toggle", "interfaces/ironman/image", 2, 3, 4);
		addClickableSprites(42403, "Toggle", "interfaces/ironman/image", 2, 3, 4);
		addClickableSprites(42404, "Toggle", "interfaces/ironman/image", 2, 3, 4);
		addClickableSprites(42423, "Toggle", "interfaces/ironman/image", 2, 3, 4);

		addClickableSprites(42405, "Toggle", "interfaces/ironman/image", 2, 3, 4);
		addClickableSprites(42406, "Toggle", "interfaces/ironman/image", 2, 3, 4);
		addText(42407,
				"An Iron Man does not receive items or assistance from other players.\\n"
						+ "They cannot trade, stake, receive PK loot, nor scavenge dropped items.",
				tda, 0, 0xFD851A, false, true);
		addText(42408, "In addition, an Ultimate Iron Man cannot use banks.", tda, 0, 0xFD851A, false, true);
		addText(42409, "No Iron Man restrictions will apply to this account.", tda, 0, 0xFD851A, false, true);
		addText(42424, "    Hardcore Iron Man accounts only have 1 life.",tda, 0, 0xFD851A, false, true);
		addText(42410, "You must talk to an npc that will reset your mode after a seven day\\n" + "delay.", tda, 0,
				0xFD851A, false, true);
		addText(42411, "The Iron Man restrictions can never be removed.", tda, 0, 0xFD851A, false, true);
		addText(42412, "Standard Iron Man", tda, 0, 0xFFFFFF, false, true);
		addText(42413, "Ultimate Iron Man", tda, 0, 0xFFFFFF, false, true);
		addText(42422, "Hardcore Iron Man", tda, 0, 0xFFFFFF, false, true);
		addText(42414, "None", tda, 0, 0xFFFFFF, false, true);
		addText(42415, "NPC", tda, 0, 0xFFFFFF, false, true);
		addText(42416, "Permanent", tda, 0, 0xFFFFFF, false, true);

		addText(42417, "Iron Man Mode", tda, 1, 0xFFFFFF, false, true);
		addText(42418, "After Selection...", tda, 1, 0xFFFFFF, false, true);
		addHoverButton(42419, "interfaces/ironman/image", 5, 23, 23, "Confirm and Continue", 0, 42420, 1);
		addHoveredButton(42420, "interfaces/ironman/image", 6, 23, 23, 42421);

		setChildren(23, widget);

		setBounds(42401, 15, 28, 0, widget);

		setBounds(42402, 30, 104, 1, widget); // Ironman toggle
		setBounds(42403, 30, 142, 2, widget); // Ult iron man toggle
		setBounds(42423, 30, 163, 21, widget); // OSRS Mode toggle
		setBounds(42404, 30, 185, 3, widget); // Reg mode toggle

		setBounds(42405, 110, 244, 4, widget);
		setBounds(42406, 110, 277, 5, widget);

		setBounds(42407, 50, 102, 6, widget); // Iron man text
		setBounds(42408, 50, 144, 7, widget); // Ult iron man text
		setBounds(42409, 86, 187, 8, widget); // Reg mode text
		setBounds(42424, 145, 165, 22, widget); // hcim mode text

		setBounds(42410, 130, 241, 9, widget);
		setBounds(42411, 194, 279, 10, widget);

		setBounds(42412, 50, 92, 11, widget); // Standard iron man
		setBounds(42413, 50, 130, 12, widget); // Ultimate iron man
		setBounds(42422, 50, 165, 20, widget); // OSRS Mode

		setBounds(42414, 50, 187, 13, widget);
		setBounds(42415, 130, 231, 14, widget);
		setBounds(42416, 130, 279, 15, widget);
		setBounds(42417, 174, 69, 16, widget);
		setBounds(42418, 250, 210, 17, widget);
		setBounds(42419, 465, 34, 18, widget);
		setBounds(42420, 465, 34, 19, widget);
	}

	public static void slayerInterface(TextDrawingArea[] tda) {
		RSInterface rsInterface = addInterface(41000);
		addSprite(41001, 1, "interfaces/slayerinterface/image");
		addHoverButton(41002, "interfaces/slayerinterface/image", 4, 16, 16, "Close window", 0, 41003, 1);
		addHoveredButton(41003, "interfaces/slayerinterface/image", 5, 16, 16, 41004);
		addHoverButton(41005, "", 0, 85, 20, "Buy", 0, 41006, 1);
		addHoverButton(41007, "", 0, 85, 20, "Learn", 0, 41008, 1);
		addHoverButton(41009, "", 0, 85, 20, "Assignment", 0, 41010, 1);
		addText(41011, "Slayer Points: ", tda, 3, 0xFF981F);
		addTextButton(41012, "Slayer Experience						   (50)", "Buy Slayer Experience", 0xFF981F, false,
				true, tda, 1, 400);
		addTextButton(41013, "Slayer's Respite							  (25)", "Buy Slayer's Respite", 0xFF981F,
				false, true, tda, 1, 401);
		addTextButton(41014, "Slayer Darts									  (35)", "Buy Slayer Darts", 0xFF981F,
				false, true, tda, 1, 402);
		addTextButton(41015, "Broad Arrows									(25)", "Buy Broad Arrows", 0xFF981F, false,
				true, tda, 1, 403);
		addTextButton(41016, "Imbue Slayer Helmet					   (No cost)", "Imbue Slayer Helmet", 0xFF981F,
				false, true, tda, 1, 406);
		addTextButton(41017, "Extend Boss Tasks					   (100)", "Extend Boss Tasks", 0xFF981F, false, true,
				tda, 1, 407);
		addTextButton(41018, "Recolor Slayer Helmet", "Recolor Slayer Helmet", 0xFF981F, false, true, tda, 1, 408);
		setChildren(14, rsInterface);
		rsInterface.child(0, 41001, 12, 10);
		rsInterface.child(1, 41002, 473, 20);
		rsInterface.child(2, 41003, 473, 20);
		rsInterface.child(3, 41005, 21, 23);
		rsInterface.child(4, 41007, 107, 23);
		rsInterface.child(5, 41009, 193, 23);
		rsInterface.child(6, 41011, 98, 74);
		rsInterface.child(7, 41012, 67, 120);
		rsInterface.child(8, 41013, 67, 145);
		rsInterface.child(9, 41014, 67, 170);
		rsInterface.child(10, 41015, 67, 195);
		rsInterface.child(11, 41016, 68, 220);
		rsInterface.child(12, 41017, 68, 245);
		rsInterface.child(13, 41018, 68, 270);

	}

	public static void slayerInterfaceSub1(TextDrawingArea[] tda) {
		RSInterface rsInterface = addInterface(41500);
		addSprite(41501, 2, "interfaces/slayerinterface/image");
		addHoverButton(41502, "interfaces/slayerinterface/image", 4, 16, 16, "Close window", 0, 41503, 1);
		addHoveredButton(41503, "interfaces/slayerinterface/image", 5, 16, 16, 41504);
		addHoverButton(41505, "", 0, 85, 20, "Buy", 0, 41506, 1);
		addHoverButton(41507, "", 0, 85, 20, "Learn", 0, 41508, 1);
		addHoverButton(41509, "", 0, 85, 20, "Assignment", 0, 41510, 1);
		addText(41511, "Slayer Points: ", tda, 3, 0xFF981F);
		addTextButton(41512, "Learn how to create slayer helmet								   (350)", "Learn",
				0xFF981F, false, true, tda, 1, 404);
		addTextButton(41513, "Learn how to create slayer helmet (imbued)				  (150)", "Learn", 0xFF981F,
				false, true, tda, 1, 405);
		addTextButton(41514, "Learn how to encounter Superior Slayer NPCS				  (250)", "Learn", 0xFF981F,
				false, true, tda, 1, 406);
		setChildren(10, rsInterface);
		rsInterface.child(0, 41501, 12, 10);
		rsInterface.child(1, 41502, 473, 20);
		rsInterface.child(2, 41503, 473, 20);
		rsInterface.child(3, 41505, 21, 23);
		rsInterface.child(4, 41507, 107, 23);
		rsInterface.child(5, 41509, 193, 23);
		rsInterface.child(6, 41511, 98, 74);
		rsInterface.child(7, 41512, 67, 120);
		rsInterface.child(8, 41513, 67, 145);
		rsInterface.child(9, 41514, 67, 170);
	}

	public static void slayerInterfaceSub2(TextDrawingArea[] tda) {
		RSInterface rsInterface = addInterface(42000);
		addSprite(42001, 3, "interfaces/slayerinterface/image");
		addHoverButton(42002, "interfaces/slayerinterface/image", 4, 16, 16, "Close window", 0, 42003, 1);
		addHoveredButton(42003, "interfaces/slayerinterface/image", 5, 16, 16, 42004);
		addHoverButton(42005, "", 0, 85, 20, "Buy", 0, 42006, 1);
		addHoverButton(42007, "", 0, 85, 20, "Learn", 0, 42008, 1);
		addHoverButton(42009, "", 0, 85, 20, "Assignment", 0, 42010, 1);
		addText(42011, "Slayer Points: ", tda, 3, 0xFF981F);
		addTextButton(42012, "Cancel Task", "Temporarily cancel your current slayer task", 0xFF981F, false, true, tda,
				1, 300);
		addTextButton(42013, "Remove Task permanently", "Permanently remove this monster as a task", 0xFF981F, false,
				true, tda, 1, 305);
		addText(42014, "line 1", tda, 1, 0xFF981F);
		addText(42015, "line 2", tda, 1, 0xFF981F);
		addText(42016, "line 3", tda, 1, 0xFF981F);
		addText(42017, "line 4", tda, 1, 0xFF981F);
		addButton(42018, 6, "interfaces/slayerinterface/image", "Delete removed slayer task");
		addButton(42019, 6, "interfaces/slayerinterface/image", "Delete removed slayer task");
		addButton(42020, 6, "interfaces/slayerinterface/image", "Delete removed slayer task");
		addButton(42021, 6, "interfaces/slayerinterface/image", "Delete removed slayer task");
		setChildren(17, rsInterface);
		rsInterface.child(0, 42001, 12, 10);
		rsInterface.child(1, 42002, 473, 20);
		rsInterface.child(2, 42003, 473, 20);
		rsInterface.child(3, 42005, 21, 23);
		rsInterface.child(4, 42007, 107, 23);
		rsInterface.child(5, 42009, 193, 23);
		rsInterface.child(6, 42011, 98, 74);
		rsInterface.child(7, 42012, 71, 127);
		rsInterface.child(8, 42013, 71, 146);
		rsInterface.child(9, 42014, 71, 216);
		rsInterface.child(10, 42015, 71, 234);
		rsInterface.child(11, 42016, 71, 252);
		rsInterface.child(12, 42017, 71, 270);
		rsInterface.child(13, 42018, 303, 215);
		rsInterface.child(14, 42019, 303, 233);
		rsInterface.child(15, 42020, 303, 251);
		rsInterface.child(16, 42021, 303, 269);
	}

	public static void achievements(TextDrawingArea[] tda) {
		RSInterface rsi = addInterface(49000);
		addSprite(49001, 1, "interfaces/achievements/image");
		addHoverButton(49002, "interfaces/achievements/image", 15, 16, 16, "Close Window", -1, 49003, 3);
		addHoveredButton(49003, "interfaces/achievements/image", 16, 16, 16, 49004);
		addConfigButton(49005, 49000, 12, 20, "interfaces/achievements/image", 71, 29, "Tier Tier I", 1, 1, 800);
		addConfigButton(49006, 49000, 13, 20, "interfaces/achievements/image", 71, 29, "Tier Tier II", 1, 1, 801);
		addConfigButton(49007, 49000, 14, 20, "interfaces/achievements/image", 71, 29, "View Tier III", 1, 1, 802);
		addSprite(49014, 11, "interfaces/achievements/image");
		addText(49016, "1000", tda, 0, 0xff981f, true, true);
		addText(49017, "Tier I", tda, 0, 0xff981f, false, true);
		addText(49018, "Tier II", tda, 0, 0xff981f, false, true);
		addText(49019, "Tier III", tda, 0, 0xff981f, false, true);
		addText(49020, "100", tda, 0, 0xff981f, false, true);

		setChildren(14, rsi);
		setBounds(49001, 0, 0, 0, rsi);
		setBounds(49002, 490, 6, 1, rsi);
		setBounds(49003, 490, 6, 2, rsi);

		setBounds(49005, 15, 10, 3, rsi);
		setBounds(49006, 90, 10, 4, rsi);
		setBounds(49007, 165, 10, 5, rsi);

		setBounds(49014, 415, 14, 6, rsi);
		setBounds(49016, 443, 19, 7, rsi);
		setBounds(49017, 37, 19, 8, rsi);
		setBounds(49018, 111, 19, 9, rsi);
		setBounds(49019, 184, 19, 10, rsi);

		setBounds(49100, 3, 48, 11, rsi);
		setBounds(51100, 3, 48, 12, rsi);
		setBounds(53100, 3, 48, 13, rsi);

		RSInterface scroll = addInterface(49100);
		setChildren(800, scroll);
		scroll.scrollMax = 6502;
		scroll.height = 281;
		scroll.width = 486;
		int y = 0;
		for (int i = 0; i < 100; i++) {
			addSprite(49101 + i, 10, "interfaces/achievements/image");
			addSprite(49201 + i, 2, "interfaces/achievements/image");
			addSprite(49301 + i, 5, "interfaces/achievements/image");
			addText(49401 + i, "", tda, 2, 0xFFFFFF, true, true);
			addText(49501 + i, "", tda, 2, 0xFFFFFF, false, true);
			addText(49601 + i, "", tda, 2, 0x425619, false, true);
			addSprite(49701 + i, 6, "interfaces/achievements/image");
			addText(49801 + i, "0/1", tda, 1, 0xFFFFFF, true, true);
			setBounds(49101 + i, 1, y, i, scroll);
			setBounds(49201 + i, 8, y + 5, 100 + i, scroll);
			setBounds(49301 + i, 430, y + 12, 200 + i, scroll);
			setBounds(49401 + i, 448, y + 24, 300 + i, scroll);
			setBounds(49501 + i, 65, y + 9, 400 + i, scroll);
			setBounds(49601 + i, 65, y + 24, 500 + i, scroll);
			setBounds(49701 + i, 65, y + 41, 600 + i, scroll);
			setBounds(49801 + i, 160, y + 43, 700 + i, scroll);
			y += 65;
		}
		RSInterface tier2 = addInterface(51100);
		setChildren(800, tier2);
		tier2.scrollMax = 6502;
		tier2.height = 281;
		tier2.width = 486;
		y = 0;
		for (int i = 0; i < 100; i++) {
			addSprite(51101 + i, 10, "interfaces/achievements/image");
			addSprite(51201 + i, 3, "interfaces/achievements/image");
			addSprite(51301 + i, 5, "interfaces/achievements/image");
			addText(51401 + i, "", tda, 2, 0xFFFFFF, true, true);
			addText(51501 + i, "", tda, 2, 0xFFFFFF, false, true);
			addText(51601 + i, "", tda, 2, 0x425619, false, true);
			addSprite(51701 + i, 6, "interfaces/achievements/image");
			addText(51801 + i, "0/1", tda, 1, 0xFFFFFF, true, true);
			setBounds(51101 + i, 1, y, i, tier2);
			setBounds(51201 + i, 8, y + 5, 100 + i, tier2);
			setBounds(51301 + i, 430, y + 12, 200 + i, tier2);
			setBounds(51401 + i, 448, y + 24, 300 + i, tier2);
			setBounds(51501 + i, 65, y + 9, 400 + i, tier2);
			setBounds(51601 + i, 65, y + 24, 500 + i, tier2);
			setBounds(51701 + i, 65, y + 41, 600 + i, tier2);
			setBounds(51801 + i, 160, y + 43, 700 + i, tier2);
			y += 65;
		}
		RSInterface tier3 = addInterface(53100);
		setChildren(800, tier3);
		tier3.scrollMax = 6502;
		tier3.height = 281;
		tier3.width = 486;
		y = 0;
		for (int i = 0; i < 100; i++) {
			addSprite(53101 + i, 10, "interfaces/achievements/image");
			addSprite(53201 + i, 4, "interfaces/achievements/image");
			addSprite(53301 + i, 5, "interfaces/achievements/image");
			addText(53401 + i, "", tda, 2, 0xFFFFFF, true, true);
			addText(53501 + i, "", tda, 2, 0xFFFFFF, false, true);
			addText(53601 + i, "", tda, 2, 0x425619, false, true);
			addSprite(53701 + i, 6, "interfaces/achievements/image");
			addText(53801 + i, "0/1", tda, 1, 0xFFFFFF, true, true);
			setBounds(53101 + i, 1, y, i, tier3);
			setBounds(53201 + i, 8, y + 5, 100 + i, tier3);
			setBounds(53301 + i, 430, y + 12, 200 + i, tier3);
			setBounds(53401 + i, 448, y + 24, 300 + i, tier3);
			setBounds(53501 + i, 65, y + 9, 400 + i, tier3);
			setBounds(53601 + i, 65, y + 24, 500 + i, tier3);
			setBounds(53701 + i, 65, y + 41, 600 + i, tier3);
			setBounds(53801 + i, 160, y + 43, 700 + i, tier3);
			y += 65;
		}
	}

	/*
	 * public static void optionTab(TextDrawingArea[] tda) { RSInterface tab =
	 * addTabInterface(904); RSInterface energy = interfaceCache[149];
	 * energy.textColor = 0xff9933; addSprite(905, 9, "/options/sprite");
	 * addSprite(907, 18, "/options/sprite"); addSprite(909, 29, "/options/sprite");
	 * addSprite(951, 32, "/options/sprite"); addSprite(953, 33, "/options/sprite");
	 * addSprite(955, 34, "/options/sprite"); addSprite(947, 36, "/options/sprite");
	 * addSprite(949, 35, "/options/sprite"); addSprite(949, 35, "/options/sprite");
	 * // run button here addConfigButton(152, 904, 30, 31, "/options/sprite", 40,
	 * 40, "Toggle-run", 1, 5, 173); addConfigButton(906, 904, 10, 14,
	 * "/options/sprite", 32, 16, "Dark", 1, 5, 166); addConfigButton(908, 904, 11,
	 * 15, "/options/sprite", 32, 16, "Normal", 2, 5, 166); addConfigButton(910,
	 * 904, 12, 16, "/options/sprite", 32, 16, "Bright", 3, 5, 166);
	 * addConfigButton(912, 904, 13, 17, "/options/sprite", 32, 16, "Very Bright",
	 * 4, 5, 166); addConfigButton(930, 904, 19, 24, "/options/sprite", 26, 16,
	 * "Music Off", 4, 5, 168); addConfigButton(931, 904, 20, 25, "/options/sprite",
	 * 26, 16, "Music Level-1", 3, 5, 168); addConfigButton(932, 904, 21, 26,
	 * "/options/sprite", 26, 16, "Music Level-2", 2, 5, 168); addConfigButton(933,
	 * 904, 22, 27, "/options/sprite", 26, 16, "Music Level-3", 1, 5, 168);
	 * addConfigButton(934, 904, 23, 28, "/options/sprite", 24, 16, "Music Level-4",
	 * 0, 5, 168); addConfigButton(941, 904, 19, 24, "/options/sprite", 26, 16,
	 * "Sound Effects Off", 4, 5, 169); addConfigButton(942, 904, 20, 25,
	 * "/options/sprite", 26, 16, "Sound Effects Level-1", 3, 5, 169);
	 * addConfigButton(943, 904, 21, 26, "/options/sprite", 26, 16,
	 * "Sound Effects Level-2", 2, 5, 169); addConfigButton(944, 904, 22, 27,
	 * "/options/sprite", 26, 16, "Sound Effects Level-3", 1, 5, 169);
	 * addConfigButton(945, 904, 23, 28, "/options/sprite", 24, 16,
	 * "Sound Effects Level-4", 0, 5, 169); addConfigButton(913, 904, 30, 31,
	 * "/options/sprite", 40, 40, "Toggle-Orbs", 0, 5, 170); addConfigButton(915,
	 * 904, 30, 31, "/options/sprite", 40, 40, "Toggle-Chat Effects", 0, 5, 171);
	 * addConfigButton(957, 904, 30, 31, "/options/sprite", 40, 40,
	 * "Toggle-Split Private Chat", 1, 5, 287); addConfigButton(12464, 904, 30, 31,
	 * "/options/sprite", 40, 40, "Toggle-Accept Aid", 0, 5, 427); addButton(17255,
	 * 0, "/options/OTHER", ""); addConfigButton(19998, 904, 30, 31,
	 * "/options/sprite", 40, 40, "Toggle-Left Click Attack", 0, 4, 430);
	 * addSprite(19999, 37, "/options/sprite"); tab.totalChildren(31); int x = 0;
	 * int y = 2; tab.child(0, 905, 13 + x, 10 + y); tab.child(1, 906, 48 + x, 18 +
	 * y); tab.child(2, 908, 80 + x, 18 + y); tab.child(3, 910, 112 + x, 18 + y);
	 * tab.child(4, 912, 144 + x, 18 + y); tab.child(5, 907, 14 + x, 55 + y);
	 * tab.child(6, 930, 49 + x, 61 + y); tab.child(7, 931, 75 + x, 61 + y);
	 * tab.child(8, 932, 101 + x, 61 + y); tab.child(9, 933, 127 + x, 61 + y);
	 * tab.child(10, 934, 151 + x, 61 + y); tab.child(11, 909, 13 + x, 99 + y);
	 * tab.child(12, 941, 49 + x, 104 + y); tab.child(13, 942, 75 + x, 104 + y);
	 * tab.child(14, 943, 101 + x, 104 + y); tab.child(15, 944, 127 + x, 104 + y);
	 * tab.child(16, 945, 151 + x, 104 + y); tab.child(17, 913, 15, 153);
	 * tab.child(18, 955, 19, 159); tab.child(19, 915, 75, 153); tab.child(20, 953,
	 * 79, 160); tab.child(21, 957, 135, 153); tab.child(22, 951, 139, 159);
	 * tab.child(23, 12464, 15, 208); tab.child(24, 949, 20, 213); tab.child(25,
	 * 152, 75, 208); tab.child(26, 947, 87, 212); tab.child(27, 149, 80, 231);
	 * tab.child(28, 17255, 135, 208); tab.child(29, 19998, 135, 208); tab.child(30,
	 * 19999, 135, 208); }
	 */

	private static final void addGodwarsWidget(TextDrawingArea[] tda) {
		RSInterface godwars = addInterface(16210);
		setChildren(9, godwars);
		addText(16211, "NPC Killcount", tda, 0, 0xFD851A, false, true);
		addText(16212, "Armadyl", tda, 0, 0xFD851A, false, true);
		addText(16213, "Bandos", tda, 0, 0xFD851A, false, true);
		addText(16214, "Saradomin", tda, 0, 0xFD851A, false, true);
		addText(16215, "Zamorak", tda, 0, 0xFD851A, false, true);
		addText(16216, "0", tda, 0, 0x66FFFF, false, true);
		addText(16217, "0", tda, 0, 0x66FFFF, false, true);
		addText(16218, "0", tda, 0, 0x66FFFF, false, true);
		addText(16219, "0", tda, 0, 0x66FFFF, false, true);
		setBounds(16211, 400, 20, 0, godwars);
		for (int index = 1; index <= 4; index++) {
			setBounds(16211 + index, 400, 20 + index * 13, index, godwars);
		}
		for (int index = 1; index <= 4; index++) {
			setBounds(16215 + index, 480, 20 + index * 13, index + 4, godwars);
		}
	}

	public static void keybindingDropdown(int id, int width, int defaultOption, String[] options, Dropdown d,
			boolean inverted) {
		RSInterface widget = addInterface(id);
		widget.type = TYPE_KEYBINDS_DROPDOWN;
		widget.dropdown = new DropdownMenu(width, true, defaultOption, options, d);
		widget.atActionType = OPTION_DROPDOWN;
		widget.inverted = inverted;
	}

	public static void keybinding(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(53000);

		addSettingsSprite(53001, 63);
		addText(53002, "Keybinding", tda, 2, 0xff8a1f, false, true);
		closeButton(53003, 83, 84);

		hoverButton(Keybinding.RESTORE_DEFAULT, "Restore Defaults", 80, 81, "Restore Defaults", rsFont, 0xff8a1f,
				0xff8a1f, true);

		addText(53005, "Esc closes current interface", tda, 1, 0xff8a1f, false, true);
		configButton(Keybinding.ESCAPE_CONFIG, "Select", 62, 61);

		tab.totalChildren(48);
		int childNum = 0;

		setBounds(53001, 5, 17, childNum++, tab);
		setBounds(53002, 221, 27, childNum++, tab);
		setBounds(39021, 479, 24, childNum++, tab);
		setBounds(Keybinding.RESTORE_DEFAULT, 343, 275, childNum++, tab);
		setBounds(53005, 59, 284, childNum++, tab);
		setBounds(Keybinding.ESCAPE_CONFIG, 35, 285, childNum++, tab);

		/* Tabs and dropdowns */

		int x = 31;
		int y = 63;
		childNum = 47;

		for (int i = 0; i < 14; i++, y += 43) {

			addSettingsSprite(53007 + 3 * i, 64 + i);
			configButton(53008 + 3 * i, "", 79, 78);

			boolean inverted = i == 3 || i == 4 || i == 8 || i == 9 || i == 13;
			keybindingDropdown(53009 + 3 * i, 86, 0, Keybinding.OPTIONS, Dropdown.KEYBIND_SELECTION, inverted);

			setBounds(Keybinding.MIN_FRAME - 2 + 3 * i, x + stoneOffset(64 + i, true), y + stoneOffset(64 + i, false),
					childNum--, tab);
			setBounds(Keybinding.MIN_FRAME - 1 + 3 * i, x, y, childNum--, tab);
			setBounds(Keybinding.MIN_FRAME + 3 * i, x + 39, y + 4, childNum--, tab);

			if (i == 4 || i == 9) {
				x += 160;
				y = 20;
			}
		}
	}

	public static int stoneOffset(int spriteId, boolean xOffset) {
		Sprite stone = Client.cacheSprite3[79];
		Sprite icon = Client.cacheSprite3[spriteId];

		if (xOffset) {
			return (stone.myWidth / 2) - icon.myWidth / 2;
		}
		return (stone.myHeight / 2) - icon.myHeight / 2;
	}

	private static void optionsDisplayTab(TextDrawingArea[] tda) {
		 RSInterface tab = addTabInterface(23000);
		 
		 addSprite(962, 9,  "interfaces/options/sprite");
		 addConfigButton(906, 904, 10, 14, "interfaces/options/sprite", 32, 16, "Dark", 1, 5, 166);
		 addConfigButton(908, 904, 11, 15, "interfaces/options/sprite", 32, 16, "Normal", 2, 5, 166);
		 addConfigButton(910, 904, 12, 16, "interfaces/options/sprite", 32, 16, "Bright", 3, 5, 166);
		 addConfigButton(912, 904, 13, 17, "interfaces/options/sprite", 32, 16, "Very Bright", 4, 5, 166);
		 
		 addSprite(964, 60, "interfaces/options/sprite");
		 addConfigButton(916, 904, 10, 14, "interfaces/options/sprite", 32, 16, "Zoom In", 1, 5, 2166);
		 addConfigButton(918, 904, 11, 15, "interfaces/options/sprite", 32, 16, "Zoom In", 2, 5, 2166);
		 addConfigButton(920, 904, 12, 16, "interfaces/options/sprite", 32, 16, "Normal Zoom", 3, 5, 2166);
		 addConfigButton(922, 904, 13, 17, "interfaces/options/sprite", 32, 16, "Zoom Out", 4, 5, 2166);
		 
		 
		 addConfigButton(23001, 904, 49, 48, "interfaces/options/sprite", 62, 54, "Toggle Fixed Screen", 0, 5, 23001);
		 addSprite(23002, 45, "interfaces/options/sprite");
			 
		 addConfigButton(23003, 904, 49, 48, "interfaces/options/sprite", 62, 54, "Toggle Resizable Screen", 0, 5, 23003);
		 addSprite(23004, 46, "interfaces/options/sprite");
			 
		// addConfigButton(23005, 904, 49, 48, "interfaces/options/sprite", 62, 54, "Toggle Full Screen", 0, 5, 23005);
		 addSprite(23005, 54, "interfaces/options/sprite");
		 addHoverText(23006, "Advanced", "Advanced Options", tda, 1, 0xff9040,
					false, true, 73);
		// addSprite(23006, 54, "interfaces/options/sprite");
		 
		 
		 tab.totalChildren(17);
		 
		 tab.child(0, 904, 0, -3);
		 
		 
		 tab.child(1, 962, 9, 90);
		 tab.child(2, 906, 47, 100);
		 tab.child(3, 908, 79, 100);
		 tab.child(4, 910, 111, 100);
		 tab.child(5, 912, 143, 100);
		
		 tab.child(6, 23001, 28, 124);
		 tab.child(7, 23002, 32, 128);
				
		 tab.child(8, 23003, 100, 124);
		 tab.child(9, 23004, 104, 128);
				
		 tab.child(10, 23005, 40, 180);
		 tab.child(11, 23006, 66, 182);
		 
		 tab.child(12, 964, 9, 57);
		 tab.child(13, 916, 47, 68);
		 tab.child(14, 918, 79, 68);
		 tab.child(15, 920, 111, 68);
		 tab.child(16, 922, 143, 68);
	}
	
	private static void optionsControlTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(23100);
		 
		addConfigButton(23101, 904, 31, 30, "interfaces/options/sprite", 40, 40, "Toggle-Data Orbs", 0, 5, 23101);
		addSprite(23102, 42, "interfaces/options/sprite");
		 
		addConfigButton(23103, 904, 31, 30, "interfaces/options/sprite", 40, 40, "Toggle-Roof-removal", 0, 5, 23103);
		addSprite(23104, 43, "interfaces/options/sprite");
		 
		addConfigButton(23105, 904, 31, 30, "interfaces/options/sprite", 40, 40, "Toggle-Left Click Attack'", 0, 5, 23105);
		addSprite(23106, 34, "interfaces/options/sprite");
		
		//addConfigButton(23107, 904, 31, 30, "interfaces/options/sprite", 40, 40, "Toggle-Chat Effects", 0, 5, 23107);
		//addSprite(23108, 33, "interfaces/options/sprite");
		
		//addConfigButton(23109, 904, 31, 30, "interfaces/options/sprite", 40, 40, "Toggle-Split Private Chat", 0, 5, 23109);
		//addSprite(23110, 32, "interfaces/options/sprite");
		
		//addConfigButton(23111, 904, 31, 30, "interfaces/options/sprite", 40, 40, "Toggle-Game Timers", 0, 5, 23111);
		//addSprite(23112, 50, "interfaces/options/sprite");
		
		addConfigButton(23113, 904, 31, 30, "interfaces/options/sprite", 40, 40, "Toggle-Target tracking", 0, 5, 23113);
		addSprite(23114, 51, "interfaces/options/sprite");
		
		addConfigButton(23115, 904, 31, 30, "interfaces/options/sprite", 40, 40, "Toggle-Ground Item Names", 0, 5, 23115);
		addSprite(23116, 52, "interfaces/options/sprite");
		addConfigButton(23117, 904, 31, 30, "interfaces/options/sprite", 40, 40, "Configure", 0, 5, 23117);
		
		addConfigButton(23118, 904, 31, 30, "interfaces/options/sprite", 40, 40, "Toggle-Shift Drop", 0, 5, 23118);
		addSprite(23119, 53, "interfaces/options/sprite");
		
		tab.totalChildren(14);
		
		tab.child(0, 904, 0, -3);
		
		tab.child(1, 23101, 19, 56);
		tab.child(2, 23102, 23, 60);
			
		tab.child(3, 23103, 75, 56);
		tab.child(4, 23104, 79, 60);
			
		tab.child(5, 23105, 131, 56);
		tab.child(6, 23106, 135, 60);
		
		//tab.child(7, 23107, 19, 106);
		//tab.child(8, 23108, 23, 110);
		
		//tab.child(9, 23109, 75, 106);
		//tab.child(10, 23110, 79, 110);
		
		//tab.child(7, 23111, 131, 106);
		//tab.child(8, 23112, 137, 110);
		
		tab.child(7, 23113, 19, 156);
		tab.child(8, 23114, 19, 156);

		tab.child(9, 23117, 75, 156);
		tab.child(10, 23115, 75, 156);
		tab.child(11, 23116, 85, 163);
		tab.child(12, 23118, 131, 156);
		tab.child(13, 23119, 135, 161);
	}
	
	public static void optionsSoundTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(23200);
	
		addSprite(23201, 18, "interfaces/options/sprite");
		addConfigButton(23202, 906, 10, 14, "interfaces/options/sprite", 32, 16, "Mute", 1, 5, 166);
		addConfigButton(23203, 906, 11, 15, "interfaces/options/sprite", 32, 16, "Low", 2, 5, 166);
		addConfigButton(23204, 906, 12, 16, "interfaces/options/sprite", 32, 16, "Medium", 3, 5, 166);
		addConfigButton(23205, 906, 13, 17, "interfaces/options/sprite", 32, 16, "High", 4, 5, 166);
		
		
		tab.totalChildren(6);
		 
		 tab.child(0, 904, 0, -3);
		 
		 
		 tab.child(1, 23201, 9, 90);
		 tab.child(2, 23202, 47, 100);
		 tab.child(3, 23203, 79, 100);
		 tab.child(4, 23204, 111, 100);
		 tab.child(5, 23205, 143, 100);
		
	}
	
	public static void optionsChatTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(23300);
	
		addConfigButton(23301, 904, 31, 30, "interfaces/options/sprite", 40, 40, "Toggle-Chat Effects", 0, 5, 23301);
		addSprite(23302, 33, "interfaces/options/sprite");
		
		addConfigButton(23303, 904, 31, 30, "interfaces/options/sprite", 40, 40, "Toggle-Split Private Chat", 0, 5, 23303);
		addSprite(23304, 32, "interfaces/options/sprite");
		
		
		 tab.totalChildren(5);
		 
		 tab.child(0, 904, 0, -3);
		 
		 tab.child(1, 23301, 30, 70);
		 tab.child(2, 23302, 34, 74);
			
		 tab.child(3, 23303, 120, 70);
		 tab.child(4, 23304, 124, 74);
		
	}
	
	public static void slayerRewardsBuy(TextDrawingArea[] tda) {
		RSInterface rsi = addTab(25400);
		int j = 0;
		addSprite(25401, 1, "slayer/panel");
		addButton(25402, 0, "slayer/tab", "View", 27640, 1, 75, 23);
		addButton(25403, 1, "slayer/tab", "View", 27640, 1, 75, 23);
		addButton(25404, 1, "slayer/tab", "View", 27640, 1, 75, 23);
		addText(25405, "Buy", tda, 0, 0xff9040);
		addText(25406, "Learn", tda, 0, 0xff9040);
		addText(25407, "Assignment", tda, 0, 0xff9040);
		addText(25408, "Slayer Points : ", tda, 2, 0xff9040);
		addText(25409, "XXXX", tda, 2, 0xff9040);
		addHoverText(25510, "Close window", "Close window", tda, 1, 0xff9040, false, true, 73);
		addHoverText(25411, "Purchase slayer experience", "Slayer experience", tda, 1, 0xff9040, false, true, 205);
		addText(25412, "(50 Points)", tda, 0, 0xff9040);
		addHoverText(25413, "Purchase Slayer's Respite(4)", "Slayer's Respite(4)", tda, 1, 0xff9040, false, true, 205);
		addText(25414, "(25 Points)", tda, 0, 0xff9040);
		addHoverText(25415, "Purchase 250 Slayer dart casts", "Slayer dart casts", tda, 1, 0xff9040, false, true, 205);
		addText(25416, "(35 Points)", tda, 0, 0xff9040);
		addHoverText(25417, "Nothing yet!", "Nothing here!", tda, 1, 0xff9040, false, true, 205);
		addText(25418, "(35 Points)", tda, 0, 0xff9040);
		rsi.totalChildren(18);
		rsi.child(j, 25401, 10, 10);
		j++;
		rsi.child(j, 25402, 20, 20);
		j++;
		rsi.child(j, 25403, 98, 20);
		j++;
		rsi.child(j, 25404, 176, 20);
		j++;
		rsi.child(j, 25405, 40, 25);
		j++;
		rsi.child(j, 25406, 118, 25);
		j++;
		rsi.child(j, 25407, 186, 25);
		j++;
		rsi.child(j, 25408, 85, 75);
		j++;
		rsi.child(j, 25409, 200, 75);
		j++;
		rsi.child(j, 25510, 409, 20);
		j++;
		rsi.child(j, 25411, 161, 153);
		j++;
		rsi.child(j, 25412, 409, 157);
		j++;
		rsi.child(j, 25413, 161, 190);
		j++;
		rsi.child(j, 25414, 409, 194);
		j++;
		rsi.child(j, 25415, 161, 233);
		j++;
		rsi.child(j, 25416, 409, 237);
		j++;
		rsi.child(j, 25417, 161, 270);
		j++;
		rsi.child(j, 25418, 409, 274);
		j++;
	}

	public static void slayerRewardsLearn(TextDrawingArea[] tda) {
		RSInterface rsi = addTab(25200);
		int j = 0;
		addSprite(25201, 2, "slayer/panel");
		addButton(25202, 1, "slayer/tab", "View", 27640, 1, 75, 23);
		addButton(25203, 0, "slayer/tab", "View", 27640, 1, 75, 23);
		addButton(25204, 1, "slayer/tab", "View", 27640, 1, 75, 23);
		addText(25205, "Buy", tda, 0, 0xff9040);
		addText(25206, "Learn", tda, 0, 0xff9040);
		addText(25207, "Assignment", tda, 0, 0xff9040);
		addText(25208, "Slayer Points : ", tda, 2, 0xff9040);
		addText(25209, "XXXX", tda, 2, 0xff9040);
		addHoverText(25210, "Close window", "Close window", tda, 1, 0xff9040, false, true, 73);
		addHoverText(25211, "Unlock the ability to create a slayer helmet", "Unlock", tda, 1, 0xff9040, false, true,
				205);
		addText(25212, "(300 Points)", tda, 0, 0xff9040);
		addHoverText(25213, "Unlock the ability to create rings of slaying", "Unlock", tda, 1, 0xff9040, false, true,
				205);
		addText(25214, "(100 Points)", tda, 0, 0xff9040);
		rsi.totalChildren(14);
		rsi.child(j, 25201, 10, 10);
		j++;
		rsi.child(j, 25202, 20, 20);
		j++;
		rsi.child(j, 25203, 98, 20);
		j++;
		rsi.child(j, 25204, 176, 20);
		j++;
		rsi.child(j, 25205, 40, 25);
		j++;
		rsi.child(j, 25206, 118, 25);
		j++;
		rsi.child(j, 25207, 186, 25);
		j++;
		rsi.child(j, 25208, 85, 75);
		j++;
		rsi.child(j, 25209, 200, 75);
		j++;
		rsi.child(j, 25210, 409, 20);
		j++;
		rsi.child(j, 25211, 150, 165);
		j++;
		rsi.child(j, 25212, 409, 170);
		j++;
		rsi.child(j, 25213, 150, 225);
		j++;
		rsi.child(j, 25214, 409, 230);
		j++;
	}

	public static void slayerRewardsAssign(TextDrawingArea[] tda) {
		RSInterface rsi = addTab(25300);
		int j = 0;
		addSprite(25301, 3, "slayer/panel");
		addButton(25602, 1, "slayer/tab", "View", 27640, 1, 75, 23);
		addButton(25603, 1, "slayer/tab", "View", 27640, 1, 75, 23);
		addButton(25604, 0, "slayer/tab", "View", 27640, 1, 75, 23);
		addText(25305, "Buy", tda, 0, 0xff9040);
		addText(25306, "Learn", tda, 0, 0xff9040);
		addText(25307, "Assignment", tda, 0, 0xff9040);
		addText(25308, "Slayer Points : ", tda, 2, 0xff9040);
		addText(25309, "XXXX", tda, 2, 0xff9040);
		addHoverText(25310, "Close window", "Close window", tda, 1, 0xff9040, false, true, 73);
		addHoverText(25311, "Cancel your current task", "Cancel your current task", tda, 1, 0xff9040, false, true, 140);
		addText(25312, "(30 Points)", tda, 0, 0xff9040);
		addHoverText(25313, "Cancel and stop assigning current task", "Cancel task and stop it from being assigned",
				tda, 1, 0xff9040, false, true, 225);
		addText(25314, "(100 Points)", tda, 0, 0xff9040);
		addText(25315, "line 1", tda, 1, 0xFF981F);
		addText(25316, "line 2", tda, 1, 0xFF981F);
		addText(25317, "line 3", tda, 1, 0xFF981F);
		addText(25318, "line 4", tda, 1, 0xFF981F);
		addButton(25319, 6, "slayer/image", "Delete removed slayer task");
		addButton(25320, 6, "slayer/image", "Delete removed slayer task");
		addButton(25321, 6, "slayer/image", "Delete removed slayer task");
		addButton(25322, 6, "slayer/image", "Delete removed slayer task");
		rsi.totalChildren(22);
		rsi.child(j, 25301, 10, 10);
		j++;
		rsi.child(j, 25602, 20, 20);
		j++;
		rsi.child(j, 25603, 98, 20);
		j++;
		rsi.child(j, 25604, 176, 20);
		j++;
		rsi.child(j, 25305, 40, 25);
		j++;
		rsi.child(j, 25306, 118, 25);
		j++;
		rsi.child(j, 25307, 186, 25);
		j++;
		rsi.child(j, 25308, 85, 75);
		j++;
		rsi.child(j, 25309, 200, 75);
		j++;
		rsi.child(j, 25310, 409, 20);
		j++;
		rsi.child(j, 25311, 87, 130);
		j++;
		rsi.child(j, 25312, 409, 134);
		j++;
		rsi.child(j, 25313, 87, 150);
		j++;
		rsi.child(j, 25314, 409, 154);
		j++;
		rsi.child(j, 25315, 87, 205);
		j++;
		rsi.child(j, 25316, 87, 225);
		j++;
		rsi.child(j, 25317, 87, 245);
		j++;
		rsi.child(j, 25318, 87, 265);
		j++;
		rsi.child(j, 25319, 400, 205);
		j++;
		rsi.child(j, 25320, 400, 225);
		j++;
		rsi.child(j, 25321, 400, 245);
		j++;
		rsi.child(j, 25322, 400, 265);
		j++;
	}

	public static void clanChatSetup(TextDrawingArea[] tda) {
		RSInterface rsi = addInterface(18300);
		rsi.totalChildren(12 + 15);
		int count = 0;
		/* Background */
		addSprite(18301, 1, "/interfaces/clanchat/sprite");
		rsi.child(count++, 18301, 14, 18);
		/* Close button */
		addButton(18302, 0, "/interfaces/clanchat/close", "Close");
		interfaceCache[18302].atActionType = 3;
		rsi.child(count++, 18302, 475, 26);
		/* Clan Setup title */
		addText(18303, "Clan Setup", tda, 2, 0xFF981F, true, true);
		rsi.child(count++, 18303, 256, 26);
		/* Setup buttons */
		String[] titles = { "Clan name:", "Who can enter chat?", "Who can talk on chat?", "Who can kick on chat?",
				"Who can ban on chat?" };
		String[] defaults = { "Chat Disabled", "Anyone", "Anyone", "Anyone", "Anyone" };
		String[] whoCan = { "Anyone", "Recruit", "Corporal", "Sergeant", "Lieutenant", "Captain", "General",
				"Only Me" };
		for (int index = 0, id = 18304, y = 50; index < titles.length; index++, id += 3, y += 40) {
			addButton(id, 2, "/interfaces/clanchat/sprite", "");
			interfaceCache[id].atActionType = 0;
			if (index > 0) {
				interfaceCache[id].actions = whoCan;
			} else {
				interfaceCache[id].actions = new String[] { "Change title", "Delete clan" };
				;
			}
			addText(id + 1, titles[index], tda, 0, 0xFF981F, true, true);
			addText(id + 2, defaults[index], tda, 1, 0xFFFFFF, true, true);
			rsi.child(count++, id, 25, y);
			rsi.child(count++, id + 1, 100, y + 4);
			rsi.child(count++, id + 2, 100, y + 17);
		}
		/* Table */
		addSprite(18319, 5, "/interfaces/clanchat/sprite");
		rsi.child(count++, 18319, 197, 70);
		/* Labels */
		int id = 18320;
		int y = 74;
		addText(id, "Ranked Members", tda, 2, 0xFF981F, false, true);
		rsi.child(count++, id++, 202, y);
		addText(id, "Banned Members", tda, 2, 0xFF981F, false, true);
		rsi.child(count++, id++, 339, y);
		/* Ranked members list */
		RSInterface list = addInterface(id++);
		int lines = 100;
		list.totalChildren(lines);
		String[] ranks = { "Demote", "Recruit", "Corporal", "Sergeant", "Lieutenant", "Captain", "General", "Owner" };
		list.childY[0] = 2;
		// System.out.println(id);
		for (int index = id; index < id + lines; index++) {
			addText(index, "", tda, 1, 0xffffff, false, true);
			interfaceCache[index].actions = ranks;
			list.children[index - id] = index;
			list.childX[index - id] = 2;
			list.childY[index - id] = (index - id > 0 ? list.childY[index - id - 1] + 14 : 0);
		}
		id += lines;
		list.width = 119;
		list.height = 210;
		list.scrollMax = 2000;
		rsi.child(count++, list.id, 199, 92);
		/* Banned members list */
		list = addInterface(id++);
		list.totalChildren(lines);
		list.childY[0] = 2;
		// System.out.println(id);
		for (int index = id; index < id + lines; index++) {
			if (index == 18470) {
				index++;
				id++;
			}
			addText(index, "", tda, 1, 0xffffff, false, true);
			interfaceCache[index].actions = new String[] { "Unban" };
			list.children[index - id] = index;
			list.childX[index - id] = 0;
			list.childY[index - id] = (index - id > 0 ? list.childY[index - id - 1] + 14 : 0);
		}
		id += lines;
		list.width = 119;
		list.height = 210;
		list.scrollMax = 2000;
		rsi.child(count++, list.id, 339, 92);
		/* Table info text */
		y = 47;
		addText(id, "You can manage both ranked and banned members here.", tda, 0, 0xFF981F, true, true);
		rsi.child(count++, id++, 337, y);
		addText(id, "Right click on a name to edit the member.", tda, 0, 0xFF981F, true, true);
		rsi.child(count++, id++, 337, y + 11);
		/* Add ranked member button */
		y = 75;
		addButton(id, 0, "/interfaces/clanchat/plus", "Add ranked member");
		interfaceCache[id].atActionType = 5;
		rsi.child(count++, id++, 319, y);
		/* Add banned member button */
		addButton(id, 0, "/interfaces/clanchat/plus", "Add banned member");
		interfaceCache[id].atActionType = 5;
		rsi.child(count++, id++, 459, y);

		/* Hovers */
		int[] clanSetup = { 18302, 18304, 18307, 18310, 18313, 18316, 18526, 18527 };
		String[] names = { "close", "sprite", "sprite", "sprite", "sprite", "sprite", "plus", "plus" };
		int[] ids = { 1, 3, 3, 3, 3, 3, 1, 1 };
		for (int index = 0; index < clanSetup.length; index++) {
			rsi = interfaceCache[clanSetup[index]];
			rsi.disabledHover = imageLoader(ids[index], "/interfaces/clanchat/" + names[index]);
		}
	}

	public static void Pestpanel(TextDrawingArea[] tda) {
		RSInterface RSinterface = addTab(21119);

		addText(21120, "Next Departure:", 0xCCCBCB, false, true, 52, tda, 1);
		addText(21121, "Players Ready:", 0x5BD230, false, true, 52, tda, 1);
		addText(21122, "(Need 5 to 25 players)", 0xDED36A, false, true, 52, tda, 1);
		addText(21123, "Pest Points:", 0x99FFFF, false, true, 52, tda, 1);
		int last = 4;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];

		setBounds(21120, 5, 5, 0, RSinterface);
		setBounds(21121, 5, 20, 1, RSinterface);
		setBounds(21122, 5, 35, 2, RSinterface);
		setBounds(21123, 5, 50, 3, RSinterface);

		RSInterface rsi = interfaceCache[6114] = new RSInterface();
		rsi.type = 4;
		rsi.width = 390;
		rsi.centerText = true;
	}

	public static void Pestpanel2(TextDrawingArea[] tda) {
		RSInterface RSinterface = addInterface(21100);
		addSprite(21101, 0, "interfaces/pestcontrol/pest1");
		addSprite(21102, 1, "interfaces/pestcontrol/pest1");
		addSprite(21103, 2, "interfaces/pestcontrol/pest1");
		addSprite(21104, 3, "interfaces/pestcontrol/pest1");
		addSprite(21105, 4, "interfaces/pestcontrol/pest1");
		addSprite(21106, 5, "interfaces/pestcontrol/pest1");
		addText(21107, "", 0xCC00CC, false, true, 52, tda, 1);
		addText(21108, "", 0x0000FF, false, true, 52, tda, 1);
		addText(21109, "", 0xFFFF44, false, true, 52, tda, 1);
		addText(21110, "", 0xCC0000, false, true, 52, tda, 1);
		addText(21111, "", 0x99FF33, false, true, 52, tda, 1);// w purp
		addText(21112, "", 0x99FF33, false, true, 52, tda, 1);// e blue
		addText(21113, "", 0x99FF33, false, true, 52, tda, 1);// se yel
		addText(21114, "", 0x99FF33, false, true, 52, tda, 1);// sw red
		addText(21115, "200", 0x99FF33, false, true, 52, tda, 1);// attacks
		addText(21116, "", 0x99FF33, false, true, 52, tda, 1);// knights hp
		addText(21117, "Time Remaining:", 0xFFFFFF, false, true, 52, tda, 0);
		addText(21118, "", 0xFFFFFF, false, true, 52, tda, 0);
		int last = 18;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];
		setBounds(21101, 361, 27, 0, RSinterface);
		setBounds(21102, 396, 27, 1, RSinterface);
		setBounds(21103, 436, 27, 2, RSinterface);
		setBounds(21104, 474, 27, 3, RSinterface);
		setBounds(21105, 3, 21, 4, RSinterface);
		setBounds(21106, 3, 50, 5, RSinterface);
		setBounds(21107, 371, 60, 6, RSinterface);
		setBounds(21108, 409, 60, 7, RSinterface);
		setBounds(21109, 443, 60, 8, RSinterface);
		setBounds(21110, 479, 60, 9, RSinterface);
		setBounds(21111, 362, 14, 10, RSinterface);
		setBounds(21112, 398, 14, 11, RSinterface);
		setBounds(21113, 436, 14, 12, RSinterface);
		setBounds(21114, 475, 14, 13, RSinterface);
		setBounds(21115, 32, 32, 14, RSinterface);
		setBounds(21116, 32, 62, 15, RSinterface);
		setBounds(21117, 8, 88, 16, RSinterface);
		setBounds(21118, 87, 88, 17, RSinterface);
	}

	public static void godWars(TextDrawingArea[] tda) {
		RSInterface rsinterface = addTabInterface(16210);
		addText(16211, "NPC killcount", tda, 0, 0xff9040, true, true);
		addText(16212, "Armadyl kills", tda, 0, 0xff9040, true, true);
		addText(16213, "Bandos kills", tda, 0, 0xff9040, true, true);
		addText(16214, "Saradomin kills", tda, 0, 0xff9040, true, true);
		addText(16215, "Zamorak kills", tda, 0, 0xff9040, true, true);
		addText(16216, "0", tda, 0, 0x66FFFF, true, true);// armadyl
		addText(16217, "0", tda, 0, 0x66FFFF, true, true);// bandos
		addText(16218, "0", tda, 0, 0x66FFFF, true, true);// saradomin
		addText(16219, "0", tda, 0, 0x66FFFF, true, true);// zamorak
		rsinterface.scrollMax = 0;
		rsinterface.children = new int[9];
		rsinterface.childX = new int[9];
		rsinterface.childY = new int[9];
		rsinterface.children[0] = 16211;
		rsinterface.childX[0] = -52 + 375 + 30;
		rsinterface.childY[0] = 7;
		rsinterface.children[1] = 16212;
		rsinterface.childX[1] = -52 + 375 + 30;
		rsinterface.childY[1] = 30;
		rsinterface.children[2] = 16213;
		rsinterface.childX[2] = -52 + 375 + 30;
		rsinterface.childY[2] = 44;
		rsinterface.children[3] = 16214;
		rsinterface.childX[3] = -52 + 375 + 30;
		rsinterface.childY[3] = 58;
		rsinterface.children[4] = 16215;
		rsinterface.childX[4] = -52 + 375 + 30;
		rsinterface.childY[4] = 73;
		rsinterface.children[5] = 16216;
		rsinterface.childX[5] = -52 + 460 + 60;
		rsinterface.childY[5] = 31;
		rsinterface.children[6] = 16217;
		rsinterface.childX[6] = -52 + 460 + 60;
		rsinterface.childY[6] = 45;
		rsinterface.children[7] = 16218;
		rsinterface.childX[7] = -52 + 460 + 60;
		rsinterface.childY[7] = 59;
		rsinterface.children[8] = 16219;
		rsinterface.childX[8] = -52 + 460 + 60;
		rsinterface.childY[8] = 74;
	}

	public static final int BEGIN_READING_PRAYER_INTERFACE = 6;// Amount of total custom prayers we've added
	public static final int CUSTOM_PRAYER_HOVERS = 3; // Amount of custom prayer hovers we've added

	public static final int PRAYER_INTERFACE_CHILDREN = 80 + BEGIN_READING_PRAYER_INTERFACE + CUSTOM_PRAYER_HOVERS;

	public static final int TYPE_SPRITE = 5;

	public static void addPrayer2(int ID, String tooltip, int w, int h, int glowSprite, int glowX, int glowY,
			int sprite1, int sprite2, int config, int configFrame, int hover) {
		RSInterface p = addTabInterface(ID);
		// Adding config-toggleable glow on the prayer
		// Also clickable
		p.parentID = 5608;
		p.type = TYPE_SPRITE;
		p.atActionType = 1;
		p.width = w;
		p.height = h;
		p.requiredValues = new int[1];
		p.valueCompareType = new int[1];
		p.valueCompareType[0] = 1;
		p.requiredValues[0] = config;
		p.valueIndexArray = new int[1][3];
		p.valueIndexArray[0][0] = 5;
		p.valueIndexArray[0][1] = configFrame;
		p.valueIndexArray[0][2] = 0;
		p.tooltip = tooltip;
		p.message = tooltip;
		p.hoverType = 52;
		p.sprite1 = imageLoader(0, "prayerglow");
		p.sprite2 = imageLoader(1, "prayerglow");
		p.spriteXOffset = glowX;
		p.spriteYOffset = glowY;

		// Adding config-toggleable prayer sprites
		// not clickable
		p = addTabInterface(ID + 1);
		p.parentID = 5608;
		p.type = TYPE_SPRITE;
		p.atActionType = 0;
		p.width = w;
		p.height = h;
		p.requiredValues = new int[1];
		p.valueCompareType = new int[1];
		p.valueCompareType[0] = 2;
		p.requiredValues[0] = 1;
		p.valueIndexArray = new int[1][3];
		p.valueIndexArray[0][0] = 5;
		p.valueIndexArray[0][1] = configFrame + 1;
		p.valueIndexArray[0][2] = 0;
		p.tooltip = tooltip;
		p.message = tooltip;
		p.sprite2 = Client.cacheSprite2[sprite1]; // imageLoader(sprite1, "s");
		p.sprite1 = Client.cacheSprite2[sprite2]; // imageLoader(sprite2, "s");
		p.hoverType = hover;
	}

	public static void addPrayerHover(TextDrawingArea[] tda, int idx, int ID, String hover, int xOffset, int yOffset) {
		// Adding hover box
		RSInterface p = addTabInterface(ID);
		p.inventoryhover = true;
		p.parentID = 5608;
		p.type = 8;
		p.width = 40;
		p.height = 32;
		p.hoverText = p.message = hover;
		p.textDrawingAreas = tda[idx];
		p.hoverXOffset = xOffset;
		p.hoverYOffset = yOffset;
		p.regularHoverBox = true;
	}

	public static void prayerBook(TextDrawingArea[] tda) {
		
		RSInterface tab = addTabInterface(15608);
		tab.totalChildren(10);
		RSInterface prayerBook = interfaceCache[5608];

		// Switches the Chivalry & Piety positions.
		/** Chivalry **/
		int xMinus = 1;
		int minusX = 37;
		prayerBook.childX[50] = 41 - minusX;
		prayerBook.childY[50] = 195 - xMinus;
		prayerBook.childX[51] = 48 - minusX;
		prayerBook.childY[51] = 197 - xMinus;
		prayerBook.childX[63] = 41 - minusX;
		prayerBook.childY[63] = 200 - xMinus;

		/** Piety **/
		prayerBook.childX[52] = 41;
		prayerBook.childY[52] = 195 - xMinus;
		prayerBook.childX[53] = 43;
		prayerBook.childY[53] = 206 - xMinus;
		prayerBook.childX[64] = 48;
		prayerBook.childY[64] = 197 - xMinus;

		addPrayer(39401, 0, 728, 55, 26, "Preserve");
		addPrayer(39404, 0, 730, 74, 27, "Rigour");
		addPrayer(39407, 0, 732, 77, 28, "Augury");
		addPrayerHover(tda, 1, 39409,
				"Level 77\\nAugury\\nIncreases your Magic attack\\nby 25% and your defence by\\n25%", -110, -100);
		addPrayerHover(tda, 1, 39403, "Level 55\\nPreserve\\nBoosted stats last 20%\nlonger.", -135, -60);
		addPrayerHover(tda, 1, 39406,
				"Level 74\\nRigour\\nIncreases your Ranged attack\\nby 20% and damage by 23%,\\nand your defence by 25%",
				-70, -100);
		setBounds(39401, 152, 158 - xMinus, 0, tab);
		setBounds(39404, 78, 195 - xMinus, 1, tab);
		setBounds(39407, 115, 195 - xMinus, 2, tab);
		setBounds(39402, 154, 158 - xMinus, 3, tab);
		setBounds(39405, 81, 198 - xMinus, 4, tab);
		setBounds(39408, 118, 198 - xMinus, 5, tab);
		setBounds(5608, 0, 0 - xMinus, 6, tab);
		setBounds(39403, 154, 158 - xMinus, 7, tab);
		setBounds(39406, 84, 198 - xMinus, 8, tab);
		setBounds(39409, 120, 198 - xMinus, 9, tab);

		interfaceCache[19812].valueIndexArray[0][1] = 720;
		interfaceCache[19814].valueIndexArray[0][1] = 721;
		interfaceCache[19816].valueIndexArray[0][1] = 722;
		interfaceCache[19818].valueIndexArray[0][1] = 723;
		interfaceCache[19821].valueIndexArray[0][1] = 724;
		interfaceCache[19823].valueIndexArray[0][1] = 725;
		interfaceCache[19825].valueIndexArray[0][1] = 726;
		interfaceCache[19827].valueIndexArray[0][1] = 727;

	}

	public static void ancients(TextDrawingArea[] tda) {
		RSInterface p = addTabInterface(838);
		RSInterface rsinterface = interfaceCache[12855];
		// rsinterface.childX[6] = 10;
		rsinterface.childY[22] = 153;
		rsinterface.childX[22] = 18;
		rsinterface.childY[30] = 153;
		rsinterface.childX[30] = 65;
		rsinterface.childY[44] = 153; // ANNAKARL
		rsinterface.childX[44] = 112;
		rsinterface.childY[46] = 180; // GHORROCK
		rsinterface.childX[46] = 65;
		rsinterface.childY[7] = 181; // ICE BARRAGE
		rsinterface.childX[7] = 18;
		rsinterface.childY[15] = 153; // BLOOD BARRAGE
		rsinterface.childX[15] = 152;

		addSpellBig2(34674, 563, 560, 562, 10, 10, 10, 30009, 30009, 30011, 85, "Teleport to Target",
				"Teleports you near your Bounty\\nHunter Target", tda, 9, 7, 5);
		setChildren(3, p);
		setBounds(12855, 0, 0, 0, p);
		setBounds(34674, 150, 123, 1, p);
		setBounds(34675, 5, -5, 2, p);
	}

	public static void configureLunar(TextDrawingArea[] TDA) {
		constructLunar();
		homeTeleport();
		drawRune(30003, 1, "Fire");
		drawRune(30004, 2, "Water");
		drawRune(30005, 3, "Air");
		drawRune(30006, 4, "Earth");
		drawRune(30007, 5, "Mind");
		drawRune(30008, 6, "Body");
		drawRune(30009, 7, "Death");
		drawRune(30010, 8, "Nature");
		drawRune(30011, 9, "Chaos");
		drawRune(30012, 10, "Law");
		drawRune(30013, 11, "Cosmic");
		drawRune(30014, 12, "Blood");
		drawRune(30015, 13, "Soul");
		drawRune(30016, 14, "Astral");
		addLunar3RunesSmallBox(30017, 9075, 554, 555, 0, 4, 3, 30003, 30004, 64, "Bake Pie",
				"Bake pies without a stove", TDA, 0, 16, 2);
		addLunar2RunesSmallBox(30025, 9075, 557, 0, 7, 30006, 65, "Cure Plant", "Cure disease on farming patch", TDA, 1,
				4, 2);
		addLunar3RunesBigBox(30032, 9075, 564, 558, 0, 0, 0, 30013, 30007, 65, "Monster Examine",
				"Detect the combat statistics of a\\nmonster", TDA, 2, 2, 2);
		addLunar3RunesSmallBox(30040, 9075, 564, 556, 0, 0, 1, 30013, 30005, 66, "NPC Contact",
				"Speak with varied NPCs", TDA, 3, 0, 2);
		addLunar3RunesSmallBox(30048, 9075, 563, 557, 0, 0, 9, 30012, 30006, 67, "Cure Other", "Cure poisoned players",
				TDA, 4, 8, 2);
		addLunar3RunesSmallBox(30056, 9075, 555, 554, 0, 2, 0, 30004, 30003, 67, "Humidify",
				"fills certain vessels with water", TDA, 5, 0, 5);
		addLunar3RunesSmallBox(30064, 9075, 563, 557, 1, 0, 1, 30012, 30006, 68, "Moonclan Teleport",
				"Teleports you to moonclan island", TDA, 6, 0, 5);
		addLunar3RunesBigBox(30075, 9075, 563, 557, 1, 0, 3, 30012, 30006, 69, "Tele Groun Moonclan",
				"Teleports players to Moonclan\\nisland", TDA, 7, 0, 5);
		addLunar3RunesSmallBox(30083, 9075, 563, 557, 1, 0, 5, 30012, 30006, 70, "Ourania Teleport",
				"Teleports you to ourania rune altar", TDA, 8, 0, 5);
		addLunar3RunesSmallBox(30091, 9075, 564, 563, 1, 1, 0, 30013, 30012, 70, "Cure Me", "Cures Poison", TDA, 9, 0,
				5);
		addLunar2RunesSmallBox(30099, 9075, 557, 1, 1, 30006, 70, "Hunter Kit", "Get a kit of hunting gear", TDA, 10, 0,
				5);
		addLunar3RunesSmallBox(30106, 9075, 563, 555, 1, 0, 0, 30012, 30004, 71, "Waterbirth Teleport",
				"Teleports you to Waterbirth island", TDA, 11, 0, 5);
		addLunar3RunesBigBox(30114, 9075, 563, 555, 1, 0, 4, 30012, 30004, 72, "Tele Group Waterbirth",
				"Teleports players to Waterbirth\\nisland", TDA, 12, 0, 5);
		addLunar3RunesSmallBox(30122, 9075, 564, 563, 1, 1, 1, 30013, 30012, 73, "Cure Group",
				"Cures Poison on players", TDA, 13, 0, 5);
		addLunar3RunesBigBox(30130, 9075, 564, 559, 1, 1, 4, 30013, 30008, 74, "Stat Spy",
				"Cast on another player to see their\\nskill levels", TDA, 14, 8, 2);
		addLunar3RunesBigBox(30138, 9075, 563, 554, 1, 1, 2, 30012, 30003, 74, "Barbarian Teleport",
				"Teleports you to the Barbarian\\noutpost", TDA, 15, 0, 5);
		addLunar3RunesBigBox(30146, 9075, 563, 554, 1, 1, 5, 30012, 30003, 75, "Tele Group Barbarian",
				"Teleports players to the Barbarian\\noutpost", TDA, 16, 0, 5);
		addLunar3RunesSmallBox(30154, 9075, 554, 556, 1, 5, 9, 30003, 30005, 76, "Superglass Make",
				"Make glass without a furnace", TDA, 17, 16, 2);
		addLunar3RunesSmallBox(30162, 9075, 563, 555, 1, 1, 3, 30012, 30004, 77, "Khazard Teleport",
				"Teleports you to Port khazard", TDA, 18, 0, 5);
		addLunar3RunesSmallBox(30170, 9075, 563, 555, 1, 1, 7, 30012, 30004, 78, "Tele Group Khazard",
				"Teleports players to Port khazard", TDA, 19, 0, 5);
		addLunar3RunesBigBox(30178, 9075, 564, 559, 1, 0, 4, 30013, 30008, 78, "Dream",
				"Take a rest and restore hitpoints 3\\n times faster", TDA, 20, 0, 5);
		addLunar3RunesSmallBox(30186, 9075, 557, 555, 1, 9, 4, 30006, 30004, 79, "String Jewellery",
				"String amulets without wool", TDA, 21, 0, 5);
		addLunar3RunesLargeBox(30194, 9075, 557, 555, 1, 9, 9, 30006, 30004, 80, "Stat Restore Pot\\nShare",
				"Share a potion with up to 4 nearby\\nplayers", TDA, 22, 0, 5);
		addLunar3RunesSmallBox(30202, 9075, 554, 555, 1, 6, 6, 30003, 30004, 81, "Magic Imbue",
				"Combine runes without a talisman", TDA, 23, 0, 5);
		addLunar3RunesBigBox(30210, 9075, 561, 557, 2, 1, 14, 30010, 30006, 82, "Fertile Soil",
				"Fertilise a farming patch with super\\ncompost", TDA, 24, 4, 2);
		addLunar3RunesBigBox(30218, 9075, 557, 555, 2, 11, 9, 30006, 30004, 83, "Boost Potion Share",
				"Shares a potion with up to 4 nearby\\nplayers", TDA, 25, 0, 5);
		addLunar3RunesSmallBox(30226, 9075, 563, 555, 2, 2, 9, 30012, 30004, 84, "Fishing Guild Teleport",
				"Teleports you to the fishing guild", TDA, 26, 0, 5);
		addSpellBig2(30234, 563, 560, 562, 1, 1, 1, 30009, 30012, 30004, 84, "Teleport to Target",
				"Teleports you near your Bounty\\nHunter Target", TDA, 9, 7, 5);
		addLunar3RunesSmallBox(30242, 9075, 557, 561, 2, 14, 0, 30006, 30010, 85, "Plank Make", "Turn Logs into planks",
				TDA, 28, 16, 5);
		/******** Cut Off Limit **********/
		addLunar3RunesSmallBox(30250, 9075, 563, 555, 2, 2, 9, 30012, 30004, 86, "Catherby Teleport",
				"Teleports you to Catherby", TDA, 29, 0, 5);
		addLunar3RunesSmallBox(30258, 9075, 563, 555, 2, 2, 14, 30012, 30004, 87, "Tele Group Catherby",
				"Teleports players to Catherby", TDA, 30, 0, 5);
		addLunar3RunesSmallBox(30266, 9075, 563, 555, 2, 2, 7, 30012, 30004, 88, "Ice Plateau Teleport",
				"Teleports you to Ice Plateau", TDA, 31, 0, 5);
		addLunar3RunesBigBox(30274, 9075, 563, 555, 2, 2, 15, 30012, 30004, 89, "Tele Group Ice\\n Plateau",
				"\\nTeleports players to Ice Plateau", TDA, 32, 0, 5);
		addLunar3RunesBigBox(30282, 9075, 563, 561, 2, 1, 0, 30012, 30010, 90, "Energy Transfer",
				"Spend hitpoints and Energy to\\n give another player \\nhitpoints and run energy", TDA, 33, 8, 2);
		addLunar3RunesBigBox(30290, 9075, 563, 565, 2, 2, 0, 30012, 30014, 91, "Heal Other",
				"Transfer up to 75% of hitpoints\\n to another player", TDA, 34, 8, 2);
		addLunar3RunesBigBox(30298, 9075, 560, 557, 2, 1, 9, 30009, 30006, 92, "Vengeance Other",
				"Allows another player to rebound\\ndamage to an opponent", TDA, 35, 8, 2);
		addLunar3RunesSmallBox(30306, 9075, 560, 557, 3, 1, 9, 30009, 30006, 93, "Vengeance",
				"Rebound damage to an opponent", TDA, 36, 0, 5);
		addLunar3RunesBigBox(30314, 9075, 565, 563, 3, 2, 5, 30014, 30012, 94, "Heal Group",
				"Transfer up to 75% of hitpoints to a group", TDA, 37, 0, 5);
		addLunar3RunesBigBox(30322, 9075, 564, 563, 2, 1, 0, 30013, 30012, 95, "Spellbook Swap",
				"Change to another spellbook for 1\\nspell cast", TDA, 38, 0, 5);
	}

	public static void constructLunar() {
		RSInterface Interface = addInterface(29999);
		setChildren(80, Interface); // 71
		int[] Cid = { 30000, 30017, 30025, 30032, 30040, 30048, 30056, 30064, 30075, 30083, 30091, 30099, 30106, 30114,
				30122, 30130, 30138, 30146, 30154, 30162, 30170, 30178, 30186, 30194, 30202, 30210, 30218, 30226, 30234,
				30242, 30250, 30258, 30266, 30274, 30282, 30290, 30298, 30306, 30314, 30322, 30001, 30018, 30026, 30033,
				30041, 30049, 30057, 30065, 30076, 30084, 30092, 30100, 30107, 30115, 30123, 30131, 30139, 30147, 30155,
				30163, 30171, 30179, 30187, 30195, 30203, 30211, 30219, 30227, 30235, 30243, 30251, 30259, 30267, 30275,
				30283, 30291, 30299, 30307, 30315, 30323 };

		int[] xCord = { 11, 40, 71, 103, 135, 165, 8, 39, 71, 103, 135, 165, 12, 42, 71, 103, 135, 165, 14, 42, 71, 101,
				135, 168, 11, 42, 74, 103, 135, 164, 10, 42, 71, 103, 136, 165, 13, 42, 71, 104, 6, 5, 5, 5, 5, 5, 5, 5,
				5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };

		int[] yCord = { 9, 9, 12, 10, 12, 10, 39, 39, 39, 39, 39, 37, 68, 68, 68, 68, 68, 68, 97, 97, 97, 97, 98, 98,
				125, 124, 125, 125, 125, 126, 155, 155, 155, 155, 155, 155, 185, 185, 184, 184, 184, 176, 176, 163, 176,
				176, 176, 176, 163, 176, 176, 176, 176, 163, 176, 163, 163, 163, 176, 176, 176, 163, 176, 149, 176, 163,
				163, 176, 149, 176, 176, 176, 176, 176, 9, 9, 9, 9, 9, 9 };

		for (int i = 0; i < Cid.length; i++) {
			setBounds(Cid[i], xCord[i], yCord[i], i, Interface);
		}
	}	

	public static void emoteTab() {
		RSInterface tab = addTabInterface(147);
		RSInterface scroll = addTabInterface(148);
		tab.totalChildren(1);
		tab.child(0, 148, 0, 1);
		addButton(168, 0, "emotes/emote", "Yes");
		addButton(169, 1, "emotes/emote", "No");
		addButton(164, 2, "emotes/emote", "Bow");
		addButton(165, 3, "emotes/emote", "Angry");
		
		addButton(162, 4, "emotes/emote", "Think");
		addButton(163, 5, "emotes/emote", "Wave");
		addButton(13370, 6, "emotes/emote", "Shrug");
		addButton(171, 7, "emotes/emote", "Cheer");
		
		addButton(167, 8, "emotes/emote", "Beckon");
		addButton(170, 9, "emotes/emote", "Laugh");
		addButton(13366, 10, "emotes/emote", "Jump for Joy");
		addButton(13368, 11, "emotes/emote", "Yawn");
		
		addButton(166, 12, "emotes/emote", "Dance");
		addButton(13363, 13, "emotes/emote", "Jig");
		addButton(13364, 14, "emotes/emote", "Spin");
		addButton(13365, 15, "emotes/emote", "Headbang");
		
		addButton(161, 16, "emotes/emote", "Cry");
		addButton(11100, 17, "emotes/emote", "Blow kiss");
		addButton(13362, 18, "emotes/emote", "Panic");
		addButton(13367, 19, "emotes/emote", "Raspberry");
		
		addButton(172, 20, "emotes/emote", "Clap");
		addButton(13369, 21, "emotes/emote", "Salute");
		addButton(13383, 22, "emotes/emote", "Goblin Bow");
		addButton(13384, 23, "emotes/emote", "Goblin Salute");
		
		addButton(667, 24, "emotes/emote", "Glass Box");
		addButton(6503, 25, "emotes/emote", "Climb Rope");
		addButton(6506, 26, "emotes/emote", "Lean On Air");
		addButton(666, 27, "emotes/emote", "Glass Wall");
		
		addButton(18700, 28, "emotes/emote", "Idea");
		addButton(18701, 29, "emotes/emote", "Stomp");
		addButton(18702, 30, "emotes/emote", "Flap");
		addButton(18703, 31, "emotes/emote", "Slap head");
		
		addButton(18464, 32, "emotes/emote", "Zombie Walk");
		addButton(18465, 33, "emotes/emote", "Zombie Dance");
		addButton(15166, 34, "emotes/emote", "Scared");
		addButton(18686, 35, "emotes/emote", "Rabbit Hop");
		
		addButton(18708, 36, "emotes/emote", "Sit up");
		addButton(18709, 37, "emotes/emote", "Push up");
		addButton(18710, 38, "emotes/emote", "Star jump");
		addButton(18711, 39, "emotes/emote", "Jog");

		addButton(18712, 40, "emotes/emote", "Zombie hand");
		addButton(18713, 41, "emotes/emote", "Hypermobile Drinker");
		addButton(154, 42, "emotes/emote", "Skillcape");
		addButton(18715, 43, "emotes/emote", "Air guitar");

		addButton(18716, 44, "emotes/emote", "Uri");
		addButton(18717, 45, "emotes/emote", "Smooth dance");
		addButton(18718, 46, "emotes/emote", "Crazy dance");
		addButton(18719, 47, "emotes/emote", "Premier shield");


		
		scroll.width = 173;
		scroll.height = 260;
		scroll.scrollMax = 598;
		scroll.totalChildren(48);
		scroll.child(0, 168, 10, 7);
		scroll.child(1, 169, 54, 7);
		scroll.child(2, 164, 98, 14);
		scroll.child(3, 167, 137, 7);
		scroll.child(4, 162, 9, 56);
		scroll.child(5, 163, 48, 56);
		scroll.child(6, 13370, 95, 56);
		scroll.child(7, 171, 137, 56);
		scroll.child(8, 165, 7, 105);
		scroll.child(9, 170, 51, 105);
		scroll.child(10, 13366, 95, 104);
		scroll.child(11, 13368, 139, 105);
		scroll.child(12, 166, 6, 154);
		scroll.child(13, 13363, 50, 154);
		scroll.child(14, 13364, 90, 154);
		scroll.child(15, 13365, 135, 154);
		scroll.child(16, 161, 8, 204);
		scroll.child(17, 11100, 51, 203);
		scroll.child(18, 13362, 99, 204);
		scroll.child(19, 13367, 137, 203);
		scroll.child(20, 172, 10, 253);
		scroll.child(21, 13369, 53, 253);
		scroll.child(22, 13383, 88, 258);
		scroll.child(23, 13384, 138, 252);

		scroll.child(24, 667, 6, 302);
		scroll.child(25, 6503, 49, 302);
		scroll.child(26, 6506, 93, 302);
		scroll.child(27, 666, 137, 302);

		scroll.child(28, 18700, 3, 352);
		scroll.child(29, 18701, 46, 352);
		scroll.child(30, 18702, 90, 352);
		scroll.child(31, 18703, 129, 352);
		
		scroll.child(32, 18464, 13, 402);
		scroll.child(33, 18465, 52, 402);
		scroll.child(34, 15166, 95, 402);
		scroll.child(35, 18686, 140, 402);
		
		scroll.child(36, 18708, 1, 455);
		scroll.child(37, 18709, 49, 455);
		scroll.child(38, 18710, 92, 448);
		scroll.child(39, 18711, 139, 448);
		
		scroll.child(40, 18712, 6, 498);
		scroll.child(41, 18713, 47, 498);
		scroll.child(42, 154, 90, 498);
		scroll.child(43, 18715, 129, 498);
		
		scroll.child(44, 18716, 3, 550);
		scroll.child(45, 18717, 43, 550);
		scroll.child(46, 18718, 83, 550);
		scroll.child(47, 18719, 123, 550);

	}

	public static void removeConfig(int id) {
		@SuppressWarnings("unused")
		RSInterface rsi = interfaceCache[id] = new RSInterface();
	}

	public static void addHoverButton_sprite_loader(int i, int spriteId, int width, int height, String text,
			int contentType, int hoverOver, int aT) {// hoverable
		// button
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = aT;
		tab.contentType = contentType;
		tab.opacity = 0;
		tab.hoverType = hoverOver;
		tab.sprite1 = Client.cacheSprite1[spriteId];
		tab.sprite2 = Client.cacheSprite1[spriteId];
		tab.width = width;
		tab.height = height;
		tab.tooltip = text;
	}

	public static void addHoveredButton_sprite_loader(int i, int spriteId, int w, int h, int IMAGEID) {// hoverable
		// button
		RSInterface tab = addTabInterface(i);
		tab.parentID = i;
		tab.id = i;
		tab.type = 0;
		tab.atActionType = 0;
		tab.width = w;
		tab.height = h;
		tab.visible = true;
		tab.opacity = 0;
		tab.hoverType = -1;
		tab.scrollMax = 0;
		addHoverImage_sprite_loader(IMAGEID, spriteId);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}

	public static void addSprite3(int childId, int spriteId) {
		RSInterface rsi = interfaceCache[childId] = new RSInterface();
		rsi.id = childId;
		rsi.parentID = childId;
		rsi.type = 5;
		rsi.atActionType = 0;
		rsi.contentType = 0;
		rsi.sprite1 = Client.cacheSprite3[spriteId];
		rsi.sprite2 = Client.cacheSprite3[spriteId];
		rsi.width = rsi.sprite1.myWidth;
		rsi.height = rsi.sprite2.myHeight - 2;
	}

	public static void addButton(int id, int sid, String tooltip) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 1;
		tab.contentType = 0;
		tab.opacity = (byte) 0;
		tab.hoverType = 52;
		tab.sprite1 = Client.cacheSprite1[sid];// imageLoader(sid, spriteName);
		tab.sprite2 = Client.cacheSprite1[sid];// imageLoader(sid, spriteName);
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite1.myHeight;
		tab.tooltip = tooltip;
	}

	public static void addHoverImage_sprite_loader(int i, int spriteId) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.opacity = 0;
		tab.hoverType = 52;
		tab.sprite1 = Client.cacheSprite1[spriteId];
		tab.sprite2 = Client.cacheSprite1[spriteId];
	}

	public static void addHoverImage_sprite_loader3(int i, int spriteId) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.opacity = 0;
		tab.hoverType = 52;
		tab.sprite1 = Client.cacheSprite3[spriteId];
		tab.sprite2 = Client.cacheSprite3[spriteId];
	}

	public static void addHoveredButton_sprite_loader3(int i, int spriteId, int w, int h, int IMAGEID) {// hoverable
		// button
		RSInterface tab = addTabInterface(i);
		tab.parentID = i;
		tab.id = i;
		tab.type = 0;
		tab.atActionType = 0;
		tab.width = w;
		tab.height = h;
		tab.visible = true;
		tab.opacity = 0;
		tab.hoverType = -1;
		tab.scrollMax = 0;
		addHoverImage_sprite_loader3(IMAGEID, spriteId);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}

	public static void addHoverButton_sprite_loader3(int i, int spriteId, int width, int height, String text,
			int contentType, int hoverOver, int aT) {// hoverable
		// button
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = aT;
		tab.contentType = contentType;
		tab.opacity = 0;
		tab.hoverType = hoverOver;
		tab.sprite1 = Client.cacheSprite3[spriteId];
		tab.sprite2 = Client.cacheSprite3[spriteId];
		tab.width = width;
		tab.height = height;
		tab.tooltip = text;
	}

	public static void equipmentTab(TextDrawingArea[] wid) {
		RSInterface Interface = interfaceCache[1644];
		addSprite(15101, 0, "interfaces/equipment/bl");// cheap hax
		addSprite(15102, 1, "interfaces/equipment/bl");// cheap hax
		addSprite(15109, 2, "interfaces/equipment/bl");// cheap hax
		removeConfig(21338);
		removeConfig(21344);
		removeConfig(21342);
		removeConfig(21341);
		removeConfig(21340);
		removeConfig(15103);
		removeConfig(15104);
		Interface.children[24] = 15102;
		Interface.childX[24] = 110;
		Interface.childY[24] = 205;
		Interface.children[25] = 15109;
		Interface.childX[25] = 39;
		Interface.childY[25] = 240;
		Interface.children[26] = 27650;
		Interface.childX[26] = 0;
		Interface.childY[26] = 0;
		Interface = addInterface(27650);
		
		addHoverButton(27651, "/equipment/sprite", 6, 40, 40, "Price-checker", 550, 27652, 5);
		addHoveredButton(27652, "/equipment/sprite", 7, 40, 40, 27658);
		
		addHoverButton(27653, "/equipment/sprite", 8, 40, 40, "Show Equipment Stats", 550, 27655, 5);
		addHoveredButton(27655, "/equipment/sprite", 9, 40, 40, 27665);

		addHoverButton(27654, "/equipment/sprite", 10, 40, 40, "Show items kept on death", -1, 27657, 1);
		addHoveredButton(27657, "/equipment/sprite", 11, 40, 40, 27666);
		
		addHoverButton(27660, "/equipment/sprite", 12, 40, 40, "Call follower", -1, 27661, 1);
		addHoveredButton(27661, "/equipment/sprite", 13, 40, 40, 27662);

		setChildren(8, Interface);
		setBounds(27651, 53, 205, 0, Interface);
		setBounds(27652, 53, 205, 1, Interface);
		setBounds(27653, 8, 205, 2, Interface);
		setBounds(27654, 98, 205, 3, Interface);
		setBounds(27655, 8, 205, 4, Interface);
		setBounds(27657, 98, 205, 5, Interface);

		setBounds(27660, 98 + 45, 205, 6, Interface);
		setBounds(27661, 98 + 45, 205, 7, Interface);
	}

	public static void itemsOnDeath(TextDrawingArea[] wid) {
		RSInterface rsinterface = addInterface(17100);
		addEquipmentSprite(17101, 2, 2);
		addHover(17102, 3, 0, 10601, 1, "interfaces/equipment/sprite", 17, 17, "Close Window");
		addHovered(10601, 3, "interfaces/equipment/sprite", 17, 17, 10602);
		addText(17103, "Items kept on death", wid, 2, 0xff981f);
		addText(17104, "Items I will keep...", wid, 1, 0xff981f);
		addText(17105, "Items I will lose...", wid, 1, 0xff981f);
		addText(17106, "Info", wid, 1, 0xff981f);
		addText(17107, "RuneScape", wid, 1, 0xffcc33);
		addText(17108, "", wid, 1, 0xffcc33);
		rsinterface.scrollMax = 0;
		rsinterface.visible = false;
		rsinterface.children = new int[12];
		rsinterface.childX = new int[12];
		rsinterface.childY = new int[12];

		rsinterface.children[0] = 17101;
		rsinterface.childX[0] = 7;
		rsinterface.childY[0] = 8;
		rsinterface.children[1] = 17102;
		rsinterface.childX[1] = 480;
		rsinterface.childY[1] = 17;
		rsinterface.children[2] = 17103;
		rsinterface.childX[2] = 185;
		rsinterface.childY[2] = 18;
		rsinterface.children[3] = 17104;
		rsinterface.childX[3] = 22;
		rsinterface.childY[3] = 50;
		rsinterface.children[4] = 17105;
		rsinterface.childX[4] = 22;
		rsinterface.childY[4] = 110;
		rsinterface.children[5] = 17106;
		rsinterface.childX[5] = 347;
		rsinterface.childY[5] = 47;
		rsinterface.children[6] = 17107;
		rsinterface.childX[6] = 349;
		rsinterface.childY[6] = 270;
		rsinterface.children[7] = 17108;
		rsinterface.childX[7] = 398;
		rsinterface.childY[7] = 298;
		rsinterface.children[8] = 17115;
		rsinterface.childX[8] = 348;
		rsinterface.childY[8] = 64;
		rsinterface.children[9] = 10494;
		rsinterface.childX[9] = 26;
		rsinterface.childY[9] = 74;
		rsinterface.children[10] = 10600;
		rsinterface.childX[10] = 26;
		rsinterface.childY[10] = 133;
		rsinterface.children[11] = 10601;
		rsinterface.childX[11] = 480;
		rsinterface.childY[11] = 17;
		interfaceCache[10494].invSpritePadX = 8;
		interfaceCache[10600].invSpritePadX = 6;
		interfaceCache[10600].invSpritePadY = 6;
	}

	public static void itemsOnDeathDATA(TextDrawingArea[] wid) {
		RSInterface rsinterface = addInterface(17115);
		addText(17109, "a", wid, 0, 0xff981f);
		addText(17110, "b", wid, 0, 0xff981f);
		addText(17111, "c", wid, 0, 0xff981f);
		addText(17112, "d", wid, 0, 0xff981f);
		addText(17113, "e", wid, 0, 0xff981f);
		addText(17114, "f", wid, 0, 0xff981f);
		addText(17117, "g", wid, 0, 0xff981f);
		addText(17118, "h", wid, 0, 0xff981f);
		addText(17119, "i", wid, 0, 0xff981f);
		addText(17120, "j", wid, 0, 0xff981f);
		addText(17121, "k", wid, 0, 0xff981f);
		addText(17122, "l", wid, 0, 0xff981f);
		addText(17123, "m", wid, 0, 0xff981f);
		addText(17124, "n", wid, 0, 0xff981f);
		addText(17125, "o", wid, 0, 0xff981f);
		addText(17126, "p", wid, 0, 0xff981f);
		addText(17127, "q", wid, 0, 0xff981f);
		addText(17128, "r", wid, 0, 0xff981f);
		addText(17129, "s", wid, 0, 0xff981f);
		addText(17130, "t", wid, 0, 0xff981f);
		rsinterface.parentID = 17115;
		rsinterface.id = 17115;
		rsinterface.type = 0;
		rsinterface.atActionType = 0;
		rsinterface.contentType = 0;
		rsinterface.width = 130;
		rsinterface.height = 197;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = -1;
		rsinterface.scrollMax = 280;
		rsinterface.children = new int[20];
		rsinterface.childX = new int[20];
		rsinterface.childY = new int[20];
		rsinterface.children[0] = 17109;
		rsinterface.childX[0] = 0;
		rsinterface.childY[0] = 0;
		rsinterface.children[1] = 17110;
		rsinterface.childX[1] = 0;
		rsinterface.childY[1] = 12;
		rsinterface.children[2] = 17111;
		rsinterface.childX[2] = 0;
		rsinterface.childY[2] = 24;
		rsinterface.children[3] = 17112;
		rsinterface.childX[3] = 0;
		rsinterface.childY[3] = 36;
		rsinterface.children[4] = 17113;
		rsinterface.childX[4] = 0;
		rsinterface.childY[4] = 48;
		rsinterface.children[5] = 17114;
		rsinterface.childX[5] = 0;
		rsinterface.childY[5] = 60;
		rsinterface.children[6] = 17117;
		rsinterface.childX[6] = 0;
		rsinterface.childY[6] = 72;
		rsinterface.children[7] = 17118;
		rsinterface.childX[7] = 0;
		rsinterface.childY[7] = 84;
		rsinterface.children[8] = 17119;
		rsinterface.childX[8] = 0;
		rsinterface.childY[8] = 96;
		rsinterface.children[9] = 17120;
		rsinterface.childX[9] = 0;
		rsinterface.childY[9] = 108;
		rsinterface.children[10] = 17121;
		rsinterface.childX[10] = 0;
		rsinterface.childY[10] = 120;
		rsinterface.children[11] = 17122;
		rsinterface.childX[11] = 0;
		rsinterface.childY[11] = 132;
		rsinterface.children[12] = 17123;
		rsinterface.childX[12] = 0;
		rsinterface.childY[12] = 144;
		rsinterface.children[13] = 17124;
		rsinterface.childX[13] = 0;
		rsinterface.childY[13] = 156;
		rsinterface.children[14] = 17125;
		rsinterface.childX[14] = 0;
		rsinterface.childY[14] = 168;
		rsinterface.children[15] = 17126;
		rsinterface.childX[15] = 0;
		rsinterface.childY[15] = 180;
		rsinterface.children[16] = 17127;
		rsinterface.childX[16] = 0;
		rsinterface.childY[16] = 192;
		rsinterface.children[17] = 17128;
		rsinterface.childX[17] = 0;
		rsinterface.childY[17] = 204;
		rsinterface.children[18] = 17129;
		rsinterface.childX[18] = 0;
		rsinterface.childY[18] = 216;
		rsinterface.children[19] = 17130;
		rsinterface.childX[19] = 0;
		rsinterface.childY[19] = 228;
	}

	public static void Sidebar0(TextDrawingArea[] tda) {
		Sidebar0a(1698, 1701, 7499, "Chop", "Hack", "Smash", "Block", 42, 75, 127, 75, 39, 128, 125, 128, 122, 103, 40,
				50, 122, 50, 40, 103, tda, "Accurate\nSlash\nAttack XP", "Aggressive\nSlash\nStrength XP",
				"Aggressive\nCrush\nStrength XP", "Defensive\nSlash\nDefence XP", 40132, 40136, 40140, 40144); // OK

		Sidebar0a(2276, 2279, 7574, "Stab", "Lunge", "Slash", "Block", 43, 75, 124, 75, 41, 128, 125, 128, 122, 103, 40,
				50, 122, 50, 40, 103, tda, "Accurate\nStab\nAttack XP", "Aggressive\nStab\nStrength XP",
				"Aggressive\nSlash\nStrength XP", "Defensive\nStab\nDefence XP", 40020, 40024, 40028, 40032); // OK

		Sidebar0a(2423, 2426, 7599, "Chop", "Slash", "Lunge", "Block", 42, 75, 125, 75, 40, 128, 125, 128, 122, 103, 40,
				50, 122, 50, 40, 103, tda, "Accurate\nSlash\nAttack XP", "Aggressive\nSlash\nStrength XP",
				"Controlled\nStab\nShared XP", "Defensive\nSlash\nDefence XP", 40036, 40040, 40044, 40048); // OK

		Sidebar0a(3796, 3799, 7624, "Pound", "Pummel", "Spike", "Block", 39, 75, 121, 75, 41, 128, 125, 128, 122, 103,
				40, 50, 122, 50, 40, 103, tda, "", "", "", "", 40052, 40056, 40060, 40064); // WTF IS
																							// THIS?!

		Sidebar0a(4679, 4682, 7674, "Lunge", "Swipe", "Pound", "Block", 40, 75, 124, 75, 39, 128, 125, 128, 122, 103,
				40, 50, 122, 50, 40, 103, tda, "Controlled\nStab\nShared XP", "Controlled\nSlash\nShared XP",
				"Controlled\nCrush\nShared XP", "Defensive\nStab\nDefence XP", 40068, 40072, 40076, 40080); // OK

		Sidebar0a(4705, 4708, 7699, "Chop", "Slash", "Smash", "Block", 42, 75, 125, 75, 39, 128, 125, 128, 122, 103, 40,
				50, 122, 50, 40, 103, tda, "Accurate\nSlash\nAttack XP", "Aggressive\nSlash\nStrength XP",
				"Aggressive\nCrush\nStrength XP", "Defensive\nSlash\nDefence XP", 40084, 40088, 40092, 40096); // ???

		Sidebar0a(5570, 5573, 7724, "Spike", "Impale", "Smash", "Block", 41, 75, 123, 75, 39, 128, 125, 128, 122, 103,
				40, 50, 122, 50, 40, 103, tda, "Accurate\nStab\nAttack XP", "Aggressive\nStab\nStrength XP",
				"Aggressive\nCrush\nStrength XP", "Defensive\nStab\nDefence XP", 40010, 40104, 40108, 40112); // OK

		Sidebar0a(7762, 7765, 7800, "Chop", "Slash", "Lunge", "Block", 42, 75, 125, 75, 40, 128, 125, 128, 122, 103, 40,
				50, 122, 50, 40, 103, tda, "Accurate\nSlash\nAttack XP", "Aggressive\nSlash\nStrength XP",
				"Controlled\nStab\nShared XP", "Defensive\nSlash\nDefence XP", 40116, 40120, 40124, 40128); // OK

		Sidebar0b(776, 779, "Reap", "Chop", "Jab", "Block", 42, 75, 126, 75, 46, 128, 125, 128, 122, 103, 122, 50, 40,
				103, 40, 50, tda, "", "", "", "", 40132, 40136, 40140, 40144); // ???

		Sidebar0c(425, 428, 7474, "Pound", "Pummel", "Block", 39, 75, 121, 75, 42, 128, 40, 103, 40, 50, 122, 50, tda,
				"Accurate\nCrush\nAttack XP", "Aggressive\nCrush\nDefence XP", "Defensive\nCrush\nDefence XP", 40148,
				40152, 40156); // OK

		Sidebar0c(1749, 1752, 7524, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122,
				50, tda, "Accurate\nRanged XP", "Rapid\nRanged XP", "Long range\nRanged XP\nDefence XP", 40160, 40164,
				40168); // OK

		Sidebar0c(1764, 1767, 7549, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122,
				50, tda, "Accurate\nRanged XP", "Rapid\nRanged XP", "Long range\nRanged XP\nDefence XP", 40172, 40176,
				40180); // OK

		Sidebar0c(4446, 4449, 7649, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122,
				50, tda, "Accurate\nRanged XP", "Rapid\nRanged XP", "Long range\nRanged XP\nDefence XP", 40184, 40188,
				40192); // OK

		Sidebar0c(5855, 5857, 7749, "Punch", "Kick", "Block", 40, 75, 129, 75, 42, 128, 40, 50, 122, 50, 40, 103, tda,
				"Accurate\nCrush\nAttack XP", "Aggressive\nCrush\nStrength XP", "Defensive\nCrush\nDefence XP", 40196,
				40200, 40204); // OK

		Sidebar0c(6103, 6132, 6117, "Bash", "Pound", "Block", 43, 75, 124, 75, 42, 128, 40, 103, 40, 50, 122, 50, tda,
				"Accurate\nCrush\nAttack XP", "Aggressive\nCrush\nStrength XP", "Defensive\nCrush\nDefence XP", 40208,
				40212, 40216); // ???

		Sidebar0c(8460, 8463, 8493, "Jab", "Swipe", "Fend", 46, 75, 124, 75, 43, 128, 40, 103, 40, 50, 122, 50, tda,
				"Controlled\nStabbed\nShared XP", "Aggressive\nSlash\nStrength XP", "Defensive\nStab\nDefence XP",
				40224, 40228, 40232); // OK

		Sidebar0c(12290, 12293, 12323, "Flick", "Lash", "Deflect", 44, 75, 127, 75, 36, 128, 40, 50, 40, 103, 122, 50,
				tda, "Accurate\nSlash\nAttack XP", "Controlled\nSlash\nShared XP", "Defensive\nSlash\nDefence XP",
				40236, 40240, 40244); // OK

		Sidebar0d(328, 331, "Bash", "Pound", "Focus", 42, 66, 39, 101, 41, 136, 40, 120, 40, 50, 40, 85, tda);

		RSInterface rsi = addTabInterface(19300);
		textSize(3983, tda, 0);
		addAttackStyleButton2(150, 150, 172, 150, 44, "Auto Retaliate", 40000, 154, 42,
				"When active, you will\nautomatically fight back if\nattacked.", tda);

		rsi.totalChildren(3);
		rsi.child(0, 3983, 52, 25); // combat level
		rsi.child(1, 150, 21, 153); // auto retaliate
		rsi.child(2, 40000, 26, 200);

		rsi = interfaceCache[3983];
		rsi.centerText = true;
		rsi.textColor = 0xff981f;
	}

	public static void Sidebar0a(int id, int id2, int id3, String text1, String text2, String text3, String text4,
			int str1x, int str1y, int str2x, int str2y, int str3x, int str3y, int str4x, int str4y, int img1x,
			int img1y, int img2x, int img2y, int img3x, int img3y, int img4x, int img4y, TextDrawingArea[] tda,
			String popupString1, String popupString2, String popupString3, String popupString4, int hoverID1,
			int hoverID2, int hoverID3, int hoverID4) // 4button
														// spec
	{
		RSInterface rsi = addTabInterface(id); // 2423
		addAttackText(id2, "-2", tda, 3, 0xff981f, true); // 2426
		addAttackText(id2 + 11, text1, tda, 0, 0xff981f, false);
		addAttackText(id2 + 12, text2, tda, 0, 0xff981f, false);
		addAttackText(id2 + 13, text3, tda, 0, 0xff981f, false);
		addAttackText(id2 + 14, text4, tda, 0, 0xff981f, false);

		rsi.specialBar(id3, tda); // 7599

		addAttackHover(id2 + 3, hoverID1, popupString1, tda);
		addAttackHover(id2 + 6, hoverID2, popupString2, tda);
		addAttackHover(id2 + 5, hoverID3, popupString3, tda);
		addAttackHover(id2 + 4, hoverID4, popupString4, tda);

		rsi.width = 190;
		rsi.height = 261;

		int frame = 0;
		rsi.totalChildren(20);

		rsi.child(frame, id2 + 3, 21, 46);
		frame++; // 2429
		rsi.child(frame, id2 + 4, 104, 99);
		frame++; // 2430
		rsi.child(frame, id2 + 5, 21, 99);
		frame++; // 2431
		rsi.child(frame, id2 + 6, 105, 46);
		frame++; // 2432

		rsi.child(frame, id2 + 7, img1x, img1y);
		frame++; // bottomright 2433
		rsi.child(frame, id2 + 8, img2x, img2y);
		frame++; // topleft 2434
		rsi.child(frame, id2 + 9, img3x, img3y);
		frame++; // bottomleft 2435
		rsi.child(frame, id2 + 10, img4x, img4y);
		frame++; // topright 2436

		rsi.child(frame, id2 + 11, str1x, str1y);
		frame++; // chop 2437
		rsi.child(frame, id2 + 12, str2x, str2y);
		frame++; // slash 2438
		rsi.child(frame, id2 + 13, str3x, str3y);
		frame++; // lunge 2439
		rsi.child(frame, id2 + 14, str4x, str4y);
		frame++; // block 2440

		rsi.child(frame, id3, 21, 205);
		frame++; // special attack 7599
		rsi.child(frame, 19300, 0, 0);
		frame++; // stuffs
		rsi.child(frame, id2, 94, 4);
		frame++; // weapon 2426
		rsi.child(frame, hoverID1, 25, 96);
		frame++;
		rsi.child(frame, hoverID2, 108, 96);
		frame++;
		rsi.child(frame, hoverID3, 25, 149);
		frame++;
		rsi.child(frame, hoverID4, 108, 149);
		frame++;
		rsi.child(frame, 40005, 28, 149);
		frame++; // special bar tooltip

		for (int i = id2 + 3; i < id2 + 7; i++) { // 2429 - 2433
			rsi = interfaceCache[i];
			rsi.sprite1 = CustomSpriteLoader(19301, "");
			rsi.sprite2 = CustomSpriteLoader(19301, "a");
			rsi.width = 68;
			rsi.height = 44;
		}
	}

	public static void Sidebar0b(int id, int id2, String text1, String text2, String text3, String text4, int str1x,
			int str1y, int str2x, int str2y, int str3x, int str3y, int str4x, int str4y, int img1x, int img1y,
			int img2x, int img2y, int img3x, int img3y, int img4x, int img4y, TextDrawingArea[] tda,
			String popupString1, String popupString2, String popupString3, String popupString4, int hoverID1,
			int hoverID2, int hoverID3, int hoverID4) // 4button
														// nospec
	{
		RSInterface rsi = addTabInterface(id); // 2423
		addAttackText(id2, "-2", tda, 3, 0xff981f, true); // 2426
		addAttackText(id2 + 11, text1, tda, 0, 0xff981f, false);
		addAttackText(id2 + 12, text2, tda, 0, 0xff981f, false);
		addAttackText(id2 + 13, text3, tda, 0, 0xff981f, false);
		addAttackText(id2 + 14, text4, tda, 0, 0xff981f, false);

		addAttackHover(id2 + 3, hoverID1, popupString1, tda);
		addAttackHover(id2 + 6, hoverID2, popupString2, tda);
		addAttackHover(id2 + 5, hoverID3, popupString3, tda);
		addAttackHover(id2 + 4, hoverID4, popupString4, tda);

		rsi.width = 190;
		rsi.height = 261;

		int frame = 0;
		rsi.totalChildren(18);

		rsi.child(frame, id2 + 3, 21, 46);
		frame++; // 2429
		rsi.child(frame, id2 + 4, 104, 99);
		frame++; // 2430
		rsi.child(frame, id2 + 5, 21, 99);
		frame++; // 2431
		rsi.child(frame, id2 + 6, 105, 46);
		frame++; // 2432

		rsi.child(frame, id2 + 7, img1x, img1y);
		frame++; // bottomright 2433
		rsi.child(frame, id2 + 8, img2x, img2y);
		frame++; // topleft 2434
		rsi.child(frame, id2 + 9, img3x, img3y);
		frame++; // bottomleft 2435
		rsi.child(frame, id2 + 10, img4x, img4y);
		frame++; // topright 2436

		rsi.child(frame, id2 + 11, str1x, str1y);
		frame++; // chop 2437
		rsi.child(frame, id2 + 12, str2x, str2y);
		frame++; // slash 2438
		rsi.child(frame, id2 + 13, str3x, str3y);
		frame++; // lunge 2439
		rsi.child(frame, id2 + 14, str4x, str4y);
		frame++; // block 2440

		rsi.child(frame, 19300, 0, 0);
		frame++; // stuffs
		rsi.child(frame, id2, 94, 4);
		frame++; // weapon 2426
		rsi.child(frame, hoverID1, 25, 96);
		frame++;
		rsi.child(frame, hoverID2, 108, 96);
		frame++;
		rsi.child(frame, hoverID3, 25, 149);
		frame++;
		rsi.child(frame, hoverID4, 108, 149);
		frame++;

		for (int i = id2 + 3; i < id2 + 7; i++) { // 2429 - 2433
			rsi = interfaceCache[i];
			rsi.sprite1 = CustomSpriteLoader(19301, "");
			rsi.sprite2 = CustomSpriteLoader(19301, "a");
			rsi.width = 68;
			rsi.height = 44;
		}
	}

	public static void Sidebar0c(int id, int id2, int id3, String text1, String text2, String text3, int str1x,
			int str1y, int str2x, int str2y, int str3x, int str3y, int img1x, int img1y, int img2x, int img2y,
			int img3x, int img3y, TextDrawingArea[] tda, String popupString1, String popupString2, String popupString3,
			int hoverID1, int hoverID2, int hoverID3) // 3button spec
	{
		RSInterface rsi = addTabInterface(id); // 2423
		addAttackText(id2, "-2", tda, 3, 0xff981f, true); // 2426
		addAttackText(id2 + 9, text1, tda, 0, 0xff981f, false);
		addAttackText(id2 + 10, text2, tda, 0, 0xff981f, false);
		addAttackText(id2 + 11, text3, tda, 0, 0xff981f, false);

		rsi.specialBar(id3, tda); // 7599

		addAttackHover(id2 + 5, hoverID1, popupString1, tda);
		addAttackHover(id2 + 4, hoverID2, popupString2, tda);
		addAttackHover(id2 + 3, hoverID3, popupString3, tda);

		rsi.width = 190;
		rsi.height = 261;

		int frame = 0;
		rsi.totalChildren(16);

		rsi.child(frame, id2 + 3, 21, 99);
		frame++;
		rsi.child(frame, id2 + 4, 105, 46);
		frame++;
		rsi.child(frame, id2 + 5, 21, 46);
		frame++;

		rsi.child(frame, id2 + 6, img1x, img1y);
		frame++; // topleft
		rsi.child(frame, id2 + 7, img2x, img2y);
		frame++; // bottomleft
		rsi.child(frame, id2 + 8, img3x, img3y);
		frame++; // topright

		rsi.child(frame, id2 + 9, str1x, str1y);
		frame++; // chop
		rsi.child(frame, id2 + 10, str2x, str2y);
		frame++; // slash
		rsi.child(frame, id2 + 11, str3x, str3y);
		frame++; // lunge

		rsi.child(frame, id3, 21, 205);
		frame++; // special attack 7599
		rsi.child(frame, 19300, 0, 0);
		frame++; // stuffs
		rsi.child(frame, id2, 94, 4);
		frame++; // weapon

		rsi.child(frame, hoverID1, 25, 96);
		frame++;
		rsi.child(frame, hoverID2, 108, 96);
		frame++;
		rsi.child(frame, hoverID3, 25, 149);
		frame++;
		rsi.child(frame, 40005, 28, 149);
		frame++; // special bar tooltip

		for (int i = id2 + 3; i < id2 + 6; i++) {
			rsi = interfaceCache[i];
			rsi.sprite1 = CustomSpriteLoader(19301, "");
			rsi.sprite2 = CustomSpriteLoader(19301, "a");
			rsi.width = 68;
			rsi.height = 44;
		}
	}

	public static void Sidebar0d(int id, int id2, String text1, String text2, String text3, int str1x, int str1y,
			int str2x, int str2y, int str3x, int str3y, int img1x, int img1y, int img2x, int img2y, int img3x,
			int img3y, TextDrawingArea[] tda) // 3button nospec
												// (magic intf)
	{
		RSInterface rsi = addTabInterface(id); // 2423
		addAttackText(id2, "-2", tda, 3, 0xff981f, true); // 2426
		addAttackText(id2 + 9, text1, tda, 0, 0xff981f, false);
		addAttackText(id2 + 10, text2, tda, 0, 0xff981f, false);
		addAttackText(id2 + 11, text3, tda, 0, 0xff981f, false);

		addAttackText(353, "Spell", tda, 0, 0xff981f, false);
		addAttackText(354, "Spell", tda, 0, 0xff981f, false);

		addCacheSprite(337, 19, 0, "combaticons");
		addCacheSprite(338, 13, 0, "combaticons2");
		addCacheSprite(339, 14, 0, "combaticons2");

		addToggleButton(349, 349, 108, 68, 44, "Select");
		addToggleButton(350, 350, 108, 68, 44, "Select");

		rsi.width = 190;
		rsi.height = 261;

		int last = 15;
		int frame = 0;
		rsi.totalChildren(last);

		rsi.child(frame, id2 + 3, 20, 115);
		frame++;
		rsi.child(frame, id2 + 4, 20, 80);
		frame++;
		rsi.child(frame, id2 + 5, 20, 45);
		frame++;

		rsi.child(frame, id2 + 6, img1x, img1y);
		frame++; // topleft
		rsi.child(frame, id2 + 7, img2x, img2y);
		frame++; // bottomleft
		rsi.child(frame, id2 + 8, img3x, img3y);
		frame++; // topright

		rsi.child(frame, id2 + 9, str1x, str1y);
		frame++; // bash
		rsi.child(frame, id2 + 10, str2x, str2y);
		frame++; // pound
		rsi.child(frame, id2 + 11, str3x, str3y);
		frame++; // focus

		rsi.child(frame, 349, 105, 46);
		frame++; // spell1
		rsi.child(frame, 350, 104, 106);
		frame++; // spell2

		rsi.child(frame, 353, 125, 74);
		frame++; // spell
		rsi.child(frame, 354, 125, 134);
		frame++; // spell

		rsi.child(frame, 19300, 0, 0);
		frame++; // stuffs
		rsi.child(frame, id2, 94, 4);
		frame++; // weapon
	}

	public static void clanChatTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(18128);
		addHoverButton(18129, "/clanchat/sprite", 6, 72, 32, "Join Clan", 550, 18130, 5);
		addHoveredButton(18130, "/clanchat/sprite", 7, 72, 32, 18131);
		addHoverButton(18132, "/clanchat/sprite", 6, 72, 32, "Clan Setup", -1, 18133, 5);
		addHoveredButton(18133, "/clanchat/sprite", 7, 72, 32, 18134);
		addText(18135, "Join Clan", tda, 0, 0xff9b00, true, true);
		addText(18136, "Clan Setup", tda, 0, 0xff9b00, true, true);
		addSprite(18137, 37, "/clanchat/sprite");
		addText(18138, "Clan Chat", tda, 1, 0xff9b00, true, true);
		addText(18139, "Talking in: Not in clan", tda, 0, 0xff9b00, false, true);
		addText(18140, "Owner: None", tda, 0, 0xff9b00, false, true);
		addSprite(16126, 4, "/clanchat/sprite");
		tab.totalChildren(13);
		tab.child(0, 16126, 0, 221);
		tab.child(1, 16126, 0, 59);
		tab.child(2, 18137, 0, 62);
		tab.child(3, 18143, 0, 62);
		tab.child(4, 18129, 15, 226);
		tab.child(5, 18130, 15, 226);
		tab.child(6, 18132, 103, 226);
		tab.child(7, 18133, 103, 226);
		tab.child(8, 18135, 51, 237);
		tab.child(9, 18136, 139, 237);
		tab.child(10, 18138, 95, 1);
		tab.child(11, 18139, 10, 23);
		tab.child(12, 18140, 25, 38);
		/* Text area */
		RSInterface list = addTabInterface(18143);
		list.totalChildren(100);
		for (int i = 18144; i <= 18244; i++) {
			addText(i, "", tda, 0, 0xffffff, false, true);
		}
		for (int id = 18144, i = 0; id <= 18243 && i <= 99; id++, i++) {
			interfaceCache[id].actions = new String[] { "Edit Rank", "Kick", "Ban" };
			list.children[i] = id;
			list.childX[i] = 5;
			for (int id2 = 18144, i2 = 1; id2 <= 18243 && i2 <= 99; id2++, i2++) {
				list.childY[0] = 2;
				list.childY[i2] = list.childY[i2 - 1] + 14;
			}
		}
		list.height = 158;
		list.width = 174;
		list.scrollMax = 1405;
	}
}