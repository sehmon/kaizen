package apps.sehmon.com.kaizen;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sehmon on 12/24/14.
 */
public class KaizenFragment extends Fragment {

    ArrayAdapter<String> mAmTaskAdapter;
    ArrayAdapter<String> mPmTaskAdapter;

    public KaizenFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.kaizen_fragment, container, false);

        String[] tasks = {
                "Take your vitamins",
                "Eat 2 bananas",
                "Talk to your doctor",
                "Make amends",
                "Liberate Cuba"
        };

        List<String> amTasks = new ArrayList<String> (Arrays.asList(tasks));
        List<String> pmTasks = new ArrayList<String> (Arrays.asList(tasks));

        mAmTaskAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.task_list_item,
                R.id.list_item_textview,
                amTasks
        );

        mPmTaskAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.task_list_item,
                R.id.list_item_textview,
                pmTasks
        );

        ListView amListView = (ListView) rootView.findViewById(R.id.am_listview);
        ListView pmListView = (ListView) rootView.findViewById(R.id.pm_listview);

        amListView.setAdapter(mAmTaskAdapter);
        pmListView.setAdapter(mPmTaskAdapter);

        return rootView;
    }
}
