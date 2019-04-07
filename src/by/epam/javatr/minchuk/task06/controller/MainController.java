package by.epam.javatr.minchuk.task06.controller;

import by.epam.javatr.minchuk.task06.util.ValidatorSAXXSD;
import org.apache.log4j.Logger;

public class MainController {
    public static final Logger LOGGER;
    static {
        LOGGER = Logger.getRootLogger();
    }

    public static void main(String[] args) {
        LOGGER.trace("start program ");
       // ValidatorXSD.validateScheme();
        ValidatorSAXXSD.validateScheme();
        LOGGER.trace("finish program ");
    }
}
