package com.anki.files.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anki.files.common.RestObject;
import com.anki.files.mapper.UsersMapper;
import com.anki.files.pojo.DecksInsert;
import com.anki.files.pojo.IdRandomizer;
import com.anki.files.pojo.Qa;
import com.anki.files.pojo.Results;
import com.anki.files.pojo.State;
import com.anki.files.pojo.Users;
import com.anki.files.pojo.decks;


@Service
public class UsersService {
	@Autowired
	UsersMapper userMapper;
	

	
	public RestObject login(Users user,HttpSession session) {
		Users result=userMapper.login(user.getEmail());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		if(result!=null) {
			if(result.getPassword().equals(user.getPassword())) {
				result.setPassword(null);
				session.setAttribute("User_id", result.getId());
				return RestObject.Ok("Login succeffully",null);
				
			}else {
				return RestObject.Error("Sorry Password is incorrect. ");
			}
		}else {
			return RestObject.Error("Sorry account does exist.");
		}
		
	}
	
	public RestObject signUp(Users user,String ConfirmPassword) {
		try {
			if(user.getPassword().equals(ConfirmPassword)){
				if(validAccount(user)) {
					userMapper.signUp(user);
					return RestObject.Ok("Account has been regitered", null);
				}else {
					return RestObject.Error("invalid characters please try again");
				}
			}else {
				return RestObject.Error("first password and second password do not match");
				
			}
		}catch(Exception e){
			return RestObject.Error("The account "+ user.getEmail()+" already exists" );
		}

	}
	
	
	public RestObject forgetPassword(Users user, HttpSession session) {
		System.out.println("UsersService: forget password method is running");
		
		Users result = userMapper.selectForVertify(user.getEmail(), user.getVerification());
		if (result != null) {
			if (user.getEmail().equals(result.getEmail())) {
				if (user.getVerification().equals(result.getVerification())) {
					result.setVerification(null);
					
					session.setAttribute("verificationEmail", result.getEmail());
					
					return RestObject.Ok("valid info", result);
				}else {
					System.out.println("verification code: Error!");
					return RestObject.Error("invalid verification...");
				}	
			}else {
					return RestObject.Error("email or verification is not exist");
				}
		}
			else {

					return RestObject.Error("this email is not exist...");
				}
				
	}
	
	public RestObject resetPassword(HttpSession session,Users user, String confirmPassword) {
		
		String sessionEmail =  session.getAttribute("verificationEmail").toString();
		
		user.setEmail(sessionEmail);
		System.out.println("email: "+sessionEmail);
		System.out.println("getter: "+user.getEmail());
		if (user.getPassword().equals(confirmPassword)) {
			int result = userMapper.updatePassword(user);
			System.out.println("log: "+result);
			if (result == 0) {
				return RestObject.Error("sorry password can't reset password");
			}else {
				return RestObject.Ok("password reset succesful!", null);
			}
		}else {
			return RestObject.Error("sorry password doesn't match");
		}
			
	
	}
	
	
	public RestObject createDeck(DecksInsert deck,HttpSession session) {
		int user=(int) session.getAttribute("User_id");
		deck.setUser_id(user);
		System.out.println("user id:"+deck.getUser_id());
		System.out.println("user id:"+user);
		System.out.println("words:"+deck.getWord());
		System.out.println("meaning:"+deck.getMeaning());
		String word1=deck.getWord().get(0);
		String word2=deck.getWord().get(1);
		String word3=deck.getWord().get(2);
		String word4=deck.getWord().get(3);
		String word5=deck.getWord().get(4);
		
		String meaning1=deck.getMeaning().get(0);
		String meaning2=deck.getMeaning().get(1);
		String meaning3=deck.getMeaning().get(2);
		String meaning4=deck.getMeaning().get(3);
		String meaning5=deck.getMeaning().get(4);
		
		int result1=userMapper.createDeck(deck.getUser_id(), word1, meaning1, deck.getDeck_name());
		int result2=userMapper.createDeck(deck.getUser_id(), word2, meaning2, deck.getDeck_name());
		int result3=userMapper.createDeck(deck.getUser_id(), word3, meaning3, deck.getDeck_name());
		int result4=userMapper.createDeck(deck.getUser_id(), word4, meaning4, deck.getDeck_name());
		int result5=userMapper.createDeck(deck.getUser_id(), word5, meaning5, deck.getDeck_name());
		int sum=result1+result2+result3+result5+result4;
		
		if(sum==5) {
			return RestObject.Ok("Insertion successful", null);
		}else {
			return RestObject.Error("Somthing went wrong insertion could not be completed!");
		}
		
		
	}
	
