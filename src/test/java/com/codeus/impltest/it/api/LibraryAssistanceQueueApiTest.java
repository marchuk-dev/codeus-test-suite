package com.codeus.impltest.it.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.codeus.impltest.entity.LibraryAssistanceQueueEntity;
import com.codeus.impltest.repo.LibraryAssistanceQueueRepository;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@AutoConfigureEmbeddedDatabase(provider = AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY)
@ActiveProfiles(profiles = {"test"})
@SpringBootTest
@DisplayName("Library Assistance Queue API tests")
class LibraryAssistanceQueueApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LibraryAssistanceQueueRepository libraryAssistanceQueueRepository;

    private LibraryAssistanceQueueEntity entity;

    @BeforeAll
    void setUpBeforeClass() {
        LibraryAssistanceQueueEntity entity = LibraryAssistanceQueueEntity.builder()
          .queueName("test1")
          .description("test description 1")
          .inquiryTypes("General")
          .bookGenres("Fantasy")
          .build();
        this.entity = libraryAssistanceQueueRepository.save(entity);

        libraryAssistanceQueueRepository.save(LibraryAssistanceQueueEntity.builder()
          .queueName("test2")
          .description("test description 2")
          .inquiryTypes("Payment issue")
          .bookGenres("Science Fiction")
          .build());

        libraryAssistanceQueueRepository.save(LibraryAssistanceQueueEntity.builder()
          .queueName("test3")
          .description("test description 3")
          .inquiryTypes("Payment issue,Rare item request")
          .bookGenres("Science Fiction,Rare Books")
          .build());
    }

    @Test
    @DisplayName("(200) retrieve all queues")
    void getAllQueuesTest() throws Exception {
        mockMvc.perform(get("/api/queues"))
          .andDo(print())
          .andExpect(status().isOk())
          .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    @DisplayName("(200) ")
    void getQueueByIdTest() throws Exception {
        mockMvc.perform(get("/api/queues/{id}", entity.getId()))
          .andDo(print())
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.id",is(entity.getId().intValue())))
          .andExpect(jsonPath("$.queueName",is(entity.getQueueName())))
          .andExpect(jsonPath("$.description",is(entity.getDescription())))
          .andExpect(jsonPath("$.bookGenres",is(entity.getBookGenres())))
          .andExpect(jsonPath("$.inquiryTypes",is(entity.getInquiryTypes())));
    }

    @Test
    @DisplayName("(200) ")
    void createQueueTest() throws Exception {

        mockMvc.perform(post("/api/queues")
          .content(""));
    }
}
