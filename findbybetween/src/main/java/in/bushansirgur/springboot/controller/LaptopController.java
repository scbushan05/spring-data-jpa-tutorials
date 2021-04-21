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
	
	@GetMapping("/laptops/price")
	public ResponseEntity<List<Laptop>> getLaptopsByPrice (@RequestParam BigDecimal start, @RequestParam BigDecimal end) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByPriceBetween(start, end), HttpStatus.OK);
	}
	
	@GetMapping("/laptops/date")
	public ResponseEntity<List<Laptop>> getLaptopsByDate (@RequestParam Date start, @RequestParam Date end) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByCreatedAtBetween(start, end), HttpStatus.OK);
	}
	
	
}