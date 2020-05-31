package be.ucll.david.Tasks.repository;

import be.ucll.david.Tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface TaskRepo  extends JpaRepository<Task, Long> {

    public Task getById(long id);

    @Modifying
    @Transactional
    @Query("update Task t set t.title = ?2, t.description = ?3, t.date = ?4 where t.id = ?1")
    public void UpdateTask(long id, String title, String description, LocalDateTime time);



}
