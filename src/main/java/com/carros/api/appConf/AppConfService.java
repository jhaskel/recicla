package com.carros.api.appConf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppConfService {

    @Autowired
    private AppConfRepository rep;

    public List<AppConfDTO> get() {
        return rep.findAll().stream().map(AppConfDTO::create).collect(Collectors.toList());
    }


}