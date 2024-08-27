package org.demetriuslewis.todo_app.controllers;

import org.demetriuslewis.todo_app.models.TodoItem;
import org.demetriuslewis.todo_app.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoFormController {
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem) {
        return "create";
    }
}
