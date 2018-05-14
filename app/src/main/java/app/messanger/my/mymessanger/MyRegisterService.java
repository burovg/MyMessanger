package app.messanger.my.mymessanger;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyRegisterService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_FOO = "app.messanger.my.mymessanger.action.FOO";
    public static final String ACTION_BAZ = "app.messanger.my.mymessanger.action.BAZ";

    // TODO: Rename parameters
    public static final String EXTRA_PARAM1 = "app.messanger.my.mymessanger.extra.PARAM1";
    public static final String EXTRA_PARAM2 = "app.messanger.my.mymessanger.extra.PARAM2";

    public MyRegisterService() {
        super("MyRegisterService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            InstanceID instanceID = InstanceID.getInstance(this);
            try {
                String token = instanceID.getToken("538468401953", GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
                Intent lintent = new Intent("messanger");
                lintent.putExtra("token",token);
                LocalBroadcastManager.getInstance(this).sendBroadcast(lintent);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
