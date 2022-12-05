package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.services;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.domain.Fruita;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.repository.FruitaRepo;

public class FruitaServiceImpl implements FruitaService {
	
	@Autowired
	private FruitaRepo fruitaRepo;

	@Override
	public Fruita addFruita() {
		Scanner scn = new Scanner(System.in);
		String nom;
		int quilos;
		System.out.println("Nom de la fruite: ");
		nom = scn.nextLine();
		System.out.println("Quilos: ");
		quilos = scn.nextInt();
		Fruita fr = new Fruita(nom, quilos);
		fr.setNom(nom);
		fr.setQuilos(quilos);
		return fruitaRepo.save(fr);
	}

	@Override
	public Fruita updateFruita() {
		Scanner scn = new Scanner(System.in);
		String nom;
		int nousQuilos;
		System.out.println("Nom fruite per modificar: ");
		nom = scn.nextLine();
		System.out.println("Cuantos Quilos a modificar: ");
		nousQuilos = scn.nextInt();
		((Fruita) fruitaRepo.findBynom(nom)).modificarQuilos(nousQuilos);
		return null;
	}

	@Override
	public Fruita deleteFruita(int id) {
		fruitaRepo.deleteById(id);
		return null;
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
