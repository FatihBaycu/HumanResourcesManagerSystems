package fatih.baycu.hrms.restApi.controllers.JobSeekers;

import fatih.baycu.hrms.business.abstracts.JobSeeker.SchoolDepartmentService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/job-seekers/school-departments")
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
    public Result add(@RequestBody SchoolDepartment schoolDepartment){
        return this.schoolDepartmentService.add(schoolDepartment);
    }

    @PostMapping("/update")
    public Result update(@RequestBody SchoolDepartment schoolDepartment){
        return this.schoolDepartmentService.update(schoolDepartment);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody SchoolDepartment schoolDepartment){
        return this.schoolDepartmentService.delete(schoolDepartment);
    }

}
