package in.bushansirgur.springboot.repos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
	
	List<Laptop> findByNameAndBrand(String name, String brand);
	
	List<Laptop> findByBrandAndPrice(String name, BigDecimal price);
	
	List<Laptop> findByNameOrBrandOrPrice(String name, String brand, BigDecimal price);
}
