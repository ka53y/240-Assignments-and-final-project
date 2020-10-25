public class character{
	private int damage;
	private int specialDamage;
	private String specialName;
	private String characterName;
	private int healPerTurn;
	
	
	public character(int damage, int specialDamage, String specialName, String characterName, int healPerTurn){
		super();
		this.damage = damage;
		this.specialDamage = specialDamage;
		this.specialName = specialName;
		this.characterName = characterName;
		this.healPerTurn = healPerTurn;
	}
	
	public void setDamage(int damage){
		this.damage = damage;
	}
	
	public void setSpecialDamage(int specialDamage){
		this.specialDamage = specialDamage;
	}
	
	public void setSpecialName(String specialName){
		this.specialName = specialName;
	}
	
	public void setCharacterName(String characterName){
		this.characterName = characterName;
	}
		
	public void setHealPerTurn(int healPerTurn){
		this.healPerTurn = healPerTurn;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public int getSpecialDamage(){
		return specialDamage;
	}
	
	public String getSpecialName(){
		return specialName;
	}
	
	public String getCharacterName(){
		return characterName;
	}
	
	public int getHealPerTurn(){
		return healPerTurn;
	}
}
