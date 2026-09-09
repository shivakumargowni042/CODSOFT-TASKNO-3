package src;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Cart {
    private final Map<Long, CartItem> items = new ConcurrentHashMap<>();

    public void addItem(Product product) {
        items.merge(product.getId(),
            new CartItem(product, 1),
            (existing, newVal) -> {
                existing.setQuantity(existing.getQuantity() + 1);
                return existing;
            });
    }

    public void removeItem(long productId) {
        items.remove(productId);
    }

    public void updateQuantity(long productId, int quantity) {
        if (quantity <= 0) {
            items.remove(productId);
        } else {
            CartItem item = items.get(productId);
            if (item != null) item.setQuantity(quantity);
        }
    }

    public Collection<CartItem> getItems() { return items.values(); }
    public int getItemCount() { return items.values().stream().mapToInt(CartItem::getQuantity).sum(); }
    public double getTotal() { return items.values().stream().mapToDouble(CartItem::getTotalPrice).sum(); }
    public void clear() { items.clear(); }
}
