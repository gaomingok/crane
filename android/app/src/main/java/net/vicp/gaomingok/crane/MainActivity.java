package net.vicp.gaomingok.crane;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import net.vicp.gaomingok.crane.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow();
        }

        webView = (WebView) findViewById(R.id.webView1);
        webView.loadUrl("file:///android_asset/index.html");
        webView.getSettings().setJavaScriptEnabled(true);//启用js
        webView.getSettings().setBlockNetworkImage(false);//解决图片不显示
        /**滚动条风格，为0指滚动条不占用空间，直接覆盖在网页上  */
        webView.setScrollBarStyle(0);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                /**返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器*/
                view.loadUrl(url);
                return true;
            }
        });
    }
}
