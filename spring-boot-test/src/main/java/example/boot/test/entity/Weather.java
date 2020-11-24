package example.boot.test.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "temperature", nullable = false)
    private Float temperature;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "created_time")
    private Instant createdTime;

    @Column(name = "updated_time")
    private Instant updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }

    public Instant getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Instant updatedTime) {
        this.updatedTime = updatedTime;
    }


    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", description='" + description + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
