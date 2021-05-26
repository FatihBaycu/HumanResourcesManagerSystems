package fatih.baycu.hrms.restApi.controllers;

import fatih.baycu.hrms.business.abstracts.UserService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public  DataResult<List<User>> getAll(){
        return userService.getAll();

    }

    @PostMapping("/add-user")
    public Result add(@RequestBody User user){
        return userService.add(user);
    }
}

