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
	
	@GetMapping("/laptops/namelike")
	public ResponseEntity<List<Laptop>> getLaptopsByNameLike(@RequestParam String name) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByNameLike("%"+name+"%"), HttpStatus.OK);
	}
	
	@GetMapping("/laptops/brandlike")
	public ResponseEntity<List<Laptop>> getLaptopsByBrandLike(@RequestParam String brand) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByBrandLike("%"+brand+"%"), HttpStatus.OK);
	}
}