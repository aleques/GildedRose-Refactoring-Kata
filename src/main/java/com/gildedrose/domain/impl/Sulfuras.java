package com.gildedrose.domain.impl;

import com.gildedrose.Item;
import com.gildedrose.domain.ItemType;

public class Sulfuras extends CommonItem {

	public static int SULFURAS_MAX_QUALITY = 80;

	public Sulfuras(Item item) {
		super(item);
	}

	@Override
	public void updateQualityBeforeSellInDecrease() {
	}

	@Override
	public void updateQualityAfterSellInDecrease() {
	}

	@Override
	public void update() {
	}

	@Override
	protected int decreaseSellIn() {
		return getSellIn();
	}

	@Override
	public int getMaxQuality() {
		return SULFURAS_MAX_QUALITY;
	}

	@Override
	public ItemType getType() {
		return ItemType.SULFURAS;
	}
}
