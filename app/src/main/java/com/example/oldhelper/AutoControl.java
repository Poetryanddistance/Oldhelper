package com.example.oldhelper;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AutoControl extends AppCompatActivity {

    @BindView(R.id.auto_warning_text)
    ImageView autoWarningText;
    @BindView(R.id.auto_start_button)
    Button autoStartButton;
    private SendUitl sendUitl;
    private boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_control);
        ButterKnife.bind(this);
        autoWarningText.setImageResource(R.drawable.start_text);
        flag = !flag;
        sendUitl = new SendUitl(AutoControl.this);
    }

    @OnClick(R.id.auto_start_button)
    public void onViewClicked() {
        if (flag){
            autoWarningText.setImageResource(R.drawable.start_successfully);
            sendUitl.sendInstruction(SendUitl.AUTO_START);
        }else{
            autoWarningText.setImageResource(R.drawable.start_text);
            sendUitl.sendInstruction(SendUitl.AUTO_STOP);
        }
        flag = !flag;
    }
}
