package com.sateria.uts_18411023_sateria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtNPM, edtNama, edtMatkul, edtTugas, edtUTS, edtUAS;

    Button btnHitung;
    TextView txtNilai, txtGrade, txtKeterangan, txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNPM = (EditText) findViewById(R.id.edtNPM);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtMatkul = (EditText) findViewById(R.id.edtMatkul);
        edtTugas = (EditText) findViewById(R.id.nilaitugas);
        edtUTS = (EditText) findViewById(R.id.nilaiuts);
        edtUAS = (EditText) findViewById(R.id.nilaiuas);
        txtHasil  = (TextView) findViewById(R.id.txtHasil);
        btnHitung = (Button) findViewById(R.id.tombol);
        txtNilai  = (TextView) findViewById(R.id.nilaiakhir);
        txtGrade  = (TextView) findViewById(R.id.nilaigrade);
        txtKeterangan  = (TextView) findViewById(R.id.nilaiketerangan);


        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNPM = edtNPM.getText().toString();
                String strNama = edtNama.getText().toString();
                String strMatkul = edtMatkul.getText().toString();
                String strGrade = txtGrade.getText().toString();
                String tugas = edtTugas.getText().toString().trim();
                String uts = edtUTS.getText().toString().trim();
                String uas = edtUAS.getText().toString().trim();

                double T = Double.parseDouble(tugas);
                double U = Double.parseDouble(uts);
                double UAS = Double.parseDouble(uas);
                double Nilai = (0.3 * T) + (0.3 * U) + (0.4 * UAS);

                if (Nilai >= 80&&Nilai<=100) {
                    strGrade = "A";
                } else if (Nilai >= 70&&Nilai<=80) {
                    strGrade = "B";
                } else if (Nilai >= 60&&Nilai<=70) {
                    strGrade = "C";
                } else if (Nilai >= 50&&Nilai<=60) {
                    strGrade = "D";
                } else {
                    strGrade = "E";
                }

                txtNilai.setText("NPM : " +strNPM + "\n" + "Nama : " +strNama + "\n" + "Mata Kuliah : " + strMatkul + "\n"   + "Grade : " + strGrade + "\n" + "Total Nilai : " + Nilai );

                if (Nilai >= 60) {
                    txtKeterangan.setText("Keterangan : LULUS");
                } else {
                    txtKeterangan.setText("Keterangan : TIDAK LULUS");
                }
            }
        });

    }
}