package by.epam.javatr.minchuk.task06.controller;

import org.apache.log4j.Logger;

public class Test {
    public static final Logger LOG;
    static {
        LOG = Logger.getRootLogger();
    }

    public static void main(String[] args) {
        LOG.info("info!!!");
        LOG.warn("warn!!!");
        LOG.error("error!!!");
        //LOG.trace("trace!!!");
    }
}
