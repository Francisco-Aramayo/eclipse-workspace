package ar.edu.unlp.objetos.uno.ejercicio12;

import java.util.List;

public class FIFO extends Strategy{
	@Override
	public JobDescription next(List<JobDescription> jobs) {
		return jobs.isEmpty() ? null : jobs.get(0);
	}
}
