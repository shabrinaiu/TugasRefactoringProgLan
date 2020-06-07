/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Asus
 */
public abstract class Game {
    private int health;

    public Game(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void subtractHealth(int health){
        if (this.health > 0)
            this.health = health - 10;
    }
    
    public String setCondition(boolean condition){
        if(condition)
            return "You won the duel";
        else
            return "You lost the duel";
    }
    
    public abstract boolean winCondition(int pirateId, int townieId);
}
