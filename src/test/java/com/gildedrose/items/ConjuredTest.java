package com.gildedrose.items;

import static com.gildedrose.domain.ItemType.COMMON_ITEM;
import static com.gildedrose.domain.ItemType.CONJURED;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class ConjuredTest {

	private CommonItemTest commonItemTest = new CommonItemTest();


	// ======================== BASE TESTS =================================


	//All items have a SellIn value which denotes the number of days we have to sell the item
	@Test
	public void sellInDegredesByOnePerDay() {
		commonItemTest.sellInDegredesByOnePerDay(new Item(CONJURED.getName(), 10,20));
	}

	// The Quality of an item is never negative
	@Test
	public void qualityIsNeverNegative() {
		commonItemTest.qualityIsNeverNegative(new Item(CONJURED.getName(), 10,0));
	}

	// The Quality of an item is never more than 50
	@Test
	public void qualityIsNeverMoreThan50() {
		commonItemTest.qualityIsNeverMoreThan50(new Item(CONJURED.getName(), 10, CommonItemTest.MAX_QUALITY_VALUE));
	}


	// ===================================================================


	// "Conjured" items degrade in Quality twice as fast as normal items
	// override basic behavior of
	//    qualityDegredesTwiceFastWhenSellByDateHasPassed
	@Test
	public void qualityOfConjuredDegradesTwiceFastAsNormalItem() {

		// GIVEN SOME ITEMS
		Item conjured = new Item(CONJURED.getName(), 10,20);
		Item common = new Item(COMMON_ITEM.getName(), 10,20);
		GildedRose app = new GildedRose(new Item[]{conjured});

		int itemQualityBefore = conjured.quality;
		int commonItemQualityBefore = common.quality; // to simulate same values and conditions in the normal way
		// WHEN
		app.updateQuality();
		// THEN
		int commonItemDegrade = commonItemQualityBefore - common.quality;
		int expected = itemQualityBefore - (commonItemDegrade * 2);
		assertEquals(conjured.name, expected, conjured.quality);
	}

}
