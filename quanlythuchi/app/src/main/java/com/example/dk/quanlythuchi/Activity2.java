package com.example.dk.quanlythuchi;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Activity2 extends AppCompatActivity {
    Button btnHienThi;
    Button btnNhapLai;
    Button btnThem;
    EditText edtND;
    EditText edtTien;
    RadioButton radioThu;
    RadioButton radioChi;
    RadioGroup radioGroup;
    ArrayList<NDThuChi> listTC;
    EditText edtNgay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        listTC = new ArrayList<>();
        btnThem = (Button) findViewById(R.id.buttonThem);
        btnNhapLai = (Button) findViewById(R.id.buttonNhaplai);
        edtND = findViewById(R.id.editTextND);
        edtTien = findViewById(R.id.editTextSoTien);
        edtNgay = (EditText) findViewById(R.id.editTextNgay);
        edtNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChonNgay();
            }
        });
        radioChi = findViewById(R.id.radioButtonChi);
        radioThu = findViewById(R.id.radioButtonThu);
        btnHienThi = (Button) findViewById(R.id.buttonHienthi);
        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("data", listTC);
                setResult(RESULT_OK, intent2);
                finish();
            }
        });
        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtND.setText("");
                edtTien.setText("");
                edtNgay.setText("");
                radioChi.setChecked(false);
                radioThu.setChecked(false);
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            NDThuChi tc = new NDThuChi(edtND.getText().toString(),Integer.valueOf(edtTien.getText().toString()),(radioChi.isChecked() ? "chi":"thu"));
            listTC.add(tc);
                Toast.makeText(Activity2.this, "Nội dung đã được thêm vào danh sách", Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void ChonNgay() {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtNgay.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam, thang, ngay);
        datePickerDialog.show();
    }

    public NDThuChi insert() {
        String noidung = edtND.getText().toString();
        int sotien = edtTien.getInputType();
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(id);
        String hinhthuc = radioButton.getText().toString();
        int idHinhthuc = 0;
//

        NDThuChi ndThuChi = new NDThuChi(noidung, sotien, hinhthuc);
        return ndThuChi;
    }

    public void addList(NDThuChi ndThuChi) {

        MainActivity.ndThuChis.add(ndThuChi);

    }
}
