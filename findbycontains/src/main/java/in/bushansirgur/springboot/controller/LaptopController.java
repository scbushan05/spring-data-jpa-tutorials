package in.bushansirgur.springboot.controller;

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
	
	@GetMapping("/laptops/namecontains")
	public ResponseEntity<List<Laptop>> getLaptopsByNameContains(@RequestParam String name) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByNameContaining(name), HttpStatus.OK);
	}
	
	@GetMapping("/laptops/brandcontains")
	public ResponseEntity<List<Laptop>> getLaptopsByBrandContains(@RequestParam String brand) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByBrandContaining(brand), HttpStatus.OK);
	}
	
	
}