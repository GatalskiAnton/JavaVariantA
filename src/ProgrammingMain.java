import GUI.Frame;
import Notify.*;
import University.*;
import Writer.*;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class ProgrammingMain {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        Undergraduate gg4 = new Undergraduate("gg4", "gg4", "gg4@bsu.by");
        Academic PaulDeitel = new Academic("Paul Deitel");
        gg4.setTutor(PaulDeitel);
        Undergraduate pr3 = new Undergraduate("pr3", "pr3", "pr3@bsu.by");
        Academic CayHorstamnn = new Academic("Cay Horstmann");
        pr3.setTutor(CayHorstamnn);
        Postgraduate te2 = new Postgraduate("te2", "te2", "tr2@bsu.by");
        te2.setSupervisor(PaulDeitel);
        Postgraduate yj34 = new Postgraduate("yj34", "yj34", "yj43@bsu.by");
        yj34.setSupervisor(CayHorstamnn);
        Postgraduate jj8 = new Postgraduate("jj8", "jj8", "jj8@bsu.by");
        jj8.setSupervisor(CayHorstamnn);
        students.add(gg4);
        students.add(pr3);
        students.add(te2);
        students.add(yj34);
        students.add(jj8);

        Course c1 = new Course(students, "course-1");
        Set<Postgraduate> postgraduates = c1.getPostgraduates(CayHorstamnn.getName());

        for (Postgraduate postgraduate : postgraduates)
            System.out.println(postgraduate.getName() + " " + postgraduate.getLogin() + " " + postgraduate.getEmail());


        Notifier n1 = new Notifier(students);
        n1.doNotifyAll("Hello, Students!");
        Set<Student> studentsByPredicate = c1.getStudentsByPredicate(student -> student.getName().length() == 3);

        System.out.println(studentsByPredicate.toString());

        try {
            MyWriter.toFile(c1, new File("output.txt"), false);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Frame frame = new Frame("Course info",c1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
