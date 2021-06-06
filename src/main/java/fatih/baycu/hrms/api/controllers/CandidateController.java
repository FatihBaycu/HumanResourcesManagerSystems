package fatih.baycu.hrms.api.controllers;

import fatih.baycu.hrms.business.abstracts.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(candidateService.getAll());
    }

    @GetMapping("/getresumebycandidateid")
    public ResponseEntity<?> getResumeByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.candidateService.getResumeByCandidateId(candidateId));
    }
}
