package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class CourseSelectDlg extends JDialog {
    private static int MODAL_WIDTH = 420;
    private static int MODAL_HEIGHT = 240;

    private static int COMBOBOX_X = 155;
    private static int COMBOBOX_Y = 41;
    private static int COMBOBOX_WIDTH = 103;
    private static int COMBOBOX_HEIGHT = 22;

    private static int HIGH_LEVEL_RADIO_X = 50;
    private static int HIGH_LEVEL_RADIO_Y = 87;
    private static int HIGH_LEVEL_RADIO_WIDTH = 103;
    private static int HIGH_LEVEL_RADIO_HEIGHT = 26;
    private static String HIGH_LEVEL_RADIO_TEXT = "High Level";

    private static int LOW_LEVEL_RADIO_X = 236;
    private static int LOW_LEVEL_RADIO_Y = 87;
    private static int LOW_LEVEL_RADIO_WIDTH = 103;
    private static int LOW_LEVEL_RADIO_HEIGHT = 26;
    private static String LOW_LEVEL_RADIO_TEXT = "Low Level";

    private static int J_LABEL_X = 39;
    private static int J_LABEL_Y = 44;
    private static int J_LABEL_WIDTH = 85;
    private static int J_LABEL_HEIGHT = 18;
    private static String J_LABEL_TEXT = "Course Name";

    private static int OK_BUTTON_X = 78;
    private static int OK_BUTTON_Y = 139;
    private static int OK_BUTTON_WIDTH = 79;
    private static int OK_BUTTON_HEIGHT = 29;
    private static String OK_BUTTON_TEXT = "OK";

    private static int LOGOUT_BUTTON_X = 224;
    private static int LOGOUT_BUTTON_Y = 140;
    private static int LOGOUT_BUTTON_WIDTH = 73;
    private static int LOGOUT_BUTTON_HEIGHT = 31;
    private static String LOGOUT_BUTTON_TEXT = "Logout";

    // 0 HighLevel presentation 1 LowLevel Experiment
    ClassCourseList theCourseList;
    Course selectedCourse;
    int nCourseLevel = 0;
    boolean bLogout = false;
    JComboBox comboBox = new JComboBox();
    JRadioButton highLevelRadio = new JRadioButton();
    JRadioButton lowLevelRadio = new JRadioButton();
    JLabel jLabel1 = new JLabel();
    JButton okButton = new JButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    JButton buttonLogout = new JButton();

    public CourseSelectDlg() {
        try {
            jbInit();
            setSize(MODAL_WIDTH, MODAL_HEIGHT);
            setModal(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        comboBox.setBounds(new Rectangle(COMBOBOX_X, COMBOBOX_Y, COMBOBOX_WIDTH, COMBOBOX_HEIGHT));

        highLevelRadio.setText(HIGH_LEVEL_RADIO_TEXT);
        highLevelRadio.setBounds(new Rectangle(HIGH_LEVEL_RADIO_X, HIGH_LEVEL_RADIO_Y, HIGH_LEVEL_RADIO_WIDTH, HIGH_LEVEL_RADIO_HEIGHT));

        lowLevelRadio.setToolTipText(LOW_LEVEL_RADIO_TEXT);
        lowLevelRadio.setSelected(true);
        lowLevelRadio.setText(LOW_LEVEL_RADIO_TEXT);
        lowLevelRadio.setBounds(new Rectangle(LOW_LEVEL_RADIO_X, LOW_LEVEL_RADIO_Y, LOW_LEVEL_RADIO_WIDTH, LOW_LEVEL_RADIO_HEIGHT));

        jLabel1.setText(J_LABEL_TEXT);
        jLabel1.setBounds(new Rectangle(J_LABEL_X, J_LABEL_Y, J_LABEL_WIDTH, J_LABEL_HEIGHT));

        okButton.setText(OK_BUTTON_TEXT);
        okButton.setBounds(new Rectangle(OK_BUTTON_X, OK_BUTTON_Y, OK_BUTTON_WIDTH, OK_BUTTON_HEIGHT));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okButtonActionPerformed(e);
            }
        });

        buttonLogout.setText(LOGOUT_BUTTON_TEXT);
        buttonLogout.setBounds(new Rectangle(LOGOUT_BUTTON_X, LOGOUT_BUTTON_Y, LOGOUT_BUTTON_WIDTH, LOGOUT_BUTTON_HEIGHT));
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonLogoutActionPerformed(e);
            }
        });

        this.getContentPane().add(comboBox, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(highLevelRadio, null);
        this.getContentPane().add(lowLevelRadio, null);
        this.getContentPane().add(okButton, null);
        this.getContentPane().add(buttonLogout, null);
        buttonGroup1.add(highLevelRadio);
        buttonGroup1.add(lowLevelRadio);
    }

    /*
     * show the theCourseList in a combox Show the Course type selection button
     * return the pointer pointing to the Course object return the Course Type
     */

    public Course ShowDlg(ClassCourseList courseList) {

        theCourseList = courseList;
        CourseIterator theIterator = new CourseIterator(theCourseList);
        Course theCourse;
        while ((theCourse = (Course) theIterator.next()) != null) /// end of the list
        {
            comboBox.addItem(theCourse);
        }
        setVisible(true);
        return selectedCourse;
    }

    void okButtonActionPerformed(ActionEvent e) {
        selectedCourse = (Course) comboBox.getSelectedItem();
        if (highLevelRadio.isSelected())
            nCourseLevel = 0; // high level course: 0
        else
            nCourseLevel = 1; // low level course: 1
        setVisible(false);
    }

    public boolean isLogout() {
        return bLogout;
    }

    void buttonLogoutActionPerformed(ActionEvent e) {
        bLogout = true;
        setVisible(false);
    }
}