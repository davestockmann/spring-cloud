package com.perficient.feign;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.feign.resources.Note;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableFeignClients
public class FeignClientApplicationTests {

	@Autowired
	NotesClient notesClient;

	@Test
	public void findNote() {

		String body = "this is the body";
		Assertions.assertThat(notesClient).isNotNull();
		Note n = notesClient.findNote(Long.valueOf(1), body);
		Assertions.assertThat(n).isNotNull();
		Assertions.assertThat(n.getBody()).isEqualTo(body);
	}

	@Test
	public void findNotes() {
		List<Note> notes = notesClient.findNotes();
		Assertions.assertThat(notes).isNotNull();
		Assertions.assertThat(notes.size()).isEqualTo(3);
	}

}
