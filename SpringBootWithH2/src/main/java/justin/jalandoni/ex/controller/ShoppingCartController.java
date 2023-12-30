package justin.jalandoni.ex.controller;

import justin.jalandoni.ex.dto.CartDto;
import justin.jalandoni.ex.dto.CartItemDto;
import justin.jalandoni.ex.model.Cart;
import justin.jalandoni.ex.model.CartItem;
import justin.jalandoni.ex.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CartDto getCartDetails(@PathVariable int id) {
        return buildCartDto(cartService.getCartDetails(id));
    }

    private CartDto buildCartDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setCartId(cart.getId());
        cartDto.setIsFull(cart.isFull());
        cartDto.setIsCheckout(cart.isCheckout());
        List<CartItemDto> cartItemDtoList = new ArrayList<>();
        Set<CartItem> cartItems = cart.getItems();

        for (CartItem cartItem : cartItems) {
            CartItemDto cartItemDto = new CartItemDto();
            cartItemDto.setPrice(cartItem.getProduct().getPrice());
            cartItemDto.setProductName(cartItem.getProduct().getName());
            cartItemDtoList.add(cartItemDto);
        }
        cartDto.setCartItems(cartItemDtoList);
        return cartDto;
    }

    @GetMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createCart() {
        int cartId = cartService.generateCart();
        return "Your cart's generated id is: " + cartId;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public String deleteCart(@PathVariable int id) {
        cartService.deleteCart(id);
        return "Cart deleted: " + id;
    }

    @PostMapping("/addToCart")
    @ResponseStatus(HttpStatus.OK)
    public String addToCart(@RequestParam int cartId, @RequestParam int productId) {
        return cartService.addItemToCart(cartId, productId);
    }

    @PutMapping("/checkout/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String checkout(@PathVariable int id) {
        cartService.checkoutCart(id);
        return "Cart has been checked out with Id: " + id;
    }

}
