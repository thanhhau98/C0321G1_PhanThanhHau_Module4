package com.codegym.phone_manager.model.repository;

import com.codegym.phone_manager.model.bean.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long> {
}
