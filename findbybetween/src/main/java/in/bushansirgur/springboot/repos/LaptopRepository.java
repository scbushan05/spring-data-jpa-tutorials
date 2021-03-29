package in.bushansirgur.springboot.repos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
	
	List<Laptop> findByCreatedAtBetween(Date startDate, Date endDate);
	
	List<Laptop> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);
}
