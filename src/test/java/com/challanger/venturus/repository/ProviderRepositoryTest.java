package com.challanger.venturus.repository;

import com.challanger.venturus.model.Provider;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProviderRepositoryTest {

    @Autowired
    private ProviderRepository providerRepository;

    @Test
    public void shouldCarryProviderByDocument(){
        String document = "99987667813";
        Provider provider = providerRepository.findByDocument(document);
        Assert.assertNotNull(provider);
        Assert.assertEquals(document, provider.getDocument());
    }
}
