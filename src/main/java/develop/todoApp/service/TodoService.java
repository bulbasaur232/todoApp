package develop.todoApp.service;

import develop.todoApp.entity.TaskEntity;
import develop.todoApp.form.SaveForm;
import develop.todoApp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<TaskEntity> getList(){
        return todoRepository.findAll();
    }

    public TaskEntity saveTask(SaveForm saveForm){
        TaskEntity taskEntity = getEntity(saveForm);
        todoRepository.save(taskEntity);
        return taskEntity;
    }

    public void deleteTask(Long id){
        todoRepository.deleteById(id);
    }

    private static TaskEntity getEntity(SaveForm saveForm) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setContent(saveForm.getContent());
        return taskEntity;
    }
}
