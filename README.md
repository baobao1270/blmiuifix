# BL/MI Fix
BiliBili Play 4.2.x navbar fix on MIUI 12

修复 BlilBili Legacy (4.2.x) Play 版在 MIUI 12 上，如果未启用全面屏，就会使导航栏遮挡播放器 UI 的问题。

这是一个 Xposed 模块，依赖 Xposed 运行。

<b style="color: red">使用前请务必阅读使用说明！</b>

以下说明，港版指的都是 Google Play 版。

## 截图

|修复前|修复后|
|:----:|:----:|
|<img alt="修复前" src="https://image-host-1251131545.file.myqcloud.com/by-uuid/dd0ed211-9b26-4989-9cfa-ffef1ac2305b.jpg">|<img alt="修复后" src="https://image-host-1251131545.file.myqcloud.com/by-uuid/40205d5a-211e-4108-a6fd-dde1ee96b826.jpg">|

## 机型适配
 - 目前仅测试过 Redmi K30 Pro
 - 仅支持 MIUI 12，且仅在 MIUI 12.5 开发版上测试过。其他版本可能有问题。
 - 关于 B 站版本：仅支持港版 B 站，版本为 `2.4.0` 或 `2.4.2`。

[旧版 B 站可以在此处下载](https://apkpure.com/cn/bilibili-%E9%AB%98%E7%95%AB%E8%B3%AA%E7%84%A1%E5%BB%A3%E5%91%8A%E8%BF%BD%E6%98%9F%E5%8B%95%E6%BC%AB%E9%83%BD%E5%9C%A8%E9%80%99/com.bilibili.app.in/versions)

## 安装与使用说明
使用前请下载并安装 Xposed 或其衍生品。个人推荐 [LSPosed](https://github.com/LSPosed/LSPosed)。此处恕不详述其安装方式，请自行搜索。

<b style="color: red">自己仔细阅读 LSPosed 的安装说明。出了问题不要找本 App 作者。</b>

**下载方式**

[GitHub Release](https://github.com/baobao1270/blmiuifix/releases)

如果 GitHub 访问不畅，可使用 [备用下载链接](https://image-host-1251131545.file.myqcloud.com/by-uuid/bee18779-be58-4c8b-b32f-47dfbab16295.apk)。

**安装**

下载完并安装好 Xposed/LSPosed 后，**重启手机**。安装本 App，然后在 Xposed/LSPosed 中启用本模块。

<b style="color: red">如果您使用 LSPosed，还需要在“启用的应用”中勾选哔哩哔哩。其名称是“bilibili”，包名为 <code>com.bilibili.app.in</code>，注意与大陆版不同。</b>

## 已知问题
在退出全屏后，需要对 UI 有任意一个操作，三大金刚才会显示出来。

## 免责声明
<b style="color: red">使用本 App 可能造成手机卡顿、无法启动，或导致您的 B 站账号被封禁，以及可能无法预期的故障和问题。您已了解这些风险。作者将不会为您使用本 App 导致的任何不利后果负责。</b>

本 App 不会长期维护，可能也不会修 bug，够用就行。

## 构建
Git Clone 后使用 Android Studio 4.1 以上版本打开即可。

打包所需的密钥使用 GitHub Secret 管理，在 Settings -> Environments 处可以设置。

签名名称请填写 `Luo Tianyi`。

## 版权
WTFPL
