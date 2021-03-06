package in.bushansirgur.springboot.repos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
	
	List<Laptop> findByPriceBetween (BigDecimal start, BigDecimal end);

	List<Laptop> findByCreatedAtBetween (Date start, Date end);
}
