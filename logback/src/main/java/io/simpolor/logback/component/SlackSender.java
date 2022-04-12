package io.simpolor.logback.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
@RequiredArgsConstructor
public class SlackSender {

    private RestTemplate restTemplate = new RestTemplate();

    public String send() {

        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .scheme("https")
                        .host("hooks.slack.com")
                        .path("/services/T8QPXMJPP/BRH0X8XFG/KJ6cSPhM0koY8wlrSEdjF1Hx")
                        .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("text", "This is test");

        HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(uriComponents.toUriString(), entity, String.class);

            return response.getBody();

        } catch (Exception e) {
            log.error("SlackSender error : {}", e.getMessage());

            return "fail";
        }
    }

}
