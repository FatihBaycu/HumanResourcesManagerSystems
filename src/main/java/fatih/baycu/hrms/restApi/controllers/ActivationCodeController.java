package fatih.baycu.hrms.restApi.controllers;


import fatih.baycu.hrms.business.abstracts.ActivationCodeService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.dataAccess.abstracts.ActivationCodeDao;
import fatih.baycu.hrms.entities.concretes.ActivationCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("api/activation-codes")

public class ActivationCodeController {

    private ActivationCodeService activationCodeService;

    public ActivationCodeController(ActivationCodeService activationCodeService) {
        this.activationCodeService = activationCodeService;
    }

    @GetMapping("")
    public DataResult<List<ActivationCode>> getAll(){
            return activationCodeService.getAll();
    }

    @GetMapping("get-by-user-id")
    public DataResult<ActivationCode> getByUserId(int id){
        return activationCodeService.findActivationCodeByUserId(id);
    }



}
