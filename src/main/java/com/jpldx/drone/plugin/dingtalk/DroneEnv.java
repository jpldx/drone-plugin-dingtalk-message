package com.jpldx.drone.plugin.dingtalk;

import com.jpldx.drone.plugin.dingtalk.constants.ConfigProperties;

/**
 * Drone environment variables
 *
 * @author chenxudong
 */
public final class DroneEnv {

    public static final String DRONE_BUILD_STATUS;
    public static final String DRONE_REPO;
    public static final String DRONE_REPO_BRANCH;
    public static final String DRONE_COMMIT_AUTHOR;
    public static final String DRONE_BUILD_NUMBER;

    // init
    static {
        DRONE_BUILD_STATUS = System.getenv(ConfigProperties.DRONE_BUILD_STATUS);
        DRONE_REPO = System.getenv(ConfigProperties.DRONE_REPO);
        DRONE_REPO_BRANCH = System.getenv(ConfigProperties.DRONE_REPO_BRANCH);
        DRONE_COMMIT_AUTHOR = System.getenv(ConfigProperties.DRONE_COMMIT_AUTHOR);
        DRONE_BUILD_NUMBER = System.getenv(ConfigProperties.DRONE_BUILD_NUMBER);
    }
}
