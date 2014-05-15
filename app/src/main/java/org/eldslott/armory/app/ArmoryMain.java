package org.eldslott.armory.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.JsonReader;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import org.eldslott.armory.entity.Versions;
import org.eldslott.armory.network.VersionsTask;
import org.eldslott.armory.network.VersionsReader;
import org.json.JSONArray;

/**
 * Main activity, handles the tabs.
 */
public class ArmoryMain extends ActionBarActivity implements CallbackActivity {
    private Fragment searchTab = new SearchTab();
    private Fragment resultTab = new ResultTab();
    private Fragment detailsTab = new DetailsTab();

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

        checkDatabaseVersion();
    }

    private void checkDatabaseVersion() {
        new VersionsTask(this).execute("http://10.0.2.2:3000/versions.json");
    }

    @Override
    public void taskCallback(Class<?> taskClass, JSONArray jsonArray) {
        if (!VersionsTask.class.equals(taskClass)) {
            return;
        }

        Versions version = new VersionsReader().read(jsonArray);
        Toast.makeText(getBaseContext(), "Version: " + version.toString(), Toast.LENGTH_LONG).show();
        TextView versionTextView = (TextView)findViewById(R.id.tab_search_versions);
        versionTextView.setText("Verions: " + version.toString());
    }

    /**
     * Inflate the menu; this adds items to the action bar if it is present.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.armory_main, menu);
        return true;
    }

    /**
     * Handle action bar item clicks here. The action bar will
     * automatically handle clicks on the Home/Up button, so long
     * as you specify a parent activity in AndroidManifest.xml.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
