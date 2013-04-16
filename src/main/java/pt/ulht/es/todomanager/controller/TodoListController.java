package pt.ulht.es.todomanager.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pt.ist.fenixframework.pstm.AbstractDomainObject;
import pt.ulht.es.todomanager.domain.Todo;
import pt.ulht.es.todomanager.domain.TodoList;
import pt.ulht.es.todomanager.domain.TodoManager;

@Controller
public class TodoListController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String listTodoLists(Model model) {
		model.addAttribute("todoLists", TodoManager.getInstance().getTodoListSet());
		return "listTodoLists";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/todos/{id}")
	public String toggleTodo(@PathVariable("id") String id) {
		Todo todo = AbstractDomainObject.fromExternalId(id);
		todo.toggle();
		return "redirect:/lists/" + todo.getTodoList().getExternalId();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/lists/{id}")
	public String listTodos(@PathVariable("id") String id, Model model) {
		TodoList todoList = AbstractDomainObject.fromExternalId(id);
		List<Todo> todoSortedList = new ArrayList<Todo>(todoList.getTodoSet());
		Collections.sort(todoSortedList, new Todo.CreationDateComparator());
		model.addAttribute("todoList", todoList);
		model.addAttribute("todoSortedList", todoSortedList);
		return "listTodos";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/lists/{id}/delete")
	public String deleteTodoList(@PathVariable("id") String id) {
		TodoList todoList = AbstractDomainObject.fromExternalId(id);
		todoList.delete();
		TodoManager.getInstance().removeTodoList(todoList);
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/lists")
	public String createTodoList(Model model) {
		TodoList todoList = new TodoList();
		return "redirect:/lists/" + todoList.getOid();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/lists/{id}")
	public String createTodo(@PathVariable("id") String id, @RequestParam Map<String, String> params) {
		String todoText = params.get("todoText");
		TodoList todoList = AbstractDomainObject.fromExternalId(id);
		todoList.addTodo(todoText);
		return "redirect:/lists/{id}";
	}
}