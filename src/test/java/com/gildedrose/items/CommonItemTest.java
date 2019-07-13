package com.gildedrose.items;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class CommonItemTest {

	public static final int MAX_QUALITY_VALUE = 50;

	//All items have a SellIn value which denotes the number of days we have to sell the item
	@Test
	public void sellInDegredesByOnePerDay() {
		sellInDegredesByOnePerDay(new Item("+5 Dexterity Vest", 10,20));
	}

	// Once the sell by date has passed, Quality degrades twice as fast
	@Test
	public void qualityDegredesTwiceFastWhenSellByDateHasPassed() {
		qualityDegredesTwiceFastWhenSellByDateHasPassed(new Item("+5 Dexterity Vest", -5,20));
	}

	// The Quality of an item is never negative
	@Test
	public void qualityIsNeverNegative() {
		qualityIsNeverNegative(new Item("+5 Dexterity Vest", 10,0));
	}

	// The Quality of an item is never more than 50
	@Test
	public void qualityIsNeverMoreThan50() {
		qualityIsNeverMoreThan50(new Item("+5 Dexterity Vest", 10, MAX_QUALITY_VALUE));
	}

	// =======================================================================================

	public void sellInDegredesByOnePerDay(Item item) {

		// GIVEN
		GildedRose app = new GildedRose(new Item[]{item});
		int sellInBefore = item.sellIn;

		// WHEN
		app.updateQuality();

		// THEN
		int expected = sellInBefore - 1;
		assertEquals(item.name, expected, item.sellIn);
	}

	public void qualityDegredesTwiceFastWhenSellByDateHasPassed(Item item) {

		// GIVEN
		GildedRose app = new GildedRose(new Item[]{item});
		int qualityBefore = item.quality;

		// WHEN
		app.updateQuality();

		// THEN
		int expected = qualityBefore - 2;
		assertEquals(item.name, expected, item.quality);
	}

	public void qualityIsNeverNegative(Item item) {

		// GIVEN
		GildedRose app = new GildedRose(new Item[]{item});

		// WHEN
		app.updateQuality();

		// THEN
		assertFalse(item.name, item.quality < 0);
	}

	public void qualityIsNeverMoreThan50(Item item) {

		// GIVEN
		GildedRose app = new GildedRose(new Item[]{item});

		// WHEN
		app.updateQuality();

		// THEN
		assertFalse(item.name, item.quality > 50);
	}

}
