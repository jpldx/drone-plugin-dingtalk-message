package com.jpldx.drone.plugin.dingtalk.constants;

/**
 * Configuration properties
 *
 * @author jpldx
 */
public interface ConfigProperties {

    // ------ DingTalk ------
    /**
     * DingTalk webhook
     */
    String WEBHOOK = "https://oapi.dingtalk.com/robot/send";
    /**
     * DingTalk webhook request success code
     */
    Integer SUCCESS_CODE = 0;
    /**
     * DingTalk robot message type
     */
    String MSG_TYPE_TEXT = "text";
    String MSG_TYPE_MARKDOWN = "markdown";
    String MSG_TITLE = "新的构建通知";

    // ------ Drone CI ------
    /**
     * Drone build status
     */
    String BUILD_STATUS_SUCCESS = "success";
    String BUILD_STATUS_FAILURE = "failure";
    /**
     * DingTalk robot access token
     */
    String ENV_ACCESS_TOKEN = "PLUGIN_ACCESS_TOKEN";
    /**
     * DingTalk robot message type
     */
    String ENV_MSG_TYPE = "PLUGIN_MSG_TYPE";

}
