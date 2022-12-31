package com.example.demo.teacher.rest;


import com.example.demo.shared.ConstantTest;
import com.example.demo.shared.RestBaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MvcResult;

import java.util.UUID;

import static com.example.demo.teacher.rest.stub.CreateTeacherRequestStub.getCreateTeacherRequest;
import static com.example.demo.teacher.rest.stub.CreateTeacherRequestStub.getCreateTeacherRequestEmpty;
import static com.example.demo.teacher.rest.stub.UpdateTeacherRequestStub.getUpdateTeacherRequest;
import static com.example.demo.teacher.rest.stub.UpdateTeacherRequestStub.getUpdateTeacherRequestEmpty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Tag("Smoke-test")
class TeacherControllerTest extends RestBaseTest {

    private static final String TEACHER_URL = "/teacher";
    private static final String TEACHER_URL_ID_TEACHER = TEACHER_URL + "/{idTeacher}";
    private static final String TEACHER_URL_ID_TEACHER_ACTIVATE = TEACHER_URL_ID_TEACHER + "/activate";

    @Test
    void should_create_a_teacher_ok() throws Exception{
        mockMvc.perform(
                post(TEACHER_URL)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(parseJson(getCreateTeacherRequest())))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void should_return_bad_request_error_creating_teacher_without_mandatory_fields() throws Exception{
        mockMvc.perform(
                post(TEACHER_URL)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(parseJson(getCreateTeacherRequestEmpty())))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Test
    @Sql(scripts = "classpath:sql/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/clear-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_update_a_teacher_ok() throws Exception {
        mockMvc.perform(
                put(TEACHER_URL_ID_TEACHER , ConstantTest.UPDATE_TEACHER_ID1_CREATED)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(parseJson(getUpdateTeacherRequest())))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @Sql(scripts = "classpath:sql/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/clear-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_return_bad_request_error_updating_teacher_without_mandatory_fields() throws Exception{
        mockMvc.perform(
                put(TEACHER_URL_ID_TEACHER , ConstantTest.UPDATE_TEACHER_ID1_CREATED)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(parseJson(getUpdateTeacherRequestEmpty())))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Test
    void should_return_not_found_exception_updating_a_teacher_that_not_exists() throws Exception {
        String notExistsTeacherId = UUID.randomUUID().toString();
        mockMvc.perform(
                put(TEACHER_URL_ID_TEACHER , notExistsTeacherId)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(parseJson(getUpdateTeacherRequest())))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    @Test
    @Sql(scripts = "classpath:sql/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/clear-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_activate_teacher_ok() throws Exception {
        mockMvc.perform(
                patch(TEACHER_URL_ID_TEACHER_ACTIVATE , ConstantTest.UPDATE_TEACHER_ID1_CREATED))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void should_return_not_found_exception_activating_a_teacher_that_not_exists() throws Exception {
        String notExistsTeacherId = UUID.randomUUID().toString();
        mockMvc.perform(
                patch(TEACHER_URL_ID_TEACHER_ACTIVATE , notExistsTeacherId))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    @Test
    @Sql(scripts = "classpath:sql/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/clear-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_delete_teacher_ok() throws Exception {
        mockMvc.perform(
                delete(TEACHER_URL_ID_TEACHER , ConstantTest.UPDATE_TEACHER_ID1_CREATED))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void should_delete_not_found_exception_activating_a_teacher_that_not_exists() throws Exception {
        String notExistsTeacherId = UUID.randomUUID().toString();
        mockMvc.perform(
                delete(TEACHER_URL_ID_TEACHER , notExistsTeacherId))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    @Test
    @Sql(scripts = "classpath:sql/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/clear-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_find_a_teacher_by_id_ok() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get(TEACHER_URL_ID_TEACHER , ConstantTest.UPDATE_TEACHER_ID1_CREATED))
            .andReturn();
        mockMvc.perform(
                asyncDispatch(mvcResult))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value(ConstantTest.TEACHER_NAME_TEST));
    }

    @Test
    @Sql(scripts = "classpath:sql/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/clear-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_find_all_teachers_default_pagination_ok() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get(TEACHER_URL))
            .andReturn();
        mockMvc.perform(
                asyncDispatch(mvcResult))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.teachers.length()").value(3))
            .andExpect(jsonPath("$.totalPages").value(1))
            .andExpect(jsonPath("$.totalElements").value(3));
    }
}