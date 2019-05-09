package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RevisionNotesArrayAdapter extends ArrayAdapter<Note> {
	Context context;
	ArrayList<Note> notes;
	int resource;
	private TextView tvNote;
	ImageView iv1, iv2, iv3, iv4, iv5;

	public RevisionNotesArrayAdapter(Context context, int resource, ArrayList<Note> notes) {
		super(context, resource, notes);
		this.context = context;
		this.notes = notes;
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(resource, parent, false);

		//Match the UI components with Java variables

		tvNote = rowView.findViewById(R.id.textViewNote);

		Note note = notes.get(position);
		String theStar = (String.valueOf(note.getStars()));

		tvNote.setText(note.getNoteContent());

		//Check if the property for starts >= 5, if so, "light" up the stars
		if (theStar.equals("5")) {
			iv5.setImageResource(android.R.drawable.btn_star_big_on);
			iv4.setImageResource(android.R.drawable.btn_star_big_on);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		} else if (theStar.equals("4")) {
			iv5.setImageResource(android.R.drawable.btn_star_big_off);
			iv4.setImageResource(android.R.drawable.btn_star_big_on);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		} else if (theStar.equals("3")) {
			iv5.setImageResource(android.R.drawable.btn_star_big_off);
			iv4.setImageResource(android.R.drawable.btn_star_big_off);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		} else if (theStar.equals("2")) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv2.setImageResource(android.R.drawable.btn_star_big_off);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }

		return rowView;
	}



}
