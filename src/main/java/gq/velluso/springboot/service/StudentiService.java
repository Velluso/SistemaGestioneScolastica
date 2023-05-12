package gq.velluso.springboot.service;

import java.util.List;

import gq.velluso.springboot.model.Studenti;
import org.springframework.data.domain.Page;

public interface StudentiService {
	List<Studenti> selezionaTuttiStudenti();
	void salvaStudenti(Studenti studenti);
	Studenti getStudentiDaId(long id);
	void deleteStudentiDaId(long id);
	Page<Studenti> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
