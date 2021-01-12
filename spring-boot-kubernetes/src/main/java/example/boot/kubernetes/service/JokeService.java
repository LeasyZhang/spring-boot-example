package example.boot.kubernetes.service;

import com.google.gson.Gson;
import example.boot.kubernetes.model.JokeResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class JokeService {
    private static final Logger logger = LoggerFactory.getLogger(JokeService.class);

    private static final OkHttpClient client = new OkHttpClient.Builder().build();

    @Value("${third-party-api.joke-api-endpoint}")
    private String jokeAPIBase;

    public JokeResponse getJokeById(Long id) {
        String destAddress = jokeAPIBase + id;

        Request request = new Request.Builder()
                .url(destAddress)
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            logger.info("Get response from remote api {}", response.code());
            String responseBody = Objects.requireNonNull(response.body()).string();
            return new Gson().fromJson(responseBody, JokeResponse.class);
        } catch (IOException e) {
            logger.error("Fetch weather api error", e);
        }
        return new JokeResponse();
    }
}
