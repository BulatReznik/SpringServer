package com.example.springserver.Dao;

import com.example.springserver.Models.User;
import com.example.springserver.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserDao
{
    @Autowired
    private UserRepository repository;

    public void save(User user)
    {
        repository.save(user);
    }

    public void delete(int userId)
    {
        repository.deleteById(userId);
    }

    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(users::add);
        return users;
    }
    public User getUser(int userId) {return repository.findById(userId).get();}


}
