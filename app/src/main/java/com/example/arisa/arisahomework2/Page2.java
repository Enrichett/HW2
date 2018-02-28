package com.example.arisa.arisahomework2;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Page2 extends AppCompatActivity {
    //region 變數
    private Button button3;
    private TextView textView3;
    private Button fuck;
    private EditText you;
    int[] answer = new int[4];//answer[0~3]
    private TextView textView2;
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        for (int i = 0; i < 4; i++) {
            answer[i] = (int) (Math.random() * 10);
            for (int j = 0; j < i; j++) {
                if (answer[i] == answer[j]) {
                    i = i - 1;
                    break;
                }
            }
        }
        //   Log.e("寇錫胺是智障", String.valueOf(answer[0])+String.valueOf(answer[1])+String.valueOf(answer[2])+String.valueOf(answer[3]));
        findView();
        setListner();

    }


    //region findView動作(固定)
    private void findView(){
        textView2 = (TextView)findViewById(R.id.textView2);
        you = (EditText) findViewById(R.id.editText3);
        fuck = (Button) findViewById(R.id.send);
        button3 = (Button) findViewById(R.id.button3);
        textView3 = (TextView) findViewById(R.id.textView3);
    }
    //endregion

    private void setListner(){
        button3.setOnClickListener(clickListener);
        fuck.setOnClickListener(clickListener);
    }


    private void Alert(){
        new AlertDialog.Builder(Page2.this).setTitle("Alert").setItems(new String[] { "超過四個數字" }
        , null).setNegativeButton("確認", null).show();
    }

    private void facebook() {
        int num;
        int[] tmp = new int[4];
        int countA = 0;
        int countB = 0;


        num = Integer.parseInt(you.getText().toString());
        tmp[0] = num / 1000;
        tmp[1] = (num % 1000) / 100;
        tmp[2] = (num % 100) / 10;
        tmp[3] = num % 10;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tmp[i] == answer[j]) {
                    if (i == j)
                        countA += 1;//數字相同而且位置相同 +1A
                    else
                        countB += 1;//數字相同但是位置不同 -1A
                }
            }
            textView2.setText(countA + "A" + countB + "B");

            if (countA == 4) {
                textView2.setText(countA + "A" + countB + "B");
                textView3.setText("答案是：" + String.valueOf(answer[0]) + String.valueOf(answer[1]) + String.valueOf(answer[2]) + String.valueOf(answer[3]));
            }


        }
    }

    //region 點擊事件

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button3:
                    textView3.setText("答案是：" + String.valueOf(answer[0]) + String.valueOf(answer[1]) + String.valueOf(answer[2]) + String.valueOf(answer[3]));
                    break;
                case R.id.send:
                    if (you.length() ==4){
                        Log.e("寇錫胺是智障", you.getText().toString());
                        if (!you.getText().toString().equals("")){
                            facebook();
                        }
                    }
                    else{
                        Alert();
                    }
                    you.setText("");
                    break;
            }
        }
    };
    //endregion

    protected void onStart() {
        super.onStart();

    }
}


