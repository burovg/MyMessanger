package app.messanger.my.mymessanger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mReceiver;
    private boolean mRegistered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String token = intent.getStringExtra("token");
                EditText txtToken = (EditText)findViewById(R.id.txtToken);
                txtToken.setText(token);
            }
        };
        registerReceiver();
        Intent service = new Intent(this,MyRegisterService.class);
        startService(service);
    }

    private void registerReceiver(){
        if(!mRegistered){
            LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver,new IntentFilter("messanger"));
            mRegistered = true;
        }
    }

    @Override
    public void onPause()
    {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
        mRegistered = false;
        super.onPause();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        registerReceiver();
    }
}
