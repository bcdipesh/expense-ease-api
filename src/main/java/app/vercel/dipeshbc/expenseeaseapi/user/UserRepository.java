package app.vercel.dipeshbc.expenseeaseapi.user;

import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, String> {
}
