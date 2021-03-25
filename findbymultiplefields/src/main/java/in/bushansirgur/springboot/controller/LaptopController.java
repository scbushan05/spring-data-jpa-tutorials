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
	
	@GetMapping("/laptops/nameandbrand")
	public ResponseEntity<List<Laptop>> getLaptopsByNameAndBrand(@RequestParam String name,
				@RequestParam String brand) {
		return new ResponseEntity<>(lRepo.findByNameAndBrand(name, brand), HttpStatus.OK);
	}
	
	@GetMapping("/laptops/brandandprice")
	public ResponseEntity<List<Laptop>> getLaptopsByBrandAndPrice(@RequestParam String brand,
				@RequestParam BigDecimal price) {
		return new ResponseEntity<>(lRepo.findByBrandAndPrice(brand, price), HttpStatus.OK);
	}
	
	@GetMapping("/laptops/nameorbrandorprice")
	public ResponseEntity<List<Laptop>> getLaptopsByNameOrBrandOrPrice(@RequestParam String name,
				@RequestParam String brand,
				@RequestParam BigDecimal price) {
		return new ResponseEntity<>(lRepo.findByNameOrBrandOrPrice(name, brand, price), HttpStatus.OK);
	}
}




















