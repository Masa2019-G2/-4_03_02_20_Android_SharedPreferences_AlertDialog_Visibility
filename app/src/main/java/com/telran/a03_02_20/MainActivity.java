package com.telran.a03_02_20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText inputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.inputName);
        Button saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener( v -> {
//            save(inputName.getText().toString());

            showDialog("Save new input?");
        });
        load();



        BankAccount acc = new BankAccount()
                .balance(100)
                .id(123)
                .owner("Vasya");
        Log.d("MY_TAG", "onCreate: " + acc.toString());

//        showDialog("Text message!");

        Button myBtn = findViewById(R.id.myBtn);
        myBtn.setVisibility(View.GONE);
    }


    private void save(String name){
//        SharedPreferences sp = getSharedPreferences("DATA",MODE_PRIVATE);
//        SharedPreferences.Editor editor = sp.edit();
//
//        editor.putString("NAME",name);
//        editor.commit();
        getSharedPreferences("DATA",MODE_PRIVATE)
                .edit()
                .putString("NAME",name)
                .putString("LAST_NAME","Pupkin")
                .putString("PHONE","123456")
                .putInt("AGE",32)
                .commit();
    }


    private void load(){
        SharedPreferences sp = getSharedPreferences("DATA",MODE_PRIVATE);
        inputName.setText(sp.getString("NAME",""));
    }


    private void showDialog(String message){
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Dialog")
                .setMessage(message)
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("Ok", (dialog1, which) -> MainActivity.this.save(inputName.getText().toString()))
                .setNegativeButton("No",null)
                .setCancelable(false)
                .create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
