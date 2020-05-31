package be.ucll.david.Tasks.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    public Task() {

    }

    public Task( String title, String desc, LocalDateTime da) {
        setTitle(title);
        setDescription(desc);
        setDate(da);
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

    public Long getId() {
        return this.id;
    }


}
