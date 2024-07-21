package app.vercel.dipeshbc.expenseeaseapi.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("User")
public record User(
        @Id
        String id,
        @Column("kindeUserId")
        String kindeUserId,
        String email,
        String name,
        @Column("imageUrl")
        String imageUrl,
        @Column("createdAt")
        LocalDateTime createdAt,
        @Column("updatedAt")
        LocalDateTime updatedAt
) {
}
