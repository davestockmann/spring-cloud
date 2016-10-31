package com.perficient.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.perficient.feign.resources.Note;

@FeignClient(url = "http://localhost:8080/notes", name = "notes-service")
public interface NotesClient {

	@RequestMapping(method = RequestMethod.GET, value = "/{noteId}")
	Note findNote(@PathVariable("noteId") Long raceId);
}
