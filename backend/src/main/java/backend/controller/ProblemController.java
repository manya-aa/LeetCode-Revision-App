package backend.controller;

import backend.dto.ProblemDTO;
import backend.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemController {

    @Autowired
    ProblemService problemService;

    @PostMapping("/addProb")
    public void addProb(ProblemDTO problem){
problemService.addProb(problem);
    }

}
