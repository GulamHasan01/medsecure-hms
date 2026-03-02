package com.hasan.medsecure_hms.Controller;

import com.hasan.medsecure_hms.Model.Hospital;
import com.hasan.medsecure_hms.Services.HospitalServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {

    private final HospitalServices hospitalServices;

    public HospitalController(HospitalServices hospitalServices) {
        this.hospitalServices = hospitalServices;
    }

    // 1. Register a new Hospital/Branch
    @PostMapping
    public ResponseEntity<Hospital> registerHospital(@RequestBody Hospital hospital) {
        Hospital savedHospital = hospitalServices.saveHospital(hospital);
        return new ResponseEntity<>(savedHospital, HttpStatus.CREATED);
    }

    // 2. Get details of all registered hospital branches
    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        return ResponseEntity.ok(hospitalServices.getAllHospitals());
    }

    // 3. Get specific hospital by ID
    @GetMapping("/PUBLIC/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(hospitalServices.getHospitalById(id));
    }

    // 4. Update Hospital Information (Address, Phone, etc.)
    @PutMapping("/DOCTOR/{id}")
    public ResponseEntity<Hospital> updateHospital(@PathVariable Long id, @RequestBody Hospital hospitalDetails) throws Exception {
        return ResponseEntity.ok(hospitalServices.updateHospital(id, hospitalDetails));
    }

    // 5. Delete a Hospital Branch
    @DeleteMapping("/ADMIN/{id}")
    public ResponseEntity<Void> deleteHospital(@PathVariable Long id) {
        hospitalServices.deleteHospital(id);
        return ResponseEntity.noContent().build();
    }
}