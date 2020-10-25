import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;

public class main{
	public static void main(String[]args){
		ArrayList<users>theApprovedUsers = new ArrayList<>();
		ArrayList<users>theUnapprovedUsers = new ArrayList<>();
		ArrayList<character>theCharacters = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String input;
		
		theApprovedUsers.add(new users("user1", 123, false, true));
		theCharacters.add(new character(10, 15, "punch", "boxer", 5));
		theApprovedUsers.add(new users("kxsee", 123, true, true));
		theUnapprovedUsers.add(new users("newUser1", 123, false, false));
		

		do{
			System.out.println("Enter the username you want to log in with");
			String loginUser = scan.next();
			System.out.println("Enter the password for your account");
			int loginPass = scan.nextInt();
			int exists = 0;
			int loopLength;
			if(theApprovedUsers.size() > theUnapprovedUsers.size()){
				loopLength = theApprovedUsers.size();
			} else{
				loopLength = theUnapprovedUsers.size();
			}
			for(int x = 0; x < loopLength; x++){
				if(theApprovedUsers.get(x).getUserName().equals(loginUser) && theApprovedUsers.get(x).getPassword() == loginPass){
					exists = 1;
					if(theApprovedUsers.get(x).getProgrammer() == true){
						int userInput1;
						do{
							System.out.println("1. List Users\r\n"+"2. add character\r\n"+"3. approve user\r\n"+"4. Delete user\r\n"+"5. Alter character \r\n"+"6. add user \r\n" +"7. exit");
							System.out.println("Please select from the list (1-7)");
							userInput1 = scan.nextInt();
							switch(userInput1){
								case 1:
									for(int k = 0; k < theApprovedUsers.size(); k++){
										System.out.println("appUser: "+theApprovedUsers.get(k).getUserName());
									}
									for(int e = 0; e < theUnapprovedUsers.size(); e++){
										System.out.println("unappUsers: "+theUnapprovedUsers.get(e).getUserName());
									}
								break;
								case 2: 
									System.out.println("Enter the amount of damage the character will do per turn");
									int charDamage = scan.nextInt();
									System.out.println("Enter the damage done on special attack");
									int specDamage = scan.nextInt();
									System.out.println("Enter the name of special attack");
									String specName = scan.next();
									System.out.println("Enter the name of the character");
									String charName = scan.next();
									System.out.println("Enter the amount of passive heal per turn");
									int passHeal = scan.nextInt();
									theCharacters.add(new character(charDamage, specDamage, specName, charName, passHeal));
								break;
								case 3:
									for(int s = 0; s < theUnapprovedUsers.size(); s++){
										System.out.println("unappUser: "+ s  + " "+theUnapprovedUsers.get(s).getUserName());
										
									}
									System.out.println("Please select user to approve");
									int approveInput = scan.nextInt();
									if(theUnapprovedUsers.get(approveInput).getReferred() == true){
										theUnapprovedUsers.get(approveInput).setApproved(true);
									}else {
										System.out.println("This user has not been referred are you sure you want to approve them? y/n");
										String confirmApprove = scan.next();
										if(confirmApprove.equals("y")){
											theUnapprovedUsers.get(approveInput).setApproved(true);
										} else {
											System.out.println("good choice");
										}
									}
									
								break;
								case 4:
									System.out.println("Enter the username you want to delete");
									String delUser = scan.next();
									int rem = 0;
									for(int l = 0; l < theApprovedUsers.size(); l++){
										if(theApprovedUsers.get(l).getUserName().equals(delUser)){
											rem = 1;
										}
									}
									if(rem == 1){
										System.out.println("removed");
									}
									else{
										System.out.println("user not found");
									}
								break;
								case 5:
									System.out.println("Enter the character name you want to change");
									String changeChar = scan.next();
									for(int i = 0; i < theCharacters.size(); i++){
										if(theCharacters.get(i).getCharacterName().equals(changeChar)){
											System.out.println("These are the characters attributes");
											System.out.println(theCharacters.get(i).getDamage());
											System.out.println(theCharacters.get(i).getSpecialDamage());
											System.out.println(theCharacters.get(i).getSpecialName());
											System.out.println(theCharacters.get(i).getHealPerTurn());
											int alterChar;
											do{
												System.out.println("1. damage \r\n"+"2. Special damage\r\n"+"3. special name \r\n"+"4. heal per turn\r\n"+"5. exit");
												System.out.println("Please select one");
												alterChar = scan.nextInt();
												switch(alterChar){
													case 1:
														System.out.println("What would you like to change their damage to?");
														int damCha = scan.nextInt();
														theCharacters.get(i).setDamage(damCha);
													break;
													case 2:
														System.out.println("What would you like to change their special damage to?");
														int specDamCha = scan.nextInt();
														theCharacters.get(i).setSpecialDamage(specDamCha);
													break;
													case 3:
														System.out.println("What would you like to change their special name to?");
														String specNameCha = scan.next();
														theCharacters.get(i).setSpecialName(specNameCha);
													break;
													case 4:
														System.out.println("What would you like to set their passive heal per turn to?");
														int healPerCha = scan.nextInt();
														theCharacters.get(i).setHealPerTurn(healPerCha);
													break;
													case 5:
														System.out.println("Bye");
													break;
													default:
														System.out.println("Not a valid input");
													break;
												}
										}while(alterChar != 5);
										} else {
											System.out.println("could not find");
										}
									}
								break;
								case 6:
									System.out.println("Please enter the username of the player");
									String newUserName = scan.next();
									System.out.println("Please enter the password of the player");
									int newUserPass = scan.nextInt();
									System.out.println("Are they approved? true/false");
									boolean newUserApp = scan.nextBoolean();
									System.out.println("Are they a fellow programmer? true/false");
									boolean newUserProg = scan.nextBoolean();
									if(newUserApp == true){
										theApprovedUsers.add(new users(newUserName, newUserPass, newUserApp, newUserProg));
									} else {
										theUnapprovedUsers.add(new users(newUserName, newUserPass, newUserApp, newUserProg));
									}
								break;
								case 7:
									System.out.println("Bye");
								break;
								default:
									System.out.println("Not valid");
								break;	
							}
						}while(userInput1 != 7);
					} else{
						int input2;
						do{
							System.out.println("1. play \r\n"+"2. Refer an unapproved user\r\n"+"3. exit");
							input2 = scan.nextInt();
							switch(input2){
								case 1:
									System.out.println("Please select a character to play with");
									for(int y = 0; y < theCharacters.size(); y++){
										System.out.println(theCharacters.get(y).getCharacterName());
									}
									String userPick = scan.next();
									for(int p = 0; p < theCharacters.size(); p++){
										if(theCharacters.get(p).getCharacterName().equals(userPick)){
											System.out.println("All characters start with 40 health!");
											System.out.println("You will go up against an enemy that has random stats good luck!");
											int userHealth = 40;
											int compHealth = 50;
											while(userHealth > 0 && compHealth > 0){
												System.out.println("Would you like to use your super attack? you have a 1 in 3 chance of using it and will not be able to use your passive damage this turn if you choose to do so y/n");
												String supAt = scan.next();
												if(supAt.equals("y")){
													int supNum = rand.nextInt(2);
													if(supNum == 0){
														System.out.println("You have successfully used your attack");
														compHealth = compHealth - theCharacters.get(p).getSpecialDamage();
													} else{
														System.out.println("Sorry you did not use your attack but you still passively healed");
														userHealth += theCharacters.get(p).getHealPerTurn();
													}
												} else {
													System.out.println("You chose the safe decison and will hurt the enemy with your passive damage and passively heal");
													compHealth = compHealth - theCharacters.get(p).getDamage();
													userHealth += theCharacters.get(p).getHealPerTurn();
												}
												int compDamage = rand.nextInt(15);
												userHealth = userHealth - compDamage;
												System.out.println("New health for user: " +userHealth+" new health for enemy: "+compHealth);
											}
											if(userHealth <= 0 || compHealth <= 0){                                                                                                                                                                          if(userHealth > compHealth){                                                                                                                                                                                   System.out.println("You win congrats");                                                                                                                                                        } else {                                                                                                                                                                                                       System.out.println("You lost sorry");                                                                                                                                                          }                                                                                                                                                                                              } 
										} else{
											System.out.println("The character you tried to pick does not exist");
										}
									}
								break;
								case 2:
									int foundRefer = 0;
									System.out.println("Please input the username of the unapproved user you want to refer");
									for(int e= 0; e < theUnapprovedUsers.size(); e++){
										System.out.println(theUnapprovedUsers.get(e).getUserName());
									}
									String userRefer = scan.next();
									for(int o = 0; o < theUnapprovedUsers.size(); o++){
										if(theUnapprovedUsers.get(o).getUserName().equals(userRefer)){
											System.out.println("You have Succesfully referred a user");
											theUnapprovedUsers.get(o).setReferred(true);		
											foundRefer = 1;
										}
									}
									if(foundRefer == 0){
										System.out.println("Could not find the user you are looking for");
									}
								break;
								case 3:
									System.out.println("bye");
								break;
								default:
									System.out.println("Not a valid input");
								break;
								
							}
						}while(input2 != 3);
					}
				} else if(theUnapprovedUsers.get(x).getUserName().equals(loginUser) && theUnapprovedUsers.get(x).getPassword() == loginPass){
					exists = 1;
					int unAppInput1;
					do{
						System.out.println("1. list characters \r\n"+"2. Prove your worth to be approved\r\n"+"3. exit");
						System.out.println("Please select one of these options");
						unAppInput1 = scan.nextInt();
						switch(unAppInput1){
							case 1:
								for(int u = 0; u < theCharacters.size(); u++){
									System.out.println(theCharacters.get(u).getCharacterName());
								}
							break;
							case 2:
								int numCorrect = 0;
								System.out.println("You will be asked a series of questions about sportsmanship to prove your worth to our game");
								System.out.println("You have a teammate with less skill do you tell them they are less skilled? y/n");
								String proveInput = scan.next();
								if(proveInput.equals("n")){
									numCorrect += 1;
								}
								System.out.println("You have started a game but are not able to finish do you leave? y/n");
								proveInput = scan.next();
								if(proveInput.equals("n")){
									numCorrect+= 1;
								}
								System.out.println("Have you played video games before? y/n");
								proveInput = scan.next();
								if(proveInput.equals("y")){
									numCorrect+= 1;
								}
								if(numCorrect > 2){
									System.out.println("congrats you have been approved and your status will change!");
									theUnapprovedUsers.get(x).setApproved(true);
								}
							break;
							case 3:
								System.out.println("Bye");
							break;
							default:
								System.out.println("That is not a valid input");
							break;
						}	
					}while(unAppInput1 != 3);
				} else {
					System.out.println("User name or password not found");
				}
			}
			if(exists == 0) {
				System.out.println("DNE");
			}
			System.out.println("Continue y/n");
			input = scan.next();
		}while(!input.equals("n"));
	}
}	
