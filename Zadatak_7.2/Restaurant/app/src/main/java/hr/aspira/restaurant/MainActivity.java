package hr.aspira.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.categoriesList); // objekt  categories list - to ima smo dali komponenti nekoj, nekom viewu koja će imati svoje vrijednosti ---u xmlu bi tribalo <ListView> id="kategorijeLista"

        //listener se postavlja valjda na objekt koji će biti kliknut, to je u ovom slučaju View -ListView - ListView i Spinner su braća ??
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
                    startActivity(intent);
                }
                else if(position == 1) {
                    Intent intent2 = new Intent(MainActivity.this, KokiListActivity.class);
                    startActivity(intent2);
                }
            }
        });
    }
}