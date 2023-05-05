package develop.todoApp.controller;

import develop.todoApp.form.SaveForm;
import develop.todoApp.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/todoList")
public class TodoController {

    private final TodoService todoService;

    //목록 조회하는 홈 화면
    @GetMapping
    public String home(Model model){
        model.addAttribute("todoList", todoService.getList());
        return "todolist";
    }

    //할 일 추가 폼
    @GetMapping("/add")
    public String addForm(@ModelAttribute("saveForm") SaveForm saveForm){
        return "addform";
    }

    //할 일 추가
    @PostMapping("/add")
    public String add(@Validated @ModelAttribute SaveForm saveForm){
        todoService.saveTask(saveForm);
        return "redirect:/todoList";
    }

    //목록 조회에서 삭제 버튼을 누르면 삭제
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        todoService.deleteTask(id);
        return "redirect:/todoList";
    }

}
