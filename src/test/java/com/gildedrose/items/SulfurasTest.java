package com.gildedrose.items;

import static com.gildedrose.domain.ItemType.SULFURAS;
import static com.gildedrose.domain.impl.Sulfuras.SULFURAS_MAX_QUALITY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class SulfurasTest {

	// "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
	// "Sulfuras", being a legendary item, never decreases in Quality
	@Test
	public void qualityOfSulfurasIsAlways80() {
		qualityOfSulfurasIsAlways80(new Item(SULFURAS.getName(), 1, SULFURAS_MAX_QUALITY));
		// EDGE CASE - SellInIsZero
		qualityOfSulfurasIsAlways80(new Item(SULFURAS.getName(), 0, SULFURAS_MAX_QUALITY));
		// EDGE CASE - SellInIsNgative
		qualityOfSulfurasIsAlways80(new Item(SULFURAS.getName(), -1, SULFURAS_MAX_QUALITY));
	}

	// "Sulfuras", being a legendary item, never has to be sold
	@Test
	public void sellInOfSulfurasNeverDecreases() {
		sellInOfSulfurasNeverDecreases(new Item(SULFURAS.getName(), 1, SULFURAS_MAX_QUALITY));
		// EDGE CASE - SellInIsZero
		sellInOfSulfurasNeverDecreases(new Item(SULFURAS.getName(), 0, SULFURAS_MAX_QUALITY));
		// EDGE CASE - SellInIsNgative
		sellInOfSulfurasNeverDecreases(new Item(SULFURAS.getName(), -1, SULFURAS_MAX_QUALITY));
	}

	// =============================================================

	private void qualityOfSulfurasIsAlways80(Item item) {
		// GIVEN A SULFURA
		GildedRose app = new GildedRose(new Item[]{item});
		// WHEN
		app.updateQuality();
		// THEN
		assertEquals(item.name, SULFURAS_MAX_QUALITY, item.quality);
	}

	private void sellInOfSulfurasNeverDecreases(Item item) {
		// GIVEN A SULFURA
		GildedRose app = new GildedRose(new Item[]{item});
		int sellInBefore = item.sellIn;
		// WHEN
		app.updateQuality();
		// THEN
		assertFalse(item.name, item.sellIn < sellInBefore);
	}
}
