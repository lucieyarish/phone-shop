package dev.lucieyarish.phoneshopdemo.controllers;

import dev.lucieyarish.phoneshopdemo.services.PhoneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(PhoneController.class)
class PhoneControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PhoneService phoneService;

    @Test
    void createPhoneSuccessTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/phones")
                        .content("{\"brand\": \"Xiaomi\"," +
                                "    \"operating_system\": \"Android\"," +
                                "    \"model\": \"Redmi Note 11\"," +
                                "    \"price\": \"10000\", " +
                                "    \"image\": \"R0lGODlhAQABAIAAAAUEBA\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.ALL))
                .andExpect(status().isCreated());
    }

    @Test
    void createPhoneNoBrandTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/phones")
                        .content("{\"brand\": \"\"," +
                                "    \"operating_system\": \"Android\"," +
                                "    \"model\": \"Redmi Note 11\"," +
                                "    \"price\": \"10000\", " +
                                "    \"image\": \"R0lGODlhAQABAIAAAAUEBA\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.ALL))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors")
                        .value("Brand is required."));
    }

    @Test
    void createPhoneNoOperatingSystemTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/phones")
                        .content("{\"brand\": \"Xiaomi\"," +
                                "    \"operating_system\": \"\"," +
                                "    \"model\": \"Redmi Note 11\"," +
                                "    \"price\": \"10000\", " +
                                "    \"image\": \"R0lGODlhAQABAIAAAAUEBA\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.ALL))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors")
                        .value("Operating system is required."));
    }

    @Test
    void createPhoneNoPriceTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/phones")
                        .content("{\"brand\": \"Xiaomi\"," +
                                "    \"operating_system\": \"Android\"," +
                                "    \"model\": \"Redmi Note 11\"," +
                                "    \"price\": \"\", " +
                                "    \"image\": \"R0lGODlhAQABAIAAAAUEBA\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.ALL))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors")
                        .value("Price is required."));
    }

    @Test
    void createPhonePriceNegativeValueTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/phones")
                        .content("{\"brand\": \"Xiaomi\"," +
                                "    \"operating_system\": \"Android\"," +
                                "    \"model\": \"Redmi Note 11\"," +
                                "    \"price\": \"-10000\", " +
                                "    \"image\": \"R0lGODlhAQABAIAAAAUEBA\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.ALL))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors")
                        .value("Price must be greater than or equal to 0."));
    }

    @Test
    void createPhoneNoImageTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/phones")
                        .content("{\"brand\": \"Xiaomi\"," +
                                "    \"operating_system\": \"Android\"," +
                                "    \"model\": \"Redmi Note 11\"," +
                                "    \"price\": \"10000\", " +
                                "    \"image\": \"\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.ALL))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors")
                        .value("Image is required."));
    }
}
