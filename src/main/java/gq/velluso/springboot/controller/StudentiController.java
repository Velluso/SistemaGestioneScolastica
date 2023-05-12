package gq.velluso.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gq.velluso.springboot.model.Studenti;
import gq.velluso.springboot.service.StudentiService;

@Controller
public class StudentiController {

	@Autowired
	private StudentiService studentiService;
	
	// Mostra Lista di Studenti


	@GetMapping("/home")
	public String homePage(Model model) {
		return "index";
	}


	@GetMapping("/lista")
	public String viewHomePage(Model model) {
		return findPaginated(1, "nome", "asc", model);
	}



	@GetMapping("/mostraNuovoFormStudente")
	public String showNewEmployeeForm(Model model) {
		// crea il model attribute per agganciare i dati del form
		Studenti studenti = new Studenti();
		model.addAttribute("studenti	", studenti);
		return "aggiungi_studenti";
	}


	@PostMapping("/salvaStudenti")
	public String salvaStudenti(@ModelAttribute("studenti") Studenti studenti) {
		// Salva Studenti nel database
		studentiService.salvaStudenti(studenti);
		return "redirect:/lista";
	}


	@GetMapping("/mostraFormUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// Prende gli Studenti dalla classe Service
		Studenti studenti = studentiService.getStudentiDaId(id);
		
		// Imposta gli studenti come Model da pre-aggiungere al form
		model.addAttribute("studenti", studenti);
		return "update_studenti";
	}
	
	@GetMapping("/cancellaStudenti/{id}")
	public String cancellaStudenti(@PathVariable (value = "id") long id) {
		
		// chiama il metodo delete studenti
		this.studentiService.deleteStudentiDaId(id);
		return "redirect:/lista";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Studenti> page = studentiService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Studenti> studenti = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("studenti", studenti);
		return "lista_studenti";
	}
}
