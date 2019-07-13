package com.gildedrose.domain.impl;

import com.gildedrose.Item;
import com.gildedrose.domain.ItemAdapter;
import com.gildedrose.domain.ItemType;

public class CommonItem extends ItemAdapter {

	public CommonItem(Item item) {
		super(item);
	}

	@Override
	public void updateQualityBeforeSellInDecrease() {
		if (isQualityNonNegative()) {
			decreaseQuality();
		}
	}

	@Override
	public void updateQualityAfterSellInDecrease() {
		if (getSellIn() < 0 && isQualityNonNegative()) {
			decreaseQuality();
		}
	}

	@Override
	public ItemType getType() {
		return ItemType.COMMON_ITEM;
	}

	private boolean isQualityNonNegative() {
		return getQuality() > 0;
	}

}
