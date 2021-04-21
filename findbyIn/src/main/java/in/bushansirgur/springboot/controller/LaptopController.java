package in.bushansirgur.springboot.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.springboot.entity.Laptop;
import in.bushansirgur.springboot.repos.LaptopRepository;

@RestController
public class LaptopController {
	
	@Autowired
	LaptopRepository lRepo;
	
	@GetMapping("/laptops/names")
	public ResponseEntity<List<Laptop>> getLaptopsByNames () {
		return new ResponseEntity<>(lRepo.findByNameIn(Arrays.asList("HP", "Lenovo")), HttpStatus.OK);
	}
	
	@GetMapping("/laptops/prices")
	public ResponseEntity<List<Laptop>> getLaptopsByPrices () {
		return new ResponseEntity<>(lRepo.findByPriceIn(Arrays.asList(new BigDecimal(50000.00), new BigDecimal(60000))), HttpStatus.OK);
	}
}