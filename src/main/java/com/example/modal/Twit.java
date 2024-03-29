package com.example.modal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Twit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private User user;
	
	private String content;
	private String image;
	private String video;
	
	@OneToMany(mappedBy = "twit",cascade = CascadeType.ALL)
	private List<Like> likes=new ArrayList<>();
	
	@OneToMany
	private List<Twit> replyTwits=new ArrayList<>();
	
	@ManyToMany
	private List<User> retwitUser=new ArrayList<>();
	
	@ManyToOne
	private Twit replayFor;
	
	private boolean isReply;
	private boolean isTwit;
	
	private LocalDateTime createdAt;
	
	public Twit() {
		
	}

	public Twit(Long id, User user, String content, String image, String video, List<Like> likes, List<Twit> replyTwits,
			List<User> retwitUser, Twit replayFor, boolean isReply, boolean isTwit, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.image = image;
		this.video = video;
		this.likes = likes;
		this.replyTwits = replyTwits;
		this.retwitUser = retwitUser;
		this.replayFor = replayFor;
		this.isReply = isReply;
		this.isTwit = isTwit;
		createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<Twit> getReplyTwits() {
		return replyTwits;
	}

	public void setReplyTwits(List<Twit> replyTwits) {
		this.replyTwits = replyTwits;
	}

	public List<User> getRetwitUser() {
		return retwitUser;
	}

	public void setRetwitUser(List<User> retwitUser) {
		this.retwitUser = retwitUser;
	}

	public Twit getReplayFor() {
		return replayFor;
	}

	public void setReplayFor(Twit replayFor) {
		this.replayFor = replayFor;
	}

	public boolean isReply() {
		return isReply;
	}

	public void setReply(boolean isReply) {
		this.isReply = isReply;
	}

	public boolean isTwit() {
		return isTwit;
	}

	public void setTwit(boolean isTwit) {
		this.isTwit = isTwit;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		createdAt = createdAt;
	}
	
	
}
