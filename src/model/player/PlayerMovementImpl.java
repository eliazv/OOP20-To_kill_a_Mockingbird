package model.player;


public class PlayerMovementImpl extends PlayerImpl implements PlayerMovement {

    private static final double X_MOVE = 100;
    private static final double Y_MOVE = 100.2;

    public PlayerMovementImpl(final String filename, final double xPos, final double yPos) {

        super(filename, xPos, yPos);
    }

    /**
     * move character one box up.
     */
    private void goUp() {

        this.setYLoc(this.getYLoc() - Y_MOVE);
    }

    /**
     * move character one box down.
     */
    private void goDown() {

        this.setYLoc(this.getYLoc() + Y_MOVE);
    }

    /**
     * move character one Box left.
     */
    private void goLeft() {

        this.setXLoc(this.getXLoc() - X_MOVE);
    }

    /**
     * move character one Box right.
     */
    private void goRight() {

        this.setXLoc(this.getXLoc() + X_MOVE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveDirection(final Directions direction) {

        switch (direction) {
            case UP:
                this.goUp();
                break;

            case DOWN:
                this.goDown();
                break;

            case RIGHT:
                this.goRight();
                break;

            case LEFT:
                this.goLeft();
                break;

            default:
                break;
        }
    }
}
