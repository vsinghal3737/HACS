package hacs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseIteratorTest {
	CourseIterator itr;
	ClassCourseList courseList;

	@BeforeEach
	void start() {
		courseList = new ClassCourseList();
		courseList.InitializeFromFile("CourseInfo.txt");
		itr = new CourseIterator(courseList);
	}

	@Test
	void testHasNext() {
		assertTrue(itr.hasNext());
		courseList = new ClassCourseList();
		itr = new CourseIterator(courseList);
		assertFalse(itr.hasNext());
	}

	@Test
	void testNext() {
		assertEquals(itr.next().CourseName, "CSE870");
		assertEquals(itr.next().CourseName, "CSE880");
	}

	@Test
	void testNextNull() {
		courseList = new ClassCourseList();
		itr = new CourseIterator(courseList);
		assertNull(itr.next());

	}

	@Test
	void testRemove() {
		int length = itr.theCourseList.size();
		itr.remove();
		assertEquals(itr.theCourseList.size(), length - 1);
	}

	@Test
	void testNextString() {
		assertEquals(itr.next("CSE880").CourseName, "CSE880");
		assertNull(itr.next("CS"));
	}

}
