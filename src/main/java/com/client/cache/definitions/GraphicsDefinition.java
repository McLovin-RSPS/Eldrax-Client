package com.client.cache.definitions;

import com.client.cache.Archive;
import com.client.collection.Cache;
import com.client.io.Buffer;
import com.client.model.Model;

public final class GraphicsDefinition {

	public static void unpackConfig(Archive streamLoader) {
		Buffer stream = new Buffer(streamLoader.getDataForName("spotanim.dat"));
		int length = stream.readShort();
		if (cache == null)
			cache = new GraphicsDefinition[length + 15000];
		for (int j = 0; j < length; j++) {
			if (cache[j] == null) {
				cache[j] = new GraphicsDefinition();
			}
			if (j == 65535) {
				j = -1;
			}
			cache[j].index = j;
			cache[j].setDefault();
			cache[j].readValues(stream);
		}
		cache[1282] = new GraphicsDefinition();
		cache[1282].index = 1282;
		cache[1282].modelId = 44811;
		cache[1282].animationId = 7155;
		cache[1282].animation = AnimationDefinition.anims[cache[1282].animationId];
	}

	private void readValues(Buffer stream) {
		while(true) {
			int i = stream.readUnsignedByte();
			if (i == 0) {
				return;
			}
			if (i == 1) {
				modelId = stream.readShort();
			} else if (i == 2) {
				animationId = stream.readShort();
				if (AnimationDefinition.anims != null) {
					animation = AnimationDefinition.anims[animationId];
				}
			} else if (i == 4) {
				breadthScale = stream.readShort();
			} else if (i == 5) {
				depthScale = stream.readShort();
			} else if (i == 6) {
				orientation = stream.readShort();
			} else if (i == 7) {
				ambience = stream.readUnsignedByte();
			} else if (i == 8) {
				modelShadow = stream.readUnsignedByte();
			} else if (i == 40) {
				int j = stream.readUnsignedByte();
				for (int k = 0; k < j; k++) {
					originalColours[k] = stream.readShort();
					replacementColours[k] = stream.readShort();
				}
			} else {
				System.out.println("Error unrecognised spotanim config code: " + i);
			}
		}
	}

	
	public static GraphicsDefinition fetch(int modelId) {
		for (GraphicsDefinition anim : cache) {
			if (anim == null) {
				continue;
			}
			if (anim.modelId == modelId) {
				return anim;
			}
		}
		return null;
	}

	public Model getModel() {
		Model model = (Model) modelCache.insertFromCache(index);
		if (model != null)
			return model;
		model = Model.fetchModel(modelId);
		if (model == null)
			return null;
		for (int i = 0; i < originalColours.length; i++)
			if (originalColours[0] != 0) //default frame id
				model.replaceColor(originalColours[i], replacementColours[i]);

		modelCache.removeFromCache(model, index);
		return model;
	}
	
	private void setDefault() {
		modelId = -1;
		animationId = -1;
		originalColours = new int[6];
		replacementColours = new int[6];
		breadthScale = 128;
		depthScale = 128;
		orientation = 0;
		ambience = 0;
		modelShadow = 0;
	}

	public GraphicsDefinition() {
		anInt400 = 9;
		animationId = -1;
		originalColours = new int[6];
		replacementColours = new int[6];
		breadthScale = 128;
		depthScale = 128;
	}
	
	public int getModelId() {
		return modelId;
	}
	
	public int getIndex() {
		return index;
	}

	public final int anInt400;
	public static GraphicsDefinition cache[];
	private int index;
	private int modelId;
	public int animationId;
	public AnimationDefinition animation;
	public int[] originalColours;
	public int[] replacementColours;
	public int breadthScale;
	public int depthScale;
	public int orientation;
	public int ambience;
	public int modelShadow;
	public static Cache modelCache = new Cache(30);

}
