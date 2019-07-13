package com.gildedrose.domain;

import java.util.Objects;

import com.gildedrose.Item;

public abstract class ItemAdapter {

	public static final int MAX_QUALITY = 50;

	protected Item item;

	public ItemAdapter(Item item) {
		this.item = item;
		validateItemName(item.name);
	}

	public ItemAdapter(String name, int sellIn, int quality) {
		this(new Item(name, sellIn, quality));
	}

	// ===================================

	public abstract void updateQualityBeforeSellInDecrease();
	public abstract void updateQualityAfterSellInDecrease();
	public abstract ItemType getType();

	// ===================================

	public void update() {

		updateQualityBeforeSellInDecrease();
		decreaseSellIn();
		updateQualityAfterSellInDecrease();
	}
	// ===================================

	public int getMaxQuality() {
		return MAX_QUALITY;
	}

	protected int decreaseSellIn() {
		return --item.sellIn;
	}

	protected int increaseQuality() {
		return ++item.quality;
	}

	protected int decreaseQuality() {
		return --item.quality;
	}

	protected int sumToQuality(int i) {
		item.quality += i;
		return item.quality;
	}

	// ===================================

	public String getName() {
		return item.name;
	}

	public int getSellIn() {
		return item.sellIn;
	}

	public void setSellIn(int sellIn) {
		this.item.sellIn = sellIn;
	}

	public int getQuality() {
		return item.quality;
	}

	public void setQuality(int quality) {
		this.item.quality = quality;
	}

	// ===================================

	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; }
		if (o == null || getClass() != o.getClass()) { return false; }
		ItemAdapter that = (ItemAdapter) o;
		return item.name.equals(that.item.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(item.name);
	}

	// ===================================

	private void validateItemName(String name) {
		if (getType() != ItemType.COMMON_ITEM && !getType().getName().equals(name)) {
			throw new IllegalArgumentException("Invalid name for this item adapter - " + getType().getName());
		}
	}
}
