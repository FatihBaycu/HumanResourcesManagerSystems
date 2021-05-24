package fatih.baycu.hrms.core.utilities.results;

public class ErrorResult<T> extends Result<T> {

    public ErrorResult(){
        super(false);
    }
    public ErrorResult(String message){
        super(false,message);
    }
}
