package com.client.cache.definitions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

import com.client.cache.Archive;
import com.client.cache.graphics.Sprite;
import com.client.collection.Cache;
import com.client.draw.raster.Raster;
import com.client.draw.raster.Rasterizer3D;
import com.client.io.Buffer;
import com.client.model.Model;

public final class ItemDefinition {
	
	public int rdc;
	public int rdc2;
	public int rdc3;

	
	public  void applyTexturing(Model model, int id) {
		switch (id) {
		case 22000: //test model, not actually going to use this (it's the red phat)
			//System.out.println("Lava phat-------------------------");
			model.setTexture(40); //sets the texture to all faces. model.setTexture(40, face) for a specific face;
			//Model.printModelColours(model); //a method for getting all the model faces to display
			//System.out.println("Lava phat-------------------------");
			break;


	case 22001: //test model, not actually going to use this (it's the red phat)
		//System.out.println("Infernal phat-------------------------");
		model.setTexture(59); //sets the texture to all faces. model.setTexture(40, face) for a specific face;
		//Model.printModelColours(model); //a method for getting all the model faces to display
		//System.out.println("Infernal phat-------------------------");
		break;
	case 33142://firecape
		model.overrideTexture(40, 68);
		break;
	case 33451://firecape
		model.overrideTexture(40, 77);
		break;
	case 33144://firecape
		model.overrideTexture(40, 69);
		break;
	case 33145://firecape
		model.overrideTexture(40, 56);
		break;
	case 33143://blue inferno
		model.overrideTexture(59, 64);
		break;
	case 33146://green inferno
		model.overrideTexture(59, 65);
		break;
	case 33147://purple inferno
		model.overrideTexture(59, 72);
		break;
	case 33148://firecape
		model.overrideTexture(40, 63);
		break;
	case 33164://firecape mix
		model.overrideTexture(40, 68);
		break;
	case 33165://firecape mix
		model.overrideTexture(40, 69);
		break;
	case 33166://firecape mix
		model.overrideTexture(40, 56);
		break;
	case 33167://firecape mix
		model.overrideTexture(40, 63);
		break;
	case 33161://blue inferno mix
		model.overrideTexture(40, 64);
		break;
	case 33162://green inferno mix
		model.overrideTexture(40, 65);
		break;
	case 33163://purple inferno mix
		model.overrideTexture(40, 72);
		break;
	case 33150:
		model.setTexture(59);
		break;
	case 33151:
		model.setTexture(59);
		break;
	case 33152:
		model.setTexture(59);
		break;
	case 33153:
		model.setTexture(59);
		break;
	case 37000:
		model.setTexture(40);
		break;
	case 33154:
		model.overrideTexture(63, 59);
		break;
	}
	}

	public static void unpackConfig(final Archive streamLoader) {
		 stream = new Buffer(streamLoader.getDataForName("obj.dat"));
		 Buffer stream = new Buffer(streamLoader.getDataForName("obj.idx"));
		//stream = new Buffer(FileOperations.readFile(Signlink.getCacheDirectory() + "/data/obj.dat"));
		//final Buffer stream = new Buffer(FileOperations.readFile(Signlink.getCacheDirectory() + "/data/obj.idx"));

		totalItems = stream.readShort();
		System.out.println("total items: " + totalItems);
		streamIndices = new int[totalItems + 1000];
		int i = 2;
		for (int j = 0; j < totalItems; j++) {
			streamIndices[j] = i;
			i += stream.readShort();
		}

		cache = new ItemDefinition[10];
		for (int index = 0; index < 10; index++) {
			cache[index] = new ItemDefinition();
		}
		//itemDump();
	}

	public static ItemDefinition forID(int itemId) {
		for (int j = 0; j < 10; j++) {
			if (cache[j].id == itemId) {
				return cache[j];
			}
		}
		int streamItemId = itemId;
		if (itemId == -1)
			streamItemId = 0;
		if (itemId > streamIndices.length)
			streamItemId = 0;

		cacheIndex = (cacheIndex + 1) % 10;
		final ItemDefinition itemDef = cache[cacheIndex];
		stream.position = streamIndices[streamItemId];
		itemDef.id = itemId;
		itemDef.setDefaults();
		itemDef.readValues(stream);

		customItems(itemDef.id);
		

		if (itemDef.certTemplateID != -1) {
			itemDef.toNote();
		}

		if (itemDef.opcode140 != -1) {
			itemDef.method2789(forID(itemDef.opcode140), forID(itemDef.opcode139));
		}

		if (itemDef.opcode149 != -1) {
			itemDef.method2790(forID(itemDef.opcode149), forID(itemDef.opcode148));
		}


		switch (itemId) {

		}
		return itemDef;
	}

