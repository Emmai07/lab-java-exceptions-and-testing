package com.ironhack.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class TestClass {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testGetPatientById() throws Exception {
        mockMvc.perform(get("/api/patients/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
    @Test
    public void testGetPatientsByDateOfBirthRange() throws Exception {
        mockMvc.perform(get("/api/patients/dob"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testGetPatientsByAdmittingDoctorsDepartment() throws Exception {
        mockMvc.perform(get("/api/patients/department/101"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testGetPatientsWithDoctorsInStatusOff() throws Exception {
        mockMvc.perform(get("/api/patients/doctors/status/OFF"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testGetAllDoctors() throws Exception {
        mockMvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testGetDoctorById() throws Exception {
        mockMvc.perform(get("/api/employee/10"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testGetDoctorsByStatus() throws Exception {
        mockMvc.perform(get("/api/employee/status/ON"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testGetDoctorsByDepartment() throws Exception {
        mockMvc.perform(get("/api/employee/department/101"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testUpdatePatientInformation() throws Exception {
        mockMvc.perform(get("/api/employee/department/101"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testUpdateDoctorDepartment() throws Exception {
        mockMvc.perform(get("/api/101/department"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }

}
