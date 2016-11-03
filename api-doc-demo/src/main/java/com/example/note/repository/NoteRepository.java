package com.example.note.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.note.domain.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

	List<Note> findAll();

}