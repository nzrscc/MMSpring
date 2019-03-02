package it.mastermind.mmspring.services;

import it.mastermind.mmspring.dao.UserRepository;
import it.mastermind.mmspring.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository theUserRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
        this.theUserRepository = theUserRepository;
    }


    @Override
    public void save(String username, String password) {

        String timeStamp= new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date());
        UserModel userModel = new UserModel(username, password, timeStamp);
        theUserRepository.save(userModel);
    }

    @Override
    public boolean existsByUsernameAndPassword(String username, String password) {

        return theUserRepository.existsByUsernameAndPassword(username,password);
    }

    @Override
    public boolean existsByUsername(String username) {
        return theUserRepository.existsByUsername(username);
    }

    @Override
    public int getIdByUsername(String username)
    {

        UserModel userModel = theUserRepository.getUserByUsername(username);
        return userModel.getId();
    }

    @Override
    public String getUsernameById(int id) {

        UserModel userModel = theUserRepository.getUserById(id);
        return userModel.getUsername();
    }
}

