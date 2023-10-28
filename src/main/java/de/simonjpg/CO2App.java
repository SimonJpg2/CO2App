package de.simonjpg;

import de.simonjpg.Backend.Backend;
import de.simonjpg.Backend.Database.Entities.CO2Entity;
import de.simonjpg.Backend.Database.Services.CO2Service;
import de.simonjpg.Backend.Exceptions.InsertStatementFailedException;
import de.simonjpg.Backend.Exceptions.SelectStatementFailedException;
import de.simonjpg.Backend.Extractor.ExtractCO2Data;
import de.simonjpg.Frontend.Frontend;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class CO2App {
    private static final Logger LOGGER = LogManager.getLogger(CO2App.class);
    @SuppressWarnings("unused")
    private static final String banner1 = "    ____________                                      \n" +
            "   /   ______   \\                                    \n" +
            "  /   /      \\___\\                                  \n" +
            " /   /                                                         \n" +
            "/   /                                                          \n" +
            "\\   \\                                                  ___________\n" +
            " \\   \\                                                |________   |\n" +
            "  \\   \\_______      (__)                                       |  |\n" +
            "   \\_______   \\                                                |  |\n" +
            "           \\   \\     __                                        |  |   _______     _______\n" +
            "            \\   \\   |  |   _____________     ____    _______   |  |  /       \\   /       \\\n" +
            "             \\   \\  |  |  /  __ __ __   \\   /    \\  |/   _  \\  |  | /         \\ /         \\\n" +
            "             /   /  |  | |  /  \\  /  \\  |  /      \\ |/  / \\  \\ |  | |   (__)  ||   (__)   |\n" +
            " ___        /   /   |  | |  |  |  |  |  | |  (__)  ||  |  |  | |  | |         / \\         |\n" +
            " \\  \\______/   /    |  | |  |  |  |  |  |  \\      / |  |  |  | |  | |   _____/   \\_____   |\n" +
            "  \\___________/     |__| |__|  |__|  |__|   \\____/  |__|  |__| |  | |  |               |  |\n" +
            "                                                               /  / |  |               |  |\n" +
            "                                                        ______/  /  |  |         ______/  /      \n" +
            "                                                       |________/   |__|        |________/ \n" +
            "                                                                                ";

    @SuppressWarnings("unused")
    private static final String banner2 = " " +
            "  _____ _                            _             \n" +
            "  / ____(_)                          | |            \n" +
            " | (___  _ _ __ ___   ___  _ __      | |_ __   __ _ \n" +
            "  \\___ \\| | '_ ` _ \\ / _ \\| '_ \\ _   | | '_ \\ / _` |\n" +
            "  ____) | | | | | | | (_) | | | | |__| | |_) | (_| |\n" +
            " |_____/|_|_| |_| |_|\\___/|_| |_|\\____/| .__/ \\__, |\n" +
            "                                       | |     __/ |\n" +
            "                                       |_|    |___/ ";

    @SuppressWarnings("unused")
    private static final String banner3 = " ________  ___  _____ ______   ________  ________         ___  ________  ________     \n" +
            "|\\   ____\\|\\  \\|\\   _ \\  _   \\|\\   __  \\|\\   ___  \\      |\\  \\|\\   __  \\|\\   ____\\    \n" +
            "\\ \\  \\___|\\ \\  \\ \\  \\\\\\__\\ \\  \\ \\  \\|\\  \\ \\  \\\\ \\  \\     \\ \\  \\ \\  \\|\\  \\ \\  \\___|    \n" +
            " \\ \\_____  \\ \\  \\ \\  \\\\|__| \\  \\ \\  \\\\\\  \\ \\  \\\\ \\  \\  __ \\ \\  \\ \\   ____\\ \\  \\  ___  \n" +
            "  \\|____|\\  \\ \\  \\ \\  \\    \\ \\  \\ \\  \\\\\\  \\ \\  \\\\ \\  \\|\\  \\\\_\\  \\ \\  \\___|\\ \\  \\|\\  \\ \n" +
            "    ____\\_\\  \\ \\__\\ \\__\\    \\ \\__\\ \\_______\\ \\__\\\\ \\__\\ \\________\\ \\__\\    \\ \\_______\\\n" +
            "   |\\_________\\|__|\\|__|     \\|__|\\|_______|\\|__| \\|__|\\|________|\\|__|     \\|_______|\n" +
            "   \\|_________|                                                                       \n" +
            "                                                                                      \n" +
            "                                                                                      ";

    @SuppressWarnings("unused")
    private static final String banner4 = "                                     \n" +
            " _____ _                  __         \n" +
            "|   __|_|_____ ___ ___ __|  |___ ___ \n" +
            "|__   | |     | . |   |  |  | . | . |\n" +
            "|_____|_|_|_|_|___|_|_|_____|  _|_  |\n" +
            "                            |_| |___|\n" +
            "\n";

    @SuppressWarnings("unused")
    private static final String banner5 = "   _____                             __           \n" +
            "  / ___/(_)___ ___  ____  ____      / /___  ____ _\n" +
            "  \\__ \\/ / __ `__ \\/ __ \\/ __ \\__  / / __ \\/ __ `/\n" +
            " ___/ / / / / / / / /_/ / / / / /_/ / /_/ / /_/ / \n" +
            "/____/_/_/ /_/ /_/\\____/_/ /_/\\____/ .___/\\__, /  \n" +
            "                                  /_/    /____/   \n" +
            "\n";

    @SuppressWarnings("unused")
    private static final String banner6 = "____________                        _________                \n" +
            "__  ___/__(_)______ ______________________  /______________ _\n" +
            "_____ \\__  /__  __ `__ \\  __ \\_  __ \\__ _  /___  __ \\_  __ `/\n" +
            "____/ /_  / _  / / / / / /_/ /  / / / /_/ / __  /_/ /  /_/ / \n" +
            "/____/ /_/  /_/ /_/ /_/\\____//_/ /_/\\____/  _  .___/_\\__, /  \n" +
            "                                            /_/     /____/   \n" +
            "\n";

    @SuppressWarnings("unused")
    private static final String banner7 = " ______     __     __    __     ______     __   __       __     ______   ______    \n" +
            "/\\  ___\\   /\\ \\   /\\ \"-./  \\   /\\  __ \\   /\\ \"-.\\ \\     /\\ \\   /\\  == \\ /\\  ___\\   \n" +
            "\\ \\___  \\  \\ \\ \\  \\ \\ \\-./\\ \\  \\ \\ \\/\\ \\  \\ \\ \\-.  \\   _\\_\\ \\  \\ \\  _-/ \\ \\ \\__ \\  \n" +
            " \\/\\_____\\  \\ \\_\\  \\ \\_\\ \\ \\_\\  \\ \\_____\\  \\ \\_\\\\\"\\_\\ /\\_____\\  \\ \\_\\    \\ \\_____\\ \n" +
            "  \\/_____/   \\/_/   \\/_/  \\/_/   \\/_____/   \\/_/ \\/_/ \\/_____/   \\/_/     \\/_____/ \n" +
            "                                                                                   ";

    public static void main(String[] args) {
        System.out.println(banner5);
        LOGGER.info("Starting Application CO2 App");

        // Init backend and frontend
        Backend backend = Backend.instance();
        Frontend frontend = Frontend.instance();
        frontend.start();

        // Insert Co² data of excel sheet into database.
        //TODO: Insert extracted data into database and create JUnit5 tests
        CO2Service service = CO2Service.instance(backend.getConnection());
        List<Double> extractedData = new ExtractCO2Data().extractData("1990.0");

        try {
            if (service.select().isEmpty()) {
                insert(1990, extractedData, service);
            } else {
                LOGGER.info("Skipping insertion, data already in database.");
            }
        } catch (SelectStatementFailedException e) {
            LOGGER.error("Selection from database failed.\n{}", e.getMessage());
        }
        extractedData.forEach(System.out::println);
    }

    private static void insert(int year, List<Double> data, CO2Service service) {
        try {
            for (Double value : data) {
                service.create(new CO2Entity(year, value));
                LOGGER.info("Inserted CO2 data of year {} successfully.", year);
            }
        } catch (InsertStatementFailedException e) {
            LOGGER.error("Insertion to database failed.\n{}", e.getMessage());
        }
    }
}
