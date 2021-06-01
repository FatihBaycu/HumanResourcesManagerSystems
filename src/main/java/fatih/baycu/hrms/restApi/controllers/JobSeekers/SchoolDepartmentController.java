package fatih.baycu.hrms.restApi.controllers.JobSeekers;

import fatih.baycu.hrms.business.abstracts.JobSeeker.SchoolDepartmentService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.entities.concretes.job_seeker.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/job-seekers/school-department")
public class SchoolDepartmentController {

    private SchoolDepartmentService schoolDepartmentService;

    @Autowired
    public SchoolDepartmentController(SchoolDepartmentService schoolDepartmentService) {
        this.schoolDepartmentService = schoolDepartmentService;
    }

    @GetMapping("/getall")
    public DataResult<List<SchoolDepartment>> getAll(){
        return this.schoolDepartmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(SchoolDepartment schoolDepartment){
        return this.schoolDepartmentService.add(schoolDepartment);
    }

    @PostMapping("/update")
    public Result update(SchoolDepartment schoolDepartment){
        return this.schoolDepartmentService.update(schoolDepartment);
    }

    @PostMapping("/delete")
    public Result delete(SchoolDepartment schoolDepartment){
        return this.schoolDepartmentService.delete(schoolDepartment);
    }

}
