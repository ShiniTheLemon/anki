package com.anki.files.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.anki.files.pojo.Qa;
import com.anki.files.pojo.State;
import com.anki.files.pojo.Users;

import com.anki.files.pojo.decks;

@Repository
public interface UsersMapper {
	Users login(@Param("email")String email);
	int signUp(@Param("user")Users user);
	
	Users selectForVertify(@Param("email") String email, @Param("verification") String verification);
	
	 int updatePassword(@Param("user")Users user);
	 
	 int createDeck(@Param("user_id")int user_id,@Param("word")String word,
			 @Param("meaning")String meaning,
			 @Param("deck_name")String deck_name);
	//  ArrayList<String> deckName(@Param("user_id")int user_id);
	 ArrayList<String> deckName(@Param("user_id")int user_id);
	 int removeDeck(@Param("user_id")int user_id,@Param("deck_name")String deck_name);
	//int updatePassword(@Param("email") String email, @Param("password")String password);
	 
	 ArrayList<decks> showDecks(@Param("user_id")int user_id);
	 
	 ArrayList<decks> searchDecks(@Param("user_id")int user_id,@Param("deck_name")String deck_name);

	 int editDeck(@Param("deck")decks deck);
	//Users selectForVertify(String email);
	 
	 decks randomTestQuestion(@Param("id")int id);
	 
	 
	 ArrayList<decks> RandomIdSelector(@Param("user_id")int user_id,
			 @Param("deck_name")String deck_name);
	 
	 
	 ArrayList<decks> difficultTest(@Param("user_id")int user_id,
			 @Param("deck_name")String deck_name,int state);
	 
	 int answerHandler(@Param("id")int id,@Param("state")int state);
	 
	 int help(@Param("help")Qa help);
	 
	 Qa rowId(@Param("user_id")int user_id,@Param("questions")String questions);
	 
	 ArrayList<decks>results(@Param("deck")decks deck);
	 ArrayList<Qa>feedBack(@Param("user_id")int user_id);

}
