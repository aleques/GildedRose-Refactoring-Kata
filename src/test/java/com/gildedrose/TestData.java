package com.gildedrose;

public class TestData {

	public static Item[] getDataForSellInDegredesByOnePerDay() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 20, 50),
				new Item("Apple", 0, 12),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				new Item("Conjured Mana Cake", 3, 6) };
	}

	public static Item[] getDataForQualityDegredesTwiceFastWhenSellByDateHasPassed() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 0, 200),
				new Item("nuts", 0, 200),
				// new Item("Aged Brie", 20, 50),
				new Item("Apple", 0, 1200),
				new Item("Elixir of the Mongoose", -5, 500),
				new Item("Banana", -7, 1000),
				// new Item("Sulfuras, Hand of Ragnaros", -5, 80),
				new Item("Backstage passes", -10, 490) };
				//new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				//new Item("Conjured Mana Cake", 0, 600) };
	}

	public static Item[] getDataForQualityIsNeverNegative() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 20, 50),
				new Item("Apple", 0, 12),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Banana", 7, 10),
				new Item("Sulfuras, Hand of Ragnaros", 5, 80),
				new Item("Backstage passes", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				new Item("Conjured Mana Cake", 3, 6) };
	}

	public static Item[] getDataForQualityIsNeverMoreThan50() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 20, 50),
				new Item("Apple", 0, 12),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Banana", 7, 10),
				// new Item("Sulfuras, Hand of Ragnaros", 5, 80),
				new Item("Backstage passes", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				new Item("Conjured Mana Cake", 3, 6) };
	}

	public static Item[] getDataForQualityOfAgedBrieIncreasesWhenGetOlder() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 20, 50),
				new Item("Apple", 0, 12),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Banana", 7, 10),
				new Item("Aged Brie MASTER ULTRA", 20, 0),
				new Item("Sulfuras, Hand of Ragnaros", 5, 80),
				new Item("Backstage passes", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				new Item("Conjured Mana Cake", 3, 6) };
	}

	public static Item[] getDataForQualityOfSulfurasNeverDecreases() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 20, 50),
				new Item("Apple", 0, 12),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Banana", 7, 10),
				new Item("Sulfuras, Hand of Ragnaros", 5, 80),
				new Item("Backstage passes", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				new Item("Conjured Mana Cake", 3, 6) };
	}

	public static Item[] getDataForQualityOfSulfurasIsAlways80() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 20, 50),
				new Item("Apple", 0, 12),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Banana", 7, 10),
				new Item("Sulfuras, Hand of Ragnaros", 5, 80),
				new Item("Sulfuras from hell", 9, 80),
				new Item("Backstage passes", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				new Item("Conjured Mana Cake", 3, 6) };
	}

	public static Item[] getDataForSellInOfSulfurasNeverDecreases() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 20, 50),
				new Item("Apple", 0, 12),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Banana", 7, 10),
				new Item("Sulfuras, Hand of Ragnaros", 5, 80),
				new Item("Backstage passes", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				new Item("Conjured Mana Cake", 3, 6) };
	}

	public static Item[] getDataForQualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 20, 50),
				new Item("Apple", 0, 12),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Banana", 7, 10),
				new Item("Sulfuras, Hand of Ragnaros", 5, 80),
				new Item("Backstage passes", 4, 10),
				new Item("Backstage passes blablabla", 3, 15),
				new Item("Backstage passes ddddd", 1, 17),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 3),
				new Item("Conjured Mana Cake", 3, 6) };
	}

	public static Item[] getDataForQualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 20, 50),
				new Item("Apple", 0, 12),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Banana", 7, 10),
				new Item("Sulfuras, Hand of Ragnaros", 5, 80),
				new Item("Backstage passes", 10, 49),
				new Item("Backstage passes blablabla", 9, 15),
				new Item("Backstage passes ddddd", 6, 17),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 7),
				new Item("Conjured Mana Cake", 3, 6) };
	}

	public static Item[] getDataForQualityOfBackstagePassesDropsToZeroAfterConcert() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 20, 50),
				new Item("Apple", 0, 12),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Banana", 7, 10),
				new Item("Sulfuras, Hand of Ragnaros", 5, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49),
				new Item("Backstage passes", 10, 49),
				new Item("Conjured Mana Cake", 3, 6) };
	}

	public static Item[] getDataForQualityOfConjuredDecreasesTwiceFastAsNormalItem() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 20, 50),
				new Item("Apple", 0, 12),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Banana", 7, 10),
				new Item("Sulfuras, Hand of Ragnaros", 5, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49),
				new Item("Test", 5, 20),
				new Item("Conjured Mana Cake", 5, 20) };
	}
}
