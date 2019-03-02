package it.mastermind.mmspring.services;


public interface UserService {


    void save(String username, String password);

    boolean existsByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    int getIdByUsername(String username);

    String getUsernameById(int id);

}
