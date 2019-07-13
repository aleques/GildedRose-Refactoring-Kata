package com.gildedrose.domain.impl;

import com.gildedrose.Item;
import com.gildedrose.domain.ItemAdapter;
import com.gildedrose.domain.ItemType;

public class ItemBase extends ItemAdapter {

	public ItemBase(Item item, ItemType itemType) {
		super(item, itemType);
	}

	@Override
	public void updateQualityBeforeSellInDecrease() {
		if (getQuality() > 0) {
			decreaseQuality();
		}
	}

	@Override
	public void updateQualityAfterSellInDecrease() {
		if (getSellIn() < 0 && getQuality() > 0) {
			decreaseQuality();
		}
	}

	public ItemBase(Item item) {
		this(item, ItemType.COMMON_ITEM);
	}

}
