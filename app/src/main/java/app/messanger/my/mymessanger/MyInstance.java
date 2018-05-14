package app.messanger.my.mymessanger;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by burovg on 16/11/2016.
 */

public class MyInstance extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh(){
        Intent intent = new Intent(this,MyRegisterService.class);
        startService(intent);
    }
}
