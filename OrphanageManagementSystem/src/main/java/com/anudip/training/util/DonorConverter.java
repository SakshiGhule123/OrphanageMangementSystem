package com.anudip.training.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.dto.DonorDTO;
import com.anudip.training.entity.Donor;

@Component
public class DonorConverter {

    // Converting Donor TO DonorDTO
    public DonorDTO convertToDonorDTO(Donor donor) {
        DonorDTO donorDTO = new DonorDTO();
        if (donor != null) {
            BeanUtils.copyProperties(donor, donorDTO);
        }
        return donorDTO;
    }

    // Converting DonorDTO TO Donor
    public Donor convertToDonor(DonorDTO donorDTO) {
        Donor donor = new Donor();
        if (donorDTO != null) {
            BeanUtils.copyProperties(donorDTO, donor);
        }
        return donor;
    }
}

