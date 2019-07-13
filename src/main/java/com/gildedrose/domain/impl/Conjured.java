package com.gildedrose.domain.impl;

import com.gildedrose.Item;
import com.gildedrose.domain.ItemType;

public class Conjured extends ItemBase {

	public Conjured(Item item) {
		super(item, ItemType.CONJURED);
	}

	@Override
	public void update() {
		int qualityBefore = getQuality();
		super.update(); // general behavior
		int qualityIncreaseAmount = getQuality() - qualityBefore;
		sumToQuality(qualityIncreaseAmount); // twice general behavior
	}
}
