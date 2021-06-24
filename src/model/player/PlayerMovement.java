package model.player;


public interface PlayerMovement extends Player {

    /**
     * move character in any direction.
     * @param direction
     */
    void moveDirection(Directions direction);

}
