package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class InstructorAssignmentMenu extends AssignmentMenu {
    private static String ASSIGNMENT_TEXT = "Assignment Name";
    private static int ASSIGNMENT_X = 25;
    private static int ASSIGNMENT_Y = 31;
    private static int ASSIGNMENT_WIDTH = 118;
    private static int ASSIGNMENT_HEIGHT = 18;

    private static String TB_ASSIGNMENT_TEXT = "jTextField1";
    private static int TB_ASSIGNMENT_X = 192;
    private static int TB_ASSIGNMENT_Y = 31;
    private static int TB_ASSIGNMENT_WIDTH = 341;
    private static int TB_ASSIGNMENT_HEIGHT = 22;

    private static String DUE_DATE_TEXT = "Due Date";
    private static int DUE_DATE_X = 28;
    private static int DUE_DATE_Y = 90;
    private static int DUE_DATE_WIDTH = 113;
    private static int DUE_DATE_HEIGHT = 18;

    private static String TB_DUE_DATE_TEXT = "tbDueDate";
    private static int TB_DUE_DATE_X = 195;
    private static int TB_DUE_DATE_Y = 87;
    private static int TB_DUE_DATE_WIDTH = 337;
    private static int TB_DUE_DATE_HEIGHT = 22;

    private static String SUGGESTED_SOLUTION_TEXT = "Suggested Solution";
    private static int SUGGESTED_SOLUTION_X = 28;
    private static int SUGGESTED_SOLUTION_Y = 151;
    private static int SUGGESTED_SOLUTION_WIDTH = 118;
    private static int SUGGESTED_SOLUTION_HEIGHT = 18;

    private static String TB_SUGGESTED_SOLUTION_TEXT = "jTextField2";
    private static int TB_SUGGESTED_SOLUTION_X = 197;
    private static int TB_SUGGESTED_SOLUTION_Y = 149;
    private static int TB_SUGGESTED_SOLUTION_WIDTH = 339;
    private static int TB_SUGGESTED_SOLUTION_HEIGHT = 22;

    private static String GRADE_TEXT = "Grade";
    private static int GRADE_X = 458;
    private static int GRADE_Y = 199;
    private static int GRADE_WIDTH = 79;
    private static int GRADE_HEIGHT = 29;

    private static String REPORT_TEXT = "Report";
    private static int REPORT_X = 365;
    private static int REPORT_Y = 249;
    private static int REPORT_WIDTH = 79;
    private static int REPORT_HEIGHT = 29;

    private static String CLOSE_TEXT = "Close";
    private static int CLOSE_X = 86;
    private static int CLOSE_Y = 253;
    private static int CLOSE_WIDTH = 79;
    private static int CLOSE_HEIGHT = 29;

    private static int COMBO_SOLUTION_X = 32;
    private static int COMBO_SOLUTION_Y = 204;
    private static int COMBO_SOLUTION_WIDTH = 413;
    private static int COMBO_SOLUTION_HEIGHT = 22;


    JComboBox combSolutionList = new JComboBox();
    JTextField tbAssignmentName = new JTextField();
    JTextField tbDueDate = new JTextField();
    JTextField tbSuggestedSolution = new JTextField();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JButton buttonGrade = new JButton();
    JButton buttonReport = new JButton();
    JButton buttonClose = new JButton();

    ////  class AssignmentMenu
    private boolean bSubmit = false;
    private Solution theSolution;
    private Assignment theAssignment;

    public InstructorAssignmentMenu() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText(ASSIGNMENT_TEXT);
        jLabel1.setBounds(new Rectangle(ASSIGNMENT_X, ASSIGNMENT_Y, ASSIGNMENT_WIDTH, ASSIGNMENT_HEIGHT));

        tbAssignmentName.setText(TB_ASSIGNMENT_TEXT);
        tbAssignmentName.setBounds(new Rectangle(TB_ASSIGNMENT_X, TB_ASSIGNMENT_Y, TB_ASSIGNMENT_WIDTH, TB_ASSIGNMENT_HEIGHT));

        jLabel2.setText(DUE_DATE_TEXT);
        jLabel2.setBounds(new Rectangle(DUE_DATE_X, DUE_DATE_Y, DUE_DATE_WIDTH, DUE_DATE_HEIGHT));

        tbDueDate.setText(TB_DUE_DATE_TEXT);
        tbDueDate.setBounds(new Rectangle(TB_DUE_DATE_X, TB_DUE_DATE_Y, TB_DUE_DATE_WIDTH, TB_DUE_DATE_HEIGHT));

        jLabel3.setText(SUGGESTED_SOLUTION_TEXT);
        jLabel3.setBounds(new Rectangle(SUGGESTED_SOLUTION_X, SUGGESTED_SOLUTION_Y, SUGGESTED_SOLUTION_WIDTH, SUGGESTED_SOLUTION_HEIGHT));

        tbSuggestedSolution.setText(TB_SUGGESTED_SOLUTION_TEXT);
        tbSuggestedSolution.setBounds(new Rectangle(TB_SUGGESTED_SOLUTION_X, TB_SUGGESTED_SOLUTION_Y, TB_SUGGESTED_SOLUTION_WIDTH, TB_SUGGESTED_SOLUTION_HEIGHT));

        buttonGrade.setText(GRADE_TEXT);
        buttonGrade.setBounds(new Rectangle(GRADE_X, GRADE_Y, GRADE_WIDTH, GRADE_HEIGHT));
        buttonGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonGradeActionPerformed(e);
            }
        });

        buttonReport.setText(REPORT_TEXT);
        buttonReport.setBounds(new Rectangle(REPORT_X, REPORT_Y, REPORT_WIDTH, REPORT_HEIGHT));
        buttonReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonReportActionPerformed(e);
            }
        });

        buttonClose.setText(CLOSE_TEXT);
        buttonClose.setBounds(new Rectangle(CLOSE_X, CLOSE_Y, CLOSE_WIDTH, CLOSE_HEIGHT));
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonCloseActionPerformed(e);
            }
        });

        combSolutionList.setBounds(new Rectangle(COMBO_SOLUTION_X, COMBO_SOLUTION_Y, COMBO_SOLUTION_WIDTH, COMBO_SOLUTION_HEIGHT));

        this.getContentPane().setLayout(null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tbAssignmentName, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(tbDueDate, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(tbSuggestedSolution, null);
        this.getContentPane().add(buttonClose, null);
        this.getContentPane().add(combSolutionList, null);
        this.getContentPane().add(buttonGrade, null);
        this.getContentPane().add(buttonReport, null);
    }

    public void showMenu(Assignment assignment, Person person) {
        theAssignment = assignment;
        Solution theSolution;
        try {
            tbAssignmentName.setText(theAssignment.assName);

            DateFormat theDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
            tbDueDate.setText(theDateFormat.format(theAssignment.dueDate));
            tbSuggestedSolution.setText(theAssignment.suggestSolution.SolutionFileName);
            refreshSolutionList();
            setVisible(true);
        } catch (NullPointerException e) {
            System.out.println("No Assignment Available");
        }
    }

    void buttonCloseActionPerformed(ActionEvent e) {
        theAssignment.assName = tbAssignmentName.getText();
        DateFormat tempDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        try {
            theAssignment.dueDate = tempDateFormat.parse(tbDueDate.getText());
        } catch (Exception ee) {
        }
        theAssignment.suggestSolution.SolutionFileName = tbSuggestedSolution.getText();
        setVisible(false);
    }

    void buttonGradeActionPerformed(ActionEvent e) {
        Solution theSolution = (Solution) combSolutionList.getSelectedItem();
        if (theSolution == null)
            return;
        SolutionGradingDlg dlg = new SolutionGradingDlg();
        dlg.show(theSolution);
        refreshSolutionList();
    }

    void buttonReportActionPerformed(ActionEvent e) {
        SolutionIterator iter = new SolutionIterator(theAssignment.theSolutionList);
        while (iter.hasNext()) {
            Solution solution = (Solution) iter.next();
            solution.setReported(true);
        }
        refreshSolutionList();
    }

    private void refreshSolutionList() {
        combSolutionList.removeAllItems();
        SolutionIterator SolIter = new SolutionIterator(theAssignment.theSolutionList);
        while (SolIter.hasNext()) {
            theSolution = (Solution) SolIter.next();
            combSolutionList.addItem(theSolution);
        }
    }
}