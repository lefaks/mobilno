package hr.aspira.restaurant;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KokiActivity extends AppCompatActivity {

    public static final String EXTRA_KOKID = "kokId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        int kokId = getIntent().getExtras().getInt(EXTRA_KOKID);

        Kok kok= Kok.koki[kokId];     //
        TextView nameLabel = findViewById(R.id.name);
        nameLabel.setText(kok.getName());

        TextView descLabel = findViewById(R.id.description);
        descLabel.setText(kok.getDescription());

        ImageView image = findViewById(R.id.photo);
        image.setImageResource(kok.getImageId());
        image.setContentDescription(kok.getName());
    }
}


