package gq.velluso.springboot.service;

import gq.velluso.springboot.model.Studenti;
import gq.velluso.springboot.repository.StudentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentiServiceImpl implements StudentiService {

	@Autowired
	private StudentiRepository studentiRepository;


	@Override
	public List<Studenti> selezionaTuttiStudenti() {
		return studentiRepository.findAll();
	}

	@Override
	public void salvaStudenti(Studenti studenti) {
		this.studentiRepository.save(studenti);
	}

	@Override
	public Studenti getStudentiDaId(long id) {
		Optional<Studenti> optional = studentiRepository.findById(id);
		Studenti studenti = null;
		if (optional.isPresent()) {
			studenti = optional.get();
		} else {
			throw new RuntimeException(" id: " + id + " " + "non trovato");
		}
		return studenti;
	}

	@Override
	public void deleteStudentiDaId(long id) {
		this.studentiRepository.deleteById(id);
	}

	@Override
	public Page<Studenti> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.studentiRepository.findAll(pageable);
	}
}
