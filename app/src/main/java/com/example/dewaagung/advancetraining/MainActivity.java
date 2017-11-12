package com.example.dewaagung.advancetraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dewaagung.advancetraining.listener.HostToFragmentListener;

public class MainActivity extends AppCompatActivity {

    private HostToFragmentListener hostToFragmentListener;

    public void setHostToFragmentListener(HostToFragmentListener hostToFragmentListener){
        this.hostToFragmentListener = hostToFragmentListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OneFragment oneFragment = OneFragment.newInstance(0);

        /*getSupportFragmentManager().beginTransaction()
                .add(R.id.container, oneFragment,"0")
                .commit();*/

        getSupportFragmentManager().beginTransaction()
                .addToBackStack("fragment_two")
                .replace(R.id.container, new FragmentTwo(), null)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.send_to_fragment:
                hostToFragmentListener.onDataReceiveIntFragment("DATA TEST");
                break;
        }

        return true;
    }

    public void onBackPressed(){
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if(count > 0){
            getSupportFragmentManager().popBackStack();
        }else {
            super.onBackPressed();
        }
    }
}
