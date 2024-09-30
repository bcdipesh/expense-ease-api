package app.vercel.dipeshbc.expenseeaseapi.service.impl;

import app.vercel.dipeshbc.expenseeaseapi.dto.TransactionsDto;
import app.vercel.dipeshbc.expenseeaseapi.entity.Transactions;
import app.vercel.dipeshbc.expenseeaseapi.exception.ResourceNotFoundException;
import app.vercel.dipeshbc.expenseeaseapi.mapper.TransactionsMapper;
import app.vercel.dipeshbc.expenseeaseapi.repository.TransactionsRepository;
import app.vercel.dipeshbc.expenseeaseapi.service.ITransactionsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionsServiceImpl implements ITransactionsService {

    private final TransactionsRepository transactionsRepository;

    /**
     * Creates a new transaction
     *
     * @param transactionsDto - The transaction to create
     * @return The created transaction
     */
    @Override
    public TransactionsDto save(TransactionsDto transactionsDto) {
        Transactions newTransactions = transactionsRepository.save(TransactionsMapper.mapToTransaction(new Transactions(), transactionsDto));

        return TransactionsMapper.mapToTransactionDto(newTransactions, new TransactionsDto());
    }

    /**
     * Finds all transactions
     *
     * @return The list of all transactions
     */
    @Override
    public List<TransactionsDto> findAll() {
        return transactionsRepository.findAll().stream().map(transactions -> TransactionsMapper.mapToTransactionDto(transactions, new TransactionsDto())).toList();
    }

    /**
     * Finds a transaction by id
     *
     * @param id - The id of the transaction to find
     * @return The transaction
     */
    @Override
    public TransactionsDto findById(Long id) {
        Transactions transactions = transactionsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id.toString()));

        return TransactionsMapper.mapToTransactionDto(transactions, new TransactionsDto());
    }

    /**
     * Finds all transactions by user id
     *
     * @param userId - The id of the user whose transactions to find
     * @return The list of transactions
     */
    @Override
    public List<TransactionsDto> findByUserId(String userId) {
        List<Transactions> transactions = transactionsRepository.findByUserId(userId);

        return transactions.stream().map(transaction -> TransactionsMapper.mapToTransactionDto(transaction, new TransactionsDto())).toList();
    }

    /**
     * Updates a transaction
     *
     * @param id              - The id of the transaction to update
     * @param transactionsDto - The updated transaction data
     * @return The updated transaction
     */
    @Override
    public TransactionsDto update(Long id, TransactionsDto transactionsDto) {
        Transactions transactions = transactionsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id.toString())
        );
        TransactionsMapper.mapToTransaction(transactions, transactionsDto);
        transactionsRepository.save(transactions);

        return TransactionsMapper.mapToTransactionDto(transactions, new TransactionsDto());
    }

    /**
     * Deletes a transaction by id
     *
     * @param id - The id of the transaction to delete
     */
    @Override
    public void deleteById(Long id) {
        transactionsRepository.deleteById(id);
    }
}
