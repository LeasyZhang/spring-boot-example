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
public class AuthorBookModel implements Serializable {

    private static final long serialVersionUID = -1345543238;

    private Integer authorId;
    private Integer bookId;

}
