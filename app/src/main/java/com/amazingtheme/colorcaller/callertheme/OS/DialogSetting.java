package com.amazingtheme.colorcaller.callertheme.OS;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.amazingtheme.colorcaller.R;

public class DialogSetting extends Dialog {
    public DialogSetting(Context context) {
        super(context);
        requestWindowFeature(1);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawableResource(17170445);
        }
    }

    @Override 
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_setting);
    }
}
