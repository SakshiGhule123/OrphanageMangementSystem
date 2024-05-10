package com.anudip.training.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.dto.OrphanageDTO;
import com.anudip.training.entity.Orphanage;

@Component
public class OrphanageConverter {

    // Converting Orphanage TO OrphanageDTO
    public OrphanageDTO convertToOrphanageDTO(Orphanage orphanage) {
        OrphanageDTO orphanageDTO = new OrphanageDTO();
        if (orphanage != null) {
            BeanUtils.copyProperties(orphanage, orphanageDTO);
        }
        return orphanageDTO;
    }

    // Converting OrphanageDTO TO Orphanage
    public Orphanage convertToOrphanage(OrphanageDTO orphanageDTO) {
        Orphanage orphanage = new Orphanage();
        if (orphanageDTO != null) {
            BeanUtils.copyProperties(orphanageDTO, orphanage);
        }
        return orphanage;
    }
}
