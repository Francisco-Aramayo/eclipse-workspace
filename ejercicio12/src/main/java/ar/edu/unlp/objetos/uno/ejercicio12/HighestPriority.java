package ar.edu.unlp.objetos.uno.ejercicio12;

import java.util.List;

public class HighestPriority extends Strategy {
	@Override
	public JobDescription next(List <JobDescription> jobs) {
		return jobs.stream()
				.max((j1, j2) -> Integer.compare
				(j1.getPriority(), j2.getPriority()))
				.orElse(null);
	}

}
