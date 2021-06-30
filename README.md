# 项目简介

一个 Java 实现的基于 Drone CI 的钉钉群机器人消息通知插件。


# 效果预览
<img src="http://www.jpldx.com:2020/dingtalk-success.png" alt="构建成功" width = "50%" height = "50%" />
<img src="http://www.jpldx.com:2020/dingtalk-failure.png" alt="构建失败" width = "50%" height = "50%" />


# 使用方法
你可以在 [Drone CI](https://www.drone.io/) 的 pipeline 文件里通过如下配置使用它：
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

# 注意
- 暂时只支持钉钉群机器人 `markdown` 消息类型。
- 暂不支持钉钉群机器人安全设置中的 `自定义关键词` 和 `加签` 方式。
- Docker 镜像不够轻量(100M)，后续考虑使用 Go 实现。
- 暂不支持参数自定义，如：通知标题、字体颜色、LOGO等。