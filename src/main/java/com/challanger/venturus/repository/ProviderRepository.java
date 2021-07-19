package com.challanger.venturus.repository;

import com.challanger.venturus.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Provider findByDocument(String document);
}
