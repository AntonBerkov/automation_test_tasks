package errorsAndExceptions.model;

import errorsAndExceptions.exceptions.NoGroupException;
import errorsAndExceptions.exceptions.NoStudentsException;
import errorsAndExceptions.faculties.Faculties;

import java.util.List;

public class Faculty {

    private Faculties facultyName;
    private List<Group> groups;

    public Faculty(Faculties facultyName, List<Group> groups) {
        this.facultyName = facultyName;
        this.groups = groups;

    }

    public Faculties getFacultyName() {
        return facultyName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public double getAverageMathMark() throws NoGroupException {
        if (groups.isEmpty()) {
            throw new NoGroupException("need to add groups to faculty");
        }
        int sum = 0;
        for (Group group : groups) {
            try {
                sum += group.getAverageMathMark();
            } catch (NoStudentsException e) {
                e.printStackTrace();
            }
        }
        return (double) sum / groups.size();
    }
}
