package hacs;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HighLevelCourseMenu extends CourseMenu {

	/*
	 * JButton AssignmentAddButton = new JButton(); JRadioButton OptionRadio = new
	 * JRadioButton(); JComboBox OptionCombo = new JComboBox(); JButton
	 * OptionViewButton = new JButton(); JButton OptionAddButton = new JButton();
	 */

	public HighLevelCourseMenu() {
	}

	void ShowMenu(Course theCourse) {
		ShowViewButtons();
		ShowRadios();
		ShowComboxes();
		show();
	}

	void ShowAddButtons() {
		AssignmentAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssignmentAddButton_actionPerformed(e);
			}
		});
		AssignmentAddButton.setText("Add");
		AssignmentAddButton.setBounds(new Rectangle(389, 54, 79, 29));
		OptionAddButton.setText("Add");
		OptionAddButton.setBounds(new Rectangle(390, 125, 79, 29));
		this.getContentPane().add(AssignmentAddButton, null);
		this.getContentPane().add(OptionAddButton, null);
	}

	void ShowRadios() {
		AssignmentRadiao.setText("Assignment");
		AssignmentRadiao.setBounds(new Rectangle(21, 55, 103, 26));
		this.getContentPane().add(AssignmentRadiao, null);
		OptionRadio.setText("HighLevel Presentation");
		OptionRadio.setBounds(new Rectangle(21, 128, 103, 26));
		this.getContentPane().add(OptionRadio, null);
	}

	void ShowComboxes() {
		AssignmentCombox.setBounds(new Rectangle(140, 57, 126, 22));
		OptionCombo.setBounds(new Rectangle(137, 127, 126, 22));
		this.getContentPane().add(AssignmentCombox, null);
		this.getContentPane().add(OptionCombo, null);
		refresh();
	}

	void ShowViewButtons() {
		AssignmentViewButton.setText("View");
		AssignmentViewButton.setBounds(new Rectangle(290, 54, 79, 29));
		AssignmentViewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssignmentViewButton_actionPerformed(e);
			}
		});
		OptionViewButton.setText("View");
		OptionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
		this.getContentPane().add(AssignmentViewButton, null);
		this.getContentPane().add(OptionViewButton, null);
	}

	void ShowLabel() {
		AssignmentContentLable.setText("AssigmentContent");
		AssignmentContentLable.setBounds(new Rectangle(23, 186, 432, 99));
		this.getContentPane().add(AssignmentContentLable, null);
	}
}