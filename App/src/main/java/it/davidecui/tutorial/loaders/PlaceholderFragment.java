package it.davidecui.tutorial.loaders;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<String>> {
    private static final int THE_LOADER = 0x01;
    private View rootView;

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        getLoaderManager().initLoader(THE_LOADER, null, this).forceLoad();
        return rootView;
    }

    @Override
    public Loader<List<String>> onCreateLoader(int i, Bundle bundle) {
        return new SampleLoader(this.getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<String>> listLoader, List<String> strings) {
        final ListView listview = (ListView) rootView.findViewById(R.id.listview);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, strings);
        listview.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader<List<String>> listLoader) {
        final ListView listview = (ListView) rootView.findViewById(R.id.listview);
        listview.setAdapter(null);
    }
}
