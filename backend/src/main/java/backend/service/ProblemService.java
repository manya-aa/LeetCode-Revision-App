package backend.service;

import backend.dto.ProblemDTO;
import backend.entity.ProblemEntity;
import backend.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProblemService {

    @Autowired
    ProblemRepository problemRepository;
    ProblemEntity problemEntity;
    public ProblemEntity dtoToEntity(ProblemDTO problem){
        LocalDate today = LocalDate.now();
        problemEntity.user_id=1;
        problemEntity.date=today.plusDays(3);
        problemEntity.prob_num=problem.getProb_no();
        problemEntity.url=problem.getUrl();
        problemEntity.interval=7;
        return  problemEntity;
    }

    public void addProb(ProblemDTO problem){



    }


}
