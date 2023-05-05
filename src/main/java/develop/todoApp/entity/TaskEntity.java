package develop.todoApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(length=200) // 200자 제한
    private String content;

    @Column(nullable = false)
    private boolean completed = false;

}
