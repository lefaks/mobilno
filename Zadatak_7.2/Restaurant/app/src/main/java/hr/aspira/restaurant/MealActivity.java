package hr.aspira.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MealActivity extends AppCompatActivity {

    public static final String EXTRA_MEALID = "mealId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        int mealId = getIntent().getExtras().getInt(EXTRA_MEALID);
        Meal meal = Meal.meals[mealId];

        TextView nameLabel = findViewById(R.id.name);  //spremimo samo komponentu ne i njenu vrijednost?
        nameLabel.setText(meal.getName());    //zašto koristim set Text tu ?? Ne može drugačije?

        TextView descLabel = findViewById(R.id.description);
        descLabel.setText(meal.getDescription());

        ImageView image = findViewById(R.id.photo);
        image.setImageResource(meal.getImageId());
        image.setContentDescription(meal.getName());
    }
}


