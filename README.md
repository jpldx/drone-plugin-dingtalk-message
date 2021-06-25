# 简介

一个 Java 实现的基于 Drone CI 的钉钉群机器人消息通知插件。



# 使用方法

你可以在 Drone CI 的 pipeline 文件里通过如下配置使用它：

```yaml
steps:
  - name: dingtalk
    pull: if-not-exists
    image: jpldx/drone-plugin-dingtalk-message
    settings:
      access_token: ${your_access_token}
    when:
      status:
        - failure
        - success
```

