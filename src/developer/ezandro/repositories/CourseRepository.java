package developer.ezandro.repositories;

import developer.ezandro.domain.Course;
import developer.ezandro.exceptions.CourseNotFoundException;
import developer.ezandro.utils.MessageProvider;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private final List<Course> courses;

    public CourseRepository() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(this.courses);
    }

    public Course findById(long id) {
        return this.courses
                .stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException(MessageProvider.getCourseNotFoundMessage(id)));
    }
}