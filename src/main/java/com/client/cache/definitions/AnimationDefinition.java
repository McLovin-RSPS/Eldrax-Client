package com.client.cache.definitions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.client.cache.Archive;
import com.client.cache.animation.Frame;
import com.client.io.Buffer;
import com.client.sign.Signlink;
import com.client.utilities.FileOperations;


public final class AnimationDefinition {
	
	private static Buffer stream667;
	public DataType dataType;
	
	public static void unpackConfig(Archive streamLoader) {
		Buffer stream = new Buffer(streamLoader.getDataForName("seq.dat"));
		stream667 = new Buffer(streamLoader.getDataForName("seq2.dat"));
		//stream667 = new Buffer(FileOperations.ReadFile(Signlink.findcachedirORIG() + "/data/seq2.dat"));

		int length = stream.readUnsignedWord();
		//int length667 = stream667.readUnsignedWord();

		if (anims == null)
			anims = new AnimationDefinition[length + 6000];
	
		for (int j = 0; j < anims.length; j++) {
			if (j >= length && j <= length + 6000) {
				continue;
			}
			
			if (anims[j] == null)
				anims[j] = new AnimationDefinition();
			if (j > length + 6000) {
				anims[j].dataType = DataType.PRE_EOC_667;
				anims[j].readValues667(j, stream667);

			} else {
				anims[j].readValues(stream);
			}
			  
			if (j == 719) {
				anims[j].playerMainhand = 28232;
				anims[j].priority = 6;
				anims[j].playerOffhand = 0;
				anims[j].replayMode = 1;
				anims[j].loopOffset = -1;
				anims[j].stretches = false;
				anims[j].priority = 5;
				anims[j].maximumLoops = 99;
				anims[j].animatingPrecedence = -1;
				anims[j].walkingPrecedence = -1;
			}
			switch (j) {

			case 7156:
				anims[j] = new AnimationDefinition();
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 4,
						4, 4, 4, 3, 3, 3, };
				anims[j].primaryFrames = new int[] { 158990394, 158990411, 158990398, 158990429, 158990418, 158990393,
						158990407, 158990402, 158990397, 158990428, 158990409, 158990401, 158990425, 158990406,
						158990417, 158990403, 158990420, 158990395, 158990399, 158990435, 158990414, 158990405,
						158990432, 158990410, 158990415, 158990426, 158990430, 158990394, };
				anims[j].frameCount = 28;
				anims[j].stretches = false;
				anims[j].priority = 10;
				anims[j].maximumLoops = 99;
				anims[j].replayMode = 2;
				break;

			case 7155:
				anims[j] = new AnimationDefinition();
				anims[j].durations = new int[] { 18, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1,
						1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 6, 4, 1, 1, 1, 1, 1, 1, 1, 1, };
				anims[j].primaryFrames = new int[] { 168558682, 168558693, 168558686, 168558670, 168558665, 168558702,
						168558703, 168558669, 168558690, 168558705, 168558692, 168558694, 168558671, 168558679,
						168558672, 168558667, 168558675, 168558683, 168558706, 168558681, 168558704, 168558673,
						168558698, 168558680, 168558695, 168558677, 168558700, 168558701, 168558699, 168558668,
						168558689, 168558684, 168558678, 168558696, 168558688, 168558666, 168558687, 168558674,
						168558691, 168558676, 168558685, 168558697, };
				anims[j].frameCount = 42;
				anims[j].stretches = false;
				anims[j].priority = 5;
				anims[j].maximumLoops = 99;
				anims[j].replayMode = 2;
				break;

			case 7154:
				// fileID = 1845
				anims[j].durations = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
						5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
						5, 5, 5, 5, 5, 5, 5, 5, 5, 5, };
				anims[j].primaryFrames = new int[] { 120913948, 120913967, 120913935, 120913942, 120913982, 120913929,
						120913947, 120913937, 120913951, 120913932, 120913966, 120913931, 120913960, 120913924,
						120913973, 120913976, 120913972, 120913936, 120913920, 120913981, 120913921, 120913945,
						120913964, 120913968, 120913943, 120913944, 120913954, 120913970, 120913939, 120913949,
						120913963, 120913974, 120913983, 120913938, 120913926, 120913956, 120913940, 120913923,
						120913958, 120913965, 120913946, 120913971, 120913953, 120913969, 120913977, 120913980,
						120913930, 120913975, 120913978, 120913928, 120913961, 120913952, 120913955, 120913950,
						120913925, 120913959, 120913957, 120913962, 120913922, 120913934, 120913927, 120913979,
						120913941, 120913933, };
				anims[j].frameCount = 64;
				anims[j].stretches = false;
				anims[j].priority = 5;
				anims[j].maximumLoops = 99;
				anims[j].replayMode = 2;
				anims[j].loopOffset = 64;
				break;

			case 1134:
				// fileID = 464
				anims[j].frameCount = 3;
				anims[j].primaryFrames = new int[] { 30408704, 30408708, 30408707, };
				anims[j].durations = new int[] { 14, 14, 12, };
				break;

			case 1674:
				// fileID = 472
				anims[j].frameCount = 4;
				anims[j].primaryFrames = new int[] { 30932992, 30932995, 30932994, 30932993, };
				anims[j].durations = new int[] { 9, 9, 9, 9, };
				break;

			case 1675:
				// fileID = 470
				anims[j].frameCount = 4;
				anims[j].primaryFrames = new int[] { 30801923, 30801922, 30801920, 30801921, };
				anims[j].durations = new int[] { 10, 9, 11, 10, };
				break;

			case 1676:
				// fileID = 474
				anims[j].frameCount = 13;
				anims[j].primaryFrames = new int[] { 31064066, 31064073, 31064070, 31064075, 31064071, 31064068,
						31064074, 31064065, 31064072, 31064064, 31064069, 31064067, 31064076, };
				anims[j].durations = new int[] { 9, 8, 5, 7, 7, 12, 4, 17, 12, 9, 10, 16, 11, };
				anims[j].loopOffset = 1;
				anims[j].priority = 10;
				break;

			case 1677:
				// fileID = 466
				anims[j].frameCount = 8;
				anims[j].primaryFrames = new int[] { 30539776, 30539782, 30539783, 30539779, 30539778, 30539781,
						30539780, 30539777, };
				anims[j].durations = new int[] { 8, 7, 7, 7, 7, 7, 7, 10, };
				break;

			case 1678:
				// fileID = 471
				anims[j].frameCount = 8;
				anims[j].primaryFrames = new int[] { 30867457, 30867459, 30867458, 30867456, 30867463, 30867460,
						30867461, 30867462, };
				anims[j].durations = new int[] { 11, 16, 12, 14, 18, 17, 17, 15, };
				break;

			case 1679:
				// fileID = 465
				anims[j].frameCount = 7;
				anims[j].primaryFrames = new int[] { 30474245, 30474240, 30474246, 30474243, 30474241, 30474242,
						30474244, };
				anims[j].durations = new int[] { 7, 8, 17, 8, 6, 6, 8, };
				anims[j].priority = 6;
				break;

			case 1682:
				// fileID = 462
				anims[j].frameCount = 5;
				anims[j].primaryFrames = new int[] { 30277634, 30277635, 30277633, 30277636, 30277632, };
				anims[j].durations = new int[] { 8, 8, 11, 8, 8, };
				anims[j].priority = 6;
				break;

			case 1683:
				// fileID = 467
				anims[j].frameCount = 6;
				anims[j].primaryFrames = new int[] { 30605316, 30605313, 30605317, 30605315, 30605314, 30605312, };
				anims[j].durations = new int[] { 8, 4, 6, 7, 9, 6, };
				anims[j].priority = 6;
				break;

			case 1684:
				// fileID = 463
				anims[j].frameCount = 9;
				anims[j].primaryFrames = new int[] { 30343170, 30343168, 30343171, 30343175, 30343173, 30343176,
						30343177, 30343174, 30343172, };
				anims[j].durations = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, };
				break;

