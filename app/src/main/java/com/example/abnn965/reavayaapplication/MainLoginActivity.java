package com.example.abnn965.reavayaapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainLoginActivity extends AppCompatActivity {

    SQLiteDatabase myDb;
    DatabaseHelper dbH;

    private EditText accNumber;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        dbH = new DatabaseHelper(this);

        accNumber = (EditText) findViewById(R.id.edtAccountNumber);
        password = (EditText) findViewById(R.id.edtPassword);
    }

    public void onClickLogin(View view){


        final String TABLE_NAME = " customer_table";
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        myDb = dbH.getReadableDatabase();
        Cursor cursor = myDb.rawQuery(selectQuery, null);

        while(cursor.moveToNext()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String surname = cursor.getString(2);
            String cellnumber = cursor.getString(3);
            String accountnumber = cursor.getString(4);
            String password_db = cursor.getString(5);
            String email = cursor.getString(6);

            if (accNumber.getText().toString().equals(accountnumber) && password.getText().toString().equals(password_db)){
                Intent loginIntent = new Intent(MainLoginActivity.this, HomeActivity.class);
                startActivity(loginIntent);
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Account Number and Password don't match", Toast.LENGTH_LONG).show();
            }
        }cursor.close();

    }

    public void onClickRegister(View view){
        Intent registerIntent = new Intent(MainLoginActivity.this, RegisterActivity.class);
        startActivity(registerIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
