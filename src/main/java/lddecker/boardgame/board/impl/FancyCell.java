package lddecker.boardgame.board.impl;

import lddecker.boardgame.board.AbstractCell;

import javax.swing.*;
import java.awt.*;

public class FancyCell extends AbstractCell {
    private JButton _button;

    private final Insets _buttonMargin = new Insets(0, 0, 0, 0);
    private final Color _defaultCellBackground = Color.WHITE;

    public FancyCell() {
        _button = new JButton();
        _button.setMargin(_buttonMargin);
        _button.setBackground(_defaultCellBackground);
        _button.setText("");
    }

    public JButton getButton() {
        return _button;
    }

    @Override
    protected void updateCellValue(Character newVal) {
        _button.setText(newVal.toString());
    }

    @Override
    protected void resetImpl() {
        _button.setText("");
    }

    @Override
    protected void tripleScoreModifierImpl() {
        _button.setBackground(Color.RED);
    }

    @Override
    protected void doubleScoreModifierImpl() {
        _button.setBackground(Color.PINK);
    }

    @Override
    public void doubleScoreModifier(Object modifier) {
        super.doubleScoreModifier(modifier);
        _button.setBackground((Color) modifier);
    }

    @Override
    public void tripleScoreModifier(Object modifier) {
        super.tripleScoreModifier(modifier);
        _button.setBackground((Color) modifier);
    }

    public void setAction(Action action) {
        _button.setAction(action);
    }

    public Action getAction() {
        return _button.getAction();
    }
}
