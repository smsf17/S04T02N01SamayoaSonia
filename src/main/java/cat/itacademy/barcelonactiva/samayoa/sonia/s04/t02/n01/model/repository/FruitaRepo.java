package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.domain.Fruita;

public interface FruitaRepo extends JpaRepository<Fruita, Integer> {
	
	List<Fruita> findBynom(String nom);

}
