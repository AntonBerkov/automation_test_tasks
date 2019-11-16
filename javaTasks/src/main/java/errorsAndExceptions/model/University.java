package errorsAndExceptions.model;

import errorsAndExceptions.exceptions.NoFacultyException;
import errorsAndExceptions.exceptions.NoGroupException;

import java.util.List;

public class University {
    private List<Faculty> faculties;

    public University(List<Faculty> faculties) {
        this.faculties = faculties;

    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public double getAverageMathMark() throws NoFacultyException {
        int sum = 0;
        if (faculties.isEmpty()) {
            throw new NoFacultyException("need to add faculty to university");
        }
        for (Faculty faculty : faculties) {
            try {
                sum += faculty.getAverageMathMark();
            } catch (NoGroupException e) {
                e.printStackTrace();
            }
        }
        return (double) sum / faculties.size();
    }
}
