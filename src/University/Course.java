package University;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class Course {
    private Set<Student> students;
    private String name;

    public Course(Set<Student> students, String name) {
        this.students = students;
        this.name = name;
    }

    public  Set<Postgraduate> getPostgraduates(String nameOfSupervisor)
    {
        Set<Postgraduate> postgraduates = new HashSet<>();

        for(Student student: students)
        {
           if (student instanceof Postgraduate) {
               if (((Postgraduate) student).getSupervisor().getName().equals(nameOfSupervisor))
                   postgraduates.add(((Postgraduate) student));
           }
        }
        return postgraduates;
    }

    public  Set<Student> getStudentsByPredicate(Predicate<Student> predicate)
    {
        Set<Student> studentsByPredicate = new HashSet<>();
        for (Student student: students)
        {
            if (predicate.test(student))
                studentsByPredicate.add(student);

        }
        return studentsByPredicate;
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }

    @Override
    public String toString() {
        return name + "\nstudents: "  + students.toString();
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