	public RestObject addToExistingDeck(decks deck,HttpSession session) {
		int user=(int) session.getAttribute("User_id");
		deck.setUser_id(user);
		System.out.println("user id:"+deck.getUser_id());
		System.out.println("user id:"+user);
		String word1=deck.getWord();
//		String word2=deck.getWord().get(1);
//		String word3=deck.getWord().get(2);
//		String word4=deck.getWord().get(3);
//		String word5=deck.getWord().get(4);
		
		String meaning1=deck.getMeaning();
//		String meaning2=deck.getMeaning().get(1);
//		String meaning3=deck.getMeaning().get(2);
//		String meaning4=deck.getMeaning().get(3);
//		String meaning5=deck.getMeaning().get(4);
		System.out.println("word is:"+word1);
		System.out.println("meaning is:"+meaning1);
		int result1=userMapper.createDeck(deck.getUser_id(), word1, meaning1, deck.getDeck_name());
//		int result2=userMapper.createDeck(deck.getUser_id(), word2, meaning2, deck.getDeck_name());
//		int result3=userMapper.createDeck(deck.getUser_id(), word3, meaning3, deck.getDeck_name());
//		int result4=userMapper.createDeck(deck.getUser_id(), word4, meaning4, deck.getDeck_name());
//		int result5=userMapper.createDeck(deck.getUser_id(), word5, meaning5, deck.getDeck_name());
//		int sum=result1+result2+result3+result5+result4;

		if(result1==1) {
			return RestObject.Ok("Insertion successful", null);
		}else {
			return RestObject.Error("Somthing went wrong insertion could not be completed!");
		}
		
	}
	
	
	
	public RestObject deckName(HttpSession session) {
		int user=(int) session.getAttribute("User_id");
		//deck.setUser_id(user);
		ArrayList<String> result= userMapper.deckName(user);
		if(result!=null) {

			return RestObject.Ok("words obtained successfully", result);
		}else {
			return RestObject.Error("error");
		}
	}
	
	
	public RestObject removeDeck(decks deck,HttpSession session) {
		int user=(int) session.getAttribute("User_id");
		
		deck.setDeck_name(session.getAttribute("searchResult").toString());
		deck.setUser_id(user);
		int result=userMapper.removeDeck(deck.getUser_id(), deck.getDeck_name());
		if(result>0) {
			System.out.println("results"+result);
			return RestObject.Ok("deck has been deleted", null);
		}else {
			System.out.println("results"+result);
			return RestObject.Error("could not delete deck");
		}
		
	}
	
	
	public RestObject showDecks(HttpSession session) {
		int user=(int) session.getAttribute("User_id");
		System.out.println("show deck method has been called");
		ArrayList<decks> result=userMapper.showDecks(user);
		if(result!=null) {
			
			return RestObject.Ok("query successfull", result);
		}else {
			return RestObject.Error("query failure");
		}
	}
	
	
	
	public RestObject searchDecks(decks deck,HttpSession session) {
		int user=(int) session.getAttribute("User_id");
		System.out.println("search method "+deck);
		
		ArrayList<decks>result=userMapper.searchDecks(user, deck.getDeck_name());
		System.out.println("search method "+result);
		if(result.isEmpty()) {

			return RestObject.Error("The thing you does not exist");
		}else {
			session.setAttribute("searchResult", deck.getDeck_name());
			return RestObject.Ok("search successful", result);
		}
	}
	

	
	public RestObject editDecks(decks deck,HttpSession session) {
		deck.setUser_id((int)(session.getAttribute("User_id")));
		deck.setDeck_name(session.getAttribute("searchResult").toString());
		System.out.println("The word is "+ deck.getWord());
		System.out.println("The meaning is "+ deck.getMeaning());
		decks checkedDeck=   ObjectChecker(deck);
		int result=userMapper.editDeck(checkedDeck);
		if(result==1) {
			return RestObject.Ok("edit was successful", null);
		}else {
			return RestObject.Error("edit was unsuccessful");
		}
	}
	private decks ObjectChecker(decks deck) {
		
		//ArrayList<decks>result=userMapper.searchDecks(deck.getUser_id(), deck.getDeck_name());
		//System.out.println("results"+result);
		if(deck.getWord().equals("")|| deck.getWord().equals("undefined")) {
			 deck.setWord(null);
			 return deck;
				
			}else if(deck.getMeaning().equals("")||deck.getMeaning().equals("undefined")) {
				deck.setMeaning(null);
				return deck;
			}
	
		return deck;
	}
	
	public RestObject randomTestQuestion(int id,HttpSession session) {
		
		
		decks result=userMapper.randomTestQuestion(id);
		if(result!=null) {
				session.setAttribute("randomQuestion", result.getWord());
				session.setAttribute("randomId", result.getId());
				session.setAttribute("randomAnswer", result.getMeaning());
				session.setAttribute("randomStatus", result.getStatus());
		   return RestObject.Ok("The question was obtained successfully", result);
		}else {
			return RestObject.Error("could not get question");
		}
	}
	
	public RestObject RandomIdSelector(decks deck,HttpSession session) {

		
		int user=(int) session.getAttribute("User_id");
		deck.setUser_id(user);
		
		ArrayList<decks> result=userMapper.RandomIdSelector(deck.getUser_id(), deck.getDeck_name());
		//ArrayList<Integer>deck_ids=null;
		if(result.isEmpty()) {

			return RestObject.Error("Sorry deck does not exist!");
			
		}else {
			System.out.println("results"+result);
			
			int id=IdRandomizer(result);
			session.setAttribute("deck_id", id);
			
			
			System.out.println("id's have been retrieved"+ result);
			return randomTestQuestion(id,session);
		}
	}
	
