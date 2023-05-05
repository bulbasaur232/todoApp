package develop.todoApp.repository;

import develop.todoApp.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TaskEntity, Long> {
    // 리포지토리에 저장할 객체 타입과 기본키의 자료형 지정
}
