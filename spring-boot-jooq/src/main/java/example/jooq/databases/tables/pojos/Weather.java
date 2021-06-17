/*
 * This file is generated by jOOQ.
*/
package example.jooq.databases.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Weather implements Serializable {

    private static final long serialVersionUID = -807854348;

    private Long      id;
    private Double    temperature;
    private String    description;
    private Timestamp createdTime;
    private Timestamp updatedTime;

    public Weather() {}

    public Weather(Weather value) {
        this.id = value.id;
        this.temperature = value.temperature;
        this.description = value.description;
        this.createdTime = value.createdTime;
        this.updatedTime = value.updatedTime;
    }

    public Weather(
        Long      id,
        Double    temperature,
        String    description,
        Timestamp createdTime,
        Timestamp updatedTime
    ) {
        this.id = id;
        this.temperature = temperature;
        this.description = description;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getUpdatedTime() {
        return this.updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Weather (");

        sb.append(id);
        sb.append(", ").append(temperature);
        sb.append(", ").append(description);
        sb.append(", ").append(createdTime);
        sb.append(", ").append(updatedTime);

        sb.append(")");
        return sb.toString();
    }
}
