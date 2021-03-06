package com.example.notes;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NoteInput {
	
	@NotBlank
	private final String title;

	@Length(max = 1024)
	private final String body;

	private final List<URI> tagUris;

	@JsonCreator
	public NoteInput(@JsonProperty("title") String title,
			@JsonProperty("body") String body, @JsonProperty("tags") List<URI> tagUris) {
		this.title = title;
		this.body = body;
		this.tagUris = tagUris == null ? Collections.<URI>emptyList() : tagUris;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	@JsonProperty("tags")
	public List<URI> getTagUris() {
		return this.tagUris;
	}

}
