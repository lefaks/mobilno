
package hr.aspira.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SpiraliListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        ListView listKoki = findViewById(R.id.mealsList);
        listKoki.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Kok.koki
        ));

        listKoki.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SpiraliListActivity.this, KokiActivity.class);
                intent.putExtra(KokiActivity.EXTRA_KOKID, (int) id);
                startActivity(intent);
            }
        });
    }
}