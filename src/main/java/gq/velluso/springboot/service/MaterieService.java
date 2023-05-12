package gq.velluso.springboot.service;

import gq.velluso.springboot.model.Materie;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MaterieService  {


    List<Materie> trovaTutteMaterie();

    // Page<Materie> findPaginated(int pageNo, int pageSize, String sortField, String sortDir);
}
