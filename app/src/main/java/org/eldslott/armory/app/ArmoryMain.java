package org.eldslott.armory.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import org.eldslott.armory.event.EventMultiplexer;
import org.eldslott.armory.event.event.CheckBackendVersionsEvent;

/**
 * Main activity, handles the tabs.
 */
public class ArmoryMain extends ActionBarActivity {
    private EventMultiplexer eventMultiplexer = new EventMultiplexer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_creature);
        checkDatabaseVersion();
    }

    private void checkDatabaseVersion() {
        eventMultiplexer.onEvent(new CheckBackendVersionsEvent());
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
