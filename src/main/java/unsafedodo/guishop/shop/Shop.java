package unsafedodo.guishop.shop;

import java.util.LinkedList;
import java.util.List;

public class Shop {
    private String name;
    private String itemMaterial;
    private List<ShopItem> items;

    public String getName() {
        return name;
    }

    public List<ShopItem> getItems() {
        return items;
    }

    public String getItemMaterial() {
        return itemMaterial;
    }

    public Shop(String name) {
        this(name, new LinkedList<>(), "minecraft:diamond");
    }

    public Shop(String name, List<ShopItem> items, String ItemMaterial) {
        this.name = name;
        this.items = items;
        this.itemMaterial = ItemMaterial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        return name.equals(shop.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
