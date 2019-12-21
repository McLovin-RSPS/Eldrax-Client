package com.client.dumper;

public class ItemDefDumperData {

	private int id;
	private String name;
	private int[] modifiedColors, newModelColors;

	public ItemDefDumperData(int id, String name, int[] modifiedColors, int[] newModelColors) {
		this.id = id;
		this.name = name;
		this.modifiedColors = modifiedColors;
		this.newModelColors = newModelColors;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int[] getModifiedColors() {
		return modifiedColors;
	}

	public int[] getnewModelColors() {
		return newModelColors;
	}

}
