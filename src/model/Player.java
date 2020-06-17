package model;

public class Player {
    private Piece piece;
    private int health;

    public Player(int health, Piece piece) {
        this.health = health;
        this.piece = piece;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void subtractHealth() {
        if (this.health > 0)
            this.health -= 10;
    }
    
    public String setCondition(boolean condition){
        if(condition)
            return "You won the duel";
        else
            return "You lost the duel";
    }
    
    public boolean notifyWinningCondition(int pirateId, int townieId) {
        return piece.notifyWinningCondition(pirateId, townieId);
    }
}
