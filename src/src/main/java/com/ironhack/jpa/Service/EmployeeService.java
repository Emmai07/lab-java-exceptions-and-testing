package com.ironhack.jpa.Service;


import com.ironhack.jpa.Model.Employee;
import com.ironhack.jpa.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllDoctors() {
        return employeeRepository.findAll();
    }

    public Employee getDoctorById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    public List<Employee> getDoctorsByStatus(String status) {
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> getDoctorsByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
    public Employee addDoctor(Employee doctor) {
        return employeeRepository.save(doctor);
    }

    public Employee changeDoctorStatus(Long employeeId, String newStatus) {
        Employee doctor = getDoctorById(employeeId);
        doctor.setStatus(newStatus);
        return employeeRepository.save(doctor);
    }

    public Employee updateDoctorDepartment(Long employeeId, String newDepartment) {
        Employee doctor = getDoctorById(employeeId);
        doctor.setDepartment(newDepartment);
        return employeeRepository.save(doctor);
    }
}

