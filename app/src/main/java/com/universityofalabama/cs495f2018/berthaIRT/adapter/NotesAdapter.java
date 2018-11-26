package com.universityofalabama.cs495f2018.berthaIRT.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.universityofalabama.cs495f2018.berthaIRT.Message;
import com.universityofalabama.cs495f2018.berthaIRT.R;
import com.universityofalabama.cs495f2018.berthaIRT.Util;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private List<Message> notes;

    public NotesAdapter(List<Message> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_note, parent, false);
        return new NotesAdapter.NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NotesViewHolder holder, int position) {
        Message note = this.notes.get(position);
        holder.noteTimestamp.setText(Util.formatTimestamp(note.getMessageTimestamp()));
        holder.noteBody.setText(note.getMessageBody());
        holder.noteSubject.setText(note.getMessageSubject());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{
        TextView noteBody, noteTimestamp, noteSubject;

        NotesViewHolder(View itemView) {
            super(itemView);

            noteTimestamp = itemView.findViewById(R.id.note_alt_timestamp);
            noteBody =  itemView.findViewById(R.id.note_alt_text);
            noteSubject = itemView.findViewById(R.id.note_alt_subject);
        }
    }
}
