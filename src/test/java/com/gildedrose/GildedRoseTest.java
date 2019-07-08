package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    //All items have a SellIn value which denotes the number of days we have to sell the item
    @Test
    public void sellInDegredesByOnePerDay() {
        fail();
    }

    // Once the sell by date has passed, Quality degrades twice as fast
    @Test
    public void qualityDegredesTwiceFastWhenSellByDateHasPassed() {
        fail();
    }

    // The Quality of an item is never negative
    @Test
    public void qualityIsNeverNegative() {
        fail();
    }

    // The Quality of an item is never more than 50
    @Test
    public void qualityIsNeverMoreThan50() {
        fail();
    }

    // "Aged Brie" actually increases in Quality the older it gets
    @Test
    public void qualityOfAgedBrieIncreasesWhenGetOlder() {
        fail();
    }

    // "Sulfuras", being a legendary item, never decreases in Quality
    @Test
    public void qualityOfSulfurasNeverDecreases() {
        fail();
    }

    // "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
    @Test
    public void qualityOfSulfurasIsAlways80() {
        fail();
    }

    // Quality of "Backstage passes" increases by 3 when there are 5 days or less
    @Test
    public void qualityOfBackstageIncreasesBy3WhenThereAre5DaysOrLess() {
        fail();
    }

    // Quality "Backstage passes" increases by 2 when there are 10 days or less
    @Test
    public void qualityOfBackstageIncreasesBy2WhenThereAre10DaysOrLess() {
        fail();
    }

    // Quality drops to 0 after the concert
    @Test
    public void qualityOfBackstageDropsToZeroAfterConcert() {
        fail();
    }

}
