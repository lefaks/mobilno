package hr.aspira.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.Executors;

import hr.aspira.restaurant.database.RestaurantDatabase;

public class MealActivity extends AppCompatActivity {

    public static final String EXTRA_MEALID = "mealId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        int mealId = getIntent().getExtras().getInt(EXTRA_MEALID);

        final Handler handler = new Handler();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                RestaurantDatabase restaurantDatabase = RestaurantDatabase.getInstance(MealActivity.this);
                final Meal meal = restaurantDatabase.mealDao().findById(mealId);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onGetMeal(meal);
                    }
                });
            }
        });
    }

    private void onGetMeal(Meal meal) {
        TextView nameLabel = findViewById(R.id.name);
        nameLabel.setText(meal.getName());

        TextView descLabel = findViewById(R.id.description);
        descLabel.setText(meal.getDescription());

        ImageView image = findViewById(R.id.photo);
        image.setImageResource(meal.getImageId());
        image.setContentDescription(meal.getName());
    }
}