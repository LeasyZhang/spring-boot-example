package example.boot.actuator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String url;
    private String title;
    private String director;
    private String type;
    private String imageUrl;
}
