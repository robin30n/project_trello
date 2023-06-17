package bitlab.sprint.sprinttask3.service;

import bitlab.sprint.sprinttask3.model.Comments;
import bitlab.sprint.sprinttask3.model.Tasks;
import bitlab.sprint.sprinttask3.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentsService {
    @Autowired
    CommentsRepository commentsRepository;


    public List<Comments> getAllComments(Long id){
        return commentsRepository.findAllByTaskId(id);
    }
    public void saveComments(Comments comments){
        commentsRepository.save(comments);
    }

    public void deleteComment(Long id){
        commentsRepository.deleteAllByTaskId(id);
    }


    public void deleteAllComments(List<Tasks> tasks){
        List<Long> id = tasks.stream()
                .map(Tasks::getId)
                .collect(Collectors.toList());
        commentsRepository.deleteAllByTaskIdIn(id);
    }



}
