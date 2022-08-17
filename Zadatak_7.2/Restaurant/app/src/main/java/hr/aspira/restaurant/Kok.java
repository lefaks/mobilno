package hr.aspira.restaurant;

import androidx.annotation.NonNull;

public class Kok {

    private String name;
    private String description;
    private int imageId;

    public static Kok[] koki = {

            new Kok("Streptococcus aureus", "Mrsa", R.drawable.staphylococcus_aureus),
            new Kok("Staphylococcus pneumoniae", "Zajeban", R.drawable.streptococcus_pneumoniae),
            new Kok("Staphylococcus pneumoniae", "Zajeban", R.drawable.streptococcus_pneumoniae)


    };

    public Kok(String name, String description, int imageId) {
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
