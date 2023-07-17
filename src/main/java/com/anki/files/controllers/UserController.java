package com.anki.files.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anki.files.common.LoginAuthentication;
import com.anki.files.common.RestObject;
import com.anki.files.pojo.DecksInsert;
import com.anki.files.pojo.Qa;
import com.anki.files.pojo.Results;
import com.anki.files.pojo.Users;
import com.anki.files.pojo.decks;
import com.anki.files.service.UsersService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/anki")
public class UserController {

	@Autowired
	UsersService service;
	
	   @CrossOrigin
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	RestObject login(Users user,@ApiIgnore HttpSession session) {
		return service.login(user, session);
	}
	
	@RequestMapping(value = "/signUp.do", method = RequestMethod.POST)
	RestObject signUp(Users user,String confirmPassword) {
		return service.signUp(user, confirmPassword);
	}
	
	@RequestMapping(value = "/vertify.do", method = RequestMethod.POST)
	 RestObject forgetPassword(Users user,@ApiIgnore HttpSession session) {
		 
		return service.forgetPassword(user, session);
	}
	
	@RequestMapping(value = "/resetPassword.do", method = RequestMethod.POST)
	RestObject resetPassword(@ApiIgnore HttpSession session, Users user, String confirmPassword) {
		return service.resetPassword(session, user, confirmPassword);
	}
	
	 @CrossOrigin
	@RequestMapping(value="/logOut.do", method=RequestMethod.POST)
	RestObject logOut(@ApiIgnore HttpSession session) {
		session.invalidate();
		return RestObject.Ok("Logged out successfully", null);
	}
	
	@LoginAuthentication
	@RequestMapping(value="/createDeck.do", method=RequestMethod.POST)
	RestObject createDeck(DecksInsert deck,@ApiIgnore HttpSession session) {
		return service.createDeck(deck, session);
	}
	
	@LoginAuthentication
	@RequestMapping(value="/deckName.do", method=RequestMethod.POST)
	RestObject deckName(@ApiIgnore HttpSession session) {
		return service.deckName( session);
	}
	
	@LoginAuthentication
	@RequestMapping(value="/removeDeck.do", method=RequestMethod.POST)
	RestObject removeDeck(decks deck,@ApiIgnore HttpSession session ) {
		return service.removeDeck(deck, session);
	}
	
	@LoginAuthentication
	@RequestMapping(value="/addToExistingDeck.do", method=RequestMethod.POST)
	RestObject addToExistingDeck(decks deck,@ApiIgnore HttpSession session) {
		return service.addToExistingDeck(deck, session);
	} 
	
	@LoginAuthentication
	@RequestMapping(value="/showDecks.do", method=RequestMethod.POST)
	RestObject showDecks(@ApiIgnore HttpSession session) {
		return service.showDecks(session);
	}
	
	@LoginAuthentication
	@RequestMapping(value="/searchDecks.do", method=RequestMethod.POST)
	RestObject searchDecks(decks deck,@ApiIgnore HttpSession session) {
		return service.searchDecks(deck, session);
	}
	
	@LoginAuthentication
	@RequestMapping(value="/editDecks.do", method=RequestMethod.POST)
	RestObject editDecks(decks deck,@ApiIgnore HttpSession session ) {
		return service.editDecks(deck, session);
	}
	
	@LoginAuthentication
	@RequestMapping(value="/normalTest.do", method=RequestMethod.POST)
	RestObject RandomIdSelector(decks deck,@ApiIgnore HttpSession session) {
		return service.RandomIdSelector( deck, session);
	}
	
	@LoginAuthentication
	@RequestMapping(value="/answerHandler.do", method=RequestMethod.POST)
	RestObject answerHandler(decks deck ,@ApiIgnore  HttpSession session) {
		return service.answerHandler(deck, session);
	}
	
	@LoginAuthentication
	@RequestMapping(value="/difficultTest.do", method=RequestMethod.POST)
	RestObject difficultTest(decks deck,@ApiIgnore HttpSession session) {
		return service.difficultTest(deck, session);
	}
	
	@LoginAuthentication
	@RequestMapping(value="/results.do", method=RequestMethod.POST)
	RestObject results(decks deck,@ApiIgnore HttpSession session) {
		return service.results(deck, session);
	}
	

	@RequestMapping(value="/help.do", method=RequestMethod.POST)
	@LoginAuthentication
	RestObject help(Qa query,@ApiIgnore HttpSession session) {
		return service.help(query, session);
	}
	
	@LoginAuthentication
	@RequestMapping(value="/feedBack.do", method=RequestMethod.POST)
	RestObject feedBack(Qa response,@ApiIgnore HttpSession session) {
		return service.feedBack(response, session);
	}

}
