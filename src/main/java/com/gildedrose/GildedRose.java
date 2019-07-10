package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {

            switch (item.name) {

            case "Aged Brie":
                updateQualityAgedBrie(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                updateQualitySulfuras(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateQualityBackstagePasses(item);
                break;
            case "Conjured Mana Cake":
                updateQualityConjured(item);
                break;
            default:
                updateQualityGeneral(item);
            }
        }
    }

    private void updateQualityAgedBrie(Item item) {

        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void updateQualitySulfuras(Item item) {
    }

    private void updateQualityBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11 && item.quality < 50) {
                item.quality = item.quality + 1;
            }

            if (item.sellIn < 6 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = item.quality - item.quality;
        }
    }

    // This should be twice as normal
    private void updateQualityConjured(Item item) {

        int decreaseConjured = 0;

        if (item.quality > 0) {
            item.quality = item.quality - 1;
            decreaseConjured++;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
            decreaseConjured++;
        }

        item.quality -= decreaseConjured; // twice as normal

    }

    private void updateQualityGeneral(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

}