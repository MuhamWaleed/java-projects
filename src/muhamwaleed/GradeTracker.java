/*
 * Name: Muhammad Waleed
 * Grade Tracker
 * Created: 07/03/2025
 */
package muhamwaleed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * GradeTracker handles user interaction for managing courses and assignments.
 */
public class GradeTracker {
    private final List<Course> courses = new ArrayList<>();
    private final Scanner input;

    /**
     * Initializes a new GradeTracker with input scanner.
     */
    public GradeTracker() {
        this.input = new Scanner(System.in);
    }

    /**
     * Runs the main program loop.
     */
    public void run() {
        while (true) {
            System.out.println("\nGrade Tracker Menu");
            System.out.println("------------------");
            System.out.println("1. Add Course");
            System.out.println("2. Add Assignment");
            System.out.println("3. View Courses");
            System.out.println("4. Edit Assignment");
            System.out.println("5. Delete Assignment");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> addAssignmentToCourse();
                case 3 -> viewCourses();
                case 4 -> editAssignment();
                case 5 -> deleteAssignment();
                case 6 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addCourse() {
        System.out.print("Enter Course Name: ");
        String courseName = input.nextLine();
        courses.add(new Course(courseName, new ArrayList<>()));
        System.out.println("Course " + courseName + " has been added.");
    }

    private void addAssignmentToCourse() {
        if (courses.isEmpty()) {
            System.out.println("No courses available. Add a course first.");
            return;
        }

        listCourses();
        System.out.print("Enter the number of the course to add assignment to: ");
        int index = input.nextInt();
        input.nextLine();

        if (index < 1 || index > courses.size()) {
            System.out.println("Invalid course index.");
            return;
        }

        Course selectedCourse = courses.get(index - 1);
        System.out.print("Enter assignment name: ");
        String name = input.nextLine();
        System.out.print("Enter score earned: ");
        double score = input.nextDouble();
        System.out.print("Enter total points: ");
        double total = input.nextDouble();

        selectedCourse.addAssignment(new Assignment(name, score, total));
        System.out.println("Assignment added.");
    }

    private void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            System.out.println((i + 1) + ". " + course.getName());

            List<Assignment> assignments = course.getAssignments();
            if (assignments.isEmpty()) {
                System.out.println("   No assignments.");
                continue;
            }

            for (Assignment a : assignments) {
                System.out.println("   - " + a.getName());
                System.out.println("     Score: " + a.getScore());
                System.out.println("     Total: " + a.getTotal());
                System.out.println("     Percentage: " + a.getPercentage() + "%");
            }

            System.out.println("   Average: " + course.calculateAverage() + "%\n");
        }
    }

    private void editAssignment() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        listCourses();
        System.out.print("Enter course number: ");
        int courseIndex = input.nextInt();
        input.nextLine();

        if (courseIndex < 1 || courseIndex > courses.size()) {
            System.out.println("Invalid course index.");
            return;
        }

        Course course = courses.get(courseIndex - 1);
        List<Assignment> assignments = course.getAssignments();

        if (assignments.isEmpty()) {
            System.out.println("No assignments in this course.");
            return;
        }

        listAssignments(assignments);
        System.out.print("Enter assignment number to edit: ");
        int assignmentIndex = input.nextInt();
        input.nextLine();

        if (assignmentIndex < 1 || assignmentIndex > assignments.size()) {
            System.out.println("Invalid assignment index.");
            return;
        }

        Assignment assignment = assignments.get(assignmentIndex - 1);
        System.out.print("Enter new score (current: " + assignment.getScore() + "): ");
        assignment.setScore(input.nextDouble());
        System.out.print("Enter new total (current: " + assignment.getTotal() + "): ");
        assignment.setTotal(input.nextDouble());
        System.out.println("Assignment updated.");
    }

    private void deleteAssignment() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        listCourses();
        System.out.print("Enter course number: ");
        int courseIndex = input.nextInt();
        input.nextLine();

        if (courseIndex < 1 || courseIndex > courses.size()) {
            System.out.println("Invalid course index.");
            return;
        }

        Course course = courses.get(courseIndex - 1);
        List<Assignment> assignments = course.getAssignments();

        if (assignments.isEmpty()) {
            System.out.println("No assignments to delete.");
            return;
        }

        listAssignments(assignments);
        System.out.print("Enter assignment number to delete: ");
        int assignmentIndex = input.nextInt();
        input.nextLine();

        if (assignmentIndex < 1 || assignmentIndex > assignments.size()) {
            System.out.println("Invalid assignment index.");
            return;
        }

        Assignment assignment = assignments.get(assignmentIndex - 1);
        course.removeAssignment(assignment);
        System.out.println("Assignment deleted.");
    }

    private void listCourses() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getName());
        }
    }

    private void listAssignments(List<Assignment> assignments) {
        for (int i = 0; i < assignments.size(); i++) {
            System.out.println((i + 1) + ". " + assignments.get(i).getName());
        }
    }

    public static void main(String[] args) {
        new GradeTracker().run();
    }
}
