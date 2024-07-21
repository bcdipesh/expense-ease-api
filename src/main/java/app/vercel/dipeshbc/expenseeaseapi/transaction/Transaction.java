package app.vercel.dipeshbc.expenseeaseapi.transaction;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("Transaction")
public record Transaction (
    @Id
    String id,
    String description,
    Double amount,
    @Column("userId")
    String userId,
    @Column("createdAt")
    LocalDateTime createdAt
) {
}
