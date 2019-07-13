package com.gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class GildedRoseTest {

	//All items have a SellIn value which denotes the number of days we have to sell the item
	@Test
	public void sellInDegredesByOnePerDay() {

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForSellInDegredesByOnePerDay();
		GildedRose app = new GildedRose(items);

		for (Item item : items) {
			int sellInBefore = item.sellIn;
			// WHEN
			app.updateQuality();
			// THEN
			int expected = sellInBefore - 1;
			assertEquals(item.name, expected, item.sellIn);
		}
	}

	// Once the sell by date has passed, Quality degrades twice as fast
	@Test
	public void qualityDegredesTwiceFastWhenSellByDateHasPassed() {

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityDegredesTwiceFastWhenSellByDateHasPassed();
		GildedRose app = new GildedRose(items);

		for (Item item : items) {
			int qualityBefore = item.quality;
			// WHEN
			app.updateQuality();
			// THEN
			int expected = qualityBefore - 2;
			assertEquals(item.name, expected, item.quality);
		}
	}

	// The Quality of an item is never negative
	@Test
	public void qualityIsNeverNegative() {

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityIsNeverNegative();
		GildedRose app = new GildedRose(items);

		// WHEN
		app.updateQuality();

		for (Item item : items) {
			// THEN
			int expected = Math.max(0, item.quality);
			assertEquals(item.name, expected, item.quality);
		}
	}

	// The Quality of an item is never more than 50
	@Test
	public void qualityIsNeverMoreThan50() {

		final int UNIQUE_QUALITY_VALUE = 50;

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityIsNeverMoreThan50();
		GildedRose app = new GildedRose(items);

		// WHEN
		app.updateQuality();

		for (Item item : items) {
			// THEN
			int expected = Math.min(UNIQUE_QUALITY_VALUE, item.quality);
			assertEquals(item.name, expected, item.quality);
		}
	}

	// "Aged Brie" actually increases in Quality the older it gets
	@Test
	public void qualityOfAgedBrieIncreasesWhenGetOlder() {

		// GIVEN AN AGED BRIE
		Item[] items = TestData.getDataForQualityOfAgedBrieIncreasesWhenGetOlder();
		GildedRose app = new GildedRose(items);
		Item item = items[0];
		int qualityBefore = item.quality;

		// WHEN
		app.updateQuality();
		// THEN
		int expected = Math.max(qualityBefore, item.quality);
		assertEquals(item.name, expected, item.quality);
	}

	// "Sulfuras", being a legendary item, never decreases in Quality
	@Test
	public void qualityOfSulfurasNeverDecreases() {

		// GIVEN A SULFURA
		Item[] items = TestData.getDataForQualityOfSulfurasNeverDecreases();
		GildedRose app = new GildedRose(items);
		Item item = items[0];
		int qualityBefore = item.quality;

		// WHEN
		app.updateQuality();
		// THEN
		int expected = Math.max(qualityBefore, item.quality);
		assertEquals(item.name, expected, item.quality);
	}

	// "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
	@Test
	public void qualityOfSulfurasIsAlways80() {

		final int UNIQUE_QUALITY_VALUE = 80;
		
		// GIVEN A SULFURA
		Item[] items = TestData.getDataForQualityOfSulfurasIsAlways80();
		GildedRose app = new GildedRose(items);
		Item item = items[0];
		// WHEN
		app.updateQuality();
		// THEN
		assertEquals(item.name, UNIQUE_QUALITY_VALUE, item.quality);
	}

	// "Sulfuras", being a legendary item, never has to be sold
	@Test
	public void sellInOfSulfurasNeverDecreases() {

		// GIVEN A SULFURA
		Item[] items = TestData.getDataForSellInOfSulfurasNeverDecreases();
		GildedRose app = new GildedRose(items);
		Item item = items[0];
		int sellInBefore = item.sellIn;
		// WHEN
		app.updateQuality();
		// THEN
		int expected = Math.max(sellInBefore, item.sellIn);
		assertEquals(item.name, expected, item.sellIn);
	}

	// Quality of "Backstage passes" increases by 3 when there are 5 days or less
	@Test
	public void qualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess() {

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess();
		GildedRose app = new GildedRose(items);
		Item item = items[0];
		int qualityBefore = item.quality;
		// WHEN
		app.updateQuality();
		// THEN
		int expected = qualityBefore + 3;
		assertEquals(item.name, expected, item.quality);
	}

	// Quality "Backstage passes" increases by 2 when there are 10 days or less

	/**
	 * @see #qualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess
	 */
	@Test
	public void qualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess() {

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess();
		GildedRose app = new GildedRose(items);
		Item item = items[0];
		int qualityBefore = item.quality;
		// WHEN
		app.updateQuality();
		// THEN
		int expected = qualityBefore + 2;
		assertEquals(item.name, expected, item.quality);
	}

	// Quality drops to 0 after the concert
	@Test
	public void qualityOfBackstagePassesDropsToZeroAfterConcert() {

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityOfBackstagePassesDropsToZeroAfterConcert();
		GildedRose app = new GildedRose(items);
		Item item = items[0];
		// WHEN
		app.updateQuality();
		// THEN
		assertEquals(item.name, 0, item.quality);
	}

	// "Conjured" items degrade in Quality twice as fast as normal items
	/**
	 * @see #qualityDegredesTwiceFastWhenSellByDateHasPassed
	 */
	@Test
	public void qualityOfConjuredDecreasesTwiceFastAsNormalItem() {

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityOfConjuredDecreasesTwiceFastAsNormalItem();
		GildedRose app = new GildedRose(items);
		Item normalItem = items[0];
		Item item = items[1];

		int itemQualityBefore = item.quality;
		int normalItemQualityBefore = normalItem.quality; // to simulate same values and conditions in the normal way
		// WHEN
		app.updateQuality();
		// THEN
		int expected = itemQualityBefore - ((normalItemQualityBefore - normalItem.quality) * 2);
		assertEquals(item.name, expected, item.quality);
	}


	private Item getItem(Item[] items, String itemName) {
		return Arrays.stream(items)
				.filter(item -> item.name.equalsIgnoreCase(itemName))
				.findFirst()
				.get();
	}

}
