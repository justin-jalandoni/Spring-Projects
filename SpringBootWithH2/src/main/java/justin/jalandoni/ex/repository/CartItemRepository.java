package justin.jalandoni.ex.repository;

import justin.jalandoni.ex.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    int countByCartId(int cartId);

}
