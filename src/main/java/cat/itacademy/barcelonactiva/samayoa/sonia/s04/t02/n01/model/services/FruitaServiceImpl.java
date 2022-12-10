package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.repository.FruitaRepo;

@Service
public class FruitaServiceImpl implements FruitaService {
	
	@Autowired
	private FruitaRepo fruitaRepo;

	@Override
	public ResponseEntity<Fruita> addFruita(Fruita fruita) {
		
		try {
			Fruita nFruita = fruitaRepo.save(new Fruita(fruita.getNom(), fruita.getQuilos()));
			return new ResponseEntity<>(nFruita, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public String updateFruita(Fruita fruitaUpdate) {
		
		Long num = fruitaUpdate.getId();
		
		if(fruitaRepo.findById(num).isEmpty()) {
			
			return "Error al modificar Fruita";
		}else {
			Fruita fruitaToUpdate = new Fruita();
			fruitaToUpdate.setNom(fruitaUpdate.getNom());
			fruitaToUpdate.setQuilos(fruitaUpdate.getQuilos());
			fruitaRepo.save(fruitaToUpdate);
		
			return "Fruita modificada";
		}
	}

	@Override
	public String deleteFruita(long id) {
		
		if(fruitaRepo.findById(id).isEmpty()){
		
			return "Error! Fruita no existente!";
		}else {
			fruitaRepo.deleteById((int) id);
		
			return "Fruita eliminada";
		}
	}

	@Override
	public ResponseEntity<List<Fruita>> getOneFruita(long id) {
		
		if (fruitaRepo.findById(id).isEmpty()) {			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(fruitaRepo.findById(id), HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<List<Fruita>> getAllFruita() {
		
		try {
			List<Fruita> fruites = new ArrayList<Fruita>();
			
			if(fruitaRepo.findAll().isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				fruitaRepo.findAll().forEach(fruites::add);
			}
			return new ResponseEntity<>(fruites, HttpStatus.OK);
		}catch (Exception e) {		
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
