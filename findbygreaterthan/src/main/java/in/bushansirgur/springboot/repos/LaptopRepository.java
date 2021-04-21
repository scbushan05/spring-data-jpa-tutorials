package in.bushansirgur.springboot.repos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

	List<Laptop> findByPriceGreaterThan(BigDecimal price);
	
	List<Laptop> findByPriceLessThan(BigDecimal price);
}
