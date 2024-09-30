package app.vercel.dipeshbc.expenseeaseapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(name = "Transactions", description = "Transactions schema")
@Data
public class TransactionsDto {

    @Schema(description = "The Transaction description")
    @NotBlank(message = "Description cannot be empty or null")
    private String description;

    @Schema(description = "The Transaction amount")
    @NotNull(message = "Amount cannot be empty or null")
    private BigDecimal amount;

    @Schema(description = "The id of the user related to this Transaction")
    @NotEmpty(message = "User Id cannot be empty or null")
    private String userId;
}
