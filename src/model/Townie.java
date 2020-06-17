package model;

public class Townie extends Player{

    public Townie(int health) {
        super(health, null);
    }

    @Override
    public boolean notifyWinningCondition(int pirateId, int townieId) {
        return (pirateId != townieId);
    }

}