	private static void customItems(int itemId) {
		ItemDefinition itemDef = forID(itemId);

		switch (itemId) {

		case 11864:
		case 11865:
		case 19639:
		case 19641:
		case 19643:
		case 19645:
		case 19647:
		case 19649:
			itemDef.equipActions[2] = "Log";
			itemDef.equipActions[1] = "Check";
			break;

		case 13136:
			itemDef.equipActions[2] = "Elidinis";
			itemDef.equipActions[1] = "Kalphite Hive";
			break;
		case 2550:
			itemDef.equipActions[2] = "Check";
			break;

		case 1712:
		case 1710:
		case 1708:
		case 1706:
			itemDef.equipActions[1] = "Edgeville";
			itemDef.equipActions[2] = "Karamja";
			itemDef.equipActions[3] = "Draynor";
			itemDef.equipActions[4] = "Al-Kharid";
			break;
			
		case 22000:
			itemDef.name = "Lava partyhat";
			itemDef.modelId = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotationX = 1852;
			itemDef.modelRotationY = 76;
			itemDef.translateX = 1;
			itemDef.translateYZ = 1;
			itemDef.maleModel = 187;
			itemDef.femaleModel = 363;
            //itemDef.anInt164 = -1;
            //itemDef.anInt188 = -1;
            //itemDef.aByte205 = -8;
			itemDef.groundOptions = new String[] { null, null, "Take", null, null };
			itemDef.inventoryOptions = new String[5];
			itemDef.inventoryOptions[1] = "Wear";
			itemDef.inventoryOptions[2] = null;
			itemDef.description = "A lava partyhat.";
			break;
			
		case 22001:
			itemDef.name = "Infernal partyhat";
			itemDef.modelId = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotationX = 1852;
			itemDef.modelRotationY = 76;
			itemDef.translateX = 1;
			itemDef.translateYZ = 1;
			itemDef.maleModel = 187;
			itemDef.femaleModel = 363;
            //itemDef.anInt164 = -1;
            //itemDef.anInt188 = -1;
            //itemDef.aByte205 = -8;
			itemDef.groundOptions = new String[] { null, null, "Take", null, null };
			itemDef.inventoryOptions = new String[5];
			itemDef.inventoryOptions[1] = "Wear";
			itemDef.inventoryOptions[2] = null;
			itemDef.description = "An Infernal partyhat.";
			break;

		case 2552:
		case 2554:
		case 2556:
		case 2558:
		case 2560:
		case 2562:
		case 2564:
		case 2566: // Ring of duelling
			itemDef.equipActions[2] = "Shantay Pass";
			itemDef.equipActions[1] = "Clan wars";
			break;

			case 21307:
				itemDef.name = "Pursuit crate";
				break;
				
			case 12792:
				itemDef.name = "Graceful recolor kit";
				break;
				
			case 12022:
				itemDef.name = "Bandos Casket";
				itemDef.description = "100% chance for an item off the Bandos gwds rare drop table.";
				break;
				
			case 12024:
				itemDef.name = "Armadyl Casket";
				itemDef.description = "100% chance for an item off the Armadyl gwds rare drop table.";
				break;
				
			case 12026:
				itemDef.name = "Saradomin Casket";
				itemDef.description = "100% chance for an item off the Saradomin gwds rare drop table.";
				break;
				
			case 12028:
				itemDef.name = "Zamorak Casket";
				itemDef.description = "100% chance for an item off the Zamorak gwds rare drop table.";
				break;
				
			case 964:
				itemDef.name = "Pet Petie";
				break;
				
		/*	case 17014:
				itemDef.name = "Dragon flail";
				itemDef.modelId = 50083;
				itemDef.modelZoom = 1440;
				itemDef.modelRotation2 = 272;
				itemDef.modelRotation1 = 352;
				itemDef.modelOffset1 = 32;
				//itemDef.modelOffset2 = 0;
				itemDef.maleModel = 50083;
				itemDef.femaleModel = 50083;
                itemDef.anInt164 = -1;
                itemDef.anInt188 = -1;
                itemDef.aByte205 = -8;
				itemDef.groundOptions = new String[] { null, null, "Take", null, null };
				itemDef.inventoryOptions = new String[] { "Wear", null, null, null, "Drop" };
				itemDef.description = "An Ancient Dragon Flail.";
				break;*/
				
			case 33168:
				itemDef.name = "Justiciar kiteshield";
				itemDef.modelId = 65471;
				itemDef.modelZoom = 1600;
				itemDef.modelRotationX = 250;
				itemDef.modelRotationY = 300;
				itemDef.translateX = -4;
				itemDef.translateYZ = -4;
				itemDef.maleModel = 65473;
				itemDef.femaleModel = 65474;
                //itemDef.anInt164 = -1;
                //itemDef.anInt188 = -1;
                //itemDef.aByte205 = -8;
				itemDef.groundOptions = new String[] { null, null, "Take", null, null };
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.description = "An ancient kiteshield. Part of the Justiciar set.";
				break;
				
			case 2996:
				itemDef.name = "PKP Ticket";
				itemDef.inventoryOptions = new String[5];
				itemDef.description = "Exchange this for a PK Point.";
				break;
			case 13226:
				itemDef.name = "Herb Sack";
				itemDef.inventoryOptions = new String[5];
				itemDef.description = "A sack for storing grimy herbs.";
				break;
			case 13346:
				itemDef.name = "Raid Mystery Box";
				itemDef.inventoryOptions = new String[] { "Open", null, null, null, "Drop" };
				itemDef.description = "Open for chances to receive Raid items & other awesome rewards.";
				break;
			case 8800:
				itemDef.name = "Donator Tokens";
				itemDef.modelId = 15343;
				itemDef.stackAmounts = new int[] { 2, 3, 50, 100, 500000, 1000000, 2500000, 10000000, 100000000, 0 };//amount the model will change at
				itemDef.stackIDs = new int[] { 8801, 8802, 8803, 8804, 8805, 8806, 8807, 8808, 8809, 0 };//new item id to grab the model from
				itemDef.stackable = true;
				itemDef.modifiedModelColors = new int[] {5813,9139};
				itemDef.newModelColors = new int[] {22450,22450};
				itemDef.modelZoom = 550;
				itemDef.modelRotationX = 1764;
				itemDef.modelRotationY = 202;
				itemDef.translateX = -10;
				itemDef.translateYZ = 8;
				itemDef.groundOptions = new String[] { null, null, "Take", null, null };
				itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
				itemDef.description = "Tokens for the Donator Store.";
				break;
			case 8801:
				itemDef.name = "Donator Tokens";
				itemDef.modelId = 15344;
				itemDef.stackable = true;
				itemDef.modifiedModelColors = new int[] {5813,9139};
				itemDef.newModelColors = new int[] {22450,22450};
				itemDef.modelZoom = 550;
				itemDef.modelRotationX = 1764;
				itemDef.modelRotationY = 202;
				itemDef.groundOptions = new String[] { null, null, "Take", null, null };
				itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
				itemDef.description = "Tokens for the Donator Store.";
				break;
			case 8802:
				itemDef.name = "Donator Tokens";
				itemDef.modelId = 15345;
				itemDef.stackable = true;
				itemDef.modifiedModelColors = new int[] {5813,9139};
				itemDef.newModelColors = new int[] {22450,22450};
				itemDef.modelZoom = 550;
				itemDef.modelRotationX = 1764;
				itemDef.modelRotationY = 202;
				itemDef.groundOptions = new String[] { null, null, "Take", null, null };
				itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
				itemDef.description = "Tokens for the Donator Store.";
				break;
			case 8803:
				itemDef.name = "Donator Coins";
				itemDef.modelId = 15346;
				itemDef.stackable = true;
				itemDef.modifiedModelColors = new int[] {5813,9139};
				itemDef.newModelColors = new int[] {22450,22450};
				itemDef.modelZoom = 550;
				itemDef.modelRotationX = 1764;
				itemDef.modelRotationY = 202;
				itemDef.groundOptions = new String[] { null, null, "Take", null, null };
				itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
				itemDef.description = "Tokens for the Donator Store.";
				break;
			case 8804:
				itemDef.name = "Donator Coins";
				itemDef.modelId = 15347;
				itemDef.stackable = true;
				itemDef.modifiedModelColors = new int[] {5813,9139};
				itemDef.newModelColors = new int[] {22450,22450};
				itemDef.modelZoom = 550;
				itemDef.modelRotationX = 1764;
				itemDef.modelRotationY = 202;
				itemDef.groundOptions = new String[] { null, null, "Take", null, null };
				itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
				itemDef.description = "Tokens for the Donator Store.";
				break;
			case 8805:
				itemDef.name = "Donator Coins";
				itemDef.modelId = 15348;
				itemDef.stackable = true;
				itemDef.modifiedModelColors = new int[] {5813,9139};
				itemDef.newModelColors = new int[] {22450,22450};
				itemDef.modelZoom = 550;
				itemDef.modelRotationX = 1764;
				itemDef.modelRotationY = 202;
				itemDef.groundOptions = new String[] { null, null, "Take", null, null };
				itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
				itemDef.description = "Tokens for the Donator Store.";
				break;
			case 8806:
				itemDef.name = "Donator Coins";
				itemDef.modelId = 15349;
				itemDef.stackable = true;
				itemDef.modifiedModelColors = new int[] {5813,9139};
				itemDef.newModelColors = new int[] {22450,22450};
				itemDef.modelZoom = 550;
				itemDef.modelRotationX = 1764;
				itemDef.modelRotationY = 202;
				itemDef.groundOptions = new String[] { null, null, "Take", null, null };
				itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
				itemDef.description = "Tokens for the Donator Store.";
				break;
			case 8807:
				itemDef.name = "Donator Coins";
				itemDef.modelId = 15350;
				itemDef.stackable = true;
				itemDef.modifiedModelColors = new int[] {5813,9139};
				itemDef.newModelColors = new int[] {22450,22450};
				itemDef.modelZoom = 550;
				itemDef.modelRotationX = 1764;
				itemDef.modelRotationY = 202;
				itemDef.groundOptions = new String[] { null, null, "Take", null, null };
				itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
				itemDef.description = "Tokens for the Donator Store.";
				break;
			case 8808:
				itemDef.name = "Donator Coins";
				itemDef.modelId = 15351;
				itemDef.stackable = true;
				itemDef.modifiedModelColors = new int[] {5813,9139};
				itemDef.newModelColors = new int[] {22450,22450};
				itemDef.modelZoom = 550;
				itemDef.modelRotationX = 1764;
				itemDef.modelRotationY = 202;
				itemDef.groundOptions = new String[] { null, null, "Take", null, null };
				itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
				itemDef.description = "Tokens for the Donator Store.";
				break;
			case 8809:
				itemDef.name = "Donator Coins";
				itemDef.modelId = 15352;
				itemDef.stackable = true;
				itemDef.modifiedModelColors = new int[] {5813,9139};
				itemDef.newModelColors = new int[] {22450,22450};
				itemDef.modelZoom = 550;
				itemDef.modelRotationX = 1764;
				itemDef.modelRotationY = 202;
				itemDef.groundOptions = new String[] { null, null, "Take", null, null };
				itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
				itemDef.description = "Tokens for the Donator Store.";
				break;
			case 15098:
				itemDef.name = "Dice (up to 100)";
				itemDef.description = "A 100-sided dice.";
				itemDef.modelId = 31223;
				itemDef.modelZoom = 1104;
				itemDef.modelRotationX = 215;
				itemDef.modelRotationY = 94;
				itemDef.translateYZ = -5;
				itemDef.translateX = -18;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Public-roll";
				itemDef.inventoryOptions[2] = null;
				itemDef.name = "Dice (up to 100)";
				itemDef.anInt196 = 15;
				itemDef.anInt184 = 25;
				break;
				
			case 32991:
				itemDef.name = "Divine spirit shield";
				itemDef.description = "An ethereal shield with an divine sigil attached to it.";
				itemDef.modelId = 50001;
				itemDef.maleModel = 50002;
				itemDef.femaleModel = 50002;
				itemDef.modelZoom = 1616;
				itemDef.modelRotationX = 1050;
				itemDef.modelRotationY = 396;
				itemDef.translateYZ = 4;
				itemDef.translateX = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = -8;
				break;
			case 32992:
				itemDef.name = "Rainbow spirit shield";
				itemDef.description = "An ethereal shield with all 4 sigils attached to it.";
				itemDef.modelId = 50004;
				itemDef.maleModel = 50005;
				itemDef.femaleModel = 50005;
				itemDef.modelZoom = 1616;
				itemDef.modelRotationX = 1050;
				itemDef.modelRotationY = 396;
				itemDef.translateYZ = 4;
				itemDef.translateX = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 32993:
				itemDef.name = "Divine sigil";
				itemDef.description = "A sigil in the shape of a divine symbol.";
				itemDef.modelId = 50003;
				itemDef.modelZoom = 848;
				itemDef.modelRotationY = 267;
				itemDef.modelRotationX = 138;
				itemDef.translateX = 5;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				break;
			case 33060:
				itemDef.name = "Barrows Sword";
				itemDef.description = "A sword glowing with otherworldy energy.";
				itemDef.modelId = 22325;
				itemDef.maleModel = 50010;
				itemDef.femaleModel = 50010;
				itemDef.modelZoom = 1616;
				itemDef.modelRotationX = 1050;
				itemDef.modelRotationY = 396;
				itemDef.translateYZ = 4;
				itemDef.translateX = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = -8;
				break;
			case 32994:
				itemDef.name = "Statius's platebody";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42602;
				itemDef.maleModel= 35951;
				itemDef.femaleModel= 35964;
				itemDef.modelZoom = 1312;
				itemDef.modelRotationY = 272;
				itemDef.modelRotationX = 2047;
				itemDef.translateX = -2;
				itemDef.translateYZ = 39;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 32995:
				itemDef.name = "Statius's platelegs";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42590;
				itemDef.maleModel= 35947;
				itemDef.femaleModel= 35961;
				itemDef.modelZoom = 1625;
				itemDef.modelRotationY = 355;
				itemDef.modelRotationX = 2046;
				itemDef.translateX = 0;
				itemDef.translateYZ = -11;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 32996:
				itemDef.name = "Statius's full helm";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42596;
				itemDef.maleModel= 35943;
				itemDef.femaleModel= 35958;
				itemDef.modelZoom = 789;
				itemDef.modelRotationY = 96;
				itemDef.modelRotationX = 2039;
				itemDef.translateX = 2;
				itemDef.translateYZ = -7;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 32997:
				itemDef.name = "Statius's warhammer";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42577;
				itemDef.maleModel= 35968;
				itemDef.femaleModel= 35968;
				itemDef.modelZoom = 1360;
				itemDef.modelRotationY = 507;
				itemDef.modelRotationX = 27;
				itemDef.translateX = 7;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 32998:
				itemDef.name = "Vesta's chainbody";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42593;
				itemDef.maleModel= 35953;
				itemDef.femaleModel= 35965;
				itemDef.modelZoom = 1440;
				itemDef.modelRotationY = 545;
				itemDef.modelRotationX = 2;
				itemDef.translateX = 4;
				itemDef.translateYZ = 5;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 32999:
				itemDef.name = "Vesta's plateskirt";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42581;
				itemDef.maleModel= 35950;
				itemDef.femaleModel= 35960;
				itemDef.modelZoom = 1753;
				itemDef.modelRotationY = 562;
				itemDef.modelRotationX = 1;
				itemDef.translateX = -3;
				itemDef.translateYZ = 11;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33000:
				itemDef.name = "Vesta's longsword";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42597;
				itemDef.maleModel= 35969;
				itemDef.femaleModel= 35969;
				itemDef.modelZoom = 1744;
				itemDef.modelRotationY = 738;
				itemDef.modelRotationX = 1985;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.maleOffset = -8;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;	
			case 33001:
				itemDef.name = "Vesta's spear";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42599;
				itemDef.maleModel= 35973;
				itemDef.femaleModel= 35973;
				itemDef.modelZoom = 2022;
				itemDef.modelRotationY = 480;
				itemDef.modelRotationX = 15;
				itemDef.translateX = 0;
				itemDef.translateYZ = 5;
				itemDef.maleOffset = -8;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33002:
				itemDef.name = "Morrigan's leather body";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42578;
				itemDef.maleModel= 35954;
				itemDef.femaleModel= 35963;
				itemDef.modelZoom = 1440;
				itemDef.modelRotationY = 545;
				itemDef.modelRotationX = 2;
				itemDef.translateX = -2;
				itemDef.translateYZ = 5;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33003:
				itemDef.name = "Morrigan's leather chaps";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42603;
				itemDef.maleModel= 35948;
				itemDef.femaleModel= 35959;
				itemDef.modelZoom = 1753;
				itemDef.modelRotationY = 482;
				itemDef.modelRotationX = 1;
				itemDef.translateX = -3;
				itemDef.translateYZ = 11;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;	
			case 33004:
				itemDef.name = "Morrigan's coif";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42583;
				itemDef.maleModel= 35945;
				itemDef.femaleModel= 35956;
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 537;
				itemDef.modelRotationX = 5;
				itemDef.translateX = -3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;	
			case 33005:
				itemDef.name = "Morrigan's javelin";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42592;
				itemDef.stackable = true;
				itemDef.maleModel = 42613;
				itemDef.femaleModel = 42613;
				itemDef.modelZoom = 1872;
				itemDef.modelRotationY = 282;
				itemDef.modelRotationX = 2009;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.maleOffset = -8;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;	
			case 33006:
				itemDef.name = "Morrigan's throwing axe";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42582;
				itemDef.stackable = true;
				itemDef.maleModel = 42611;
				itemDef.femaleModel = 42611;
				itemDef.modelZoom = 976;
				itemDef.modelRotationY = 672;
				itemDef.modelRotationX = 2024;
				itemDef.translateX = -5;
				itemDef.maleOffset = -8;
				itemDef.translateYZ = 4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;		
			case 33007:
				itemDef.name = "Zuriels robe top";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42591;
				itemDef.maleModel= 35952;
				itemDef.femaleModel= 35966;
				itemDef.modelZoom = 1373;
				itemDef.modelRotationY = 373;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = -7;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;	
			case 33008:
				itemDef.name = "Zuriels robe bottom";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42588;
				itemDef.maleModel= 35949;
				itemDef.femaleModel= 35962;
				itemDef.modelZoom = 1697;
				itemDef.modelRotationY = 512;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 2;
				itemDef.translateYZ = -9;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;	
			case 33009:
				itemDef.name = "Zuriels hood";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42604;
				itemDef.maleModel= 35944;
				itemDef.femaleModel= 35957;
				itemDef.modelZoom = 720;
				itemDef.modelRotationY = 28;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 1;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;	
			case 33010:
				itemDef.name = "Zuriels staff";
				itemDef.description = "This item degrades in combat, and will turn to dust.";
				itemDef.modelId = 42595;
				itemDef.maleModel= 35971;
				itemDef.femaleModel= 35971;
				itemDef.modelZoom = 2000;
				itemDef.modelRotationY = 366;
				itemDef.modelRotationX = 3;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;	

			case 33011:
				itemDef.name = "Craw's bow (u)";
				itemDef.description = "This bow once belonged to a formidable follower of Armadyl.";
				itemDef.modelId = 35777;
				itemDef.maleModel = 35768;
				itemDef.femaleModel = 35768;
				itemDef.modelZoom = 1979;
				itemDef.modelRotationY = 1463;
				itemDef.modelRotationX = 510;
				itemDef.translateX = -1;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33012:
				itemDef.name = "Craw's bow";
				itemDef.description = "This bow once belonged to a formidable follower of Armadyl.";
				itemDef.modelId = 35777;
				itemDef.maleModel = 35769;
				itemDef.femaleModel = 35769;
				itemDef.modelZoom = 1979;
				itemDef.modelRotationY = 1463;
				itemDef.modelRotationX = 510;
				itemDef.translateX = -1;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33013:
				itemDef.name = "Thammaron's sceptre (u)";
				itemDef.description = "A mighty sceptre used in long forgotten battles.";
				itemDef.modelId = 35776;
				itemDef.maleModel = 35772;
				itemDef.femaleModel = 35772;
				itemDef.modelZoom = 2105;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 1020;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;	
			case 33014:
				itemDef.name = "Thammaron's sceptre";
				itemDef.description = "A mighty sceptre used in long forgotten battles.";
				itemDef.modelId = 35776;
				itemDef.maleModel = 35773;
				itemDef.femaleModel = 35773;
				itemDef.modelZoom = 2105;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 1020;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;	
			case 33015:
				itemDef.name = "Viggora's chainmace (u)";
				itemDef.description = "An ancient chainmace with a peculiar mechanism that allows for varying attack styles.";
				itemDef.modelId = 35778;
				itemDef.maleModel = 35770;
				itemDef.femaleModel = 35770;
				itemDef.modelZoom = 1616;
				itemDef.modelRotationY = 252;
				itemDef.modelRotationX = 944;
				itemDef.translateX = -1;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33016:
				itemDef.name = "Viggora's chainmace";
				itemDef.description = "An ancient chainmace with a peculiar mechanism that allows for varying attack styles.";
				itemDef.modelId = 35778;
				itemDef.maleModel = 35771;
				itemDef.femaleModel = 35771;
				itemDef.modelZoom = 1616;
				itemDef.modelRotationY = 252;
				itemDef.modelRotationX = 944;
				itemDef.translateX = -1;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33018:
				itemDef.name = "Amulet of avarice";
				itemDef.description = "A hauntingly beautiful amulet bearing the shape of a skull.";
				itemDef.modelId = 35779;
				itemDef.maleModel = 35766;
				itemDef.femaleModel = 35766;
				itemDef.modelZoom = 420;
				itemDef.modelRotationY = 191;
				itemDef.modelRotationX = 86;
				itemDef.translateX = -1;
				itemDef.translateYZ = -5;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33019:
				itemDef.name = "Completionist cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				itemDef.modelId = 65270;
				itemDef.maleModel = 65297;
				itemDef.femaleModel = 65316;
				itemDef.modelZoom = 1316;
				itemDef.modelRotationY = 252;
				itemDef.modelRotationX = 1020;
				itemDef.translateX = -1;
				itemDef.translateYZ = 24;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 3;
				break;
			case 33020:
				itemDef.name = "Completionist cape (t)";
				itemDef.description = "	A cape worn by those who've overachieved.";
				itemDef.modelId = 65258;
				itemDef.maleModel = 65295;
				itemDef.femaleModel = 65328;
				itemDef.modelZoom = 1316;
				itemDef.modelRotationY = 252;
				itemDef.modelRotationX = 1020;
				itemDef.translateX = -1;
				itemDef.translateYZ = 24;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 3;
				break;
			case 33021:
				itemDef.name = "Torva full helm";
				itemDef.description = "An ancient warrior's full helm.";
				itemDef.modelId = 62714;
				itemDef.maleModel = 62738;
				itemDef.femaleModel = 62738;
				itemDef.modelZoom = 672;
				itemDef.modelRotationY = 85;
				itemDef.modelRotationX = 1867;
				itemDef.translateX = 0;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33022:
				itemDef.name = "Torva platebody";
				itemDef.description = "An ancient warrior's platebody.";
				itemDef.modelId = 62699;
				itemDef.maleModel = 62746;
				itemDef.femaleModel = 62746;
				itemDef.modelZoom = 1506;
				itemDef.modelRotationY = 473;
				itemDef.modelRotationX = 2042;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33023:
				itemDef.name = "Torva platelegs";
				itemDef.description = "An ancient warrior's platelegs.";
				itemDef.modelId = 62701;
				itemDef.maleModel = 62743;
				itemDef.femaleModel = 62743;
				itemDef.modelZoom = 1740;
				itemDef.modelRotationY = 474;
				itemDef.modelRotationX = 2045;
				itemDef.translateX = 0;
				itemDef.translateYZ = -5;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33024:
				itemDef.name = "Pernix cowl";
				itemDef.description = "An ancient warrior's cowl.";
				itemDef.modelId = 62693;
				itemDef.maleModel = 62739;
				itemDef.femaleModel = 62739;
				itemDef.modelZoom = 800;
				itemDef.modelRotationY = 532;
				itemDef.modelRotationX = 14;
				itemDef.translateX = -1;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33025:
				itemDef.name = "Pernix body";
				itemDef.description = "An ancient warrior's leather body.";
				itemDef.modelId = 62709;
				itemDef.maleModel = 62744;
				itemDef.femaleModel = 62744;
				itemDef.modelZoom = 1378;
				itemDef.modelRotationY = 485;
				itemDef.modelRotationX = 2042;
				itemDef.translateX = -1;
				itemDef.translateYZ = 7;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33026:
				itemDef.name = "Pernix chaps";
				itemDef.description = "An ancient warrior's chaps.";
				itemDef.modelId = 62695;
				itemDef.maleModel = 62741;
				itemDef.femaleModel = 62741;
				itemDef.modelZoom = 1740;
				itemDef.modelRotationY = 504;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 4;
				itemDef.translateYZ = 3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33027:
				itemDef.name = "Virtus mask";
				itemDef.description = "An ancient warrior's mask.";
				itemDef.modelId = 62710;
				itemDef.maleModel = 62736;
				itemDef.femaleModel = 62736;
				itemDef.modelZoom = 928;
				itemDef.modelRotationY = 406;
				itemDef.modelRotationX = 2041;
				itemDef.translateX = 1;
				itemDef.translateYZ = -5;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33028:
				itemDef.name = "Virtus robe top";
				itemDef.description = "An ancient warrior's robe top.";
				itemDef.modelId = 62704;
				itemDef.maleModel = 62748;
				itemDef.femaleModel = 62748;
				itemDef.modelZoom = 1122;
				itemDef.modelRotationY = 488;
				itemDef.modelRotationX = 3;
				itemDef.translateX = 1;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33029:
				itemDef.name = "Virtus robe legs";
				itemDef.description = "An ancient warrior's robe legs.";
				itemDef.modelId = 62700;
				itemDef.maleModel = 62742;
				itemDef.femaleModel = 62742;
				itemDef.modelZoom = 1740;
				itemDef.modelRotationY = 498;
				itemDef.modelRotationX = 2045;
				itemDef.translateX = -1;
				itemDef.translateYZ = 4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33030:
				itemDef.name = "Zaryte bow";
				itemDef.description = "An ancient warrior's bow.";
				itemDef.modelId = 62692;
				itemDef.maleModel = 62750;
				itemDef.femaleModel = 61750;
				itemDef.modelZoom = 1703;
				itemDef.modelRotationY = 221;
				itemDef.modelRotationX = 404;
				itemDef.translateX = 0;
				itemDef.translateYZ = -13;
				itemDef.maleOffset = -8;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
            case 33083:
	itemDef.name = "Tokhaar-kal";
	itemDef.description = "	A cape made of ancient, enchanted obsidian.";
	itemDef.modelId = 52073;
	itemDef.maleModel = 52072;
	itemDef.femaleModel = 52071;
	itemDef.modelZoom = 1615;
	itemDef.modelRotationY = 339;
	itemDef.modelRotationX = 192;
	itemDef.translateX = -4;
	itemDef.translateYZ = 0;
	itemDef.inventoryOptions = new String[5];
	itemDef.inventoryOptions[1] = "Wear";
	itemDef.inventoryOptions[2] = null;
	itemDef.maleOffset = 3;
	break;
       case 33089:
	itemDef.name = "Chaotic maul";
	itemDef.description = "A maul used to claim life from those who don't deserve it.";
	itemDef.modelId = 54286;
	itemDef.maleModel = 56294;
	itemDef.femaleModel = 56294;
	itemDef.modelZoom = 1447;
	itemDef.modelRotationY = 525;
	itemDef.modelRotationX = 350;
	itemDef.translateX = 5;
	itemDef.translateYZ = 3;
	itemDef.inventoryOptions = new String[5];
	itemDef.inventoryOptions[1] = "Wear";
	itemDef.inventoryOptions[2] = null;
	break;
case 33094:
	itemDef.name = "Chaotic crossbow";
	itemDef.description = "A small crossbow, only effective at short distance.";
	itemDef.modelId = 54331;
	itemDef.maleModel = 56307;
	itemDef.femaleModel = 56307;
	itemDef.modelZoom = 1028;
	itemDef.modelRotationY = 249;
	itemDef.modelRotationX = 2021;
	itemDef.translateX = -1;
	itemDef.translateYZ = -54;
	itemDef.inventoryOptions = new String[5];
	itemDef.inventoryOptions[1] = "Wear";
	itemDef.inventoryOptions[2] = null;
	break;
case 33095:
	itemDef.name = "Chaotic staff";
	itemDef.description = "This staff makes destructive spells more powerful.";
	itemDef.modelId = 54367;
	itemDef.maleModel = 56286;
	itemDef.femaleModel = 56286;
	itemDef.modelZoom = 1711;
	itemDef.modelRotationY = 471;
	itemDef.modelRotationX = 391;
	itemDef.translateX = 0;
	itemDef.translateYZ = -1;
	itemDef.inventoryOptions = new String[5];
	itemDef.inventoryOptions[1] = "Wear";
	itemDef.inventoryOptions[2] = null;
	break;
case 33096:
	itemDef.name = "Chaotic kiteshield";
	itemDef.description = "A large metal shield.";
	itemDef.modelId = 54358;
	itemDef.maleModel = 56038;
	itemDef.femaleModel = 56038;
	itemDef.modelZoom = 1488;
	itemDef.modelRotationY = 276;
	itemDef.modelRotationX = 1101;
	itemDef.translateX = -5;
	itemDef.translateYZ = 0;
	itemDef.inventoryOptions = new String[5];
	itemDef.inventoryOptions[1] = "Wear";
	itemDef.inventoryOptions[2] = null;
	break;
          case 33031:
	itemDef.name = "Chaotic rapier";
	itemDef.description = "A razor-sharp rapier.";
	itemDef.modelId = 54197;
	itemDef.maleModel = 56252;
	itemDef.femaleModel = 56252;
	itemDef.modelZoom = 1425;
	itemDef.modelRotationY = 540;
	itemDef.modelRotationX = 1370;
	itemDef.translateX = 9;
	itemDef.translateYZ = 13;
	itemDef.maleOffset = -12;
	itemDef.inventoryOptions = new String[5];
	itemDef.inventoryOptions[1] = "Wear";
	itemDef.inventoryOptions[2] = null;
	break;
case 33032:
	itemDef.name = "Chaotic longsword";
	itemDef.description = "A razor-sharp longsword.";
	itemDef.modelId = 54204;
	itemDef.maleModel = 56237;
	itemDef.femaleModel = 56237;
	itemDef.modelZoom = 1650;
	itemDef.modelRotationY = 498;
	itemDef.modelRotationX = 1300;
	//itemDef.aByte154 = -14;
	itemDef.translateX = 3;
	itemDef.translateYZ = 0;
	itemDef.inventoryOptions = new String[5];
	itemDef.inventoryOptions[1] = "Wear";
	itemDef.inventoryOptions[2] = null;
	break;
case 33097:
	itemDef.name = "Sword of Eldrax";
	itemDef.description = "A razor-sharp longsword.";
	itemDef.modelId = 53091;
	itemDef.maleModel = 53092;
	itemDef.femaleModel = 53092;
	itemDef.modelZoom = 2007;
	itemDef.modelRotationY = 512;
	itemDef.modelRotationX = 2047;
	itemDef.translateX = 1;
	itemDef.translateYZ = -3;
	itemDef.inventoryOptions = new String[5];
	itemDef.inventoryOptions[1] = "Wear";
	itemDef.inventoryOptions[2] = null;
	break;
case 33098:
	itemDef.name = "Eldrax longsword";
	itemDef.description = "A razor-sharp 2h sword.";
	itemDef.modelId = 53093;
	itemDef.maleModel = 53094;
	itemDef.femaleModel = 53094;
	itemDef.modelZoom = 4007;
	itemDef.modelRotationY = 512;
	itemDef.modelRotationX = 2047;
	itemDef.maleOffset = -8;
	itemDef.translateX = 1;
	itemDef.translateYZ = -3;
	itemDef.inventoryOptions = new String[5];
	itemDef.inventoryOptions[1] = "Wear";
	itemDef.inventoryOptions[2] = null;
	break;
case 33099:
	itemDef.name = "White scimitar";
	itemDef.description = "A razor-sharp scimitar.";
	itemDef.modelId = 53097;
	itemDef.maleModel = 53098;
	itemDef.femaleModel = 53098;
	itemDef.modelZoom = 1513;
	itemDef.modelRotationY = 312;
	itemDef.modelRotationX = 0;
	//itemDef.aByte154 = -14;
	itemDef.translateX = 3;
	itemDef.translateYZ = -1;
	itemDef.inventoryOptions = new String[5];
	itemDef.inventoryOptions[1] = "Wear";
	itemDef.inventoryOptions[2] = null;
	break;
case 33100:
	itemDef.name = "White kiteshield";
	itemDef.description = "a heavy kiteshield.";
	itemDef.modelId = 53095;
	itemDef.maleModel = 53096;
	itemDef.femaleModel = 53096;
	itemDef.modelZoom = 1616;
	itemDef.modelRotationY = 303;
	itemDef.modelRotationX = 180;
	//itemDef.aByte154 = -14;
	itemDef.translateX = -3;
	itemDef.translateYZ = 7;
	itemDef.inventoryOptions = new String[5];
	itemDef.inventoryOptions[1] = "Wear";
	itemDef.inventoryOptions[2] = null;
	break;
			case 33033:
				itemDef.name = "Agility master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				                                                       //4 //7  //10  //13 //14//16//18//22 //24//39
				itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
				itemDef.newModelColors = new int[] {677, 801, 43540, 43543, 43546, 43549, 43550, 43552, 43554, 43558, 43560, 43575 };
				itemDef.modelId = 50030;
				itemDef.maleModel = 50031;
				itemDef.femaleModel = 50031;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33034:
				itemDef.name = "Attack master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
                                                                       //4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {7104, 9151, 911, 914, 917, 920, 921, 923, 925, 929, 931, 946 };
				itemDef.modelId = 50032;
				itemDef.maleModel = 50033;
				itemDef.femaleModel = 50033;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33035:
				itemDef.name = "Construction master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
                //4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {6061, 5945, 6327, 6330, 6333, 6336, 6337, 6339, 6341, 6345, 6347, 6362 };
				itemDef.modelId = 50034;
				itemDef.maleModel = 50035;
				itemDef.femaleModel = 50035;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33036:
				itemDef.name = "Cooking master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {920, 920, 51856, 51859, 51862, 51865, 51866, 51868, 51870, 51874, 51876, 51891 };
				itemDef.modelId = 50036;
				itemDef.maleModel = 50037;
				itemDef.femaleModel = 50037;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33037:
				itemDef.name = "Crafting master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {9142, 9152, 4511, 4514, 4517, 4520, 4521, 4523, 4525, 4529, 4531, 4546 };
				itemDef.modelId = 50038;
				itemDef.maleModel = 50039;
				itemDef.femaleModel = 50039;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33038:
				itemDef.name = "Defence master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {10460, 10473, 41410, 41413, 41416, 41419, 41420, 41422, 41424, 41428, 41430, 41445 };
				itemDef.modelId = 50040;
				itemDef.maleModel = 50041;
				itemDef.femaleModel = 50041;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33039:
				itemDef.name = "Farming master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {14775, 14792, 22026, 22029, 22032, 22035, 22036, 22038, 22040, 22044, 22046, 22061 };
				itemDef.modelId = 50042;
				itemDef.maleModel = 50043;
				itemDef.femaleModel = 50043;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33040:
				itemDef.name = "Firemaking master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {8125, 9152, 4015, 4018, 4021, 4024, 4025, 4027, 4029, 4033, 4035, 4050 };
				itemDef.modelId = 50044;
				itemDef.maleModel = 50045;
				itemDef.femaleModel = 50045;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33041:
				itemDef.name = "Fishing master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {9144, 9152, 38202, 38205, 38208, 38211, 38212, 38214, 38216, 38220, 38222, 38237 };
				itemDef.modelId = 50046;
				itemDef.maleModel = 50047;
				itemDef.femaleModel = 50047;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33042:
				itemDef.name = "Fletching master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {6067, 9152, 33670, 33673, 33676, 33679, 33680, 33682, 33684, 33688, 33690, 33705 };
				itemDef.modelId = 50048;
				itemDef.maleModel = 50049;
				itemDef.femaleModel = 50049;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33043:
				itemDef.name = "Herblore master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {9145, 9156, 22414, 22417, 22420, 22423, 22424, 22426, 22428, 22432, 22434, 22449 };
				itemDef.modelId = 50050;
				itemDef.maleModel = 50051;
				itemDef.femaleModel = 50051;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33044:
				itemDef.name = "Hitpoints master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {818, 951, 8291, 8294, 8297, 8300, 8301, 8303, 8305, 8309, 8311, 8319 };
				itemDef.modelId = 50052;
				itemDef.maleModel = 50053;
				itemDef.femaleModel = 50053;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				itemDef.femaleOffset = 4;
				break;
			case 33045:
				itemDef.name = "Hunter master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {5262, 6020, 8472, 8475, 8478, 8481, 8482, 8484, 8486, 8490, 8492, 8507 };
				itemDef.modelId = 50054;
				itemDef.maleModel = 50055;
				itemDef.femaleModel = 50055;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33046:
				itemDef.name = "Magic master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {43569, 43685, 6336, 6339, 6342, 6345, 6346, 6348, 6350, 6354, 6356, 6371 };
				itemDef.modelId = 50056;
				itemDef.maleModel = 50057;
				itemDef.femaleModel = 50057;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33047:
				itemDef.name = "Mining master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {36296, 36279, 10386, 10389, 10392, 10395, 10396, 10398, 10400, 10404, 10406, 10421 };
				itemDef.modelId = 50058;
				itemDef.maleModel = 50059;
				itemDef.femaleModel = 50059;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33048:
				itemDef.name = "Prayer master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {9163, 9168, 117, 120, 123, 126, 127, 127, 127, 127, 127, 127 };
				itemDef.modelId = 50060;
				itemDef.maleModel = 50061;
				itemDef.femaleModel = 50061;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33049:
				itemDef.name = "Range master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {3755, 3998, 15122, 15125, 15128, 15131, 15132, 15134, 15136, 15140, 15142, 15157 };
				itemDef.modelId = 50062;
				itemDef.maleModel = 50063;
				itemDef.femaleModel = 50063;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33050:
				itemDef.name = "Runecrafting master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				//4 //7  //10  //13 //14//16//18//22 //24//39
                itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
                itemDef.newModelColors = new int[] {9152, 8128, 10318, 10321, 10324, 10327, 10328, 10330, 10332, 10336, 10338, 10353 };
				itemDef.modelId = 50064;
				itemDef.maleModel = 50065;
				itemDef.femaleModel = 50065;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33051:
				itemDef.name = "Slayer master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				itemDef.modifiedModelColors = new int[] {57022, 48811};
	            itemDef.newModelColors = new int[] {912, 920};
				itemDef.modelId = 50066;
				itemDef.maleModel = 50067;
				itemDef.femaleModel = 50067;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33052:
				itemDef.name = "Smithing master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
	            itemDef.newModelColors = new int[] {8115, 9148, 10386, 10389, 10392, 10395, 10396, 10398, 10400, 10404, 10406, 10421 };
				itemDef.modelId = 50068;
				itemDef.maleModel = 50069;
				itemDef.femaleModel = 50069;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33053:
				itemDef.name = "Strength master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
	            itemDef.newModelColors = new int[] {935, 931, 27538, 27541, 27544, 27547, 27548, 27550, 27552, 27556, 27558, 27573 };
				itemDef.modelId = 50070;
				itemDef.maleModel = 50071;
				itemDef.femaleModel = 50071;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33054:
				itemDef.name = "Thieving master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
	            itemDef.newModelColors = new int[] {11, 0, 58779, 58782, 58785, 58788, 58789, 57891, 58793, 58797, 58799, 58814 };
				itemDef.modelId = 50072;
				itemDef.maleModel = 50073;
				itemDef.femaleModel = 50073;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33055:
				itemDef.name = "Woodcutting master cape";
				itemDef.description = "	A cape worn by those who've overachieved.";
				itemDef.modifiedModelColors = new int[] {57022, 48811, 2, 1029, 1032, 11, 12, 14, 16,    20, 22, 2 };
	            itemDef.newModelColors = new int[] {25109, 24088, 6693, 6696, 6699, 6702, 6703, 6705, 6707, 6711, 6713, 6728 };
				itemDef.modelId = 50074;
				itemDef.maleModel = 50075;
				itemDef.femaleModel = 50075;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				itemDef.maleOffset = 5;
				break;
			case 33057:
				itemDef.name = "Abyssal Scythe";
				itemDef.description = "	A Scythe recieved from the Trials of Xeric CUSTOM RAID.";
				itemDef.modelId = 50081;
				itemDef.maleModel = 50080;
				itemDef.femaleModel = 50080;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.maleOffset = -12;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33090:
				itemDef.name = "Goliath gloves (Black)";
				itemDef.description = "	A pair of gloves earned with blood.";
				itemDef.modelId = 50108;
				itemDef.maleModel = 50100;
				itemDef.femaleModel = 50101;
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 539;
				itemDef.modelRotationX = 40;
				itemDef.translateX = 1;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33091:
				itemDef.name = "Goliath gloves (Red)";
				itemDef.description = "	A pair of gloves earned with blood.";
				itemDef.modelId = 50108;
				itemDef.maleModel = 50102;
				itemDef.femaleModel = 50103;
				itemDef.modifiedModelColors = new int[] {10, 15, 20};
				itemDef.newModelColors = new int[] {65046, 65051, 65056};
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 539;
				itemDef.modelRotationX = 40;
				itemDef.translateX = 1;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33092:
				itemDef.name = "Goliath gloves (White)";
				itemDef.description = "	A pair of gloves earned with blood.";
				itemDef.modelId = 50108;
				itemDef.maleModel = 50104;
				itemDef.femaleModel = 50105;
				itemDef.modifiedModelColors = new int[] {10, 15, 20};
				itemDef.newModelColors = new int[] {64585, 64590, 64595};
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 539;
				itemDef.modelRotationX = 40;
				itemDef.translateX = 1;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33093:
				itemDef.name = "Goliath gloves (Yellow)";
				itemDef.description = "	A pair of gloves earned with blood.";
				itemDef.modelId = 50108;
				itemDef.maleModel = 50106;
				itemDef.femaleModel = 50107;
				itemDef.modifiedModelColors = new int[] {10, 15, 20};
				itemDef.newModelColors = new int[] {9767, 9772, 9777};
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 539;
				itemDef.modelRotationX = 40;
				itemDef.translateX = 1;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 12639:
			case 12637:
			case 12638:
				itemDef.description = "Provides players with infinite run energy!";
				break;
			case 33056:
				itemDef.name = "Events cape (slayer)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {933, 0, 0, 0, 0};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33081:
				itemDef.name = "Events cape (agility)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {669, 43430, 43430, 43430, 43430};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33080:
				itemDef.name = "Events cape (attack)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {9926, 1815, 1815, 1815, 1815};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33059:
				itemDef.name = "Events cape (construction)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {6967, 6343, 6343, 6343, 6343};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33061:
				itemDef.name = "Events cape (cooking)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {1819, 49685, 49685, 49685, 49685};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33062:
				itemDef.name = "Events cape (crafting)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {7994, 4516, 4516, 4516, 4516};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33063:
				itemDef.name = "Events cape (defence)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {39367, 10472, 10472, 10472, 10472};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33064:
				itemDef.name = "Events cape (farming)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {10698, 19734, 19734, 19734, 19734};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33065:
				itemDef.name = "Events cape (firemaking)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {10059, 4922, 4922, 4922, 4922};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33066:
				itemDef.name = "Events cape (fishing)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {10047, 36165, 36165, 36165, 36165};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33067:
				itemDef.name = "Events cape (fletching)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {10047, 31500, 31500, 31500, 31500};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33068:
				itemDef.name = "Events cape (herblore)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {10051, 20889, 20889, 20889, 20889};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33069:
				itemDef.name = "Events cape (hitpoints)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {1836, 8296, 8296, 8296, 8296};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33070:
				itemDef.name = "Events cape (hunter)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {6916, 8477, 8477, 8477, 8477};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33071:
				itemDef.name = "Events cape (magic)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {43556, 6339, 6339, 6339, 6339};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33072:
				itemDef.name = "Events cape (mining)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {34111, 10391, 10391, 10391, 10391};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33073:
				itemDef.name = "Events cape (prayer)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {9927, 2169, 2169, 2169, 2169};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33074:
				itemDef.name = "Events cape (range)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {3626, 20913, 20913, 20913, 20913};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33075:
				itemDef.name = "Events cape (runecrafting)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {10047, 10323, 10323, 10323, 10323};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33076:
				itemDef.name = "Events cape (smithing)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {10044, 5412, 5412, 5412, 5412};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33077:
				itemDef.name = "Events cape (strength)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {1819, 30487, 30487, 30487, 30487};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33078:
				itemDef.name = "Events cape (thieveing)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {8, 57636, 57636, 57636, 57636};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33079:
				itemDef.name = "Events cape (woodcutting)";
				itemDef.description = "events cape.";
				itemDef.modifiedModelColors = new int[] {38333, 127, 107, 115, 90};
				itemDef.newModelColors = new int[] {26007, 6570, 6570, 6570, 6570};
				itemDef.modelId = 34418;
				itemDef.maleModel = 34271;
				itemDef.femaleModel = 34288;
				itemDef.modelZoom = 1960;
				itemDef.modelRotationY = 528;
				itemDef.modelRotationX = 1583;
				itemDef.translateX = 0;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33101:
				itemDef.name = "Vorkath platebody";
				itemDef.description = "Vorkath armour.";
				itemDef.modelId = 53100;
				itemDef.maleModel = 53099;
				itemDef.femaleModel = 53099;
				itemDef.modelZoom = 1513;
				itemDef.modelRotationY = 566;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 1;
				itemDef.translateYZ = -8;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33102:
				itemDef.name = "Vorkath platelegs";
				itemDef.description = "Vorkath armour.";
				itemDef.modelId = 53102;
				itemDef.maleModel = 53101;
				itemDef.femaleModel = 53101;
				itemDef.modelZoom = 1753;
				itemDef.modelRotationY = 562;
				itemDef.modelRotationX = 1;
				itemDef.translateX = 11;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33103:
				itemDef.name = "Vorkath boots";
				itemDef.description = "Vorkath armour.";
				itemDef.modelId = 53104;
				itemDef.maleModel = 53103;
				itemDef.femaleModel = 53103;
				itemDef.modelZoom = 855;
				itemDef.modelRotationY = 215;
				itemDef.modelRotationX = 94;
				itemDef.translateX = 4;
				itemDef.translateYZ = -32;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33104:
				itemDef.name = "Vorkath gloves";
				itemDef.description = "Vorkath armour.";
				itemDef.modelId = 53106;
				itemDef.maleModel = 53105;
				itemDef.femaleModel = 53105;
				itemDef.modelZoom = 855;
				itemDef.modelRotationY = 215;
				itemDef.modelRotationX = 94;
				itemDef.translateX = 4;
				itemDef.translateYZ = -32;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33105:
				itemDef.name = "Vorkath helmet";
				itemDef.description = "Vorkath armour.";
				itemDef.modelId = 53108;
				itemDef.maleModel = 53107;
				itemDef.femaleModel = 53107;
				itemDef.modelZoom = 1010;
				itemDef.modelRotationY = 16;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 2;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33106:
				itemDef.name = "Tekton helmet";
				itemDef.description = "Tekton armour.";
				itemDef.modelId = 53118;
				itemDef.maleModel = 53117;
				itemDef.femaleModel = 53117;
				itemDef.modelZoom = 724;
				itemDef.modelRotationY = 81;
				itemDef.modelRotationX = 1670;
				itemDef.translateX = 0;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33107:
				itemDef.name = "Tekton platebody";
				itemDef.description = "Tekton armour.";
				itemDef.modelId = 53110;
				itemDef.maleModel = 53109;
				itemDef.femaleModel = 53109;
				itemDef.modelZoom = 1513;
				itemDef.modelRotationY = 566;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 1;
				itemDef.translateYZ = -8;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33108:
				itemDef.name = "Tekton platelegs";
				itemDef.description = "Tekton armour.";
				itemDef.modelId = 53112;
				itemDef.maleModel = 53111;
				itemDef.femaleModel = 53111;
				itemDef.modelZoom = 1550;
				itemDef.modelRotationY = 344;
				itemDef.modelRotationX = 186;
				itemDef.translateX = 5;
				itemDef.translateYZ = 11;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33109:
				itemDef.name = "Tekton gloves";
				itemDef.description = "Tekton armour.";
				itemDef.modelId = 53116;
				itemDef.maleModel = 53115;
				itemDef.femaleModel = 53115;
				itemDef.modelZoom = 830;
				itemDef.modelRotationY = 536;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33110:
				itemDef.name = "Tekton boots";
				itemDef.description = "Tekton armour.";
				itemDef.modelId = 53114;
				itemDef.maleModel = 53113;
				itemDef.femaleModel = 53113;
				itemDef.modelZoom = 855;
				itemDef.modelRotationY = 215;
				itemDef.modelRotationX = 94;
				itemDef.translateX = 4;
				itemDef.translateYZ = -32;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33111:
				itemDef.name = "Anti-santa scythe";
				itemDef.description = "Legend says this is the biggest arse scratcher around.";
				itemDef.modelId = 57002;
				itemDef.maleModel = 57001;
				itemDef.femaleModel = 57001;
				itemDef.modelZoom = 3224;
				itemDef.modelRotationY = 539;
				itemDef.modelRotationX = 714;
				itemDef.translateX = -1;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33112:
				itemDef.name = "Dominion staff";
				itemDef.description = "Dominion staff.";
				itemDef.modelId = 59029;
				itemDef.maleModel = 59305;
				itemDef.femaleModel = 59305;
				itemDef.modelZoom = 1872;
				itemDef.modelRotationY = 288;
				itemDef.modelRotationX = 1685;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33113:
				itemDef.name = "Dominion sword";
				itemDef.description = "Dominion sword.";
				itemDef.modelId = 59832;
				itemDef.maleModel = 59306;
				itemDef.femaleModel = 59306;
				itemDef.modelZoom = 1829;
				itemDef.modelRotationY = 513;
				itemDef.modelRotationX = 546;
				itemDef.translateX = 5;
				itemDef.translateYZ = 3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33114:
				itemDef.name = "Dominion crossbow";
				itemDef.description = "Dominion crossbow.";
				itemDef.modelId = 59839;
				itemDef.maleModel = 59304;
				itemDef.femaleModel = 59304;
				itemDef.modelZoom = 1490;
				itemDef.modelRotationY = 362;
				itemDef.modelRotationX = 791;
				itemDef.translateX = 1;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33115:
				itemDef.name = "Unamed shield";
				itemDef.description = "unamed shield.";
				itemDef.modelId = 53120;
				itemDef.maleModel = 53119;
				itemDef.femaleModel = 53119;
				itemDef.modelZoom = 2022;
				itemDef.modelRotationY = 540;
				itemDef.modelRotationX = 123;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33116:
				itemDef.name = "Zilyana's longbow";
				itemDef.description = "A bow belonged to Zilyana.";
				itemDef.modelId = 53122;
				itemDef.maleModel = 53121;
				itemDef.femaleModel = 53121;
				itemDef.modelZoom = 2000;
				itemDef.modelRotationY = 636;
				itemDef.modelRotationX = 1010;
				itemDef.translateX = 4;
				itemDef.translateYZ = 3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33117:
				itemDef.name = "Black dragon hunter crossbow";
				itemDef.description = "Black dragon hunter crossbow.";
				itemDef.modelId = 53124;
				itemDef.maleModel = 53123;
				itemDef.femaleModel = 53123;
				itemDef.modelZoom = 1554;
				itemDef.modelRotationY = 636;
				itemDef.modelRotationX = 1010;
				itemDef.translateX = 4;
				itemDef.translateYZ = 3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33118:
				itemDef.name = "Vorkath blowpipe";
				itemDef.description = "Vorkath blowpipe.";
				itemDef.modelId = 53126;
				itemDef.maleModel = 53125;
				itemDef.femaleModel = 53125;
				itemDef.modelZoom = 1158;
				itemDef.modelRotationY = 768;
				itemDef.modelRotationX = 189;
				itemDef.translateX = -7;
				itemDef.translateYZ = 4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33119:
				itemDef.name = "Black twisted bow";
				itemDef.description = "Black twisted bow.";
				itemDef.modelId = 53128;
				itemDef.maleModel = 53127;
				itemDef.femaleModel = 53127;
				itemDef.modelZoom = 2000;
				itemDef.modelRotationY = 720;
				itemDef.modelRotationX = 1500;
				itemDef.translateX = 3;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33123:
				itemDef.name = "Staff of sliske";
				itemDef.description = "Staff of sliske.";
				itemDef.modelId = 59234;
				itemDef.maleModel = 59233;
				itemDef.femaleModel = 59233;
				itemDef.modelZoom = 1872;
				itemDef.modelRotationY = 288;
				itemDef.modelRotationX = 1685;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33124:
				itemDef.name = "Twisted crossbow";
				itemDef.description = "Twisted crossbow.";
				itemDef.modelId = 62777;
				itemDef.maleModel = 62776;
				itemDef.femaleModel = 62776;
				itemDef.modelZoom = 926;
				itemDef.modelRotationY = 432;
				itemDef.modelRotationX = 258;
				itemDef.translateX = 0;
				itemDef.translateYZ = 3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33125:
				itemDef.name = "Present";
				itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
				itemDef.stackable = true;
				itemDef.modelId = 2426;
				itemDef.modelZoom = 1180;
				itemDef.modelRotationY = 160;
				itemDef.modelRotationX = 172;
				itemDef.translateX = 0;
				itemDef.translateYZ = -14;
				itemDef.modifiedModelColors = new int[] {22410,2999};
				itemDef.newModelColors = new int[] {933,24410};
				itemDef.description = "Santa's stolen present";
				break;
			case 33126:
				itemDef.name = "Christmas tree branch";
				itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
				itemDef.stackable = true;
				itemDef.modelId = 2412;
				itemDef.modelZoom = 940;
				itemDef.modelRotationY = 268;
				itemDef.modelRotationX = 152;
				itemDef.translateX = -8;
				itemDef.translateYZ = -21;
				itemDef.modifiedModelColors = new int[] {11144};
				itemDef.newModelColors = new int[] {6047};
				itemDef.description = "Enter examine here.";
				break;
			case 33127:
				itemDef.name = "Kbd gloves";
				itemDef.description = "Kbd gloves.";
				itemDef.modifiedModelColors = new int[] {33085};
				itemDef.newModelColors = new int[] {1060};
				itemDef.modelId = 53106;
				itemDef.maleModel = 53105;
				itemDef.femaleModel = 53105;
				itemDef.modelZoom = 855;
				itemDef.modelRotationY = 215;
				itemDef.modelRotationX = 94;
				itemDef.translateX = 4;
				itemDef.translateYZ = -32;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33128:
				itemDef.name = "Kbd boots";
				itemDef.description = "Kbd boots.";
				itemDef.modifiedModelColors = new int[] {33198, 33202, 33206, 33215, 33210};
				itemDef.newModelColors = new int[] {1060, 1061, 1063, 1064, 1065};
				itemDef.modelId = 53104;
				itemDef.maleModel = 53103;
				itemDef.femaleModel = 53103;
				itemDef.modelZoom = 855;
				itemDef.modelRotationY = 215;
				itemDef.modelRotationX = 94;
				itemDef.translateX = 4;
				itemDef.translateYZ = -32;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33129:
				itemDef.name = "Kbd platelegs";
				itemDef.description = "Kbd platelegs.";
				itemDef.modelId = 59994;
				itemDef.maleModel = 59995;
				itemDef.femaleModel = 59995;
				itemDef.modelZoom = 1753;
				itemDef.modelRotationY = 562;
				itemDef.modelRotationX = 1;
				itemDef.translateX = 11;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33130:
				itemDef.name = "Kbd platebody";
				itemDef.description = "Kbd platebody.";
				itemDef.modelId = 59998;
				itemDef.maleModel = 59999;
				itemDef.femaleModel = 59999;
				itemDef.modelZoom = 1513;
				itemDef.modelRotationY = 566;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 1;
				itemDef.translateYZ = -8;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33131:
				itemDef.name = "Kbd helmet";
				itemDef.description = "Kbd helmet.";
				itemDef.modelId = 59996;
				itemDef.maleModel = 59997;
				itemDef.femaleModel = 59997;
				itemDef.modelZoom = 1010;
				itemDef.modelRotationY = 16;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 2;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33132:
				itemDef.name = "Kbd cape";
				itemDef.description = "Kbd cape.";
				itemDef.modelId = 59992;
				itemDef.maleModel = 59993;
				itemDef.femaleModel = 59993;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 400;
				itemDef.modelRotationX = 948;
				itemDef.translateX = 3;
				itemDef.translateYZ = 6;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33133:
				itemDef.name = "Anti-imp pet";
				itemDef.description = "Anti-imp pet.";
				itemDef.modelId = 45294;
				itemDef.modelZoom = 1500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33134:
				itemDef.name = "Anti-santa pet";
				itemDef.description = "Anti-santa pet.";
				itemDef.modelId = 29030;
				itemDef.modelZoom = 653;
				itemDef.modelRotationY = 512;
				itemDef.modelRotationX = 1966;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33135:
				itemDef.name = "Bandos mask";
				itemDef.description = "Bandos helmet.";
				itemDef.modelId = 59987;
				itemDef.maleModel = 59991;
				itemDef.femaleModel = 59991;
				itemDef.modelZoom = 800;
				itemDef.modelRotationY = 16;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 2;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33136:
				itemDef.name = "Armadyl mask";
				itemDef.description = "Armadyl mask.";
				itemDef.modelId = 59986;
				itemDef.maleModel = 59990;
				itemDef.femaleModel = 59990;
				itemDef.modelZoom = 800;
				itemDef.modelRotationY = 16;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 2;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33137:
				itemDef.name = "Zamorak mask";
				itemDef.description = "Zamorak mask.";
				itemDef.modelId = 59985;
				itemDef.maleModel = 59989;
				itemDef.femaleModel = 59989;
				itemDef.modelZoom = 800;
				itemDef.modelRotationY = 16;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 2;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33138:
				itemDef.name = "Saradomin mask";
				itemDef.description = "Saradomin mask.";
				itemDef.modelId = 59984;
				itemDef.maleModel = 59988;
				itemDef.femaleModel = 59988;
				itemDef.modelZoom = 800;
				itemDef.modelRotationY = 16;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 2;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33139:
				itemDef.name = "Zamarok godbow";
				itemDef.description = "Zamarok godbow.";
				itemDef.modelId = 60553;
				itemDef.maleModel = 60552;
				itemDef.femaleModel = 60552;
				itemDef.modelZoom = 2100;
				itemDef.modelRotationY = 720;
				itemDef.modelRotationX = 1500;
				itemDef.translateX = 3;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33140:
				itemDef.name = "Saradomin godbow";
				itemDef.description = "Saradomin godbow.";
				itemDef.modelId = 60555;
				itemDef.maleModel = 60554;
				itemDef.femaleModel = 60554;
				itemDef.modelZoom = 2100;
				itemDef.modelRotationY = 720;
				itemDef.modelRotationX = 1500;
				itemDef.translateX = 3;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33141:
				itemDef.name = "Bandos godbow";
				itemDef.description = "Bandos godbow.";
				itemDef.modelId = 60559;
				itemDef.maleModel = 60558;
				itemDef.femaleModel = 60558;
				itemDef.modelZoom = 2100;
				itemDef.modelRotationY = 720;
				itemDef.modelRotationX = 1500;
				itemDef.translateX = 3;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33142:
				itemDef.name = "Fire cape (purple)";
				itemDef.description = "Fire cape (purple).";
				itemDef.modelId = 9631;
				itemDef.maleModel = 9638;
				itemDef.femaleModel = 9640;
				itemDef.modelZoom = 2086;
				itemDef.modelRotationY = 567;
				itemDef.modelRotationX = 2031;
				itemDef.translateX = 0;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33451:
				itemDef.name = "Infernus cape";
				itemDef.description = "An Infernus cape.";
				itemDef.modelId = 9631;
				itemDef.maleModel = 9638;
				itemDef.femaleModel = 9640;
				itemDef.modelZoom = 2086;
				itemDef.modelRotationY = 567;
				itemDef.modelRotationX = 2031;
				itemDef.translateX = 0;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				break;
			case 33148:
				itemDef.name = "Fire cape (cyan)";
				itemDef.description = "Fire cape (cyan).";
				itemDef.modelId = 9631;
				itemDef.maleModel = 9638;
				itemDef.femaleModel = 9640;
				itemDef.modelZoom = 2086;
				itemDef.modelRotationY = 567;
				itemDef.modelRotationX = 2031;
				itemDef.translateX = 0;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33144:
				itemDef.name = "Fire cape (green)";
				itemDef.description = "Fire cape (green).";
				itemDef.modelId = 9631;
				itemDef.maleModel = 9638;
				itemDef.femaleModel = 9640;
				itemDef.modelZoom = 2086;
				itemDef.modelRotationY = 567;
				itemDef.modelRotationX = 2031;
				itemDef.translateX = 0;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33145:
				itemDef.name = "Fire cape (red)";
				itemDef.description = "Fire cape (red).";
				itemDef.modelId = 9631;
				itemDef.maleModel = 9638;
				itemDef.femaleModel = 9640;
				itemDef.modelZoom = 2086;
				itemDef.modelRotationY = 567;
				itemDef.modelRotationX = 2031;
				itemDef.translateX = 0;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33143:
				itemDef.name = "Infernal cape (blue)";
				itemDef.description = "Infernal cape (blue).";
				itemDef.modifiedModelColors = new int[] {5056, 5066, 924, 3005};
				itemDef.newModelColors = new int[] {39851, 39851, 39851, 39851};
				itemDef.modelId = 33144;
				itemDef.maleModel = 33103;
				itemDef.femaleModel = 33111;
				itemDef.modelZoom = 2086;
				itemDef.modelRotationY = 567;
				itemDef.modelRotationX = 2031;
				itemDef.translateX = 0;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33146:
				itemDef.name = "Infernal cape (green)";
				itemDef.description = "Infernal cape (green)."; 
				itemDef.modifiedModelColors = new int[] {5056, 5066, 924, 3005};
				itemDef.newModelColors = new int[] {21167, 21167, 21167, 21167};
				itemDef.modelId = 33144;
				itemDef.maleModel = 33103;
				itemDef.femaleModel = 33111;
				itemDef.modelZoom = 2086;
				itemDef.modelRotationY = 567;
				itemDef.modelRotationX = 2031;
				itemDef.translateX = 0;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33147:
				itemDef.name = "Infernal cape (purple)";
				itemDef.description = "Infernal cape (purple).";
				itemDef.modifiedModelColors = new int[] {5056, 5066, 924, 3005};
				itemDef.newModelColors = new int[] {53160, 53160, 53160, 53160};
				itemDef.modelId = 33144;
				itemDef.maleModel = 33103;
				itemDef.femaleModel = 33111;
				itemDef.modelZoom = 2086;
				itemDef.modelRotationY = 567;
				itemDef.modelRotationX = 2031;
				itemDef.translateX = 0;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33150:
				itemDef.name = "Infernal key piece 1";
				itemDef.description = "Infernal key piece 1.";
				itemDef.modelId = 61001;
				itemDef.modelZoom = 1000;
				itemDef.modelRotationY = 534;
				itemDef.modelRotationX = 222;
				itemDef.translateX = -1;
				itemDef.translateYZ = 5;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[0] = "Combine";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33151:
				itemDef.name = "Infernal key piece 2";
				itemDef.description = "Infernal key piece 2.";
				itemDef.modelId = 61002;
				itemDef.modelZoom = 1000;
				itemDef.modelRotationY = 534;
				itemDef.modelRotationX = 222;
				itemDef.translateX = -1;
				itemDef.translateYZ = 5;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[0] = "Combine";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33152:
				itemDef.name = "Infernal key piece 3";
				itemDef.description = "Infernal key piece 3.";
				itemDef.modelId = 61003;
				itemDef.modelZoom = 1000;
				itemDef.modelRotationY = 534;
				itemDef.modelRotationX = 222;
				itemDef.translateX = -1;
				itemDef.translateYZ = 5;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[0] = "Combine";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33153:
				itemDef.name = "Infernal key";
				itemDef.description = "Infernal key.";
				itemDef.modelId = 61111;
				itemDef.modelZoom = 1000;
				itemDef.modelRotationY = 534;
				itemDef.modelRotationX = 222;
				itemDef.translateX = -1;
				itemDef.translateYZ = 5;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33154:
				itemDef.name = "Infernal mystery box";
				itemDef.description = "Infernal mystery box.";
				itemDef.modelId = 61110;
				itemDef.modelZoom = 1180;
				itemDef.modelRotationY = 160;
				itemDef.modelRotationX = 172;
				itemDef.translateX = 0;
				itemDef.translateYZ = -14;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[0] = "Open";
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33155:
				itemDef.name = "Ethereal sword (red)";
				itemDef.description = "Ethereal sword (red).";
				itemDef.modelId = 61005;
				itemDef.maleModel = 61004;
				itemDef.femaleModel = 61004;
				itemDef.modelZoom = 1645;
				itemDef.modelRotationY = 1549;
				itemDef.modelRotationX = 1791;
				itemDef.translateX = -1;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33156:
				itemDef.name = "Ethereal sword (blue)";
				itemDef.description = "Ethereal sword (blue).";
				itemDef.modelId = 61006;
				itemDef.maleModel = 61007;
				itemDef.femaleModel = 61007;
				itemDef.modelZoom = 1645;
				itemDef.modelRotationY = 1549;
				itemDef.modelRotationX = 1791;
				itemDef.translateX = -1;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33157:
				itemDef.name = "Ethereal sword (green)";
				itemDef.description = "Ethereal sword (green).";
				itemDef.modelId = 61008;
				itemDef.maleModel = 61009;
				itemDef.femaleModel = 61009;
				itemDef.modelZoom = 1645;
				itemDef.modelRotationY = 1549;
				itemDef.modelRotationX = 1791;
				itemDef.translateX = -1;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33158:
				itemDef.name = "Dagon' hai robe top";
				itemDef.description = "An elite dark mages robes.";
				itemDef.modelId = 60317;
				itemDef.maleModel = 43614;
				itemDef.femaleModel = 43689;
				itemDef.maleArm = 44594;
				itemDef.femaleArm = 43681;
				itemDef.modelZoom = 1697;
				itemDef.modelRotationY = 536;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 7;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33159:
				itemDef.name = "Dagon' hai hat";
				itemDef.description = "An elite dark mages hat.";
				itemDef.modelId = 60319;
				itemDef.maleModel = 60318;
				itemDef.femaleModel = 60318;
				itemDef.maleArm = -1;
				itemDef.femaleArm = -1;
				itemDef.modelZoom = 1373;
				itemDef.modelRotationY = 98;
				itemDef.modelRotationX = 1988;
				itemDef.translateX = 1;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33160:
				itemDef.name = "Dagon' hai robe bottom";
				itemDef.description = "An elite dark mages robe.";
				itemDef.modelId = 60321;
				itemDef.maleModel = 60320;
				itemDef.femaleModel = 60320;
				itemDef.maleArm = -1;
				itemDef.femaleArm = -1;
				itemDef.modelZoom = 2216;
				itemDef.modelRotationY = 572;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 14;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33161:
				itemDef.name = "Blue infernal cape mix";
				itemDef.description = "Changes the color of the Infernal Cape to Blue.";
				itemDef.modelId = 8956;
				itemDef.modelZoom = 842;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
                itemDef.translateX = 0;
                itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Use";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33162:
				itemDef.name = "Green infernal cape mix";
				itemDef.description = "Changes the color of the Infernal Cape to Green.";
				itemDef.modelId = 8956;
				itemDef.modelZoom = 842;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
                itemDef.translateX = 0;
                itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Use";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33163:
				itemDef.name = "Purple infernal cape mix";
				itemDef.description = "Changes the color of the Infernal Cape to Purple.";
				itemDef.modelId = 8956;
				itemDef.modelZoom = 842;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
                itemDef.translateX = 0;
                itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Use";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33164:
				itemDef.name = "Purple firecape mix";
				itemDef.description = "Changes the color of the firecape to purple.";
				itemDef.modelId = 8956;
				itemDef.modelZoom = 842;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
		        itemDef.translateX = 0;
		        itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Use";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33165:
				itemDef.name = "Cyan firecape mix";
				itemDef.description = "Changes the color of the firecape to cyan.";
				itemDef.modelId = 8956;
				itemDef.modelZoom = 842;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
		        itemDef.translateX = 0;
		        itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Use";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33166:
				itemDef.name = "Green firecape mix";
				itemDef.description = "Changes the color of the firecape to green.";
				itemDef.modelId = 8956;
				itemDef.modelZoom = 842;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
		        itemDef.translateX = 0;
		        itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Use";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
			case 33167:
				itemDef.name = "Red firecape mix";
				itemDef.description = "Changes the color of the firecape to red.";
				itemDef.modelId = 8956;
				itemDef.modelZoom = 842;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
		        itemDef.translateX = 0;
		        itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Use";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
				case 33169:
				itemDef.name = "K'ril robe top";
				itemDef.description = "A top worn by magic-using followers of Zamorak.";
				itemDef.modelId = 62558;
				itemDef.maleModel = 62559;
				itemDef.femaleModel = 62559;
				itemDef.modelZoom = 1358;
				itemDef.modelRotationY = 514;
				itemDef.modelRotationX = 2041;
				itemDef.translateX = 0;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
				case 33170:
				itemDef.name = "K'ril robe bottom";
				itemDef.description = "A robe worn by magic-using followers of Zamorak.";
				itemDef.modelId = 62553;
				itemDef.maleModel = 62554;
				itemDef.femaleModel = 62554;
				itemDef.modelZoom = 1690;
				itemDef.modelRotationY = 435;
				itemDef.modelRotationX = 9;
				itemDef.translateX = -1;
				itemDef.translateYZ = 7;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;     
				case 33171:
				itemDef.name = "K'ril hat";
				itemDef.description = "A hat worn by magic-using followers of Zamorak.";
				itemDef.modelId = 62551;
				itemDef.maleModel = 62552;
				itemDef.femaleModel = 62552;
				itemDef.modelZoom = 1236;
				itemDef.modelRotationY = 118;
				itemDef.modelRotationX = 10;
				itemDef.translateX = 0;
				itemDef.translateYZ = -12;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;      
				case 33172:
				itemDef.name = "K'ril swords";
				itemDef.description = "Sheath & Unsheath this sword in the Equipment tab. Hits an enemy twice.";
				itemDef.equipActions[2] = "Sheath";
				itemDef.modelId = 62556;
				itemDef.maleModel = 62557;
				itemDef.femaleModel = 62557;
				itemDef.modelZoom = 1650;
				itemDef.modelRotationY = 498;
				itemDef.modelRotationX = 1300;
				itemDef.translateX = 3;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;    
				case 33173:
				itemDef.name = "K'ril swords (sheathed)";
				itemDef.description = "Sheath & Unsheath this sword in the Equipment tab. Hits an enemy twice.";
				itemDef.equipActions[2] = "Unsheath";
				itemDef.modelId = 62556;
				itemDef.maleModel = 62556;
				itemDef.femaleModel = 62556;
				itemDef.modelZoom = 1650;
				itemDef.modelRotationY = 498;
				itemDef.modelRotationX = 1300;
				itemDef.translateX = 3;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;     
				case 33174:
				itemDef.name = "Pet demonic gorilla";
				itemDef.description = "none.";
				itemDef.modelId = 31241;
				itemDef.modelZoom = 16000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				
				case 33175:
				itemDef.name = "Pet crawling hand";
				itemDef.description = "none.";
				itemDef.modelId = 5071;
				itemDef.modelZoom = 2000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33176:
				itemDef.name = "Pet cave bug";
				itemDef.description = "none.";
				itemDef.modelId = 23854;
				itemDef.modelZoom = 2000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33177:
				itemDef.name = "Pet cave crawler";
				itemDef.description = "none.";
				itemDef.modelId = 5066;
				itemDef.modelZoom = 2300;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 270;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33178:
				itemDef.name = "Pet banshee";
				itemDef.description = "none.";
				itemDef.modelId = 5063;
				itemDef.modelZoom = 3200;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33179:
				itemDef.name = "Pet cave slime";
				itemDef.description = "none.";
				itemDef.modelId = 5786;
				itemDef.modelZoom = 2000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33180:
				itemDef.name = "Pet rockslug";
				itemDef.description = "none.";
				itemDef.modelId = 5084;
				itemDef.modelZoom = 2000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33181:
				itemDef.name = "Pet cockatrice";
				itemDef.description = "none.";
				itemDef.modelId = 5070;
				itemDef.modelZoom = 3200;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33182:
				itemDef.name = "Pet pyrefiend";
				itemDef.description = "none.";
				itemDef.modelId = 5083;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33183:
				itemDef.name = "Pet basilisk";
				itemDef.description = "none.";
				itemDef.modelId = 5064;
				itemDef.modelZoom = 3000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33184:
				itemDef.name = "Pet infernal mage";
				itemDef.modifiedModelColors = new int[] { -26527, -24618, -25152, -25491, 119 };
				itemDef.newModelColors = new int[] { 924, 148, 0, 924, 924 };
				itemDef.description = "none.";
				itemDef.modelId = 5047;
				itemDef.modelZoom = 3940;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 84;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33185:
				itemDef.name = "Pet bloodveld";
				itemDef.description = "none.";
				itemDef.modelId = 5065;
				itemDef.modelZoom = 2000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33186:
				itemDef.name = "Pet jelly";
				itemDef.description = "none.";
				itemDef.modelId = 5081;
				itemDef.modelZoom = 3000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
			
				case 33187:
				itemDef.name = "Pet turoth";
				itemDef.description = "none.";
				itemDef.modelId = 5086;
				itemDef.modelZoom = 2600;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33188:
				itemDef.name = "Pet aberrant spectre";
				itemDef.description = "none.";
				itemDef.modelId = 5085;
				itemDef.modelZoom = 6500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 450;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33189:
				itemDef.name = "Pet dust devil";
				itemDef.description = "none.";
				itemDef.modelId = 5076;
				itemDef.modelZoom = 3000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33190:
				itemDef.name = "Pet kurask";
				itemDef.description = "none.";
				itemDef.modelId = 5082;
				itemDef.modelZoom = 5000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33191:
				itemDef.name = "Pet skeletal wyvern";
				itemDef.description = "none.";
				itemDef.modelId = 10350;
				itemDef.modelZoom = 1104;
				itemDef.modelRotationY = 27;
				itemDef.modelRotationX = 1634;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				
				case 33192:
				itemDef.name = "Pet garygoyle";
				itemDef.description = "none.";
				itemDef.modelId = 5078;
				itemDef.modelZoom = 4000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33193:
				itemDef.name = "Pet nechryael";
				itemDef.description = "none.";
				itemDef.modelId = 5074;
				itemDef.modelZoom = 4000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33194:
				itemDef.name = "Pet abyssal demon";
				itemDef.description = "none.";
				itemDef.modelId = 5062;
				itemDef.modelZoom = 5000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 270;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33195:
				itemDef.name = "Pet dark beast";
				itemDef.description = "none.";
				itemDef.modelId = 26395;
				itemDef.modelZoom = 4500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 270;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				
				case 33196:
				itemDef.name = "Pet night beast";
				itemDef.description = "none.";
				itemDef.modelId = 32933;
				itemDef.modelZoom = 7000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 270;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33197:
				itemDef.name = "Pet greater abyssal demon";
				itemDef.description = "none.";
				itemDef.modelId = 32921;
				itemDef.modelZoom = 5000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 270;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33198:
				itemDef.name = "Pet crushing hand";
				itemDef.description = "none.";
				itemDef.modelId = 32922;
				itemDef.modelZoom = 4500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33199:
				itemDef.name = "Pet chasm crawler";
				itemDef.description = "none.";
				itemDef.modelId = 32918;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33200:
				itemDef.name = "Pet screaming banshee";
				itemDef.description = "none.";
				itemDef.modelId = 32823;
				itemDef.modelZoom = 5500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				
				case 33201:
				itemDef.name = "Pet twisted banshee";
				itemDef.description = "none.";
				itemDef.modelId = 32847;
				itemDef.modelZoom = 5500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33202:
				itemDef.name = "Pet giant rockslug";
				itemDef.description = "none.";
				itemDef.modelId = 32919;
				itemDef.modelZoom = 4500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				
				case 33203:
				itemDef.name = "Pet cockathrice";
				itemDef.description = "none.";
				itemDef.modelId = 32920;
				itemDef.modelZoom = 4500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33204:
				itemDef.name = "Pet flaming pyrelord";
				itemDef.description = "none.";
				itemDef.modelId = 32923;
				itemDef.modelZoom = 4500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33205:
				itemDef.name = "Pet monstrous basilisk";
				itemDef.description = "none.";
				itemDef.modelId = 32924;
				itemDef.modelZoom = 4500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33206:
				itemDef.name = "Pet malevolent mage";
				itemDef.description = "none.";
				itemDef.modelId = 32929;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
					
				case 33207:
				itemDef.name = "Pet insatiable bloodveld";
				itemDef.description = "none.";
				itemDef.modelId = 32926;
				itemDef.modelZoom = 5000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33208:
				itemDef.name = "Pet insatiable mutated bloodveld";
				itemDef.description = "none.";
				itemDef.modelId = 32925;
				itemDef.modelZoom = 5000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33209:
				itemDef.name = "Pet vitreous jelly";
				itemDef.description = "none.";
				itemDef.modelId = 32852;
				itemDef.modelZoom = 4500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33210:
				itemDef.name = "Pet vitreous warped jelly";
				itemDef.description = "none.";
				itemDef.modelId = 32917;
				itemDef.modelZoom = 6000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33211:
				itemDef.name = "Pet cave abomination";
				itemDef.description = "none.";
				itemDef.modelId = 32935;
				itemDef.modelZoom = 5500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33212:
				itemDef.name = "Pet abhorrent spectre";
				itemDef.description = "none.";
				itemDef.modelId = 32930;
				itemDef.modelZoom = 6500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33213:
				itemDef.name = "pet repugnant spectre";
				itemDef.description = "none.";
				itemDef.modelId = 32926;
				itemDef.modelZoom = 6500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33214:
				itemDef.name = "Pet choke devil";
				itemDef.description = "none.";
				itemDef.modelId = 32927;
				itemDef.modelZoom = 6000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33215:
				itemDef.name = "Pet king kurask";
				itemDef.description = "none.";
				itemDef.modelId = 32934;
				itemDef.modelZoom = 8000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33217:
				itemDef.name = "Pet nuclear smoke devil";
				itemDef.description = "none.";
				itemDef.modelId = 32928;
				itemDef.modelZoom = 5500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33218:
				itemDef.name = "Pet marble gargoyle";
				itemDef.description = "none.";
				itemDef.modelId = 34251;
				itemDef.modelZoom = 8000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33219:
				itemDef.name = "Pet nechryarch";
				itemDef.description = "none.";
				itemDef.modelId = 32932;
				itemDef.modelZoom = 6500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33220:
				itemDef.name = "Pet Patrity";
				itemDef.description = "none.";
				itemDef.modelId = 32035;
				itemDef.modelZoom = 653;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 1535;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33221:
				itemDef.name = "Pet xarpus";
				itemDef.description = "none.";
				itemDef.modelId = 35383;
				itemDef.modelZoom = 14000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33222:
				itemDef.name = "Pet nyclocas vasilias";
				itemDef.description = "none.";
				itemDef.modelId = 35182;
				itemDef.modelZoom = 12000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33223:
				itemDef.name = "Pet pestilent bloat";
				itemDef.description = "none.";
				itemDef.modelId = 35404;
				itemDef.modelZoom = 8500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
			
				case 33224:
				itemDef.name = "Pet maiden of sugadinti";
				itemDef.description = "none.";
				itemDef.modelId = 35385;
				itemDef.modelZoom = 8500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33225:
				itemDef.name = "Pet lizardman shaman";
				itemDef.description = "none.";
				itemDef.modelId = 4039;
				itemDef.modelZoom = 8500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33226:
				itemDef.name = "Pet abyssal sire";
				itemDef.description = "none.";
				itemDef.modelId = 29477;
				itemDef.modelZoom = 9000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33227:
				itemDef.name = "Pet black demon";
				itemDef.description = "none.";
				itemDef.modelId = 31984;
				itemDef.modelZoom = 1104;
				itemDef.modelRotationY = 144;
				itemDef.modelRotationX = 1826;
				itemDef.translateX = 7;
				itemDef.translateYZ = -4;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33228:
				itemDef.name = "Pet greater demon";
				itemDef.description = "none.";
				itemDef.modelId = 32015;
				itemDef.modelZoom = 902;
				itemDef.modelRotationY = 216;
				itemDef.modelRotationX = 138;
				itemDef.translateX = -3;
				itemDef.translateYZ = -16;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
			
				case 33229:
				itemDef.name = "Armadyl godsword (sheathed)";
				itemDef.description = "Armadyl godsword (sheathed)";
				itemDef.modelId = 28075;
				itemDef.maleModel = 62683;
				itemDef.femaleModel = 62683;
				itemDef.modelZoom = 1957;
				itemDef.modelRotationY = 498;
				itemDef.modelRotationX = 494;
				itemDef.translateX = -1;
				itemDef.translateYZ = -1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
				
				case 33230:
				itemDef.name = "Bandos godsword (sheathed)";
				itemDef.description = "Bandos godsword (sheathed)";
				itemDef.modelId = 28059;
				itemDef.maleModel = 62684;
				itemDef.femaleModel = 62684;
				itemDef.modelZoom = 1957;
				itemDef.modelRotationY = 498;
				itemDef.modelRotationX = 494;
				itemDef.translateX = -1;
				itemDef.translateYZ = -1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
				
				case 33231:
				itemDef.name = "Saradomin godsword (sheathed)";
				itemDef.description = "Saradomin godsword (sheathed)";
				itemDef.modelId = 28070;
				itemDef.maleModel = 62685;
				itemDef.femaleModel = 62685;
				itemDef.modelZoom = 1957;
				itemDef.modelRotationY = 498;
				itemDef.modelRotationX = 494;
				itemDef.translateX = -1;
				itemDef.translateYZ = -1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
				
				case 33232:
				itemDef.name = "Zamorak godsword (sheathed)";
				itemDef.description = "Zamorak godsword (sheathed)";
				itemDef.modelId = 28060;
				itemDef.maleModel = 62686;
				itemDef.femaleModel = 62686;
				itemDef.modelZoom = 1957;
				itemDef.modelRotationY = 498;
				itemDef.modelRotationX = 494;
				itemDef.translateX = -1;
				itemDef.translateYZ = -1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
		        
				case 33233:
				itemDef.name = "Pet revenant imp";
				itemDef.description = "none.";
				itemDef.modelId = 34156;
				itemDef.modelZoom = 2000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				
				case 33234:
				itemDef.name = "Pet revenant goblin";
				itemDef.description = "none.";
				itemDef.modelId = 34262;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33235:
				itemDef.name = "Pet revenant pyrefiend";
				itemDef.description = "none.";
				itemDef.modelId = 34142;
				itemDef.modelZoom = 4500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33236:
				itemDef.name = "Pet revenant hobgoblin";
				itemDef.description = "none.";
				itemDef.modelId = 34157;
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
			
				case 33237:
				itemDef.name = "Pet revenant cyclops";
				itemDef.description = "none.";
				itemDef.modelId = 34155;
				itemDef.modelZoom = 4500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33473:
					itemDef.name = "Pet mammoth";
					itemDef.description = "none.";
					itemDef.modelId = 3005;
					itemDef.modelZoom = 4500;
					itemDef.modelRotationY = 0;
					itemDef.modelRotationX = 0;
					itemDef.translateX = 0;
					itemDef.translateYZ = 0;
					itemDef.inventoryOptions = new String[5];
					itemDef.inventoryOptions[1] = null;
					itemDef.inventoryOptions[2] = null;
					//itemDef.aByte205 = 3;
					break; 
					
				case 33474:
					itemDef.name = "Pet holy knuckles";
					itemDef.description = "none.";
					itemDef.modelId = 800027;
					itemDef.modelZoom = 3500;
					itemDef.modelRotationY = 0;
					itemDef.modelRotationX = 0;
					itemDef.translateX = 0;
					itemDef.translateYZ = 0;
					itemDef.inventoryOptions = new String[5];
					itemDef.inventoryOptions[1] = null;
					itemDef.inventoryOptions[2] = null;
					//itemDef.aByte205 = 3;
					break; 
					
				case 33475:
					itemDef.name = "Pet vendigo";
					itemDef.description = "none.";
					itemDef.modelId = 800028;
					itemDef.modelZoom = 3500;
					itemDef.modelRotationY = 0;
					itemDef.modelRotationX = 0;
					itemDef.translateX = 0;
					itemDef.translateYZ = 0;
					itemDef.inventoryOptions = new String[5];
					itemDef.inventoryOptions[1] = null;
					itemDef.inventoryOptions[2] = null;
					//itemDef.aByte205 = 3;
					break; 

				case 33238:
				itemDef.name = "Pet revenant hellhound";
				itemDef.description = "none.";
				itemDef.modelId = 34143;
				itemDef.modelZoom = 3500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 270;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33239:
				itemDef.name = "Pet revenant demon";
				itemDef.description = "none.";
				itemDef.modelId = 32015;
				itemDef.modifiedModelColors = new int[] { 1690, 910, 912, 1814, 1938 };
				itemDef.newModelColors = new int[] { 43078, 43078, 43078, 43078, 43078, 43078 };
				itemDef.modelZoom = 902;
				itemDef.modelRotationY = 216;
				itemDef.modelRotationX = 138;
				itemDef.translateX = -3;
				itemDef.translateYZ = -16;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33240:
				itemDef.name = "Pet revenant ork";
				itemDef.description = "none.";
				itemDef.modelId = 34154;
				itemDef.modelZoom = 3500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
					
				case 33242:
				itemDef.name = "Pet revenant dark beast";
				itemDef.description = "none.";
				itemDef.modelId = 34158;
				itemDef.modelZoom = 6500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 270;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 		
					
				case 33243:
				itemDef.name = "Pet revenant knight";
				itemDef.description = "none.";
				itemDef.modelId = 34145;
				itemDef.modelZoom = 3000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 		
					
				case 33244:
				itemDef.name = "Pet revenant dragon";
				itemDef.description = "none.";
				itemDef.modelId = 34163;
				itemDef.modelZoom = 7500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 270;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33245:
				itemDef.name = "Pet glob";
				itemDef.description = "none.";
				itemDef.modelId = 26074;
				itemDef.modelZoom = 10000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
					
				case 33246:
				itemDef.name = "Pet ice queen";
				itemDef.description = "none.";
				itemDef.modelId = 104;
				itemDef.modifiedModelColors = new int[] { 41, 61, 4550, 12224, 25238, 6798 };
				itemDef.newModelColors = new int[] { -22052, -26150, -24343, -22052, -22052, -23327 };
				itemDef.modelZoom = 2500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 		
					
				case 33247:
				itemDef.name = "Pet enraged tarn";
				itemDef.description = "none.";
				itemDef.modelId = 60322;
				itemDef.modelZoom = 6500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
					
				case 33248:
				itemDef.name = "Pet jaltok-jad";
				itemDef.description = "none.";
				itemDef.modelId = 33012;
				itemDef.modelZoom = 12000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 270;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				
				case 33249:
				itemDef.name = "Pet rune dragon";
				itemDef.description = "none.";
				itemDef.modelId = 34668;
				itemDef.modelZoom = 2541;
				itemDef.modelRotationY = 83;
				itemDef.modelRotationX = 1826;
				itemDef.translateX = -97;
				itemDef.translateYZ = 9;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 	
				
				case 33250:
				itemDef.name = "Swift gloves (Black)";
				itemDef.description = "Watch my speedy hands!";
				itemDef.modelId = 62655;
				itemDef.maleModel = 62657;
				itemDef.femaleModel = 62658;
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 512;
				itemDef.modelRotationX = 27;
				itemDef.translateX = 1;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;    
			    
				case 33251:
				itemDef.name = "Swift gloves (Red)";
				itemDef.description = "Watch my speedy hands!";
				itemDef.modifiedModelColors = new int[] {10, 15, 20};
				itemDef.newModelColors = new int[] {65046, 65051, 65056};
				itemDef.modelId = 62655;
				itemDef.maleModel = 62659;
				itemDef.femaleModel = 62660;
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 512;
				itemDef.modelRotationX = 27;
				itemDef.translateX = 1;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;    
				
				case 33252:
				itemDef.name = "Swift gloves (White)";
				itemDef.description = "Watch my speedy hands!";
				itemDef.modifiedModelColors = new int[] {10, 15, 20};
				itemDef.newModelColors = new int[] {64585, 64590, 64595};
				itemDef.modelId = 62655;
				itemDef.maleModel = 62661;
				itemDef.femaleModel = 62662;
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 512;
				itemDef.modelRotationX = 27;
				itemDef.translateX = 1;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;   
				
				case 33253:
				itemDef.name = "Swift gloves (Yellow)";
				itemDef.description = "Watch my speedy hands!";
				itemDef.modifiedModelColors = new int[] {10, 15, 20};
				itemDef.newModelColors = new int[] {9767, 9772, 9777};
				itemDef.modelId = 62655;
				itemDef.maleModel = 62663;
				itemDef.femaleModel = 62664;
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 512;
				itemDef.modelRotationX = 27;
				itemDef.translateX = 1;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;    
				
				case 33254:
				itemDef.name = "Spellcaster gloves (Black)";
				itemDef.description = "	Some pretty fantastical gloves.";
				itemDef.modelId = 62656;
				itemDef.maleModel = 62665;
				itemDef.femaleModel = 62666;
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 512;
				itemDef.modelRotationX = 27;
				itemDef.translateX = 1;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;   
				
				case 33255:
				itemDef.name = "Spellcaster gloves (Red)";
				itemDef.description = "	Some pretty fantastical gloves.";
				itemDef.modifiedModelColors = new int[] {10, 15, 20};
				itemDef.newModelColors = new int[] {65046, 65051, 65056};
				itemDef.modelId = 62656;
				itemDef.maleModel = 62667;
				itemDef.femaleModel = 62668;
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 512;
				itemDef.modelRotationX = 27;
				itemDef.translateX = 1;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;    
				
				case 33256:
				itemDef.name = "Spellcaster gloves (White)";
				itemDef.description = "	Some pretty fantastical gloves.";
				itemDef.modifiedModelColors = new int[] {10, 15, 20};
				itemDef.newModelColors = new int[] {64585, 64590, 64595};
				itemDef.modelId = 62656;
				itemDef.maleModel = 62669;
				itemDef.femaleModel = 62670;
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 512;
				itemDef.modelRotationX = 27;
				itemDef.translateX = 1;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33257:
				itemDef.name = "Spellcaster gloves (Yellow)";
				itemDef.description = "	Some pretty fantastical gloves.";
				itemDef.modifiedModelColors = new int[] {10, 15, 20};
				itemDef.newModelColors = new int[] {9767, 9772, 9777};
				itemDef.modelId = 62656;
				itemDef.maleModel = 62671;
				itemDef.femaleModel = 62672;
				itemDef.modelZoom = 592;
				itemDef.modelRotationY = 512;
				itemDef.modelRotationX = 27;
				itemDef.translateX = 1;
				itemDef.translateYZ = 1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;  
				
				case 33258:
				itemDef.name = "Tekton longsword";
				itemDef.description = "Tekton longsword.";
				itemDef.modelId = 62682;
				itemDef.maleModel = 62681;
				itemDef.femaleModel = 62681;
				itemDef.modelZoom = 1445;
				itemDef.modelRotationY = 1549;
				itemDef.modelRotationX = 1791;
				itemDef.translateX = -1;
				itemDef.translateYZ = -3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
				
				case 33259:
				itemDef.name = "Pet wyrm";
				itemDef.description = "none.";
				itemDef.modelId = 36922;
				itemDef.modelZoom = 2547;
				itemDef.modelRotationY = 97;
				itemDef.modelRotationX = 1820;
				itemDef.translateX = -7;
				itemDef.translateYZ = -9;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				
				case 33260:
				itemDef.name = "Pet drake";
				itemDef.description = "none.";
				itemDef.modelId = 36160;
				itemDef.modelZoom = 6500;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 270;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				
				case 33261:
				itemDef.name = "Pet wyrm";
				itemDef.description = "none.";
				itemDef.modelId = 36922;
				itemDef.modelZoom = 2547;
				itemDef.modelRotationY = 97;
				itemDef.modelRotationX = 1820;
				itemDef.translateX = -7;
				itemDef.translateYZ = -9;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				
				case 33262:
				itemDef.name = "Valentines Balloon";
				itemDef.description = "none.";
				itemDef.modelId = 62766;
				itemDef.maleModel = 62767;
				itemDef.femaleModel = 62767;
				itemDef.modelZoom = 2200;
				itemDef.modelRotationY = 270;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				
				case 33263:
				itemDef.name = "Cupid bow";
				itemDef.description = "none.";
				itemDef.modelId = 62768;
				itemDef.maleModel = 62769;
				itemDef.femaleModel = 62769;
				itemDef.modelZoom = 1072;
				itemDef.modelRotationY = 127;
				itemDef.modelRotationX = 103;
				itemDef.translateX = -5;
				itemDef.translateYZ = 2;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				case 33264:
				itemDef.name = "Halo and horns";
				itemDef.description = "none.";
				itemDef.modelId = 62771;
				itemDef.maleModel = 62770;
				itemDef.femaleModel = 62770;
				itemDef.modelZoom = 550;
				itemDef.modelRotationY = 228;
				itemDef.modelRotationX = 141;
				itemDef.translateX = 0;
				itemDef.translateYZ = 3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				case 33265:
				itemDef.name = "Heart";
				itemDef.description = "none.";
				itemDef.modelId = 62782;
				itemDef.modelZoom = 2000;
				itemDef.modelRotationY = 0;
				itemDef.modelRotationX = 0;
				itemDef.translateX = 0;
				itemDef.translateYZ = 0;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				case 33266:
				itemDef.name = "Valentines mystery box";
				itemDef.description = "You make me hard.";
				itemDef.modelId = 62773;
				itemDef.modelZoom = 464;
				itemDef.modelRotationY = 423;
				itemDef.modelRotationX = 1928;
				itemDef.translateX = 2;
				itemDef.translateYZ = -1;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[0] = "Open";
				itemDef.inventoryOptions[1] = null;
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break; 
				case 33267:
				itemDef.name = "Staff of adoration";
				itemDef.description = "none.";
				itemDef.modelId = 62774;
				itemDef.maleModel = 62775;
				itemDef.femaleModel = 62775;
				itemDef.modelZoom = 1579;
				itemDef.modelRotationY = 660;
				itemDef.modelRotationX = 48;
				itemDef.translateX = 0;
				itemDef.translateYZ = 3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
				
				case 33268:
				itemDef.name = "Valentines crossbow";
				itemDef.description = "none.";
				itemDef.modelId = 62778;
				itemDef.maleModel = 62779;
				itemDef.femaleModel = 62779;
				itemDef.modelZoom = 1200;
				itemDef.modelRotationY = 432;
				itemDef.modelRotationX = 258;
				itemDef.translateX = 0;
				itemDef.translateYZ = 3;
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
				//itemDef.aByte205 = 3;
				break;
		case 11773:
		case 11771:
		case 11770:
		case 11772:
			itemDef.anInt196 += 45;
			break;
		case 22610:
			itemDef.name = "Vesta's spear (deg)";
			break;
		case 22614:
			itemDef.name = "Vesta's longsword (deg)";
			break;
		case 22616:
			itemDef.name = "Vesta's chainbody (deg)";
			break;
		case 22619:
			itemDef.name = "Vesta's plateskirt (deg)";
			break;
		case 22622:
			itemDef.name = "Statius's warhammer (deg)";
			break;
		case 22625:
			itemDef.name = "Statius's full helm (deg)";
			break;
		case 22628:
			itemDef.name = "Statius's platebody (deg)";
			break;
		case 22631:
			itemDef.name = "Statius's platelegs (deg)";
			break;
		case 22638:
			itemDef.name = "Morrigan's coif (deg)";
			break;
		case 22641:
			itemDef.name = "Morrigan's leather body (deg)";
			break;
		case 22644:
			itemDef.name = "Morrigan's leather chaps (deg)";
			break;
		case 22647:
			itemDef.name = "Zuriel's staff (deg)";
			break;
		case 22650:
			itemDef.name = "Zuriel's hood (deg)";
			break;
		case 22653:
			itemDef.name = "Zuriel's robe top (deg)";
			break;
		case 22656:
			itemDef.name = "Zuriel's robe bottom (deg)";
			break;
		
		case 13303:
			itemDef.name = "Event Key";
			itemDef.description = "Use this to open the Event Boss chest.";
			itemDef.modifiedModelColors = new int[] { 8128 };
			itemDef.newModelColors = new int[] { 933 };
			break;
		case 2697:
			itemDef.name = "$10 Scroll";
			itemDef.description = "Get donor status at a cheaper cost!";
			break;
		case 2698:
			itemDef.name = "$50 Scroll";
			itemDef.description = "Read this scroll to be rewarded with the Super Donator status.";
			break;
		case 2699:
			itemDef.name = "$100 Donator";
			itemDef.description = "Read this scroll to be rewarded with the Extreme Donator status.";
			break;
		case 2700:
			itemDef.name = "$5 Scroll";
			itemDef.description = "Read this scroll to be rewarded with the Legendary Donator status.";
			break;
		case 1464:
			itemDef.name = "Vote ticket";
			itemDef.description = "This ticket can be exchanged for a voting point.";
			break;
			
		case 11739:
			itemDef.name = "Daily reward box";
			itemDef.description = "Open this box for a daily reward.";
			break;
			
		case 30000:
	            itemDef.modelId = 800001;
	            itemDef.name = "Pink Dildo";
	            itemDef.description = "Dug out of Kayley Fishers bum hole";
	            itemDef.modelZoom = 1579;
	            itemDef.translateYZ = -4;
	            itemDef.translateX = 0;
	            itemDef.modelRotationX = 533;
	            itemDef.modelRotationY = 333;
	            itemDef.maleModel = 800001;
	            itemDef.femaleModel = 800001;
	            itemDef.groundOptions = new String[5];
	            itemDef.groundOptions[2] = "Take";
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[1] = "Wear";
				itemDef.inventoryOptions[2] = null;
	            itemDef.stackable = false;
	        break;
		case 31231:
	            itemDef.name = "Verac the Defiled Pet";
	            itemDef.inventoryOptions = new String[]{null, null, null, null, "Drop"};
	            itemDef.modelId = 31241;
	            itemDef.modelRotationY = 2000;
	            itemDef.modelRotationX = 2000;
	            itemDef.modelZoom = 2000;
	            itemDef.translateX = 0;
	            itemDef.translateYZ = 41;
	            break;
	            case 31230:
				itemDef.name = "Torag the Corrupted Pet";
	            itemDef.inventoryOptions = new String[]{null, null, null, null, "Drop"};
	            itemDef.modelId = 31241;
	            itemDef.modelRotationY = 2000;
	            itemDef.modelRotationX = 0;
	            itemDef.modelZoom = 560;
	            itemDef.translateX = 0;
	            itemDef.translateYZ = 71;
	            break;
	            case 31229:
	            itemDef.name = "Karil the Tainted Pet";
	            itemDef.inventoryOptions = new String[]{null, null, null, null, "Drop"};
	            itemDef.modelId = 31241;
	            itemDef.modelRotationY = 2000;
	            itemDef.modelRotationX = 2000;
	            itemDef.modelZoom = 2000;
	            itemDef.translateX = 0;
	            itemDef.translateYZ = 41;
	            break;
	            case 31228:
	            itemDef.name = "Guthan the Infested Pet";
	            itemDef.inventoryOptions = new String[]{null, null, null, null, "Drop"};
	            itemDef.modelId = 31241;
	            itemDef.modelRotationY = 2000;
	            itemDef.modelRotationX = 0;
	            itemDef.modelZoom = 535;
	            itemDef.translateX = 0;
	            itemDef.translateYZ = 73;
	            break;
	            
	            case 31227:
	            itemDef.name = "Dharok the Wretched Pet";
	            itemDef.inventoryOptions = new String[]{null, null, null, null, "Drop"};
	            itemDef.modelId = 31241;
	            itemDef.modelRotationY = 2000;
	            itemDef.modelRotationX = 2000;
	            itemDef.modelZoom = 828;
	            itemDef.translateX = 0;
	            itemDef.translateYZ = 61;
	            break;
	            
	            case 31226:
	            itemDef.name = "Ahrim the Blighted Pet";
	            itemDef.inventoryOptions = new String[]{null, null, null, null, "Drop"};
	            itemDef.modelId = 31241;
	            itemDef.modelRotationY = 2000;
	            itemDef.modelRotationX = 2000;
	            itemDef.modelZoom = 2000;
	            itemDef.translateX = 0;
	            itemDef.translateYZ = 41;
		break;
		
	            case 4840:
	            	itemDef.name = "Dinosaur bones";
		            itemDef.inventoryOptions = new String[]{"Bury", null, null, null, "Drop"};
	            	itemDef.modelId = 2768;
	            	itemDef.maleModel = -1;
	            	itemDef.femaleModel = -1;
	            	itemDef.modelZoom = 2232;
	            	itemDef.modelRotationY = 498;
	            	itemDef.modelRotationX = 1145;
	            	itemDef.translateX = -16;
	            	itemDef.translateYZ = 4;
	            	itemDef.description = "Bones from a dinossaur";
	            	itemDef.rdc2 = 105;
	            	break;
	            	
				case 37000:
					itemDef.name = "Lava key";
					itemDef.description = "Required to access infernal dragons.";
					itemDef.modelId = 61111;
					itemDef.modelZoom = 1000;
					itemDef.modelRotationY = 534;
					itemDef.modelRotationX = 222;
					itemDef.translateX = -1;
					itemDef.translateYZ = 5;
					itemDef.inventoryOptions = new String[5];
					itemDef.inventoryOptions[1] = null;
					itemDef.inventoryOptions[2] = null;
					break;
					
			    case 11964:
			    	itemDef.name = "Infernal dragon bones";
		            itemDef.inventoryOptions = new String[]{"Bury", null, null, null, "Drop"};
			        itemDef.modelId = ItemDefinition.forID(11943).modelId;
			        itemDef.maleModel = -1;
			        itemDef.femaleModel = -1;
					itemDef.modelZoom = ItemDefinition.forID(11943).modelZoom;
					itemDef.modelRotationY = ItemDefinition.forID(11943).modelRotationY;
					itemDef.modelRotationX = ItemDefinition.forID(11943).modelRotationX;
					itemDef.translateX = ItemDefinition.forID(11943).translateX;
					itemDef.translateYZ = ItemDefinition.forID(11943).translateYZ;
			        break;
			        
			    case 20587:
					itemDef.inventoryOptions = new String[5];
					itemDef.inventoryOptions[1] = "Wear";
					itemDef.inventoryOptions[2] = null;
					itemDef.name = "Abyssal lime whip"; 
					itemDef.description = "A Lime whip.";
					itemDef.modelRotationY = 280;
					itemDef.modelRotationX = 0;
					itemDef.translateX = -1;
					itemDef.translateYZ = 56;
					itemDef.modelId = 5412;
					itemDef.maleModel = 5409;
					itemDef.femaleModel = 5409;
					itemDef.modelZoom = 840;
					itemDef.newModelColors = new int[2];
					itemDef.modifiedModelColors = new int[2];
					itemDef.modifiedModelColors[0] = 528;
					itemDef.newModelColors[0] = 17350;
					break;
					
				case 19043:
		            itemDef.name = "Infernus emperor gloves";
		            itemDef.modelId = 94431;
		            itemDef.maleModel = 94432;
		            itemDef.femaleModel = 94432;
		            itemDef.inventoryOptions = new String[]{null, "Wear", null, null, "Drop"};
		            itemDef.modelRotationY = 520;
		            itemDef.modelRotationX = 0;
		            itemDef.modelZoom = 1000;
		            itemDef.translateX = 0;
		            itemDef.translateYZ = 0;
					itemDef.modifiedModelColors = new int[] {60};
					itemDef.newModelColors = new int[] {59};
		        break;
		        
				case 13421: 
					itemDef.name = "Dragonic katana";
					itemDef.inventoryOptions = new String[5];
					itemDef.inventoryOptions[1] = "Wield";
					itemDef.inventoryOptions[4] = "Drop";
					itemDef.modelId = 83143;
					itemDef.femaleModel = 83144;
					itemDef.maleModel = 83144;
					itemDef.modelZoom = 1530;
					itemDef.modelRotationX = 224;
					itemDef.modelRotationY = 408;
					itemDef.translateX = 6;
					itemDef.translateYZ = -49;
					break;
				
		        case 19044:
		            itemDef.name = "Infernus emperor boots";
		            itemDef.modelId = 94430;
		            itemDef.maleModel = 94371;
		            itemDef.femaleModel = 94371;
		            itemDef.inventoryOptions = new String[]{null, "Wear", null, null, "Drop"};
		            itemDef.modelRotationY = 520;
		            itemDef.modelRotationX = 0;
		            itemDef.modelZoom = 1000;
		            itemDef.translateX = 0;
		            itemDef.translateYZ = 0;
					itemDef.modifiedModelColors = new int[] {60};
					itemDef.newModelColors = new int[] {59};
		            break;
		        case 19045:
		            itemDef.name = "Infernus emperor legs";
		            itemDef.modelId = 94428;
		            itemDef.maleModel = 94429;
		            itemDef.femaleModel = 94429;
		            itemDef.inventoryOptions = new String[]{null, "Wear", null, null, "Drop"};
		            itemDef.modelRotationY = 520;
		            itemDef.modelRotationX = 0;
		            itemDef.modelZoom = 1740;
		            itemDef.translateX = 0;
		            itemDef.translateYZ = 0;
					itemDef.modifiedModelColors = new int[] {60};
					itemDef.newModelColors = new int[] {59};
		            break;
		        case 19046:
		            itemDef.name = "Infernus emperor body";
		            itemDef.modelId = 94426;
		            itemDef.maleModel = 94427;
		            itemDef.femaleModel = 94427;
		            itemDef.inventoryOptions = new String[]{null, "Wear", null, null, "Drop"};
		            itemDef.modelRotationY = 520;
		            itemDef.modelRotationX = 0;
		            itemDef.modelZoom = 1740;
		            itemDef.translateX = 0;
		            itemDef.translateYZ = 0;
					itemDef.modifiedModelColors = new int[] {60};
					itemDef.newModelColors = new int[] {59};
		            break;
		            
		            case 19047:
		            itemDef.name = "Infernus emperor helm";
		            itemDef.modelId = 94424;
		            itemDef.maleModel = 94425;
		            itemDef.femaleModel = 94425;
		            itemDef.inventoryOptions = new String[]{null, "Wear", null, null, "Drop"};
		            itemDef.modelRotationY = 520;
		            itemDef.modelRotationX = 0;
		            itemDef.modelZoom = 500;
		            itemDef.translateX = 0;
		            itemDef.translateYZ = 0;
					itemDef.modifiedModelColors = new int[] {60};
					itemDef.newModelColors = new int[] {59};
		        break;
		        
		            case 7692:
						itemDef.name = "Redwood longbow (u)";
						itemDef.modelZoom = 1820;
						itemDef.modelRotationY = 460;
						itemDef.modelRotationX = 1004;
						itemDef.translateX = 2;
						itemDef.translateYZ = 15;
						itemDef.newModelColors = new int[] { 2964 };
						itemDef.modifiedModelColors = new int[] { 6674 };
						itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
						itemDef.modelId = 2401;
						itemDef.maleModel = 26609;
						itemDef.femaleModel = 26609;
//		                itemDef.lightness = 55;
						break;

		            case 7694:
		                itemDef.name = "Redwood shortbow (u)";
		                itemDef.modelZoom = 1200;
		                itemDef.modelRotationY = 508;
		                itemDef.modelRotationX = 124;
		                itemDef.translateX = 7;
		                itemDef.translateYZ = 2;
		                itemDef.newModelColors = new int[] { 2964 };
		                itemDef.modifiedModelColors = new int[] { 6674 };
		                itemDef.inventoryOptions = new String[] { null, null, null, null, "Drop" };
		                itemDef.modelId = 2435;
		                itemDef.maleModel = 26610;
		                itemDef.femaleModel = 26610;
//		                itemDef.lightness = 55;
		                break;

		            case 7696:
		                itemDef.name = "Redwood longbow";
		                itemDef.modelZoom = 1820;
		                itemDef.modelRotationY = 460;
		                itemDef.modelRotationX = 1004;
		                itemDef.translateX = 2;
		                itemDef.translateYZ = 15;
		                itemDef.newModelColors = new int[] { 2964 };
		                itemDef.modifiedModelColors = new int[] { 6674 };
		                itemDef.inventoryOptions = new String[] { null, "Wield", null, null, "Drop" };
		                itemDef.modelId = 2832;
		                itemDef.maleModel = 563;
		                itemDef.femaleModel = 563;
//		                itemDef.lightness = 55;
		                break;

		            case 7698:
		                itemDef.name = "Redwood shortbow";
		                itemDef.modelZoom = 1200;
		                itemDef.modelRotationY = 508;
		                itemDef.modelRotationX = 124;
		                itemDef.translateX = 7;
		                itemDef.translateYZ = 2;
		                itemDef.newModelColors = new int[] { 2964 };
		                itemDef.modifiedModelColors = new int[] { 6674 };
		                itemDef.inventoryOptions = new String[] { null, "Wield", null, null, "Drop" };
		                itemDef.modelId = 2562;
		                itemDef.maleModel = 512;
		                itemDef.femaleModel = 512;
//		                itemDef.lightness = 55;
		                break;
		                
					case 4850:
						itemDef.name = "Death cape";
						itemDef.description = "	A cape gifted from Death themselves.";
						itemDef.modelId = 95092;
						itemDef.maleModel = 95093;
						itemDef.femaleModel = 95093;
						itemDef.modelZoom = 3000;
						itemDef.modelRotationX = 1017;
						itemDef.modelRotationY = 652;
						itemDef.translateX = 9;
						itemDef.translateYZ = 43;
						itemDef.inventoryOptions = new String[5];
						itemDef.inventoryOptions[1] = "Wear";
						itemDef.inventoryOptions[2] = null;
						break;
						
					case 4848:
						itemDef.name = "Undeath cape";
						itemDef.description = "	A cape gifted from undeath themselves.";
						itemDef.modelId = 95091;
						itemDef.maleModel = 95090;
						itemDef.femaleModel = 95090;
						itemDef.modelZoom = 2500;
						itemDef.modelRotationY = 400;
						itemDef.modelRotationX = 948;
						itemDef.translateX = 3;
						itemDef.translateYZ = 6;
						itemDef.inventoryOptions = new String[5];
						itemDef.inventoryOptions[1] = "Wear";
						itemDef.inventoryOptions[2] = null;
						break;
						
					case 27000:
						itemDef.name = "Cape of Mordris";
						itemDef.description = "A cape with the skull of Mordris attached.";
						itemDef.modelId = 83272;
						itemDef.maleModel = 83273;
						itemDef.femaleModel = 83273;
						itemDef.modelZoom = 2086;
						itemDef.modelRotationY = 567;
						itemDef.modelRotationX = 2031;
						itemDef.translateX = 0;
						itemDef.translateYZ = -4;
						itemDef.inventoryOptions = new String[5];
						itemDef.inventoryOptions[1] = "Wear";
						itemDef.inventoryOptions[2] = null;
						break;
					case 27001:
						itemDef.modelId = 800003;
						itemDef.name = "Primal platebody";
						itemDef.description = "A primal item.";
						itemDef.modelZoom = 1447;
						itemDef.modelRotationY = 485;
						itemDef.modelRotationX = 0;
						itemDef.translateX = 0;
						itemDef.translateYZ = 13;
						itemDef.membersObject = true;
						itemDef.maleModel = 800004;
						itemDef.femaleModel = 800004;
						itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
						itemDef.stackable = false;
						break;
						
					case 27002:
						itemDef.modelId = 800005;//800005
						itemDef.name = "Primal platelegs";
						itemDef.description = "A primal item.";
						itemDef.modelZoom = 1730;
						itemDef.modelRotationY = 525;
						itemDef.modelRotationX = 0;
						itemDef.translateX = 7;
						itemDef.translateYZ = 3;
						itemDef.membersObject = true;
						itemDef.maleModel = 800006;//800006
						itemDef.femaleModel = 800007;//800007
						itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
						itemDef.stackable = false;
						break;
					case 27003:
						itemDef.modelId = 800008;//800008
						itemDef.name = "Primal full helm";
						itemDef.description = "A primal item.";
						itemDef.modelZoom = 921;
						itemDef.modelRotationY = 121;
						itemDef.modelRotationX = 0;
						itemDef.translateX = 0;
						itemDef.translateYZ = -4;
						itemDef.membersObject = true;
						itemDef.maleModel = 800009;//800009
						itemDef.femaleModel = 800010;//800010
						itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
						itemDef.stackable = false;
						break;
						
					case 7150:
						itemDef.name = "Adventurer backpack";
						itemDef.description = "	A backpack to store items.";
						itemDef.modelId = 91208;
						itemDef.maleModel = 91209;
						itemDef.femaleModel = 91209;
						itemDef.modelZoom = 1700;
						itemDef.modelRotationY = 400;
						itemDef.modelRotationX = 948;
						itemDef.translateX = 3;
						itemDef.translateYZ = 6;
						itemDef.inventoryOptions = new String[5];
						itemDef.inventoryOptions[0] = "Open";
						itemDef.inventoryOptions[1] = "Wear";
						itemDef.inventoryOptions[2] = "Deposit";
						itemDef.maleOffset = 5;
						itemDef.stackable = false;
						break;
						
					case 33450:
						itemDef.name = "Scream mask";
						itemDef.description = "A scary mask.";
						itemDef.modelId = 800014;
						itemDef.maleModel = 800015;
						itemDef.femaleModel = 800015;
						itemDef.modelZoom = 928;
						itemDef.modelRotationY = 406;
						itemDef.modelRotationX = 2041;
						itemDef.translateX = 1;
						itemDef.translateYZ = -5;
						itemDef.inventoryOptions = new String[5];
						itemDef.inventoryOptions[1] = "Wear";
						itemDef.inventoryOptions[2] = null;
						break;
						
				      case 7162:
				    		itemDef.name = "Behemoth rapier";
				    		itemDef.description = "A razor-sharp rapier.";
				    		itemDef.modelId = 800016;
				    		itemDef.maleModel = 800017;
				    		itemDef.femaleModel = 800017;
				    		itemDef.modelZoom = 1525;
				    		itemDef.modelRotationY = 540;
				    		itemDef.modelRotationX = 1370;
				    		itemDef.translateX = 9;
				    		itemDef.translateYZ = 13;
				    		itemDef.maleOffset = -12;
				    		itemDef.inventoryOptions = new String[5];
				    		itemDef.inventoryOptions[1] = "Wear";
				    		itemDef.inventoryOptions[2] = null;
				    		break;
				    		
							
						case 4842:
			                itemDef.copy(ItemDefinition.forID(1163));
			                itemDef.name = "Fire full helm";
			                itemDef.description = "A piece of armour dropped from the fire warriors.";
			                itemDef.inventoryOptions = new String[5];
			                itemDef.inventoryOptions[1] = "Wield";
			                itemDef.inventoryOptions[4] = "Drop";
			                itemDef.rdc = 965;
			                break;
						case 4844:
			                itemDef.copy(ItemDefinition.forID(1127));
			                itemDef.name = "Fire platebody";
			                itemDef.description = "A piece of armour dropped from the fire warriors.";
			                itemDef.inventoryOptions = new String[5];
			                itemDef.inventoryOptions[1] = "Wield";
			                itemDef.inventoryOptions[4] = "Drop";
			                itemDef.rdc = 965;
			                break;
						case 4846:
			                itemDef.copy(ItemDefinition.forID(1079));
			                itemDef.name = "Fire platelegs";
			                itemDef.description = "A piece of armour dropped from the fire warriors.";
			                itemDef.inventoryOptions = new String[5];
			                itemDef.inventoryOptions[1] = "Wield";
			                itemDef.inventoryOptions[4] = "Drop";
			                itemDef.rdc = 965;
			                break;
			               
							
						case 33453:
			                itemDef.copyAllButModels(ItemDefinition.forID(11840));
			                itemDef.name = "Rainbow boots";
			                itemDef.description = "A pair of funky spiked boots";
							itemDef.maleModel = 83121;
							itemDef.femaleModel = 83121;
							itemDef.modelId = 83121;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
			                break;
			                
						case 33454:
			                itemDef.copyAllButModels(ItemDefinition.forID(1163));
			                itemDef.name = "Sirenic full helm";
			                itemDef.description = "A piece of sirenic gear";
							itemDef.maleModel = 83135;
							itemDef.femaleModel = 83135;
							itemDef.modelId = 83134;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
			                break;
			                
						case 33456:
			                itemDef.copyAllButModels(ItemDefinition.forID(1127));
			                itemDef.name = "Sirenic platelegs";
			                itemDef.description = "A piece of sirenic gear";
							itemDef.maleModel = 83133;
							itemDef.femaleModel = 83133;
							itemDef.modelId = 83132;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
			                break;
			                
						case 33455:
			                itemDef.copyAllButModels(ItemDefinition.forID(1079));
			                itemDef.name = "Sirenic platebody";
			                itemDef.description = "A piece of sirenic gear";
							itemDef.maleModel = 83131;
							itemDef.femaleModel = 83131;
							itemDef.modelId = 83130;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
			                break;
			                
						case 33457:
			                itemDef.name = "Bandos warshield";
			                itemDef.description = "A firece bandos warshield";
							itemDef.maleModel = 800019;
							itemDef.femaleModel = 800019;
							itemDef.modelId = 800018;
							itemDef.modelZoom = 1780;
				    		itemDef.modelRotationY = 560; //x
				    		itemDef.modelRotationX = 796; //y
				    		itemDef.translateX = 9;//x
				    		itemDef.translateYZ = 26; //xz
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
			                break;
			                
						case 33458:
			                itemDef.copyAllButModels(ItemDefinition.forID(9470));
			                itemDef.name = "Rainbow scarf";
			                itemDef.description = "A colourful scarf";
							itemDef.maleModel = 800020;
							itemDef.femaleModel = 800020;
							itemDef.modelId = 800021;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
			                break;
			                
						case 33467:
			                itemDef.copyAllButModels(ItemDefinition.forID(9750));
			                itemDef.name = "Owner cape";
			                itemDef.description = "An owners cape";
							itemDef.maleModel = 800024;
							itemDef.femaleModel = 800024;
							itemDef.modelId = 800023;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
			                break;
			                
						case 33468:
			                itemDef.copyAllButModels(ItemDefinition.forID(11283));
			                itemDef.name = "Shield of the undead";
			                itemDef.description = "A shield which strangely protects you from 20% damage from undead";
							itemDef.maleModel = 800026;
							itemDef.femaleModel = 800026;
							itemDef.modelId = 800025;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
			                break;
			                
						case 3718:
			                itemDef.name = "Gold Magnet";
			                itemDef.description = "A magnet which automatically picks up gold";
			                break;
			               
						case 33452:
							itemDef.modelId = 83099;
							itemDef.name = "Teddy bear";
							itemDef.description = "Awh how cute.";
							itemDef.modelZoom = 921;
							itemDef.modelRotationY = 121;
							itemDef.modelRotationX = 0;
							itemDef.translateX = 0;
							itemDef.translateYZ = -4;
							itemDef.membersObject = true;
							itemDef.maleModel = 83100;
							itemDef.femaleModel = 83100;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
							itemDef.stackable = false;
							break;

						case 33459:
							itemDef.name = "Ganodermic staff";
							itemDef.description = "It's an Polypore staff";
							itemDef.inventoryOptions = new String[] { null, "Wield", null, null, "drop" };
							itemDef.modelId = 95128;
							itemDef.maleModel = 95129;
							itemDef.femaleModel = 95129;
							itemDef.modelZoom = 3750;
							itemDef.modelRotationY = 1454;
							itemDef.modelRotationX = 997;
							itemDef.translateX = 0;
							itemDef.translateYZ = 8;
							break;

						case 33460:
							itemDef.modelId = 95130;
							itemDef.maleModel = 95131;
							itemDef.femaleModel = 95131;
							itemDef.name = "Ganodermic visor";
							itemDef.description = "A visor encrusted with ganodermic flakes.";
							itemDef.modelZoom = 789;
							itemDef.translateX = 0;
							itemDef.translateYZ = 1;
							itemDef.modelRotationY = 67;
							itemDef.modelRotationX = 175;
							itemDef.inventoryOptions = new String[5];
							itemDef.inventoryOptions[0] = null;
							itemDef.inventoryOptions[1] = "Wear";
							itemDef.inventoryOptions[2] = null;
							itemDef.inventoryOptions[3] = null;
							itemDef.inventoryOptions[4] = "drop";
							break;
							
						case 33461:
							itemDef.name = "Ganodermic top";
							itemDef.description = "It's an Ganodermic poncho";
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "drop" };
							itemDef.modelId = 95132;
							itemDef.maleModel = 95133;
							itemDef.femaleModel = 95133;
							itemDef.modelZoom = 1513;
							itemDef.modelRotationY = 485;
							itemDef.modelRotationX = 13;
							itemDef.translateX = 1;
							itemDef.translateYZ = -3;
							break;
						case 33462:
							itemDef.name = "Ganodermic bottom";
							itemDef.description = "It's an Ganodermic leggings";
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "drop" };
							itemDef.modelId = 95134;
							itemDef.maleModel = 95135;
							itemDef.femaleModel = 95135;
							itemDef.modelZoom = 1513;
							itemDef.modelRotationY = 498;
							itemDef.modelRotationX = 0;
							itemDef.translateX = 8;
							itemDef.translateYZ = -18;
							break;

