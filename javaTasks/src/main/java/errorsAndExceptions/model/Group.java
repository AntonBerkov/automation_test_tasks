package errorsAndExceptions.model;

import errorsAndExceptions.exceptions.NoStudentsException;
import errorsAndExceptions.exceptions.NoSubjectsException;
import errorsAndExceptions.exceptions.WrongMarkException;

import java.util.List;

public class Group {

    private int groupNumber;
    private List<Student> students;

    public Group(int groupNumber, List<Student> students) {
        this.groupNumber = groupNumber;
        this.students = students;

    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public double getAverageMathMark() throws NoStudentsException {
        if (students.isEmpty()) {
            throw new NoStudentsException("need to add students to group");
        }
        int sum = 0;
        for (Student student : students) {
            for (int j = 0; j < student.getSubjects().size(); j++) {
                Subject currentSubject = student.getSubjects().get(j);
                if (currentSubject.getName().equals("Math")) {
                    try {
                        sum += student.getAverageMark();
                    } catch (NoSubjectsException | WrongMarkException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sum / students.size();
    }
}
