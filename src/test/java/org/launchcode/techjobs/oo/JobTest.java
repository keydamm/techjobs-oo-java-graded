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
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", testJob.getName()); //don't need a getValue on a string
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());

        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
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

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = job.toString();
        assertEquals('\n', testString.charAt(0));
        assertEquals('\n', testString.charAt(testString.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = "\n" +
                "ID: " + job.getId() + "\n" +
                "Name: " + job.getName() + "\n" +
                "Employer: " + job.getEmployer() + "\n" +
                "Location: " + job.getLocation() + "\n" +
                "Position Type: " + job.getPositionType() + "\n" +
                "Core Competency: " + job.getCoreCompetency() + "\n";
        assertEquals(testString, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
    Job emptyJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistance"));
    String testString = "\n" +
            "ID: " + emptyJob.getId() + "\n" +
            "Name: " + emptyJob.getName() + "\n" +
            "Employer: " + emptyJob.getEmployer() + "\n" +
            "Location: " + emptyJob.getLocation() + "\n" +
            "Position Type: " + emptyJob.getPositionType() + "\n" +
            "Core Competency: " + emptyJob.getCoreCompetency() + "\n";
    assertEquals(emptyJob.toString(), testString);
    }
}