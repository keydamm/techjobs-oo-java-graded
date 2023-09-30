package org.launchcode.techjobs.oo;
import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne, jobTwo);
    }

    @Test
    public void testJobConstructorSetsALlFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer );
        assertTrue(job.getLocation() instanceof Location );
        assertTrue(job.getPositionType() instanceof PositionType );
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency );

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job jobOne = new Job();
        jobOne.setName("Product tester");
        Job jobTwo = new Job();
        jobTwo.setName("Product tester");
        assertEquals(jobOne.getName(), jobTwo.getName());
        assertFalse(jobOne.getId() == jobTwo.getId());
    }
}
