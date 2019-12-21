package com.client.cache;
import java.io.*;
import java.util.zip.*;

import com.client.bzip.BZip2Decompressor;
import com.client.io.Buffer;

public class Archive {

	public Archive(byte[] b, String s) {
		try {
			// if (s.contains("2d"))
			// b = getBytesFromFile(new File("./data.dat"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		a(b);
	}

	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		long length = file.length();
		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			is.close();
			throw new IOException("Could not completely read file "
					+ file.getName());
		}

		is.close();
		return bytes;
	}

	public void a(byte abyte0[]) {
		Buffer stream = new Buffer(abyte0);
		int i = stream.readUTriByte();
		int j = stream.readUTriByte();
		if (j == 0) {
			byte[] abyte1 = new byte[i];
			byte[] abyte3 = new byte[i];
			System.arraycopy(abyte0, 6, abyte1, 0, abyte0.length - 6);
			try {
				DataInputStream datainputstream = new DataInputStream(
						new GZIPInputStream(new ByteArrayInputStream(abyte1)));
				datainputstream.readFully(abyte3, 0, abyte3.length);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			archiveData = abyte3;
			stream = new Buffer(archiveData);
			compressed = true;
		} else if (j != i) {
			byte abyte1[] = new byte[i];
			BZip2Decompressor.method225(abyte1, i, abyte0, j, 6);
			archiveData = abyte1;
			stream = new Buffer(archiveData);
			compressed = true;
		} else {
			archiveData = abyte0;
			compressed = false;
		}
		numFiles = stream.readShort();
		fileHashes = new int[numFiles];
		fileLengths = new int[numFiles];
		fileCLengths = new int[numFiles];
		fileOffsets = new int[numFiles];
		int k = stream.position + numFiles * 10;
		for (int l = 0; l < numFiles; l++) {
			fileHashes[l] = stream.readInt();
			fileLengths[l] = stream.readUTriByte();
			fileCLengths[l] = stream.readUTriByte();
			fileOffsets[l] = k;
			k += fileCLengths[l];
		}
	}

	public byte[] getDataForName(String s) {
		byte abyte0[] = null; // was a parameter
		int i = 0;
		s = s.toUpperCase();
		for (int j = 0; j < s.length(); j++)
			i = (i * 61 + s.charAt(j)) - 32;

		for (int k = 0; k < numFiles; k++)
			if (fileHashes[k] == i) {
				if (abyte0 == null)
					abyte0 = new byte[fileLengths[k]];
				if (!compressed) {
					BZip2Decompressor.method225(abyte0, fileLengths[k], archiveData,
							fileCLengths[k], fileOffsets[k]);
				} else {
					System.arraycopy(archiveData, fileOffsets[k], abyte0,
							0, fileLengths[k]);

				}
				return abyte0;
			}

		return null;
	}

	public byte[] archiveData;
	public int numFiles;
	public int[] fileHashes;
	public int[] fileLengths;
	public int[] fileCLengths;
	public int[] fileOffsets;
	public boolean compressed;
}
