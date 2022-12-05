package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.domain.Fruita;

public interface FruitaService {
	/* http://localhost:8080/fruita/add

http://localhost:8080/fruita/update

http://localhost:8080/fruita/delete/{id}

http://localhost:8080/fruita/getOne/{id}

http://localhost:8080/fruita/getAll*/
	
	public Fruita addFruita ();
	
	public Fruita updateFruita ();
	
	public Fruita deleteFruita (int id);
	
	public Fruita getOneFruita (int id);
	
	public List<Fruita> getAllFruita ();
	

}
