package hacs;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.ActionEvent;

public class LowLevelCourseMenu extends CourseMenu {
    private static String ADD_ASSIGNMENT_BUTTON_TEXT = "Add";
    private static int ADD_ASSIGNMENT_BUTTON_X = 440;
    private static int ADD_ASSIGNMENT_BUTTON_Y = 54;
    private static int ADD_ASSIGNMENT_BUTTON_WIDTH = 79;
    private static int ADD_ASSIGNMENT_BUTTON_HEIGHT = 29;

    private static String ADD_OPTION_BUTTON_TEXT = "Add";
    private static int ADD_OPTION_BUTTON_X = 440;
    private static int ADD_OPTION_BUTTON_Y = 124;
    private static int ADD_OPTION_BUTTON_WIDTH = 79;
    private static int ADD_OPTION_BUTTON_HEIGHT = 29;

    private static String ADD_ASSIGNMENT_RADIO_TEXT = "Assignment";
    private static int ADD_ASSIGNMENT_RADIO_X = 21;
    private static int ADD_ASSIGNMENT_RADIO_Y = 55;
    private static int ADD_ASSIGNMENT_RADIO_WIDTH = 150;
    private static int ADD_ASSIGNMENT_RADIO_HEIGHT = 26;

    private static String ADD_OPTION_RADIO_TEXT = "Low Level Experiment";
    private static int ADD_OPTION_RADIO_X = 21;
    private static int ADD_OPTION_RADIO_Y = 128;
    private static int ADD_OPTION_RADIO_WIDTH = 150;
    private static int ADD_OPTION_RADIO_HEIGHT = 26;

    private static int ADD_ASSIGNMENT_COMBOX_X = 190;
    private static int ADD_ASSIGNMENT_COMBOX_Y = 57;
    private static int ADD_ASSIGNMENT_COMBOX_WIDTH = 126;
    private static int ADD_ASSIGNMENT_COMBOX_HEIGHT = 22;

    private static int ADD_OPTION_COMBOX_X = 190;
    private static int ADD_OPTION_COMBOX_Y = 127;
    private static int ADD_OPTION_COMBOX_WIDTH = 126;
    private static int ADD_OPTION_COMBOX_HEIGHT = 22;

    private static String VIEW_ASSIGNMENT_BUTTON_TEXT = "View";
    private static int VIEW_ASSIGNMENT_BUTTON_X = 340;
    private static int VIEW_ASSIGNMENT_BUTTON_Y = 54;
    private static int VIEW_ASSIGNMENT_BUTTON_WIDTH = 79;
    private static int VIEW_ASSIGNMENT_BUTTON_HEIGHT = 29;

    private static String VIEW_OPTION_BUTTON_TEXT = "View";
    private static int VIEW_OPTION_BUTTON_X = 340;
    private static int VIEW_OPTION_BUTTON_Y = 124;
    private static int VIEW_OPTION_BUTTON_WIDTH = 79;
    private static int VIEW_OPTION_BUTTON_HEIGHT = 29;

    private static String LABEL_TEXT = "Assignment Content";
    private static int LABEL_X = 23;
    private static int LABEL_Y = 86;
    private static int LABEL_WIDTH = 432;
    private static int LABEL_HEIGHT = 99;

    public LowLevelCourseMenu() {
    }

    void showMenu(Course theCourse) {
        showViewButtons();
        showRadios();
        showComboxes();
        showAddButtons();
        setVisible(true);
    }

    void showAddButtons() {
        assignmentAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assignmentAddButtonActionPerformed(e);
            }
        });
        assignmentAddButton.setText(ADD_ASSIGNMENT_BUTTON_TEXT);
        assignmentAddButton.setBounds(new Rectangle(ADD_ASSIGNMENT_BUTTON_X, ADD_ASSIGNMENT_BUTTON_Y, ADD_ASSIGNMENT_BUTTON_WIDTH, ADD_ASSIGNMENT_BUTTON_HEIGHT));

        optionAddButton.setText(ADD_OPTION_BUTTON_TEXT);
        optionAddButton.setBounds(new Rectangle(ADD_OPTION_BUTTON_X, ADD_OPTION_BUTTON_Y, ADD_OPTION_BUTTON_WIDTH, ADD_OPTION_BUTTON_HEIGHT));

        this.getContentPane().add(assignmentAddButton, null);
        this.getContentPane().add(optionAddButton, null);
    }

    void showRadios() {
        assignmentRadio.setText(ADD_ASSIGNMENT_RADIO_TEXT);
        assignmentRadio.setBounds(new Rectangle(ADD_ASSIGNMENT_RADIO_X, ADD_ASSIGNMENT_RADIO_Y, ADD_ASSIGNMENT_RADIO_WIDTH, ADD_ASSIGNMENT_RADIO_HEIGHT));
        this.getContentPane().add(assignmentRadio, null);

        optionRadio.setText(ADD_OPTION_RADIO_TEXT);
        optionRadio.setBounds(new Rectangle(ADD_OPTION_RADIO_X, ADD_OPTION_RADIO_Y, ADD_OPTION_RADIO_WIDTH, ADD_OPTION_RADIO_HEIGHT));
        this.getContentPane().add(optionRadio, null);
    }

    void showComboxes() {
        assignmentCombox.setBounds(new Rectangle(ADD_ASSIGNMENT_COMBOX_X, ADD_ASSIGNMENT_COMBOX_Y, ADD_ASSIGNMENT_COMBOX_WIDTH, ADD_ASSIGNMENT_COMBOX_HEIGHT));
        optionCombo.setBounds(new Rectangle(ADD_OPTION_COMBOX_X, ADD_OPTION_COMBOX_Y, ADD_OPTION_COMBOX_WIDTH, ADD_OPTION_COMBOX_HEIGHT));
        this.getContentPane().add(assignmentCombox, null);
        this.getContentPane().add(optionCombo, null);
        refresh();
    }

    void showViewButtons() {
        assignmentViewButton.setText(VIEW_ASSIGNMENT_BUTTON_TEXT);
        assignmentViewButton.setBounds(new Rectangle(VIEW_ASSIGNMENT_BUTTON_X, VIEW_ASSIGNMENT_BUTTON_Y, VIEW_ASSIGNMENT_BUTTON_WIDTH, VIEW_ASSIGNMENT_BUTTON_HEIGHT));
        assignmentViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assignmentViewButtonActionPerformed(e);
            }
        });

        optionViewButton.setText(VIEW_OPTION_BUTTON_TEXT);
        optionViewButton.setBounds(new Rectangle(VIEW_OPTION_BUTTON_X, VIEW_OPTION_BUTTON_Y, VIEW_OPTION_BUTTON_WIDTH, VIEW_OPTION_BUTTON_HEIGHT));
        this.getContentPane().add(assignmentViewButton, null);
        this.getContentPane().add(optionViewButton, null);
    }

    void showLabel() {
        assignmentContentLabel.setText(LABEL_TEXT);
        assignmentContentLabel.setBounds(new Rectangle(LABEL_X, LABEL_Y, LABEL_WIDTH, LABEL_HEIGHT));
        this.getContentPane().add(assignmentContentLabel, null);
    }
}
