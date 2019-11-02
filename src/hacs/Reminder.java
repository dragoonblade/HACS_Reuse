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

public class Reminder extends JDialog {
    private static int REMINDER_WIDTH = 400;
    private static int REMINDER_HEIGHT = 386;

    private static String J_LABEL1_TEXT = "Upcoming Assignments";
    private static int J_LABEL1_X = 38;
    private static int J_LABEL1_Y = 40;
    private static int J_LABEL1_WIDTH = 160;
    private static int J_LABEL1_HEIGHT = 17;

    private static String J_LABEL2_TEXT = "Overdue Assignments";
    private static int J_LABEL2_X = 38;
    private static int J_LABEL2_Y = 160;
    private static int J_LABEL2_WIDTH = 160;
    private static int J_LABEL2_HEIGHT = 17;

    private static int UPCOMING_LIST_X = 30;
    private static int UPCOMING_LIST_Y = 65;
    private static int UPCOMING_LIST_WIDTH = 340;
    private static int UPCOMING_LIST_HEIGHT = 85;

    private static int OVERDUE_LIST_X = 30;
    private static int OVERDUE_LIST_Y = 185;
    private static int OVERDUE_LIST_WIDTH = 340;
    private static int OVERDUE_LIST_HEIGHT = 85;

    private static String OK_BUTTON_TEXT = "OK";
    private static int OK_BUTTON_X = 150;
    private static int OK_BUTTON_Y = 308;
    private static int OK_BUTTON_WIDTH = 67;
    private static int OK_BUTTON_HEIGHT = 37;

    ClassCourseList courseList;
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    java.awt.List listUpcoming = new java.awt.List();
    java.awt.List listOverdue = new java.awt.List();
    Button buttonOK = new Button();

    public Reminder() {
        try {
            jbInit();
            setModal(true);
            setSize(REMINDER_WIDTH, REMINDER_HEIGHT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText(J_LABEL1_TEXT);
        jLabel1.setBounds(new Rectangle(J_LABEL1_X, J_LABEL1_Y, J_LABEL1_WIDTH, J_LABEL1_HEIGHT));

        jLabel2.setText(J_LABEL2_TEXT);
        jLabel2.setBounds(new Rectangle(J_LABEL2_X, J_LABEL2_Y, J_LABEL2_WIDTH, J_LABEL2_HEIGHT));

        listUpcoming.setBounds(new Rectangle(UPCOMING_LIST_X, UPCOMING_LIST_Y, UPCOMING_LIST_WIDTH, UPCOMING_LIST_HEIGHT));
        listOverdue.setBounds(new Rectangle(OVERDUE_LIST_X, OVERDUE_LIST_Y, OVERDUE_LIST_WIDTH, OVERDUE_LIST_HEIGHT));

        buttonOK.setLabel(OK_BUTTON_TEXT);
        buttonOK.setBounds(new Rectangle(OK_BUTTON_X, OK_BUTTON_Y, OK_BUTTON_WIDTH, OK_BUTTON_HEIGHT));
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonOKActionPerformed(e);
            }
        });

        this.getContentPane().setLayout(null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(listUpcoming, null);
        this.getContentPane().add(listOverdue, null);
        this.getContentPane().add(buttonOK, null);
    }

    void showReminder() {
        ReminderVisitor visitor = new ReminderVisitor(this);
        visitor.visitFacade(Hacs.theFacade);
        setVisible(true);
    }

    void buttonOKActionPerformed(ActionEvent e) {
        setVisible(false);
    }
}