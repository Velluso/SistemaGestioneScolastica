package gq.velluso.springboot.service;

import gq.velluso.springboot.model.Materie;
import gq.velluso.springboot.repository.MaterieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterieServiceImpl implements MaterieService {


    private MaterieRepository materieRepository;



    // TROVA TUTTE MATERIE

    @Override
    public List<Materie> trovaTutteMaterie() {
        return materieRepository.findAll();
    }




    // PAGINAZIONE

    /*

    @Override
    public Page<Materie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.materieRepository.findAll(pageable);

    }

     */
}
