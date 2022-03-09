package com.alex.dojosAndNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.dojosAndNinjas.models.Ninja;
import com.alex.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRepo;
	
	public List<Ninja> getAllNinjas() {
		
		return ninjaRepo.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		
		return ninjaRepo.save(ninja);
	}
}
