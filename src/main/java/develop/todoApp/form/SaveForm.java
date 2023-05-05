package develop.todoApp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SaveForm {

    @NotBlank
    private String content;
}
