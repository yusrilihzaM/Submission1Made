package com.yusril.submission1;

import android.os.Parcel;
import android.os.Parcelable;

public class FilmModel implements Parcelable {
    private int photo;
    private String name;
    private String description;

    public FilmModel() {
    }

    public FilmModel(int photo, String name, String description) {
        this.photo = photo;
        this.name = name;
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.name);
        dest.writeString(this.description);
    }

    protected FilmModel(Parcel in) {
        this.photo = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<FilmModel> CREATOR = new Parcelable.Creator<FilmModel>() {
        @Override
        public FilmModel createFromParcel(Parcel source) {
            return new FilmModel(source);
        }

        @Override
        public FilmModel[] newArray(int size) {
            return new FilmModel[size];
        }
    };
}
