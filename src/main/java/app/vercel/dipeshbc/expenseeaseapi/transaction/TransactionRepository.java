package app.vercel.dipeshbc.expenseeaseapi.transaction;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TransactionRepository extends ListCrudRepository<Transaction, String> {

    List<Transaction> findAllByUserId(String userId);
}
