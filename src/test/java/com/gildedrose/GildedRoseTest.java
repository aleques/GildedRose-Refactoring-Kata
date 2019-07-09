package com.gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class GildedRoseTest {

	private static final int TOTAL_DAYS = 100;
	private static final String TITTLE_FORMAT = "DAY %d: %s";

	@Test
	public void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("foo", app.items[0].name);
		assertEquals(0, app.items[0].quality); // qualityIsNeverNegative
		assertEquals(-1, app.items[0].sellIn); // sellInDegredesByOnePerDay
	}

	//All items have a SellIn value which denotes the number of days we have to sell the item
	@Test
	public void sellInDegredesByOnePerDay() {

		// GIVEN SOME items
		final Item[] ITEMS_ORIGIN = TestData.getDataForSellInDegredesByOnePerDay();
		Item[] items = TestData.getDataForSellInDegredesByOnePerDay();

		GildedRose app = new GildedRose(items);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			// WHEN
			app.updateQuality();

			for (int i = 0; i < ITEMS_ORIGIN.length; i++) {
				Item item = items[i];
				// THEN
				int expected = ITEMS_ORIGIN[i].sellIn - day;
				assertEquals(getTittle(day, item.name), expected, items[i].sellIn);
			}
		}
	}

	// Once the sell by date has passed, Quality degrades twice as fast
	@Test
	public void qualityDegredesTwiceFastWhenSellByDateHasPassed() {

		// GIVEN SOME items
		final Item[] ITEMS_ORIGIN = TestData.getDataForQualityDegredesTwiceFastWhenSellByDateHasPassed();
		Item[] items = TestData.getDataForQualityDegredesTwiceFastWhenSellByDateHasPassed();

		GildedRose app = new GildedRose(items);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			// WHEN
			app.updateQuality();

			for (int i = 0; i < ITEMS_ORIGIN.length; i++) {
				Item item = items[i];
				int expected = ITEMS_ORIGIN[i].quality - (day*2);
				// THEN
				assertEquals(getTittle(day, item.name), expected, items[i].quality);
			}
		}
	}

	// The Quality of an item is never negative
	@Test
	public void qualityIsNeverNegative() {

		// GIVEN SOME items
		Item[] items = TestData.getDataForQualityIsNeverNegative();
		GildedRose app = new GildedRose(items);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			// WHEN
			app.updateQuality();

			for (int i = 0; i < items.length; i++) {
				Item item = items[i];
				int expected = Math.max(0, items[i].quality);
				// THEN
				assertEquals(getTittle(day, item.name), expected, items[i].quality);
			}
		}
	}

	// The Quality of an item is never more than 50
	@Test
	public void qualityIsNeverMoreThan50() {

		final int UNIQUE_QUALITY_VALUE = 50;
		// GIVEN SOME items
		Item[] items = TestData.getDataForQualityIsNeverMoreThan50();
		GildedRose app = new GildedRose(items);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			// WHEN
			app.updateQuality();

			for (int i = 0; i < items.length; i++) {
				Item item = items[i];
				int expected = Math.min(UNIQUE_QUALITY_VALUE, items[i].quality);
				// THEN
				assertEquals(getTittle(day, item.name), expected, items[i].quality);
			}
		}
	}

	// "Aged Brie" actually increases in Quality the older it gets
	@Test
	public void qualityOfAgedBrieIncreasesWhenGetOlder() {

		final String ITEM_PARTIAL_NAME = "Aged Brie";

		// GIVEN SOME ITEMS
		Item[] itemsOrigin = TestData.getDataForQualityOfAgedBrieIncreasesWhenGetOlder();
		GildedRose app = new GildedRose(itemsOrigin);

		List<Item> items = getItems(itemsOrigin, ITEM_PARTIAL_NAME);
		Map<String, Integer> itemQualityBeforeMap = getItemQualityMap(items);
		Map<String, Integer> itemQualityNowMap = getItemQualityMap(items);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			updateItemQualityMap(itemQualityBeforeMap, items);

			// WHEN
			app.updateQuality();

			updateItemQualityMap(itemQualityNowMap, items);

			for (Item item : items) {

				int qualityBefore = itemQualityBeforeMap.get(item.name);
				int qualityNow = itemQualityNowMap.get(item.name);

				int expected = Math.max(qualityBefore, qualityNow);
				// THEN
				assertEquals(getTittle(day, item.name), expected, qualityNow);
			}

		}
	}

	// "Sulfuras", being a legendary item, never decreases in Quality
	@Test
	public void qualityOfSulfurasNeverDecreases() {

		//final String ITEM_PARTIAL_NAME = "Sulfuras";
		final String ITEM_PARTIAL_NAME = "Sulfuras, Hand of Ragnaros";

		// GIVEN SOME ITEMS
		Item[] itemsOrigin = TestData.getDataForQualityOfSulfurasNeverDecreases();
		GildedRose app = new GildedRose(itemsOrigin);

		List<Item> items = getItems(itemsOrigin, ITEM_PARTIAL_NAME);
		Map<String, Integer> itemQualityBeforeMap = getItemQualityMap(items);
		Map<String, Integer> itemQualityNowMap = getItemQualityMap(items);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			updateItemQualityMap(itemQualityBeforeMap, items);

			// WHEN
			app.updateQuality();

			updateItemQualityMap(itemQualityNowMap, items);

			for (Item item : items) {

				int qualityBefore = itemQualityBeforeMap.get(item.name);
				int qualityNow = itemQualityNowMap.get(item.name);

				int expected = Math.max(qualityBefore, qualityNow);
				// THEN
				assertEquals(getTittle(day, item.name), expected, qualityNow);
			}
		}
	}

	// "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
	@Test
	public void qualityOfSulfurasIsAlways80() {

		//final String ITEM_PARTIAL_NAME = "Sulfuras";
		final String ITEM_PARTIAL_NAME = "Sulfuras, Hand of Ragnaros";
		final int UNIQUE_QUALITY_VALUE = 80;
		
		// GIVEN SOME ITEMS
		Item[] itemsOrigin = TestData.getDataForQualityOfSulfurasIsAlways80();

		GildedRose app = new GildedRose(itemsOrigin);

		List<Item> items = getItems(itemsOrigin, ITEM_PARTIAL_NAME);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			// WHEN
			app.updateQuality();

			for (Item item : items) {
				// THEN
				assertEquals(getTittle(day, item.name), UNIQUE_QUALITY_VALUE, item.quality);
			}
		}
	}

	// "Sulfuras", being a legendary item, never has to be sold
	@Test
	public void sellInOfSulfurasNeverDecreases() {

		//final String ITEM_PARTIAL_NAME = "Sulfuras";
		final String ITEM_PARTIAL_NAME = "Sulfuras, Hand of Ragnaros";

		// GIVEN SOME ITEMS
		Item[] itemsOrigin = TestData.getDataForSellInOfSulfurasNeverDecreases();
		GildedRose app = new GildedRose(itemsOrigin);

		List<Item> items = getItems(itemsOrigin, ITEM_PARTIAL_NAME);
		Map<String, Integer> itemSellInBeforeMap = getItemSellInMap(items);
		Map<String, Integer> itemSellInNowMap = getItemSellInMap(items);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			updateItemSellInMap(itemSellInBeforeMap, items);

			// WHEN
			app.updateQuality();

			updateItemSellInMap(itemSellInNowMap, items);

			for (Item item : items) {

				int sellInBefore = itemSellInBeforeMap.get(item.name);
				int sellInNow = itemSellInNowMap.get(item.name);

				int expected = Math.max(sellInBefore, sellInNow);
				// THEN
				assertEquals(getTittle(day, item.name), expected, sellInNow);
			}
		}
	}

	// Quality of "Backstage passes" increases by 3 when there are 5 days or less
	@Test
	public void qualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess() {

		// final String ITEM_PARTIAL_NAME = "Backstage passes";
		// final String ITEM_PARTIAL_NAME_NOT_ALLOWED = "concert";
		final String ITEM_PARTIAL_NAME = "Backstage passes to a TAFKAL80ETC concert";

		// GIVEN SOME ITEMS
		Item[] itemsOrigin = TestData.getDataForQualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess();
		GildedRose app = new GildedRose(itemsOrigin);

		List<Item> items = getItems(itemsOrigin, ITEM_PARTIAL_NAME);
		Map<String, Integer> itemQualityBeforeMap = getItemQualityMap(items);
		Map<String, Integer> itemQualityNowMap = getItemQualityMap(items);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			updateItemQualityMap(itemQualityBeforeMap, items);

			// WHEN
			app.updateQuality();

			updateItemQualityMap(itemQualityNowMap, items);

			for (Item item : items) {

				if (item.sellIn >= 0) {

					int qualityBefore = itemQualityBeforeMap.get(item.name);
					int qualityNow = itemQualityNowMap.get(item.name);

					int expected = qualityBefore + 3;
					// THEN
					assertEquals(getTittle(day, item.name), expected, qualityNow);
				}
			}
		}
	}

	// Quality "Backstage passes" increases by 2 when there are 10 days or less
	@Test
	public void qualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess() {

		// final String ITEM_PARTIAL_NAME = "Backstage passes";
		// final String ITEM_PARTIAL_NAME_NOT_ALLOWED = "concert";
		final String ITEM_PARTIAL_NAME = "Backstage passes to a TAFKAL80ETC concert";

		// GIVEN SOME ITEMS
		Item[] itemsOrigin = TestData.getDataForQualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess();
		GildedRose app = new GildedRose(itemsOrigin);

		List<Item> items = getItems(itemsOrigin, ITEM_PARTIAL_NAME);
		// items = getItemsNotContaining(items, ITEM_PARTIAL_NAME_NOT_ALLOWED);
		Map<String, Integer> itemQualityBeforeMap = getItemQualityMap(items);
		Map<String, Integer> itemQualityNowMap = getItemQualityMap(items);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			updateItemQualityMap(itemQualityBeforeMap, items);

			// WHEN
			app.updateQuality();

			updateItemQualityMap(itemQualityNowMap, items);

			for (Item item : items) {

				// FIXME - greater than 5 because fall in another condition
				// If this condition dies, this test will not cover all the cases
				if (item.sellIn >= 5) {

					int qualityBefore = itemQualityBeforeMap.get(item.name);
					int qualityNow = itemQualityNowMap.get(item.name);

					int expected = qualityBefore + 2;
					// THEN
					assertEquals(getTittle(day, item.name), expected, qualityNow);
				}
			}
		}
	}

	// Quality drops to 0 after the concert
	@Test
	public void qualityOfBackstagePassesDropsToZeroAfterConcert() {

		final String ITEM_PARTIAL_NAME_1 = "Backstage passes";
		final String ITEM_PARTIAL_NAME_2 = "concert";

		// GIVEN SOME ITEMS
		Item[] itemsOrigin = TestData.getDataForQualityOfBackstagePassesDropsToZeroAfterConcert();
		GildedRose app = new GildedRose(itemsOrigin);

		List<Item> items = getItems(itemsOrigin, ITEM_PARTIAL_NAME_1, ITEM_PARTIAL_NAME_2);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			// WHEN
			app.updateQuality();

			for (Item item : items) {

				if (item.sellIn < 0 ) { // after concert
					// THEN
					assertEquals(getTittle(day, item.name), 0, item.quality);
				}
			}
		}
	}

	private String getTittle(int day, String itemName) {
		return String.valueOf(String.format(TITTLE_FORMAT, day, itemName));
	}

	private List<Item> getItems(Item[] items, String... itemPartialNames) {
		return Arrays.stream(items)
				.filter(item -> Arrays.stream(itemPartialNames)
											 .allMatch(itemName -> item.name.toUpperCase().contains(itemName.toUpperCase())))
				.collect(Collectors.toList());
	}

	private List<Item> getItemsNotContaining(List<Item> items, String... itemPartialNamesNotAllowed) {
		return items.stream()
				.filter(item -> Arrays.stream(itemPartialNamesNotAllowed)
						.anyMatch(itemName -> !item.name.toUpperCase().contains(itemName.toUpperCase())))
				.collect(Collectors.toList());
	}

	private Map<String, Integer> getItemQualityMap(List<Item> items) {
		return items.stream().collect(Collectors.toMap(i-> i.name, i-> i.quality));
	}

	private Map<String, Integer> getItemSellInMap(List<Item> items) {
		return items.stream().collect(Collectors.toMap(i-> i.name, i-> i.sellIn));
	}

	private void updateItemQualityMap(Map<String, Integer> itemQualityMap, List<Item> items) {
		for (Item item : items) {
			itemQualityMap.put(item.name, item.quality);
		}
	}

	private void updateItemSellInMap(Map<String, Integer> itemSellInMap, List<Item> items) {
		for (Item item : items) {
			itemSellInMap.put(item.name, item.sellIn);
		}
	}

}
