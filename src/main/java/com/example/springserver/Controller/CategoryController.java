package com.example.springserver.Controller;
import com.example.springserver.Dao.CategoryDao;
import com.example.springserver.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public void save(@RequestBody Category category) {categoryDao.save(category);}

    /*
    @DeleteMapping("/category/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) { categoryDao.delete(id);}
*/

    @GetMapping("/category/{id}")
    public void getCategory(@PathVariable(value = "id") Integer id){categoryDao.getCategory(id);}


    @RequestMapping(value = "/category/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        try {
            categoryDao.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

}
