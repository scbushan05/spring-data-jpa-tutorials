package in.bushansirgur.springboot.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.springboot.entity.Laptop;
import in.bushansirgur.springboot.repos.LaptopRepository;

@RestController
public class LaptopController {
	
	@Autowired
	LaptopRepository lRepo;
	
	@GetMapping("/laptops/createdat")
	public ResponseEntity<List<Laptop>> getLaptopsByCreatedDate (@RequestParam Date startDate,
																@RequestParam Date endDate) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByCreatedAtBetween(startDate, endDate), HttpStatus.OK);
	}
	
	@GetMapping("/laptops/price")
	public ResponseEntity<List<Laptop>> getLaptopsByPrice (@RequestParam BigDecimal startPrice,
																@RequestParam BigDecimal endPrice) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByPriceBetween(startPrice, endPrice), HttpStatus.OK);	
	}
}