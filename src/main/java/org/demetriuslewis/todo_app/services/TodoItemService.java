package org.demetriuslewis.todo_app.services;

import java.time.Instant;
import java.util.Optional;

import org.demetriuslewis.todo_app.models.TodoItem;
import org.demetriuslewis.todo_app.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    public Iterable<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> getById(Long id) {
        return todoItemRepository.findById(id);
    }

    public TodoItem save(TodoItem todoItem) {
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(Instant.now());
        }

        todoItem.setUpdatedAt(Instant.now());

        return todoItemRepository.save(todoItem);
    }
    
    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }
}
