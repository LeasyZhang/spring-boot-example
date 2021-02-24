package example.integration.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
public class WeatherResponse {

    private List<Weather> weather;

    public WeatherResponse(String main, String description) {
        this.weather = Collections.singletonList(new Weather(main, description));
    }

    public String getSummary() {
        return weather.stream()
                .map(w -> w.main + ": " + w.description)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherResponse that = (WeatherResponse) o;
        return Objects.equals(weather, that.weather);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weather);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Weather {
        private String main;
        private String description;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Weather weather = (Weather) o;
            return Objects.equals(main, weather.main) &&
                    Objects.equals(description, weather.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(main, description);
        }

    }
}
