package com.example.note.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.note.domain.Note;

@RunWith(SpringRunner.class)
@DataJpaTest
// @Sql(scripts = "note-test.sql")
public class NoteRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private NoteRepository noteRepository;

	@Test
	public void findAll_ShouldReturnList() {
		List<Note> notes = noteRepository.findAll();
		Assertions.assertThat(notes).isNotNull();
		Assertions.assertThat(notes.size()).isEqualTo(3);
		Assertions.assertThat(notes.get(0).getTags()).isNotNull();
		Assertions.assertThat(notes.get(0).getTags().size()).isEqualTo(3);
	}

	@Test
	public void findOne_ShouldReturnNot() {
		Note note = noteRepository.findOne(1L);
		Assertions.assertThat(note).isNotNull();
		Assertions.assertThat(note.getTags()).isNotNull();
		Assertions.assertThat(note.getTags().size()).isEqualTo(3);
	}
}
