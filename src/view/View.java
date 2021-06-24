package view;


/**
 * An interface that represent a generic View.
 *
 */
public interface View {

    /**
     * Setup the view, making it ready to work.
     */
	void setup();
	
    /**
     * Exits the view and closes it.
     */
	void exit();
}
