package com.alex.lookify.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alex.lookify.models.Song;
import com.alex.lookify.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	private SongService songService;

	@GetMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String allSongs(Song song, Model viewModel) {
		
		viewModel.addAttribute("songs", songService.allSongs());
		return "dashboardSongs.jsp";
	}
	
	@GetMapping("/search")
	public String search(@PathVariable("artist") Song song, String artist, Model viewModel) {
		
		viewModel.addAttribute("songs", songService.findByArtist(artist));
		return "showSongs.jsp";
	}
	
	@PostMapping("/search")
	public String search(@RequestParam("artist") String artist, Song song, Model viewModel) {
		
		
		viewModel.addAttribute("songs", songService.findByArtist(artist));
		viewModel.addAttribute("artist", artist);
		System.out.println(songService.findByArtist(artist));
		return "showSongs.jsp";
		
	}

	@GetMapping("/songs/new")
	public String newSong(Song song) {
		
		return "newSong.jsp";
	}
	
	@PostMapping("/songs/create")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newSong.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/songs/{id}")
	public String getSong(@PathVariable("id") Long id, Model viewModel) {
		
		viewModel.addAttribute("song", songService.findSong(id));
		return "showOne.jsp";
	}
	
	@GetMapping("/songs/edit/{id}")
	public String editSong(@PathVariable("id") Long id, Model viewModel) {
		
		Song song = songService.findSong(id);
		
		viewModel.addAttribute("song", song);
		return "editSong.jsp";
	}
	
	@PutMapping("/songs/update/{id}")
	public String updateSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		
		if(result.hasErrors()) {
			return "editSong.jsp";
		} else {
			songService.updateSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/search/topTen")
	public String topTen(Song song, Model viewModel) {
		
		
		viewModel.addAttribute("songs", songService.getTopTen());
		return "topTenSongs.jsp";
	}
	
	@DeleteMapping("/songs/{id}")
		public String destroy(@PathVariable("id") Long id) {
			
			songService.deleteSong(id);
			return "redirect:/dashboard";
	}
	
	
}
