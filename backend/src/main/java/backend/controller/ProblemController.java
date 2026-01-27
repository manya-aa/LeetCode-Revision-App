package backend.controller;

import backend.dto.ProblemDTO;
import backend.service.ProblemService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ProblemController {

    ProblemService problemService;

    @Autowired
    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @PostMapping("/addProb")
    public ResponseEntity<ProblemDTO> addProb(@RequestBody ProblemDTO problem){
      return ResponseEntity.ok(problemService.addProb(problem));
    }

    @GetMapping("/showProb")
    public ResponseEntity<List<ProblemDTO>> showProb(){
        return ResponseEntity.ok(problemService.showProb());
    }

    @PostMapping("/submit")
    public ResponseEntity<Void> submit(@RequestBody List<Integer> problem){
     problemService.submit(problem);
        return ResponseEntity.ok().build();
    }


}
