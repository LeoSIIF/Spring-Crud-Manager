package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.*;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.*;

@Controller
public class EventController {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private CoordRepository coordRepository;
	
	@GetMapping("/events")
	public String eventos(Model model) {
		
		List<Event> events = eventRepository.findAll();
		model.addAttribute("events", events);
		
		return "indexEventos";
	}
	
	@GetMapping("/events/form")
	public String eventForm(Model model, @ModelAttribute("event") Event event) {
		List<Coord> coords = coordRepository.findAll();
		model.addAttribute("coords",coords);
		return "event_form";
	}
	
	@PostMapping("/events/new")
	public String eventNew(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			List<Event> events = eventRepository.findAll();
			model.addAttribute("events", events);
			
			return "coord_form";
		}
		
		eventRepository.save(event);
		return "redirect:/events";
	}
	
	@GetMapping("/events/update/{id}")
	public String eventUpdate(@PathVariable("id") Integer id, Model model) {
		
		Optional<Event> optEvent = eventRepository.findById(id);
		
		if(!optEvent.isPresent()) {
			//Gerar erro
		}
		
		Event event = optEvent.get();
		
		model.addAttribute("event", event);
		
		List<Coord> coords = coordRepository.findAll();
		model.addAttribute("coords",coords);
		
		return "event_form";
	}
	
	@GetMapping("/events/delete/{id}")
	public String eventDelete(@PathVariable("id") Integer id, Model model) {
		
		Optional<Event> optEvent = eventRepository.findById(id);
		
		if(!optEvent.isPresent()) {
			//Gerar erro
		}
		
		Event event = optEvent.get();
		
		eventRepository.delete(event);
		
		return "redirect:/events";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
