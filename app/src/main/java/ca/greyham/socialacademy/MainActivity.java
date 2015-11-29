package ca.greyham.socialacademy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonFindProject_Click(View v)
    {
        Intent pitchscrollactivity = new Intent(MainActivity.this, pitchscrollactivity.class);
//        DeadDrop newDeaddrop = new DeadDrop();
//        startCardViewActivity.putExtra("DeadDrop", newDeaddrop.toString());
        startActivity(pitchscrollactivity);
    }

}
