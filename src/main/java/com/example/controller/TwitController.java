package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.TwitDto;
import com.example.dto.mapper.TwitDtoMapper;
import com.example.exception.TwitException;
import com.example.exception.UserException;
import com.example.modal.Twit;
import com.example.modal.User;
import com.example.request.TwitReplyRequest;
import com.example.service.TwitService;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/twits")
public class TwitController {

	@Autowired
	private TwitService twitService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<TwitDto> createTwit(@RequestBody Twit req, @RequestHeader("Authorization")String jwt)throws UserException, TwitException{
		User user=userService.findUserProfileByJwt(jwt);
		
		Twit twit=twitService.createTwit(req, user);
		
		TwitDto twitDto=TwitDtoMapper.toTwitDto(twit, user);
		
		return new ResponseEntity<>(twitDto,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/reply")
	public ResponseEntity<TwitDto> replyTwit(@RequestBody TwitReplyRequest req, @RequestHeader("Authorization")String jwt)throws UserException, TwitException{
		User user=userService.findUserProfileByJwt(jwt);
		
		Twit twit=twitService.createdReply(req, user);
		
		TwitDto twitDto=TwitDtoMapper.toTwitDto(twit, user);
		
		return new ResponseEntity<>(twitDto,HttpStatus.CREATED);
	}
	
	
}
