package lk.ijse.RoyalInstitute.business.custom.impl;

import lk.ijse.RoyalInstitute.business.custom.CourseBO;
import lk.ijse.RoyalInstitute.dao.DAOFactory;
import lk.ijse.RoyalInstitute.dao.DAOType;
import lk.ijse.RoyalInstitute.dao.custom.impl.CourseDAOImpl;
import lk.ijse.RoyalInstitute.dto.CourseDTO;
import lk.ijse.RoyalInstitute.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    CourseDAOImpl courseDAO = DAOFactory.getInstance().getDAO(DAOType.COURSE);

    @Override
    public boolean saveCourse(CourseDTO course) throws Exception {
        return courseDAO.add(new Course(course.getProId(),
                course.getPro(),
                course.getDuration(),
                course.getFee()));
    }

    @Override
    public boolean deleteCourse(CourseDTO course) throws Exception {
        return courseDAO.delete(new Course(course.getProId(),
                course.getPro(),
                course.getDuration(),
                course.getFee()));
    }

    @Override
    public boolean updateCourse(CourseDTO course) throws Exception {
        return courseDAO.update(new Course(course.getProId(),
                course.getPro(),
                course.getDuration(),
                course.getFee()));
    }

    @Override
    public CourseDTO getCourse(String id) throws Exception {
        Course course = courseDAO.getOne(id);
        return new CourseDTO(course.getProId(),
                course.getPro(),
                course.getDuration(),
                course.getFee());
    }

    @Override
    public ArrayList<CourseDTO> getAllCourses() throws Exception {
        List<Course> courseList = courseDAO.getAll();
        ArrayList<CourseDTO> dtoList = new ArrayList();
        for (Course course : courseList) {
            dtoList.add(new CourseDTO(course.getProId(),
                    course.getPro(),
                    course.getDuration(),
                    course.getFee()));
        }
        return dtoList;
    }
}