						case 33463:
							itemDef.name = "Ganodermic boots";
							itemDef.description = "A pair of Blood Justicar boots.";
							itemDef.inventoryOptions = new String[5];
							itemDef.inventoryOptions[1] = "Wear";
							itemDef.inventoryOptions[4] = "Drop";
							itemDef.modelId = 95136;
							itemDef.maleModel = 95136;
							itemDef.femaleModel = 95136;
							itemDef.modelZoom = 770;
							itemDef.modelRotationY = 152;
							itemDef.modelRotationX = 160;
							itemDef.translateX = 1;
							itemDef.translateYZ = -6;
							itemDef.value = 6;
							itemDef.team = 0;
							break;
							
						case 33464:
							itemDef.name = "Ganodermic gloves";
							itemDef.description = "A pair of Blood Justicar gloves.";
							itemDef.inventoryOptions = new String[5];
							itemDef.inventoryOptions[1] = "Wear";
							itemDef.inventoryOptions[4] = "Drop";
							itemDef.modelId = 95137;
							itemDef.maleModel = 95138;
							itemDef.femaleModel = 95138;
							itemDef.modelZoom = 770;
							itemDef.modelRotationY = 152;
							itemDef.modelRotationX = 160;
							itemDef.translateX = 1;
							itemDef.translateYZ = -6;
							itemDef.value = 6;
							itemDef.team = 0;
							break;
							
