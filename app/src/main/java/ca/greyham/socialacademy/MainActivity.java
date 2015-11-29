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
        Intent pitchScrollActivity = new Intent(MainActivity.this, PitchScrollActivity.class);
        startActivity(pitchScrollActivity);
    }

    public void buttonProfile_Click(View v)
    {
        Intent profileActivity = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(profileActivity);
    }

}
