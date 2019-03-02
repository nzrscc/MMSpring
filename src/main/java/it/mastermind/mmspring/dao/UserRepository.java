package it.mastermind.mmspring.dao;

import it.mastermind.mmspring.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    boolean existsByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    UserModel getUserByUsername(String username);

    UserModel getUserById(int id);
}
