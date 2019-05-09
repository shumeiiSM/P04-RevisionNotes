package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	TextView theNote;
	ArrayAdapter aa;
	ArrayList<Note> note;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView


		lv = findViewById(R.id.lv);
		theNote = findViewById(R.id.textViewNote);

		note = new ArrayList<Note>();

		note.add(new Note(1, "Revision Note #1", 3));
		note.add(new Note(2, "Revision Note #2", 4));
		note.add(new Note(3, "Revision Note #3", 1));

		aa = new RevisionNotesArrayAdapter(this, R.layout.row, note);
		lv.setAdapter(aa);

//		Intent i = getIntent();
//		Integer id = i.getIntExtra("id", 0);
//		String note = i.getStringExtra("note");
//		Integer star = i.getIntExtra("star", 0);
//
//		Note note1 = new Note(id, note, star);

		DBHelper db = new DBHelper(SecondActivity.this);

		// Insert a task
		ArrayList<Note> data = db.getAllNotes();
		db.close();

		for (int i = 0; i < data.size(); i++) {
			int theID = data.get(i).getId();
			String theNote = data.get(i).getNoteContent();
			int theStar = data.get(i).getStars();

			Note note1 = new Note(theID, theNote, theStar);
			note.add(note1);
			aa = new RevisionNotesArrayAdapter(this, R.layout.row, note);
			lv.setAdapter(aa);
		}



	}


}
