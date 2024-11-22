package com.obedcodes.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.annotation.SuppressLint
import android.view.Gravity
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/


        Toast.makeText(this,"Made by ObedTech!",Toast.LENGTH_LONG).show()
        val webView = findViewById<WebView>(R.id.webView)
        // Let us not be recognized using an Android device
        val webSettings: WebSettings = webView.settings

        // Set a custom user agent to simulate a desktop browser
        webSettings.userAgentString =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"

        webSettings.cacheMode = WebSettings.LOAD_DEFAULT
        webSettings.databaseEnabled = true
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

        // Enable JavaScript if needed
        webSettings.javaScriptEnabled = true

        // Load your URL
        webView.loadUrl("https://web.whatsapp.com/")
        // Enable JavaScript in the WebView
        webView.settings.javaScriptEnabled = true

        // Set a WebViewClient to open links within the app
        webView.webViewClient = WebViewClient()

        // Set a WebChromeClient to handle progress and title changes
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                // Handle progress changes if needed
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                // Handle title changes if needed
            }
        }


    }

        // Load a default URL when the app starts
      //  webView.loadUrl("https://web.whatsapp.com/")

       /* // Set up pull-to-refresh functionality
        val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener {
            webView.reload()
        }

        // Set up navigation buttons
        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            if (webView.canGoBack()) {
                webView.goBack()
            }
        }

        val forwardButton = findViewById<ImageButton>(R.id.forwardButton)
        forwardButton.setOnClickListener {
            if (webView.canGoForward()) {
                webView.goForward()
            }
        }
    }*/

   /* // Override onBackPressed to handle WebView navigation
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }*/


}