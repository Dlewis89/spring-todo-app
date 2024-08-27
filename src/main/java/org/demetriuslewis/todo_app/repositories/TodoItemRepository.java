package org.demetriuslewis.todo_app.repositories;

import org.demetriuslewis.todo_app.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
