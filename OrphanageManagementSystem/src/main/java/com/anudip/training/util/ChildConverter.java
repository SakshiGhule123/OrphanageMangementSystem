package com.anudip.training.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.dto.ChildDTO;
import com.anudip.training.entity.Child;

@Component
public class ChildConverter {

    // Converting Child TO ChildDTO
    public ChildDTO convertToChildDTO(Child child) {
        ChildDTO childDTO = new ChildDTO();
        if (child != null) {
            BeanUtils.copyProperties(child, childDTO);
        }
        return childDTO;
    }

    // Converting ChildDTO TO Child
    public Child convertToChild(ChildDTO childDTO) {
        Child child = new Child();
        if (childDTO != null) {
            BeanUtils.copyProperties(childDTO, child);
        }
        return child;
    }
}
