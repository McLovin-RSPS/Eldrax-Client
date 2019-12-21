package com.client.cache.definitions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//
//import org.apache.commons.io.FileUtils;
import java.util.Arrays;

import com.client.Client;
import com.client.cache.Archive;
import com.client.cache.animation.Frame;
import com.client.cache.config.VarBit;
import com.client.cache.graphics.Sprite;
import com.client.collection.Cache;
import com.client.config.Configuration;
import com.client.io.Buffer;
import com.client.map.objects.FloatingSprite;
import com.client.map.objects.FloatingText;
import com.client.model.Model;

public final class NpcDefinition {

	public static NpcDefinition forID(int i) {
		for (int j = 0; j < 20; j++)
			if (cache[j].interfaceType == i)
				return cache[j];

		if(i >= streamIndices.length) {
			return forID(0);
		}
		anInt56 = (anInt56 + 1) % 20;
		NpcDefinition npc = cache[anInt56] = new NpcDefinition();
		stream.position = streamIndices[i];
		npc.interfaceType = i;
		npc.readValues(stream);
		if (i == 1524 || i == 3913 || i == 4712 || i == 3417 || i ==3657 || i == 1520) {
			FloatingSprite floatingSprite = new FloatingSprite();
			floatingSprite.sprite = new Sprite("/interfaces/prestige/playerstats/skills/img 10");
			floatingSprite.spriteHeight = 200;
			floatingSprite.spriteOpacity = 0.6f;
		}
		if(i == 4306) {
			npc.name = "Wise Old Man (Skillcapes)";
			npc.actions = new String[] {"Trade", null, null, null, null};
		}
		if (i == 506) {
			npc.name = "Iron man Supplies";
			npc.description = "A shop specifically for iron men.";
			FloatingText floatingText = new FloatingText();
			floatingText.font = Client.instance.newRegularFont;
			floatingText.overheadText = "Ironman Shopkeeper";
			floatingText.textColor = 0xFFFFFF;
			floatingText.textShadow = 0x000000;
			floatingText.textOpacity = 0.9f;
			floatingText.textHeight = 200;
			npc.floatingText = floatingText;
			FloatingSprite floatingSprite = new FloatingSprite();
			floatingSprite.sprite = new Sprite("/interfaces/prestige/playerstats/skills/img 10");
			floatingSprite.spriteHeight = 200;
			floatingSprite.spriteOpacity = 0.6f;
		}if(i==3218 || i ==3217){
			npc.actions = new String[] { "Talk-to", null, null, null, null };
		}
		if (i == 5449) {
			npc.actions = new String[5];
			npc.actions[0] = "Talk-to";
			npc.actions[2] = "Decant";
			npc.actions[3] = "Clean Herbs";
		}
		if(i==3257){
			npc.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==2662){//pvm shop
			npc.name = "PVM Point Shop";
			npc.combatLevel = 0;
			npc.actions = new String[5];
			npc.actions = new String[] { "Trade", null, null, null, null };
			FloatingText floatingText = new FloatingText();
			floatingText.font = Client.instance.newRegularFont;
			floatingText.overheadText = "Pvm Point Shop";
			floatingText.textColor = 0xFFFFFF;
			floatingText.textShadow = 0x000000;
			floatingText.textOpacity = 0.9f;
			floatingText.textHeight = 200;
			npc.floatingText = floatingText;
		}
		if(i==7586){// ice fiend
			npc.actions = new String[] { null, "Attack", null, null, null };
		}
		if(i==7597){ //lizard
			npc.actions = new String[] { null, "Attack", null, null, null };
		}
		if(i==7576){ // air crab
			npc.actions = new String[] { null, "Attack", null, null, null };
		}
		if(i==7577){ //fire crab
			npc.actions = new String[] { null, "Attack", null, null, null };
		}
		if(i==7578){ //earth crab
			npc.actions = new String[] { null, "Attack", null, null, null };
		}
		if(i==7579){ //water crab
			npc.actions = new String[] { null, "Attack", null, null, null };
		}
		if(i==8278){//range shop
			npc.name = "Range Shop";
			npc.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==6781){//skill point shop
			npc.name = "Skill Point Shop";
			npc.actions = new String[] { "Trade", null, null, null, null };
			FloatingText floatingText = new FloatingText();
			floatingText.font = Client.instance.newRegularFont;
			floatingText.overheadText = "Skill Point Shop";
			floatingText.textColor = 0xFFFFFF;
			floatingText.textShadow = 0x000000;
			floatingText.textOpacity = 0.9f;
			floatingText.textHeight = 200;
			npc.floatingText = floatingText;
		}
		if(i==8122){//point shop
			npc.name = "Point Reward Shops";
			npc.actions = new String[] { "Trade", null, null, null, null };
			FloatingText floatingText = new FloatingText();
			floatingText.font = Client.instance.newRegularFont;
			floatingText.overheadText = "Point Reward Shops";
			floatingText.textColor = 0xFFFFFF;
			floatingText.textShadow = 0x000000;
			floatingText.textOpacity = 0.9f;
			floatingText.textHeight = 200;
			npc.floatingText = floatingText;
			
		}
		if(i==3216){//point shop
			npc.name = "Combat Supply Shop";
			npc.actions = new String[] { "Trade", null, null, null, null };
			FloatingText floatingText = new FloatingText();
			floatingText.font = Client.instance.newRegularFont;
			floatingText.overheadText = "Combat Supply Shop";
			floatingText.textColor = 0xFFFFFF;
			floatingText.textShadow = 0x000000;
			floatingText.textOpacity = 0.9f;
			floatingText.textHeight = 200;
			npc.floatingText = floatingText;
			
		}
	    if (i == 4819)
	    {
	      npc.description = "It's a kalphite king.";
	      npc.name = "Kalphite King";
	      npc.combatLevel = 899;
	      npc.colourRedefine2 = 14899;
		  npc.actions = new String[] { null, "Attack", null, null, null };
	      npc.models = new int[] { 800032 };
	      npc.standAnim = 2618; //2618
	    }
		if(i==534){//outfit shop
			npc.name = "Fancy Outfit Shop";
		}
		if(i==2578){//imbue rings
			npc.name = "Brother Jared (Ring Imbues)";
		}
		if(i==507){//outfit shop
			npc.name = "General Supplies";
			npc.description = "Buy combat supplies, food and potions here.";
		}
		if(i==3461){//bm shop
			npc.name = "Bloodmoney Shop";
		}
		if(i==5567){//grim reaper
			npc.actions = new String[5];
			npc.actions = new String[] { "Talk-to", null, null, null, null };
		}
		if(i==4625){
			npc.name = "Donator shop";
			npc.actions = new String[] { "Talk-to", "Trade", null, null, null };
		}
		if(i==7204){
			npc.name = "Donator shop";
			npc.actions = new String[] { "Talk-to", "Trade", null, null, null };
			FloatingText floatingText = new FloatingText();
			floatingText.font = Client.instance.newRegularFont;
			floatingText.overheadText = "Donator Shop";
			floatingText.textColor = 0xFFFFFF;
			floatingText.textShadow = 0x000000;
			floatingText.textOpacity = 0.9f;
			floatingText.textHeight = 200;
			npc.floatingText = floatingText;
		}
		if(i==8280){
			npc.name = "Damien (200M Capes)";
			npc.actions = new String[] { "Trade", "null", null, null, null };
		}
		if(i==7041){
			npc.name = "Ticket Exchange";
			npc.actions = new String[] { "Talk-to", null, null, null, null };
			npc.description = "He can exchange your vote & pkp tickets so you can spend them in the shop.";
		}
		if(i==7303){
			npc.name = "Watson (Clue Scroll Exchange)";
			npc.actions = new String[] { "Talk-to", null, null, null, null };
			npc.description = "Exchange clue scrolls here for elite clue scrolls.";
		}
		if(i==1909){
			npc.name = "Daily Task Manager";
			npc.actions = new String[] { "Talk-to", null, null, null, null };
			npc.description = "Recieve daily pvm/skilling tasks from her.";
		}
		if(i==2989){
			npc.name = "Prestige Manager";
			npc.actions = new String[] { "Talk-to", null, null, null, null };
			npc.description = "Talk to him for anything to do with Prestiging.";
		}
		if(i==6559){
			npc.name = "Mandrith (PKP Shop)";
			npc.actions = new String[] { "Talk-to", null, null, null, null };
			npc.description = "He can exchange your vote & pkp tickets so you can spend them in the shop.";
		}
		if(i==4423){
			npc.name = "Jossik (Prayer book merchant)";
			npc.actions = new String[] { "Talk-to", null, null, null, null };
			npc.description = "Buy damaged prayer books from Jossik to put your pages into.";
		}
		if(i==3219){
			npc.name = "Cooking tutor (Food shop)";
			npc.actions = new String[] { "Talk-to", null, null, null, null };
			npc.description = "You can buy food from this shop.";
		}
		if(i==7456){
			npc.name = "Perdu (Armour Repairs)";
			npc.actions = new String[] { "Talk-to", null, null, null, null };
			npc.description = "Talk to him to repair any broken/degraded armour.";
		}
		if(i==7663){
			npc.name = "Kristillia (Wilderness Slayer)";
			npc.actions = new String[] { "Talk-to", null, null, null, null };
			npc.description = "Talk to her to receive a wilderness slayer task.";
		}

		if (i == 5314) {
			npc.name = "Mystical Wizard";
			npc.actions = new String[] { "Teleport", "Pickup", "Open Bank", "Daily Boost", null };
			npc.description = "Teleporting and banking? pretty useful.";
			npc.resizeY = 40;
			npc.resizeX = 40;
		}
		
		if (i == 8026) {
			npc.name = "Vorkath";
			// entityDef.combatLevel = 732;
			npc.models = new int[] { 35023 };
			npc.standAnim = 7946;
			npc.onMinimap = true;
			npc.actions = new String[5];
			npc.actions = new String[] { "Poke", null, null, null, null };
			npc.resizeY = 100;
			npc.resizeX = 100;
		}
		if (i == 8027) {
			npc.name = "Vorkath";
			npc.combatLevel = 732;
			npc.models = new int[] { 35023 };
			npc.standAnim = 7950;
			npc.onMinimap = true;
			npc.actions = new String[5];
			npc.actions = new String[] { null, null, null, null, null };
			npc.resizeY = 100;
			npc.resizeX = 100;
		}
		if (i == 8028) {
			npc.name = "Vorkath";
			npc.combatLevel = 732;
			npc.models = new int[] { 35023 };
			npc.standAnim = 7948;
			npc.onMinimap = true;
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.resizeY = 100;
			npc.resizeX = 100;
		}
		
		if (i == 5001) {
			npc.name = "Anti-santa";
			npc.combatLevel = 0;
			npc.models = new int[] { 28975, 28984, 28982, 28980, 28977, 28988, 57001 };
			npc.standAnim = 2065;
			npc.walkAnim = 2064;
			npc.onMinimap = true;
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 300;
			npc.resizeX = 300;
		}
		if (i == 6477) {
			npc.name = "Enraged Tarn";
			npc.combatLevel = 500;
			npc.models = new int[] { 60322 };
			npc.standAnim = 5616;
			npc.walkAnim = 5615;
			npc.onMinimap = true;
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 220;
			npc.resizeX = 220;
		}
		if (i == 5000) {
			npc.name = "Tiny anti-santa";
			npc.combatLevel = 0;
			npc.models = new int[] { 28975, 28984, 28982, 28980, 28977, 28988, 57001 };
			npc.standAnim = 2065;
			npc.walkAnim = 2064;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 80;
			npc.resizeX = 80;
		}
		
		if (i == 5670) {
			npc.name = "Pet demonic gorilla";
			npc.combatLevel = 0;
			npc.models = new int[] { 31241 };
			npc.standAnim = 7230;
			npc.walkAnim = 7233;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 30;
			npc.resizeX = 30;
		}
		
		if (i == 5648) {
			npc.name = "Pet crawling hand";
			npc.combatLevel = 0;
			npc.models = new int[] { 5071 };
			npc.standAnim = 1588;
			npc.walkAnim = 1589;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 90;
			npc.resizeX = 90;
		}
		
		if (i == 5649) {
			npc.name = "Pet cave bug";
			npc.combatLevel = 0;
			npc.originalColors = new int[] { 1585, 431, 551, 8088 };
			npc.newColors = new int[] { 1699, 4766, 545, 7062 };
			npc.models = new int[] { 23854 };
			npc.standAnim = 6078;
			npc.walkAnim = 6077;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 90;
			npc.resizeX = 90;
		}
		
		if (i == 5650) {
			npc.name = "Pet cave crawler";
			npc.combatLevel = 0;
			npc.originalColors = new int[] { 21656, 21652, 8375};
			npc.newColors = new int[] { 16536, 14610, 5442};
			npc.models = new int[] { 5066, 5067, 5069 };
			npc.standAnim = 226;
			npc.walkAnim = 225;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 90;
			npc.resizeX = 90;
		}
		
		if (i == 5651) {
			npc.name = "Pet banshee";
			npc.combatLevel = 0;
			npc.models = new int[] { 5063,5079 };
			npc.standAnim = 1522;
			npc.walkAnim = 1521;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 60;
			npc.resizeX = 60;
		}
		
		if (i == 4814) {
			npc.name = "Pet holy knuckles";
			npc.combatLevel = 999;
			npc.models = new int[] {800027};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
		}
		
		if (i == 4815) {
			npc.name = "Pet vendigo";
			npc.combatLevel = 69;
			npc.models = new int[] {800028};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
		}
		
		if (i == 5652) {
			npc.name = "Pet cave slime";
			npc.combatLevel = 0;
			npc.models = new int[] { 5786 };
			npc.standAnim = 1790;
			npc.walkAnim = 1788;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 70;
			npc.resizeX = 70;
		}
		
		if (i == 5653) {
			npc.name = "Pet rockslug";
			npc.combatLevel = 0;
			npc.originalColors = new int[] {6829};
			npc.newColors = new int[] { 21782};
			npc.models = new int[] { 5084 };
			npc.standAnim = 1566;
			npc.walkAnim = 1564;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 110;
			npc.resizeX = 110;
		}
		
		if (i == 5654) {
			npc.name = "Pet cockatrice";// haha it has cock in its name.
			npc.combatLevel = 0;
			npc.models = new int[] { 5070 };
			npc.standAnim = 1561;
			npc.walkAnim = 1559;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 70;
			npc.resizeX = 70;
		}
		
		if (i == 5655) {
			npc.name = "Pet pyrefiend";
			npc.combatLevel = 0;
			npc.models = new int[] { 5083 };
			npc.standAnim = 1578;
			npc.walkAnim = 1579;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 100;
			npc.resizeX = 100;
		}
		
		if (i == 5656) {
			npc.name = "Pet basilisk";
			npc.combatLevel = 0;
			npc.models = new int[] { 5064 };
			npc.standAnim = 1545;
			npc.walkAnim = 1544;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 60;
			npc.resizeX = 60;
		}
		
		if (i == 5657) {
			npc.name = "Pet infernal mage";
			npc.originalColors = new int[] { 4550, 8741, 7952, 6798, 5404, 4626 };
			npc.newColors = new int[] { 8514, 10644, 11142, 10529, 8720, 7566 };
			npc.combatLevel = 0;
			npc.models = new int[] { 230, 250, 292, 170, 179, 5105, 185, 5036, 317, 5103, 5099, 5106 };
			npc.standAnim = 813;
			npc.walkAnim = 1205;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 80;
			npc.resizeX = 80;
		}
		
		if (i == 5658) {
			npc.name = "Pet bloodveld";
			npc.combatLevel = 0;
			npc.models = new int[] { 5065 };
			npc.standAnim = 1551;
			npc.walkAnim = 1549;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 80;
			npc.resizeX = 80;
		}
		
		if (i == 5659) {
			npc.name = "Pet jelly";
			npc.combatLevel = 0;
			npc.models = new int[] { 5081 };
			npc.standAnim = 1583;
			npc.walkAnim = 1584;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 70;
			npc.resizeX = 70;
		
		}
		
		if (i == 5660) {
			npc.name = "Pet turoth";
			npc.originalColors = new int[] { 10357, 5351 };
			npc.newColors = new int[] { 317, 181 };
			npc.combatLevel = 0;
			npc.models = new int[] { 5086 };
			npc.standAnim = 1594;
			npc.walkAnim = 1593;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 70;
			npc.resizeX = 70;
		
		}
		
		if (i == 5661) {
			npc.name = "Pet aberrant spectre";
			npc.combatLevel = 0;
			npc.models = new int[] { 5085 };
			npc.standAnim = 1506;
			npc.walkAnim = 1505;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 30;
			npc.resizeX = 30;
		
		}
		
		if (i == 5662) {
			npc.name = "Pet dust devil";
			npc.combatLevel = 0;
			npc.models = new int[] { 5076, 5077 };
			npc.standAnim = 1556;
			npc.walkAnim = 1554;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 80;
			npc.resizeX = 80;
		
		}
		
		if (i == 5663) {
			npc.name = "Pet kurask";
			npc.combatLevel = 0;
			npc.models = new int[] { 5082 };
			npc.standAnim = 1511;
			npc.walkAnim = 1510;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 60;
			npc.resizeX = 60;
		
		}
		
		if (i == 5665) {
			npc.name = "Pet skeletal wyvern";
			npc.originalColors = new int[] { 103, 82 , 61, 41, 0 };
			npc.newColors = new int[] { -25506, -24362, -24374, -24391, -27475 };
			npc.combatLevel = 0;
			npc.models = new int[] { 10351, 10354, 10356, 21832  };
			npc.standAnim = 2984;
			npc.walkAnim = 2982;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5666) {
			npc.name = "Pet gargyole";
			npc.combatLevel = 0;
			npc.models = new int[] { 5078, 5079  };
			npc.standAnim = 1516;
			npc.walkAnim = 1515;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 50;
			npc.resizeX = 50;
		
		}
		
		if (i == 5667) {
			npc.name = "Pet nechryael";
			npc.combatLevel = 0;
			npc.models = new int[] { 5074  };
			npc.standAnim = 1527;
			npc.walkAnim = 1526;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 50;
			npc.resizeX = 50;
		
		}
		
		if (i == 5668) {
			npc.name = "Pet abyssal demon";
			npc.originalColors = new int[] { 4015 };
			npc.newColors = new int[] { 528 };
			npc.combatLevel = 0;
			npc.models = new int[] { 5062};
			npc.standAnim = 1536;
			npc.walkAnim = 1534;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5669) {
			npc.name = "Pet dark beast";
			npc.combatLevel = 0;
			npc.models = new int[] { 26395};
			npc.standAnim = 2730;
			npc.walkAnim = 2729;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 60;
			npc.resizeX = 60;
		
		}
		
		if (i == 5693) {
			npc.name = "Pet night beast";
			npc.combatLevel = 0;
			npc.models = new int[] { 32933};
			npc.standAnim = 2730;
			npc.walkAnim = 2729;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5671) {
			npc.name = "Pet greater abyssal demon";
			npc.combatLevel = 0;
			npc.models = new int[] { 32921};
			npc.standAnim = 1536;
			npc.walkAnim = 1534;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5672) {
			npc.name = "Pet crushing hand";
			npc.combatLevel = 0;
			npc.models = new int[] { 32922};
			npc.standAnim = 1588;
			npc.walkAnim = 1589;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 50;
			npc.resizeX = 50;
		
		}
		
		
		if (i == 5673) {
			npc.name = "Pet chasm crawler";
			npc.combatLevel = 0;
			npc.models = new int[] { 32918};
			npc.standAnim = 226;
			npc.walkAnim = 225;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 50;
			npc.resizeX = 50;
		
		}
		
		if (i == 5674) {
			npc.name = "Pet screaming banshee";
			npc.combatLevel = 0;
			npc.models = new int[] { 32823};
			npc.standAnim = 7545;
			npc.walkAnim = 1104;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5675) {
			npc.name = "Pet twisted banshee";
			npc.combatLevel = 0;
			npc.models = new int[] { 32847};
			npc.standAnim = 7545;
			npc.walkAnim = 1104;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5676) {
			npc.name = "Pet giant rockslug";
			npc.combatLevel = 0;
			npc.models = new int[] { 32919};
			npc.standAnim = 1566;
			npc.walkAnim = 1564;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5677) {
			npc.name = "Pet cockathrice";
			npc.combatLevel = 0;
			npc.models = new int[] { 32920};
			npc.standAnim = 1561;
			npc.walkAnim = 1559;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 60;
			npc.resizeX = 60;
		
		}
		
		if (i == 5678) {
			npc.name = "Pet flaming pyrelord";
			npc.combatLevel = 0;
			npc.models = new int[] { 32923};
			npc.standAnim = 1578;
			npc.walkAnim = 1579;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 50;
			npc.resizeX = 50;
		
		}
		
		
		if (i == 5679) {
			npc.name = "Pet monstrous basilisk";
			npc.combatLevel = 0;
			npc.models = new int[] { 32924};
			npc.standAnim = 1545;
			npc.walkAnim = 1544;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5680) {
			npc.name = "Pet malevolent mage";
			npc.combatLevel = 0;
			npc.models = new int[] { 32929};
			npc.standAnim = 813;
			npc.walkAnim = 1205;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 70;
			npc.resizeX = 70;
		
		}
		
		if (i == 5681) {
			npc.name = "Pet insatiable bloodveld";
			npc.combatLevel = 0;
			npc.models = new int[] { 32926};
			npc.standAnim = 1551;
			npc.walkAnim = 1549;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 50;
			npc.resizeX = 50;
		
		}
		
		if (i == 5682) {
			npc.name = "Pet insatiable mutated bloodveld";
			npc.combatLevel = 0;
			npc.models = new int[] { 32925};
			npc.standAnim = 1551;
			npc.walkAnim = 1549;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 50;
			npc.resizeX = 50;
		
		}
		
		if (i == 5683) {
			npc.name = "Pet vitreous jelly";
			npc.combatLevel = 0;
			npc.models = new int[] { 32852};
			npc.standAnim = 1583;
			npc.walkAnim = 1584;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5684) {
			npc.name = "Pet vitreous warped jelly";
			npc.combatLevel = 0;
			npc.models = new int[] { 32917};
			npc.standAnim = 1583;
			npc.walkAnim = 1584;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 30;
			npc.resizeX = 30;
		
		}
		
		
		if (i == 5685) {
			npc.name = "Pet cave abomination";
			npc.combatLevel = 0;
			npc.models = new int[] { 32935};
			npc.standAnim = 4231;
			npc.walkAnim = 4236;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 50;
			npc.resizeX = 50;
		
		}
		
		
		if (i == 5686) {
			npc.name = "Pet abhorrent spectre";
			npc.combatLevel = 0;
			npc.models = new int[] { 32930};
			npc.standAnim = 6371;
			npc.walkAnim = 6372;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5687) {
			npc.name = "Pet repugnant spectre";
			npc.combatLevel = 0;
			npc.models = new int[] { 32931};
			npc.standAnim = 6371;
			npc.walkAnim = 6372;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		
		if (i == 5688) {
			npc.name = "Pet choke devil";
			npc.combatLevel = 0;
			npc.models = new int[] { 32927};
			npc.standAnim = 1556;
			npc.walkAnim = 1554;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 50;
			npc.resizeX = 50;
		
		}
		
		
		if (i == 5689) {
			npc.name = "Pet king kurask";
			npc.combatLevel = 0;
			npc.models = new int[] { 32934};
			npc.standAnim = 4231;
			npc.walkAnim = 4236;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 30;
			npc.resizeX = 30;
		
		}
		
		
		if (i == 5690) {
			npc.name = "Pet nuclear smoke devil";
			npc.combatLevel = 0;
			npc.models = new int[] { 32928};
			npc.standAnim = 1829;
			npc.walkAnim = 1828;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 30;
			npc.resizeX = 30;
		
		}
		
		if (i == 5691) {
			npc.name = "Pet marble gargoyle";
			npc.combatLevel = 0;
			npc.models = new int[] { 34251};
			npc.standAnim = 7810;
			npc.walkAnim = 7810;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 30;
			npc.resizeX = 30;
		
		}
		
		if (i == 5692) {
			npc.name = "Pet nechryarch";
			npc.combatLevel = 0;
			npc.models = new int[] { 32932};
			npc.standAnim = 6371;
			npc.walkAnim = 6372;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 30;
			npc.resizeX = 30;
		
		}
		
		if (i == 5694) {
			npc.name = "Pet Patrity";
			npc.combatLevel = 0;
			npc.models = new int[] { 235, 253, 315, 173, 176, 6364, 31899, 275, 181};
			npc.standAnim = 3040;
			npc.walkAnim = 3039;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 80;
			npc.resizeX = 80;
		
		}
	    
		
		if (i == 5695) {
			npc.name = "Pet xarpus";
			npc.combatLevel = 0;
			npc.models = new int[] { 35383};
			npc.standAnim = 8058;
			npc.walkAnim = 8058;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 25;
			npc.resizeX = 25;
		
		}
		if (i == 4813) {
			npc.name = "Pet mammoth";
			npc.combatLevel = 80;
			npc.models = new int[] {3005};
			npc.standAnim = 306;
			npc.walkAnim = 303;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 50;
			npc.resizeX = 50;
		
		}
		
		
		if (i == 5696) {
			npc.name = "Pet nyclocas vasilias";
			npc.combatLevel = 0;
			npc.models = new int[] { 35182};
			npc.standAnim = 7988;
			npc.walkAnim = 7987;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 30;
			npc.resizeX = 30;
		
		}
		
		if (i == 5697) {
			npc.name = "Pet pestilent bloat";
			npc.combatLevel = 0;
			npc.models = new int[] { 35404};
			npc.standAnim = 8080;
			npc.walkAnim = 8081;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 30;
			npc.resizeX = 30;
		
		}
		
		if (i == 5698) {
			npc.name = "Pet maiden of sugadinti";
			npc.combatLevel = 0;
			npc.models = new int[] { 35385};
			npc.standAnim = 8090;
			npc.walkAnim = 8090;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 30;
			npc.resizeX = 30;
		
		}
		
		if (i == 5700) {
			npc.name = "Pet lizardman shaman";
			npc.combatLevel = 0;
			npc.models = new int[] { 4039};
			npc.standAnim = 7191;
			npc.walkAnim = 7195;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5701) {
			npc.name = "Pet abyssal sire";
			npc.combatLevel = 0;
			npc.models = new int[] { 29477};
			npc.standAnim = 4533;
			npc.walkAnim = 4534;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 25;
			npc.resizeX = 25;
		
		}
		
		if (i == 5702) {
			npc.name = "Pet black demon";
			npc.combatLevel = 0;
			npc.originalColors = new int[] { 910, 912 , 1938, 1814, 1690, 0 };
			npc.newColors = new int[] { 898, 4, 8, 12, 16, 5206 };
			npc.models = new int[] {17375, 17391, 17384, 17399, 17390 };
			npc.standAnim = 66;
			npc.walkAnim = 63;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5703) {
			npc.name = "Pet greater demon";
			npc.combatLevel = 0;
			npc.originalColors = new int[] { 1690, 1814 , 1938, 912, 910, 0 };
			npc.newColors = new int[] { 1447, 1571, 1566, 540, 538, 7357 };
			npc.models = new int[] {17375, 17391, 17384, 17399, 17390 };
			npc.standAnim = 66;
			npc.walkAnim = 63;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5704) {
			npc.name = "Pet revenant imp";
			npc.combatLevel = 0;
			npc.models = new int[] {34156};
			npc.standAnim = 171;
			npc.walkAnim = 168;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 110;
			npc.resizeX = 110;
		
		}
		
		if (i == 5705) {
			npc.name = "Pet revenant goblin";
			npc.combatLevel = 0;
			npc.models = new int[] {34262};
			npc.standAnim = 6181;
			npc.walkAnim = 6180;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 85;
			npc.resizeX = 85;
		
		}
		
		if (i == 5706) {
			npc.name = "Pet revenant pyrefiend";
			npc.combatLevel = 0;
			npc.models = new int[] {34142};
			npc.standAnim = 1578;
			npc.walkAnim = 1579;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 55;
			npc.resizeX = 55;
		
		}
		
		if (i == 5707) {
			npc.name = "Pet revenant hobgoblin";
			npc.combatLevel = 0;
			npc.models = new int[] {34157};
			npc.standAnim = 166;
			npc.walkAnim = 162;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 85;
			npc.resizeX = 85;
		
		}
		
		if (i == 5708) {
			npc.name = "Pet revenant cyclops";
			npc.combatLevel = 0;
			npc.models = new int[] {34155};
			npc.standAnim = 4650;
			npc.walkAnim = 4649;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 45;
			npc.resizeX = 45;
		
		}
		
		if (i == 5709) {
			npc.name = "Pet revenant hellhound";
			npc.combatLevel = 0;
			npc.models = new int[] {34143};
			npc.standAnim = 6580;
			npc.walkAnim = 6583;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 55;
			npc.resizeX = 55;
		
		}
		
		if (i == 5710) {
			npc.name = "Pet revenant demon";
			npc.combatLevel = 0;
			npc.models = new int[] {34161, 34162, 34160, 34159, 17390};
			npc.standAnim = 66;
			npc.walkAnim = 63;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 35;
			npc.resizeX = 35;
		
		}
		
		if (i == 5711) {
			npc.name = "Pet revenant ork";
			npc.combatLevel = 0;
			npc.models = new int[] {34154};
			npc.standAnim = 4318;
			npc.walkAnim = 4319;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 65;
			npc.resizeX = 65;
		
		}
		
		if (i == 5712) {
			npc.name = "Pet revenant dark beast";
			npc.combatLevel = 0;
			npc.models = new int[] {34158};
			npc.standAnim = 2730;
			npc.walkAnim = 2729;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 35;
			npc.resizeX = 35;
		
		}
		
		if (i == 5713) {
			npc.name = "Pet revenant knight";
			npc.combatLevel = 0;
			npc.models = new int[] {34145};
			npc.standAnim = 813;
			npc.walkAnim = 1205;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 80;
			npc.resizeX = 80;
		
		}
		
		if (i == 5714) {
			npc.name = "Pet revenant dragon";
			npc.combatLevel = 0;
			npc.models = new int[] {34163};
			npc.standAnim = 90;
			npc.walkAnim = 79;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5715) {
			npc.name = "Pet glod";
			npc.combatLevel = 0;
			npc.models = new int[] {26074};
			npc.standAnim = 6504;
			npc.walkAnim = 6505;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 25;
			npc.resizeX = 25;
		
		}
		
		if (i == 5716) {
			npc.name = "Pet ice queen";
			npc.combatLevel = 0;
			npc.models = new int[] {379, 368, 468, 440, 353, 339};
			npc.originalColors = new int[] { 41, 61, 4550, 12224, 25238, 6798 };
			npc.newColors = new int[] { -22052, -26150, -24343, -22052, -22052, -23327 };
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 80;
			npc.resizeX = 80;
		
		}
		
		if (i == 5717) {
			npc.name = "Pet enraged tarn";
			npc.combatLevel = 0;
			npc.models = new int[] { 60322 };
			npc.standAnim = 5616;
			npc.walkAnim = 5615;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		
		if (i == 5718) {
			npc.name = "Pet jalTok-jad";
			npc.combatLevel = 0;
			npc.models = new int[] { 33012 };
			npc.standAnim = 7589;
			npc.walkAnim = 7588;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 20;
			npc.resizeX = 20;
		
		}
		
		if (i == 5719) {
			npc.name = "Pet rune dragon";
			npc.combatLevel = 0;
			npc.models = new int[] {34668, 24587, 24582, 17423};
			npc.originalColors = new int[] { -27471, -27479, -27446, -27364, -27359, -22256 };
			npc.newColors = new int[] { -26441, -26445, -28464, -25303, -27479, -25442 };
			npc.standAnim = 90;
			npc.walkAnim = 79;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 40;
			npc.resizeX = 40;
		
		}
		if (i == 5458) {
			npc.name = "Pet wyrm";
			npc.combatLevel = 0;
			npc.models = new int[] {36166};
			npc.standAnim = 8266;
			npc.walkAnim = 8266;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", "Transform", null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 35;
			npc.resizeX = 35;
		
		}
		if (i == 5459) {
			npc.name = "Pet drake";
			npc.combatLevel = 0;
			npc.models = new int[] {36160};
			npc.standAnim = 8274;
			npc.walkAnim = 8273;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 35;
			npc.resizeX = 35;
		
		}
		if (i == 5460) {
			npc.name = "Pet wyrm";
			npc.combatLevel = 0;
			npc.models = new int[] {36167};
			npc.standAnim = 8267;
			npc.walkAnim = 8267;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", "Transform", null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 35;
			npc.resizeX = 35;
		
		}
		if (i == 5461) {
			npc.name = "Heart";
			npc.combatLevel = 0;
			npc.models = new int[] {62772};
			npc.standAnim = 3117;
			npc.walkAnim = 3117;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.getDegreesToTurn = 64;
		
		}
		if (i == 5462) {
			npc.name = "Enraged general graardor";
			npc.combatLevel = 0;
			npc.models = new int[] {62780, 62781};
			npc.standAnim = 7017;
			npc.walkAnim = 7016;
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 150;
			npc.resizeX = 150;
		
		}
		if (i == 4999) {
			npc.name = "Anti-santa imp";
			npc.combatLevel = 0;
			npc.models = new int[] { 45294 };
			npc.standAnim = 171;
			npc.walkAnim = 168;
			npc.onMinimap = true;
			npc.getDegreesToTurn = 64;
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
		}
		if (i == 4998) {
			npc.name = "Anti-santa imp";
			npc.combatLevel = 0;
			npc.models = new int[] { 45294 };
			npc.standAnim = 171;
			npc.walkAnim = 168;
			npc.onMinimap = false;
			npc.getDegreesToTurn = 64;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
		}
		if (i == 4996) {
			npc.name = "Santa claus";
			npc.combatLevel = 0;
			npc.models = new int[] { 28976, 28983, 28981, 28979, 28989, 28978 };
			npc.dialogueModels = new int [] {29016};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.onMinimap = true;
			npc.actions = new String[5];
			npc.actions = new String[] { "Talk-to", null, null, null, null };
			npc.getDegreesToTurn = 64;
			npc.resizeY = 180;
			npc.resizeX = 180;
			npc.originalColors = new int []  { 127 };
			npc.newColors = new int [] { 115 };
		}
		if (i == 5571) {
			npc.name = "Zombie Follower";
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.resizeY = 75;
			npc.resizeX = 75;
		}
		if (i == 5570) {
			npc.name = "Zombie Follower";
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.resizeY = 75;
			npc.resizeX = 75;
		}
		if (i == 5569) {
			npc.name = "Zombie Follower";
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.resizeY = 75;
			npc.resizeX = 75;
		}
		if (i == 5568) {
			npc.name = "Zombie Follower";
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.resizeY = 75;
			npc.resizeX = 75;
		}
		if (i == 3291) {
			npc.name = "Petie";
			npc.onMinimap = false;
			npc.actions = new String[5];
			npc.actions = new String[] { "Pick-up", null, null, null, null };
			npc.resizeY = 90;
			npc.resizeX = 90;
		}
		
		if (i == 5248) {
			npc.models = new int[1];
			npc.models[0] = 800000;
			npc.name = "Nex";
			npc.size = 3;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.combatLevel = 1001;
			npc.description = "The God of Zaros.";
			npc.standAnim = 6320;
			npc.walkAnim = 6319;
		}
		
		if (i == 4800) {
		npc.name = "Tyrannosaurus rex";
		npc.description = "A tyrannical monster brought through time and space to the realm of Eldrax.";
		npc.actions = new String[5];
		npc.actions[1] = "Attack";
		npc.combatLevel = 412;
		npc.size = 2;
		npc.resizeX = 200;
		npc.resizeY = 200;
		npc.headIcon = 0;
		npc.models = new int[1];
		npc.models[0] = 800002;
        npc.standAnim = 2850;
        npc.walkAnim = 2849;
	}
		

if (i == 4801) {
npc.models = new int[]{214, 250, 176, 181, 44594, 60320, 60318, 43614, 10702, 16487};
npc.name = "Dagon'hai mage";
npc.description = "A lost mage of the Dagon'hai clan.";
npc.description = null;
npc.size = 1;
npc.standAnim = 813;
npc.walkAnim = 1205;
npc.actions = new String[5];
npc.actions[1] = "Attack";
npc.newColors = new int[]{5921, 39215, 39211, 39331, 39207, 39207};
npc.originalColors = new int[] {6798, 8741, 40918, 119, 40384, 8078};
npc.combatLevel = 101;
}

if (i == 4802) {
npc.models = new int[]{213, 306, 164, 176, 268, 184, 511};
npc.name = "Fire warrior";
npc.description = "It's a Fire warrior";
npc.size = 1;
npc.standAnim = 842;
npc.walkAnim = 841;
npc.actions = new String[5];
npc.actions[1] = "Attack";
npc.newColors = new int[] {965, 965, 965, 965, 965, 965};
npc.originalColors = new int[] {61, 41, 4550, 57, 12, 24};
npc.combatLevel = 80;
}

if (i == 4803) {
npc.models = new int[]{
		/*head*/214,
		/*beard*/250,
		/*platebody*/34630,
		/*kiteshield*/34649,
		/*weapon*/6031,
		/*boots*/27638,
		/*platelegs*/5024};
		 
npc.name = "Dragon devotee";
npc.description = "Someone reaaaally likes dragons.....";
npc.size = 1;
npc.standAnim = 808;
npc.walkAnim = 819;
npc.actions = new String[5];
npc.actions[1] = "Attack";
npc.newColors = new int[]{7863, 41, 7863};
npc.originalColors = new int[]{24, 7054, 123};
npc.combatLevel = 112;
npc.resizeX = 130;
npc.resizeY = 130;
}


if (i == 4804) {
npc.models = new int[]{28300, 28301, 28302, 17423};
npc.originalColors = new int[] { 40 };
npc.newColors = new int[] { 59 };
npc.name = "Infernal dragon";
npc.description = "It's dripping with infernal lava";
npc.size = 4;
npc.standAnim = 90;
npc.walkAnim = 79;
npc.actions = new String[5];
npc.actions[1] = "Attack";
npc.onMinimap = true;
npc.combatLevel = 313;
npc.resizeX = 120;
npc.resizeY = 120;
}

if (i == 4805) {
npc.models = new int[]{6232};
npc.name = "Possessed ancient staff";
npc.description = "It's a possessed staff";
npc.size = 1;
npc.standAnim = 813;
npc.walkAnim = 1205;
npc.actions = new String[5];
npc.actions[1] = "Attack";
npc.combatLevel = 71;
npc.resizeX = 100;
npc.resizeY = 100;

}

		

    if (i == 4012) {
        npc.name = "Dharok The Wretched";
        npc.actions = new String[5];
        npc.actions[0] = "Pick-up";
        npc.models = new int[6];
        npc.models[0] = 6652;
        npc.models[1] = 6671;
        npc.models[2] = 6640;
        npc.models[3] = 6661;
        npc.models[4] = 6703;
        npc.models[5] = 6679;
        npc.standAnim = 2065;
        npc.walkAnim = 2064;
        npc.resizeX = 100;
        npc.resizeY = 100;
    }
    
     if (i == 4013) {
        npc.name = "Guthan The Infested";
        npc.actions = new String[5];
        npc.actions[0] = "Pick-up";
        npc.models = new int[6];
        npc.models[0] = 6654;
        npc.models[1] = 6673;
        npc.models[2] = 6642;
        npc.models[3] = 6666;
        npc.models[4] = 6679;
        npc.models[5] = 6710;
        npc.standAnim = 813;
        npc.walkAnim = 1205;
        npc.resizeY = 100;
        npc.resizeX = 100;
     }
     
      if (i == 4014) { 
        npc.name = "Karil the Tainted";
        npc.actions = new String[5];
        npc.actions[0] = "Pick-up";
        npc.models = new int[1];
        npc.models[0] = 6675;
        npc.standAnim = 2074;
        npc.walkAnim = 2076;
        npc.resizeY = 100;
        npc.resizeX = 100;
     }
      if (i == 4015) { 
        npc.name = "Torag the Corrupted";
        npc.actions = new String[5];
        npc.actions[0] = "Pick-up";
        npc.models = new int[6];
        npc.models[0] = 6657;
        npc.models[1] = 6677;
        npc.models[2] = 6645;
        npc.models[3] = 6663;
        npc.models[4] = 6708;
        npc.models[5] = 6679;
        npc.standAnim = 808;
        npc.walkAnim = 819;
        npc.resizeY = 100;
        npc.resizeX = 100;
      }
      if (i == 4016) {
        npc.name = "Verac the Defiled";
        npc.actions = new String[5];
        npc.actions[0] = "Pick-up";
        npc.models = new int[2];
        npc.models[0] = 6678;
        npc.models[1] = 6705;
        npc.standAnim = 2061;
        npc.walkAnim = 2060;
        npc.resizeY = 100;
        npc.resizeX = 100;
      }
      
      if (i == 4806) {
    	  npc.models = new int[]{
    	  		/*head*/800009,
    	  		/*weapon*/5409,
    	  		/*platebody*/800004,
    	  		/*kiteshield*/50002, 
    	  		/*Boots*/53115,
    	  		/*Gloves*/53113,
    	  		/*cape*/95093,
    	  		/*platelegs*/800006};
    	  		 
    	  npc.name = "Upgradium";
    	  npc.description = "Upgrade your items here";
    	  npc.size = 1;
    	  npc.standAnim = 808;
    	  npc.walkAnim = 819;
    	  npc.actions = new String[5];
    	  npc.actions[0] = "Upgrade-Items";
    	  npc.originalColors = new int[]{528};
    	  npc.newColors = new int[]{17350};
    	  npc.resizeX = 128;
    	  npc.resizeY = 128;
    	  }
      
      if (i == 4808) {
    	  npc.models = new int[]{800011};
      	  npc.name = "Chucky";
    	  npc.description = "A possessed doll";
    	  npc.size = 1;
    	  npc.standAnim = 808;
    	  npc.walkAnim = 819;
    	  npc.actions = new String[5];
    	  npc.actions[1] = "Attack";
    	  npc.resizeX = 128;
    	  npc.resizeY = 128;
    	  }
      

if (i == 4809) {
npc.models = new int[] {800013};
npc.name = "Flying Behemoth";
npc.description = null;
npc.size = 5;
npc.standAnim = 5021;
npc.walkAnim = 5022;
npc.actions = new String[5];
npc.actions[1] = "Attack";
npc.combatLevel = 143;
}

if (i == 4810) {
npc.models = new int[] {800022};
npc.name = "Charizard";
npc.description = null;
npc.size = 3;
npc.standAnim = 808;
npc.walkAnim = 819;
npc.actions = new String[5];
npc.actions[1] = "Attack";
npc.combatLevel = 900;
}

if (i == 4811) {
	  npc.models = new int[]{800011};
	  npc.name = "Pet chucky";
	  npc.description = "A possessed doll";
	  npc.size = 1;
	  npc.standAnim = 808;
	  npc.walkAnim = 819;
	  npc.actions = new String[] { "Pick-up", null, null, null, null };
	  npc.resizeX = 128;
	  npc.resizeY = 128;
	  }

if (i == 4812) {
npc.name = "Pet rexxy";
npc.description = "A tyrannical monster brought through time and space to the realm of Eldrax.";
npc.actions = new String[] { "Pick-up", null, null, null, null };
npc.combatLevel = 412;
npc.size = 1;
npc.resizeX = 70;
npc.resizeY = 70;
npc.models = new int[1];
npc.models[0] = 800002;
npc.standAnim = 2850;
npc.walkAnim = 2849;
}
if (i == 4817)
{
  npc.name = "Tormented Demon";
  npc.models = new int[] { 800029 };
  npc.actions = new String[] { null, "Attack", null, null, null };
  npc.combatLevel = 126;
  npc.standAnim = 2850;
  npc.walkAnim = 2849;
}

      if (i == 5862) {
    	  npc.models = new int[]{800012};
    	  }
      
      if(i==7144){
		npc.copyNpc(2745, "Rustic Jad", 1337);
		npc.colourRedefine2 = 266770;
	}

	
		
		if(i==7144){
	npc.headIcon = 0;
		}
		if(i==963){
			npc.headIcon = 6;
		}
		if(i==7145){
	npc.headIcon = 1;
		}
		if(i==7146){
	npc.headIcon = 2;
		}
		return npc;
	}

	public static int totalAmount;

	public static void unpackConfig(Archive streamLoader) {
		stream = new Buffer(streamLoader.getDataForName("npc.dat"));
		Buffer stream = new Buffer(streamLoader.getDataForName("npc.idx"));
		totalAmount = stream.readShort();
		streamIndices = new int[totalAmount];
		int i = 2;
		for (int j = 0; j < totalAmount; j++) {
			streamIndices[j] = i;
			i += stream.readShort();
		}

		cache = new NpcDefinition[20];
		for (int k = 0; k < 20; k++)
			cache[k] = new NpcDefinition();
		for (int index = 0; index < totalAmount; index++) {
			NpcDefinition ed = forID(index);
			if (ed == null)
				continue;
			if (ed.name == null)
				continue;
		}
	}

	private void readValues(Buffer stream) {
		while (true) {
			int opcode = stream.readUnsignedByte();
			if (opcode == 0)
				return;
			if (opcode == 1) {
				int j = stream.readUnsignedByte();
				models = new int[j];
				for (int j1 = 0; j1 < j; j1++)
					models[j1] = stream.readShort();

			} else if (opcode == 2)
				name = stream.readString();
			else if (opcode == 3)
				description = stream.readString();
			else if (opcode == 12)
				size = stream.readSignedByte();
			else if (opcode == 13)
				standAnim = stream.readShort();
			else if (opcode == 14)
				walkAnim = stream.readShort();
			else if (opcode == 17) {
				walkAnim = stream.readShort();
				turn180Anim = stream.readShort();
				turn90CWAnim = stream.readShort();
				turn90ACWAnim = stream.readShort();
				if (turn180Anim == 65535) {
					turn180Anim = -1;
				}
				if (turn90CWAnim == 65535) {
					turn90CWAnim = -1;
				}
				if (turn90ACWAnim == 65535) {
					turn90ACWAnim = -1;
				}
			} else if (opcode >= 30 && opcode < 40) {
				if (actions == null)
					actions = new String[5];
				actions[opcode - 30] = stream.readString();
				if (actions[opcode - 30].equalsIgnoreCase("hidden"))
					actions[opcode - 30] = null;
			} else if (opcode == 40) {
				int k = stream.readUnsignedByte();
				originalColors = new int[k];
				newColors = new int[k];
				for (int k1 = 0; k1 < k; k1++) {
					originalColors[k1] = stream.readShort();
					newColors[k1] = stream.readShort();
				}

			} else if (opcode == 60) {
				int l = stream.readUnsignedByte();
				dialogueModels = new int[l];
				for (int l1 = 0; l1 < l; l1++)
					dialogueModels[l1] = stream.readShort();

			} else if (opcode == 93)
				onMinimap = false;
			else if (opcode == 95)
				combatLevel = stream.readShort();
			else if (opcode == 97)
				resizeX = stream.readShort();
			else if (opcode == 98)
				resizeY = stream.readShort();
			else if (opcode == 99)
				hasRenderPriority = true;
			else if (opcode == 100)
				lightModifier = stream.readSignedByte();
			else if (opcode == 101)
				shadowModifier = stream.readSignedByte();
			else if (opcode == 102)
				headIcon = stream.readSignedByte();
			else if (opcode == 103)
				getDegreesToTurn = stream.readSignedByte();
			else if (opcode == 106) {
				varbitIndex = stream.readShort();
				if (varbitIndex == 65535)
					varbitIndex = -1;
				varpIndex = stream.readShort();
				if (varpIndex == 65535)
					varpIndex = -1;
				int i1 = stream.readUnsignedByte();
				childrenIDs = new int[i1 + 1];
				for (int i2 = 0; i2 <= i1; i2++) {
					childrenIDs[i2] = stream.readShort();
					if (childrenIDs[i2] == 65535)
						childrenIDs[i2] = -1;
				}
			} else if (opcode == 107)
				isClickable = false;
		}
	}
	
	public void copyNpc(final int id, final String newName, final int combatLvl) {
		final NpcDefinition entitydef = forID(id);
		this.models = entitydef.models.clone();
		this.combatLevel = combatLvl;
		this.name = newName;
		this.standAnim = entitydef.standAnim;
		this.walkAnim = entitydef.walkAnim;
		this.actions = entitydef.actions.clone();
	}

	public Model getHeadModel() {
		if (childrenIDs != null) {
			NpcDefinition altered = getAlteredNPCDef();
			if (altered == null)
				return null;
			else
				return altered.getHeadModel();
		}
		if (dialogueModels == null) {
			return null;
		}
		boolean everyFetched = false;
		for (int i = 0; i < dialogueModels.length; i++)
			if (!Model.modelIsFetched(dialogueModels[i]))
				everyFetched = true;

		if (everyFetched)
			return null;
		Model parts[] = new Model[dialogueModels.length];
		for (int j = 0; j < dialogueModels.length; j++)
			parts[j] = Model.fetchModel(dialogueModels[j]);

		Model model;
		if (parts.length == 1)
			model = parts[0];
		else
			model = new Model(parts.length, parts);

		if (originalColors != null) {
			for (int k = 0; k < originalColors.length; k++)
				model.replaceColor(originalColors[k], newColors[k]);
		}
		if (colourRedefine > 0) {
			model.method1337(colourRedefine);
		}
		if (colourRedefine2 != 0) {
			model.method1338(colourRedefine2);
		}
		if (colourRedefine3 != 0) {
			model.method1339(colourRedefine3);
		}
		return model;
	}

	public NpcDefinition getAlteredNPCDef() {
		int j = -1;
		if (varbitIndex != -1 && varbitIndex <= 2113) {
			VarBit varBit = VarBit.cache[varbitIndex];
			int k = varBit.setting;
			int l = varBit.low;
			int i1 = varBit.high;
			int j1 = Client.BIT_MASK[i1 - l];
			j = clientInstance.variousSettings[k] >> l & j1;
		} else if (varpIndex != -1)
			j = clientInstance.variousSettings[varpIndex];
		if (j < 0 || j >= childrenIDs.length || childrenIDs[j] == -1)
			return null;
		else
			return forID(childrenIDs[j]);
	}

	public Model method164(int frameId2, int frameId, int framesFrom2[]) 
	{
		if (childrenIDs != null) 
		{
			NpcDefinition entityDef = getAlteredNPCDef();
			if (entityDef == null)
				return null;
			else
				return entityDef.method164(frameId2, frameId, framesFrom2);
		}
		Model completedModel = (Model) mruNodes.insertFromCache(interfaceType);
		if (completedModel == null) {
			boolean flag = false;
			for (int ptr = 0; ptr < models.length; ptr++)
				if (!Model.modelIsFetched(models[ptr]))
					flag = true;

			if (flag)
				return null;
			Model parts[] = new Model[models.length];
			for (int j1 = 0; j1 < models.length; j1++)
				parts[j1] = Model.fetchModel(models[j1]);

			if (parts.length == 1)
				completedModel = parts[0];
			else
				completedModel = new Model(parts.length, parts);
			if (originalColors != null) {
				for (int k1 = 0; k1 < originalColors.length; k1++)
					completedModel.replaceColor(originalColors[k1], newColors[k1]);
			}
				if (colourRedefine > 0) {
					completedModel.method1337(colourRedefine);
				}
				if (colourRedefine2 != 0) {
					completedModel.method1338(colourRedefine2);
				}
				if (colourRedefine3 != 0) {
					completedModel.method1339(colourRedefine3);
			}
			completedModel.createBones();
			completedModel.light(64 + lightModifier, 850 + shadowModifier, -30, -50, -30, true);
			mruNodes.removeFromCache(completedModel, interfaceType);
		}
		Model model_1 = Model.EMPTY_MODEL;
		model_1.method464(completedModel, Frame.method532(frameId) & Frame.method532(frameId2));
		if (frameId != -1 && frameId2 != -1)
			model_1.mixAnimationFrames(framesFrom2, frameId2, frameId);
		else if (frameId != -1)
			model_1.applyTransform(frameId);
		if (resizeX != 128 || resizeY != 128)
			model_1.scale(resizeX, resizeX, resizeY);
		model_1.calculateDiagonals();
		model_1.faceGroups = null;
		model_1.vertexGroups = null;
		if (size == 1)
			model_1.fits_on_single_square = true;
		return model_1;
	}

	private NpcDefinition() {
		turn90ACWAnim = -1;
		varbitIndex = walkAnim;
		turn180Anim = walkAnim;
		varpIndex = walkAnim;
		combatLevel = -1;
		anInt64 = 1834;
		walkAnim = -1;
		size = 1;
		headIcon = -1;
		standAnim = -1;
		interfaceType = -1L;
		getDegreesToTurn = 32;
		turn90CWAnim = -1;
		isClickable = true;
		resizeY = 128;
		onMinimap = true;
		resizeX = 128;
		hasRenderPriority = false;
	}

	public static void nullLoader() {
		mruNodes = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}
	
	public static void dumpDefs() {
		File f = new File("npc.txt");
		System.out.println("Dumping Npc..");
		String[] variableNames = new String[] { "models", "name", "description", "squaresNeeded", "standAnim",
				"walkAnim", "runAnim", "turn180AnimIndex", "turn90CWAnimIndex", "turn90CCWAnimIndex", "actions",
				"destColours", "originalColours", "npcHeadModels", "drawMinimapDot", "combatLevel", "sizeXZ", "sizeY",
				"hasRenderPriority", "lightning", "shadow", "headIcon", "degreesToTurn", "varbitId", "varSettingsId",
				"childrenIDs", "clickable" };
		try {
			f.createNewFile();
			BufferedWriter bf = new BufferedWriter(new FileWriter(f));
			for (int index = 0; index < 8000; index++) {
				NpcDefinition def = forID(index);
				String models = Arrays.toString(def.models);
				String name = def.name;
				String description = def.description + "";
				String squaresNeeded = def.size + "";
				String standAnim = def.standAnim + "";
				String walkAnim = def.walkAnim + "";
				String runAnim = def.walkAnim + "";
				String turn180AnimIndex = def.turn180Anim + "";
				String turn90CWAnimIndex = def.turn90CWAnim + "";
				String turn90CCWAnimIndex = def.turn90ACWAnim + "";
				String actions = Arrays.toString(def.actions);
				String destColours = Arrays.toString(def.newColors);
				String originalColours = Arrays.toString(def.originalColors);
				String drawMinimapDot = def.onMinimap + "";
				String combatLevel = def.combatLevel + "";
				String sizeXZ = def.resizeX + "";
				String sizeY = def.resizeY + "";
				String hasRenderPriority = def.hasRenderPriority + "";
				String lightning = def.shadowModifier + "";
				String shadow = def.lightModifier + "";
				String headIcon = def.headIcon + "";
				String degreesToTurn = def.getDegreesToTurn + "";
				String varbitId = def.varbitIndex + "";
				String varSettingsId = def.varpIndex + "";
				String clickable = def.isClickable + "";

				String[] variables = new String[] { models, name, description, squaresNeeded, standAnim, walkAnim,
						runAnim, turn180AnimIndex, turn90CWAnimIndex, turn90CCWAnimIndex, actions, destColours,
						originalColours, drawMinimapDot, combatLevel, sizeXZ, sizeY, hasRenderPriority,
						lightning, shadow, headIcon, degreesToTurn, varbitId, varSettingsId, clickable };
				bf.write("if (i == " + index + ") {");
				bf.newLine();
				for (int i = 0; i < variables.length; i++) {
					bf.write("entityDef." + variableNames[i] + " = " + variables[i] + ";");
					bf.newLine();
				}
				bf.write("}");
				bf.newLine();
				bf.newLine();
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Dumping Complete!");
	}

	public static void dumpList() {
		try {
			File file = new File(System.getProperty("user.home") + "/Desktop/npcList " + Configuration.dumpID + ".txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalAmount; i++) {
					NpcDefinition definition = forID(i);
					if (definition != null) {
						writer.write("npc = " + i + "\t" + definition.name + "\t" + definition.combatLevel + "\t"
								+ definition.standAnim + "\t" + definition.walkAnim + "\t");
						writer.newLine();
					}
				}
			}

			System.out.println("Finished dumping npc definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dumpSizes() {
		try {
			File file = new File(System.getProperty("user.home") + "/Desktop/npcSizes 143.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalAmount; i++) {
					NpcDefinition definition = forID(i);
					if (definition != null) {
						writer.write(i + "	" + definition.size);
						writer.newLine();
					}
				}
			}

			System.out.println("Finished dumping npc definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int turn90ACWAnim;
	public static int anInt56;
	public int varbitIndex;
	public int turn180Anim;
	public int varpIndex;
	public static Buffer stream;
	public int combatLevel;
	public final int anInt64;
	public String name;
	public String actions[];
	public int walkAnim;
	public byte size;
	public int[] newColors;
	public static int[] streamIndices;
	public int[] dialogueModels;
	public int headIcon;
	public int[] originalColors;
	public int colourRedefine = 0;
	public int colourRedefine2 = 0;
	public int colourRedefine3 = 0;
	public int standAnim;
	public long interfaceType;
	public int getDegreesToTurn;
	public static NpcDefinition[] cache;
	public static Client clientInstance;
	public int turn90CWAnim;
	public boolean isClickable;
	public int lightModifier;
	public int resizeY;
	public boolean onMinimap;
	public int childrenIDs[];
	public String description;
	public int resizeX;
	public int shadowModifier;
	public boolean hasRenderPriority;
	public int[] models;
	public static Cache mruNodes = new Cache(30);
	public FloatingText floatingText;
	public FloatingSprite floatingSprite;
}