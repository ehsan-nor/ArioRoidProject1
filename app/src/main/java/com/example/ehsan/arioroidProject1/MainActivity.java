package com.example.ehsan.arioroidproject1;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private WifiManager wifiManager;
    private boolean wifistatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiManager = (WifiManager) this.getSystemService(WIFI_SERVICE);
        wifistatus = wifiManager.isWifiEnabled();

        if(!wifistatus)
            wifiManager.setWifiEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      wifiManager = (WifiManager) this.getSystemService(WIFI_SERVICE);
        if(!wifistatus)
            wifiManager.setWifiEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings :startActivity(new Intent(MainActivity.this,Settings.class));break;
            case R.id.aboutus:break;
        }

        return super.onOptionsItemSelected(item);
    }
}
