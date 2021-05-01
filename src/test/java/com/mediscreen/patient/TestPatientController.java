package com.mediscreen.patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.patient.controller.PatientController;
import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.service.PatientService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc

@WebMvcTest(PatientController.class)
public class TestPatientController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;


    @Test
    void giventListOfPatients_whenGetPatients_thenListOfPatientsIsDisplayed() throws Exception {
        Patient patient1 = new Patient("Test", "TestNone", "1981-10-28", "F", "1 Brookside St", "100-222-3333");
        Patient patient2 = new Patient("Test2", "TestNone", "1983-04-12", "M", "1 Brookside St", "100-222-3333");

        List<Patient> patients = new ArrayList<>();
        patients.add(patient1);
        patients.add(patient2);
        given(patientService.listAll()).willReturn(patients);

        mockMvc.perform(get("/patients")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].firstName", is("Test")))
        .andReturn();

    }

    @Test
    void givenPatient_whenPatientAdded_thenPatientIsCreated() throws Exception {
        Patient patient1 = new Patient("Test", "TestName", "2000-12-01", "F", "1 Brookside St", "100-222-3333");
        when(patientService.savePatient(patient1)).thenReturn(patient1);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(patientService.savePatient(patient1));
        mockMvc.perform(post("/patient/add")
        .content(json)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful()); // 204 dans les tests, 201 avec Postman
    }
    
}
