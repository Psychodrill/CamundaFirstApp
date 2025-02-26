package camundaapp.myfirstapp.delegate;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component(value ="addSomething")
public class addSomethingDelegate implements JavaDelegate{

    @Override
    public void execute(DelegateExecution arg0) throws Exception {

        System.out.println("Hello dude!");
    }

}
