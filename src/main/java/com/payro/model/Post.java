package com.payro.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column
	private String title;
	@Lob
	@Column
	@NotEmpty
	private String content;
	@Column
	private Instant createOn;
	@Column
	private Instant updateOn;
	@Column
	@NotBlank
	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Instant getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Instant createOn) {
		this.createOn = createOn;
	}

	public Instant getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Instant updateOn) {
		this.updateOn = updateOn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
