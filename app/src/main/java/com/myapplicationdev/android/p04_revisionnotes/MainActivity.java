package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    RadioGroup rgStar;
    Button btnInsert, btnShowList;

    ArrayList<Note> al;
    ArrayAdapter aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = findViewById(R.id.editTextNote);
        btnInsert = findViewById(R.id.buttonInsertNote);
        btnShowList = findViewById(R.id.buttonShowList);


//        DBHelper db = new DBHelper(MainActivity.this);
//
//        // Insert a task
//        ArrayList<String> data = db.getNoteContent();
//
//        db.insertNote("Revision Note #1", 3);
//        db.insertNote("Revision Note #2", 4);
//        db.insertNote("Revision Note #3", 1);
//        db.close();


        // DBHelper db = new DBHelper(this);
        // db.getWritableDatabase();
        // db.close();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rgStar = findViewById(R.id.radioGroupStars);
                int selectedButtonId = rgStar.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);

                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
//                db.insertNote(etNote.getText().toString(), Integer.parseInt(rb.getText()));
                db.close();

                Toast.makeText(MainActivity.this, "inserted", Toast.LENGTH_LONG).show();

            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Note> data = db.getAllNotes();
                db.close();


                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", data.get(i).getId() +". "+data.get(i).getNoteContent() +". " + data.get(i).getStars());
//                    int theID = data.get(i).getId();
//                    String theNote = data.get(i).getNoteContent();
//                    int theStar = data.get(i).getStars();

                    //Intent intent = new Intent (getBaseContext(), SecondActivity.class);
//                    intent.putExtra("id", theID);
//                    intent.putExtra("note", theNote);
//                    intent.putExtra("star", theStar);
                    //startActivity(intent);
                }

                Intent intent = new Intent (getBaseContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}
