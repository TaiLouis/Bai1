package com.example.bai1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ThongTin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);

        Intent intent = getIntent();
        String thongtin = intent.getStringExtra("ten") + "\n"+
                intent.getStringExtra("cmnd") + "\n" +
                intent.getStringExtra("bangcap") + "\n" +
                intent.getStringExtra("sothich") + "\n" +
                "-----------------"+ "\n" +
                intent.getStringExtra("bosung")+ "\n"+
                "-----------------";

        TextView txtthongtin = findViewById(R.id.txtThongTin);
        txtthongtin.setText(thongtin);

    }

    public void xuLyDong(View view) {
        finish();
    }
}
