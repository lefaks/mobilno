
package hr.aspira.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        ListView listMeals = findViewById(R.id.mealsList);
        listMeals.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Meal.meals
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
}