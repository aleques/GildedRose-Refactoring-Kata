package com.gildedrose.domain.impl;

import com.gildedrose.Item;
import com.gildedrose.domain.ItemType;

public class BackstagePasses extends CommonItem {

	public BackstagePasses(Item item) {
		super(item);
	}

	@Override
	public void updateQualityBeforeSellInDecrease() {
		if (getQuality() < getMaxQuality()) {
			increaseQuality();
			if (getSellIn() < 11 && getQuality() < getMaxQuality()) {
				increaseQuality();
			}
			if (getSellIn() < 6 && getQuality() < getMaxQuality()) {
				increaseQuality();
			}
		}
	}

	@Override
	public void updateQualityAfterSellInDecrease() {
		if (getSellIn() < 0) {
			setQuality(0);
		}
	}

	@Override
	public ItemType getType() {
		return ItemType.BACKSTAGE_PASSES;
	}
}
