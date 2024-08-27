package org.demetriuslewis.todo_app.controllers;

import org.demetriuslewis.todo_app.models.TodoItem;
import org.demetriuslewis.todo_app.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("todoItems", todoItemService.getAll());

        return modelAndView;
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {
        TodoItem item = new TodoItem();

        item.setDescription(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());

        todoItemService.save(todoItem);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemService.getById(id).orElseThrow(()-> new IllegalArgumentException("todoItem id: " + id + " not found"));

        model.addAttribute("todo", todoItem);


        return "edit";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model) {
        TodoItem item = todoItemService.getById(id).orElseThrow(()-> new IllegalArgumentException("todoItem id: " + id + " not found"));

        item.setIsComplete(todoItem.getIsComplete());
        item.setDescription(todoItem.getDescription());

        todoItemService.save(item);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemService.getById(id).orElseThrow(() -> new IllegalArgumentException("todoItem id: " + id + " not found"));

       todoItemService.delete(todoItem);

       return "redirect:/";
    }

}
