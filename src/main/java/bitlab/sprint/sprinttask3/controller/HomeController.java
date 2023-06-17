package bitlab.sprint.sprinttask3.controller;

import bitlab.sprint.sprinttask3.enam.TaskStatus;
import bitlab.sprint.sprinttask3.model.Comments;
import bitlab.sprint.sprinttask3.model.Folders;
import bitlab.sprint.sprinttask3.model.Categories;
import bitlab.sprint.sprinttask3.model.Tasks;
import bitlab.sprint.sprinttask3.service.CategoriesService;
import bitlab.sprint.sprinttask3.service.CommentsService;
import bitlab.sprint.sprinttask3.service.FoldersService;
import bitlab.sprint.sprinttask3.service.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final FoldersService foldersService;
    private final CategoriesService categoriesService;
    private final TasksService tasksService;
    private final CommentsService commentsService;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("folders",foldersService.getAllFolders());
        return "main-page";
    }

    @PostMapping(value = "/add-folder")
    public String addFolder(Folders folders){
        foldersService.saveFolders(folders);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{folderId}")
    public String details(@PathVariable(name = "folderId") Long id, Model model) {
        Folders folders = foldersService.getFolderById(id);
        model.addAttribute("folder",folders);

        List<Categories> categories = folders.getCategories();
        model.addAttribute("currentCategories",categories);

        List<Categories> categories1 = categoriesService.getAllCategories();
        categories1.removeAll(categories);
        model.addAttribute("allCategories",categories1);

        model.addAttribute("tasks",tasksService.getAllTasks(id));

        return "details";
    }

    @PostMapping(value = "/chose-category")
    public String choseCategory(@RequestParam(name = "categoryId") Long categoryId,
                              @RequestParam(name = "folderId") Long folderId){
        foldersService.choseCategories(folderId,categoryId);
        return "redirect:/details/"+folderId;
    }

    @PostMapping(value = "/add-category")
    public String addCategory(Categories categories,
                              @RequestParam(name = "id")Long folderId){
        categoriesService.addCategories(categories);
        return "redirect:/details/"+folderId;
    }

    @PostMapping(value = "/delete-category")
    public String deleteCategory(@RequestParam(name = "categoryId") Long categoryId,
                                 @RequestParam(name = "folderId") Long folderId){
        foldersService.deleteCategory(folderId,categoryId);
        return "redirect:/details/"+folderId;
    }

    @PostMapping(value = "/add-task")
    public String addTask(Tasks task){
        task.setStatus(TaskStatus.TODO);
        tasksService.addTasks(task);
        return "redirect:/details/" + task.getFolder().getId();
    }

    @GetMapping(value = "/details/{folderId}/viewMore/{taskId}")
    public String viewMore(@PathVariable(name = "folderId") Long folderId,
            @PathVariable(name = "taskId") Long taskId,
                           Model model) {
        model.addAttribute("task",tasksService.getTaskById(taskId));
        model.addAttribute("folder",foldersService.getFolderById(folderId));
        model.addAttribute("comments",commentsService.getAllComments(taskId));
        return "view-more";
    }

    @PostMapping(value = "/update-task")
    public String updateTask(Tasks tasks){
        tasksService.updateTask(tasks);
        return "redirect:/details/" + tasks.getFolder().getId();
    }

    @PostMapping(value = "/delete-task")
    public String deleteTask(@RequestParam(name = "taskId") Long taskId,
                             @RequestParam(name = "folderId") Long folderId){
        commentsService.deleteComment(taskId);
        tasksService.deleteTask(taskId);
        return "redirect:/details/" + folderId;
    }

    @PostMapping(value = "/delete-folder")
    public String deleteTask(@RequestParam(name = "id") Long id){
        Folders folders = foldersService.getFolderById(id);
        List<Tasks> tasks = tasksService.getTasksByFolder(id);


        commentsService.deleteAllComments(tasks);
        tasksService.deleteAllTask(folders.getId());
        foldersService.deleteFolder(id);
        return "redirect:/";
    }

    @PostMapping(value = "add-comment")
    public String addComment(Comments comments,
                             @RequestParam(name = "folderId") Long id){
        commentsService.saveComments(comments);
        return "redirect:/details/" + id + "/viewMore/"+comments.getTask().getId();
    }
}
