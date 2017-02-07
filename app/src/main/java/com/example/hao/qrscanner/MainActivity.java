package com.example.hao.qrscanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends Activity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mscan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public  void onClick(View v){
        mscan = new ZXingScannerView(this);
        setContentView(mscan);
        mscan.setResultHandler(this);
        mscan.startCamera();
    }
    @Override
    public void onPause(){
        super.onPause();
        mscan.stopCamera();
    }
    @Override
    public void handleResult (Result result){
        //do anything with result here
        Log.v("handleResult",result.getText());
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Scan result");
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

        //resume scanning
        //mscan.resumeCameraPreview(this);
    }
}
