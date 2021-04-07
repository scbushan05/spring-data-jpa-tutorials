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
	
	@GetMapping("/laptops/namein")
	public ResponseEntity<List<Laptop>> getLaptopsByNameIn() {
		return new ResponseEntity<List<Laptop>>(lRepo.findByNameIn(Arrays.asList("hp", "lenovo")), HttpStatus.OK);
	}
	
	@GetMapping("/laptops/pricein")
	public ResponseEntity<List<Laptop>> getLaptopsByPriceIn() {
		return new ResponseEntity<List<Laptop>>(
				lRepo.findByPriceIn(Arrays.asList(new BigDecimal(50000.00), new BigDecimal(85000.00))), HttpStatus.OK);
	}
}