package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {

    @Autowired
    TaskMapper taskMapper;

    @Test
    public void taskMapperMapToTaskTestSuite() {
        // Given
        TaskDto taskDto = new TaskDto(1L, "task Dto", "task Dto content");

        // When
        Task task = taskMapper.mapToTask(taskDto);

        // Then
//        assertEquals(1L, task.getId());
        assertEquals(1L, (long) task.getId());
        assertEquals("task Dto", task.getTitle());
        assertEquals("task Dto content", task.getContent());
    }

    @Test
    public void taskMapperMapToTaskDtoTestSuite() {
        // Given
        Task task = new Task(1L, "task domain", "task domain content");

        // When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, (long) taskDto.getId());
        assertEquals("task domain", taskDto.getTitle());
        assertEquals("task domain content", taskDto.getContent());
    }

    @Test
    public void taskMapperMapToTaskDtoListTestSuite() {
        // Given
        Task task1 = new Task(1L, "task1 domain", "task1 domain content");
        Task task2 = new Task(2L, "task2 domain", "task2 domain content");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        // When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(2,taskDtoList.size());
        assertEquals(1L, (long) taskDtoList.get(0).getId());
        assertEquals("task1 domain", taskDtoList.get(0).getTitle());
        assertEquals("task1 domain content", taskDtoList.get(0).getContent());
    }
}
