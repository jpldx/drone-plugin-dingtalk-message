package com.jpldx.drone.plugin.dingtalk;

import com.jpldx.drone.plugin.dingtalk.constants.ConfigProperties;
import com.jpldx.drone.plugin.dingtalk.utils.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Application
 *
 * @author jpldx
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("start sending...");

        String accessToken = System.getenv(ConfigProperties.ENV_ACCESS_TOKEN);
        if (StringUtils.isBlank(accessToken)) {
            System.out.println("\"access_token\" not specified");
            System.exit(1);
        }

        try {
            String result = sendRequest(ConfigProperties.WEBHOOK + "?access_token=" + accessToken);
            if (result.contains("\"errcode\":0")) {
                System.out.println("sending success!");
            } else {
                System.out.printf("sending failed: %s", result);
                System.exit(1);
            }
        } catch (IOException e) {
            System.out.printf("sending failed: %s", e.getMessage());
            System.exit(1);
        }
    }

    private static String sendRequest(String url) throws IOException {
        String result = "";
        HttpPost post = new HttpPost(url);

        // Send a JSON data
        post.setEntity(new StringEntity((markdownJson()), StandardCharsets.UTF_8));
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {
            result = EntityUtils.toString(response.getEntity());
        }
        return result;
    }

    private static String markdownJson() {
        // build status: success / failure
        boolean isSuccess = ConfigProperties.BUILD_STATUS_SUCCESS.equals(DroneEnv.DRONE_BUILD_STATUS);
        String markdownTpl = readMarkdownTemplate(isSuccess ?
                "templates/markdown_success.json" :
                "templates/markdown_failure.json");

        String[] params = isSuccess ?
            new String[]{
                ConfigProperties.MSG_TITLE,
                DroneEnv.DRONE_REPO,
                DroneEnv.DRONE_REPO_BRANCH,
                DroneEnv.DRONE_COMMIT_AUTHOR,
                DroneEnv.DRONE_BUILD_NUMBER,
                DroneEnv.DRONE_COMMIT_LINK,
                DroneEnv.DRONE_COMMIT_MESSAGE} :
            new String[]{
                ConfigProperties.MSG_TITLE,
                DroneEnv.DRONE_REPO,
                DroneEnv.DRONE_REPO_BRANCH,
                DroneEnv.DRONE_COMMIT_AUTHOR,
                DroneEnv.DRONE_BUILD_NUMBER,
                DroneEnv.DRONE_COMMIT_LINK,
                DroneEnv.DRONE_COMMIT_MESSAGE,
                DroneEnv.DRONE_FAILED_STEPS
        };
        return String.format(markdownTpl, params);
    }

    private static String readMarkdownTemplate(String filepath) {
        String tpl = "";
        InputStream is = Main.class.getClassLoader().getResourceAsStream(filepath);
        if(is != null){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try{
                byte[] buffer = new byte[1024];
                int len;
                while((len = is.read(buffer)) > 0){
                    baos.write(buffer,0,len);
                }
            }catch(IOException e){
                System.out.printf("read markdown template failed: %s",e.getMessage());
            }finally {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            tpl = baos.toString();
        }
        return tpl;
    }
}
