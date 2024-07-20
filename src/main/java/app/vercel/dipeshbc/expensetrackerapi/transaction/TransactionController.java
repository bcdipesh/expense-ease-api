package app.vercel.dipeshbc.expensetrackerapi.transaction;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Transaction> findById(@PathVariable String id) {
        return transactionRepository.findById(id);
    }

    @GetMapping("/users/{userId}")
    List<Transaction> findByUserId(@PathVariable String userId) {
        return transactionRepository.findAllByUserId(userId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable String id) {
        transactionRepository.deleteById(id);
    }
}
