package com.ua.cs495f2018.berthaIRT.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.ua.cs495f2018.berthaIRT.Interface;
import com.ua.cs495f2018.berthaIRT.R;

import java.util.Objects;

public class YesNoDialog extends AlertDialog{

    private String title;
    private String text;
    private Interface.YesNoHandler handler;

    public YesNoDialog(Context ctx, String title, String text, Interface.YesNoHandler handler) {
        super(ctx);
        this.title = title.trim();
        this.text = text.trim();
        this.handler = handler;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_general);

        //set the proper buttons visible/gone
        Objects.requireNonNull((View) findViewById(R.id.generaldialog_button_ok)).setVisibility(View.GONE);
        Objects.requireNonNull((View) findViewById(R.id.generaldialog_button_yes)).setVisibility(View.VISIBLE);
        Objects.requireNonNull((View) findViewById(R.id.generaldialog_button_no)).setVisibility(View.VISIBLE);

        ((TextView) Objects.requireNonNull((View) findViewById(R.id.generaldialog_alt_text))).setText(text);

        //don't show the title if it's null
        if (title == null)
            Objects.requireNonNull((View) findViewById(R.id.generaldialog_alt_title)).setVisibility(View.GONE);
        else
            ((TextView) Objects.requireNonNull((View) findViewById(R.id.generaldialog_alt_title))).setText(title);

        //when you hit no
        Objects.requireNonNull((View) findViewById(R.id.generaldialog_button_no)).setOnClickListener(x -> {
            dismiss();
            handler.onNoClicked();
        });

        //when you hit yet
        Objects.requireNonNull((View) findViewById(R.id.generaldialog_button_yes)).setOnClickListener(x -> {
            dismiss();
            handler.onYesClicked();
        });
    }
}