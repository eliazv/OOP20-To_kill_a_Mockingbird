package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controllers.GameControllerImpl;
import model.enemy.Vehicle;
import model.enemy.VehicleImpl;
import model.map.Box;
import model.score.Coin;

/**
 * 
 *
 */
public class GameView implements KeyListener, View {

    /**
     * constants.
     */
    private static final int SIZE = 800;

    /**
     * local variables.
     */
    private JFrame frame;
    private PanelGame panelGame;
    private final GameView gv = this;

    /**
     * Create the whole frame.
     */
    @Override
    public void setup() {

        this.panelGame = new PanelGame();
        this.frame = new JFrame();
        this.frame.addKeyListener(this);
        this.frame.getContentPane().add(panelGame);
        this.frame.setTitle("Mockingbird");
        this.frame.setSize(SIZE, SIZE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setVisible(true);

    }

    public class PanelGame extends JPanel implements ActionListener {

        private static final long serialVersionUID = 1L;

        /**
         * constants.
         */
        private static final int NSTRIP_TO_GENERATE = 11;
        private static final int BOXFORSTRIP = 8;
        private static final int TIMER_DELAY = 10;
        private static final int FONT_SIZE = 40;

        /**
         * local variables.
         */
        private final Rectangle rlblCoinCounter;
        private final JLabel lblCoinCounter = new JLabel();
        private final ArrayList<ArrayList<Box>> allStrip = new ArrayList<ArrayList<Box>>();
        private final ArrayList<Vehicle> vehiclesOnRoad = new ArrayList<>();
        private final ArrayList<Vehicle> trains = new ArrayList<>();
        private final Vehicle vehicleManager = new VehicleImpl();
        private final ArrayList<Coin> coins = new ArrayList<>();
        private final Timer timer;
        private final GameControllerImpl gameController;

        public PanelGame() {

            gameController = new GameControllerImpl(gv);

            gameController.setup();

            this.timer = new Timer(TIMER_DELAY, this);

            gameController.SetInitialPosition(allStrip);

            this.repaint();

            this.add(lblCoinCounter);
            lblCoinCounter.setText("Score: 0");
            lblCoinCounter.setForeground(Color.white);
            lblCoinCounter.setFont(new Font("Helvetica", Font.ITALIC, FONT_SIZE));
            rlblCoinCounter = new Rectangle(10, 10, 30, 30);
            lblCoinCounter.setBounds(rlblCoinCounter);

            this.timer.start();
        }

        /**
         * @param g
         * 
         */
        public void paintComponent(final Graphics g) {

            /**
             * Erases the previous screen.
             */
            super.paintComponent(g);

            /**
             * Draws strips.
             */
            for (int i = 0; i < NSTRIP_TO_GENERATE; i++) {
                for (int x = 0; x < BOXFORSTRIP; x++) {
                    this.allStrip.get(i).get(x).paint(g, this);

                }
            }

            /**
             * Draws vehicles.
             */
            this.coins.forEach(v -> v.paint(g, this));
            this.vehiclesOnRoad.forEach(v -> v.paint(g, this));
            this.trains.forEach(v -> v.paint(g, this));

            gameController.getPlayer().paint(g, this);
            lblCoinCounter.setText("Score: " + gameController.getScore());
        }

        /**
         * @param e Repaints all elements and calls gameController to perform a game
         *          cycle
         */
        @Override
        public void actionPerformed(final ActionEvent e) {

            this.repaint();
            gameController.generateMap(allStrip, vehiclesOnRoad, trains, coins);
            gameController.actionPerformed(this.allStrip, this.vehicleManager, this.vehiclesOnRoad, this.coins,
                    this.trains);
        }

        /**
         * @return gameController
         */
        private GameControllerImpl getGameController() {
            return gameController;
        }
    }

    /**
     * @param e
     * 
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        panelGame.getGameController().keyCatch(e);
    }

    @Override
    public void keyReleased(final KeyEvent arg0) {
    }

    @Override
    public void keyTyped(final KeyEvent arg0) {
    }

    /**
     * 
     */
    @Override
    public void exit() {
        this.frame.dispose();
    }

}
