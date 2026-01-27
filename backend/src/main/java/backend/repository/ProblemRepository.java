package backend.repository;

import backend.dto.ProblemDTO;
import backend.entity.ProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<ProblemEntity,Integer> {
    public List<ProblemEntity> findAllBydate(LocalDate date);
}
