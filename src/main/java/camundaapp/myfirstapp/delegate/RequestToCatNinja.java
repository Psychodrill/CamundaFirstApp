package camundaapp.myfirstapp.delegate;

import java.util.Random;

//import java.net.http.HttpHeaders;

import org.camunda.bpm.engine.delegate.*;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.IntegerValue;
import org.camunda.bpm.engine.variable.value.StringValue;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;

@Component(value ="requestToCatNinja")
public class RequestToCatNinja implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // TODO Auto-generated method stub
       // throw new BpmnError("OtherDelegateTest_Error");
      Integer wordsCount = new Random().nextInt(20,31);
      RestTemplate restTemplate = new RestTemplate();
      String resourceUrl = "https://catfact.ninja/fact";
      ResponseEntity<String> response  = restTemplate.getForEntity(resourceUrl + "?max_length="+wordsCount, String.class);
      System.out.println(response.getBody());
      ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode fact = root.path("fact");

        execution.setVariable("catNinjaresponse",fact.asText().replace(' ', '_'));

    }

}
