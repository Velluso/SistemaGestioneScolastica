package gq.velluso.springboot.controller;

import gq.velluso.springboot.model.Insegnanti;
import gq.velluso.springboot.model.Materie;
import gq.velluso.springboot.service.MaterieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MaterieController {

    @Autowired
    private MaterieService materieService;


    // MOSTRA TUTTE LE MATERIE

    @GetMapping("/materie")
    public String getMaterie(Model model) {
        return "materie";
    }





/*
    // PAGINAZIONE

    @GetMapping("/page/{paginaNumero}")
    public String findPaginated(@PathVariable(value = "paginaNumero") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Materie> page = materieService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Materie> materie = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("materie", materie);
        return "materie";
    }


 */

}
