package example.boot.kubernetes.model;

import java.io.Serializable;
import java.util.List;

public class JokeResponse {

    private String type;
    private List<Joke> value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Joke> getValue() {
        return value;
    }

    public void setValue(List<Joke> value) {
        this.value = value;
    }
}
