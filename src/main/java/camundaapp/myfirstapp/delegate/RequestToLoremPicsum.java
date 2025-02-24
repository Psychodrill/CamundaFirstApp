package camundaapp.myfirstapp.delegate;

import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component(value ="requestToLoremPicsum")
public class RequestToLoremPicsum implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'execute'");
        //String loremPicsumResponse= "999";
        Integer id = new Random().nextInt(1000);
        RestTemplate restTemplate = new RestTemplate();
      //String resourceUrl = "https://picsum.photos/900/600";
      String resourceUrl = "https://picsum.photos/id/"+id+"/info";
      ResponseEntity<String> response  = restTemplate.getForEntity(resourceUrl, String.class);
      System.out.println(response.getBody());
      ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode download_url = root.path("download_url");


        execution.setVariable("loremPicsumResponse",download_url.asText());
    }

}
