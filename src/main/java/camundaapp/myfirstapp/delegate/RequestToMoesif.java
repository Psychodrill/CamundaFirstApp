package camundaapp.myfirstapp.delegate;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.Random;

import javax.imageio.stream.ImageOutputStream;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value ="requestToMoesif")
public class RequestToMoesif implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        System.out.println(execution.getVariable("catNinjaresponse"));
        System.out.println(execution.getVariable("loremPicsumResponse"));
        String catNinjaResponse = (String)execution.getVariable("catNinjaresponse");
        String loremPicsumResponse =(String)execution.getVariable("loremPicsumResponse");

        //RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://textoverimage.moesif.com/image";
        System.out.println(resourceUrl + "?image_url=" + loremPicsumResponse+"&text="+catNinjaResponse+"&text_color=09eca4ff&margin=200");
        //ResponseEntity<String> response  = restTemplate.getForEntity(resourceUrl + "?image_url=" + loremPicsumResponse+"&text="+catNinjaResponse+"&text_color=3c3a45ff&margin=150", String.class);
        execution.setVariable("resultLink",resourceUrl + "?image_url=" + loremPicsumResponse+"&text="+catNinjaResponse+"&text_color=09eca4ff&margin=200");
        // File file = restTemplate.execute(resourceUrl + "?image_url=" + loremPicsumResponse+"&text="+catNinjaResponse+"&text_color=3c3a45ff&margin=150", HttpMethod.GET, null, clientHttpResponse -> {
        //     File ret = File.createTempFile("download", "tmp");
        //     StreamUtils.copy(clientHttpResponse.getBody(), new FileOutputStream(ret));
        //     return ret;
        // });



    }

}
