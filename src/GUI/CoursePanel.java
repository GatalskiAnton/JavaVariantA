package GUI;

import University.Course;
import University.Postgraduate;
import University.Student;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;

public class CoursePanel extends JPanel {

    private Course course;

    private JLabel titleLabel;

    private JTable table;
    public CoursePanel(Course course) {

        this.course = course;

        setLayout(new BorderLayout());

        titleLabel = new JLabel(course.getName());
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);
        Vector<Vector<String >> studentInfo = new Vector<>();
        Vector<String> titles = new Vector<>();
        titles.add("Name");
        titles.add("Login");
        titles.add("Email");
        Set<Student> students = course.getStudents();
        for (Student student: students)
        {
            Vector<String > v = new Vector<>();
            v.add(student.getName());
            v.add(student.getLogin());
            v.add(student.getEmail());
            if (student instanceof Postgraduate)
                s

            studentInfo.add(v);
        }
        table = new JTable(studentInfo,titles);
        table.setRowHeight(50);
        JScrollPane js=new JScrollPane(table);

        add(js, BorderLayout.CENTER);

    }
}
