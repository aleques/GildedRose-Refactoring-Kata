package com.gildedrose.domain.impl;

import com.gildedrose.Item;
import com.gildedrose.domain.ItemType;

public class AgedBrie extends CommonItem {

	public AgedBrie(Item item) {
		super(item);
	}

	@Override
	public void updateQualityBeforeSellInDecrease() {
		if (getQuality() < getMaxQuality()) {
			increaseQuality();
		}
	}

	@Override
	public void updateQualityAfterSellInDecrease() {
		if (getSellIn() < 0 && getQuality() < getMaxQuality()) {
			increaseQuality();
		}
	}

	@Override
	public ItemType getType() {
		return ItemType.AGED_BRIE;
	}
}
