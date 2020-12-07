package com.georgedoestechstuff.rest.demo.name.dao;

import com.georgedoestechstuff.rest.demo.name.endpoint.payload.Name;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<Name, Long> {

}
