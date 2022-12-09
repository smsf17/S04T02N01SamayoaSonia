package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.services;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.repository.FruitaRepo;

@Service
public class FruitaServiceImpl implements FruitaService {
	
	@Autowired
	private FruitaRepo fruitaRepo;

	@Override
	public Fruita addFruita() {
		
		Scanner scn = new Scanner(System.in);
		String nom;
		int quilos;
		
		System.out.println("Nom de la fruita: ");
		nom = scn.nextLine();
		System.out.println("Quilos: ");
		quilos = scn.nextInt();
		
		Fruita fr = new Fruita(nom, quilos);
		fr.setNom(nom);
		fr.setQuilos(quilos);
		return fruitaRepo.save(fr);
	}

	@SuppressWarnings("null")
	@Override
	public Fruita updateFruita() {
		
		Scanner scn = new Scanner(System.in);
		Fruita fr = null;
		
		System.out.println("Id fruita: ");
		int id = scn.nextInt();
		
		Optional<Fruita> fruitaData = fruitaRepo.findById(id);
		
		if(fruitaData.isPresent()) {
			
			Fruita tempFruita = fruitaData.get();
			tempFruita.setNom(fr.getNom());
			tempFruita.setQuilos(fr.getQuilos());
			
			return fruitaRepo.save(tempFruita);
		}else {
		
		return null;
		}
	}

	@Override
	public String deleteFruita(int id) {
		
		fruitaRepo.deleteById(id);
		
		return "Fruita borrada";
	}

	@Override
	public Fruita getOneFruita(int id) {
		
		return fruitaRepo.findById(id).orElse(null);
	}

	@Override
	public List<Fruita> getAllFruita() {
		
		return fruitaRepo.findAll();
		
	}

}
