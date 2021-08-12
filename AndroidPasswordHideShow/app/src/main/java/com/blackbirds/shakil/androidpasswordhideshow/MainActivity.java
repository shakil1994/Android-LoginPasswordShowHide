package com.blackbirds.shakil.androidpasswordhideshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText edtPasswordTwo;
    boolean isPasswordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPasswordTwo = findViewById(R.id.edtPasswordTwo);

        showAndHidePassword();
    }

    private void showAndHidePassword() {
        edtPasswordTwo.setOnTouchListener((v, event) -> {
            final int RIGHT = 2;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (edtPasswordTwo.getRight() - edtPasswordTwo.getCompoundDrawables()[RIGHT].getBounds().width())) {
                    int selection = edtPasswordTwo.getSelectionEnd();
                    if (isPasswordVisible) {
                        // set drawable image
                        edtPasswordTwo.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_visibility_off_24, 0);
                        // hide Password
                        edtPasswordTwo.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        isPasswordVisible = false;
                    } else {
                        // set drawable image
                        edtPasswordTwo.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_visibility_24, 0);
                        // show Password
                        edtPasswordTwo.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        isPasswordVisible = true;
                    }
                    edtPasswordTwo.setSelection(selection);
                    return true;
                }
            }
            return false;
        });
    }
}