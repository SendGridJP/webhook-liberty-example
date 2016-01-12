# webhook-liberty-example

SendGridのWebhook受信アプリケーションのサンプルコードです。
Event WebhookおよびParse Webhookに対応しています。
[liberty](https://github.com/cloudfoundry/ibm-websphere-liberty-buildpack)上で動作します。

# 前提条件
- liberty

# 起動方法
```
$ git clone https://github.com/SendGridJP/webhook-liberty-example
[参考](http://qiita.com/asmanabu/items/a95dec97aabddd69acd8)に従ってWebアプリケーションをBluemix上に配置します。
```

# SendGridの設定
## Event Webhook
1. Webポータルで[SETTINGS > Mail Settings > Event Notification](https://app.sendgrid.com/settings/mail_settings)を開きます。
1. HTTP POST URLを設定します。  
http://%Webアプリケーションのホスト名%/EventReceiver
1. SELECT ACTIONSで受信したいイベントのチェックをONにします。
1. 「Test Your Integration」ボタンを選択してイベントがWebアプリケーションにPOSTされることを確認します。
1. SendGrid経由で[送信](https://sendgrid.com/docs/API_Reference/Web_API/mail.html)したメールの各イベントがアプリケーションにPOSTされることを確認します。

## Parse Webhook
1. Webポータルで[SETTINGS > Inbound Parse](https://app.sendgrid.com/settings/parse)を開きます。
1. 「Add Host & URL」ボタンを選択して各設定を行います。[参考](https://sendgrid.kke.co.jp/blog/?p=827)
  1. HOSTNAME：メールの宛先ドメイン。
  1. URL：http://%Webアプリケーションのホスト名%/ParseReceiver
  1. SPAM CHECK：OFF
  1. SEND RAW：OFF
1. 「Save」ボタンを選択して保存します。
1. HOSTNAMEに設定したドメインの任意のメールアドレス宛にメールを送信して、受信したメールの内容がWebアプリケーションにPOSTされることを確認します。
