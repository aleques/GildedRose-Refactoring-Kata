package com.gildedrose;

import java.util.List;

import com.gildedrose.domain.ItemAdapter;

public class GildedRose {

    private List<ItemAdapter> items;

    public GildedRose(Item[] items) {
        this.items = ItemAdapterFactory.getList(items);
    }

    public void updateQuality() {
        this.items.stream().forEach(item -> item.update());
    }

}