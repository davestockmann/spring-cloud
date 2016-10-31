package com.perficient.feign.resources;

public class Note {

	private long id;

	private String title;

	private String body;

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

}
