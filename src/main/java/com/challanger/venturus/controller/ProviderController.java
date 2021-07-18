package com.challanger.venturus.controller;

import com.challanger.venturus.controller.dto.ProviderDTO;
import com.challanger.venturus.model.Provider;
import com.challanger.venturus.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProviderController {

    @Autowired
    private ProviderRepository providerRepository;


    @RequestMapping("/providers")
    public List<ProviderDTO> list(){
        List<Provider> getProviders = providerRepository.findAll();
        return ProviderDTO.convert(getProviders);
    }


}
