package ar.edu.unlp.objetos.uno.ejercicio12;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JobSchedulerTest {

    private JobScheduler schedulerFifo;
    private JobScheduler schedulerLifo;
    private JobScheduler schedulerHighest;
    private JobScheduler schedulerEffort;

    private JobDescription jobA;
    private JobDescription jobB;
    private JobDescription jobC;

    @BeforeEach
    void setUp() {
        jobA = new JobDescription(5.0, 1, "Job A");
        jobB = new JobDescription(3.0, 10, "Job B");
        jobC = new JobDescription(8.0, 5, "Job C");

        schedulerFifo     = new JobScheduler(new FIFO());
        schedulerLifo     = new JobScheduler(new LIFO());
        schedulerHighest  = new JobScheduler(new HighestPriority());
        schedulerEffort   = new JobScheduler(new MostEffort());

        schedulerFifo.schedule(jobA);
        schedulerFifo.schedule(jobB);
        schedulerFifo.schedule(jobC);

        schedulerLifo.schedule(jobA);
        schedulerLifo.schedule(jobB);
        schedulerLifo.schedule(jobC);

        schedulerHighest.schedule(jobA);
        schedulerHighest.schedule(jobB);
        schedulerHighest.schedule(jobC);

        schedulerEffort.schedule(jobA);
        schedulerEffort.schedule(jobB);
        schedulerEffort.schedule(jobC);
    }

    @Test
    public void testNextFifo() {
        JobDescription next = schedulerFifo.next();
        assertEquals(jobA, next);
        // Verificar que se removió de la cola
        assertFalse(schedulerFifo.getJobs().contains(jobA));
    }

    @Test
    public void testNextLifo() {
        JobDescription next = schedulerLifo.next();
        assertEquals(jobC, next);
        assertFalse(schedulerLifo.getJobs().contains(jobC));
    }

    @Test
    public void testNextHighestPriority() {
        // jobB tiene prioridad=10, la mayor
        JobDescription next = schedulerHighest.next();
        assertEquals(jobB, next);
        assertFalse(schedulerHighest.getJobs().contains(jobB));
    }

    @Test
    public void testNextMostEffort() {
        // jobC tiene effort=8.0, la mayor
        JobDescription next = schedulerEffort.next();
        assertEquals(jobC, next);
        assertFalse(schedulerEffort.getJobs().contains(jobC));
    }

    @Test
    public void testUnscheduleRemovesJob() {
        schedulerFifo.schedule(jobB);
        assertTrue(schedulerFifo.getJobs().contains(jobB));
        schedulerFifo.unschedule(jobB);
        assertFalse(schedulerFifo.getJobs().contains(jobB));
    }

    @Test
    public void testScheduleAddsJob() {
        JobDescription jobD = new JobDescription(2.0, 2, "Job D");
        schedulerFifo.schedule(jobD);
        assertTrue(schedulerFifo.getJobs().contains(jobD));
    }

    @Test
    public void testNextWhenEmptyReturnsNull() {
        JobScheduler empty = new JobScheduler(new FIFO());
        assertTrue(empty.getJobs().isEmpty());
        assertNull(empty.next());
    }
}

