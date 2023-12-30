package justin.jalandoni.ex.service;

import justin.jalandoni.ex.model.Cart;

public interface CartService {

    public int generateCart();

    public void deleteCart(int id);

    public String addItemToCart(int cartId, int productId);

    public Cart getCartDetails(int id);

    public void checkoutCart(int id);
}
