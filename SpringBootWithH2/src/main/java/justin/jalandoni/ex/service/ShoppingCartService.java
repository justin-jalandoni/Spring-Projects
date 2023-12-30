package justin.jalandoni.ex.service;

import justin.jalandoni.ex.model.Cart;
import justin.jalandoni.ex.model.CartItem;
import justin.jalandoni.ex.model.Product;
import justin.jalandoni.ex.repository.CartItemRepository;
import justin.jalandoni.ex.repository.CartRepository;
import justin.jalandoni.ex.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService implements CartService{
    private final static int MAX_ITEM_COUNT = 5;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public int generateCart() {
        Cart newCart = new Cart();
        cartRepository.save(newCart);
        return newCart.getId();
    }

    @Override
    public void deleteCart(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public String addItemToCart(int cartId, int productId) {
        // todo: add checking of full cart here
        Cart cart = cartRepository.findById(cartId).get();
        Product product = productRepository.findById(productId).get();

        int cartItemCount = cartItemRepository.countByCartId(cartId);

        if (cartItemCount == MAX_ITEM_COUNT) {
            return "Cart is full";
        }

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItemRepository.save(cartItem);

        if (cartItemCount + 1 == MAX_ITEM_COUNT) {
            cart.setFull(true);
            cartRepository.save(cart);
        }

        return "Item added to cartId:" + cartId;
    }

    @Override
    public Cart getCartDetails(int id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public void checkoutCart(int id) {
        Cart cart = cartRepository.findById(id).get();
        cart.setCheckout(true);
        cartRepository.save(cart);
    }


}
