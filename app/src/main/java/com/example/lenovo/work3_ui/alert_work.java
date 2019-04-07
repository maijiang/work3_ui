package com.example.lenovo.work3_ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.app.AlertDialog;

public class alert_work extends AppCompatActivity {
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog);
        //实例化布局
        View view = getLayoutInflater().inflate(R.layout.login,null);
        //找到并对自定义布局中的控件进行操作的示例
       final EditText et_username = (EditText) view.findViewById(R.id.et_username);
        final EditText et_password = (EditText) view.findViewById(R.id.et_password);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setCancelable(false);//不可取消
        //正面按钮
        builder.setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String username = et_username.getText().toString().trim();
                Toast.makeText(alert_work.this,username+"登录中..",Toast.LENGTH_SHORT).show();
            }
        });
        //反面按钮
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(alert_work.this,"取消登录..",Toast.LENGTH_SHORT).show();

            }
        });
        builder.show(); //显示对话框
    }
}
