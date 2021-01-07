package example.boot.shardingsphere.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class Content {

    String subTitle;
    Instant createTime;
    String inner;
}
