package be.ucll.david.Tasks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class SubTask {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Integer superTaskId;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    public SubTask(){

    }

    public SubTask(String t, String desc, Integer sti) {
        setTitle(t);
        setDescription(desc);
        setSuperTaskId(sti);
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
