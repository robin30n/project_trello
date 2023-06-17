package bitlab.sprint.sprinttask3.service;

import bitlab.sprint.sprinttask3.model.Categories;
import bitlab.sprint.sprinttask3.model.Folders;
import bitlab.sprint.sprinttask3.repository.FoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoldersService {
    @Autowired
    private FoldersRepository foldersRepository;

    @Autowired CategoriesService categoriesService;
    @Autowired CommentsService commentsService;
    @Autowired TasksService tasksService;

    public List<Folders> getAllFolders(){
        return foldersRepository.findAll();
    }

    public void saveFolders(Folders folders){
        foldersRepository.save(folders);
    }

    public Folders getFolderById(Long id) {
        return foldersRepository.findById(id).orElse(null);
    }


    public void choseCategories(Long folId,Long catId) {
        Folders folder = getFolderById(folId);
        Categories category = categoriesService.getCategoryById(catId);

        if (folder.getCategories()!=null){
            if (!folder.getCategories().contains(category)) folder.getCategories().add(category);
        }else {
            List<Categories> categories = new ArrayList<>();
            categories.add(category);
            folder.setCategories(categories);
        }
        foldersRepository.save(folder);
    }



    public void deleteCategory(Long folId,Long catId) {
        Folders folder = getFolderById(folId);
        Categories category = categoriesService.getCategoryById(catId);

        folder.getCategories().remove(category);
        foldersRepository.save(folder);
    }

    public void deleteFolder(Long id){
        foldersRepository.deleteById(id);
    }

}
