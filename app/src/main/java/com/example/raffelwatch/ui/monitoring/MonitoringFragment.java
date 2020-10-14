package com.example.raffelwatch.ui.monitoring;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.raffelwatch.R;

public class MonitoringFragment extends Fragment {

    private MonitoringViewModel monitoringViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        monitoringViewModel =
                ViewModelProviders.of(this).get(MonitoringViewModel.class);
        View root = inflater.inflate(R.layout.fragment_monitoring, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        monitoringViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}