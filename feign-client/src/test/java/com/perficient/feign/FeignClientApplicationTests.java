package com.perficient.feign;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.feign.resources.Note;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableFeignClients
public class FeignClientApplicationTests {

	@Autowired
	NotesClient notesClient;

	@Test
	public void findNote() {

		Assert.assertNotNull(notesClient);
		Note n = notesClient.findNote(Long.valueOf(1));
		Assert.assertNotNull(n);
		System.out.println(n.toString());

	}

}
