package viapos.external.clover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import viapos.external.clover.helper.CloverHelper;
import viapos.external.clover.model.ChargeRequest;
import viapos.external.clover.model.ChargeResponse;
import viapos.model.Post;
import viapos.model.Transaction;

import java.util.Collections;

@Service
public class CloverService {

    @Autowired
    CloverHelper cloverHelper;

    private final RestTemplate restTemplate;
    private String url = "https://scl-sandbox.dev.clover.com/v1/charges";
    private String authorizationHeader = "Bearer 292f7640-2453-0f32-1501-80921161ec60";

    public CloverService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Transaction createCharge(Transaction transaction) {

        ChargeRequest chargeRequest = cloverHelper.convertTransaction(transaction);
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", authorizationHeader);

        HttpEntity<ChargeRequest> request = new HttpEntity<>(chargeRequest, headers);

        ChargeResponse response = restTemplate.postForObject(
                url,
                request,
                ChargeResponse.class);

        if (response != null) {
            System.out.println(response.toString());
            return cloverHelper.paresResponse(transaction, response);
        } else {
            return null;
        }
    }
}
