package hr.aspira.restaurant.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

import hr.aspira.restaurant.Meal;
import hr.aspira.restaurant.dao.MealDao;

@Database(entities = {Meal.class}, exportSchema = false, version = 1)
public abstract class RestaurantDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "db_restaurant";
    private static RestaurantDatabase restaurantDatabase;

    public static synchronized RestaurantDatabase getInstance(final Context context) {
        if(restaurantDatabase == null) {
            restaurantDatabase = Room.databaseBuilder(context.getApplicationContext(), RestaurantDatabase.class, DATABASE_NAME)
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);

                            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                @Override
                                public void run() {
                                    String firstRow = String.format("INSERT INTO meal(\"name\", \"description\", \"imageId\") VALUES(\"%s\", \"%s\", %d)",
                                            Meal.meals[0].getName(), Meal.meals[0].getDescription(), Meal.meals[0].getImageId());
                                    String secondRow = String.format("INSERT INTO meal(\"name\", \"description\", \"imageId\") VALUES(\"%s\", \"%s\", %d)",
                                            Meal.meals[1].getName(), Meal.meals[1].getDescription(), Meal.meals[1].getImageId());
                                    String thirdRow = String.format("INSERT INTO meal(\"name\", \"description\", \"imageId\") VALUES(\"%s\", \"%s\", %d)",
                                            Meal.meals[2].getName(), Meal.meals[2].getDescription(), Meal.meals[2].getImageId());
                                    db.execSQL(firstRow);
                                    db.execSQL(secondRow);
                                    db.execSQL(thirdRow);
                                }
                            });
                        }
                    })
                    .build();
        }

        return restaurantDatabase;
    }

    public abstract MealDao mealDao();
}
