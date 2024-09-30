package app.vercel.dipeshbc.expenseeaseapi.repository;

import app.vercel.dipeshbc.expenseeaseapi.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    List<Transactions> findByUserId(String userId);
}
