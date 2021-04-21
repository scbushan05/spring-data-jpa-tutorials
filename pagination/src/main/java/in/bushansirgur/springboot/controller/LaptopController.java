package in.bushansirgur.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.springboot.entity.Laptop;
import in.bushansirgur.springboot.repos.LaptopRepository;

@RestController
public class LaptopController {
	
	@Autowired
	LaptopRepository lRepo;
	
	@GetMapping("/laptops")
	public List<Laptop> getAll (@RequestParam Integer page, @RequestParam Integer size) {
		Pageable pages = PageRequest.of(page, size);
		return lRepo.findAll(pages).toList();
	}
	
}