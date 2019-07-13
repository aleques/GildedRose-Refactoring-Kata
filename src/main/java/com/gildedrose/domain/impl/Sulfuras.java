package com.gildedrose.domain.impl;

import com.gildedrose.Item;
import com.gildedrose.domain.ItemAdapter;
import com.gildedrose.domain.ItemType;

public class Sulfuras extends ItemAdapter {

	public Sulfuras(Item item) {
		super(item, ItemType.SULFURAS);
	}

	@Override
	public void updateQualityBeforeSellInDecrease() {
	}

	@Override
	public void updateQualityAfterSellInDecrease() {
	}

	@Override
	public void update() {
		// nothing
	}

	@Override
	protected int decreaseSellIn() {
		return getSellIn();
	}
}
