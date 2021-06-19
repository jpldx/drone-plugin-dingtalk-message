package com.jpldx.drone.plugin.dingtalk;

/**
 * @author jpldx
 */
public class Main {

    public static void main(String[] args)  {
        System.out.println("Hello Docker ~!");

        String test = System.getenv("TEST");
        System.out.println("ENV TEST: " + test);
    }

//    DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=1ca4981e75a2e938254350b5af4c6401587f636bebb6a9faae9309a1d0849a31");
//    OapiRobotSendRequest request = new OapiRobotSendRequest();
//        request.setMsgtype("text");
//    OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
//        text.setContent("测试文本消息");
//        request.setText(text);
//    OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
//        at.setAtMobiles(Arrays.asList("132xxxxxxxx"));
//    // isAtAll类型如果不为Boolean，请升级至最新SDK
//        at.setIsAtAll(true);
//        at.setAtUserIds(Arrays.asList("109929","32099"));
//        request.setAt(at);
//
//        request.setMsgtype("link");
//    OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
//        link.setMessageUrl("https://www.dingtalk.com/");
//        link.setPicUrl("");
//        link.setTitle("时代的火车向前开");
//        link.setText("这个即将发布的新版本，创始人xx称它为红树林。而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是红树林");
//        request.setLink(link);
//
//        request.setMsgtype("markdown");
//    OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
//        markdown.setTitle("杭州天气test");
//        markdown.setText("#### 杭州天气 @156xxxx8827\n" +
//                "> 9度，西北风1级，空气良89，相对温度73%\n\n" +
//                "> ![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png)\n"  +
//                "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n");
//        request.setMarkdown(markdown);
//    OapiRobotSendResponse response = client.execute(request);
}
