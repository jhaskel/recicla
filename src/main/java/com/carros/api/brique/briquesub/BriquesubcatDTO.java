package com.carros.api.brique.briquesub;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class BriquesubcatDTO {
    private Long id;
    private Long categoria;
    private Long recompensa;
    private String title;

    public static BriquesubcatDTO create(Briquesubcat briquesubcat) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(briquesubcat, BriquesubcatDTO.class);
    }



}
