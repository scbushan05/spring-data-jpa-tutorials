package in.bushansirgur.springboot.controller;

import java.math.BigDecimal;
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
	
	@GetMapping("/laptops/greaterthan")
	public ResponseEntity<List<Laptop>> getLaptopsByGreaterThan (@RequestParam BigDecimal price) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByPriceGreaterThan(price), HttpStatus.OK);
	}
	
	@GetMapping("/laptops/lessthan")
	public ResponseEntity<List<Laptop>> getLaptopsByLessThan (@RequestParam BigDecimal price) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByPriceLessThan(price), HttpStatus.OK);
	}
}









