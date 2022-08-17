package hr.aspira.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.concurrent.Executors;

import hr.aspira.restaurant.database.RestaurantDatabase;

public class FoodListActivity extends AppCompatActivity {

    private RestaurantDatabase restaurantDatabase;
    private Cursor mealCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        final Handler handler = new Handler();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                restaurantDatabase = RestaurantDatabase.getInstance(FoodListActivity.this);
                mealCursor = restaurantDatabase.mealDao().getMealListCursor();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onGetCursor(mealCursor);
                    }
                });
            }
        });
    }

    private void onGetCursor(Cursor mealCursor) {
        ListView listMeals = findViewById(R.id.mealsList);
        listMeals.setAdapter(new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                mealCursor,
                new String[]{"name"},
                new int[]{android.R.id.text1},
                0
        ));

        listMeals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FoodListActivity.this, MealActivity.class);
                intent.putExtra(MealActivity.EXTRA_MEALID, (int) id);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mealCursor.close();
        restaurantDatabase.close();
    }
}