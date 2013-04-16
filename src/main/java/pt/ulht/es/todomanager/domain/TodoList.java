package pt.ulht.es.todomanager.domain;

public class TodoList extends TodoList_Base {

	public TodoList() {
		setTodoManager(TodoManager.getInstance());
	}

	public void addTodo(String todoText) {
		addTodo(new Todo(todoText));
	}

	public void delete() {
		for (Todo todo : getTodoSet()) {
			todo.delete();
		}
		setTodoManager(null);
		super.deleteDomainObject();
	}
}
