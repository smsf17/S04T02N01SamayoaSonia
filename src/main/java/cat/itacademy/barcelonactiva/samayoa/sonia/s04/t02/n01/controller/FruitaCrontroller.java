package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Fruita addFruita () {
		
		System.out.println("Afegir fruita:");
		Fruita fruita = fruitaService.addFruita();
		
		return fruita;
	
	}
	
	@GetMapping("/update")
	public Fruita updateFruita(){
		
		return fruitaService.updateFruita();
	}
	
	@GetMapping("/delete/{id}")
	public void deleteFruita(@PathVariable("id")int id) {
		
		fruitaService.deleteFruita(id);
		
	}
	
	@GetMapping("/getOne/{id}")
	public Fruita getOneFruita(@PathVariable("id")int id){
		
		return fruitaService.getOneFruita(id);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<String> getAllFruita(){
		
		try {
			List<Fruita> fruites = fruitaService.getAllFruita();
			if (fruites!=null) {
				return ResponseEntity.status(HttpStatus.OK).body("esta es la lista de Fruites");
			}else{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("no hay ningun producto");
				}
			}
		catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
