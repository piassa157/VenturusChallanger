package com.challanger.venturus.controller.dto;

import com.challanger.venturus.model.Provider;

import java.util.List;
import java.util.stream.Collectors;

public class ProviderDTO {
    private String socialName;
    private String document;

    public ProviderDTO(Provider provider) {
        this.socialName = provider.getSocialName();
        this.document = provider.getDocument();
    }

    public String getSocialName() {
        return socialName;
    }

    public String getDocument() {
        return document;
    }

    public static List<ProviderDTO> convert(List<Provider> getProviders) {
        return getProviders.stream().map(ProviderDTO::new).collect(Collectors.toList());
    }
}
