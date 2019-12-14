package com.example.okul.listviewornek;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListelemeActivity extends ActionBarActivity {
ListView lst;
    ArrayList<String> listKategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeleme);
        lst=(ListView) findViewById(R.id.listView);
        listKategori=new ArrayList<String>();
        for (int i=1;i<=80;i++){
            listKategori.add("Kategori"+i);
        }
        /*
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listKategori);
        */
        //bu alanda  my_list_item isimli oluşturulan layout çağrılarak liste oluşturulur.
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.my_list_item,R.id.lbl_item,listKategori);


        lst.setAdapter(adp);
        //liste elemaları listviewvwe eklendi
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent();
                i.putExtra("KATEGORI",listKategori.get(position));
                setResult(MainActivity.LISTELEVERIKOD,i);
                finish();//listeden secilen elemanı main activitiye gönderir
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listeleme, menu);
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
