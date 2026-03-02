package com.hasan.medsecure_hms.Services;

import com.hasan.medsecure_hms.Model.Hospital;
import com.hasan.medsecure_hms.Repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServices {

    private final HospitalRepository hospitalRepository;

    public HospitalServices(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public Hospital getHospitalById(Long id) throws Exception {
        return hospitalRepository.findById(id)
                .orElseThrow(() -> new Exception("Hospital branch not found with ID: " + id));
    }

    public Hospital updateHospital(Long id, Hospital hospitalDetails) throws Exception {
        Hospital hospital = getHospitalById(id);

        hospital.setName(hospitalDetails.getName());
        hospital.setAddress(hospitalDetails.getAddress());
        hospital.setContactNumber(hospitalDetails.getContactNumber());
        hospital.setEmail(hospitalDetails.getEmail());

        return hospitalRepository.save(hospital);
    }

    public void deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
    }
}