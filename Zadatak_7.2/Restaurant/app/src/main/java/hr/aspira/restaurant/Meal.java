package hr.aspira.restaurant;

import androidx.annotation.NonNull;

public class Meal {

    private String name;
    private String description;
    private int imageId;

    public static Meal[] meals = {
            new Meal("Escherichia coli", "Bakterija kojoj je stanište probavni trakt sisavaca", R.drawable.escherichia),
            new Meal("Salmonella Typhi", "Uzrocnik visoko zarazne bolesti, tifusne groznice", R.drawable.salmonellatyphi),
            new Meal("Borellia burgdorferi", "Prenosi se na covjeka ako ga ugrize kroelj i odstoji minimalno 24  sata", R.drawable.borrelia)


    };

    public Meal(String name, String description, int imageId) {
        this.name = name;
        this.description = description;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageId() {
        return imageId;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
