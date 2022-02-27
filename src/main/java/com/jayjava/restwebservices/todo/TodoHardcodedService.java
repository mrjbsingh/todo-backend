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

    public static List<Todo> findAllTodos(String username){
        List<Todo> userTodos = new ArrayList<>();

        for(int i=0; i<todoList.size(); i++){
            if(todoList.get(i).getUsername().equalsIgnoreCase(username)){
                userTodos.add(todoList.get(i));
            }
        }
        return userTodos;
    }
}
