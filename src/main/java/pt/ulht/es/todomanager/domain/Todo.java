package pt.ulht.es.todomanager.domain;

import java.util.Comparator;

import org.joda.time.DateTime;

public class Todo extends Todo_Base {

	public Todo(String todoText) {
		setCreationTimestamp(new DateTime());
		setText(todoText);
	}

	public void complete() {
		setCompletionTimestamp(new DateTime());
	}

	public void uncomplete() {
		setCompletionTimestamp(null);
	}

	public static class CreationDateComparator implements Comparator<Todo> {

		public int compare(Todo o1, Todo o2) {
			return o1.getCreationTimestamp().compareTo(o2.getCreationTimestamp());
		}
	}

	public void toggle() {
		if (isCompleted()) {
			uncomplete();
		} else {
			complete();
		}
	}

	public boolean isCompleted() {
		return getCompletionTimestamp() != null;
	}

	public void delete() {
		setTodoList(null);
		super.deleteDomainObject();
	}

}
