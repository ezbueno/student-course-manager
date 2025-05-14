package developer.ezandro.domain;

import java.util.Objects;

public class Course {
    private static long idCounter = 1;
    private final long id;
    private final String name;
    private final String description;
    private final int workload;

    public Course(String name, String description, int workload) {
        this.id = idCounter++;
        this.name = name;
        this.description = description;
        this.workload = workload;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getWorkload() {
        return this.workload;
    }

    @Override
    public String toString() {
        return String.format("""
                --- Course ---
                ID: %d
                Name: %s
                Description: %s
                Workload: %d
                """, this.id, this.name, this.description, this.workload);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Course course = (Course) o;
        return this.id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}