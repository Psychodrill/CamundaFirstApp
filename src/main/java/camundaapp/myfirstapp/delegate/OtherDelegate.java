package camundaapp.myfirstapp.delegate;

import org.camunda.bpm.engine.delegate.*;

import org.springframework.stereotype.Component;

@Component(value ="otherDelegate")
public class OtherDelegate implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // TODO Auto-generated method stub
       // throw new BpmnError("OtherDelegateTest_Error");
    }

}
