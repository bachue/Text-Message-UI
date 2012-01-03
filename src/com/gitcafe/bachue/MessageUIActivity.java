package com.gitcafe.bachue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MessageUIActivity extends Activity {
    private ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        listView = (ListView) findViewById(R.id.listview);
        
        final String[] message_texts = getResources().getStringArray(R.array.messages);
        final String[] dates = new String[] {
        		new Date(89, 5, 4).toLocaleString(), 
        		new Date(89, 10, 7).toLocaleString(), 
        		new Date(91, 7, 18).toLocaleString()};
        final ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < 3; ++i)
        {
        	final HashMap<String, Object> map = new HashMap<String, Object>();
        	map.put("text", message_texts[i]);
        	map.put("date", dates[i]);
        	map.put("gravatar", R.drawable.ic_launcher);
        	arrayList.add(map);
        }
        final SimpleAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.item, 
        		new String[] {"gravatar", "text", "date"}, new int[] {R.id.gravatar, R.id.text, R.id.date});
        listView.setAdapter(adapter);
    }
}