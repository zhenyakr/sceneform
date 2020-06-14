package com.google.ar.sceneform.samples.gltf;

import java.util.ArrayList;

public class Model {
    private String mTitle;
    private int mImageId;

    public Model(String title, int imageId){
        mTitle = title;
        mImageId = imageId;
    }

    public String getTitle(){
        return mTitle;
    }

    public int getImageId(){
        return mImageId;
    }


    public static ArrayList<Model> modelArrayList(){
        ArrayList<Model> models = new ArrayList<>();

        models.add(new Model("Cactus", R.drawable.cactus));
        models.add(new Model("Buster drone", R.drawable.drone));
        models.add(new Model("Macbook", R.drawable.mac));
        models.add(new Model("Tigr", R.drawable.tigr));
        models.add(new Model("Skull", R.drawable.skull));
        models.add(new Model("Weapon", R.drawable.enemy));
        models.add(new Model("Penguin", R.drawable.penguin));

        return models;
    }
}
