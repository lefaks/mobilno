package hr.aspira.restaurant;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "meal")
public class Meal {

    @PrimaryKey(autoGenerate = true)
    private Integer _id;

    private String name;
    private String description;
    private int imageId;

    @Ignore
    public static Meal[] meals = {
            new Meal("Steak", "Beef steak with green pepper sauce", R.drawable.steak),
            new Meal("Chicken", "Marinated chicken wings with BBQ sauce", R.drawable.chicken),
            new Meal("Salad", "Mixed salad with a dash of aceto balsamico", R.drawable.salad)
    };

    public Meal(String name, String description, int imageId) {
        this.name = name;
        this.description = description;
        this.imageId = imageId;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
