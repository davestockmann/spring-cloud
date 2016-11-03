package com.perficient.feign.resources;

import java.util.List;

public class Note {

	private long id;

	private String title;

	private String body;

	private List<Tag> tags;

	public Note() {
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("'id':").append(id).append(",");
		sb.append("'title':").append(title).append(",");
		sb.append("'body':").append(body);

		return sb.toString();
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
