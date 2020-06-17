package model;

public enum Piece {
    PIRATE,
    TOWNIE {
        @Override
        boolean notifyWinningCondition(int pirateId, int townieId) {
            return !super.notifyWinningCondition(pirateId, townieId);
        }
    };

    boolean notifyWinningCondition(int pirateId, int townieId) {
        return (pirateId == townieId);
    }
}
