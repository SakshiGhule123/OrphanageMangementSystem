package com.anudip.training.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.dto.StaffDTO;
import com.anudip.training.entity.Staff;

@Component
public class StaffConverter {

    // Converting Staff TO StaffDTO
    public StaffDTO convertToStaffDTO(Staff staff) {
        StaffDTO staffDTO = new StaffDTO();
        if (staff != null) {
            BeanUtils.copyProperties(staff, staffDTO);
        }
        return staffDTO;
    }

    // Converting StaffDTO TO Staff
    public Staff convertToStaff(StaffDTO staffDTO) {
        Staff staff = new Staff();
        if (staffDTO != null) {
            BeanUtils.copyProperties(staffDTO, staff);
        }
        return staff;
    }
}
