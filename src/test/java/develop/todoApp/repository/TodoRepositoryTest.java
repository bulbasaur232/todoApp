package develop.todoApp.repository;

import develop.todoApp.entity.TaskEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoRepositoryTest {

    @Autowired
    TodoRepository repository;

    @Test
    void repoTest(){
        TaskEntity entity = new TaskEntity();
        entity.setContent("자바 공부");
        entity.setCompleted(Boolean.TRUE);
        repository.save(entity);
        TaskEntity findEntity = repository.findById(1L).get();
        Assertions.assertThat(findEntity).isNotNull();
    }
}