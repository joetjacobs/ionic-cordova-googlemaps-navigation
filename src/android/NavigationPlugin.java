package com.icsfl.rfsmart.navigation;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.net.Uri;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;


public class NavigationPlugin extends CordovaPlugin  {
    private static final String TAG = "NavigationPlugin";
    private CallbackContext callbackContext;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {

        super.initialize(cordova, webView);

    }

    @Override
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext)
    throws JSONException {
        if (action.equals("navigate")) {
           cordova.getActivity().runOnUiThread(new Runnable(){
            @Override
            public void run(){
              Uri gmmIntentUri = Uri.parse("google.navigation:q=Taronga+Zoo,+Sydney+Australia");
              Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
              mapIntent.setPackage("com.google.android.apps.maps");
              startActivity(mapIntent);
            }
           });
              Log.d(TAG,"Registered Successfully");
            }
            return true;
        }
         
        
    

    @Override
    public void onResume(boolean multitasking) {
        super.onResume(multitasking);
        
    }

    @Override
    public void onPause(boolean multitasking) {
        super.onPause(multitasking);
       
    }
    private Activity getActivity(){
      return this.cordova.getActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    private void NotifyError(String error) {
        if (this.callbackContext != null) {
            PluginResult result = new PluginResult(PluginResult.Status.ERROR, error);
            result.setKeepCallback(true);
            this.callbackContext.sendPluginResult(result);
        }
    }
  
}
