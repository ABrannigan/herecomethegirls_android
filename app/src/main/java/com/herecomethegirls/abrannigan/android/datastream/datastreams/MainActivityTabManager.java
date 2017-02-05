package com.herecomethegirls.abrannigan.android.datastream.datastreams;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.herecomethegirls.abrannigan.android.datastream.datastreams.presence.PresenceTabContentFragment;
import com.google.common.collect.ImmutableList;
import com.herecomethegirls.abrannigan.android.datastream.datastreams.multi.MultiListAdapter;
import com.herecomethegirls.abrannigan.android.datastream.datastreams.multi.MultiTabContentFragment;
import com.herecomethegirls.abrannigan.android.datastream.datastreams.presence.PresenceListAdapter;
import com.herecomethegirls.abrannigan.android.datastream.datastreams.pubsub.PubSubListAdapter;
import com.herecomethegirls.abrannigan.android.datastream.datastreams.pubsub.PubSubTabContentFragment;

import java.util.List;

public class MainActivityTabManager extends FragmentStatePagerAdapter {
    private final PubSubTabContentFragment pubsub = new PubSubTabContentFragment();
    private final PresenceTabContentFragment presence = new PresenceTabContentFragment();
    private final MultiTabContentFragment multi = new MultiTabContentFragment();

    private List<Fragment> items = ImmutableList.of(pubsub, presence, multi);

    public MainActivityTabManager(FragmentManager fm, int NumOfTabs) {
        super(fm);
    }

    public void setPubSubAdapter(PubSubListAdapter psAdapter) {
        this.pubsub.setAdapter(psAdapter);
    }

    public void setPresenceAdapter(PresenceListAdapter prAdapter) {
        this.presence.setAdapter(prAdapter);
    }

    public void setMultiAdapter(MultiListAdapter mlAdapter) {
        this.multi.setAdapter(mlAdapter);
    }

    @Override
    public Fragment getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public int getCount() {
        return this.items.size();
    }
}
