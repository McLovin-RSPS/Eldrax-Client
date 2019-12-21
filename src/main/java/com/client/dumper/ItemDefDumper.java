package com.client.dumper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.client.cache.definitions.ItemDefinition;


public class ItemDefDumper {

	private int totalItems;

	public ItemDefDumper(int totalItems) {
		this.totalItems = totalItems;
	}

	public void execute() {
		for (int i = 0; i < totalItems; i++) {
			ItemDefinition def = ItemDefinition.forID(i);
			if (def != null) {
				DUMP.add(new ItemDefDumperData(
						def.id, 
						def.name, 
						def.modifiedModelColors, 
						def.newModelColors));
			}
		}
		dump();
	}

	private void dump() {
		try (PrintWriter file = new PrintWriter(new FileOutputStream(new File("item_output"), true))) {

			DUMP.forEach(definition -> {
				file.append("Id: " + definition.getId());
				file.println();
				file.append("Name: " + definition.getName());
				file.println();
				file.append("New Colors: " + definition.getnewModelColors());
				file.println();
				file.append("Modified Colors: " + definition.getModifiedColors());
				file.println();
			});

			file.flush();
			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finished Dumping Item Definition!");
		}
	}

	private List<ItemDefDumperData> DUMP = new ArrayList<>();
}
