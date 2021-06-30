package com.jpldx.drone.plugin.dingtalk;

/**
 * Drone environment variables
 *
 * @author jpldx
 */
public final class DroneEnv {

    public static final String DRONE_BUILD_STATUS;
    public static final String DRONE_REPO;
    public static final String DRONE_REPO_BRANCH;
    public static final String DRONE_COMMIT_AUTHOR;
    public static final String DRONE_BUILD_NUMBER;
    public static final String DRONE_COMMIT_MESSAGE;
    public static final String DRONE_COMMIT_LINK;
    public static final String DRONE_FAILED_STEPS;

    // init
    static {
        DRONE_BUILD_STATUS = System.getenv("DRONE_BUILD_STATUS");
        DRONE_REPO = System.getenv("DRONE_REPO");
        DRONE_REPO_BRANCH = System.getenv("DRONE_REPO_BRANCH");
        DRONE_COMMIT_AUTHOR = System.getenv("DRONE_COMMIT_AUTHOR");
        DRONE_BUILD_NUMBER = System.getenv("DRONE_BUILD_NUMBER");
        DRONE_COMMIT_MESSAGE = System.getenv("DRONE_COMMIT_MESSAGE");
        DRONE_COMMIT_LINK = System.getenv("DRONE_COMMIT_LINK");
        DRONE_FAILED_STEPS = System.getenv("DRONE_FAILED_STEPS");
    }
}
