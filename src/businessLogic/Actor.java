/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

/**
 *
 * @author Eric
 */
public class Actor {
    private String name;
    private Gender gender;
    public enum Gender{Male, Female};
    
    public Actor(String Name, Gender Gender){
        this.name = Name;
        this.gender = Gender;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Gender getGender()
    {
        return gender;
    }
}
