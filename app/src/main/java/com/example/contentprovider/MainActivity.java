package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnGetContactPressed(View v){
        getPhoneContacts();
    }
    private void getPhoneContacts(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},0);

        }

        ContentResolver contentResolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = contentResolver.query(uri, null, null,null, null);
        Log.i("CONTACT_PROVIDER_DEMO", "TOTAL # of CONTACTS ::: " + Integer.toString(cursor.getCount()));

        if(cursor.getCount() > 0){
            ListView listView = (ListView) findViewById(R.id.lv_view);
            ContactAdapter contactAdapter;
            List<Contact> contacts = new ArrayList<>();
            while (cursor.moveToNext()){
                @SuppressLint("Range") String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                @SuppressLint("Range") String contactNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


                Log.i("CONTACT_PROVIDER_DEMO","CONTACT NAME :::  " + contactName + "     Ph # :::   " + contactNumber);
                Contact contact = new Contact(contactName,contactNumber);
                contacts.add(contact);
            }
            contactAdapter = new ContactAdapter(MainActivity.this,R.layout.activity_item,contacts);
            listView.setAdapter(contactAdapter);
        }
    }
}