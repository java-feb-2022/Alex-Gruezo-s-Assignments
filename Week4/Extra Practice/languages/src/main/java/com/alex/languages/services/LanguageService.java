package com.alex.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.languages.models.Language;
import com.alex.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	@Autowired
	private LanguageRepository languageRepository;
	
	public List<Language> allLanguages() {
		
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language language) {
		
		return languageRepository.save(language);
	}
	
	public Language findLanguage(Long id) {
		
		Optional<Language> optionalLanguage = languageRepository.findById(id);
			if(optionalLanguage.isPresent()) {
				return optionalLanguage.get();
			} else {
				return null;
			}
	}
	
	public Language updateLanguage(Language language) {
		
		return languageRepository.save(language);
	}
	
	public void deleteLanguage(Long id) {
		
		languageRepository.deleteById(id);
	}
}
