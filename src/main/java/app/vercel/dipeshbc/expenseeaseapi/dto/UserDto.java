package app.vercel.dipeshbc.expenseeaseapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String kindeUserId;

    @Email(message = "Email must be valid")
    private String email;

    @NotEmpty(message = "Name must not be empty")
    private String name;

    private String imageUrl;
}
