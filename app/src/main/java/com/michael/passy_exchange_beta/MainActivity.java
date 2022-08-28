package com.michael.passy_exchange_beta;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.michael.passy_exchange_beta.ui.Notifications.UserNotificationFragment;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    ActionBarDrawerToggle mDrawerToggle;
    String lastName, firstName;

    TextView Greeting, UserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);

        Greeting = findViewById(R.id.hello_nav_bar);
        UserName = findViewById(R.id.name_nav_bar);

        toolbar = findViewById(R.id.toolbar);
        ImageView bell = toolbar.findViewById(R.id.not_bell);
        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new UserNotificationFragment(),4);
            }
        });

        setupToolbar();

        NavItem[] drawerItem = new NavItem[5];

        drawerItem[0] = new NavItem("Yootopia", R.drawable.dashboard);
        drawerItem[1] = new NavItem("Sneak Peeks", R.drawable.dashboard);
        drawerItem[2] = new NavItem("Your Profile", R.drawable.post);
        drawerItem[3] = new NavItem("Events", R.drawable.post);
        drawerItem[4] = new NavItem("Logout", R.drawable.ic_outline_exit_to_app_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();

        selectItem(0);

        //code to load the user details
        getUserProfile getUserProfile = new getUserProfile();
        getUserProfile.execute();

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private boolean loadFragment(Fragment fragment, int position){
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawers();

            return true;
        }
        return false;
    }

    private boolean selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new BuyCoinsFragment();
                break;
            case 1:
                fragment = new SellCoinsFragment();
                break;
            case 2:
                fragment = new PendingOrdersFragment();
                break;
            case 3:
                fragment = new TestFragment();
                break;
            case 4:
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            default:
                break;
        }
        return loadFragment(fragment, position);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    void setupToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle(){
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

    public class getUserProfile extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {

            OkHttpClient okHttpClient = new OkHttpClient();

            SharedPreferences sharedP = getApplicationContext().getSharedPreferences("TOKEN", Context.MODE_PRIVATE);
            String token = sharedP.getString("token", "Token");
            String userId = sharedP.getString("userId", "UserId");
            String LasttName = "";
            String aasttName = "";
            String dataResult = "";
            Log.i("token", token);
            Log.i("userid", userId);

            Request request = new Request.Builder()
                    .url("https://hngboard.herokuapp.com/users/" + userId + "/profile")
                    .header("Authorization", "Bearer "  + token )
                    .build();

            try {
                Response response = okHttpClient.newCall(request).execute();
                String responsebody = response.body().string();
                Log.i("userRBody", responsebody);

                JSONObject jsonObject = new JSONObject(responsebody);
                dataResult = jsonObject.getString("data");

                JSONObject dataObject = new JSONObject(dataResult);
                String LastName = dataObject.getString("lastName");

                SharedPreferences.Editor editor = sharedP.edit();
                editor.putString("lastName", LastName);

            }catch (Exception e){
                e.printStackTrace();
            }


            return dataResult;
        }

        @Override
        protected void onPostExecute(String dataResult) {

            try {
                JSONObject dataObject = new JSONObject(dataResult);
                String LasttName = dataObject.getString("lastName");
                String FirstName = dataObject.getString("firstName");
                String HngID = dataObject.getString("hngId");

                Greeting.setText("Hello " + LasttName);
                UserName.setText(FirstName + " " + LasttName);


            }catch (Exception e){
                e.printStackTrace();
            }


            super.onPostExecute(dataResult);
        }
    }

}