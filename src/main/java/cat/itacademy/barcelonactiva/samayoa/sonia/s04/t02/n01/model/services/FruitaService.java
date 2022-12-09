package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.domain.Fruita;

public interface FruitaService {

	public Fruita addFruita ();
	
	public Fruita updateFruita ();
	
	public String deleteFruita (int id);
	
	public Fruita getOneFruita (int id);
	
	public List<Fruita> getAllFruita ();

}
