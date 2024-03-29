package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.TwitException;
import com.example.exception.UserException;
import com.example.modal.Like;
import com.example.modal.Twit;
import com.example.modal.User;
import com.example.repository.LikeRepository;
import com.example.repository.TwitRepository;

@Service
public class LikeServiceImplementation implements LikeService {
	
	@Autowired
	private LikeRepository likeRepository;
	
	@Autowired
	private TwitService twitService;
	
	@Autowired
	private TwitRepository twitRepository;

	@Override
	public Like likeTwit(Long twitId, User user) throws UserException, TwitException {
		Like isLikeExist=likeRepository.isLikeExist(user.getId(), twitId);
		
		if(isLikeExist!=null) {
			likeRepository.deleteById(isLikeExist.getId());
			return isLikeExist;
		}
		
		Twit twit=twitService.findById(twitId);
		
		Like like=new Like();
		like.setTwit(twit);
		like.setUser(user);
		
		Like savedLike=likeRepository.save(like);
		
		twit.getLikes().add(savedLike);
		twitRepository.save(twit);
		
		return savedLike;
	}

	@Override
	public List<Like> getAllLikes(Long twitId) throws TwitException {

        Twit twit=twitService.findById(twitId);
        
        List<Like> likes=likeRepository.findByTwitId(twitId);
		return likes;
	}

}
