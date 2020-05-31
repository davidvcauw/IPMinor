package be.ucll.david.Tasks.repository;

import be.ucll.david.Tasks.model.SubTask;
import be.ucll.david.Tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubTaskRepo   extends JpaRepository<SubTask, Long> {
    List<SubTask> findAllBySuperTaskId(int id);

    //public List<SubTask> getById(long id);
}
