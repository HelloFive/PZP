/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mapdemo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * The main activity of the API library demo gallery.
 * <p>
 * The main layout lists the demonstrated features, with buttons to launch them.
 */
public final class MainActivity extends AppCompatActivity {


    /**
     * A custom array adapter that shows a {@link FeatureView} containing details about the demo.
     */
//    private static class CustomArrayAdapter extends ArrayAdapter<DemoDetails> {

        /**
         * @param demos An array containing the details of the demos to be displayed.
         */
/*        public CustomArrayAdapter(Context context, DemoDetails[] demos) {
            super(context, R.layout.feature, R.id.title, demos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            FeatureView featureView;
            if (convertView instanceof FeatureView) {
                featureView = (FeatureView) convertView;
            } else {
                featureView = new FeatureView(getContext());
            }

            DemoDetails demo = getItem(position);

            featureView.setTitleId(demo.titleId);
            featureView.setDescriptionId(demo.descriptionId);

            Resources resources = getContext().getResources();
            String title = resources.getString(demo.titleId);
            String description = resources.getString(demo.descriptionId);
            featureView.setContentDescription(title + ". " + description);

            return featureView;
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        /*ListView list = (ListView) findViewById(R.id.list);

        ListAdapter adapter = new CustomArrayAdapter(this, DemoDetailsList.DEMOS);

        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        list.setEmptyView(findViewById(R.id.empty));*/
        startActivity(new Intent(this, BasicMapDemoActivity.class));
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == R.id.menu_legal) {
            startActivity(new Intent(this, LegalInfoActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DemoDetails demo = (DemoDetails) parent.getAdapter().getItem(position);
        startActivity(new Intent(this, demo.activityClass));
    }*/
}



//public final class MainActivity extends AppCompatActivity
//        implements AdapterView.OnItemClickListener {
//
//
//    /**
//     * A custom array adapter that shows a {@link FeatureView} containing details about the demo.
//     */
//    private static class CustomArrayAdapter extends ArrayAdapter<DemoDetails> {
//
//        /**
//         * @param demos An array containing the details of the demos to be displayed.
//         */
//        public CustomArrayAdapter(Context context, DemoDetails[] demos) {
//            super(context, R.layout.feature, R.id.title, demos);
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            FeatureView featureView;
//            if (convertView instanceof FeatureView) {
//                featureView = (FeatureView) convertView;
//            } else {
//                featureView = new FeatureView(getContext());
//            }
//
//            DemoDetails demo = getItem(position);
//
//            featureView.setTitleId(demo.titleId);
//            featureView.setDescriptionId(demo.descriptionId);
//
//            Resources resources = getContext().getResources();
//            String title = resources.getString(demo.titleId);
//            String description = resources.getString(demo.descriptionId);
//            featureView.setContentDescription(title + ". " + description);
//
//            return featureView;
//        }
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        ListView list = (ListView) findViewById(R.id.list);
//
//        ListAdapter adapter = new CustomArrayAdapter(this, DemoDetailsList.DEMOS);
//
//        list.setAdapter(adapter);
//        list.setOnItemClickListener(this);
//        list.setEmptyView(findViewById(R.id.empty));
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        if (item.getItemId() == R.id.menu_legal) {
//            startActivity(new Intent(this, LegalInfoActivity.class));
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        DemoDetails demo = (DemoDetails) parent.getAdapter().getItem(position);
//        startActivity(new Intent(this, demo.activityClass));
//    }
//}