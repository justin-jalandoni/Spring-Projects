package justin.jalandoni.ex.repository;

import justin.jalandoni.ex.model.Cart;
import justin.jalandoni.ex.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
