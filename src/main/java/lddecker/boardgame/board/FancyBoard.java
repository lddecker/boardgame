package lddecker.boardgame.board;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class FancyBoard implements WordGame {
    private final JPanel _gui = new JPanel(new BorderLayout(3, 3));
    private final Color _backgroundColour = Color.LIGHT_GRAY;
    private final int _cellsInBoard = 15;
    private final Color _defaultCellBackground = Color.WHITE;
    private final Color _borderColour = Color.BLACK;
    private final int _minimumSize = 400;
    private JTextArea _wordInput = new JTextArea("");
    private JButton[][] _board = new JButton[HEIGHT][WIDTH];
    private JPanel _gameBoard;
    private final JLabel _message = new JLabel("Make your move!");
    private static final String COLUMN_LABELS = "ABCDEFGHIJKLMOP";
    private final Insets _buttonMargin = new Insets(0, 0, 0, 0);
    private final JComboBox _directionBox = new JComboBox<>(Direction.values());

    public FancyBoard() {
        initializeGui();
    }

    private void initializeGui() {
        // set up the main GUI
        _gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        _gui.add(tools, BorderLayout.PAGE_START);
        Action newGameAction = new AbstractAction("New") {

            @Override
            public void actionPerformed(ActionEvent e) {
                _message.setText("Make your move!");
                resetBoard();
            }
        };

        tools.add(newGameAction);
        tools.addSeparator();
        tools.add(_wordInput);
        tools.addSeparator();
        tools.add(_directionBox);
        tools.addSeparator();
        tools.add(_message);


        _gui.add(new JLabel("?"), BorderLayout.LINE_START);

        _gameBoard = new JPanel(new GridLayout(0, _cellsInBoard + 1)) {

            /**
             * Override the preferred size to return the largest it can, in
             * a square shape.  Must (must, must) be added to a GridBagLayout
             * as the only component (it uses the parent as a guide to size)
             * with no GridBagConstraint (so it is centered).
             */
            @Override
            public final Dimension getPreferredSize() {
                Dimension dimension = new Dimension(_minimumSize, _minimumSize);
                Dimension prefSize;
                Component component = getParent();
                if (component == null) {
                    prefSize = new Dimension((int) dimension.getWidth(), (int) dimension.getHeight());
                } else if (component.getWidth() > dimension.getWidth() && component.getHeight() > dimension.getHeight()) {
                    prefSize = component.getSize();
                } else {
                    prefSize = dimension;
                }
                int width = (int) prefSize.getWidth();
                int height = (int) prefSize.getHeight();
                int smallerSize = (width > height ? height : width);
                return new Dimension(smallerSize, smallerSize);
            }
        };
        _gameBoard.setBorder(new CompoundBorder(
                new EmptyBorder(8, 8, 8, 8),
                new LineBorder(_borderColour)
        ));

        _gameBoard.setBackground(_backgroundColour);
        JPanel boardConstraint = new JPanel(new GridBagLayout());
        boardConstraint.setBackground(_backgroundColour);
        boardConstraint.add(_gameBoard);
        _gui.add(boardConstraint);

        createBoardSquares();
    }

    private void createBoardSquares() {
        for (int i = 0; i < _board.length; i++) {
            for (int j = 0; j < _board[i].length; j++) {
                if (_board[j][i] != null) {
                    _board[j][i].removeAll();
                }
                JButton button = new JButton();
                button.setMargin(_buttonMargin);
                button.setBackground(_defaultCellBackground);
                button.setText("");
                final int finalI = i;
                final int finalJ = j;
                button.setAction(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String inputWord = _wordInput.getText();
                        _wordInput.setText("");
                        Direction selectedDirection = (Direction) _directionBox.getSelectedItem();
                        try {
                            playWord(inputWord, finalJ, finalI, selectedDirection);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        System.out.println(inputWord);
                    }
                });
                _board[j][i] = button;
            }
        }

        _gameBoard.add(new JLabel(""));
        // fill the top label
        for (int i = 0; i < _cellsInBoard; i++) {
            _gameBoard.add(new JLabel(COLUMN_LABELS.substring(i, i + 1), SwingConstants.CENTER));
        }
        // fill the rest of the rows
        for (int row = 0; row < _cellsInBoard; row++) {
            for (int column = 0; column < _cellsInBoard; column++) {
                switch (column) {
                    case 0:
                        _gameBoard.add(new JLabel("" + (_cellsInBoard - row), SwingConstants.CENTER));
                    default:
                        _gameBoard.add(_board[column][row]);
                }
            }
        }
    }

    public final JComponent getGui() {
        return _gui;
    }

    @Override
    public void playWord(String word, int column, int row, Direction direction) throws Exception {
        word = word.toUpperCase();
        for (char c : word.toCharArray()) {
            try {
                String existingText = _board[column][row].getText();
                if (existingText != null && existingText != "") {
                    throw new Exception("already occupied");
                }
                _board[column][row].setText(Character.toString(c));
            } catch (Exception e) {
                throw e;
            }
            if (Direction.DOWN == direction) {
                row++;
            } else if (Direction.ACROSS == direction) {
                column++;
            } else {
                throw new Exception("Unknown direction: " + direction.name());
            }
        }
    }

    @Override
    public void resetBoard() {
        for (int i = 0; i < _board.length; i++) {
            for (int j = 0; j < _board[i].length; j++) {
                if (_board[j][i] != null) {
                    _board[j][i].setText("");
                }
            }
        }
    }

    @Override
    public int calculateScore() {
        return 0;
    }
}
