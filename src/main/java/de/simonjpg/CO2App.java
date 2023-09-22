package de.simonjpg;

import de.simonjpg.Backend.Backend;

import java.net.MalformedURLException;

public class CO2App {
    private static final String banner = "    ____________                                      \n" +
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


    public static void main(String[] args) throws MalformedURLException {
        System.out.println(banner);
        System.out.println("INFO: Starting Application: CO2 App.\n");
        new Backend().crawlData();
    }
}
