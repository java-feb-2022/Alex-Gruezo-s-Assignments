package com.alex.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.lookify.models.Song;
import com.alex.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepository;
	
	public List<Song> allSongs() {
		
		return songRepository.findAll();
	}
	
	public List<Song> findByArtist(String artist) {
		
		return songRepository.findByArtist(artist);
	}
	
	public Song createSong(Song song) {
		
		return songRepository.save(song);
	}
	
	public List<Song> getTopTen() {
		
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	public Song findSong(Long id) {
		
		Optional<Song> optionalSong = songRepository.findById(id);
			if(optionalSong.isPresent()) {
				return optionalSong.get();
			} else {
				return null;
			}
	}
	
	public Song updateSong(Song song) {
		
		return songRepository.save(song);
	}
	
	public void deleteSong(Long id) {
		
		songRepository.deleteById(id);
	}

}
