package com.project.aaron.verizontest;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Revilla on 11/13/2016.
 */

public class MainActivity extends AppCompatActivity {

    private List<AppInfo> listAppsInfo;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        listAppsInfo = new ArrayList<>();

        PackageManager pm = getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = getPackageManager().queryIntentActivities(mainIntent, 0);
        for(ResolveInfo info : resolveInfos) {
            ApplicationInfo applicationInfo = info.activityInfo.applicationInfo;
            //get the information about the application
            if(applicationInfo.packageName != null){
                AppInfo app = getAppInfo(applicationInfo.packageName);
                app.setAppImg(info.loadIcon( getPackageManager()));
                app.setPkgName( applicationInfo.packageName);
                listAppsInfo.add(app);
            }

        }

        //Create adapter and set to recycler view
        RVAdapter adapter = new RVAdapter(listAppsInfo, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));


    }


    /*
     *Call system and get the information about the battery usage for each app
     */
    public AppInfo getAppInfo(String pkgName){
        Process process = null;
        AppInfo app = new AppInfo();

        try {
            process = Runtime.getRuntime().exec("adb shell dumpsys batterystats --charged " + pkgName);

            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(process.getInputStream()));


            StringBuilder strBuilder = new StringBuilder();
            String line = "";
            while( (line = bufferedReader.readLine()) != null){
                strBuilder.append(line);

                if(line.contains("Time on battery")){
                    app.setTimeOnBattery( line);
                }
                else if(line.contains("Mobile total received")){
                    app.setMobileData( line);
                }
                else if(line.contains("Wi-Fi total received")){
                    app.setWifiData( line);
                }
                else if(line.contains("WiFi Power drain")){
                    app.setPowerDrain( line);
                }

            }

            app.setDumpsys(strBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return app;
    }

}
