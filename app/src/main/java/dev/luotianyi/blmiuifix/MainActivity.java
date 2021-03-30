package dev.luotianyi.blmiuifix;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((WebView) findViewById(R.id.main_webview)).loadUrl("file:///android_asset/index.html");
    }
}