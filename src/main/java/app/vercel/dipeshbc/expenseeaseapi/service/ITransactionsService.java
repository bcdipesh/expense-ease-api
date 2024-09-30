package app.vercel.dipeshbc.expenseeaseapi.service;

import app.vercel.dipeshbc.expenseeaseapi.dto.TransactionsDto;

import java.util.List;

public interface ITransactionsService {

    /**
     * Creates a new transaction
     *
     * @param transactionsDto - The transaction to create
     * @return The created transaction
     */
    TransactionsDto save(TransactionsDto transactionsDto);

    /**
     * Finds all transactions
     *
     * @return The list of all transactions
     */
    List<TransactionsDto> findAll();

    /**
     * Finds a transaction by id
     *
     * @param id - The id of the transaction to find
     * @return The transaction
     */
    TransactionsDto findById(Long id);

    /**
     * Finds all transactions by user id
     *
     * @param userId - The id of the user whose transactions to find
     * @return The list of transactions
     */
    List<TransactionsDto> findByUserId(String userId);

    /**
     * Updates a transaction
     *
     * @param id             - The id of the transaction to update
     * @param transactionsDto - The updated transaction data
     * @return The updated transaction
     */
    TransactionsDto update(Long id, TransactionsDto transactionsDto);

    /**
     * Deletes a transaction by id
     *
     * @param id - The id of the transaction to delete
     */
    void deleteById(Long id);

}
