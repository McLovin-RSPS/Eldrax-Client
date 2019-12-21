package com.client.cache.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

import com.client.io.Buffer;
import com.client.sign.Signlink;

/**
 * @author dragonkk(Alex)
 * Jul 18, 2017
 */
public class PreEocCache {
	
	public static int MODELS_FOLDER = 0, OBJECTS_FOLDER = 1, MAPS_FOLDER = 2, SKELETONS_FOLDER = 3, SKINS_FOLDER = 4, ANIMATIONS_FOLDER = 5, GRAPHICS_FOLDER = 6, NPCS_FOLDER = 7, ITEMS_FOLDER = 8, FLOOR_FOLDER = 9;
		
	//to make sure no conflicts with rs2/rs3/customs models
	public static final int MODEL_OFFSET = 200000;
	public static final int OBJECTS_OFFSET = 100000;
	public static final int ANIMATIONS_OFFSET = 20000;
	public static final int GRAPHICS_OFFSET = 5000;
	public static final int FRAMES_OFFSET = 30000;
	public static final int ITEMS_OFFSET = 30000;
	public static final int NPCS_OFFSET = 30000;
	public static final int FLOOR_OFFSET = 200;
	public static boolean ENABLE_PRE_EOC = false;
	
	private static RandomAccessFile[] idxRaf;
	private static RandomAccessFile dataF;
	
	public static void init() {
		if (!ENABLE_PRE_EOC) {
			return;
		}
		try {
			idxRaf = new RandomAccessFile[6];
			for (int i = 0; i < idxRaf.length; i++) {
				idxRaf[i] = new RandomAccessFile(Signlink.getCacheDirectory()+"data/cache667/main_file_cache.idx"+i, "r");
			}
			dataF = new RandomAccessFile(Signlink.getCacheDirectory()+"data/cache667/main_file_cache.dat", "r");
		} catch (FileNotFoundException e) {
			ENABLE_PRE_EOC = false;
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(containsFile(PreEocCache.MAPS_FOLDER, 9043 * 2 ));
	}

	public static byte[] getFileD(int partition, int id) {
		byte[] data = getFile(partition, id);
		return data == null ? null : decompress(data);
	}
	
	public static int getFilesCount(int partition) {
		if (!ENABLE_PRE_EOC) {
			return 0;
		}
		try {
			return (int) (idxRaf[partition].length() / 8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static boolean containsFile(int partition, int id) {
		if (!ENABLE_PRE_EOC) {
			return false;
		}
		try {
			synchronized (dataF) {
			int pos = id * 8;
			if (idxRaf[partition].length() < pos + 8) {
				return false;
			}
			idxRaf[partition].seek(pos);
			pos = idxRaf[partition].readInt();
			int size = idxRaf[partition].readInt();
			if (size == 0 || dataF.length() < pos + size) {
				return false;
			}
			return true;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static byte[] getFile(int partition, int id) {
		if (!ENABLE_PRE_EOC) {
			return null;
		}
		try {
			synchronized (dataF) {
			int pos = id * 8;
			if (idxRaf[partition].length() < pos + 8) {
				return null;
			}
			idxRaf[partition].seek(pos);
			pos = idxRaf[partition].readInt();
			int size = idxRaf[partition].readInt();
			if (size == 0 || dataF.length() < pos + size) {
				return null;
			}
			byte[] data = new byte[size];
			dataF.seek(pos);
			dataF.readFully(data);
			return data;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] decompress(byte[] data) {
		try {
			java.io.ByteArrayInputStream bytein = new java.io.ByteArrayInputStream(data);
			java.util.zip.GZIPInputStream gzin = new java.util.zip.GZIPInputStream(bytein);
			java.io.ByteArrayOutputStream byteout = new java.io.ByteArrayOutputStream();

			int res = 0;
			byte buf[] = new byte[1024];
			while (res >= 0) {
				res = gzin.read(buf, 0, buf.length);
				if (res > 0) {
					byteout.write(buf, 0, res);
				}
			}
			byte uncompressed[] = byteout.toByteArray();
			bytein.close();
			gzin.close();
			byteout.close();
			return uncompressed;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Map<Integer, Object> decodeSettings(Buffer buffer) {
		int length = buffer.readUnsignedByte();
		Map<Integer, Object> settings = new HashMap<Integer, Object>();
		for (int i = 0; i < length; i++) {
			boolean sType = buffer.readUnsignedByte() == 1;
			int key = buffer.readUnsignedMedium();
			Object value = sType ? buffer.readString/*OS*/() : buffer.readInt();
			settings.put(key, value);
		}
		return settings;
	}
}
