package hacs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassCourseListTest {
	ClassCourseList classCourseList;

	@BeforeEach
	void start() {
		classCourseList = new ClassCourseList();
	}

	@Test
	void testFindCourseByCourseName() {
		Course course = new Course("CSE880", 0);
		assertEquals(classCourseList.FindCourseByCourseName("CSE880"), null);
		classCourseList.add(course);
		assertEquals(classCourseList.FindCourseByCourseName("CSE880"), course);
	}

	@Test
	void testInitializeFromFile() {
		classCourseList.InitializeFromFile("CourseInfo.txt");
		assertEquals(classCourseList.get(0).CourseName, "CSE870");
		assertEquals(classCourseList.get(1).CourseName, "CSE880");
		assertEquals(classCourseList.get(2).CourseName, "CSE890");
	}

}
