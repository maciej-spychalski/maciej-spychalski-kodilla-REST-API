package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTest {

    @Autowired
    DbService dbService;

    @Test
    public void saveTaskTestSuite() {
        // Given
        Task task1 = new Task(1L, "task1 domain", "task1 domain content");

        // When
        dbService.saveTask(task1);

        // Then
        List<Task> taskList = dbService.getAllTasks();
        Long task1Id = 0L;
        for(Task task : taskList) {
            if(task.getTitle().equals("task1 domain") && task.getContent().equals("task1 domain content")) {
                task1Id = task.getId();
            }
        }
        Optional<Task> task = dbService.getTask(task1Id);
        String title = task.get().getTitle();
        String content = task.get().getContent();
        assertEquals("task1 domain", title);
        assertEquals("task1 domain content", content);

        // CleanUp
        dbService.deleteTask(task1Id);
    }

    @Test
    public void deleteTaskTestSuite() {
        // Given
        Task task1 = new Task(1L, "task1 domain", "task1 domain content");
        Task task2 = new Task(2L, "task2 domain", "task2 domain content");
        dbService.saveTask(task1);
        dbService.saveTask(task2);
        List<Task> taskList = dbService.getAllTasks();
        int taskListSize = taskList.size();
        Long task1Id = 0L;
        Long task2Id = 0L;
        for(Task task : taskList) {
            if(task.getTitle().equals("task1 domain") && task.getContent().equals("task1 domain content")) {
                task1Id = task.getId();
            }
            if(task.getTitle().equals("task2 domain") && task.getContent().equals("task2 domain content")) {
                task2Id = task.getId();
            }
        }

        // When
        dbService.deleteTask(task1Id);

        // Then
        assertEquals(taskListSize-1, dbService.getAllTasks().size());

        // CleanUp
        dbService.deleteTask(task2Id);
    }

    @Test
    public void getTaskTestSuite() {
        // Given
        Task task1 = new Task(1L, "task1 domain", "task1 domain content");
        Task task2 = new Task(2L, "task2 domain", "task2 domain content");
        dbService.saveTask(task1);
        dbService.saveTask(task2);

        // When
        List<Task> taskList = dbService.getAllTasks();

        // Then
        Long task1Id = 0L;
        Long task2Id = 0L;
        for(Task task : taskList) {
            if(task.getTitle().equals("task1 domain") && task.getContent().equals("task1 domain content")) {
                task1Id = task.getId();
            }
            if(task.getTitle().equals("task2 domain") && task.getContent().equals("task2 domain content")) {
                task2Id = task.getId();
            }
        }
        assertTrue( taskList.size() > 1);

        // CleanUp
        dbService.deleteTask(task1Id);
        dbService.deleteTask(task2Id);
    }
}
