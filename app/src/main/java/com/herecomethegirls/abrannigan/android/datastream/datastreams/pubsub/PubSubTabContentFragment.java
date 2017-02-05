package com.herecomethegirls.abrannigan.android.datastream.datastreams.pubsub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class PubSubTabContentFragment extends Fragment {
    private PubSubListAdapter psAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(com.herecomethegirls.abrannigan.android.datastream.datastreams.R.layout.fragment_pubsub, container, false);
        ListView listView = (ListView) view.findViewById(com.herecomethegirls.abrannigan.android.datastream.datastreams.R.id.message_list);
        listView.setAdapter(psAdapter);

        return view;
    }

    public void setAdapter(PubSubListAdapter psAdapter) {
        this.psAdapter = psAdapter;
    }
}
