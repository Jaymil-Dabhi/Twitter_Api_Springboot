package com.example.service;

import java.util.List;

import com.example.exception.TwitException;
import com.example.exception.UserException;
import com.example.modal.Like;
import com.example.modal.User;

public interface LikeService {

	public Like likeTwit(Long twitId,User user) throws UserException, TwitException;
	
	public List<Like> getAllLikes(Long twitId) throws TwitException;
}
