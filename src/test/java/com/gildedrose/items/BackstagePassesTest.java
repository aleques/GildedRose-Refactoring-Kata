package com.gildedrose.items;

import static com.gildedrose.domain.ItemAdapter.MAX_QUALITY;
import static com.gildedrose.domain.ItemType.BACKSTAGE_PASSES;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.domain.ItemAdapter;

public class BackstagePassesTest {

	private CommonItemTest commonItemTest = new CommonItemTest();

	// ======================== BASE TESTS =================================


	//All items have a SellIn value which denotes the number of days we have to sell the item
	@Test
	public void sellInDegredesByOnePerDay() {
		commonItemTest.sellInDegredesByOnePerDay(new Item(BACKSTAGE_PASSES.getName(), 1,20));
		// EDGE CASE - When someone copy-paste quality rules in the place of SellIn rules
		commonItemTest.sellInDegredesByOnePerDay(new Item(BACKSTAGE_PASSES.getName(), -1,20));
	}

	// The Quality of an item is never more than 50
	@Test
	public void qualityIsNeverMoreThan50() {
		commonItemTest.qualityIsNeverMoreThan50(new Item(BACKSTAGE_PASSES.getName(), 10, MAX_QUALITY));
	}

	@Test
	public void qualityIsNeverMoreThan50EvenWithIncreaseRulesVaryingBetween1And3() {
		commonItemTest.qualityIsNeverMoreThan50(new Item(BACKSTAGE_PASSES.getName(), 15, MAX_QUALITY));
		commonItemTest.qualityIsNeverMoreThan50(new Item(BACKSTAGE_PASSES.getName(), 15,MAX_QUALITY-1));
		commonItemTest.qualityIsNeverMoreThan50(new Item(BACKSTAGE_PASSES.getName(), 7, MAX_QUALITY));
		commonItemTest.qualityIsNeverMoreThan50(new Item(BACKSTAGE_PASSES.getName(), 7,MAX_QUALITY-1));
		commonItemTest.qualityIsNeverMoreThan50(new Item(BACKSTAGE_PASSES.getName(), 7,MAX_QUALITY-2));
		commonItemTest.qualityIsNeverMoreThan50(new Item(BACKSTAGE_PASSES.getName(), -7, MAX_QUALITY));
		commonItemTest.qualityIsNeverMoreThan50(new Item(BACKSTAGE_PASSES.getName(), -7, MAX_QUALITY-1));
		commonItemTest.qualityIsNeverMoreThan50(new Item(BACKSTAGE_PASSES.getName(), -7, MAX_QUALITY-2));
		commonItemTest.qualityIsNeverMoreThan50(new Item(BACKSTAGE_PASSES.getName(), -7, MAX_QUALITY-3));
	}

	// ======================================================

	@Test
	public void qualityOfBackstagePassesIncreasesBy1WhenThereAre11DaysOrMore() {
		qualityOfBackstagePassesIncreasesBy1WhenThereAre11DaysOrMore(new Item(BACKSTAGE_PASSES.getName(), 15, 30));
		// EDGE CASE - SellIn11
		qualityOfBackstagePassesIncreasesBy1WhenThereAre11DaysOrMore(new Item(BACKSTAGE_PASSES.getName(), 11, 30));
	}

	// Quality "Backstage passes" increases by 2 when there are 10 days or less
	@Test
	public void qualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess() {
		qualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess(new Item(BACKSTAGE_PASSES.getName(), 10, 20));
		// EDGE CASE - SellIn6
		qualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess(new Item(BACKSTAGE_PASSES.getName(), 7, 20));
	}

	// Quality "Backstage passes" increases by 3 when there are 5 days or less
	@Test
	public void qualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess() {
		qualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess(new Item(BACKSTAGE_PASSES.getName(), 1, 30));
	}

	// Quality drops to 0 after the concert
	@Test
	public void qualityOfBackstagePassesDropsToZeroAfterConcert() {
		qualityOfBackstagePassesDropsToZeroAfterConcert(new Item(BACKSTAGE_PASSES.getName(), 0, 20));
		// EDGE CASE - QualityIsAlreadyZero
		qualityOfBackstagePassesDropsToZeroAfterConcert(new Item(BACKSTAGE_PASSES.getName(), 0, 0));
	}

	// ==============================================================

	private void qualityOfBackstagePassesIncreasesBy1WhenThereAre11DaysOrMore(Item item) {
		// GIVEN
		GildedRose app = new GildedRose(new Item[]{item});
		int qualityBefore = item.quality;
		// WHEN
		app.updateQuality();
		// THEN
		int expected = qualityBefore + 1;
		assertEquals(item.name, expected, item.quality);
	}

	private void qualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess(Item item) {
		// GIVEN
		GildedRose app = new GildedRose(new Item[]{item});
		int qualityBefore = item.quality;
		// WHEN
		app.updateQuality();
		// THEN
		int expected = qualityBefore + 2;
		assertEquals(item.name, expected, item.quality);
	}

	private void qualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess(Item item) {
		// GIVEN
		GildedRose app = new GildedRose(new Item[]{item});
		int qualityBefore = item.quality;
		// WHEN
		app.updateQuality();
		// THEN
		int expected = qualityBefore + 3;
		assertEquals(item.name, expected, item.quality);
	}

	private void qualityOfBackstagePassesDropsToZeroAfterConcert(Item item) {
		// GIVEN
		GildedRose app = new GildedRose(new Item[]{item});
		// WHEN
		app.updateQuality();
		// THEN
		assertEquals(item.name, 0, item.quality);
	}

}
