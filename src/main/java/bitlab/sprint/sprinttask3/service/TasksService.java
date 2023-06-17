package bitlab.sprint.sprinttask3.service;

import bitlab.sprint.sprinttask3.model.Categories;
import bitlab.sprint.sprinttask3.model.Tasks;
import bitlab.sprint.sprinttask3.repository.CategoriesRepository;
import bitlab.sprint.sprinttask3.repository.TasksRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksService {
    @Autowired
    private TasksRepository tasksRepository;

    public List<Tasks> getAllTasks(Long id) {
        return tasksRepository.findAllByFolderId(id);
    }

    public Tasks getTaskById(Long id) {
        return tasksRepository.findById(id).orElse(null);
    }

    public void addTasks(Tasks tasks) {
        tasksRepository.save(tasks);
    }

    public void updateTask(Tasks tasks) {
        tasksRepository.save(tasks);
    }

    public void deleteTask(Long id) {
        tasksRepository.deleteById(id);
    }
    public List<Tasks> getTasksByFolder(Long id){
       return tasksRepository.getAllByFolderId(id);
    }
    @Transactional
    public void deleteAllTask(Long id){
       tasksRepository.deleteAllByFolder_Id(id);
    }

}
