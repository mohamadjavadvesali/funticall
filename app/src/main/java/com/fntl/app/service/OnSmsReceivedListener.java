package com.fntl.app.service;

import android.widget.EditText;

public interface OnSmsReceivedListener {
    void onSmsReceiver(String message, String phone, EditText editText);
}
