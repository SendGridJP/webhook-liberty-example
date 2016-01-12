# webhook-liberty-example

SendGrid��Webhook��M�A�v���P�[�V�����̃T���v���R�[�h�ł��B
Event Webhook�����Parse Webhook�ɑΉ����Ă��܂��B
[liberty](https://github.com/cloudfoundry/ibm-websphere-liberty-buildpack)��œ��삵�܂��B

# �O�����
- liberty

# �N�����@
```
$ git clone https://github.com/SendGridJP/webhook-liberty-example
[�Q�l](http://qiita.com/asmanabu/items/a95dec97aabddd69acd8)�ɏ]����Web�A�v���P�[�V������Bluemix��ɔz�u���܂��B
```

# SendGrid�̐ݒ�
## Event Webhook
1. Web�|�[�^����[SETTINGS > Mail Settings > Event Notification](https://app.sendgrid.com/settings/mail_settings)���J���܂��B
1. HTTP POST URL��ݒ肵�܂��B  
http://%Web�A�v���P�[�V�����̃z�X�g��%/EventReceiver
1. SELECT ACTIONS�Ŏ�M�������C�x���g�̃`�F�b�N��ON�ɂ��܂��B
1. �uTest Your Integration�v�{�^����I�����ăC�x���g��Web�A�v���P�[�V������POST����邱�Ƃ��m�F���܂��B
1. SendGrid�o�R��[���M](https://sendgrid.com/docs/API_Reference/Web_API/mail.html)�������[���̊e�C�x���g���A�v���P�[�V������POST����邱�Ƃ��m�F���܂��B

## Parse Webhook
1. Web�|�[�^����[SETTINGS > Inbound Parse](https://app.sendgrid.com/settings/parse)���J���܂��B
1. �uAdd Host & URL�v�{�^����I�����Ċe�ݒ���s���܂��B[�Q�l](https://sendgrid.kke.co.jp/blog/?p=827)
  1. HOSTNAME�F���[���̈���h���C���B
  1. URL�Fhttp://%Web�A�v���P�[�V�����̃z�X�g��%/ParseReceiver
  1. SPAM CHECK�FOFF
  1. SEND RAW�FOFF
1. �uSave�v�{�^����I�����ĕۑ����܂��B
1. HOSTNAME�ɐݒ肵���h���C���̔C�ӂ̃��[���A�h���X���Ƀ��[���𑗐M���āA��M�������[���̓��e��Web�A�v���P�[�V������POST����邱�Ƃ��m�F���܂��B
