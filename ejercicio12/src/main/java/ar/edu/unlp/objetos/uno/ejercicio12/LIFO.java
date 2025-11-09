package ar.edu.unlp.objetos.uno.ejercicio12;

import java.util.List;

public class LIFO extends Strategy {

	@Override
	public JobDescription next(List<JobDescription> jobs) {
		return jobs.isEmpty() ? null : jobs.get(jobs.size() - 1);
	}
	
	
}
