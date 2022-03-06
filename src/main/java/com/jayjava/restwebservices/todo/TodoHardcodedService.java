package com.jayjava.restwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {
    private static List<Todo> todoList = new ArrayList<>();
    private static int idCounter = 0;
    static {
        todoList.add(new Todo(++idCounter, "Jay", "Learn English Grammar", new Date(), false));
        todoList.add(new Todo(++idCounter, "Jay", "Learn React", new Date(), false));
        todoList.add(new Todo(++idCounter, "Jay", "Learn Spring", new Date(), false));
        todoList.add(new Todo(++idCounter, "Anurag", "Learn Maven", new Date(), false));
        todoList.add(new Todo(++idCounter, "Anurag", "Learn to Dance", new Date(), false));
    }

    public List<Todo> findAllTodos(String username){
        List<Todo> userTodos = new ArrayList<>();

        for(int i=0; i<todoList.size(); i++){
            if(todoList.get(i).getUsername().equalsIgnoreCase(username)){
                userTodos.add(todoList.get(i));
            }
        }
        return userTodos;
    }

    public Todo getTodoById(String username, long id){
        return findByID(id);
    }

    public Todo saveTodo(Todo todo){
        if(todo.getId()==-1 || todo.getId()==0){       //if this is new we will have -1 as default id
            todo.setId(++idCounter);
            todoList.add(todo);
        }else{
            deleteTodoById(todo.getId());
            todoList.add(todo);
        }
        return todo;
    }

    public Todo deleteTodoById(long id){
        Todo todo = findByID(id);
        if(todo==null) return null;
        if(todoList.remove(todo)){
            return todo;
        }
        return null;
    }

    public Todo findByID(long id) {
        for( Todo todo:todoList){
            if(todo.getId() == id ){
                return todo;
            }
        }
        return null;
    }
}
