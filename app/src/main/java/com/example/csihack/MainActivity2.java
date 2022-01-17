package com.example.csihack;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText name, contact, dob;
    Button insert, update, delete, view, viewtwo;
    DBHelper DB;
    public static final String EXTRA_NUMBERTWO = "com.example.csihack.EXTRA_NUMBERTWO";
    public static final String EXTRA_NUMBER = "com.example.csihack.EXTRA_NUMBER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        viewtwo = findViewById(R.id.btnViewtwo);
        DB = new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, contactTXT, dobTXT);
                if(checkinsertdata==true)
                    Toast.makeText(MainActivity2.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity2.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, contactTXT, dobTXT);
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity2.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity2.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(MainActivity2.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity2.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity2.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Subject: "+res.getString(0)+"\n");
                    buffer.append("No. of sessions completed: "+res.getString(1)+"\n");
                    buffer.append("Difficulty level: "+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });

        viewtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Cursor res = DB.getdata();
//                if(res.getCount()==0){
//                    Toast.makeText(MainActivity2.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
//                    return;
//                }
////                StringBuffer buffer = new StringBuffer();
////                while(res.moveToNext()){
////                    buffer.append("Name :"+res.getString(0)+"\n");
////                    buffer.append("Contact :"+res.getString(1)+"\n");
////                    buffer.append("Date of Birth :"+res.getString(2)+"\n\n");
////                }
////
////                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
////                builder.setCancelable(true);
////                builder.setTitle("User Entries");
////                builder.setMessage(buffer.toString());
////                builder.show();

                // number:
                String contactTXT = contact.getText().toString();
                int inpone = Integer.parseInt(contactTXT);
                //numbertwo:
//                int full = 100;
                String dobTXT = dob.getText().toString();
                int inptwo = Integer.parseInt(dobTXT);
//                int inptwo = 1;
//                Initializing variables:
                int sessions_required;
                int opone = 0;
                int optwo = 0;
//                Operations:
//                Easy
                if(inptwo!=1||inptwo!=2||inptwo!=3){
                if(inptwo==1) {
                    sessions_required = 15;

                    opone = ((inpone * 100) / sessions_required);
                    optwo = 15 - inpone;
//                Sending these:
                    openActivity3(opone, optwo);
                }
//                Medium
                if(inptwo==2) {
                    sessions_required = 20;
                    opone = ((inpone * 100) / sessions_required);
                    optwo = 20 - inpone;
//                Sending these:
                    openActivity3(opone, optwo);
                }
//                Hard
                if(inptwo==3) {
                    sessions_required = 30;
                    opone = ((inpone * 100) / sessions_required);
                    optwo = 30 - inpone;
//                Sending these:
                    openActivity3(opone, optwo);
                }
                +}
                else{
                    Toast.makeText(MainActivity2.this,"WRONG INPUT",Toast.LENGTH_SHORT).show();}
            }        });
    }
    private void openActivity3(int opone, int optwo) {
        EditText editText1 = (EditText) findViewById(R.id.edittext1);
        int numbertwo = optwo;
        EditText editText2 = (EditText) findViewById(R.id.edittext2);
        int number = opone;
        android.content.Intent intent = new android.content.Intent(this, MainActivity3.class);
        intent.putExtra(EXTRA_NUMBERTWO,numbertwo);
        intent.putExtra(EXTRA_NUMBER,number);
        startActivity(intent);
    }
}

//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.google.android.material.button.MaterialButton;
//
//public class MainActivity2 extends AppCompatActivity {
//    public static final String EXTRA_TEXT = "com.example.csihack.EXTRA_TEXT";
//    public static final String EXTRA_NUMBER = "com.example.csihack.EXTRA_NUMBER";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        MaterialButton nextbtn = (MaterialButton) findViewById(R.id.nextbtn);
//        nextbtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v){
//                openActivity4();
//            }
//        });
//    }
//    private void openActivity4() {
//        EditText editText1 = (EditText) findViewById(R.id.edittext1);
//        String text = editText1.getText().toString();
//        EditText editText2 = (EditText) findViewById(R.id.edittext2);
//        int number = Integer.parseInt(editText2.getText().toString());
//        android.content.Intent intent = new android.content.Intent(this, MainActivity4.class);
//        intent.putExtra(EXTRA_TEXT,text);
//        intent.putExtra(EXTRA_NUMBER,number);
//        startActivity(intent);
//    }
//}