						case 33465:
							itemDef.name = "Chucky pet";
							itemDef.description = "A chucky pet.";
							itemDef.modelId = 800011;
							itemDef.modelZoom = 1500;
							itemDef.modelRotationY = 0;
							itemDef.modelRotationX = 0;
							itemDef.translateX = 0;
							itemDef.translateYZ = 0;
							itemDef.inventoryOptions = new String[5];
							itemDef.inventoryOptions[1] = null;
							itemDef.inventoryOptions[2] = null;
							break;
							
						case 33472:
			                itemDef.copyAllButModels(ItemDefinition.forID(4084));
							itemDef.description = "WEeeeeeeeeeeeeeeeeeeeeeeeee";
							itemDef.name = "Infernal sled";
							itemDef.modifiedModelColors = new int[] {60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80};
							itemDef.newModelColors = new int[] {59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59};
							itemDef.modelId = itemDef.maleModel = itemDef.femaleModel = 94564;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
							break;
							
						case 33466:
							itemDef.name = "Rexxy pet";
							itemDef.description = "A rexxy pet.";
							itemDef.modelId = 800002;
							itemDef.modelZoom = 2700;
							itemDef.modelRotationY = 0;
							itemDef.modelRotationX = 0;
							itemDef.translateX = 0;
							itemDef.translateYZ = 0;
							itemDef.inventoryOptions = new String[5];
							itemDef.inventoryOptions[1] = null;
							itemDef.inventoryOptions[2] = null;
							break;
							
