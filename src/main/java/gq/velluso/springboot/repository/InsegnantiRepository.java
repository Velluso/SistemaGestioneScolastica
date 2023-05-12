package gq.velluso.springboot.repository;

import gq.velluso.springboot.model.Insegnanti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsegnantiRepository extends JpaRepository<Insegnanti, Long> {
}
