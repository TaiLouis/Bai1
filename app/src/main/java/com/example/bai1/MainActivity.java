package com.example.bai1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText edtTen, edtCMND, edtBoSung;
    private RadioButton radTrungCap, radCaoDang, radDaiHoc;
    private CheckBox chkDocBao, chkDocSach, chkCoding;
    private Button btnGuiThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTen = findViewById(R.id.edtName);
        edtCMND = findViewById(R.id.edtCMND);
        edtBoSung = findViewById(R.id.edtBosung);
        radCaoDang = findViewById(R.id.radCaoDang);
        radDaiHoc = findViewById(R.id.radDaiHoc);
        radTrungCap = findViewById(R.id.radTrungCap);
        chkCoding = findViewById(R.id.chkCoding);
        chkDocBao = findViewById(R.id.chkDocBao);
        chkDocSach = findViewById(R.id.chkDocSach);
        btnGuiThongTin = findViewById(R.id.btnGuiThongTin);
    }


    private boolean checkValidTen(){
        return edtTen.getText().toString().length() >= 3;
    }

    private boolean checkValidCMND(){
        return edtCMND.getText().toString().length() == 9;
    }

    private boolean checkSelectedBangCap(){
        if (radTrungCap.isChecked() || radDaiHoc.isChecked() || radCaoDang.isChecked())
            return true;

        return false;
    }

    private boolean checkSelectedSothich(){
        if (radTrungCap.isChecked() || radDaiHoc.isChecked() || radCaoDang.isChecked())
            return true;

        return false;
    }

    public void xuLyGuiThongTin(View view) {
        boolean isValidInfo = true;
        isValidInfo = isValidInfo && checkValidTen() && checkSelectedBangCap() && checkSelectedSothich();

        if (isValidInfo == false){
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Lỗi");
            alertDialog.setMessage("Thông tin không hợp lệ");
            alertDialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            alertDialog.create().show();

        }
        else{
            Intent thongtin = new Intent(MainActivity.this, ThongTin.class);
            String ten = this.edtTen.getText().toString();
            String cmnd = this.edtCMND.getText().toString();
            String bosung = this.edtBoSung.getText().toString();

            String bangcap = "";
            if (this.radCaoDang.isChecked())
                bangcap = "Cao đăng";

            if (this.radDaiHoc.isChecked())
                bangcap = "Đại học";

            if (this.radTrungCap.isChecked())
                bangcap = "Trung câp";


            String sothich = "";
            if (this.chkDocSach.isChecked())
                sothich += "Dọc sách" + " ";

            if (this.chkDocBao.isChecked())
                sothich = "Đọc báo" + " ";

            if (this.chkCoding.isChecked())
                sothich = "Coding" + " ";


            thongtin.putExtra("ten", ten);
            thongtin.putExtra("cmnd", cmnd);
            thongtin.putExtra("bosung", bosung);
            thongtin.putExtra("bangcap", bangcap);
            thongtin.putExtra("sothich", sothich);

            startActivity(thongtin);
        }


    }
}
