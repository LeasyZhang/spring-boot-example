package com.springboot.exmaple.api;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.springboot.exmaple.service.ThirdPartyService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ThirdPartyServiceTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8080);

    @Autowired
    private ThirdPartyService thirdPartyService;

    @Before
    public void init() {

    }

    @Test
    public void testStatusAPI() {
        stubFor(get(urlEqualTo("/api/third/status"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"status\":200,\"message\":\"OK\"}")));


        String result = thirdPartyService.callThirdParty();
        assertEquals("Done", result);
    }
}
