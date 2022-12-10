package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.domain.Fruita;

public interface FruitaService {

	public ResponseEntity<Fruita> addFruita(Fruita fruita);
	
	public String updateFruita(Fruita fruitaNew);
	
	public String deleteFruita(long id);
	
	public ResponseEntity<List<Fruita>> getOneFruita(long id);
	
	public ResponseEntity<List<Fruita>> getAllFruita();
	
}
