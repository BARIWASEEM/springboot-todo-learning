package com.in28minutes.springboot.myfirstwebapp.hello;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.myfirstwebapp.todo.Todo;
import com.in28minutes.springboot.myfirstwebapp.todo.TodoRepository;
import com.in28minutes.springboot.myfirstwebapp.todo.TodoService;

import jakarta.validation.Valid;


@Controller
@SessionAttributes("name")
public class TodoJpaController {
	
	

	public TodoJpaController( TodoRepository todoRepository)
	{
		
		super();
	
		this.todoRepository =todoRepository;
	}
	
		
		private TodoRepository todoRepository;
	
	@RequestMapping("list-todos")
	public String listAlltodos(ModelMap model) {
		
		//right click and refactor and extrct method to cretae getLoggedInUsername methos
		String username = getLoggedInUsername(model);
		
		
		//diabling static data List<Todo> todos = todoService.findByUsername(username);
		
		//enabling jpa h2 database
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos",todos);
		return "listTodos";
	
	}


	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		
		Todo todo =new Todo(0,username,"Default Desc",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		
		return "todo";
	
	}
	
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		
		if(result.hasErrors())
		{
			
			return "todo";
			
		}
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
	
		
	//	todoService.addTodo(username,todo.getDescription(),todo.getTargetDate(),todo.isDone());
		return "redirect:list-todos";
	
	}
	
	
	
	
	@RequestMapping(value="delete-todo", method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		
		todoRepository.deleteById(id);;	
	
		//todoService.deleteByid(id);
		
	return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		
		Todo todo = todoRepository.findById(id).get();
		//Todo todo = todoService.findByid(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	

	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		
		if(result.hasErrors())
		{
			
			return "todo";
			
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		
		//String username = (String)model.get("name");
	//	todo.setUsername(username);
	//	todoService.updateTodo(todo);
		return "redirect:list-todos";

	}
	
	//got for refactor and extract =(String)model.get("name")
			private String getLoggedInUsername(ModelMap model) {
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				return auth.getName();
				
		
			}
			
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	}
	
	
	
	
	
	
	
	


