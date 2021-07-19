package com.challanger.venturus.controller.dto;

import com.challanger.venturus.model.Customer;
import com.challanger.venturus.model.Provider;

public class ProviderFormDTO {
    private String socialName;
    private String document;

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Provider convert() {
        return new Provider(this.socialName, this.document);
    }
}
