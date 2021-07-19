package com.challanger.venturus.controller;

import com.challanger.venturus.controller.dto.ProviderDTO;
import com.challanger.venturus.controller.dto.ProviderFormDTO;
import com.challanger.venturus.model.Provider;
import com.challanger.venturus.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")

public class ProviderController {

    @Autowired
    private ProviderRepository providerRepository;

    @GetMapping
    public List<ProviderDTO> list(){
        List<Provider> getProviders = providerRepository.findAll();
        return ProviderDTO.convert(getProviders);
    }

    @PostMapping
    public void create(@RequestBody ProviderFormDTO payload){
        Provider provider = payload.convert();
        providerRepository.save(provider);
    }


}
