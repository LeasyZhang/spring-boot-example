package com.springboot.exmaple.service.impl;

import com.springboot.exmaple.service.ThirdPartyService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ThirdPartyServiceImpl implements ThirdPartyService {

    private final Logger logger = LoggerFactory.getLogger(ThirdPartyServiceImpl.class);

    @Value("${app.thirdParty.url}")
    private String thirdPartyUrl;

    @Override
    public String callThirdParty() {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(thirdPartyUrl)
                .header("Accept","application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            logger.info(responseBody);
        } catch (IOException e) {
            return "Fail";
        }

        return "Done";
    }
}
