package developer.ezandro.domain;

import java.util.Objects;

public class Student {
    private static long idCounter = 1;
    private final long id;
    private final String name;
    private final String email;

    public Student(String name, String email) {
        this.id = idCounter++;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return String.format("""
                --- Student ---
                ID: %d
                Name: %s
                Email: %s
                """, this.id, this.name, this.email);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;
        return this.id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}