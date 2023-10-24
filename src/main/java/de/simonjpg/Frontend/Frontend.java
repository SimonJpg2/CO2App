package de.simonjpg.Frontend;

import de.simonjpg.Frontend.UI.DataFrame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//TODO: Add Javadoc
public class Frontend extends Thread {
    private static Frontend frontend;
    private static final Logger LOGGER = LogManager.getLogger(Frontend.class);
    public Frontend() {

    }

    @Override
    public void run() {
        LOGGER.info("Initializing Frontend");
        new DataFrame().setVisible(true);
    }

    public static Frontend instance() {
        if (frontend == null) {
            frontend = new Frontend();
        }
        return frontend;
    }
}
