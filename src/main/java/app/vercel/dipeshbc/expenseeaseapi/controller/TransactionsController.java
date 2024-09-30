package app.vercel.dipeshbc.expenseeaseapi.controller;

import app.vercel.dipeshbc.expenseeaseapi.dto.ErrorResponseDto;
import app.vercel.dipeshbc.expenseeaseapi.dto.TransactionsDto;
import app.vercel.dipeshbc.expenseeaseapi.service.ITransactionsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Transactions REST API",
        description = "REST API that provides CRUD (Create, Read, Update, and Delete) operations related to Transactions"
)
@RestController
@RequestMapping(value = "/api/v1/transactions", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class TransactionsController {

    private ITransactionsService transactionService;

    @Operation(summary = "Creates a new Transaction")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Transaction successfully created"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PostMapping
    public ResponseEntity<TransactionsDto> createTransaction(@Valid @RequestBody TransactionsDto transactionsDto) {
        TransactionsDto savedTransaction = transactionService.save(transactionsDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaction);
    }

    @Operation(summary = "Finds all Transactions")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully fetched all Transactions"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping
    public ResponseEntity<List<TransactionsDto>> getAllTransactions() {
        List<TransactionsDto> transactions = transactionService.findAll();

        return ResponseEntity.ok(transactions);
    }

    @Operation(summary = "Finds a Transaction by id")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Transaction successfully fetched"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<TransactionsDto> getTransactionById(@PathVariable @PositiveOrZero(message = "id must be greater than or equal to 0") Long id) {
        TransactionsDto transaction = transactionService.findById(id);

        return ResponseEntity.ok(transaction);
    }

    @Operation(summary = "Finds all Transactions by userId")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully fetched all Transactions"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/users/{id}")
    public ResponseEntity<List<TransactionsDto>> getTransactionsByUserId(@PathVariable @PositiveOrZero(message = "id must be greater than or equal to 0") String id) {
        List<TransactionsDto> transactions = transactionService.findByUserId(id);

        return ResponseEntity.ok(transactions);
    }

    @Operation(summary = "Updates a Transaction by id")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Transaction successfully updated"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<TransactionsDto> updateTransactionById(@PathVariable @PositiveOrZero(message = "id must be greater than or equal to 0") Long id, @Valid @RequestBody TransactionsDto transactionsDto) {
        TransactionsDto updatedTransaction = transactionService.update(id, transactionsDto);

        return ResponseEntity.ok(updatedTransaction);
    }

    @Operation(summary = "Deletes a Transaction by id")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Transaction successfully deleted"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionById(@PathVariable @PositiveOrZero(message = "id must be greater than or equal to 0") Long id) {
        transactionService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
