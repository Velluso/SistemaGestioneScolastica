package gq.velluso.springboot.repository;

import gq.velluso.springboot.model.Materie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterieRepository extends JpaRepository<Materie, Long> {
}
