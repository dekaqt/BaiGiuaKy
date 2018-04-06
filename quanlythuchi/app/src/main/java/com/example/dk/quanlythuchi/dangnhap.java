package com.example.dk.quanlythuchi;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dangnhap extends AppCompatActivity {
    EditText edtUser;
    EditText edtPass;
    Button btnIn;
    Button btnUp;
    Button btnExit;
    Button goiy;
    String ten, mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        goiy = (Button)findViewById(R.id.goiy);
        goiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(dangnhap.this, android.R.style.Theme_DeviceDefault_Dialog);
                builder.setTitle("  TÀI KHOẢN DÙNG THỬ");
                builder.setMessage("Tài khoản: khoa \r\n"  + "Mật khẩu: 1234");
                builder.show();
            }
        });
        Anhxa();
        ControlButton();
    }

    private void Anhxa() {
        btnExit = (Button) findViewById(R.id.buttonExit);
        btnIn = (Button) findViewById(R.id.buttonSignIn);
        btnUp = (Button) findViewById(R.id.buttonSignUp);
        edtUser = (EditText)findViewById(R.id.editTextUser);
        edtPass = (EditText)findViewById(R.id.editTextPass);
    }


    private void ControlButton() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(dangnhap.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("XÁC NHẬN THOÁT KHỎI CHƯƠNG TRÌNH");
                builder.setMessage("Bạn có muốn thoát khỏi chương trình?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(dangnhap.this);
                dialog.setTitle("ĐĂNG KÍ");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.signup);
                final EditText tenDK = (EditText)dialog.findViewById(R.id.tenDK);
                final EditText mkDK = (EditText)dialog.findViewById(R.id.mkDK);
                Button btnDK = (Button)dialog.findViewById(R.id.buttonDK);
                Button huyDK = (Button)dialog.findViewById(R.id.buttonHuy);
                btnDK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ten =  tenDK.getText().toString().trim();
                        mk = mkDK.getText().toString().trim();

                        edtUser.setText(ten);
                        edtPass.setText(mk);

                        dialog.cancel();
                    }
                });
                huyDK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUser.getText().length() !=0 && edtPass.getText().length() != 0) {
                    if (edtUser.getText().toString().equals(ten) && edtPass.getText().toString().equals(mk)){
                        Toast.makeText(dangnhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(dangnhap.this, Activity2.class);
                        startActivity(intent);
                    } else if (edtUser.getText().toString().equals("khoa") && edtPass.getText().toString().equals("1234")){
                        Toast.makeText(dangnhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(dangnhap.this, Activity2.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(dangnhap.this, "Tài khoản hoặc Mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(dangnhap.this, "Tài khoản hoặc Mật khẩu không được bỏ trống", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
