package com.example.webview.presentation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.webview.R
import com.example.webview.data.netwok.api.ApiFactory
import com.example.webview.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val linkKey = getSharedPreferences("link", Context.MODE_PRIVATE)
        checkFirstStart(linkKey)
    }

    private fun checkFirstStart(linkKey: SharedPreferences) {
        val user = getSharedPreferences("hasVisited", Context.MODE_PRIVATE)
        val visited = user.getBoolean("hasVisited", false)
        if (!visited) {
            user.edit().putBoolean("hasVisited", true).apply()
            lifecycleScope.launch {
                disposable(linkKey)
            }
        } else {
            if (!linkKey.getBoolean("link", false)) {
                getFragment(WebViewFragment())
            } else {
                getFragment(GameFragment())
            }
        }
    }


    fun disposable(linkKey: SharedPreferences) {
        val disposable = ApiFactory.apiService.getLinkHaveKey()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    if (it.args?.key == null) {
                        linkKey.edit { putBoolean("link", false) }
                        getFragment(WebViewFragment())
                    } else {
                        linkKey.edit().putBoolean("link", true).apply()
                        getFragment(GameFragment())
                    }
                }, {
                    Log.d("MyLog", "${it.message}")
                }
            )
        compositeDisposable.add(disposable)
    }

    fun getFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_container, fragment)
            .commit()
    }

    override fun onBackPressed() {
        val webView = findViewById<WebView>(R.id.wb_webView)
        if (webView.canGoBack()) {
            webView.goBack()
        } else super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
