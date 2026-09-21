// Problem 5. The Shopping Cart
// Prices are stored privately; total and item count are computed on
// request by looping over the internal array, never exposing it.

class Cart {
    private final double[] prices;
    private int itemCount;
    private final String cartId;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    void addItem(double price) {
        if (itemCount >= prices.length) {
            System.out.println("Add rejected: cart is full");
            return;
        }
        prices[itemCount] = price;
        itemCount++;
    }

    double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    int getItemCount() {
        return itemCount;
    }
}

public class Problem5_ShoppingCart {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
