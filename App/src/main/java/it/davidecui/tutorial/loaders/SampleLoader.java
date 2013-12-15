package it.davidecui.tutorial.loaders;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davide on 15/12/13.
 */
public class SampleLoader extends AsyncTaskLoader<List<String>> {

    public SampleLoader(Context context) {
        super(context);
    }

    @Override
    public List<String> loadInBackground() {
        final String[] animals = new String[] { "Ape", "Bird", "Cat", "Dog", "Elephant","Fox",
                "Gorilla", "Hyena", "Inch Worm", "Jackalope", "King Salmon","Lizard",
                "Monkey", "Narwhal", "Octopus", "Pig", "Quail", "Rattle Snake", "Salamander",
                "Tiger", "Urchin", "Vampire Bat", "Wombat", "X-Ray Tetra", "Yak", "Zebra"};

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < animals.length; ++i) {
            list.add(animals[i]);
            try {
                Thread.sleep(100); //simulated network delay
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }
}
