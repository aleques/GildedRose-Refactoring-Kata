package com.gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class GildedRoseTest {

	private static final int TOTAL_DAYS = 100;
	private static final String TITTLE_FORMAT = "DAY %d: %s";

	//All items have a SellIn value which denotes the number of days we have to sell the item
	@Test
	public void sellInDegredesByOnePerDay() {

		// GIVEN SOME ITEMS
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

		// GIVEN SOME ITEMS
		final Item[] ITEMS_ORIGIN = TestData.getDataForQualityDegredesTwiceFastWhenSellByDateHasPassed();
		Item[] items = TestData.getDataForQualityDegredesTwiceFastWhenSellByDateHasPassed();
		GildedRose app = new GildedRose(items);
		Item item;
		int expected;

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			// WHEN
			app.updateQuality();

			for (int i = 0; i < ITEMS_ORIGIN.length; i++) {
				item = items[i];
				expected = ITEMS_ORIGIN[i].quality - (day*2);
				// THEN
				assertEquals(getTittle(day, item.name), expected, items[i].quality);
			}
		}
	}

	// The Quality of an item is never negative
	@Test
	public void qualityIsNeverNegative() {

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityIsNeverNegative();
		GildedRose app = new GildedRose(items);
		Item item;
		int expected;

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			// WHEN
			app.updateQuality();

			for (int i = 0; i < items.length; i++) {
				item = items[i];
				expected = Math.max(0, items[i].quality);
				// THEN
				assertEquals(getTittle(day, item.name), expected, items[i].quality);
			}
		}
	}

	// The Quality of an item is never more than 50
	@Test
	public void qualityIsNeverMoreThan50() {

		final int UNIQUE_QUALITY_VALUE = 50;

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityIsNeverMoreThan50();
		GildedRose app = new GildedRose(items);
		Item item;
		int expected;

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			// WHEN
			app.updateQuality();

			for (int i = 0; i < items.length; i++) {
				item = items[i];
				expected = Math.min(UNIQUE_QUALITY_VALUE, items[i].quality);
				// THEN
				assertEquals(getTittle(day, item.name), expected, items[i].quality);
			}
		}
	}

	// "Aged Brie" actually increases in Quality the older it gets
	@Test
	public void qualityOfAgedBrieIncreasesWhenGetOlder() {

		final String ITEM_NAME = "Aged Brie";

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityOfAgedBrieIncreasesWhenGetOlder();
		GildedRose app = new GildedRose(items);

		Item item = getItem(items, ITEM_NAME);
		int qualityBefore;
		int qualityNow;

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			qualityBefore = item.quality;

			// WHEN
			app.updateQuality();

			qualityNow = item.quality;
			int expected = Math.max(qualityBefore, qualityNow);
			// THEN
			assertEquals(getTittle(day, item.name), expected, qualityNow);
		}
	}

	// "Sulfuras", being a legendary item, never decreases in Quality
	@Test
	public void qualityOfSulfurasNeverDecreases() {

		final String ITEM_NAME = "Sulfuras, Hand of Ragnaros";

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityOfSulfurasNeverDecreases();
		GildedRose app = new GildedRose(items);
		Item item = getItem(items, ITEM_NAME);
		int qualityBefore;
		int qualityNow;

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			qualityBefore = item.quality;

			// WHEN
			app.updateQuality();

			qualityNow = item.quality;
			int expected = Math.max(qualityBefore, qualityNow);
			// THEN
			assertEquals(getTittle(day, item.name), expected, qualityNow);
		}
	}

	// "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
	@Test
	public void qualityOfSulfurasIsAlways80() {

		final String ITEM_NAME = "Sulfuras, Hand of Ragnaros";
		final int UNIQUE_QUALITY_VALUE = 80;
		
		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityOfSulfurasIsAlways80();
		GildedRose app = new GildedRose(items);
		Item item = getItem(items, ITEM_NAME);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {
			// WHEN
			app.updateQuality();
			// THEN
			assertEquals(getTittle(day, item.name), UNIQUE_QUALITY_VALUE, item.quality);
		}
	}

	// "Sulfuras", being a legendary item, never has to be sold
	@Test
	public void sellInOfSulfurasNeverDecreases() {

		final String ITEM_NAME = "Sulfuras, Hand of Ragnaros";

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForSellInOfSulfurasNeverDecreases();
		GildedRose app = new GildedRose(items);
		Item item = getItem(items, ITEM_NAME);
		int sellInBefore;
		int sellInNow;

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			sellInBefore = item.sellIn;

			// WHEN
			app.updateQuality();
			sellInNow = item.sellIn;
			int expected = Math.max(sellInBefore, sellInNow);
			// THEN
			assertEquals(getTittle(day, item.name), expected, sellInNow);
		}
	}

	// Quality of "Backstage passes" increases by 3 when there are 5 days or less
	@Test
	public void qualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess() {

		final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";
		final int END_DAY = 5;

		// GIVEN SOME ITEMS
		Item[] itemsOrigin = TestData.getDataForQualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess();
		GildedRose app = new GildedRose(itemsOrigin);
		Item item = getItem(itemsOrigin, ITEM_NAME);
		int qualityBefore;
		int qualityNow;

		// THROUGHOUT THE DAYS
		for(int day=1; day <= END_DAY; day++) {

			qualityBefore = item.quality;

			// WHEN
			app.updateQuality();

			qualityNow = item.quality;
			int expected = qualityBefore + 3;
			// THEN
			assertEquals(getTittle(day, item.name), expected, qualityNow);
		}
	}

	// Quality "Backstage passes" increases by 2 when there are 10 days or less

	/**
	 * @see #qualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess
	 */
	@Test
	public void qualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess() {

		final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";
		final int END_DAY = 5; // 5 = (10-5) of other test described on javadoc of this method

		// GIVEN SOME ITEMS
		Item[] itemsOrigin = TestData.getDataForQualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess();
		GildedRose app = new GildedRose(itemsOrigin);

		Item item = getItem(itemsOrigin, ITEM_NAME);
		int qualityBefore;
		int qualityNow;

		// THROUGHOUT THE DAYS
		for(int day=1; day <= END_DAY; day++) {

			qualityBefore = item.quality;

			// WHEN
			app.updateQuality();

			qualityNow = item.quality;
			int expected = qualityBefore + 2;
			// THEN
			assertEquals(getTittle(day, item.name), expected, qualityNow);
		}
	}

	// Quality drops to 0 after the concert
	@Test
	public void qualityOfBackstagePassesDropsToZeroAfterConcert() {

		final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityOfBackstagePassesDropsToZeroAfterConcert();
		GildedRose app = new GildedRose(items);
		Item item = getItem(items, ITEM_NAME);

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {

			// WHEN
			app.updateQuality();

			// THEN
			assertEquals(getTittle(day, item.name), 0, item.quality);
		}
	}

	// "Conjured" items degrade in Quality twice as fast as normal items
	/**
	 * @see #qualityDegredesTwiceFastWhenSellByDateHasPassed
	 */
	@Test
	public void qualityOfConjuredDecreasesTwiceFastAsNormalItem() {

		final String ITEM_NAME = "Conjured Mana Cake";
		final String NORMAL_ITEM_NAME = "Test";

		// GIVEN SOME ITEMS
		Item[] items = TestData.getDataForQualityOfConjuredDecreasesTwiceFastAsNormalItem();
		GildedRose app = new GildedRose(items);
		Item item = getItem(items, ITEM_NAME);
		Item normalItem = getItem(items, NORMAL_ITEM_NAME);
		int itemQualityBefore;
		int normalItemQualityBefore;
		int expected;

		// THROUGHOUT THE DAYS
		for(int day=1; day <= TOTAL_DAYS; day++) {
			itemQualityBefore = item.quality;
			// to simulate same values and conditions in the normal way
			normalItem.sellIn = item.sellIn;
			normalItem.quality = item.quality;
			normalItemQualityBefore = item.quality;
			// WHEN
			app.updateQuality();

			expected = itemQualityBefore - ((normalItemQualityBefore - normalItem.quality) * 2);
			// THEN
			assertEquals(getTittle(day, item.name), expected, item.quality);
		}
	}

	private String getTittle(int day, String itemName) {
		return String.valueOf(String.format(TITTLE_FORMAT, day, itemName));
	}

	private Item getItem(Item[] items, String itemName) {
		return Arrays.stream(items)
				.filter(item -> item.name.equalsIgnoreCase(itemName))
				.findFirst()
				.get();
	}

}
