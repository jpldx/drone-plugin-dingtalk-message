package com.jpldx.drone.plugin.dingtalk.constants;

/**
 * Configuration properties
 *
 * @author jpldx
 */
public interface ConfigProperties {

    /**
     * DingTalk webhook url
     */
    String WEBHOOK = "https://oapi.dingtalk.com/robot/send";

    /**
     * DingTalk webhook request success code
     */
    Integer SUCCESS = 0;

    String BUILD_STATUS_SUCCESS = "success";
    String BUILD_STATUS_FAILURE = "failure";

    /**
     * DingTalk robot message type
     */
    String MSG_TYPE_TEXT = "text";
    String MSG_TYPE_MARKDOWN = "markdown";

    /**
     * Drone plugin container environment variables prefix
     */
    String DRONE_PLUGIN_ENV_PREFIX = "PLUGIN_";

    /**
     * DingTalk robot access token
     */
    String ENV_ACCESS_TOKEN = "PLUGIN_ACCESS_TOKEN";
    /**
     * DingTalk robot message type
     */
    String ENV_MSG_TYPE = "PLUGIN_MSG_TYPE";


    String DRONE_BUILD_STATUS = "DRONE_BUILD_STATUS";
    String DRONE_REPO = "DRONE_REPO";
    String DRONE_REPO_BRANCH = "DRONE_REPO_BRANCH";
    String DRONE_COMMIT_AUTHOR = "DRONE_COMMIT_AUTHOR";
    String DRONE_BUILD_NUMBER = "DRONE_BUILD_NUMBER";

    String SUCCESS_COLOR = "#008000";
    String FAILURE_COLOR = "#FF0000";

}
