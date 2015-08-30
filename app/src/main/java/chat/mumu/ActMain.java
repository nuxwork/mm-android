package chat.mumu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class ActMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        String token = "+7q4otDCzFtG1n/IpCZXDAIdlv+4aA3Wom5Oa0mOqyDvpHE3QglQnSBrkTV870hp2Tfem+yF4dOt0T7P7nsYMw==";//test
        httpGetTokenSuccess(token);
    }

    private void httpGetTokenSuccess(String token) {

    /* IMKit SDK调用第二步 建立与服务器的连接 */

    /* 集成和测试阶段，您可以直接使用从您开发者后台获取到的 token，比如 String token = “d6bCQsXiupB......”; */
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onSuccess(String userId) {
        /* 连接成功 */
                Toast.makeText(ActMain.this, "成功", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onError(RongIMClient.ErrorCode e) {
        /* 连接失败，注意并不需要您做重连 */
                Toast.makeText(ActMain.this, "onError", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTokenIncorrect() {
                Toast.makeText(ActMain.this, "onTokenIncorrect", Toast.LENGTH_SHORT).show();
        /* Token 错误，在线上环境下主要是因为 Token 已经过期，您需要向 App Server 重新请求一个新的 Token */
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.act_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
