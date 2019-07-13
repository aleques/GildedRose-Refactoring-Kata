package com.gildedrose.domain;

public enum ItemType {

	AGED_BRIE("Aged Brie"),
	SULFURAS("Sulfuras, Hand of Ragnaros"),
	BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
	CONJURED("Conjured Mana Cake"),
	COMMON_ITEM("Common item");

	private String name;

	ItemType(String name) {
		this.name = name;
	}

	public static ItemType get(String fullName) {
		for (ItemType itemType : values()) {
			if (itemType.name.equals(fullName)) {
				return itemType;
			}
		}
		return COMMON_ITEM;
	}

	public String getName() {
		return name;
	}
}