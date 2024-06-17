package com.self.vehicleregistration.api;

import com.self.vehicleregistration.service.VehicleRegistrationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.self.vehicleregistration.api.TestConstants.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = VehicleRegistrationController.class)
class VehicleRegistrationControllerTest {

    @MockBean
    private VehicleRegistrationService vehicleRegistrationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSaveVehiclesWith201() throws Exception {
        mockMvc.perform(post("/v1/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(PAYLOAD_CORRECT))
                .andExpect(status().is(201));
    }

    @Test
    void testSaveVehiclesWith400() throws Exception {
        mockMvc.perform(post("/v1/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(PAYLOAD_WRONG))
                .andExpect(status().is(400));
    }

    @Test
    void testIgnoreVWVehicles() throws Exception {
        mockMvc.perform(post("/v1/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(PAYLOAD_WITH_VW))
                .andExpect(status().is(201));
    }

    @Test
    void testIgnoreVehiclesWithBayOver100() throws Exception {
        mockMvc.perform(post("/v1/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(PAYLOAD_WITH_BAY_OVER_100))
                .andExpect(status().is(201));
    }

    @Test
    void testSaveVehiclesWithoutBayNumber() throws Exception {
        mockMvc.perform(post("/v1/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(PAYLOAD_WITHOUT_BAY_NUMBER))
                .andExpect(status().is(201));
    }

    @Test
    void testSaveVehiclesWithFORDandGM() throws Exception {
        mockMvc.perform(post("/v1/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(PAYLOAD_ONLY_FORD_AND_GM))
                .andExpect(status().is(201));
    }

}
