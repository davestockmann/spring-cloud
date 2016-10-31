package com.example.note.resources;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Note {

	private long id;

	private String title;

	private String body;

	private List<Tag> tags;

	public static class Builder {
		// Required parameters
		private final long id;
		private final String title;

		// Optional parameters - initialized to default values
		private String body = "";
		private List<String> tags = new ArrayList();

		public Builder(long id, String title) {
			this.id = id;
			this.title = title;
		}

		public Builder body(String val) {
			body = val;
			return this;
		}

		public Builder tags(List<String> val) {
			this.tags = val;
			return this;
		}

		public Note build() {
			return new Note(this);
		}

	}

	public Note(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.body = builder.body;

		if (builder.tags != null) {

			this.tags = new ArrayList();

			for (String tag : builder.tags) {
				Tag t = new Tag();
				t.setId(System.currentTimeMillis());
				t.setName(tag);

				this.tags.add(t);
			}
		}
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

}
