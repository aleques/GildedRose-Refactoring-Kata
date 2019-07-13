package com.gildedrose.domain.impl;

import com.gildedrose.Item;
import com.gildedrose.domain.ItemType;

public class Conjured extends CommonItem {

	public Conjured(Item item) {
		super(item);
	}

	@Override
	public void update() {
		int qualityBefore = getQuality();
		super.update(); // default common item behavior
		int qualityDiff = qualityBefore - getQuality();

		// twice general behavior
		int qualityFinal = getQuality() - Math.abs(qualityDiff);// twice general behavior
		setQuality(qualityFinal < 0 ? 0 : qualityFinal); // quality never negative
	}

	@Override
	public ItemType getType() {
		return ItemType.CONJURED;
	}
}