						case 33469:
			                itemDef.copyAllButModels(ItemDefinition.forID(1163));
			                itemDef.name = "Raiden hat";
			                itemDef.description = "A raidens hat";
							itemDef.maleModel = 94134;
							itemDef.femaleModel = 94134;
							itemDef.modelId = 94133;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
			                break;
			                
						case 33471:
			                itemDef.copyAllButModels(ItemDefinition.forID(1127));
			                itemDef.name = "Raiden platelegs";
			                itemDef.description = "A raidens platelegs";
							itemDef.maleModel = 94138;
							itemDef.femaleModel = 94138;
							itemDef.modelId = 94137;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
			                break;
			                
						case 33470:
			                itemDef.copyAllButModels(ItemDefinition.forID(1079));
			                itemDef.name = "Raiden platebody";
			                itemDef.description = "A raidens platebody";
							itemDef.maleModel = 94136;
							itemDef.femaleModel = 94136;
							itemDef.modelId = 94135;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
			                break;
			                
						case 20590:
			                itemDef.copyAllButModels(ItemDefinition.forID(4151));
					        itemDef.name = "Abyssal rainbow whip";
			                itemDef.description = "It's a rainbow abyssal whip";
							itemDef.maleModel = 800030;
							itemDef.femaleModel = 800030;
							itemDef.modelId = 800031;
							itemDef.inventoryOptions = new String[] { null, "Wear", null, null, "Drop" };
			                break;
			                				    		
	}
	}
	
    public void copy(ItemDefinition itemDef) {
        this.maleArm = itemDef.maleArm;
        this.femaleArm = itemDef.femaleArm;
        this.maleModel = itemDef.maleModel;
        this.femaleModel = itemDef.femaleModel;
        this.modelId = itemDef.modelId;
        this.modelZoom = itemDef.modelZoom;
        this.translateX = itemDef.translateX;
        this.translateYZ = itemDef.translateYZ;
        this.modelRotationY = itemDef.modelRotationY;
        this.modelRotationX = itemDef.modelRotationX;
        this.description = itemDef.description;
    }
    
    public void copyAll(ItemDefinition itemDef) {
        this.maleArm = itemDef.maleArm;
        this.femaleArm = itemDef.femaleArm;
        this.maleModel = itemDef.maleModel;
        this.femaleModel = itemDef.femaleModel;
        this.modelId = itemDef.modelId;
        this.modelZoom = itemDef.modelZoom;
        this.translateX = itemDef.translateX;
        this.translateYZ = itemDef.translateYZ;
        this.modelRotationY = itemDef.modelRotationY;
        this.modelRotationX = itemDef.modelRotationX;
        this.description = itemDef.description;
        this.inventoryOptions = itemDef.inventoryOptions.clone();
        this.groundOptions = itemDef.groundOptions.clone();
    }
    
    public void copyAllButModels(ItemDefinition itemDef) {
        this.modelZoom = itemDef.modelZoom;
        this.translateX = itemDef.translateX;
        this.translateYZ = itemDef.translateYZ;
        this.modelRotationY = itemDef.modelRotationY;
        this.modelRotationX = itemDef.modelRotationX;
        this.description = itemDef.description;
    }
    
    public void recolor(int originalColor, int newColor) {
        int index = 0;
        if (newModelColors == null) {
            modifiedModelColors = new int[1];
            newModelColors = new int[1];
        } else {
            find:
            {
                for (int i = 0; i < modifiedModelColors.length; i++)
                    if (modifiedModelColors[i] == originalColor) {
                        index = i;
                        break find;
                    }
                index = modifiedModelColors.length;
                modifiedModelColors = Arrays.copyOf(modifiedModelColors, index + 1);
                newModelColors = Arrays.copyOf(newModelColors, index + 1);
            }
        }
        modifiedModelColors[index] = originalColor;
        newModelColors[index] = newColor;
    }
	
	public static void defaultConfig(ItemDefinition itemDef, int groundModel, int maleModel, int femaleModel, String name) {
		itemDef.modelId = groundModel;
		itemDef.maleModel = maleModel;
		itemDef.femaleModel = femaleModel;
		itemDef.name = name;
		itemDef.description = ("It's an " + itemDef.name);
		itemDef.modelZoom = 1500;
		itemDef.translateX = 0;
		itemDef.translateYZ = 0;
		itemDef.modelRotationY = 900;
		itemDef.modelRotationX = 1200;
		itemDef.groundOptions = new String[5];
		itemDef.groundOptions[2] = "Take";
		itemDef.stackable = false;
	}
	
	void method2789(ItemDefinition var1, ItemDefinition var2) {
		modelId = var1.modelId * 1;
		modelZoom = var1.modelZoom * 1;
		modelRotationY = 1 * var1.modelRotationY;
		modelRotationX = 1 * var1.modelRotationX;
		modelRotationZ = 1 * var1.modelRotationZ;
		translateX = 1 * var1.translateX;
		translateYZ = var1.translateYZ * 1;
		newModelColors = var2.newModelColors;
		modifiedModelColors = var2.modifiedModelColors;
		// originalTextureColors = var2.originalTextureColors;
		// modifiedTextureColors = var2.modifiedTextureColors;
		name = var2.name;
		membersObject = var2.membersObject;
		stackable = var2.stackable;
		maleModel = 1 * var2.maleModel;
		maleArm = 1 * var2.maleArm;
		maleModel3 = 1 * var2.maleModel3;
		femaleModel = var2.femaleModel * 1;
		femaleArm = var2.femaleArm * 1;
		femaleModel3 = 1 * var2.femaleModel3;
		anInt175 = 1 * var2.anInt175;
		anInt166 = var2.anInt166 * 1;
		anInt197 = var2.anInt197 * 1;
		anInt173 = var2.anInt173 * 1;
		team = var2.team * 1;
		groundOptions = var2.groundOptions;
		inventoryOptions = new String[5];
		equipActions = new String[5];
		if (null != var2.inventoryOptions) {
			for (int var4 = 0; var4 < 4; ++var4) {
				inventoryOptions[var4] = var2.inventoryOptions[var4];
			}
		}

		inventoryOptions[4] = "Discard";
		value = 0;
	}

	void method2790(ItemDefinition var1, ItemDefinition var2) {
		modelId = var1.modelId * 1;
		modelZoom = 1 * var1.modelZoom;
		modelRotationY = var1.modelRotationY * 1;
		modelRotationX = var1.modelRotationX * 1;
		modelRotationZ = var1.modelRotationZ * 1;
		translateX = 1 * var1.translateX;
		translateYZ = var1.translateYZ * 1;
		newModelColors = var1.newModelColors;
		modifiedModelColors = var1.modifiedModelColors;
		originalTextureColors = var1.originalTextureColors;
		modifiedTextureColors = var1.modifiedTextureColors;
		stackable = var1.stackable;
		name = var2.name;
		value = 0;
	}


	private void readValues(Buffer stream) {
		while (true) {
			int opcode = stream.readUnsignedByte();
			if (opcode == 0)
				return;
			if (opcode == 1)
				modelId = stream.readShort();
			else if (opcode == 2)
				name = stream.readString();
			else if (opcode == 3)
				description = stream.readString();
			else if (opcode == 4)
				modelZoom = stream.readShort();
			else if (opcode == 5)
				modelRotationY = stream.readShort();
			else if (opcode == 6)
				modelRotationX = stream.readShort();
			else if (opcode == 7) {
				translateX = stream.readShort();
				if (translateX > 32767)
					translateX -= 0x10000;
			} else if (opcode == 8) {
				translateYZ = stream.readShort();
				if (translateYZ > 32767)
					translateYZ -= 0x10000;
			} else if (opcode == 11)
				stackable = true;
			else if (opcode == 12)
				value = stream.readInt();
			else if (opcode == 16)
				membersObject = true;
			else if (opcode == 23) {
				maleModel = stream.readShort();
				maleOffset = stream.readSignedByte();
			} else if (opcode == 24)
				maleArm = stream.readShort();
			else if (opcode == 25) {
				femaleModel = stream.readShort();
				femaleOffset = stream.readSignedByte();
			} else if (opcode == 26)
				femaleArm = stream.readShort();
			else if (opcode >= 30 && opcode < 35) {
				if (groundOptions == null)
					groundOptions = new String[5];
				groundOptions[opcode - 30] = stream.readString();
				if (groundOptions[opcode - 30].equalsIgnoreCase("hidden"))
					groundOptions[opcode - 30] = null;
			} else if (opcode >= 35 && opcode < 40) {
				if (inventoryOptions == null)
					inventoryOptions = new String[5];
				inventoryOptions[opcode - 35] = stream.readString();
			} else if (opcode == 40) {
				int size = stream.readUnsignedByte();
				newModelColors = new int[size];
				modifiedModelColors = new int[size];
				for (int index = 0; index < size; index++) {
					newModelColors[index] = stream.readShort();
					modifiedModelColors[index] = stream.readShort();
				}
			} else if (opcode == 41) {
				int size = stream.readUnsignedByte();
				originalTextureColors = new int[size];
				modifiedTextureColors = new int[size];
				for (int index = 0; index < size; index++) {
					originalTextureColors[index] = stream.readShort();
					modifiedTextureColors[index] = stream.readShort();
				}
			} else if (opcode == 65) {
				searchableItem = true;
			} else if (opcode == 78)
				maleModel3 = stream.readShort();
			else if (opcode == 79)
				femaleModel3 = stream.readShort();
			else if (opcode == 90)
				anInt175 = stream.readShort();
			else if (opcode == 91)
				anInt197 = stream.readShort();
			else if (opcode == 92)
				anInt166 = stream.readShort();
			else if (opcode == 93)
				anInt173 = stream.readShort();
			else if (opcode == 95)
				modelRotationZ = stream.readShort();
			else if (opcode == 97)
				certID = stream.readShort();
			else if (opcode == 98)
				certTemplateID = stream.readShort();
			else if (opcode >= 100 && opcode < 110) {
				if (stackIDs == null) {
					stackIDs = new int[10];
					stackAmounts = new int[10];
				}
				stackIDs[opcode - 100] = stream.readShort();
				stackAmounts[opcode - 100] = stream.readShort();
			} else if (opcode == 110)
				anInt167 = stream.readShort();
			else if (opcode == 111)
				anInt192 = stream.readShort();
			else if (opcode == 112)
				anInt191 = stream.readShort();
			else if (opcode == 113)
				anInt196 = stream.readSignedByte();
			else if (opcode == 114)
				anInt184 = stream.readSignedByte() * 5;
			else if (opcode == 115)
				team = stream.readUnsignedByte();
			else if (opcode == 139)
				opcode139 = stream.readShort();
			else if (opcode == 140)
				opcode140 = stream.readShort();
			else if (opcode == 148)
				opcode148 = stream.readShort();
			else if (opcode == 149)
				opcode149 = stream.readShort();
			else {
				// System.out.println("Error loading item " + id + ", opcode " + opcode);
			}
		}
	}

	public int opcode139, opcode140, opcode148, opcode149;

	public static void nullLoader() {
		mruNodes2 = null;
		mruNodes1 = null;
		streamIndices = null;
		cache = null;
		stream = null;
		
	}

	public boolean method192(int j) {
		int k = anInt175;
		int l = anInt166;
		if (j == 1) {
			k = anInt197;
			l = anInt173;
		}
		if (k == -1)
			return true;
		boolean flag = true;
		if (!Model.modelIsFetched(k))
			flag = false;
		if (l != -1 && !Model.modelIsFetched(l))
			flag = false;
		return flag;
	}

	public Model method194(int j) {
		int k = anInt175;
		int l = anInt166;
		if (j == 1) {
			k = anInt197;
			l = anInt173;
		}
		if (k == -1)
			return null;
		Model model = Model.fetchModel(k);
		if (l != -1) {
			Model model_1 = Model.fetchModel(l);
			Model aclass30_sub2_sub4_sub6s[] = { model, model_1 };
			model = new Model(2, aclass30_sub2_sub4_sub6s);
		}
		if (modifiedModelColors != null) {
			for (int i1 = 0; i1 < modifiedModelColors.length; i1++)
				model.method476(modifiedModelColors[i1], newModelColors[i1]);

		}
		if (this.rdc > 0) {
			model.method1337(this.rdc);
		}
		if (this.rdc2 != 0) {
			model.method1338(this.rdc2);
		}
		if (this.rdc3 != 0) {
			model.method1339(this.rdc3);
		}
		return model;
	}

	public boolean method195(int j) {
		int k = maleModel;
		int l = maleArm;
		int i1 = maleModel3;
		if (j == 1) {
			k = femaleModel;
			l = femaleArm;
			i1 = femaleModel3;
		}
		if (k == -1)
			return true;
		boolean flag = true;
		if (!Model.modelIsFetched(k))
			flag = false;
		if (l != -1 && !Model.modelIsFetched(l))
			flag = false;
		if (i1 != -1 && !Model.modelIsFetched(i1))
			flag = false;
		return flag;
	}

	public Model method196(int i) {
		int j = maleModel;
		int k = maleArm;
		int l = maleModel3;
		if (i == 1) {
			j = femaleModel;
			k = femaleArm;
			l = femaleModel3;
		}
		if (j == -1)
			return null;
		Model model = Model.fetchModel(j);
		if (k != -1)
			if (l != -1) {
				Model model_1 = Model.fetchModel(k);
				Model model_3 = Model.fetchModel(l);
				Model aclass30_sub2_sub4_sub6_1s[] = { model, model_1, model_3 };
				model = new Model(3, aclass30_sub2_sub4_sub6_1s);
			} else {
				Model model_2 = Model.fetchModel(k);
				Model aclass30_sub2_sub4_sub6s[] = { model, model_2 };
				model = new Model(2, aclass30_sub2_sub4_sub6s);
			}
		if (i == 0 && maleOffset != 0)
			model.method475(0, maleOffset, 0);
		if (i == 1 && femaleOffset != 0)
			model.method475(0, femaleOffset, 0);
		applyTexturing(model, id);
		if (modifiedModelColors != null) {
			for (int i1 = 0; i1 < modifiedModelColors.length; i1++)
				model.method476(modifiedModelColors[i1], newModelColors[i1]);

		}
		if (this.rdc > 0) {
			model.method1337(this.rdc);
		}
		if (this.rdc2 != 0) {
			model.method1338(this.rdc2);
		}
		if (this.rdc3 != 0) {
			model.method1339(this.rdc3);
		}
		if(this.modifiedTextureColors != null) {
			for(int i1 = 0;i1<modifiedTextureColors.length;i1++) {
				model.setTexture(this.originalTextureColors[i1], this.modifiedTextureColors[i1]);
			}
		}
		return model;
	}

	private void setDefaults() {
		// equipActions = new String[6];
		equipActions = new String[] { "Remove", null, "Operate", null, null };
		modelId = 0;
		name = null;
		description = null;
		modifiedModelColors = null;
		newModelColors = null;
		modifiedTextureColors = null;
		originalTextureColors = null;
		modelZoom = 2000;
		modelRotationY = 0;
		modelRotationX = 0;
		modelRotationZ = 0;
		translateX = 0;
		translateYZ = 0;
		stackable = false;
		value = 1;
		membersObject = false;
		groundOptions = null;
		inventoryOptions = null;
		maleModel = -1;
		maleArm = -1;
		maleOffset = 0;
		femaleModel = -1;
		femaleArm = -1;
		femaleOffset = 0;
		maleModel3 = -1;
		femaleModel3 = -1;
		anInt175 = -1;
		anInt166 = -1;
		anInt197 = -1;
		anInt173 = -1;
		stackIDs = null;
		stackAmounts = null;
		certID = -1;
		certTemplateID = -1;
		anInt167 = 128;
		anInt192 = 128;
		anInt191 = 128;
		anInt196 = 0;
		anInt184 = 0;
		team = 0;

		opcode140 = -1;
		opcode139 = -1;
		opcode148 = -1;
		opcode149 = -1;

		searchableItem = false;
		this.rdc = 0;
		this.rdc2 = 0;
		this.rdc3 = 0;
	}

	public static void dumpBonuses() {
		int[] bonuses = new int[14];
		int bonus = 0;
		int amount = 0;
		for (int i = 21304; i < totalItems; i++) {
			ItemDefinition item = ItemDefinition.forID(i);
			URL url;
			try {
				try {
					try {
						url = new URL("http://2007.runescape.wikia.com/wiki/" + item.name.replaceAll(" ", "_"));
						URLConnection con = url.openConnection();
						BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
						String line;
						BufferedWriter writer = new BufferedWriter(new FileWriter("item.cfg", true));
						while ((line = in.readLine()) != null) {
							try {
								if (line.contains("<td style=\"text-align: center; width: 35px;\">")) {
									line = line.replace("</td>", "").replace("%", "").replace("?", "")
											.replace("\"\"", "")
											.replace("<td style=\"text-align: center; width: 35px;\">", "");
									bonuses[bonus] = Integer.parseInt(line);
									bonus++;
								} else if (line.contains("<td style=\"text-align: center; width: 30px;\">")) {
									line = line.replace("</td>", "").replace("%", "").replace("?", "").replace("%", "")
											.replace("<td style=\"text-align: center; width: 30px;\">", "");
									bonuses[bonus] = Integer.parseInt(line);
									bonus++;
								}
							} catch (NumberFormatException e) {

							}
							if (bonus >= 13)
								bonus = 0;
							// in.close();
						}
						in.close();
						writer.write("item	=	" + i + "	" + item.name.replace(" ", "_") + "	"
								+ item.description.replace(" ", "_") + "	" + item.value + "	" + item.value + "	"
								+ item.value + "	" + bonuses[0] + "	" + bonuses[1] + "	" + bonuses[2] + "	"
								+ bonuses[3] + "	" + bonuses[4] + "	" + bonuses[5] + "	" + bonuses[6] + "	"
								+ bonuses[7] + "	" + bonuses[8] + "	" + bonuses[9] + "	" + bonuses[10] + "	"
								+ bonuses[13]);
						bonuses[0] = bonuses[1] = bonuses[2] = bonuses[3] = bonuses[4] = bonuses[5] = bonuses[6] = bonuses[7] = bonuses[8] = bonuses[9] = bonuses[10] = bonuses[13] = 0;
						writer.newLine();
						amount++;
						writer.close();
					} catch (NullPointerException e) {

					}
				} catch (FileNotFoundException e) {

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done dumping " + amount + " item bonuses!");
	}

	public static void dumpBonus() {
		final int[] wikiBonuses = new int[18];
		int bonus = 0;
		int amount = 0;
		System.out.println("Starting to dump item bonuses...");
		for (int i = 20000; i < totalItems; i++) {
			ItemDefinition item = ItemDefinition.forID(i);
			try {
				try {
					try {
						final URL url = new URL(
								"http://2007.runescape.wikia.com/wiki/" + item.name.replaceAll(" ", "_"));
						URLConnection con = url.openConnection();
						BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
						String line;
						writer = new BufferedWriter(new FileWriter("item.cfg", true));
						while ((line = in.readLine()) != null) {
							try {
								if (line.contains("<td style=\"text-align: center; width: 35px;\">")) {
									line = line.replace("</td>", "").replace("%", "").replace("?", "")
											.replace("\"\"", "")
											.replace("<td style=\"text-align: center; width: 35px;\">", "");
									wikiBonuses[bonus] = Integer.parseInt(line);
									bonus++;
								} else if (line.contains("<td style=\"text-align: center; width: 30px;\">")) {
									line = line.replace("</td>", "").replace("%", "").replace("?", "").replace("%", "")
											.replace("<td style=\"text-align: center; width: 30px;\">", "");
									wikiBonuses[bonus] = Integer.parseInt(line);
									bonus++;
								}
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
							in.close();
							writer.write("item = " + i + "	" + item.name.replace(" ", "_") + "	"
									+ item.description.replace(" ", "_") + "	" + item.value + "	" + item.value
									+ "	" + item.value + "	" + wikiBonuses[0] + "	" + wikiBonuses[1] + "	"
									+ wikiBonuses[2] + "	" + wikiBonuses[3] + "	" + wikiBonuses[4] + "	"
									+ wikiBonuses[5] + "	" + wikiBonuses[6] + "	" + wikiBonuses[7] + "	"
									+ wikiBonuses[8] + "	" + wikiBonuses[9] + "	" + wikiBonuses[10] + "	"
									+ wikiBonuses[13]);
							amount++;
							wikiBonuses[0] = wikiBonuses[1] = wikiBonuses[2] = wikiBonuses[3] = wikiBonuses[4] = wikiBonuses[5] = wikiBonuses[6] = wikiBonuses[7] = wikiBonuses[8] = wikiBonuses[9] = wikiBonuses[10] = wikiBonuses[11] = wikiBonuses[13] = 0;
							writer.newLine();
							writer.close();
						}
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Done dumping " + amount + " item bonuses!");
		}
	}

	public static void dumpItemDefs() {
		final int[] wikiBonuses = new int[18];
		int bonus = 0;
		int amount = 0;
		int value = 0;
		int slot = -1;
		// Testing Variables just so i know format is correct
		String fullmask = "false";
		// boolean stackable1 = false;
		String stackable = "false";
		// boolean noteable1 = false;
		String noteable = "true";
		// boolean tradeable1 = false;
		String tradeable = "true";
		// boolean wearable1 = false;
		String wearable = "true";
		String showBeard = "true";
		String members = "true";
		boolean twoHanded = false;
		System.out.println("Starting to dump item definitions...");
		for (int i = 22000; i < totalItems; i++) {
			ItemDefinition item = ItemDefinition.forID(i);
			try {
				try {
					try {
						final URL url = new URL(
								"http://2007.runescape.wikia.com/wiki/" + item.name.replaceAll(" ", "_"));
						URLConnection con = url.openConnection();
						BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
						String line;
						writer = new BufferedWriter(new FileWriter("itemDefs.json", true));
						while ((line = in.readLine()) != null) {
							try {
								if (line.contains("<td style=\"text-align: center; width: 35px;\">")) {
									line = line.replace("</td>", "").replace("%", "").replace("?", "")
											.replace("\"\"", "")
											.replace("<td style=\"text-align: center; width: 35px;\">", "");
									wikiBonuses[bonus] = Integer.parseInt(line);
									bonus++;
								} else if (line.contains("<td style=\"text-align: center; width: 30px;\">")) {
									line = line.replace("</td>", "").replace("%", "").replace("?", "").replace("%", "")
											.replace("<td style=\"text-align: center; width: 30px;\">", "");
									wikiBonuses[bonus] = Integer.parseInt(line);
									bonus++;
								}
								if (line.contains("<div id=\"GEPCalcResult\" style=\"display:inline;\">")) {
									line = line.replace("</div>", "").replace("%", "").replace("?", "").replace("%", "")
											.replace("<div id=\"GEPCalcResult\" style=\"display:inline;\">", "");
									value = Integer.parseInt(line);
								}

							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
							in.close();
							// fw.write("ItemID: "+itemDefinition.id+" - "+itemDefinition.name);
							// fw.write(System.getProperty("line.separator"));
							// writer.write("[\n");
							writer.write("  {\n\t\"id\": " + item.id + ",\n\t\"name\": \"" + item.name
									+ "\",\n\t\"desc\": \"" + item.description.replace("_", " ") + "\",\n\t\"value\": "
									+ value + ",\n\t\"dropValue\": " + value + ",\n\t\"bonus\": [\n\t  "
									+ wikiBonuses[0] + ",\n\t  " + wikiBonuses[1] + ",\n\t  " + wikiBonuses[2]
									+ ",\n\t  " + wikiBonuses[3] + ",\n\t  " + wikiBonuses[4] + ",\n\t  "
									+ wikiBonuses[5] + ",\n\t  " + wikiBonuses[6] + ",\n\t  " + wikiBonuses[7]
									+ ",\n\t  " + wikiBonuses[8] + ",\n\t  " + wikiBonuses[9] + ",\n\t  "
									+ wikiBonuses[10] + ",\n\t  " + wikiBonuses[13] + ",\n\t],\n\t\"slot\": " + slot
									+ ",\n\t\"fullmask\": " + fullmask + ",\n\t\"stackable\": " + stackable
									+ ",\n\t\"noteable\": " + noteable + ",\n\t\"tradeable\": " + tradeable
									+ ",\n\t\"wearable\": " + wearable + ",\n\t\"showBeard\": " + showBeard
									+ ",\n\t\"members\": " + members + ",\n\t\"slot\": " + twoHanded
									+ ",\n\t\"requirements\": [\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t  0,\n\t]\n  },\n");
							/*
							 * writer.write("item = " + i + "	" + item.name.replace(" ", "_") + "	" +
							 * item.description.replace(" ", "_") + "	" + item.value + "	" + item.value +
							 * "	" + item.value + "	" + wikiBonuses[0] + "	" + wikiBonuses[1] + "	" +
							 * wikiBonuses[2] + "	" + wikiBonuses[3] + "	" + wikiBonuses[4] + "	" +
							 * wikiBonuses[5] + "	" + wikiBonuses[6] + "	" + wikiBonuses[7] + "	" +
							 * wikiBonuses[8] + "	" + wikiBonuses[9] + "	" + wikiBonuses[10] + "	" +
							 * wikiBonuses[13]);
							 */
							amount++;
							wikiBonuses[0] = wikiBonuses[1] = wikiBonuses[2] = wikiBonuses[3] = wikiBonuses[4] = wikiBonuses[5] = wikiBonuses[6] = wikiBonuses[7] = wikiBonuses[8] = wikiBonuses[9] = wikiBonuses[10] = wikiBonuses[11] = wikiBonuses[13] = 0;
							writer.newLine();
							writer.close();
						}
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Done dumping " + amount + " item definitions!");
		}
	}

	public static void itemDump() {
		try {
			FileWriter fw = new FileWriter(System.getProperty("user.home") + "/Desktop/Item Dump.txt");
			for (int i = totalItems - 22500; i < totalItems; i++) {
				ItemDefinition item = ItemDefinition.forID(i);
				fw.write("case " + i + ":");
				fw.write(System.getProperty("line.separator"));
				fw.write("itemDef.name = \"" + item.name + "\";");
				fw.write(System.getProperty("line.separator"));
				fw.write("itemDef.modelID= " + item.modelId + ";");
				fw.write(System.getProperty("line.separator"));
				fw.write("itemDef.maleModel= " + item.maleModel + ";");
				fw.write(System.getProperty("line.separator"));
				fw.write("itemDef.femaleModel= " + item.femaleModel + ";");
				fw.write(System.getProperty("line.separator"));
				fw.write("itemDef.modelZoom = " + item.modelZoom + ";");
				fw.write(System.getProperty("line.separator"));
				fw.write("itemDef.modelRotationX = " + item.modelRotationY + ";");
				fw.write(System.getProperty("line.separator"));
				fw.write("itemDef.modelRotationY = " + item.modelRotationX + ";");
				fw.write(System.getProperty("line.separator"));
				fw.write("itemDef.modelOffset1 = " + item.translateX + ";");
				fw.write(System.getProperty("line.separator"));
				fw.write("itemDef.modelOffset2 = " + item.translateYZ + ";");
				fw.write(System.getProperty("line.separator"));
				fw.write("itemDef.description = \"" + item.description + "\";");
				fw.write(System.getProperty("line.separator"));

				fw.write(System.getProperty("line.separator"));
				fw.write("itemDef.value = " + item.value + ";");
				fw.write(System.getProperty("line.separator"));
				fw.write("itemDef.team = " + item.team + ";");
				fw.write(System.getProperty("line.separator"));
				fw.write("break;");
				fw.write(System.getProperty("line.separator"));
				fw.write(System.getProperty("line.separator"));
			}
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void dumpList() {
		try {
			FileWriter fw = new FileWriter(System.getProperty("user.home") + "/Desktop/item_data.json");
			for (int i = 20000; i < totalItems; i++) {
				ItemDefinition itemDefinition = ItemDefinition.forID(i);
				fw.write("id: " + itemDefinition.id + " - " + itemDefinition.name + "\n");
			}
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void dumpStackableList() {
		try {
			File file = new File("stackables.dat");

			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalItems; i++) {
					ItemDefinition definition = forID(i);
					if (definition != null) {
						writer.write(definition.id + "\t" + definition.stackable);
						writer.newLine();
					} else {
						writer.write(i + "\tfalse");
						writer.newLine();
					}
				}
			}

			System.out.println("Finished dumping noted items definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int[] unNoteable = {};

	public static void dumpNotes() {
		try {
			FileOutputStream out = new FileOutputStream(new File("notes.dat"));
			for (int j = 0; j < totalItems; j++) {
				ItemDefinition item = ItemDefinition.forID(j);
				for (int i = 0; i < totalItems; i++)
					if (j == unNoteable[i] + 1)
						out.write(0);
					else
						out.write(item.certTemplateID != -1 ? 0 : 1);
			}
			out.write(-1);
			out.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void dumpStackable() {
		try {
			FileOutputStream out = new FileOutputStream(new File("stackable.dat"));
			for (int j = 0; j < totalItems; j++) {
				ItemDefinition item = ItemDefinition.forID(j);
				out.write(item.stackable ? 1 : 0);
			}
			out.write(-1);
			out.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void dumpNotableList() {
		try {
			File file = new File("note_id.dat");

			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalItems; i++) {
					ItemDefinition definition = ItemDefinition.forID(i);
					if (definition != null) {
						if (definition.certTemplateID == -1 && definition.certID != -1) {
							writer.write(definition.id + "\t" + definition.certID);
							writer.newLine();
						}
					} else {
						writer.write(i + "\t-1");
						writer.newLine();
					}
				}
			}

			System.out.println("Finished dumping noted items definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void toNote() {
		ItemDefinition itemDef = forID(certTemplateID);
		modelId = itemDef.modelId;
		modelZoom = itemDef.modelZoom;
		modelRotationY = itemDef.modelRotationY;
		modelRotationX = itemDef.modelRotationX;

		modelRotationZ = itemDef.modelRotationZ;
		translateX = itemDef.translateX;
		translateYZ = itemDef.translateYZ;
		modifiedModelColors = itemDef.modifiedModelColors;
		newModelColors = itemDef.newModelColors;
		ItemDefinition itemDef_1 = forID(certID);
		name = itemDef_1.name;
		membersObject = itemDef_1.membersObject;
		value = itemDef_1.value;
		String s = "a";
		char c = itemDef_1.name == null ? 'z' : itemDef_1.name.charAt(0);
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
			s = "an";
		description = ("Swap this note at any bank for " + s + " " + itemDef_1.name + ".");
		stackable = true;
	}

	public static Sprite getSmallSprite(int itemId) {
		ItemDefinition itemDef = forID(itemId);
		Model model = itemDef.method201(1);
		if (model == null) {
			return null;
		}
		Sprite sprite1 = null;
		if (itemDef.certTemplateID != -1) {
			sprite1 = getSprite(itemDef.certID, 10, -1);
			if (sprite1 == null) {
				return null;
			}
		}
		Sprite enabledSprite = new Sprite(18, 18);
		int k1 = Rasterizer3D.textureInt1;
		int l1 = Rasterizer3D.textureInt2;
		int ai[] = Rasterizer3D.anIntArray1472;
		int ai1[] = Raster.pixels;
		int i2 = Raster.width;
		int j2 = Raster.height;
		int k2 = Raster.topX;
		int l2 = Raster.bottomX;
		int i3 = Raster.topY;
		int j3 = Raster.bottomY;
		Rasterizer3D.aBoolean1464 = false;
		Raster.initDrawingArea(18, 18, enabledSprite.myPixels);
		Raster.method336(18, 0, 0, 0, 18);
		Rasterizer3D.method364();
		int k3 = (int) (itemDef.modelZoom * 1.6D);
		int l3 = Rasterizer3D.anIntArray1470[itemDef.modelRotationY] * k3 >> 16;
		int i4 = Rasterizer3D.anIntArray1471[itemDef.modelRotationY] * k3 >> 16;
		model.method482(itemDef.modelRotationX, itemDef.modelRotationZ, itemDef.modelRotationY, itemDef.translateX,
				l3 + model.modelHeight / 2 + itemDef.translateYZ, i4 + itemDef.translateYZ);
		if (itemDef.certTemplateID != -1) {
			int l5 = sprite1.maxWidth;
			int j6 = sprite1.maxHeight;
			sprite1.maxWidth = 18;
			sprite1.maxHeight = 18;
			sprite1.drawSprite(0, 0);
			sprite1.maxWidth = l5;
			sprite1.maxHeight = j6;
		}
		Raster.initDrawingArea(j2, i2, ai1);
		Raster.setDrawingArea(j3, k2, l2, i3);
		Rasterizer3D.textureInt1 = k1;
		Rasterizer3D.textureInt2 = l1;
		Rasterizer3D.anIntArray1472 = ai;
		Rasterizer3D.aBoolean1464 = true;

		enabledSprite.maxWidth = 18;
		enabledSprite.maxHeight = 18;

		return enabledSprite;
	}

	public static Sprite getSprite(int itemId, int itemAmount, int highlightColor) {
		if (highlightColor == 0) {
			Sprite sprite = (Sprite) mruNodes1.insertFromCache(itemId);
			if (sprite != null && sprite.maxHeight != itemAmount && sprite.maxHeight != -1) {
				sprite.unlink();
				sprite = null;
			}
			/*if (sprite != null)
				return sprite;*/
		}
		ItemDefinition itemDef = forID(itemId);
		if (itemDef.stackIDs == null)
			itemAmount = -1;
		if (itemAmount > 1) {
			int i1 = -1;
			for (int j1 = 0; j1 < 10; j1++)
				if (itemAmount >= itemDef.stackAmounts[j1] && itemDef.stackAmounts[j1] != 0)
					i1 = itemDef.stackIDs[j1];

			if (i1 != -1)
				itemDef = forID(i1);
		}
		Model model = itemDef.method201(1);
		if (model == null)
			return null;
		Sprite sprite = null;
		if (itemDef.certTemplateID != -1) {
			sprite = getSprite(itemDef.certID, 10, -1);
			if (sprite == null)
				return null;
		} else if (itemDef.opcode140 != -1) {
			sprite = getSprite(itemDef.opcode139, itemAmount, -1);
			if (sprite == null)
				return null;
		} else if (itemDef.opcode149 != -1) {
			sprite = getSprite(itemDef.opcode148, itemAmount, -1);
			if (sprite == null)
				return null;
		}
		Sprite sprite2 = new Sprite(32, 32);
		int k1 = Rasterizer3D.textureInt1;
		int l1 = Rasterizer3D.textureInt2;
		int ai[] = Rasterizer3D.anIntArray1472;
		int ai1[] = Raster.pixels;
		int i2 = Raster.width;
		int j2 = Raster.height;
		int k2 = Raster.topX;
		int l2 = Raster.bottomX;
		int i3 = Raster.topY;
		int j3 = Raster.bottomY;
		Rasterizer3D.aBoolean1464 = false;
		Raster.initDrawingArea(32, 32, sprite2.myPixels);
		Raster.method336(32, 0, 0, 0, 32);
		Rasterizer3D.method364();
		if (itemDef.opcode149 != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		int k3 = itemDef.modelZoom;
		if (highlightColor == -1)
			k3 = (int) ((double) k3 * 1.5D);
		if (highlightColor > 0)
			k3 = (int) ((double) k3 * 1.04D);
		int l3 = Rasterizer3D.anIntArray1470[itemDef.modelRotationY] * k3 >> 16;
		int i4 = Rasterizer3D.anIntArray1471[itemDef.modelRotationY] * k3 >> 16;
		model.method482(itemDef.modelRotationX, itemDef.modelRotationZ, itemDef.modelRotationY, itemDef.translateX,
				l3 + model.modelHeight / 2 + itemDef.translateYZ, i4 + itemDef.translateYZ);
		if (itemDef.opcode140 != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		for (int i5 = 31; i5 >= 0; i5--) {
			for (int j4 = 31; j4 >= 0; j4--)
				if (sprite2.myPixels[i5 + j4 * 32] == 0)
					if (i5 > 0 && sprite2.myPixels[(i5 - 1) + j4 * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
					else if (j4 > 0 && sprite2.myPixels[i5 + (j4 - 1) * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
					else if (i5 < 31 && sprite2.myPixels[i5 + 1 + j4 * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
					else if (j4 < 31 && sprite2.myPixels[i5 + (j4 + 1) * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;

		}

		if (highlightColor > 0) {
			for (int j5 = 31; j5 >= 0; j5--) {
				for (int k4 = 31; k4 >= 0; k4--)
					if (sprite2.myPixels[j5 + k4 * 32] == 0)
						if (j5 > 0 && sprite2.myPixels[(j5 - 1) + k4 * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = highlightColor;
						else if (k4 > 0 && sprite2.myPixels[j5 + (k4 - 1) * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = highlightColor;
						else if (j5 < 31 && sprite2.myPixels[j5 + 1 + k4 * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = highlightColor;
						else if (k4 < 31 && sprite2.myPixels[j5 + (k4 + 1) * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = highlightColor;

			}

		} else if (highlightColor == 0) {
			for (int k5 = 31; k5 >= 0; k5--) {
				for (int l4 = 31; l4 >= 0; l4--)
					if (sprite2.myPixels[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0
							&& sprite2.myPixels[(k5 - 1) + (l4 - 1) * 32] > 0)
						sprite2.myPixels[k5 + l4 * 32] = 0x302020;

			}

		}
		if (itemDef.certTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		if (highlightColor == 0)
			mruNodes1.removeFromCache(sprite2, itemId);
		Raster.initDrawingArea(j2, i2, ai1);
		Raster.setDrawingArea(j3, k2, l2, i3);
		Rasterizer3D.textureInt1 = k1;
		Rasterizer3D.textureInt2 = l1;
		Rasterizer3D.anIntArray1472 = ai;
		Rasterizer3D.aBoolean1464 = true;
		if (itemDef.stackable)
			sprite2.maxWidth = 33;
		else
			sprite2.maxWidth = 32;
		sprite2.maxHeight = itemAmount;
		return sprite2;
	}

	public Model method201(int i) {
		if (stackIDs != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++)
				if (i >= stackAmounts[k] && stackAmounts[k] != 0)
					j = stackIDs[k];

			if (j != -1)
				return forID(j).method201(1);
		}
		Model model = (Model) mruNodes2.insertFromCache(id);
		if (model != null)
			return model;
		model = Model.fetchModel(modelId);
		if (model == null)
			return null;
		applyTexturing(model, id);
		if (anInt167 != 128 || anInt192 != 128 || anInt191 != 128)
			model.scale(anInt167, anInt191, anInt192);
		if (modifiedModelColors != null) {
			for (int l = 0; l < modifiedModelColors.length; l++)
				model.method476(modifiedModelColors[l], newModelColors[l]);

		}
		if (this.rdc > 0) {
			model.method1337(this.rdc);
		}
		if (this.rdc2 != 0) {
			model.method1338(this.rdc2);
		}
		if (this.rdc3 != 0) {
			model.method1339(this.rdc3);
		}
		model.light(64 + anInt196, 768 + anInt184, -50, -10, -50, true);
		model.fits_on_single_square = true;
		mruNodes2.removeFromCache(model, id);
		return model;
	}

	public Model method202(int i) {
		if (stackIDs != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++)
				if (i >= stackAmounts[k] && stackAmounts[k] != 0)
					j = stackIDs[k];

			if (j != -1)
				return forID(j).method202(1);
		}
		Model model = Model.fetchModel(modelId);
		if (model == null)
			return null;
		if (modifiedModelColors != null) {
			for (int l = 0; l < modifiedModelColors.length; l++)
				model.method476(modifiedModelColors[l], newModelColors[l]);

		}
		return model;
	}

	private ItemDefinition() {
		id = -1;
	}

	private byte femaleOffset;
	public int value;
	public int[] newModelColors;
	public int[] modifiedModelColors;

	private int[] originalTextureColors;
	private int[] modifiedTextureColors;

	public int id;
	public static Cache mruNodes1 = new Cache(100);
	public static Cache mruNodes2 = new Cache(50);

	public boolean membersObject;
	private int femaleModel3;
	public int certTemplateID;
	private int femaleArm;
	public int maleModel;
	private int anInt166;
	private int anInt167;
	public String groundOptions[];
	public int translateX;
	public String name;
	private static ItemDefinition[] cache;
	private int anInt173;
	public int modelId;
	private int anInt175;
	public boolean stackable;
	public String description;
	public int certID;
	private static int cacheIndex;
	public int modelZoom;
	private static Buffer stream;
	private int anInt184;
	private int maleModel3;
	private int maleArm;
	public String inventoryOptions[];
	public String equipActions[];
	public int modelRotationY;
	private int anInt191;
	private int anInt192;
	private int[] stackIDs;
	public int translateYZ;
	private static int[] streamIndices;
	private int anInt196;
	private int anInt197;
	public int modelRotationX;
	public int femaleModel;
	private int[] stackAmounts;
	public int team;
	public static int totalItems;
	private int modelRotationZ;
	private byte maleOffset;
	public boolean searchableItem;
	private static BufferedWriter writer;

	public static Sprite getSmallSprite(int itemId, int sizeX, int sizeY) {
		ItemDefinition itemDef = forID(itemId);
		Model model = itemDef.method201(1);
		if (model == null) {
			return null;
		}
		Sprite sprite1 = null;
		if (itemDef.certTemplateID != -1) {
			sprite1 = getSprite(itemDef.certID, 10, -1);
			if (sprite1 == null) {
				return null;
			}
		}
		Sprite enabledSprite = new Sprite(sizeX, sizeY);
		int k1 = Rasterizer3D.textureInt1;
		int l1 = Rasterizer3D.textureInt2;
		int ai[] = Rasterizer3D.anIntArray1472;
		int ai1[] = Raster.pixels;
		int i2 = Raster.width;
		int j2 = Raster.height;
		int k2 = Raster.topX;
		int l2 = Raster.bottomX;
		int i3 = Raster.topY;
		int j3 = Raster.bottomY;
		Rasterizer3D.aBoolean1464 = false;
		Raster.initDrawingArea(sizeX, sizeY, enabledSprite.myPixels);
		Raster.method336(sizeX, 0, 0, 0, sizeY);
		Rasterizer3D.method364();
		int k3 = (int) ((double)itemDef.modelZoom * ( 32.0D/ (double)sizeX));
		int l3 = Rasterizer3D.anIntArray1470[itemDef.modelRotationY] * k3 >> 16;
		int i4 = Rasterizer3D.anIntArray1471[itemDef.modelRotationY] * k3 >> 16;
		model.method482(itemDef.modelRotationX, itemDef.modelRotationZ, itemDef.modelRotationY, itemDef.translateX,
				l3 + model.modelHeight / 2 + itemDef.translateYZ, i4 + itemDef.translateYZ);
		if (itemDef.certTemplateID != -1) {
			int l5 = sprite1.maxWidth;
			int j6 = sprite1.maxHeight;
			sprite1.maxWidth = sizeX;
			sprite1.maxHeight = sizeY;
			sprite1.drawSprite(0, 0);
			sprite1.maxWidth = l5;
			sprite1.maxHeight = j6;
		}
		Raster.initDrawingArea(j2, i2, ai1);
		Raster.setDrawingArea(j3, k2, l2, i3);
		Rasterizer3D.textureInt1 = k1;
		Rasterizer3D.textureInt2 = l1;
		Rasterizer3D.anIntArray1472 = ai;
		Rasterizer3D.aBoolean1464 = true;
 		enabledSprite.maxWidth = sizeX;
		enabledSprite.maxHeight = sizeY;
 		return enabledSprite;
	}



}
