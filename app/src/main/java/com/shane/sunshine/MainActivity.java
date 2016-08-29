package com.shane.sunshine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) attachMainFragment();
    }

    private void attachMainFragment() {
        Fragment fragment = MainFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, fragment, fragment.getTag())
                .commit();
    }

    public static class MainFragment extends Fragment {

        public MainFragment() {
        }

        public static MainFragment newInstance() {
            return new MainFragment();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            List<String> weekForecast = generateDummyForecastData();
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, weekForecast);
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(arrayAdapter);
            return rootView;
        }

        private List<String> generateDummyForecastData() {
            return new ArrayList<>(Arrays.asList("Today - Sunny - 88/63",
                    "Tomorrow - Foggy - 70/46",
                    "Weds - Cloudy - 72/63",
                    "Thurs - Rainy - 64/51",
                    "Fri - Foggy - 70/46",
                    "Sat - Sunny - 76/68"));
        }
    }
}
