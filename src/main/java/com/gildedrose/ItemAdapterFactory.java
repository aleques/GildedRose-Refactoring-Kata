package com.gildedrose;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gildedrose.domain.impl.AgedBrie;
import com.gildedrose.domain.impl.BackstagePasses;
import com.gildedrose.domain.impl.ItemBase;
import com.gildedrose.domain.impl.Conjured;
import com.gildedrose.domain.ItemAdapter;
import com.gildedrose.domain.ItemType;
import com.gildedrose.domain.impl.Sulfuras;

public class ItemAdapterFactory {

	public static List<ItemAdapter> getList(Item[] itemList) {
		return Stream.of(itemList)
				.map(item -> getInstance(item))
				.collect(Collectors.toList());
	}

	private static ItemAdapter getInstance(Item item) {

		ItemType itemType = ItemType.get(item.name);

		switch (itemType) {
		case AGED_BRIE:
			return new AgedBrie(item);
		case SULFURAS:
			return new Sulfuras(item);
		case BACKSTAGE_PASSES:
			return new BackstagePasses(item);
		case CONJURED:
			return new Conjured(item);
		default:
			return new ItemBase(item);
		}
	}
}
