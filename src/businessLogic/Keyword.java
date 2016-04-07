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
public class Keyword {
    private String name;
    
    public Keyword(String Name){
        this.name = Name;
    }
    
    public String getKeyword(){
        return this.name;
    }
}
