package com.gildedrose.items;

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
		commonItemTest.sellInDegredesByOnePerDay(new Item(AGED_BRIE.getName(), 10,20));
	}

	// The Quality of an item is never negative
	@Test
	public void qualityIsNeverNegative() {
		commonItemTest.qualityIsNeverNegative(new Item(AGED_BRIE.getName(), 10,0));
	}

	// The Quality of an item is never more than 50
	@Test
	public void qualityIsNeverMoreThan50() {
		commonItemTest.qualityIsNeverMoreThan50(new Item(AGED_BRIE.getName(), 10, CommonItemTest.MAX_QUALITY_VALUE));
	}


	// ======================================================


	// "Aged Brie" actually increases in Quality the older it gets
	// override basic behavior of
	//    qualityDegredesTwiceFastWhenSellByDateHasPassed
	@Test
	public void qualityOfAgedBrieIncreasesWhenGetOlder() {

		// GIVEN AN AGED BRIE
		Item item = new Item(AGED_BRIE.getName(), 20, 40);
		GildedRose app = new GildedRose(new Item[]{item});
		int qualityBefore = item.quality;

		// WHEN
		app.updateQuality();
		// THEN
		int expected = Math.max(qualityBefore, item.quality);
		assertEquals(item.name, expected, item.quality);
	}
}
