package org.example;

import com.github.tomakehurst.wiremock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.get;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class Main {
    public static void main(String[] args) {
        WireMockServer server = new WireMockServer(8080);
        server.stubFor(get(urlEqualTo("/test"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("test.json")
                ));
        server.start();
        System.out.println("Mock server is running on port 8080");
    }
}