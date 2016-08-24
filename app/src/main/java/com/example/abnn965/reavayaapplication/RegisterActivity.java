package com.example.abnn965.reavayaapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    private Button submit;

    private EditText name;
    private EditText surname;
    private EditText cellNumber;
    private EditText accountNumber;
    private EditText password;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myDb = new DatabaseHelper(this);

        submit = (Button) findViewById(R.id.btnRegisterActivity);
        name = (EditText) findViewById(R.id.edtName);
        surname = (EditText) findViewById(R.id.edtSurname);
        cellNumber = (EditText) findViewById(R.id.edtCellNumber);
        accountNumber = (EditText) findViewById(R.id.edtAccountNumber);
        password = (EditText) findViewById(R.id.edtPassword);
        email = (EditText) findViewById(R.id.edtEmail);
    }

    public void onClickRegisterAct(View view){

        boolean isInserted = myDb.insertCustomerDetails(name.getText().toString(),
                surname.getText().toString(),
                cellNumber.getText().toString() ,
                accountNumber.getText().toString(),
                password.getText().toString(),
                email.getText().toString());

        if (isInserted == true){
            Toast.makeText(RegisterActivity.this, "Successfully added information, Please capture Documents", Toast.LENGTH_LONG).show();

            Intent captureDocs = new Intent(RegisterActivity.this, MainLoginActivity.class);
            startActivity(captureDocs);
        }
        else{
            Toast.makeText(RegisterActivity.this, "User not registered, try again!!!", Toast.LENGTH_LONG).show();
        }


    }


}
