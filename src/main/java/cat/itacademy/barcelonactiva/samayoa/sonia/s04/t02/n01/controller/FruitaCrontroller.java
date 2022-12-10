package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.services.FruitaService;

@CrossOrigin (origins = "http://localhost:8080")
@RestController
@RequestMapping("/fruita")
public class FruitaCrontroller {
	
	@Autowired
	FruitaService fruitaService;
	
	@GetMapping("/add")
	public ResponseEntity<Fruita> addFruita (@RequestBody Fruita fruita) {
		
		return fruitaService.addFruita(fruita);
	
	}
	
	@GetMapping("/update")
	public String updateFruita(Fruita fruitaUpdate){
		
		return fruitaService.updateFruita(fruitaUpdate);
	}
	
	@GetMapping("/delete/{id}")
	public void deleteFruita(@PathVariable("id")long id) {
		
		fruitaService.deleteFruita(id);
		
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<List<Fruita>> getOneFruita(@PathVariable("id")long id){
		
		return fruitaService.getOneFruita(id);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Fruita>> getAllFruita(){
		
		return fruitaService.getAllFruita();
	}
}
