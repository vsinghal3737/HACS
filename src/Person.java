package hacs;

import java.util.*;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

abstract public class Person {
	int type = 0; // type=0 : student, type=1 instructor
	String UserName;
	ClassCourseList CourseList;
	CourseMenu theCourseMenu;
	Course CurrentCourse;
	Assignment CurrentAssignment;

	public Person() {
		CourseList = new ClassCourseList();
	}

	abstract public CourseMenu CreateCourseMenu(Course theCourse, int theLevel);

	public void showAddButton() {
		theCourseMenu.ShowAddButtons();
	}

	public void showViewButtons() {
		theCourseMenu.ShowViewButtons();
	}

	public void showComboxes() {
		theCourseMenu.ShowComboxes();
	}

	public void showRadios() {
		theCourseMenu.ShowRadios();
	}

	public void show() {
		theCourseMenu.show();
	}

	public boolean ifLogout() {
		return theCourseMenu.ifLogout();
	}

	// show the assignment list
	public boolean ShowMenu() {
		// create a iterator for the assignment list
//    Iterator theIter=new ListIterator(CurrentCourse.AssList );
		Iterator theIter = CurrentCourse.assignmentList.iterator();
		theCourseMenu.theCourse = CurrentCourse;
		Assignment theAssignment;
		while (theIter.hasNext()) {
			theAssignment = (Assignment) theIter.next();
			theCourseMenu.AssignmentCombox.addItem(theAssignment);
		}
		return false;
	}

	public ClassCourseList GetCourseList() {
		return CourseList;
	}

	public void AddCourse(Course theCourse) {
		CourseList.add(theCourse);
	}
}