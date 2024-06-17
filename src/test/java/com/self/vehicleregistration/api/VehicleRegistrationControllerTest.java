package com.self.vehicleregistration.api;

import com.self.vehicleregistration.service.VehicleRegistrationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = VehicleRegistrationController.class)
class VehicleRegistrationControllerTest {

    @MockBean
    private VehicleRegistrationService vehicleRegistrationService;

    @Autowired
    private MockMvc mockMvc;

    
    private static final String PAYLOAD_CORRECT = """
            {"vehicles": [
            {
                        
                            "VIN": "1234",
                            "manufacturer": "GM",
                            "bay_number": 200
                        },
                        {
                        
                            "VIN": "12",
                            "manufacturer": "FORD",
                            "bay_number": 1
                        }
            ]
            }
            """;

    private static final String PAYLOAD_WRONG = """
            {"vehicles": [
            {
                        
                            "VIN": "1234",
                            "manufacturer": "GM",
                            "bay_number": 200
                        },
                        {
                        
                            "VIN": "12",
                            "manufacturer": "",
                            "bay_number": 1
                        }
            ]
            }
            """;

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

}
