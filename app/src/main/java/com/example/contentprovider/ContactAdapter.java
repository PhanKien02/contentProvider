package com.example.contentprovider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private  List<Contact> contacts;

    public ContactAdapter(Context context, int layout, List<Contact> contacts) {
        this.context = context;
        this.layout = layout;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        TextView tvname = (TextView) convertView.findViewById(R.id.name);
        TextView tvsdt = (TextView) convertView.findViewById(R.id.sdt);
        Contact contact = contacts.get(position);
        tvname.setText(contact.getName());
        tvsdt.setText(contact.getSdt());
        return convertView;
    }
}
