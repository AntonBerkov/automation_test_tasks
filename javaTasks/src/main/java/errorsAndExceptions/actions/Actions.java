package errorsAndExceptions.actions;

import errorsAndExceptions.exceptions.NoStudentsException;
import errorsAndExceptions.exceptions.NoSubjectsException;
import errorsAndExceptions.exceptions.WrongMarkException;
import errorsAndExceptions.model.Faculty;
import errorsAndExceptions.model.Group;
import errorsAndExceptions.model.Student;
import errorsAndExceptions.model.University;

public class Actions {
    public void studentsAverageMark(University university) {
        double averageMark = 0;
        Faculty currentFaculty = university.getFaculties().get(0);
        Group currentGroup = currentFaculty.getGroups().get(0);
        Student currentStudent = currentGroup.getStudents().get(1);
        try {
            averageMark = currentStudent.getAverageMark();
        } catch (NoSubjectsException | WrongMarkException e) {
            e.printStackTrace();
        }
        System.out.println(currentStudent.getName() + " " + averageMark);

    }

    public void averageMarkInGroup(University university) {
        double averageMark = 0;
        Faculty currentFaculty = university.getFaculties().get(0);
        Group currentGroup = currentFaculty.getGroups().get(0);
        try {
            averageMark = currentGroup.getAverageMathMark();
        } catch (NoStudentsException e) {
            e.printStackTrace();
        }
        System.out.println("Average math mark in " + currentFaculty.getFacultyName() + ", group №  "
                + currentGroup.getGroupNumber() + "= " + averageMark);
    }


}

