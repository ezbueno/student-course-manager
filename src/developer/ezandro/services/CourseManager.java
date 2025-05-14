package developer.ezandro.services;

import developer.ezandro.domain.Course;
import developer.ezandro.repositories.CourseRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseManager {
    private final CourseRepository courseRepository = new CourseRepository();

    public void addCourse(Course course) {
        this.courseRepository.addCourse(course);
    }

    public List<Course> listAllCourses() {
        if (this.courseRepository.getAllCourses().isEmpty()) {
            return Collections.emptyList();
        }
        return new ArrayList<>(this.courseRepository.getAllCourses());
    }

    public Course findCourseById(long id) {
        return this.courseRepository.findById(id);
    }
}