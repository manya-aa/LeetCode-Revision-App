package backend.service;
import backend.dto.ProblemDTO;
import backend.entity.ProblemEntity;
import backend.repository.ProblemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProblemService {

    ProblemRepository problemRepository;

    @Autowired
    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;

    }

    public int nextInterval(int n){
        if(n==5)return 7;
        if(n==7)return 21;
        return 30;
    }

    public ProblemEntity dtoToEntity(ProblemDTO problem){
        LocalDate today = LocalDate.now();
        ProblemEntity problemEntity =  new ProblemEntity();;
        problemEntity.setUser_id(1);
        problemEntity.setDate(today.plusDays(3));
        problemEntity.setProb_num(problem.getProb_no());
        problemEntity.setUrl(problem.getUrl());
        problemEntity.setInterval(5);
        problemEntity.setProb_name(problem.getProb_name());
        return problemEntity;
    }

    public ProblemDTO entityToDto(ProblemEntity problem){
        ProblemDTO problemDTO = new ProblemDTO();
        problemDTO.setProb_no(problem.getProb_num());
        problemDTO.setUrl(problem.getUrl());
        problemDTO.setProb_name(problem.getProb_name());
        return problemDTO;
    }

    public ProblemDTO addProb(ProblemDTO problem){
       ProblemEntity prob= dtoToEntity(problem);
        return entityToDto(problemRepository.save(prob));
    }

    public List<ProblemDTO> showProb(){
        List<ProblemEntity> list = problemRepository.findAllBydate(LocalDate.now());
        List<ProblemDTO> listDTO = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            listDTO.add(entityToDto(list.get(i)));
        }
        return listDTO;
    }

    public void submit(List<Integer> revisedProblemNumbers) {

        LocalDate today = LocalDate.now();
        List<ProblemEntity> todaysProblems =
                problemRepository.findAllBydate(today);

        for (ProblemEntity entity : todaysProblems) {

            if (revisedProblemNumbers.contains(entity.getProb_num())) {

                entity.setDate(today.plusDays(entity.getInterval()));
                entity.setInterval(nextInterval(entity.getInterval()));


            } else {
                entity.setDate(today.plusDays(1)); // backlog
            }
        }

        problemRepository.saveAll(todaysProblems);
    }

}
