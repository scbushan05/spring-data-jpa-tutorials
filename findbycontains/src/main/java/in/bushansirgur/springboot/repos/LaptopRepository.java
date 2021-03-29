package in.bushansirgur.springboot.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
	
	List<Laptop> findByNameContaining(String name);
	
	List<Laptop> findByBrandContaining(String brand);
	
}
