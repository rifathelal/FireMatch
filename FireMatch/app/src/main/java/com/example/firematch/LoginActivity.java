package com.example.firematch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    View root;
    EditText emailET;
    EditText passwordET;
    Button loginBtn;
    ImageView logoIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        root = findViewById(R.id.root_login);
        emailET = findViewById(R.id.tv_email);
        passwordET = findViewById(R.id.tv_password);
        loginBtn = findViewById(R.id.btn_login);
        logoIV = findViewById(R.id.imv_logo);

        root.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                root.getWindowVisibleDisplayFrame(r);
                int heightDiff = root.getRootView().getHeight() - (r.bottom - r.top);
                hideLogo(heightDiff > 0.25*root.getRootView().getHeight());
            }
        });
    }

    private void hideLogo(boolean state) {
        if (state) {
            logoIV.setAdjustViewBounds(false);
            logoIV.setScaleType(ImageView.ScaleType.CENTER);
            logoIV.setImageResource(R.drawable.logo_vector);
        }
        else {
            logoIV.setAdjustViewBounds(true);
            logoIV.setImageResource(R.drawable.logo_firematch);
            logoIV.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }
}
