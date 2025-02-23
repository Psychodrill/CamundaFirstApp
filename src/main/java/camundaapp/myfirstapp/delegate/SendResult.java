package camundaapp.myfirstapp.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component(value ="sendResult")
public class SendResult implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

}
