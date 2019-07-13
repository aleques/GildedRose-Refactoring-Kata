package com.gildedrose.items;

import static com.gildedrose.domain.ItemType.SULFURAS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class SulfurasTest {

	private CommonItemTest commonItemTest = new CommonItemTest();


	// ======================== BASE TESTS =================================

	// The Quality of an item is never negative
	@Test
	public void qualityIsNeverNegative() {
		commonItemTest.qualityIsNeverNegative(new Item(SULFURAS.getName(), 10,80));
	}

	// ======================================================

	// "Sulfuras", being a legendary item, never decreases in Quality
	// override basic behavior of
	//    qualityDegredesTwiceFastWhenSellByDateHasPassed
	@Test
	public void qualityOfSulfurasNeverDecreases() {

		// GIVEN A SULFURA
		Item item = new Item(SULFURAS.getName(), 5, 80);
		GildedRose app = new GildedRose(new Item[]{item});
		int qualityBefore = item.quality;

		// WHEN
		app.updateQuality();
		// THEN
		assertFalse(item.name, item.quality < qualityBefore);
	}

	// "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
	// override basic behavior of
	//    qualityIsNeverMoreThan50
	@Test
	public void qualityOfSulfurasIsAlways80() {

		final int UNIQUE_QUALITY_VALUE = 80;
		
		// GIVEN A SULFURA
		Item item = new Item(SULFURAS.getName(), 5, 80);
		GildedRose app = new GildedRose(new Item[]{item});
		// WHEN
		app.updateQuality();
		// THEN
		assertEquals(item.name, UNIQUE_QUALITY_VALUE, item.quality);
	}

	// "Sulfuras", being a legendary item, never has to be sold
	// ovveride basic behavior of
	//    sellInDegredesByOnePerDay
	@Test
	public void sellInOfSulfurasNeverDecreases() {

		// GIVEN A SULFURA
		Item item = new Item(SULFURAS.getName(), 5, 80);
		GildedRose app = new GildedRose(new Item[]{item});
		int sellInBefore = item.sellIn;
		// WHEN
		app.updateQuality();
		// THEN
		assertFalse(item.name, item.sellIn < sellInBefore);
	}
}
