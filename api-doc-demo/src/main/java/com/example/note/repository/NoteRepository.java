package com.example.note.repository;

import java.util.List;

import com.example.note.resources.Note;

public interface NoteRepository {

	List<Note> findAll();

	Note find(Long id);

}