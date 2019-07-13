package com.gildedrose.items;

import static com.gildedrose.domain.ItemAdapter.MAX_QUALITY;
import static com.gildedrose.domain.ItemType.AGED_BRIE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class AgedBrieTest {

	private CommonItemTest commonItemTest = new CommonItemTest();


	// ======================== BASE TESTS =================================


	//All items have a SellIn value which denotes the number of days we have to sell the item
	@Test
	public void sellInDegredesByOnePerDay() {
		commonItemTest.sellInDegredesByOnePerDay(new Item(AGED_BRIE.getName(), 1,20));
		// EDGE CASE - When someone copy-paste quality rules in the place of SellIn rules
		commonItemTest.sellInDegredesByOnePerDay(new Item(AGED_BRIE.getName(), -1,20));
	}

	// The Quality of an item is never more than 50
	@Test
	public void qualityIsNeverMoreThan50() {
		commonItemTest.qualityIsNeverMoreThan50(new Item(AGED_BRIE.getName(), 1, MAX_QUALITY));
		// EDGE CASE - SellInIsNegativeAndQualityIsMaximum
		commonItemTest.qualityIsNeverMoreThan50(new Item(AGED_BRIE.getName(), -1, MAX_QUALITY));
		// EDGE CASE - SellInIsZeroAndQualityIsMaximum
		commonItemTest.qualityIsNeverMoreThan50(new Item(AGED_BRIE.getName(), 0, MAX_QUALITY));
		// EDGE CASE - SellInIsPositiveAndQualityIsMaximumMinusOne
		commonItemTest.qualityIsNeverMoreThan50(new Item(AGED_BRIE.getName(), 1, MAX_QUALITY-1));
		// EDGE CASE - SellInIsNegativeAndQualityIsMaximumMinusOne
		commonItemTest.qualityIsNeverMoreThan50(new Item(AGED_BRIE.getName(), -1, MAX_QUALITY-1));
		// EDGE CASE - SellInIsZeroAndQualityIsMaximumMinusOne
		commonItemTest.qualityIsNeverMoreThan50(new Item(AGED_BRIE.getName(), 0, MAX_QUALITY-1));

	}

	// ============ AGED BRIE =====================================

	// "Aged Brie" actually increases in Quality the older it gets
	@Test
	public void qualityOfAgedBrieIncreasesWhenGetOlder() {
		qualityOfAgedBrieIncreasesWhenGetOlder(new Item(AGED_BRIE.getName(), 20, 40));
		// EDGE CASE - SellInIsNegative
		qualityOfAgedBrieIncreasesWhenGetOlder(new Item(AGED_BRIE.getName(), -20, 40));
	}

	// =============================================================

	private void qualityOfAgedBrieIncreasesWhenGetOlder(Item item) {

		// GIVEN AN AGED BRIE
		GildedRose app = new GildedRose(new Item[]{item});
		int qualityBefore = item.quality;

		// WHEN
		app.updateQuality();
		// THEN
		int expected = Math.max(qualityBefore, item.quality);
		assertEquals(item.name, expected, item.quality);
	}
}
