package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSwaggerExportDocsApplicationTests {

	@Autowired
    WebApplicationContext context;

    @Test
    public void generateSwagger() throws Exception {
    	
    	MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    	String contentAsString = mockMvc
                .perform(MockMvcRequestBuilders.get("/v2/api-docs")
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
            try (Writer writer = new FileWriter(new File("target/generated-sources/swagger.json"))) {
                IOUtils.write(contentAsString, writer);
            }
    }
}
