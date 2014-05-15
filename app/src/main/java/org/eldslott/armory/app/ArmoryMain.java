package org.eldslott.armory.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class ArmoryMain extends ActionBarActivity {
    Fragment searchTab = new SearchTab();
    Fragment resultTab = new ResultTab();
    Fragment detailsTab = new DetailsTab();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab actionBarSearchTab = actionBar.newTab().setText(R.string.title_tab_search);
        ActionBar.Tab actionBarResultsTab = actionBar.newTab().setText(R.string.title_tab_result);
        ActionBar.Tab actionBarDetailsTab = actionBar.newTab().setText(R.string.title_tab_details);

        actionBarSearchTab.setTabListener(new SimpleTabListener(searchTab));
        actionBarResultsTab.setTabListener(new SimpleTabListener(resultTab));
        actionBarDetailsTab.setTabListener(new SimpleTabListener(detailsTab));

        actionBar.addTab(actionBarSearchTab);
        actionBar.addTab(actionBarResultsTab);
        actionBar.addTab(actionBarDetailsTab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.armory_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
