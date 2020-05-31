package be.ucll.david.Tasks.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class TaskDTO {


    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    public TaskDTO() {

    }


    public String getTitle() {
        return this.title;

    }
    public String getDescription() {
        return this.description;
    }
    public LocalDateTime getDate() {
        return this.date;
    }


    public void setTitle(String n) {
        if (n != null && !n.trim().isEmpty()) {
            this.title = n;
        }
    }

    public void setDescription(String d) {
        if (d != null && !d.trim().isEmpty()) {
            this.description = d;
        }
    }

    public void setDate(LocalDateTime d) {
        if (d != null) {
            this.date = d;
        }
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
