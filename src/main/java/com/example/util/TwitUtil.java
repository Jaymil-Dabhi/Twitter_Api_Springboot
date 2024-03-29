package com.example.util;

import com.example.modal.Like;
import com.example.modal.Twit;
import com.example.modal.User;

public class TwitUtil {

	public final static boolean isLikedByReqUser(User reqUser,Twit twit) {
		for(Like like: twit.getLikes()) {
			if(like.getUser().getId().equals(reqUser.getId())) {
				return true;
			}
		}
		return false;
	}
	
	public final static boolean isRetwitedByReqUser(User reqUser,Twit twit) {
		for(User user: twit.getRetwitUser()) {
			if(user.getId().equals(reqUser.getId())) {
				return true;
			}
		}
		return false;
	}
}
