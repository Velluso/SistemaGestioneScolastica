package gq.velluso.springboot.repository;

import gq.velluso.springboot.model.Studenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentiRepository extends JpaRepository<Studenti, Long>{

}
