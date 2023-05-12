package gq.velluso.springboot.service;

import gq.velluso.springboot.model.Insegnanti;
import gq.velluso.springboot.repository.InsegnantiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsegnantiServiceImpl implements InsegnantiService{

    @Autowired
    private InsegnantiRepository insegnantiRepository;


    // MOSTRA INSEGNANTI

    @Override
    public List<Insegnanti> selezionaTuttiInsegnanti() {
        return insegnantiRepository.findAll();
    }


    // METODO POST
    @Override
    public void salvaInsegnanti(Insegnanti insegnanti) {
        this.insegnantiRepository.save(insegnanti);
    }



// METODO UPDATE
    @Override
    public Insegnanti getInsegnantiDaId(long id) {
        Optional<Insegnanti> optional = insegnantiRepository.findById(id);
        Insegnanti insegnanti = null;
        if (optional.isPresent()) {
            insegnanti = optional.get();
        } else {
            throw new RuntimeException(" id: " + id + " " + "non trovato");
        }
        return insegnanti;
    }


    // METODO DELETE


    @Override
    public void deleteInsegnantiDaId(long id) {
        this.insegnantiRepository.deleteById(id);
    }


    // PAGINAZIONE

    @Override
    public Page<Insegnanti> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.insegnantiRepository.findAll(pageable);
    }
}
