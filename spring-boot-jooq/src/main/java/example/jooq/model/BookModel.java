package example.jooq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookModel implements Serializable {

    private static final long serialVersionUID = -662146535;

    private Integer id;
    private String title;

}
