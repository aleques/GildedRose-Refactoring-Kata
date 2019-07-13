package com.gildedrose.items;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class CommonItemTest {

	// All items have a SellIn value which denotes the number of days we have to sell the item
	@Test
	public void sellInDegredesByOnePerDay() {
		sellInDegredesByOnePerDay(new Item("+5 Dexterity Vest", 1,20));
		// EDGE CASE - When someone copy-paste quality rules in the place of SellIn rules
		sellInDegredesByOnePerDay(new Item("+5 Dexterity Vest", -1,20));
	}

	// Once the sell by date has passed, Quality degrades twice as fast
	@Test
	public void qualityDegredesTwiceFastWhenSellByDateHasPassed() {
		qualityDegredesTwiceFastWhenSellByDateHasPassed(new Item("+5 Dexterity Vest", -5,20));
		// EDGE CASE - SellInIsZeroAndQualityIsPositive
		qualityDegredesTwiceFastWhenSellByDateHasPassed(new Item("+5 Dexterity Vest", 0,20));
	}

	// The Quality of an item is never negative
	@Test
	public void qualityIsNeverNegative() {
		qualityIsNeverNegative(new Item("+5 Dexterity Vest", 10,0));
		// EDGE CASE - SellInZero
		qualityIsNeverNegative(new Item("+5 Dexterity Vest", 0,0));
		// EDGE CASE - SellInNegative
		qualityIsNeverNegative(new Item("+5 Dexterity Vest", -1,0));
	}

	@Test
	public void qualityIsNeverNegativeEvenWhenQualityDegradesTwiceFast() {
		// EDGE CASE - SellInIsNegativeAndQualityIsOne
		qualityIsNeverNegative(new Item("+5 Dexterity Vest", -1,1));
		// EDGE CASE - SellInIsNegativeAndQualityIsZero
		qualityIsNeverNegative(new Item("+5 Dexterity Vest", -1,0));
		// EDGE CASE - SellInIsZeroAndQualityIsOne
		qualityIsNeverNegative(new Item("+5 Dexterity Vest", 0,1));
		// EDGE CASE - SellInIsZeroAndQualityIsZero
		qualityIsNeverNegative(new Item("+5 Dexterity Vest", 0,0));
	}

	// ============================= OTHER CASES =============================================

	@Test
	public void qualityDegredesByOnePerDay() {
		qualityDegredesByOnePerDay(new Item("+5 Dexterity Vest", 1,20));
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

	public void qualityDegredesByOnePerDay(Item item) {

		// GIVEN
		GildedRose app = new GildedRose(new Item[]{item});
		int qualityBefore = item.quality;

		// WHEN
		app.updateQuality();

		// THEN
		int expected = qualityBefore - 1;
		assertEquals(item.name, expected, item.quality);
	}

	// The Quality of an item is never more than 50
	// This condition make sense to other items
	public void qualityIsNeverMoreThan50(Item item) {

		// GIVEN
		GildedRose app = new GildedRose(new Item[]{item});

		// WHEN
		app.updateQuality();

		// THEN
		assertFalse(item.name, item.quality > 50);
	}

}
