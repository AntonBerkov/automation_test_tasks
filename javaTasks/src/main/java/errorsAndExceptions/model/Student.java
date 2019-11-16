package errorsAndExceptions.model;

import errorsAndExceptions.exceptions.NoSubjectsException;
import errorsAndExceptions.exceptions.WrongMarkException;

import java.util.List;

public class Student {
    private String name;
    private List<Subject> subjects;

    public Student(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public double getAverageMark() throws NoSubjectsException, WrongMarkException {
        int sum = 0;
        if (subjects.isEmpty()) {
            throw new NoSubjectsException("need to add subjects to student");
        }
        for (Subject subject : subjects) {
            if (subject.getMark() > 10 || subject.getMark() < 0) {
                throw new WrongMarkException("mark should be more than 0 and less than 10");
            }
            sum += subject.getMark();
        }
        return (double) sum / subjects.size();
    }
}
