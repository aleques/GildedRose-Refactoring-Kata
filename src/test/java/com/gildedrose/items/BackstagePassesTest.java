package com.gildedrose.items;

import static com.gildedrose.domain.ItemType.BACKSTAGE_PASSES;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class BackstagePassesTest {

	private CommonItemTest commonItemTest = new CommonItemTest();


	// ======================== BASE TESTS =================================


	//All items have a SellIn value which denotes the number of days we have to sell the item
	@Test
	public void sellInDegredesByOnePerDay() {
		commonItemTest.sellInDegredesByOnePerDay(new Item(BACKSTAGE_PASSES.getName(), 10,20));
	}

	// The Quality of an item is never negative
	@Test
	public void qualityIsNeverNegative() {
		commonItemTest.qualityIsNeverNegative(new Item(BACKSTAGE_PASSES.getName(), 10,0));
	}

	// The Quality of an item is never more than 50
	@Test
	public void qualityIsNeverMoreThan50() {
		commonItemTest.qualityIsNeverMoreThan50(new Item(BACKSTAGE_PASSES.getName(), 10, CommonItemTest.MAX_QUALITY_VALUE));
	}

	// ======================================================

	// Quality "Backstage passes" increases by 3 when there are 5 days or less
	// override basic behavior of
	//    qualityDegredesTwiceFastWhenSellByDateHasPassed
	@Test
	public void qualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess() {

		// GIVEN
		Item item = new Item(BACKSTAGE_PASSES.getName(), 3, 30);
		GildedRose app = new GildedRose(new Item[]{item});
		int qualityBefore = item.quality;
		// WHEN
		app.updateQuality();
		// THEN
		int expected = qualityBefore + 3;
		assertEquals(item.name, expected, item.quality);
	}

	// Quality "Backstage passes" increases by 2 when there are 10 days or less
	@Test
	public void qualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess() {

		// GIVEN
		Item item = new Item(BACKSTAGE_PASSES.getName(), 7, 20);
		GildedRose app = new GildedRose(new Item[]{item});
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
		Item item = new Item(BACKSTAGE_PASSES.getName(), 0, 20);
		GildedRose app = new GildedRose(new Item[]{item});
		// WHEN
		app.updateQuality();
		// THEN
		assertEquals(item.name, 0, item.quality);
	}

}
