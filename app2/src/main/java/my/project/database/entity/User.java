package my.project.database.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}
