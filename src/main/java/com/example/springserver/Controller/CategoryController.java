package com.example.springserver.Controller;
import com.example.springserver.Dao.CategoryDao;
import com.example.springserver.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController
{
    @Autowired
    private CategoryDao categoryDao;

    @GetMapping("/category/get-all")
    public List<Category> getAllCategories()
    {
        return categoryDao.getAllCategories();
    }

    @PostMapping("/category/save")
    public void save(@RequestBody Category category)
    {
        categoryDao.save(category);
    }

    @DeleteMapping("/category/delete")
    public void delete(@RequestParam(value = "id") Integer id)
    {
        categoryDao.delete(id);
    }

}
