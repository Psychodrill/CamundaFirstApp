package camundaapp.myfirstapp.delegate;

import org.camunda.bpm.engine.delegate.*;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.IntegerValue;
import org.camunda.bpm.engine.variable.value.StringValue;
import org.springframework.stereotype.Component;

@Component(value ="requestToCatNinja")
public class RequestToCatNinja implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // TODO Auto-generated method stub
       // throw new BpmnError("OtherDelegateTest_Error");


       execution.setVariable("catNinjaresponse","777");


    }

}
