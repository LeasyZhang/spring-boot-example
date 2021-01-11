package example.boot.kubernetes.service;

import com.google.gson.Gson;
import example.boot.kubernetes.model.JokeResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class JokeService {
    private static final Logger logger = LoggerFactory.getLogger(JokeService.class);

    private static final OkHttpClient client = new OkHttpClient.Builder().build();
    private static final String JOKE_API_BASE_URL = "https://api.icndb.com/jokes/";

    public JokeResponse getJokeById(Long id) {
        String destAddress = JOKE_API_BASE_URL + id;

        Request request = new Request.Builder()
                .url(destAddress)
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseBody = Objects.requireNonNull(response.body()).string();
            return new Gson().fromJson(responseBody, JokeResponse.class);
        } catch (IOException e) {
            logger.error("Fetch weather api error", e);
        }
        return new JokeResponse();
    }
}
