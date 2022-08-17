package hr.aspira.restaurant.dao;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hr.aspira.restaurant.Meal;

@Dao
public interface MealDao {

    @Query("SELECT * FROM meal")
    List<Meal> getMealList();

    @Query("SELECT * FROM meal")
    Cursor getMealListCursor();

    @Query("SELECT * FROM meal WHERE _id = :id")
    Cursor findByIdCursor(Integer id);

    @Query("SELECT * FROM meal WHERE _id = :id")
    Meal findById(Integer id);

    @Insert
    void insertMeal(Meal meal);

    @Insert
    void insertAll(Meal... meals);

    @Update
    void updateMeal(Meal meal);

    @Delete
    void deleteMeal(Meal meal);
}
