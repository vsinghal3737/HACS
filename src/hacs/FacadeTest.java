package hacs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.IntrospectionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hacs.UserInfoItem.USER_TYPE;

class FacadeTest {
	Facade facade;

	@BeforeEach
	void start() {
		facade = new Facade();
	}

	@Test
	void testReportSolutions() {
		Assignment assignment = new Assignment();
		assignment.theSolutionList.add(new Solution());
		facade.ReportSolutions(assignment);
		assertTrue(assignment.theSolutionList.get(0).reported);
	}

	@Test
	void testSubmitSolution() {
		Assignment assignment = new Assignment();
		Solution solution = new Solution();
		facade.SubmitSolution(assignment, solution);
		assertTrue(assignment.theSolutionList.contains(solution));
	}

	@Test
	void testCreateUser() {
		UserInfoItem user = new UserInfoItem();

		user.strUserName = "MFindler";
		user.UserType = USER_TYPE.Instructor;
		facade.CreateUser(user);
		assertEquals(facade.thePerson.UserName,"MFindler");

		user.strUserName = "Vaibhav";
		user.UserType = USER_TYPE.Student;
		facade.CreateUser(user);
		assertEquals(facade.thePerson.UserName, "Vaibhav");
	}
	
	void testCreateUserType() {
		UserInfoItem user = new UserInfoItem();

		user.strUserName = "MFindler";
		user.UserType = USER_TYPE.Instructor;
		facade.CreateUser(user);
		assertTrue(facade.thePerson instanceof Instructor);

		user.strUserName = "Vaibhav";
		user.UserType = USER_TYPE.Student;
		facade.CreateUser(user);
		assertFalse(facade.thePerson instanceof Instructor);
		
	}

	@Test
	void testCreateCourseList() {
		facade.CreateCourseList();
		assertEquals(facade.theCourseList.size(), 3);
	}

	@Test
	void testAttachCourseToUser() {
		facade.thePerson = new Student();
		facade.thePerson.UserName = "yaya";
		facade.CreateCourseList();
		facade.AttachCourseToUser();
		assertEquals(facade.thePerson.CourseList.get(1).CourseName, "CSE890");
	}

}
