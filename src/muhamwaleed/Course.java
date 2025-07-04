/*
 * Name: Muhammad Waleed
 * Grade Tracker
 * Created: 07/03/2025
 */
package muhamwaleed;

import java.util.List;

/**
 * Represents a course with a name and list of assignments.
 */
public class Course {
    private final String name;
    private final List<Assignment> assignments;

    /**
     * Constructs a course with a name and assignment list.
     * @param name of the course
     * @param assignments list of assignments
     */
    public Course(String name, List<Assignment> assignments) {
        this.name = name;
        this.assignments = assignments;
    }

    public String getName() {
        return name;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    /**
     * adds given assignment into list
     * @param assignment name of the assignment
     */
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    /**
     * removes given assignment from list
     * @param assignment name of the assignment
     */
    public void removeAssignment(Assignment assignment) {
        assignments.remove(assignment);
    }

    /**
     * Calculates average percentage of all assignments.
     */
    public double calculateAverage() {
        if (assignments.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        for (Assignment a : assignments) {
            total += a.getPercentage();
        }
        return total / assignments.size();
    }
}
