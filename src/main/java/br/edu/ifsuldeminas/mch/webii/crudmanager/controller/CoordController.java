package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.CoordRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Coord;

@Controller
public class CoordController {
	
	@Autowired
	private CoordRepository coordRepository;
	
	
	@GetMapping("/coords")
	public String coordenadores(Model model) {
		
		List<Coord> coords = coordRepository.findAll();
		model.addAttribute("coords", coords);
		
		return "indexCoord";
	}
	

	@GetMapping("")
	public String index(Model model) {
		
		List<Coord> coords = coordRepository.findAll();
		model.addAttribute("coords", coords);
		
		return "indexCoord";
	}
	
	
	
	@GetMapping("/coords/form")
	public String coordForm(@ModelAttribute("coord") Coord coord) {
		
		return "coord_form";
	}
	
	@PostMapping("/coords/new")
	public String coordNew(@Valid @ModelAttribute("coord") Coord coord, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			List<Coord> coords = coordRepository.findAll();
			model.addAttribute("coords", coords);
			
			return "coord_form";
		}
		
		coordRepository.save(coord);
		return "redirect:/coords";
	}
	
	@GetMapping("/coords/update/{id}")
	public String coordUpdate(@PathVariable("id") Integer id, Model model) {
		
		Optional<Coord> optCoord = coordRepository.findById(id);
		
		if(!optCoord.isPresent()) {
			//Gerar erro
		}
		
		Coord coord = optCoord.get();
		
		model.addAttribute("coord", coord);
		
		return "coord_form";
	}
	
	@GetMapping("/coords/delete/{id}")
	public String coordDelete(@PathVariable("id") Integer id, Model model) {
		
		Optional<Coord> optCoord = coordRepository.findById(id);
		
		if(!optCoord.isPresent()) {
			//Gerar erro
		}
		
		Coord coord = optCoord.get();
		
		coordRepository.delete(coord);
		
		return "redirect:/coords";
	}
}
