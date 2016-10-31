package com.example.note.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.note.resources.Note;

@Service
public class NoteRepositoryImpl implements NoteRepository {

	/* (non-Javadoc)
	 * @see com.example.note.repository.NoteRepository#findAll()
	 */
	@Override
	public List<Note> findAll() {

		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.note.repository.NoteRepository#find(java.lang.Long)
	 */
	@Override
	public Note find(Long id) {
		return new Note.Builder(1, "The Empire Strikes Back").tags(Arrays.asList("movie", "star-wars")).build();
	}

}