			case 1685:
				// fileID = 469
				anims[j].frameCount = 4;
				anims[j].primaryFrames = new int[] { 30736384, 30736385, 30736386, 30736387, };
				anims[j].durations = new int[] { 5, 5, 5, 5, };
				break;

			case 1687:
				// fileID = 461
				anims[j].frameCount = 5;
				anims[j].primaryFrames = new int[] { 30212100, 30212097, 30212099, 30212098, 30212096, };
				anims[j].durations = new int[] { 5, 8, 9, 9, 9, };
				break;

			case 1688:
				// fileID = 475
				anims[j].frameCount = 8;
				anims[j].primaryFrames = new int[] { 31129606, 31129605, 31129601, 31129607, 31129604, 31129602,
						31129603, 31129600, };
				anims[j].durations = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, };
				break;

			case 1689:
				// fileID = 476
				anims[j].frameCount = 14;
				anims[j].primaryFrames = new int[] { 31195148, 31195150, 31195144, 31195139, 31195136, 31195143,
						31195145, 31195147, 31195137, 31195142, 31195151, 31195140, 31195146, 31195138, };
				anims[j].durations = new int[] { 5, 5, 5, 5, 4, 4, 4, 3, 8, 8, 8, 8, 12, 12, };
				break;

			case 5061:
				anims[j].frameCount = 13;
				anims[j].primaryFrames = new int[] { 19267601, 19267602, 19267603, 19267604, 19267605, 19267606,
						19267607, 19267606, 19267605, 19267604, 19267603, 19267602, 19267601, };
				anims[j].durations = new int[] { 4, 3, 3, 4, 10, 10, 15, 10, 10, 4, 3, 3, 4, };
				// anims[j].anIntArray357 = new int[] { 1, 2, 9, 11, 13, 15, 17,
				// 19, 37, 39, 41, 43, 45, 164, 166, 168, 170, 172, 174, 176,
				// 178, 180, 182, 183, 185, 191, 192, 9999999, };
				anims[j].priority = 6;
				anims[j].playerOffhand = 0;
				anims[j].playerMainhand = 13438;
				anims[j].replayMode = 1;
				anims[j].loopOffset = -1;
				anims[j].stretches = false;
				anims[j].priority = 5;
				anims[j].maximumLoops = 99;
				anims[j].animatingPrecedence = -1;
				anims[j].walkingPrecedence = -1;
				break;

			case 5460:
				anims[j].frameCount = 19;
				anims[j].primaryFrames = new int[] { 93650945, 93650955, 93650956, 93650957, 93650958, 93650959,
						93650960, 93650961, 93650962, 93650944, 93650946, 93650947, 93650948, 93650949, 93650950,
						93650951, 93650952, 93650953, 93650954, };
				anims[j].durations = new int[] { 15, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, };
				break;

			case 5461:
				anims[j].frameCount = 8;
				anims[j].primaryFrames = new int[] { 93716480, 93716481, 93716482, 93716483, 93716484, 93716485,
						93716486, 93716487, };
				anims[j].durations = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, };
				break;

			case 5462:
				anims[j].frameCount = 8;
				anims[j].primaryFrames = new int[] { 93782016, 93782017, 93782018, 93782019, 93782020, 93782021,
						93782022, 93782023, };
				anims[j].durations = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, };
				break;

			case 2406:
				anims[j].primaryFrames = new int[] { 12058690, 12058638, 12058631, 12058683, 12058655, 12058660,
						12058710, 12058634, 12058680, 12058706, };
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, };
				anims[j].frameCount = 10;
				break;

			case 2407:
				anims[j].primaryFrames = new int[] { 12058713, 12058717, 12058647, 12058643, 12058651, 12058687,
						12058700, 12058716, 12058699, 12058667, };
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, };
				anims[j].frameCount = 10;
				break;

			case 1741:// Block
				anims[j].primaryFrames = new int[] { 12058703, 12058695, 12058666, 12058719, 12058665, 12058632,
						12058669, 12058718, 12058689, 12058721, };
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, };
				anims[j].frameCount = 10;
				break;

			case 2413:// Spawn
				anims[j].primaryFrames = new int[] { 12058654, 12058649, 12058673, 12058633, 12058626, 12058664,
						12058653, 12058694, 12058705, 12058624, 12058691, 12058696, 12058662, };
				anims[j].durations = new int[] { 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, };
				anims[j].frameCount = 13;
				break;

			case 2408:// death
				anims[j].primaryFrames = new int[] { 12058672, 12058709, 12058639, 12058688, 12058641, 12058677,
						12058671, 12058659, 12058657, 12058668, 12058676, 12058663, 12058645, 12058650, 12058625,
						12058644, 12058720, 12058707, };
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 9, 3, 3, 3, 3, 3, };
				anims[j].frameCount = 18;
				break;

			case 2405:
				anims[j].primaryFrames = new int[] { 12058670, 12058674, 12058636, 12058701, 12058678, 12058704,
						12058640, 12058629, 12058681, 12058697, };
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, };
				anims[j].frameCount = 10;
				break;

			case 1721:
				anims[j].primaryFrames = new int[] { 12058711, 12058684, 12058635, 12058658, 12058715, 12058628,
						12058630, 12058675, };
				anims[j].durations = new int[] { 3, 4, 3, 4, 4, 4, 4, 4, };
				anims[j].frameCount = 8;
				break;

			case 5358:
				anims[j].frameCount = 8;
				anims[j].primaryFrames = new int[] { 4390912, 4390913, 4390914, 4390915, 4390916, 4390915, 4390914,
						4390913, };
				anims[j].durations = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, };
				anims[j].loopOffset = 8;
				break;

			case 6648:
				anims[j].frameCount = 6;
				anims[j].primaryFrames = new int[] { 110755840, 110755841, 110755842, 110755843, 110755844,
						110755845, };
				anims[j].durations = new int[] { 2, 2, 2, 2, 2, 2, };
				break;

			case 5068:
				// fileID = 182
				anims[j].primaryFrames = new int[] { 11927613, 11927599, 11927574, 11927659, 11927676, 11927562,
						11927626, 11927628, 11927684, 11927647, 11927602, 11927576, 11927586, 11927653, 11927616,
						11927653, 11927586, 11927576, 11927602, 11927576, 11927586, 11927653, 11927616, 11927653,
						11927586, 11927576, 11927602, 11927576, 11927586, 11927653, 11927616, 11927653, 11927586,
						11927576, 11927554, 11927602, };
				anims[j].durations = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
						5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, };
				anims[j].frameCount = 36;
				break;

			case 5069:
				// fileID = 182
				anims[j].primaryFrames = new int[] { 11927613, 11927599, 11927574, 11927659, 11927676, 11927562,
						11927626, 11927628, 11927684, 11927647, 11927602, 11927576, 11927586, 11927653, 11927616, };
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, };
				anims[j].frameCount = 15;
				break;

			case 5070:
				// fileID = 182
				anims[j].primaryFrames = new int[] { 11927608, 11927625, 11927598, 11927678, 11927582, 11927600,
						11927669, 11927597, 11927678, };
				anims[j].durations = new int[] { 5, 4, 4, 4, 5, 5, 5, 4, 4, };
				anims[j].frameCount = 9;
				break;

			case 5071:
				// fileID = 182
				anims[j].primaryFrames = new int[] { 11927640, 11927643, 11927695, 11927630, 11927556, 11927667,
						11927692, 11927588, 11927555, 11927624, 11927633, 11927673, 11927661, 11927666, 11927664,
						11927579, 11927670, 11927636, 11927685, 11927595, 11927623, };
				anims[j].durations = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, };
				anims[j].frameCount = 21;
				break;

			case 5072:
				// fileID = 182
				anims[j].primaryFrames = new int[] { 11927623, 11927595, 11927685, 11927636, 11927670, 11927579,
						11927664, 11927666, 11927661, 11927673, 11927633, 11927624, 11927555, 11927588, 11927692,
						11927667, 11927556, 11927630, 11927695, 11927643, 11927640, };
				anims[j].durations = new int[] { 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, };
				anims[j].frameCount = 21;
				break;

			case 5073:
				// fileID = 182
				anims[j].primaryFrames = new int[] { 11927640, 11927643, 11927695, 11927630, 11927556, 11927667,
						11927692, 11927588, 11927555, 11927624, 11927633, 11927673, 11927661, 11927666, 11927664,
						11927579, 11927670, 11927636, 11927685, 11927595, 11927623, };
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, };
				anims[j].frameCount = 21;
				break;

			case 5804:
				// fileID = 182
				anims[j].primaryFrames = new int[] { 11927638, 11927632, 11927590, 11927580, 11927568, 11927641,
						11927652, 11927594, 11927620, 11927646, 11927658, 11927679, 11927585, 11927596, 11927559,
						11927565, 11927593, 11927584, 11927665, 11927553, 11927587, 11927682, 11927566, 11927645,
						11927592, 11927650, 11927634, 11927674, 11927689, 11927686, 11927671, 11927609, 11927603,
						11927663, 11927619, 11927572, 11927589, 11927581, 11927570, 11927662, 11927558, 11927631,
						11927617, 11927655, 11927561, 11927642, 11927575, 11927578, 11927648, };
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
						3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 6, };
				anims[j].frameCount = 49;
				break;

			case 5806:
				// fileID = 182
				anims[j].primaryFrames = new int[] { 11927612, 11927677, 11927615, 11927573, 11927618, 11927567,
						11927564, 11927606, 11927675, 11927657, 11927690, 11927583, 11927672, 11927552, 11927563,
						11927683, 11927639, 11927635, 11927668, 11927614, 11927627, 11927610, 11927693, 11927644,
						11927656, 11927660, 11927629, 11927635, 11927668, 11927614, 11927627, 11927610, 11927693,
						11927644, 11927656, 11927660, 11927635, 11927668, 11927614, 11927560, 11927687, 11927577,
						11927569, 11927557, 11927569, 11927577, 11927687, 11927560, 11927651, 11927611, 11927680,
						11927622, 11927691, 11927571, 11927601, };
				anims[j].durations = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
						4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4,
						3, };
				anims[j].frameCount = 55;
				break;

			case 5807:
				// fileID = 182
				anims[j].primaryFrames = new int[] { 11927612, 11927677, 11927615, 11927573, 11927618, 11927567,
						11927564, 11927606, 11927675, 11927657, 11927690, 11927583, 11927672, 11927552, 11927563,
						11927683, 11927639, 11927635, 11927668, 11927614, 11927627, 11927610, 11927693, 11927644,
						11927656, 11927660, 11927629, 11927635, 11927668, 11927614, 11927627, 11927610, 11927693,
						11927644, 11927656, 11927604, 11927637, 11927688, 11927696, 11927681, 11927605, 11927681,
						11927696, 11927688, 11927637, 11927604, 11927656, 11927611, 11927680, 11927622, 11927691,
						11927571, 11927601, };
				anims[j].durations = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
						4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 3, };
				anims[j].frameCount = 53;
				break;

			case 5808:
				// fileID = 182
				anims[j].primaryFrames = new int[] { 11927694, 11927654, 11927591, 11927649, 11927607, 11927649,
						11927591, 11927654, 11927694, };
				anims[j].durations = new int[] { 3, 3, 3, 3, 6, 3, 3, 3, 3, };
				anims[j].frameCount = 9;
				break;

			case 7291:
				// fileID = 2572
				anims[j].durations = new int[] { 18, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1,
						1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 6, 4, 1, 1, 1, 1, 1, 1, 1, 1, };
				anims[j].primaryFrames = new int[] { 168558682, 168558693, 168558686, 168558670, 168558665, 168558702,
						168558703, 168558669, 168558690, 168558705, 168558692, 168558694, 168558671, 168558679,
						168558672, 168558667, 168558675, 168558683, 168558706, 168558681, 168558704, 168558673,
						168558698, 168558680, 168558695, 168558677, 168558700, 168558701, 168558699, 168558668,
						168558689, 168558684, 168558678, 168558696, 168558688, 168558666, 168558687, 168558674,
						168558691, 168558676, 168558685, 168558697, };
				anims[j].frameCount = 42;
				anims[j].loopOffset = -1;
				anims[j].stretches = false;
				anims[j].priority = 5;
				anims[j].playerOffhand = -1;
				anims[j].playerMainhand = -1;
				anims[j].maximumLoops = 99;
				anims[j].animatingPrecedence = -1;
				anims[j].walkingPrecedence = -1;
				anims[j].replayMode = 2;
				break;

			case 7292:
				// fileID = 2572
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
						3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, };
				anims[j].primaryFrames = new int[] { 168558648, 168558597, 168558594, 168558633, 168558664, 168558599,
						168558645, 168558615, 168558595, 168558636, 168558640, 168558607, 168558658, 168558647,
						168558631, 168558628, 168558655, 168558656, 168558613, 168558611, 168558633, 168558664,
						168558599, 168558645, 168558615, 168558595, 168558636, 168558640, 168558607, 168558658,
						168558647, 168558631, 168558619, 168558643, 168558652, 168558638, 168558637, 168558637, };
				anims[j].frameCount = 38;
				anims[j].loopOffset = -1;
				anims[j].stretches = false;
				anims[j].priority = 5;
				anims[j].playerOffhand = -1;
				anims[j].playerMainhand = -1;
				anims[j].maximumLoops = 99;
				anims[j].animatingPrecedence = -1;
				anims[j].walkingPrecedence = -1;
				anims[j].replayMode = 2;
				break;

			case 7293:
				// fileID = 2572
				anims[j].durations = new int[] { 24, 3, 3, 2, 2, 2, 2, 2, 2, 2, };
				anims[j].primaryFrames = new int[] { 168558612, 168558616, 168558592, 168558660, 168558600, 168558662,
						168558617, 168558614, 168558624, 168558644, };
				anims[j].frameCount = 10;
				anims[j].loopOffset = -1;
				anims[j].stretches = false;
				anims[j].priority = 5;
				anims[j].playerOffhand = -1;
				anims[j].playerMainhand = -1;
				anims[j].maximumLoops = 99;
				anims[j].animatingPrecedence = -1;
				anims[j].walkingPrecedence = -1;
				anims[j].replayMode = 2;
				break;

			case 7294:
				// fileID = 2571
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
						3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, };
				anims[j].primaryFrames = new int[] { 168493151, 168493160, 168493066, 168493116, 168493073, 168493202,
						168493179, 168493140, 168493166, 168493161, 168493157, 168493154, 168493099, 168493212,
						168493172, 168493096, 168493215, 168493190, 168493163, 168493066, 168493116, 168493073,
						168493202, 168493179, 168493140, 168493166, 168493161, 168493157, 168493154, 168493099,
						168493212, 168493172, 168493096, 168493215, 168493190, 168493163, 168493056, 168493151, };
				anims[j].frameCount = 38;
				anims[j].loopOffset = -1;
				anims[j].stretches = false;
				anims[j].priority = 5;
				anims[j].playerOffhand = -1;
				anims[j].playerMainhand = -1;
				anims[j].maximumLoops = 99;
				anims[j].animatingPrecedence = -1;
				anims[j].walkingPrecedence = -1;
				anims[j].replayMode = 2;
				break;

			case 7295:
				// fileID = 2571
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, };
				anims[j].primaryFrames = new int[] { 168493102, 168493119, 168493200, 168493113, 168493153, 168493194,
						168493134, 168493213, 168493149, 168493122, 168493098, 168493170, 168493170, 168493188,
						168493205, 168493196, 168493165, 168493102, };
				anims[j].frameCount = 18;
				anims[j].loopOffset = -1;
				anims[j].stretches = false;
				anims[j].priority = 5;
				anims[j].playerOffhand = -1;
				anims[j].playerMainhand = -1;
				anims[j].maximumLoops = 99;
				anims[j].animatingPrecedence = -1;
				anims[j].walkingPrecedence = -1;
				anims[j].replayMode = 2;
				break;

			case 7296:
				// fileID = 2571
				anims[j].durations = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, };
				anims[j].primaryFrames = new int[] { 168493148, 168493076, 168493137, 168493077, 168493086, 168493081,
						168493121, 168493126, 168493143, 168493176, 168493109, 168493131, 168493063, 168493080,
						168493217, 168493189, 168493093, 168493199, 168493106, 168493175, 168493148, };
				anims[j].frameCount = 21;
				anims[j].loopOffset = -1;
				anims[j].stretches = false;
				anims[j].priority = 5;
				anims[j].playerOffhand = -1;
				anims[j].playerMainhand = -1;
				anims[j].maximumLoops = 99;
				anims[j].animatingPrecedence = -1;
				anims[j].walkingPrecedence = -1;
				anims[j].replayMode = 2;

				break;
				
				/**
				 * Start of nex anims
				 */
			case 6319:
				//fileId = 3502;
				anims[6319].frameCount = 24;
				anims[6319].priority = 4;
				anims[6319].durations = new int[]{2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2};
				anims[6319].primaryFrames = new int[]{229507415, 229507219, 229507411, 229507095, 229507202, 229507224, 229507326, 229507235, 229507337, 229507288, 229507430, 229507317, 229507239, 229507312, 229507404, 229507121, 229507464, 229507413, 229507329, 229507378, 229507173, 229507150, 229507292, 229507308};
				break;
			case 6320:
				//fileId = 3502;
				anims[6320].frameCount = 32;
				anims[6320].priority = 2;
				anims[6320].durations = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
				anims[6320].primaryFrames = new int[]{229507242, 229507350, 229507403, 229507099, 229507086, 229507365, 229507148, 229507289, 229507075, 229507246, 229507229, 229507171, 229507371, 229507296, 229507153, 229507333, 229507310, 229507198, 229507399, 229507458, 229507344, 229507142, 229507402, 229507154, 229507393, 229507220, 229507180, 229507479, 229507133, 229507450, 229507469, 229507204};
				break;
			case 6321:
				//fileId = 3502;
				anims[6321].frameCount = 53;
				anims[6321].priority = 10;
				anims[6321].durations = new int[]{1, 3, 4, 4, 3, 3, 3, 3, 2, 2, 2, 2, 7, 7, 4, 6, 3, 2, 3, 2, 2, 2, 2, 3, 4, 3, 3, 3, 2, 6, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 4, 6, 6, 5, 5, 6, 2};
				anims[6321].primaryFrames = new int[]{229507234, 229507100, 229507316, 229507266, 229507363, 229507217, 229507382, 229507257, 229507177, 229507092, 229507389, 229507163, 229507117, 229507354, 229507347, 229507123, 229507111, 229507081, 229507453, 229507309, 229507390, 229507258, 229507160, 229507213, 229507162, 229507282, 229507304, 229507164, 229507098, 229507103, 229507195, 229507103, 229507195, 229507103, 229507195, 229507103, 229507195, 229507103, 229507195, 229507103, 229507195, 229507103, 229507195, 229507103, 229507195, 229507103, 229507195, 229507174, 229507394, 229507225, 229507376, 229507271, 229507332};
				break;
			case 6326:
				//fileId = 3502;
				anims[6326].frameCount = 36;
				anims[6326].priority = 10;
				anims[6326].durations = new int[]{1, 3, 3, 4, 3, 3, 3, 3, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 7, 8, 8, 7, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2};
				anims[6326].primaryFrames = new int[]{229507157, 229507156, 229507446, 229507440, 229507406, 229507431, 229507247, 229507218, 229507465, 229507474, 229507077, 229507357, 229507327, 229507482, 229507116, 229507259, 229507129, 229507275, 229507322, 229507087, 229507102, 229507436, 229507268, 229507443, 229507361, 229507128, 229507372, 229507407, 229507185, 229507293, 229507226, 229507323, 229507255, 229507352, 229507401, 229507159};
				break;
			case 6354:
				//fileId = 3502;
				anims[6354].frameCount = 25;
				anims[6354].priority = 8;
				anims[6354].durations = new int[]{1, 1, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 5, 5, 2, 1, 1, 2, 2, 3};
				anims[6354].primaryFrames = new int[]{229507373, 229507203, 229507097, 229507298, 229507386, 229507264, 229507277, 229507080, 229507089, 229507481, 229507078, 229507094, 229507451, 229507384, 229507183, 229507385, 229507209, 229507414, 229507417, 229507335, 229507270, 229507178, 229507331, 229507096, 229507260};
				break;
			case 6355:
				//fileId = 3502;
				anims[6355].frameCount = 36;
				anims[6355].priority = 10;
				anims[6355].durations = new int[]{2, 3, 2, 2, 1, 2, 2, 3, 3, 3, 3, 3, 4, 4, 2, 2, 2, 2, 2, 3, 2, 1, 1, 1, 2, 2, 1, 2, 2, 3, 6, 5, 3, 1, 1, 1};
				anims[6355].primaryFrames = new int[]{229507412, 229507243, 229507299, 229507483, 229507428, 229507470, 229507113, 229507122, 229507468, 229507197, 229507251, 229507284, 229507215, 229507125, 229507447, 229507471, 229507303, 229507265, 229507093, 229507328, 229507273, 229507283, 229507346, 229507302, 229507480, 229507141, 229507475, 229507208, 229507396, 229507172, 229507375, 229507355, 229507305, 229507387, 229507138, 229507082};
				break;
			case 6948:
				//fileId = 3502;
				anims[6948].frameCount = 29;
				anims[6948].priority = 10;
				anims[6948].durations = new int[]{5, 5, 6, 3, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 3, 3, 4, 5, 8};
				anims[6948].primaryFrames = new int[]{229507301, 229507367, 229507205, 229507131, 229507132, 229507395, 229507318, 229507194, 229507462, 229507395, 229507318, 229507194, 229507462, 229507395, 229507318, 229507194, 229507462, 229507395, 229507318, 229507194, 229507462, 229507395, 229507318, 229507194, 229507426, 229507278, 229507147, 229507236, 229507353};
				break;
			case 6951:
				//fileId = 3502;
				anims[6951].frameCount = 65;
				anims[6951].priority = 10;
				anims[6951].durations = new int[]{4, 4, 3, 3, 4, 6, 5, 5, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 4, 4, 8, 6, 5, 1, 1, 1, 1, 3, 3, 3, 3, 3, 5, 6, 6, 6, 6, 36, 22, 22};
				anims[6951].primaryFrames = new int[]{229507307, 229507427, 229507228, 229507272, 229507422, 229507168, 229507107, 229507306, 229507249, 229507409, 229507476, 229507294, 229507250, 229507109, 229507461, 229507211, 229507244, 229507364, 229507348, 229507237, 229507341, 229507405, 229507408, 229507090, 229507079, 229507280, 229507290, 229507398, 229507119, 229507467, 229507330, 229507319, 229507181, 229507200, 229507112, 229507167, 229507334, 229507254, 229507340, 229507410, 229507383, 229507106, 229507377, 229507151, 229507269, 229507429, 229507196, 229507073, 229507136, 229507311, 229507313, 229507088, 229507432, 229507388, 229507074, 229507477, 229507456, 229507188, 229507274, 229507165, 229507212, 229507439, 229507118, 229507356, 229507438};
				break;
			case 6983:
				//fileId = 3502;
				anims[6983].frameCount = 32;
				anims[6983].priority = 2;
				anims[6983].durations = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
				anims[6983].primaryFrames = new int[]{229507321, 229507140, 229507338, 229507135, 229507374, 229507419, 229507230, 229507320, 229507454, 229507392, 229507421, 229507084, 229507166, 229507444, 229507425, 229507120, 229507201, 229507459, 229507449, 229507190, 229507435, 229507110, 229507380, 229507083, 229507420, 229507206, 229507360, 229507452, 229507297, 229507262, 229507381, 229507104};
				break;
			case 6984:
				//fileId = 3502;
				anims[6984].frameCount = 25;
				anims[6984].priority = 8;
				anims[6984].durations = new int[]{3, 5, 5, 5, 4, 4, 3, 3, 3, 3, 5, 8, 6, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 3, 3};
				anims[6984].primaryFrames = new int[]{229507276, 229507448, 229507161, 229507325, 229507145, 229507076, 229507416, 229507351, 229507170, 229507358, 229507418, 229507457, 229507115, 229507158, 229507473, 229507169, 229507362, 229507182, 229507287, 229507191, 229507240, 229507434, 229507279, 229507091, 229507126};
				break;
			case 6985:
				//fileId = 3502;
				anims[6985].frameCount = 9;
				anims[6985].priority = 10;
				anims[6985].durations = new int[]{3, 3, 2, 3, 4, 4, 4, 4, 3};
				anims[6985].primaryFrames = new int[]{229507397, 229507424, 229507186, 229507245, 229507175, 229507248, 229507445, 229507139, 229507291};
				break;
			case 6986:
				//fileId = 3502;
				anims[6986].frameCount = 33;
				anims[6986].priority = 6;
				anims[6986].durations = new int[]{4, 4, 8, 4, 4, 4, 4, 4, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 2, 2};
				anims[6986].primaryFrames = new int[]{229507149, 229507222, 229507134, 229507114, 229507130, 229507423, 229507144, 229507127, 229507227, 229507189, 229507463, 229507101, 229507263, 229507400, 229507324, 229507267, 229507238, 229507295, 229507072, 229507342, 229507300, 229507179, 229507359, 229507281, 229507105, 229507192, 229507343, 229507370, 229507339, 229507437, 229507146, 229507369, 229507252};
				break;
			case 6987:
				//fileId = 3502;
				anims[6987].frameCount = 28;
				anims[6987].priority = 6;
				anims[6987].durations = new int[]{2, 6, 6, 5, 2, 3, 4, 4, 4, 4, 4, 2, 2, 3, 3, 2, 2, 3, 2, 4, 4, 3, 3, 3, 3, 2, 3, 2};
				anims[6987].primaryFrames = new int[]{229507216, 229507231, 229507442, 229507315, 229507478, 229507108, 229507193, 229507472, 229507261, 229507441, 229507460, 229507433, 229507285, 229507210, 229507155, 229507336, 229507286, 229507232, 229507366, 229507368, 229507391, 229507124, 229507253, 229507233, 229507221, 229507345, 229507143, 229507466};
				break;
				/**
				 * End of nex anims
				 */
				

			}
		}
	}

	public int duration(int frameId) {
		int duration = durations[frameId];
		if (duration == 0) {
			Frame frame = Frame.forId(primaryFrames[frameId]);
			if (frame != null)
				duration = durations[frameId] = frame.anInt636;
		}
		if (duration == 0)
			duration = 1;
		return duration;
	}

	 private void readValues667(int id, Buffer stream)
	  {
	    int i;
	    while ((i = stream.readUnsignedByte()) != 0)
	    {
	      if (i == 1) {
				frameCount = stream.readUnsignedWord();
				primaryFrames = new int[frameCount];
				secondaryFrames = new int[frameCount];
				durations = new int[frameCount];
				
				for (int j = 0; j < frameCount; j++)
					durations[j] = stream.readShort();


				for (int j = 0; j < frameCount; j++) {
					primaryFrames[j] = stream.readShort();
					secondaryFrames[j] = -1;
				}
				

				for (int j = 0; j < frameCount; j++) {
					primaryFrames[j] += stream.readShort() << 16;
				}
	      }
	      else if (i == 2)
	      {
	        this.loopOffset = stream.readUnsignedWord();
	      }
			else if (i == 3) {
				int count = stream.readUnsignedByte();
				interleaveOrder = new int[count + 1];
				for (int l = 0; l < count; l++)
					interleaveOrder[l] = stream.readUnsignedByte();
				interleaveOrder[count] = 9999999;
			}
	      else if (i == 4)
	      {
	        this.stretches = true;
	      }
	      else if (i == 5)
	      {
	        this.priority = stream.readUnsignedByte();
	      }
	      else if (i == 6)
	      {
	        this.playerOffhand = stream.readUnsignedWord();
	      }
	      else if (i == 7)
	      {
	        this.playerMainhand = stream.readUnsignedWord();
	      }
	      else if (i == 8)
	      {
	        this.maximumLoops = stream.readUnsignedByte();
	      }
	      else if (i == 9)
	      {
	        this.animatingPrecedence = stream.readUnsignedByte();
	      }
	      else if (i == 10)
	      {
	        this.walkingPrecedence = stream.readUnsignedByte();
	      }
	      else if (i == 11)
	      {
	        this.replayMode = stream.readUnsignedByte();
	      }
	      else if (i == 12)
	      {
	        stream.readUnsignedWord();
	      }
	      else
	      {
	        System.out.println("Error unrecognised seq config code: " + i);
	      }
	    }
	    if (this.frameCount == 0)
	    {
	      this.frameCount = 1;
	      this.primaryFrames = new int[1];
	      this.primaryFrames[0] = -1;
	      this.secondaryFrames = new int[1];
	      this.secondaryFrames[0] = -1;
	      this.durations = new int[1];
	      this.durations[0] = -1;
	    }
	    if (this.animatingPrecedence == -1) {
	      if (this.interleaveOrder != null) {
	        this.animatingPrecedence = 2;
	      } else {
	        this.animatingPrecedence = 0;
	      }
	    }
	    if (this.walkingPrecedence == -1)
	    {
	      if (this.interleaveOrder != null)
	      {
	        this.walkingPrecedence = 2;
	        return;
	      }
	      this.walkingPrecedence = 0;
	    }
	  }
	
	private void readValues(Buffer stream) {
		int i;
		int last = 0;
		while ((i = stream.readUnsignedByte()) != 0) {

			if (i == 1) {
				frameCount = stream.readShort();
				primaryFrames = new int[frameCount];
				secondaryFrames = new int[frameCount];
				durations = new int[frameCount];
				
				for (int j = 0; j < frameCount; j++)
					durations[j] = stream.readShort();


				for (int j = 0; j < frameCount; j++) {
					primaryFrames[j] = stream.readShort();
					secondaryFrames[j] = -1;
				}
				

				for (int j = 0; j < frameCount; j++) {
					primaryFrames[j] += stream.readShort() << 16;
				}
			} else if (i == 2)
				loopOffset = stream.readShort();
			else if (i == 3) {
				int count = stream.readUnsignedByte();
				interleaveOrder = new int[count + 1];
				for (int l = 0; l < count; l++)
					interleaveOrder[l] = stream.readUnsignedByte();
				interleaveOrder[count] = 9999999;
			} else if (i == 4)
				stretches = true;
			else if (i == 5)
				priority = stream.readUnsignedByte();
			else if (i == 6)
				playerOffhand = stream.readShort();
			else if (i == 7)
				playerMainhand = stream.readShort();
			else if (i == 8)
				maximumLoops = stream.readUnsignedByte();
			else if (i == 9)
				animatingPrecedence = stream.readUnsignedByte();
			else if (i == 10)
				walkingPrecedence = stream.readUnsignedByte();
			else if (i == 11)
				replayMode = stream.readUnsignedByte();
			else if (i == 12) {
				int len = stream.readUnsignedByte();
				otherFrames = new int[len];
				for (int i2 = 0; i2 < len; i2++) {
					otherFrames[i2] = stream.readShort();
				}

				for (int i2 = 0; i2 < len; i2++) {
					otherFrames[i2] += stream.readShort() << 16;
				}
			} else if(i == 13) {
				int count = stream.readUnsignedByte();
				stream.position += (3 * count);
			}
			else {
				System.out.println("Error unrecognised seq config code: " + i + " last? " + last);
				continue;
			}
			last = i;
		}
		if (frameCount == 0) {
			frameCount = 1;
			primaryFrames = new int[1];
			primaryFrames[0] = -1;
			secondaryFrames = new int[1];
			secondaryFrames[0] = -1;
			durations = new int[1];
			durations[0] = -1;
		}
		if (animatingPrecedence == -1)
			if (interleaveOrder != null)
				animatingPrecedence = 2;
			else
				animatingPrecedence = 0;
		if (walkingPrecedence == -1) {
			if (interleaveOrder != null) {
				walkingPrecedence = 2;
				return;
			}
			walkingPrecedence = 0;
		}
	}

	public AnimationDefinition() {
		loopOffset = -1;
		stretches = false;
		priority = 5;
		playerOffhand = -1;
		playerMainhand = -1;
		maximumLoops = 99;
		animatingPrecedence = -1;
		walkingPrecedence = -1;
		replayMode = 2;
	}
	
	public static void dumpValues() {
		System.out.println("Dumping Animations..");
		String[] variablesNames = new String[] { "frameCount", "frameIDs", "frameIDs2", "delays", "loopDelay",
				"animationFlowControl", "oneSquareAnimation", "forcedPriority", "leftHandItem", "rightHandItem",
				"frameStep", "resetWhenWalk", "priority", "delayType" };
		File f = new File("anims.txt");
		try {
			f.createNewFile();
			BufferedWriter bf = new BufferedWriter(new FileWriter(f));
			for (int j = 0; j < j; j++) {
				String frameCount = anims[j].frameCount + "";
				String frameIDs = Arrays.toString(anims[j].primaryFrames);
				String frameIDs2 = Arrays.toString(anims[j].secondaryFrames);
				String delays = Arrays.toString(anims[j].durations);
				String loopDelay = anims[j].loopOffset + "";
				String forcedPriority = anims[j].priority + "";
				String leftHandItem = anims[j].playerOffhand + "";
				String rightHandItem = anims[j].playerMainhand + "";
				String frameStep = anims[j].otherFrames + "";
				String priority = anims[j].priority + "";

				String[] variables = new String[] { frameCount, frameIDs, frameIDs2, delays, loopDelay,
						 leftHandItem, rightHandItem,
						frameStep, priority };
				bf.write("if (j == " + j + ") {\n");
				for (int k = 0; k < variables.length; k++) {
					bf.write("anims[ " + j + "]." + variablesNames[k] + " = " + variables[k] + ";\n");
				}
				bf.write("}\n\n");
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Dumping Complete!");
	}

	public int[] otherFrames;
	 public static final int START_717 = 20000;
	  private static AnimationDefinition[] anims717;
	public static AnimationDefinition anims[];
	public int frameCount;
	public int primaryFrames[];
	public int secondaryFrames[];
	public int[] durations;
	public int loopOffset;
	public int interleaveOrder[];
	public boolean stretches;
	public int priority;
	public int playerOffhand;
	public int playerMainhand;
	public int maximumLoops;
	public int animatingPrecedence;
	public int walkingPrecedence;
	public int replayMode;
	public static int anInt367;
}