package com.drawer.gimay.drawerlayout;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleDemoActivity extends Fragment implements CompoundButton.OnCheckedChangeListener {

    private boolean toggleButtonValue = false;
    private boolean toggleSwitchValue = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        android.view.View layout = inflater.inflate(R.layout.activity_toogle_demo, container, false);



        ToggleButton toggleButton = layout.findViewById(R.id.toggle_button);
        SwitchCompat toggleSwitch = layout.findViewById(R.id.toggle_switch);

        toggleButtonValue = toggleButton.isChecked();
        toggleSwitchValue = toggleSwitch.isChecked();

        toggleButton.setOnCheckedChangeListener(this);
        toggleSwitch.setOnCheckedChangeListener(this);

        return layout;
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        String message = "";

        switch (id){
            case R.id.toggle_button:
                toggleButtonValue = isChecked;
                message = isChecked ? "Toggle Button is on" : "Toggle Button is off";
                Toast.makeText(getActivity(), "Button", Toast.LENGTH_SHORT).show();
                break;

            case R.id.toggle_switch:
                toggleSwitchValue = isChecked;
                message = isChecked ? "Switch is on" : "Switch is off";
                Toast.makeText(getActivity(), "Switch", Toast.LENGTH_SHORT).show();
                break;
        }

        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

    }
}