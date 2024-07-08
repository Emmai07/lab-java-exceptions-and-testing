package com.ironhack.jpa.Controller;

import com.ironhack.jpa.Model.Employee;
import com.ironhack.jpa.Model.Patient;
import com.ironhack.jpa.Service.EmployeeService;
import com.ironhack.jpa.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RequestMapping("/api")
public class Controller {

    @Autowired
    private PatientService patientService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping("/patients/dob")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorsDepartment(@PathVariable String department) {
        return patientService.getPatientsByAdmittingDoctorsDepartment(department);
    }

    @GetMapping("/patients/doctors/status/OFF")
    public List<Patient> getPatientsWithDoctorsInStatusOff() {
        return patientService.getPatientsWithDoctorsInStatusOff();
    }
    @GetMapping
    public List<Employee> getAllDoctors() {
        return employeeService.getAllDoctors();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getDoctorById(@PathVariable Long employeeId) {
        Employee doctor = employeeService.getDoctorById(employeeId);
        return ResponseEntity.ok().body(doctor);
    }

    @GetMapping("/employee/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return employeeService.getDoctorsByStatus(status);
    }

    @GetMapping("/employee/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        return employeeService.getDoctorsByDepartment(department);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Patient> updatePatientInformation(
            @PathVariable Long patientId,
            @RequestBody Patient updatedPatient) {
        Patient patient = patientService.updatePatient(patientId, updatedPatient);
        return ResponseEntity.ok().body(patient);
    }

    @PutMapping("/{employeeId}/department")
    public ResponseEntity<Employee> updateDoctorDepartment(
            @PathVariable Long employeeId,
            @RequestParam String newDepartment) {
        Employee updatedDoctor = employeeService.updateDoctorDepartment(employeeId, newDepartment);
        return ResponseEntity.ok().body(updatedDoctor);
    }

    @PutMapping("/{employeeId}/status")
    public ResponseEntity<Employee> changeDoctorStatus(
            @PathVariable Long employeeId,
            @RequestParam String newStatus) {
        Employee updatedDoctor = employeeService.changeDoctorStatus(employeeId, newStatus);
        return ResponseEntity.ok().body(updatedDoctor);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addNewDoctor(@RequestBody Employee doctor) {
        Employee savedDoctor = employeeService.addDoctor(doctor);
        return ResponseEntity.ok().body(savedDoctor);
    }

    @PostMapping("patient/add")
    public ResponseEntity<Patient> addNewPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.addPatient(patient);
        return ResponseEntity.ok().body(savedPatient);
    }

}

