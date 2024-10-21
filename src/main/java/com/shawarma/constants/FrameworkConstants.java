package com.shawarma.constants;

public final class FrameworkConstants {
    private FrameworkConstants(){
    }
    private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String NAME = "Shawarma Selenium Java Framework";
    private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
    private static final int EXPLICITWAIT = 10;

    public static String getName() {
        return NAME;
    }
    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }
    public static int getExplicitWait(){
        return EXPLICITWAIT;
    }
}
