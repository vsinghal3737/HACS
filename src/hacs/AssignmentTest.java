package hacs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AssignmentTest {
	Assignment assignment;

	@BeforeEach
	void start() {
		assignment = new Assignment();
	}

	@Test
	void testAddSolution() {
		Solution solution = new Solution();
		assignment.addSolution(solution);
		assertTrue(assignment.theSolutionList.contains(solution));
	}

	@Test
	void testGetSuggestedSolution() {
		Solution solution = new Solution();
		assignment.suggestedSolution = solution;
		assertEquals(assignment.getSuggestedSolution(), solution);
	}

	@Test
	void testGetSolutionIterator() {
		assertTrue(assignment.getSolutionIterator() instanceof SolutionIterator);
	}

	@Test
	void testtoString() {
		assignment.assignmentName = "NEWTEST";
		assertEquals(assignment.toString(), "NEWTEST");
	}

	@Test
	void testGetDueDateString() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		assignment.dueDate = new Date();
		assertEquals(assignment.getDueDateString(), dateFormat.format(new Date()));
	}

	@Test
	void testSetDueDate() {
		Date today = new Date();
		assignment.setDueDate(today);
		assertEquals(today, assignment.dueDate);
	}

	@Test
	void testSetAssignmentSpec() {
		assignment.setAssignmentSpec("STRING");
		assertEquals("STRING", assignment.assignmentSpec);
	}

	@Test
	void testIsOverDue() {
		Date dueDate = new GregorianCalendar(2019, Calendar.OCTOBER, 20).getTime();
		assignment.setDueDate(dueDate);
		assertTrue(assignment.isOverDue());
		dueDate = new GregorianCalendar(2023, Calendar.NOVEMBER, 20).getTime();
		assignment.setDueDate(dueDate);
		assertFalse(assignment.isOverDue());
	}

	@Test
	void testGetSolution() {
		Solution solution = new Solution();
		solution.theAuthor = "Vaibhav";
		assignment.addSolution(solution);
		assertEquals(solution, assignment.getSolution("Vaibhav"));
	}
}
