package com.example.springserver.Dao;

import com.example.springserver.Models.Category;
import com.example.springserver.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryDao
{
    @Autowired
    private CategoryRepository repository;

    public void save(Category category)
    {
        repository.save(category);
    }

    public void delete(int categoryId)
    {
        repository.deleteById(categoryId);
    }

    public Category getCategory(int categoryId) {return repository.findById(categoryId).get();}

    public List<Category> getAllCategories()
    {
        List<Category> categories = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(categories::add);
        return categories;
    }
}
