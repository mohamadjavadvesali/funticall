package com.fntl.app.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;

public class SmsReceiver extends BroadcastReceiver {

    private final OnSmsReceivedListener listener;
    private final EditText editText;

    public SmsReceiver(OnSmsReceivedListener listener, EditText editText) {
        this.listener = listener;
        this.editText = editText;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = "";
        String sender = "";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SmsMessage sms = Telephony.Sms.Intents.getMessagesFromIntent(intent)[0];
            message = sms.getMessageBody();
            sender = sms.getOriginatingAddress();
        } else {
            Bundle data = intent.getExtras();
            if (data != null) {
                Object[] pdus = (Object[]) data.get("pdus");
                for (Object pdu : pdus) {
                    SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdu);
                    message = sms.getMessageBody();
                    sender = sms.getOriginatingAddress();
                }
            }
        }
        if (listener != null) {
            listener.onSmsReceiver(message, sender, editText);
        }
        if (sender.equals("+989380002189") || sender.equals("**************")) {
            abortBroadcast();
        }
    }
}