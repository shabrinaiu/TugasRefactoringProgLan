package model;

public class Pirate extends Player{

    public Pirate(int health) {
        super(health, null);
    }

    @Override
    public boolean notifyWinningCondition(int pirateId, int townieId) {
        return (pirateId == townieId);
    }
    
}
