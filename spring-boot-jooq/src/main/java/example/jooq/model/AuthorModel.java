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
public class AuthorModel implements Serializable {

    private static final long serialVersionUID = 558592531;

    private Integer id;
    private String firstName;
    private String lastName;
}
