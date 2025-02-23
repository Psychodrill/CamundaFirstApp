package camundaapp.myfirstapp.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
@Component(value ="requestToLoremPicsum")
public class RequestToLoremPicsum implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'execute'");
        String loremPicsumResponse= "999";
        execution.setVariable("loremPicsumResponse",loremPicsumResponse);
    }

}
