package com.gildedrose.items;

import static com.gildedrose.domain.ItemType.CONJURED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.domain.ItemAdapter;

public class ConjuredTest {

	private CommonItemTest commonItemTest = new CommonItemTest();


	// ======================== BASE TESTS =================================


	//All items have a SellIn value which denotes the number of days we have to sell the item
	@Test
	public void sellInDegredesByOnePerDay() {
		commonItemTest.sellInDegredesByOnePerDay(new Item(CONJURED.getName(), 1,20));
		// EDGE CASE - When someone copy-paste quality rules in the place of SellIn rules
		commonItemTest.sellInDegredesByOnePerDay(new Item(CONJURED.getName(), -1,20));
	}

	// Once the sell by date has passed, Quality degrades twice as fast
	@Test
	public void qualityDegredesTwiceFastWhenSellByDateHasPassed() {
		qualityDegredesTwiceFastWhenSellByDateHasPassed(new Item(CONJURED.getName(), -5,20));
		// EDGE CASE - SellInIsZeroAndQualityIsPositive
		qualityDegredesTwiceFastWhenSellByDateHasPassed(new Item(CONJURED.getName(), 0,20));
	}

	// The Quality of an item is never negative
	@Test
	public void qualityIsNeverNegative() {
		commonItemTest.qualityIsNeverNegative(new Item(CONJURED.getName(), 10,0));
		// EDGE CASE - SellInZero
		commonItemTest.qualityIsNeverNegative(new Item(CONJURED.getName(), 0,0));
		// EDGE CASE - SellInNegative
		commonItemTest.qualityIsNeverNegative(new Item(CONJURED.getName(), -1,0));
	}

	@Test
	public void qualityIsNeverNegativeEvenWhenQualityDegradesTwiceFast() {
		// EDGE CASE - SellInIsZeroAndQualityIsZero
		commonItemTest.qualityIsNeverNegative(new Item(CONJURED.getName(), 0,0));
		// EDGE CASE - SellInIsZeroAndQualityIsOne
		commonItemTest.qualityIsNeverNegative(new Item(CONJURED.getName(), 0,1));
		// EDGE CASE - SellInIsZeroAndQualityIsTwo
		commonItemTest.qualityIsNeverNegative(new Item(CONJURED.getName(), 0,2));
		// EDGE CASE - SellInIsZeroAndQualityIsThree
		commonItemTest.qualityIsNeverNegative(new Item(CONJURED.getName(), 0,3));
		// EDGE CASE - SellInIsZeroOrLessAndQualityIsTwo
		commonItemTest.qualityIsNeverNegative(new Item(CONJURED.getName(), -2,2));
		// EDGE CASE - SellInIsZeroOrLessAndQualityIsThree
		commonItemTest.qualityIsNeverNegative(new Item(CONJURED.getName(), -5,3));

	}

	// ============================= OTHER CASES =============================================

	@Test
	public void qualityDegredesByTwoPerDay() {
		qualityDegredesByTwoPerDay(new Item(CONJURED.getName(), 2,20));
	}

	// =======================================================================================


	public void qualityDegredesTwiceFastWhenSellByDateHasPassed(Item item) {

		// GIVEN
		GildedRose app = new GildedRose(new Item[]{item});
		int qualityBefore = item.quality;

		// WHEN
		app.updateQuality();

		// THEN
		int expected = qualityBefore - 4;
		assertEquals(item.name, expected, item.quality);
	}

	public void qualityDegredesByTwoPerDay(Item item) {

		// GIVEN
		GildedRose app = new GildedRose(new Item[]{item});
		int qualityBefore = item.quality;

		// WHEN
		app.updateQuality();

		// THEN
		int expected = qualityBefore - 2;
		assertEquals(item.name, expected, item.quality);
	}

	// =============================================================



}
