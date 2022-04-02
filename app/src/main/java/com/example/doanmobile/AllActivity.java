package com.example.doanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AllActivity extends AppCompatActivity {

    //
    private static int colorIndex;
    private static final String TAG = "ListViewActivity";
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //
        ListView listView = (ListView) findViewById(R.id.list_activity);
        ActivityArrayAdapter activityArrayAdapter = new ActivityArrayAdapter(getApplicationContext(), R.layout.list_activity);
        listView.setAdapter(activityArrayAdapter);

        List<String[]> fruitList = readData();
        for(String[] fruitData:fruitList ) {
            String fruitImg = fruitData[0];
            String fruitName = fruitData[1];
            String calories = fruitData[2];

            Fruit fruit = new Fruit(fruitImg,fruitName,calories);
            activityArrayAdapter.add(fruit);
        }
        //
    }

    //
    public List<String[]> readData(){
        List<String[]> resultList = new ArrayList<String[]>();

        String[] fruit7 = new String[3];
        fruit7[0] = "Quỹ vaccine...";
        fruit7[1] = "2 hours ago";
        fruit7[2] = "- 1.5 ETH";
        resultList.add(fruit7);

        String[] fruit1 = new String[3];
        fruit1[0] = "Quỹ vaccine...";
        fruit1[1] = "2 hours ago";
        fruit1[2] = "- 1.5 ETH";
        resultList.add(fruit1);


        String[] fruit3 = new String[3];
        fruit3[0] = "Quỹ vaccine...";
        fruit3[1] = "2 hours ago";
        fruit3[2] = "- 1.5 ETH";
        resultList.add(fruit3);

        String[] fruit4 = new String[3];
        fruit4[0] = "Quỹ vaccine...";
        fruit4[1] = "2 hours ago";
        fruit4[2] = "- 1.5 ETH";
        resultList.add(fruit4);

        String[] fruit10 = new String[3];
        fruit10[0] = "Quỹ vaccine...";
        fruit10[1] = "2 hours ago";
        fruit10[2] = "- 1.5 ETH";
        resultList.add(fruit10);

        String[] fruit5 = new String[3];
        fruit5[0] = "Quỹ vaccine...";
        fruit5[1] = "2 hours ago";
        fruit5[2] = "- 1.5 ETH";
        resultList.add(fruit5);


        String[] fruit2 = new String[3];
        fruit2[0] = "Quỹ vaccine...";
        fruit2[1] = "Quỹ vaccine...";
        fruit2[2] = "- 1.5 ETH";
        resultList.add(fruit2);

        String[] fruit6 = new String[3];
        fruit6[0] = "Quỹ vaccine...";
        fruit6[1] = "Quỹ vaccine...";
        fruit6[2] = "- 1.5 ETH";
        resultList.add(fruit6);

        String[] fruit8 = new String[3];
        fruit8[0] = "Quỹ vaccine...";
        fruit8[1] = "Quỹ vaccine...";
        fruit8[2] = "- 1.5 ETH";
        resultList.add(fruit8);

        return  resultList;
    }
    //
}