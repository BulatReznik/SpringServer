package com.example.springserver.Controller;

import com.example.springserver.Dao.UserDao;
import com.example.springserver.Models.User;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserDao userDao;

    @GetMapping("/user/get-all")
    public List<User> getAllUsers()
    {
        return userDao.getAllUsers();
    }

    @PostMapping("/user/save")
    public void save(@RequestBody User user)
    {
        userDao.save(user);
    }

    @DeleteMapping("/user/delete")
    public void delete(@RequestParam(value = "id") Integer id) {userDao.delete(id);}

}
