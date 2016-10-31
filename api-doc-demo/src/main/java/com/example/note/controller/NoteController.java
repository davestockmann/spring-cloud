package com.example.note.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.note.repository.NoteRepository;
import com.example.note.resources.Note;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {
	
	@Autowired
	private NoteRepository noteRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Note getNote(@PathVariable String id) {
        Note n= noteRepository.find(Long.valueOf(id));
        return n;
    }
	
	@RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

}
