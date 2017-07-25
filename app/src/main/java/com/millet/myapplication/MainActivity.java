package com.millet.myapplication;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText mEditText;
    private Button mButton1, mButton2;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEditText = (EditText) findViewById(R.id.edit);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
        mImageView = (ImageView) findViewById(R.id.image);
        mImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View _view) {
        int _id = _view.getId();
        switch (_id) {
            case R.id.button1:
                String _string = mEditText.getText().toString();
                Toast.makeText(this, "输入的文字为：" + _string, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                String patchPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk";
                File file = new File(patchPath);
                boolean is = file.exists();
                Toast.makeText(this, "是否存在：" + is + "地址是：" + patchPath, Toast.LENGTH_SHORT).show();
                if (file.exists()) {
                    Log.v(TAG, "补丁文件存在");
                    TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), patchPath);
                } else {
                    Log.v(TAG, "补丁文件不存在");
                }
                break;
            case R.id.image:
                SecondActivity.launch(this);
                break;
        }
    }

}
