package babu.Todo.Controller;

import babu.Todo.Service.TodoService;
import babu.Todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.createTodo(todo),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        return new ResponseEntity<>(todoService.getTodoById(id),
                HttpStatus.OK);
    }

    @GetMapping("/get")
    ResponseEntity<List<Todo>> getAllTodo() {
        return new ResponseEntity<>(todoService.getAllTodo(),
                HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.updateTodo(todo),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
    }
}
