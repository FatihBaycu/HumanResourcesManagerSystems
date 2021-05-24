package fatih.baycu.hrms.core.utilities.results;

import javax.xml.crypto.Data;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(T data,String message){
        super(data,false,message);
    }
    public ErrorDataResult(T data){
        super(data,false,null);
    }
    public ErrorDataResult(String message){
        super(null,false,message);
    }
    public  ErrorDataResult(){
        super(null,false);
    }

}
