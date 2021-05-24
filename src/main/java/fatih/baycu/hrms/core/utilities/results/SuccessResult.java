package fatih.baycu.hrms.core.utilities.results;

public class SuccessResult<T> extends  Result<T> {

    public  SuccessResult(){
        super(true);
    }
    public SuccessResult(String message){
        super(true,message);
    }

}
