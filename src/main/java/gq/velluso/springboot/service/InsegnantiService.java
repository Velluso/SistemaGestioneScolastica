package gq.velluso.springboot.service;

import gq.velluso.springboot.model.Insegnanti;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InsegnantiService {
    List<Insegnanti> selezionaTuttiInsegnanti();

    void salvaInsegnanti(Insegnanti insegnanti);

    void deleteInsegnantiDaId(long id);

    Page<Insegnanti> findPaginated(int pageNo, int pageSize, String sortField, String sortDir);

    Insegnanti getInsegnantiDaId(long id);
}
