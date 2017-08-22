package com.noor.friendsemail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtId,txtName,txtEmail;
    Button btnSave,btnView;

    MySqliteDB sqliteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId=(EditText)findViewById(R.id.txtId);
        txtName=(EditText)findViewById(R.id.txtName);
        txtEmail=(EditText)findViewById(R.id.txtEmail);


        sqliteDB=new MySqliteDB(MainActivity.this);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String id=txtId.getText().toString();
                String name=txtName.getText().toString();
                String email=txtEmail.getText().toString();

                if (id.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please input id!", Toast.LENGTH_SHORT).show();
                }

                if (name.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please input name!", Toast.LENGTH_SHORT).show();
                }

                if (email.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please input email!", Toast.LENGTH_SHORT).show();
                }


                boolean chk=sqliteDB.addToTable(id,name,email);
                if (chk==true)
                {
                    Toast.makeText(MainActivity.this, "Data insert successful", Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(MainActivity.this, "Data not inserted!", Toast.LENGTH_SHORT).show();
            }
        });

        


        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
    }
}
