package com.gildedrose.domain;

import java.util.Objects;

import com.gildedrose.Item;

public abstract class ItemAdapter {

	public static final int GENERAL_MAX_QUALITY = 50;

	protected Item item;
	protected ItemType itemType;

	public ItemAdapter(Item item) {
		this.item = item;
		this.itemType = ItemType.get(item.name);
	}

	public ItemAdapter(Item item, ItemType itemType) {
		this.item = item;
		this.itemType = itemType;
	}

	public ItemAdapter(String name, int sellIn, int quality) {
		this(new Item(name, sellIn, quality));
	}

	// ===================================

	public abstract void updateQualityBeforeSellInDecrease();
	public abstract void updateQualityAfterSellInDecrease();

	// ===================================

	public void update() {

		updateQualityBeforeSellInDecrease();
		decreaseSellIn();
		updateQualityAfterSellInDecrease();
	}
	// ===================================

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
}
