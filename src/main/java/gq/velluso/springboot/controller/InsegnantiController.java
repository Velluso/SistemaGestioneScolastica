package gq.velluso.springboot.controller;

import gq.velluso.springboot.model.Insegnanti;
import gq.velluso.springboot.service.InsegnantiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InsegnantiController {

    @Autowired
    private InsegnantiService insegnantiService;


    // MOSTRA INSEGNANTI
    @GetMapping("/insegnanti")
    public String vediInsegnanti(Model model) {
        return findPaginated(1, "nome", "asc", model);
    }


    // AGGIUNGI INSEGNANTE
    @GetMapping("/nuovoInsegnante")
    public String getNuovoInsegnante(Model model) {

        Insegnanti insegnanti = new Insegnanti();
        model.addAttribute("insegnanti", insegnanti);
        return "aggiungi_insegnanti";
    }


    // SALVA INSEGNANTI
    @PostMapping("/salvaInsegnanti")
    public String salvaInsegnante(@ModelAttribute("insegnanti") Insegnanti insegnanti) {

        insegnantiService.salvaInsegnanti(insegnanti);
        return "redirect:/insegnanti";
    }

    // AGGIORNA INSEGNANTE
    @GetMapping("/updateInsegnante/{id}")
    public String updateInsegnante(@PathVariable(value = "id") long id, Model model) {

        // Prende gli Studenti dalla classe Service
        Insegnanti insegnanti = insegnantiService.getInsegnantiDaId(id);

        // Imposta gli studenti come Model da pre-aggiungere al form
        model.addAttribute("insegnanti", insegnanti);
        return "update_insegnanti";
    }


    // CANCELLA INSEGNANTE
    @GetMapping("/cancellaInsegnante/{id}")
    public String deleteInsegnante(@PathVariable(value = "id") long id) {

        insegnantiService.deleteInsegnantiDaId(id);
        return "redirect:/insegnanti";

    }


    // PAGINAZIONE

    @GetMapping("/pagina/{paginaNum}")
    public String findPaginated(@PathVariable (value = "paginaNum") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Insegnanti> page = insegnantiService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Insegnanti> insegnanti = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("insegnanti", insegnanti);
        return "insegnanti";
    }

}
