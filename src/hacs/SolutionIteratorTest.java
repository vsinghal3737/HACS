package hacs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionIteratorTest {

	SolutionIterator itr;
	SolutionList solList;
	Solution sol;

	@BeforeEach
	void start() {
		sol = new Solution();
		solList = new SolutionList();

		sol.theAuthor = "Vaibhav";
		sol.solutionFileName = "sol.txt";
		sol.theGrade = 1;
		sol.reported = true;

		solList.add(sol);
		itr = new SolutionIterator(solList);
	}

	@Test
	void testHasNext() {
		assertTrue(itr.hasNext());
		itr.next();
		assertFalse(itr.hasNext());
	}

	@Test
	void testNextNull() {
		solList = new SolutionList();
		itr = new SolutionIterator(solList);
		assertNull(itr.next());
	}

	@Test
	void testNext() {
		assertEquals(itr.next().theAuthor, "Vaibhav");
		assertNull(itr.next());
	}

	@Test
	void testRemove() {
		int length = itr.solutionList.size();
		itr.remove();
		assertEquals(itr.solutionList.size(), length - 1);
	}

	@Test
	void testNextString() {
		assertEquals(itr.next("Vaibhav").theAuthor, "Vaibhav");
		assertNull(itr.next("Vaibhav"));
	}

}
