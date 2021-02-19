package lk.ijse.RoyalInstitute.business.custom.impl;

import lk.ijse.RoyalInstitute.business.custom.RegisterBO;
import lk.ijse.RoyalInstitute.dao.DAOFactory;
import lk.ijse.RoyalInstitute.dao.DAOType;
import lk.ijse.RoyalInstitute.dao.custom.impl.RegisterDAOImpl;
import lk.ijse.RoyalInstitute.dto.CourseDTO;
import lk.ijse.RoyalInstitute.dto.RegisterDTO;
import lk.ijse.RoyalInstitute.dto.StudentDTO;
import lk.ijse.RoyalInstitute.entity.Course;
import lk.ijse.RoyalInstitute.entity.Register;
import lk.ijse.RoyalInstitute.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class RegisterBOImpl implements RegisterBO {

    RegisterDAOImpl registerDAO = DAOFactory.getInstance().getDAO(DAOType.REGISTER);

    @Override
    public boolean saveRegister(RegisterDTO registerDTO) throws Exception {
        StudentDTO studentDTO = registerDTO.getStudentDTO();
        Student student = new Student(studentDTO.getId(),
                studentDTO.getStudentName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender());
        CourseDTO courseDTO = registerDTO.getCourseDTO();
        Course course = new Course(courseDTO.getProId(),
                courseDTO.getPro(),
                courseDTO.getDuration(),
                courseDTO.getFee());
        return registerDAO.add(new Register(registerDTO.getRegNo(),
                registerDTO.getRegDate(),
                registerDTO.getRegFee(),
                student,
                course));
    }

    @Override
    public boolean deleteRegister(RegisterDTO registerDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateRegister(RegisterDTO registerDTO) throws Exception {
        return false;
    }

    @Override
    public RegisterDTO getRegister(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RegisterDTO> getAllRegisters() throws Exception {
        List<Register> registerList = registerDAO.getAll();
        ArrayList<RegisterDTO> dtoList = new ArrayList();
        for(Register register:registerList){
            dtoList.add(new RegisterDTO(
                    register.getRegNo(),
                    register.getRegDate(),
                    register.getRegFee(),
                    register.getStudent(),
                    register.getCourse()));
        }
        return dtoList;
    }
}
