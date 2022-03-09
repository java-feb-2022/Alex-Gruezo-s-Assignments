package com.alex.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.dojosAndNinjas.models.Dojo;
import com.alex.dojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	private DojoRepository dojoRepo;
	
	public List<Dojo> getAllDojos() {
		
		return dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		
		return dojoRepo.save(dojo);
	}
	
	public Dojo getDojo(Long id) {
		
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		
			if(optionalDojo.isPresent()) {
					return optionalDojo.get();
			} else {
				return null;
			}
	}
	
}
