package org.testtcs.util;


import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class EnviromentVariables {

    public static final EnvironmentVariables ENVIRONMENT_VARIABLES = SystemEnvironmentVariables.createEnvironmentVariables();

    public static String CLAVE = ENVIRONMENT_VARIABLES.getProperty("PASS");
    public static String USUARIO  = ENVIRONMENT_VARIABLES.getProperty("USER");
    public static String TOKEN  = ENVIRONMENT_VARIABLES.getProperty("TOKEN");


}
