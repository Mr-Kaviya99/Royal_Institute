package lk.ijse.RoyalInstitute.business.custom;

import lk.ijse.RoyalInstitute.business.SuperBO;
import lk.ijse.RoyalInstitute.dto.CourseDTO;
import lk.ijse.RoyalInstitute.dto.StudentDTO;

import java.util.ArrayList;

public interface CourseBO extends SuperBO {
    public boolean saveCourse(CourseDTO course)throws Exception;

    public boolean deleteCourse(CourseDTO course)throws Exception;

    public boolean updateCourse(CourseDTO course)throws Exception;

    public CourseDTO getCourse(String id)throws Exception;

    public ArrayList<CourseDTO> getAllCourses()throws Exception;
}
