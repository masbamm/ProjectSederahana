package iqbalyusuf.id.masjidku;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private AnimationDrawable animationDrawable;

    EditText editText1 ,editText2;
    CheckBox checkbox1;
    String text1 ,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout);
        animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(3000);

        editText2 = (EditText) findViewById(R.id.password);
        checkbox1 = (CheckBox) findViewById(R.id.checkBox);


        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    editText2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        if(animationDrawable != null && !animationDrawable.isRunning()){
            animationDrawable.start();
        }

    }

    public void login(View view) {
        editText1 = (EditText)findViewById(R.id.username);
        editText2 = (EditText) findViewById(R.id.password);
        text1 = editText1.getText().toString();
        text2 = editText2.getText().toString();

        if ((text1.contains("admin"))&&((text2.contains("admin"))))

        {
            Toast.makeText(this, "Anda Berhasil Login", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        else if ((text1.matches("")||text2.matches("")))

        {
            Toast.makeText(this, "Isikan Username dan Password", Toast.LENGTH_SHORT).show();
        }

        else

        {
            Toast.makeText(this, "Maaf Username/Password Salah", Toast.LENGTH_SHORT).show();
        }

    }


}
