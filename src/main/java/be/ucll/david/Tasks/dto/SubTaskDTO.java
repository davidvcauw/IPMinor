package be.ucll.david.Tasks.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SubTaskDTO {

    @NotNull
    private Integer superTaskId;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    public SubTaskDTO() {

    }


    public void setSuperTaskId(Integer sti2) {
        this.superTaskId = sti2;
    }

    public void setTitle(String t) {
        this.title = t;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getSuperTaskId() {
        return this.superTaskId;
    }
}
