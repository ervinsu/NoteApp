package com.example.dicodingnoteapp;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.dicodingnoteapp.db.DatabaseContract.NoteColumns.DATE;
import static com.example.dicodingnoteapp.db.DatabaseContract.NoteColumns.DESCRIPTION;
import static com.example.dicodingnoteapp.db.DatabaseContract.NoteColumns.TITLE;
import static com.example.dicodingnoteapp.db.DatabaseContract.getColumnString;

public class DicodingNoteAdapter extends CursorAdapter {

    public DicodingNoteAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dicoding_note, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        if (cursor != null){
            TextView tvTitle = (TextView)view.findViewById(R.id.tv_item_title);
            TextView tvDate = (TextView)view.findViewById(R.id.tv_item_date);
            TextView tvDescription = (TextView)view.findViewById(R.id.tv_item_description);

            tvTitle.setText(getColumnString(cursor,TITLE));
            tvDescription.setText(getColumnString(cursor,DESCRIPTION));
            tvDate.setText(getColumnString(cursor,DATE));
        }
    }

    @Override
    public Cursor getCursor() {
        return super.getCursor();
    }
}
