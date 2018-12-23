package com.cyj.a20181223_androidf;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private android.widget.Button logoutBtn;
    private android.widget.TextView timeTxt;
    private Button timePickerBtn;
    private TextView dateTxt;
    private Button datePickerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvent();
        setValues();
    }

    @Override
    public void setupEvent() {

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                경고창을 띄우고, 확인을 누르면 로그아웃 되었다는 토스트
//                취소를 누르면 아무일도 없던것으로 처리.
                AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                alert.setTitle("로그아웃 확인");
                alert.setMessage("정말 로그아웃 하시겠어요?");
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("취소", null);
                alert.show();
            }
        });

        timePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog.OnTimeSetListener otsl = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String selectedTime = String.format("%d시 %d분", hourOfDay, minute);
                        timeTxt.setText(selectedTime);
                    }
                };

                TimePickerDialog tpd = new TimePickerDialog(mContext, otsl, 13, 30, false);
                tpd.show();
            }
        });

        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener odsl = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                       String selectDate = String.format("%d년 %d월 %d일", year, month+1, dayOfMonth);
                       dateTxt.setText(selectDate);
                    }
                };

                DatePickerDialog dpd = new DatePickerDialog(mContext, odsl, 2018, 11, 23);
                dpd.show();
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.timePickerBtn = (Button) findViewById(R.id.timePickerBtn);
        this.datePickerBtn = (Button) findViewById(R.id.datePickerBtn);
        this.timeTxt = (TextView) findViewById(R.id.timeTxt);
        this.dateTxt = (TextView) findViewById(R.id.dateTxt);
        this.logoutBtn = (Button) findViewById(R.id.logoutBtn);

    }
}
