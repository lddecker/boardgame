package lddecker.boardgame.board;

class Cell {
    private int _multiplier;
    private Character _emptyDisplay;
    private Character _currValue;

    Cell() {
        _multiplier = 1;
        _emptyDisplay = ' ';
        _currValue = null;
    }

    void update(Character newVal) throws Exception {
        if (!isValidCharacter(newVal)) {
            throw new Exception("Invalid value for cell: " + newVal);
        }
        if (_currValue != null) {
            throw new Exception("Cell is already populated");
        }
        _currValue = newVal;
    }

    public static boolean isValidCharacter(Character newVal) {
        return null != newVal && ' ' != newVal;
    }

    int getScore() {
        if (null == _currValue) {
            return 0;
        }
        return _multiplier;
    }

    Character getDisplayChar() {
        if (null == _currValue) {
            return _emptyDisplay;
        }
        return _currValue;
    }
}
