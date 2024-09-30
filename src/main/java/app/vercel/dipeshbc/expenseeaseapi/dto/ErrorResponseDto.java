package app.vercel.dipeshbc.expenseeaseapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(name = "ErrorResponse", description = "ErrorResponse schema")
@Data
@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(description = "The API request endpoint")
    private String path;

    @Schema(description = "The HTTP status code")
    private HttpStatus status;

    @Schema(description = "The error message")
    private String error;

    @Schema(description = "The timestamp when the error happened")
    private LocalDateTime timestamp;
}
