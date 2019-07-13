package com.gildedrose.domain.impl;

import com.gildedrose.Item;
import com.gildedrose.domain.ItemAdapter;
import com.gildedrose.domain.ItemType;

public class AgedBrie extends ItemAdapter {

	public AgedBrie(Item item) {
		super(item, ItemType.AGED_BRIE);
	}

	@Override
	public void updateQualityBeforeSellInDecrease() {
		if (getQuality() < GENERAL_MAX_QUALITY) {
			increaseQuality();
		}
	}

	@Override
	public void updateQualityAfterSellInDecrease() {
		if (getSellIn() < 0 && getQuality() < GENERAL_MAX_QUALITY) {
			increaseQuality();
		}
	}
}
