/*
 * This software is the confidential and proprietary information of
 * Sigma Systems Innovation. ("Confidential Information"). You shall
 * not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sigma Systems Innovation.
 *
 * COPYRIGHT (C) 2014 SIGMA SYSTEMS INNOVATION AB.
 * All rights reserved.
 */
package org.eldslott.armory.event.handlers;

import android.widget.ListView;
import org.eldslott.armory.app.R;
import org.eldslott.armory.entity.CreatureEntity;
import org.eldslott.armory.event.EventHandler;
import org.eldslott.armory.event.EventMultiplexer;
import org.eldslott.armory.event.event.PopulateUICreaturesEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public class PopulateUICreaturesEventHandler extends EventHandler<PopulateUICreaturesEvent> {
    public PopulateUICreaturesEventHandler(EventMultiplexer eventMultiplexer) {
        super(eventMultiplexer, PopulateUICreaturesEvent.class);
    }
    
    @Override
    public void onEvent(PopulateUICreaturesEvent event) {
        List<CreatureEntity> creatures = loadCreatesFromDb();
        ListView listView = (ListView)getActivity().findViewById(R.id.creatureResultView);
        /* listView.addView(view from each creatures); */
    }

    private List<CreatureEntity> loadCreatesFromDb() {
        // TODO: load from db
        List<CreatureEntity> creatures = new ArrayList<>();
        creatures.add(CreatureEntity.create(null, "Test1 Young", 40, 0.3, 5, 1, 1));
        creatures.add(CreatureEntity.create(null, "Test1 Mature", 50, 1.6, 15, 1, 2));
        creatures.add(CreatureEntity.create(null, "Test1 Old", 70, 4.3, 40, 1, 3));
        creatures.add(CreatureEntity.create(null, "Test2 Young", 120, 10.3, 50, 1, 1));
        creatures.add(CreatureEntity.create(null, "Test2 Mature", 140, 17.8, 70, 1, 2));
        creatures.add(CreatureEntity.create(null, "Test2 Old", 240, 23.1, 150, 1, 3));
        return creatures;
    }
}
