package com.ironhack.jpa.Service;

import com.ironhack.jpa.Model.Patient;
import com.ironhack.jpa.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long patientId) {
        return patientRepository.findById(patientId).get();
    }

    public List<Patient> getPatientsByDateOfBirthRange(LocalDate startDate, LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    public List<Patient> getPatientsByAdmittingDoctorsDepartment(String department) {
        return patientRepository.findByAdmittingDoctor_Department(department);
    }

    public List<Patient> getPatientsWithDoctorsInStatusOff() {
        return patientRepository.findPatientsWithDoctorsInStatusOff();
    }
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long patientId, Patient updatedPatient) {
        Patient patient = getPatientById(patientId);
        // Update patient information
        patient.setName(updatedPatient.getName());
        patient.setDateOfBirth(updatedPatient.getDateOfBirth());
        // Add more fields as needed
        return patientRepository.save(patient);
    }
}

