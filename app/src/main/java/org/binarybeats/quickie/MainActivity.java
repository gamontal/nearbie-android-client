package org.binarybeats.quickie;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabClickListener;

import org.binarybeats.quickie.fragment.ChatFragment;
import org.binarybeats.quickie.fragment.MainFragment;
import org.binarybeats.quickie.fragment.SettingsFragment;
import org.binarybeats.quickie.fragment.TrendingFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomBar mBottomBar;
    private TextView mToolbarTitle;
    private ArrayList<Fragment> mBottomBarFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setTitle("");
        }

        buildBottomBar(savedInstanceState);
    }

    private void buildBottomBar(Bundle savedInstanceState) {
        // Add tabs fragments
        mBottomBarFragments = new ArrayList<>();
        mBottomBarFragments.add(new MainFragment());
        mBottomBarFragments.add(new ChatFragment());
        mBottomBarFragments.add(new TrendingFragment());
        mBottomBarFragments.add(new SettingsFragment());

        // Attach the bottom bar to the activity.
        mBottomBar = BottomBar.attachShy((CoordinatorLayout) findViewById(R.id.coordinator_layout),
                findViewById(R.id.container), savedInstanceState);

        // Solve the top empty space.
        mBottomBar.noTopOffset();

        // Disable navigation bar transparency.
        mBottomBar.noNavBarGoodness();

        // Set tabs icons and titles.
        mBottomBar.setItems(
                new BottomBarTab(R.drawable.ic_near_me_black_24dp, R.string.tab_nearby),
                new BottomBarTab(R.drawable.ic_chat_bubble_black_24dp, R.string.tab_chat),
                new BottomBarTab(R.drawable.ic_public_black_24dp, R.string.tab_trending),
                new BottomBarTab(R.drawable.ic_settings_black_24dp, R.string.tab_settings));

        // Add colors for different tabs when there is more than three of them.
        mBottomBar.mapColorForTab(0, "#607D8B");
        mBottomBar.mapColorForTab(1, "#009688");
        mBottomBar.mapColorForTab(2, "#795548");
        mBottomBar.mapColorForTab(3, "#212121");

        // Listen for tab changes.
        mBottomBar.setOnTabClickListener(new OnTabClickListener() {
            @Override
            public void onTabSelected(int position) {
                // The user selected a tab at the specified position.
                replaceCurrentFragment(position);
            }

            @Override
            public void onTabReSelected(int position) {
                // The user reselected a tab at the specified position.
            }
        });
    }

    private void replaceCurrentFragment(int position) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, mBottomBarFragments.get(position))
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        // The action bar will automatically handle clicks on the Home/Up button,
        // so long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state,
        // otherwise we would lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);

    }
}