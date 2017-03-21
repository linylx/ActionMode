package com.example.administrator.actionmode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class MainActivity extends Activity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyListView();
    }

    public void MyListView(){
        final String[] strings = new String[]{"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX"};
        int[] imgId = new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
        listView = (ListView)findViewById(R.id.listView1);
        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i=0;i<strings.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("img",imgId[i]);
            listItem.put("text",strings[i]);
            listItems.add(listItem);
        }
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItems,R.layout.temp,new String[]{"img","text"},new int[]{R.id.image_view,R.id.text_view});
        listView.setAdapter(mSimpleAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                MenuInflater inflater=actionMode.getMenuInflater();
                inflater.inflate(R.menu.menu,menu);
                return true;
            }
            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }
            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
            }
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {}
            });
     }
}
