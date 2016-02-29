package com.brunodevesa.stringformatresources;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView m_content_main_tv_counting, m_content_main_tv_squareRootResult;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_content_main_tv_counting = (TextView)findViewById(R.id.content_main_tv_counting);
        m_content_main_tv_squareRootResult = (TextView)findViewById(R.id.content_main_tv_squareRootResult);

        Button m_content_main_btn_clickMe = (Button) findViewById(R.id.content_main_btn_clickMe);
        m_content_main_btn_clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tv_counting_format = getResources().getString(R.string.tv_format_counting);
                String tv_counting_msg = String.format(tv_counting_format, counter);
                m_content_main_tv_counting.setText(tv_counting_msg);

                Float squareRootResult = (float) Math.sqrt(counter);
                String tv_squareRootResult_format = getResources().getString(R.string.tv_format_squareResult);
                String tv_squareRootResult_msg = String.format(tv_squareRootResult_format, counter, squareRootResult);
                m_content_main_tv_squareRootResult.setText(tv_squareRootResult_msg);

                counter++;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
