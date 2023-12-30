package justin.jalandoni.ex.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import justin.jalandoni.ex.model.CartItem;
import justin.jalandoni.ex.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartDto {

    @JsonProperty("cartId")
    private int cartId;

    @JsonProperty("cartItems")
    private List<CartItemDto> cartItems = new ArrayList<>();

    @JsonProperty("isFull")
    private boolean isFull = false;

    @JsonProperty("isCheckout")
    private boolean isCheckout = false;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    @JsonIgnore
    public boolean isFull() {
        return isFull;
    }

    public void setIsFull(boolean full) {
        isFull = full;
    }

    @JsonIgnore
    public boolean isCheckout() {
        return isCheckout;
    }

    public void setIsCheckout(boolean checkout) {
        isCheckout = checkout;
    }
}
