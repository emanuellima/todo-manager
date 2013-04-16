package pt.ulht.es.todomanager.domain;

import pt.ist.fenixframework.FenixFramework;

public class TodoManager extends TodoManager_Base {

	public static TodoManager getInstance() {
		return FenixFramework.getRoot();
	}

}