package in.bushansirgur.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.springboot.entity.Laptop;
import in.bushansirgur.springboot.repos.LaptopRepository;

@RestController
public class LaptopController {
	
	@Autowired
	LaptopRepository lRepo;
	
	@GetMapping("/laptopsByCols")
	public List<Laptop> getAllByCols (@RequestParam String field1, @RequestParam String field2) {
		return lRepo.findAll(Sort.by(Direction.DESC, field1, field2));
	}
	
	@GetMapping("/laptopsByDirections")
	public List<Laptop> getAllByDirections (@RequestParam String field1, @RequestParam String field2) {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(Direction.DESC, field1));
		orders.add(new Order(Direction.ASC, field2));
		return lRepo.findAll(Sort.by(orders));
	}
	
}