package com.tippingcanoe.sample;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import com.etsy.android.grid.StaggeredGridView;

import java.util.Arrays;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

	    Button scrollToItemButton;
	    Button scrollToTopButton;
	    Button toggleColumnsButton;
	    StaggeredGridView staggeredGridView;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

	    @Override
	    public void onViewCreated ( View view, @Nullable Bundle savedInstanceState ) {
		    super.onViewCreated(view, savedInstanceState);

			staggeredGridView = (StaggeredGridView) view.findViewById(R.id.staggeredGrid);
		    scrollToItemButton = (Button) view.findViewById(R.id.scollToItem);
		    scrollToTopButton = (Button) view.findViewById(R.id.scrollToTop);
		    toggleColumnsButton = (Button) view.findViewById(R.id.toggleColumns);

		    staggeredGridView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Arrays.asList("lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit", "curabitur", "vel", "hendrerit", "libero", "eleifend", "blandit", "nunc", "ornare", "odio", "ut", "orci", "gravida", "imperdiet", "nullam", "purus", "lacinia", "a", "pretium", "quis", "congue", "praesent", "sagittis", "laoreet", "auctor", "mauris", "non", "velit", "eros", "dictum", "proin", "accumsan", "sapien", "nec", "massa", "volutpat", "venenatis", "sed", "eu", "molestie", "lacus", "quisque", "porttitor", "ligula", "dui", "mollis", "tempus", "at", "magna", "vestibulum", "turpis", "ac", "diam", "tincidunt", "id", "condimentum", "enim", "sodales", "in", "hac", "habitasse", "platea", "dictumst", "aenean", "neque", "fusce", "augue", "leo", "eget", "semper", "mattis", "tortor", "scelerisque", "nulla", "interdum", "tellus", "malesuada", "rhoncus", "porta", "sem", "aliquet", "et", "nam", "suspendisse", "potenti", "vivamus", "luctus", "fringilla", "erat", "donec", "justo", "vehicula", "ultricies", "varius", "ante", "primis", "faucibus", "ultrices", "posuere", "cubilia", "curae", "etiam", "cursus", "aliquam", "quam", "dapibus", "nisl", "feugiat", "egestas", "class", "aptent", "taciti", "sociosqu", "ad", "litora", "torquent", "per", "conubia", "nostra", "inceptos", "himenaeos", "phasellus", "nibh", "pulvinar", "vitae", "urna", "iaculis", "lobortis", "nisi", "viverra", "arcu", "morbi", "pellentesque", "metus", "commodo", "ut", "facilisis", "felis", "tristique", "ullamcorper", "placerat", "aenean", "convallis", "sollicitudin", "integer", "rutrum", "duis", "est", "etiam", "bibendum", "donec", "pharetra", "vulputate", "maecenas", "mi", "fermentum", "consequat", "suscipit", "aliquam", "habitant", "senectus", "netus", "fames", "quisque", "euismod", "curabitur", "lectus", "elementum", "tempor", "risus", "cras")));
	        staggeredGridView.setColumnCount(2);

		    scrollToItemButton.setOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick ( View view ) {
				    staggeredGridView.setFirstVisiblePositionSilently(50);
			    }
		    });

		    scrollToTopButton.setOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick ( View view ) {
				    staggeredGridView.smoothScrollBy(staggeredGridView.getDistanceToTop(), 1000);
			    }
		    });

		    toggleColumnsButton.setOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick ( View v ) {
				    staggeredGridView.setColumnCount(staggeredGridView.getColumnCount() == 3 ? 2 : 3);
			    }
		    });

		    staggeredGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
			    @Override
			    public void onScrollStateChanged ( AbsListView view, int scrollState ) {

			    }

			    @Override
			    public void onScroll ( AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount ) {
				   Log.v("Iain", ((StaggeredGridView) view).getDistanceToTop() + " < Distance");
			    }
		    });
	    }
    }
}
