/*
 * Name: Muhammad Waleed
 * Grade Tracker
 * Created: 07/03/2025
 */
package muhamwaleed;

/**
 * Represents an assignment with name, score, and total.
 */
public class Assignment {
    private final String name;
    private double score;
    private double total;

    /**
     * Constructs an assignment with name, score, and total.
     * @param name of the assignment
     * @param score scored in the assignment
     * @param total marks of the assignment
     */
    public Assignment(String name, double score, double total) {
        this.name = name;
        this.score = score;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public double getTotal() {
        return total;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Returns the percentage score of the assignment.
     */
    public double getPercentage() {
        return total == 0.0 ? 0.0 : (score * 100.0) / total;
    }
}