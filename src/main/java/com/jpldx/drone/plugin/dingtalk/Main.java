package com.jpldx.drone.plugin.dingtalk;

import com.jpldx.drone.plugin.dingtalk.constants.ConfigProperties;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
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
        if (accessToken == null) {
            throw new IllegalArgumentException("access_token not specified");
        }

        try {
            String result = sendRequest(ConfigProperties.WEBHOOK + "?access_token=" + accessToken);
            if (result.contains("\"errcode\":0")) {
                System.out.println("sending success!");
            } else {
                System.out.printf("sending failed: %s", result);
            }
        } catch (IOException e) {
            System.out.printf("sending failed: %s", e.getMessage());
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
        String markdownTpl = readMarkdownTpl();
        return String.format(markdownTpl,
                "新的构建通知",
                ConfigProperties.BUILD_STATUS_SUCCESS.equals(DroneEnv.DRONE_BUILD_STATUS) ?
                        ConfigProperties.SUCCESS_COLOR : ConfigProperties.FAILURE_COLOR,
                DroneEnv.DRONE_REPO,
                DroneEnv.DRONE_REPO_BRANCH,
                DroneEnv.DRONE_COMMIT_AUTHOR,
                DroneEnv.DRONE_BUILD_NUMBER
        );
    }

    private static String readMarkdownTpl() {
        String tpl = "";
        InputStream is = Main.class.getClassLoader().getResourceAsStream("templates/markdown.json");
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
