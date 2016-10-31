package com.example.nutrition.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.RequestDispatcher;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.request.ParameterDescriptor;
import org.springframework.restdocs.snippet.Snippet;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.ApiDocDemoApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApiDocDemoApplication.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@AutoConfigureMockMvc
public class ApiDocumentation {

	/*
	 * See also:
	 * https://github.com/ssouris/spring-tutorials/tree/master/introduction-to-
	 * spring-restdocs
	 * 
	 * https://www.tothepoint.company/blog/spring-rest-doc/
	 */

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Ignore
	public void errorExample() throws Exception {
		this.mockMvc
				.perform(get("/error").requestAttr(RequestDispatcher.ERROR_STATUS_CODE, 400)
						.requestAttr(RequestDispatcher.ERROR_REQUEST_URI, "/notes").requestAttr(
								RequestDispatcher.ERROR_MESSAGE,
								"The tag 'http://localhost:8080/tags/123' does not exist"))
				.andDo(print()).andExpect(status().isBadRequest()).andExpect(jsonPath("error", is("Bad Request")))
				.andExpect(jsonPath("timestamp", is(notNullValue()))).andExpect(jsonPath("status", is(400)))
				.andExpect(jsonPath("path", is(notNullValue())))
				.andDo(document("error-example",
						responseFields(
								fieldWithPath("error").description("The HTTP error that occurred, e.g. `Bad Request`"),
								fieldWithPath("message").description("A description of the cause of the error"),
								fieldWithPath("path").description("The path to which the request was made"),
								fieldWithPath("status").description("The HTTP status code, e.g. `400`"),
								fieldWithPath("timestamp")
										.description("The time, in milliseconds, at which the error occurred"))));
	}

	@Test
	public void findNoteExample() throws Exception {

		RestDocumentationResultHandler document = documentPrettyPrintReqResp("getNote", responseFields(noteFields()));

		document.document(
				pathParameters(new ParameterDescriptor[] { parameterWithName("id").description("id of the note") }));

		this.mockMvc.perform(get("/notes/1")).andExpect(status().isOk()).andDo(document);

	}

	private static FieldDescriptor[] noteFields() {

		return new FieldDescriptor[] { fieldWithPath("id").description("The identifier of the note"),
				fieldWithPath("title").description("the title of the note"),
				fieldWithPath("body").description("the note body"),
				fieldWithPath("tags").description("List of tags associated with the note") };
	}

	/**
	 * Pretty print request and response
	 * 
	 * @param useCase
	 *            the name of the snippet
	 * @return RestDocumentationResultHandler
	 */
	private RestDocumentationResultHandler documentPrettyPrintReqResp(String useCase, Snippet... snippets) {
		return document(useCase, preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()), snippets);
	}

}