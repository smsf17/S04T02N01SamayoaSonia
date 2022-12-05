package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.services.FruitaService;

@RestController
@RequestMapping("/fruita")
public class FruitaController {
	
	@Autowired
	private FruitaService fruitaService;
	
	@GetMapping(value="/add")
	public Fruita addFruita () {
		System.out.println("Afegir fruita:");
		Fruita fruita = fruitaService.addFruita();
		return fruita;
	}
	
	 /*public Fruita updateFruita ();
	
	public Fruita deleteFruita (@PathVariable int id);
	
	public Fruita getOneFruita (@PathVariable int id);*/
	
	public List<Fruita> getAllFruita(){
		System.out.println("Lista fruita:");
		List<Fruita> fruites=fruitaService.getAllFruita();
		return fruites;
	}
	
}
