package app.vercel.dipeshbc.expensetrackerapi.user;

import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, String> {
}
