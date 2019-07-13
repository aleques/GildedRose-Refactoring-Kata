package com.gildedrose.domain.impl;

import com.gildedrose.Item;
import com.gildedrose.domain.ItemAdapter;
import com.gildedrose.domain.ItemType;

public class BackstagePasses extends ItemAdapter {

	public BackstagePasses(Item item) {
		super(item, ItemType.BACKSTAGE_PASSES);
	}

	@Override
	public void updateQualityBeforeSellInDecrease() {
		if (getQuality() < GENERAL_MAX_QUALITY) {
			increaseQuality();
			if (getSellIn() < 11 && getQuality() < GENERAL_MAX_QUALITY) {
				increaseQuality();
			}
			if (getSellIn() < 6 && getQuality() < GENERAL_MAX_QUALITY) {
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
}
