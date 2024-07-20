package app.vercel.dipeshbc.expensetrackerapi.transaction;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final JdbcAggregateTemplate jdbcAggregateTemplate;

    public TransactionService(TransactionRepository transactionRepository, JdbcAggregateTemplate jdbcAggregateTemplate) {
        this.transactionRepository = transactionRepository;
        this.jdbcAggregateTemplate = jdbcAggregateTemplate;
    }

    List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    Optional<Transaction> findById(String id) {
        return transactionRepository.findById(id);
    }

    List<Transaction> findAllByUserId(String userId) {
        return transactionRepository.findAllByUserId(userId);
    }

    void deleteById(String id) {
        transactionRepository.deleteById(id);
    }

    public Transaction save(String description, Double amount, String userId) {
        String id = UUID.randomUUID().toString();
        LocalDateTime createdAt = LocalDateTime.now();

        Transaction transaction = new Transaction(id, description, amount, userId, createdAt);
        jdbcAggregateTemplate.insert(transaction);
        return transactionRepository.save(transaction);
    }
}
