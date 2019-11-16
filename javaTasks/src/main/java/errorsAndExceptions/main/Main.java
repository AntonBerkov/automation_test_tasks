package errorsAndExceptions.main;

import errorsAndExceptions.actions.Actions;
import errorsAndExceptions.exceptions.*;
import errorsAndExceptions.faculties.Faculties;
import errorsAndExceptions.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Subject> ivanovSubjects = new ArrayList<>(Arrays.asList(
                new Subject("Math", 8),
                new Subject("English", 6),
                new Subject("History", 4)
        ));

        List<Subject> petrovSubjects = new ArrayList<>(Arrays.asList(
                new Subject("Math", 7),
                new Subject("English", 8),
                new Subject("History", 9)
        ));

        List<Subject> borisovSubjects = new ArrayList<>(Arrays.asList(
                new Subject("Math", 9),
                new Subject("English", 4),
                new Subject("History", 5)
        ));

        List<Subject> sergeevSubjects = new ArrayList<>(Arrays.asList(
                new Subject("Math", 4),
                new Subject("English", 5),
                new Subject("History", 9)
        ));

        List<Subject> zaharovSubjects = new ArrayList<>(Arrays.asList(
                new Subject("Math", 7),
                new Subject("English", 4),
                new Subject("History", 9)
        ));

        List<Subject> golenkovubjects = new ArrayList<>(Arrays.asList(
                new Subject("Math", 8),
                new Subject("English", 5),
                new Subject("History", 6)
        ));

        List<Subject> stepanovaSubjects = new ArrayList<>(Arrays.asList(
                new Subject("Math", 10),
                new Subject("English", 8),
                new Subject("History", 9)
        ));

        List<Subject> zaycecasubjects = new ArrayList<>(Arrays.asList(
                new Subject("Math", 5),
                new Subject("English", 5),
                new Subject("History", 6)
        ));

        List<Student> firstGroupStudents = new ArrayList<>(Arrays.asList(
                new Student("Ivanov", ivanovSubjects),
                new Student("Petov", petrovSubjects)));


        List<Student> secondGroupStudents = new ArrayList<>(Arrays.asList(
                new Student("Borisov", borisovSubjects),
                new Student("Sergeev", sergeevSubjects)
        ));

        List<Student> thirdGroupStudents = new ArrayList<>(Arrays.asList(
                new Student("Zaharov", zaharovSubjects),
                new Student("Golenkov", golenkovubjects)
        ));

        List<Student> fourthGroupStudents = new ArrayList<>(Arrays.asList(
                new Student("Stepanova", stepanovaSubjects),
                new Student("Zayceva", zaycecasubjects)
        ));

        List<Group> fituGroups = new ArrayList<>(Arrays.asList(
                new Group(1, firstGroupStudents),
                new Group(2, secondGroupStudents)
        ));

        List<Group> fksisGroups = new ArrayList<>(Arrays.asList(
                new Group(3, thirdGroupStudents),
                new Group(4, fourthGroupStudents)
        ));

        List<Faculty> faculties = new ArrayList<>(Arrays.asList(
                new Faculty(Faculties.FITU, fituGroups),
                new Faculty(Faculties.FKSIS, fksisGroups)
        ));

        University university = new University(faculties);
        Actions actions = new Actions();
        actions.studentsAverageMark(university);
        actions.averageMarkInGroup(university);
        double averageMark = 0;
        try {
            averageMark = university.getAverageMathMark();
        } catch (NoFacultyException e) {
            e.printStackTrace();
        }
        System.out.println("Average math mark among the university " + averageMark);
    }

}
