package lk.ijse.RoyalInstitute.business.custom;

import lk.ijse.RoyalInstitute.business.SuperBO;
import lk.ijse.RoyalInstitute.dto.RegisterDTO;
import lk.ijse.RoyalInstitute.dto.StudentDTO;

import java.util.ArrayList;

public interface RegisterBO extends SuperBO {
    public boolean saveRegister(RegisterDTO registerDTO)throws Exception;

    public boolean deleteRegister(RegisterDTO registerDTO)throws Exception;

    public boolean updateRegister(RegisterDTO registerDTO)throws Exception;

    public RegisterDTO getRegister(String id)throws Exception;

    public ArrayList<RegisterDTO> getAllRegisters()throws Exception;
}
