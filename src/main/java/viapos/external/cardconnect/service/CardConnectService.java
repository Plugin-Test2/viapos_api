package viapos.external.cardconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import viapos.external.cardconnect.helper.CardConnectHelper;
import viapos.external.cardconnect.model.AuthorizationResponse;
import viapos.external.cardconnect.model.Authorization;
import viapos.model.Post;
import viapos.model.Transaction;

import java.util.Collections;

@Service
public class CardConnectService {

    @Autowired
    CardConnectHelper cardConnectHelper;

    private final RestTemplate restTemplate;
    private String url = "https://fts-uat.cardconnect.com/cardconnect/rest/auth";
    private String authorizationHeader = "Basic dGVzdGluZzp0ZXN0aW5nMTIz";
    private String mid = "ç";

    public CardConnectService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Transaction authorizeTransaction(Transaction transaction, String merchantId) {

        Authorization authorization = cardConnectHelper.convertTransaction(transaction, merchantId);
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", authorizationHeader);

        HttpEntity<Authorization> request = new HttpEntity<>(authorization, headers);
        System.out.println(authorization.toString());

        AuthorizationResponse response = restTemplate.postForObject(
                url,
                request,
                AuthorizationResponse.class);

        if (response != null) {
            System.out.println(response.toString());
            return cardConnectHelper.paresResponse(transaction, response);
        } else {
            return null;
        }
    }
}
