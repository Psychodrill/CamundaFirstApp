package camundaapp.myfirstapp.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component(value ="requestToMoesif")
public class RequestToMoesif implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'execute'");
        System.out.println("from moesif");
        System.out.println(execution.getVariableNames());
        System.out.println(execution.getVariable("catNinjaresponse"));
        System.out.println(execution.getVariable("loremPicsumResponse"));
    }

}
