package com.kgisl.strnsestock.demostock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("portfoilioRepository")
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    

}