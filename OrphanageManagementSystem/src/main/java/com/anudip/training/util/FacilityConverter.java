package com.anudip.training.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.dto.FacilityDTO;
import com.anudip.training.entity.Facility;

@Component
public class FacilityConverter {

    // Converting Facility TO FacilityDTO
    public FacilityDTO convertToFacilityDTO(Facility facility) {
        FacilityDTO facilityDTO = new FacilityDTO();
        if (facility != null) {
            BeanUtils.copyProperties(facility, facilityDTO);
        }
        return facilityDTO;
    }

    // Converting FacilityDTO TO Facility
    public Facility convertToFacility(FacilityDTO facilityDTO) {
        Facility facility = new Facility();
        if (facilityDTO != null) {
            BeanUtils.copyProperties(facilityDTO, facility);
        }
        return facility;
    }
}
