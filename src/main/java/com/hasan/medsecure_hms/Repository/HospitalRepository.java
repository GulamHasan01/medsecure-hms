package com.hasan.medsecure_hms.Repository;

import com.hasan.medsecure_hms.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository; // Or MongoRepository
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    // Custom query to find hospital by name if needed
    java.util.Optional<Hospital> findByName(String name);
}