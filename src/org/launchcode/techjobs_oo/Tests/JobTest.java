package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.CoreCompetency;

public class JobTest {

    Job testJobOne;
    Job testEmptyJob;
    Job testEqualsJobOne;

    @Before
    public void createJobObjects() {
        testJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testEmptyJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        testEqualsJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }


    @Test
    public void testSettingJobId() {
        assertFalse(testJobOne.getId() == testEmptyJob.getId());
        assertEquals(1, testEmptyJob.getId() - testJobOne.getId(), .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testJobOne.getEmployer() instanceof Employer);
        assertEquals("ACME", testJobOne.getEmployer().getValue());

        assertTrue(testJobOne.getLocation() instanceof Location);
        assertEquals("Desert", testJobOne.getLocation().getValue());

        assertTrue(testJobOne.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJobOne.getPositionType().getValue());

        assertTrue(testJobOne.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJobOne.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJobOne == testEqualsJobOne);
    }

    @Test
    public void testToStringMethod() {
        assertEquals("\n" +
                "ID: 1\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence" +
                "\n", testJobOne.toString());

        assertEquals("OOPS! This job does not seem to exist.", testEmptyJob.toString());
    }
}


