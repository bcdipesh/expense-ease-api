package app.vercel.dipeshbc.expenseeaseapi.mapper;

import app.vercel.dipeshbc.expenseeaseapi.dto.TransactionsDto;
import app.vercel.dipeshbc.expenseeaseapi.entity.Transactions;

public class TransactionsMapper {

    public static TransactionsDto mapToTransactionDto(Transactions transactions, TransactionsDto transactionsDto) {
        transactionsDto.setDescription(transactions.getDescription());
        transactionsDto.setAmount(transactions.getAmount());
        transactionsDto.setUserId(transactions.getUserId());

        return transactionsDto;
    }

    public static Transactions mapToTransaction(Transactions transactions, TransactionsDto transactionsDto) {
        transactions.setDescription(transactionsDto.getDescription());
        transactions.setAmount(transactionsDto.getAmount());
        transactions.setUserId(transactionsDto.getUserId());

        return transactions;
    }
}
