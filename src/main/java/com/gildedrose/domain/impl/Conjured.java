package com.gildedrose.domain.impl;

import com.gildedrose.Item;
import com.gildedrose.domain.ItemType;

public class Conjured extends ItemBase {

	public Conjured(Item item) {
		super(item, ItemType.CONJURED);
	}

	@Override
	public void updateQuality() {
		int qualityBefore = getQuality();
		super.updateQuality(); // general behavior
		int qualityIncreaseAmount = getQuality() - qualityBefore;
		sumToQuality(qualityIncreaseAmount); // twice general behavior
	}
}
