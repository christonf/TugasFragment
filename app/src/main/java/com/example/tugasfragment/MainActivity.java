package com.example.tugasfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    TextView text;
    private Boolean isFragmentDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.k_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFragmentDisplayed) {
                    displayFragment();
                }
                else {
                    closeFragment();
                }
            }
        });
    }

    public void displayFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager.findFragmentById(R.id.fragment);

        fragmentTransaction.replace(R.id.fragment, simpleFragment).commit();

        isFragmentDisplayed =true;
        text = findViewById(R.id.content);
        text.setText(R.string.kelebihan);
        mButton.setText(R.string.mantap);
    }

    public void closeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager.findFragmentById(R.id.fragment);

        if (simpleFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, simpleFragment).commit();
        }

        isFragmentDisplayed = false;
        text = findViewById(R.id.content);
        text.setText(R.string.content);
        mButton.setText(R.string.b_kelebihan);
    }
}