	public RestObject difficultTest(decks deck,HttpSession session) {
		int user=(int) session.getAttribute("User_id");
		deck.setUser_id(user);
		State stateObj=new State();
		try {
			ArrayList<decks>result=userMapper.difficultTest(deck.getUser_id(), 
					deck.getDeck_name(),stateObj.hard );
			if(result!=null) {
				int id=IdRandomizer(result);
				session.setAttribute("deck_id", id);
				
				System.out.println("id's have been retrieved"+ result);
				return randomTestQuestion(id,session);
			}else {
				System.out.println("id's have been retrieved"+ result);
			
				return RestObject.Error("id was not been retrieved");
			}
		}catch(Exception e) {
			return RestObject.Error("There are no difficult words in deck");
		}

	}
	
	private int IdRandomizer(ArrayList<decks> ids) {
		Random random = new Random();
		int index=random.nextInt(ids.size());
		decks id=ids.get(index);
		int finalId=id.getId();
		System.out.println("the random id is:"+index);
		System.out.println("The arraylist of id"+ids);
		System.out.println("The arraylist of id"+finalId);
		return finalId;
	}
	
	
	public RestObject answerHandler(decks deck,HttpSession session) {
		String answer=session.getAttribute("randomAnswer").toString();
		String question=session.getAttribute("randomQuestion").toString();
		int deck_id=(int)session.getAttribute("deck_id");
		State stateObj=new State();
		//ArrayList<String>rightAnswer=new ArrayList(); 
		//ArrayList<String>rightMeaning=new ArrayList(); 
		//ArrayList<String>wrongAnswer=new ArrayList(); 
		//ArrayList<String>wrongMeaning=new ArrayList(); 
		String lowercaseAnswer=deck.getMeaning().toLowerCase();
		if(lowercaseAnswer.equals(answer)) {
			
			int result=userMapper.answerHandler(deck_id, stateObj.easy);
			if(result==1) {
				//rightAnswer.add(answer);
				//rightMeaning.add(question);
				//session.setAttribute("rightAnswer", rightAnswer);
				//session.setAttribute("rightMeaning", rightMeaning);
				
				return RestObject.Ok("The right answer arrays have been created",null);
			}else {
				return RestObject.Error("could not create the Arrays");
			}}else {
				int result=userMapper.answerHandler(deck_id, stateObj.hard);
				if(result==1) {
					//wrongAnswer.add(answer);
					//wrongMeaning.add(question);
					//session.setAttribute("wrongAnswer",wrongAnswer);
					//session.setAttribute("wrongMeaning",wrongMeaning);
					return RestObject.Error("the answer is wrong but wrong answer map"
							+ "was created");
				}else {
					return RestObject.Error("The answer is wrong and the wrong answer"
							+ "map was not created");
				}

			}
		
	}
	
	public RestObject help(Qa help,HttpSession session) {
		int user=(int) session.getAttribute("User_id");
		help.setUser_id(user);
		int result=userMapper.help(help);
		if(result==1) {
			
			Qa rowId=userMapper.rowId(user,help.getQuestions());
			if(rowId!=null) {
				 int Qa_id =rowId.getId();
				session.setAttribute("Qa_id", Qa_id);
				return RestObject.Ok("The row id has been retrieved", Qa_id);
			}else {
			return RestObject.Ok("The admin will get back to you...rwo id "
					+ "was not retrieved", result);
			}
		}else {
			return RestObject.Error("The message was not sent");
		}
	}
	
	public RestObject feedBack(Qa response,HttpSession session) {
		int user=(int) session.getAttribute("User_id");
		response.setUser_id(user);
		
		ArrayList<Qa>result=userMapper.feedBack(response.getUser_id());
		if(result!=null) {
		    
			return RestObject.Ok("You have mail", result);
		}else {
			return RestObject.Error("sorry you don't have any new mail");
		}
	}
	
	
	public RestObject results(decks deck,HttpSession session) {
		int user=(int) session.getAttribute("User_id");
		deck.setUser_id(user);
		ArrayList<decks> result=userMapper.results(deck);
		if(result!=null) {
			return RestObject.Ok("The results are as follows",result);
		}else {
			return RestObject.Error("No resutls exist");
		}
		
	}
	

	
    private boolean validAccount(Users user) {
        boolean flag = true;
        String user_name = user.getUser_name();
        flag = user_name.matches("^[\\\\u4e00-\\\\u9fa5a-zA-Z][\\\\u4e00-\\\\u9fa5a-zA-Z]+$");
        flag = flag && user.getPassword().matches("^[\\\\u4e00-\\\\u9fa5a-zA-Z][\\\\u4e00-\\\\u9fa5a-zA-Z]+$");
        return flag;
    }
}
