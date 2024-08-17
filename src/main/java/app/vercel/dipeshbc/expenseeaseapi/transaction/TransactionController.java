package app.vercel.dipeshbc.expenseeaseapi.transaction;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    List<Transaction> findAll(Pageable pageable) {
        return transactionService.findAll(pageable);
    }

    @GetMapping("/{id}")
    Optional<Transaction> findById(@PathVariable String id) {
        return transactionService.findById(id);
    }

    @GetMapping("/users/{userId}")
    List<Transaction> findAllByUserId(@PathVariable String userId) {
        return transactionService.findAllByUserId(userId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable String id) {
        transactionService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Transaction save(@RequestBody Transaction transaction) {
        return transactionService.save(transaction.description(), transaction.amount(), transaction.userId());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    Transaction update(@RequestBody Transaction transaction) {
        return transactionService.update(transaction);
    }
}
