package com.gildedrose;

public class TestData {

	public static Item[] getDataForSellInDegredesByOnePerDay() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 20, 50),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				new Item("Conjured Mana Cake", 3, 6) };
	}

	public static Item[] getDataForQualityDegredesTwiceFastWhenSellByDateHasPassed() {
		return new Item[] {new Item("+5 Dexterity Vest", 0, 40)};
	}

	public static Item[] getDataForQualityIsNeverNegative() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 0),
				new Item("Aged Brie", 20, 0),
				new Item("Elixir of the Mongoose", 5, 0),
				new Item("Sulfuras, Hand of Ragnaros", 5, 0),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0),
				new Item("Conjured Mana Cake", 3, 0) };
	}

	public static Item[] getDataForQualityIsNeverMoreThan50() {
		return new Item[] {
				new Item("+5 Dexterity Vest", 10, 50),
				new Item("Aged Brie", 20, 50),
				new Item("Elixir of the Mongoose", 5, 50),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
				new Item("Conjured Mana Cake", 3, 50) };
	}

	public static Item[] getDataForQualityOfAgedBrieIncreasesWhenGetOlder() {
		return new Item[] {new Item("Aged Brie", 20, 50)};
	}

	public static Item[] getDataForQualityOfSulfurasNeverDecreases() {
		return new Item[] {new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
	}

	public static Item[] getDataForQualityOfSulfurasIsAlways80() {
		return new Item[] {new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
	}

	public static Item[] getDataForSellInOfSulfurasNeverDecreases() {
		return new Item[] {new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
	}

	public static Item[] getDataForQualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess() {
		return new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 3)};
	}

	public static Item[] getDataForQualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess() {
		return new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 7, 7)};
	}

	public static Item[] getDataForQualityOfBackstagePassesDropsToZeroAfterConcert() {
		return new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49)};
	}

	public static Item[] getDataForQualityOfConjuredDecreasesTwiceFastAsNormalItem() {
		return new Item[] {new Item("Test", 5, 20),
				new Item("Conjured Mana Cake", 5, 20) };
	}
}
