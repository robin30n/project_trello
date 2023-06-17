package bitlab.sprint.sprinttask3.service;

import bitlab.sprint.sprinttask3.model.Categories;
import bitlab.sprint.sprinttask3.model.Folders;
import bitlab.sprint.sprinttask3.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Categories> getAllCategories(){
        return categoriesRepository.findAll();
    }

    public void saveCategories(Categories categories){
        categoriesRepository.save(categories);
    }

    public Categories getCategoryById(Long id){
        return categoriesRepository.findById(id).orElse(null);
    }

    public void addCategories(Categories categories) {
        categoriesRepository.save(categories);
    }

}
