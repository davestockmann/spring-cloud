package com.example.note.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note {

	private long id;
	private String title;
	private String body;
	private List<Tag> tags;

	public Note() {
	}

	@Column(name = "body")
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@OneToMany(mappedBy = "noteId", fetch = FetchType.LAZY)
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
