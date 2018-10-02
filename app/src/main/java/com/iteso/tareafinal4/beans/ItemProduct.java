package com.iteso.tareafinal4.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemProduct implements Parcelable{
    private int code;
    private int image;
    private String title;
    private String store;
    private String location;
    private String Phone;
    private String description;

    public ItemProduct(){

    }

    protected ItemProduct(Parcel in) {
        code = in.readInt();
        image = in.readInt();
        title = in.readString();
        store = in.readString();
        location = in.readString();
        Phone = in.readString();
        description = in.readString();
    }

    public void setCode(int code){
        this.code = code;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode(){
        return code;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getStore() {
        return store;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return Phone;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return "ItemProduct{image="+this.image+",title='"+this.getTitle()+"', store='"+this.store+"', location='"+this.location+
                "', phone='"+this.Phone+"', description='"+this.description+"'}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(code);
        parcel.writeInt(image);
        parcel.writeString(title);
        parcel.writeString(store);
        parcel.writeString(location);
        parcel.writeString(Phone);
        parcel.writeString(description);
    }

    public static final Creator<ItemProduct> CREATOR = new Creator<ItemProduct>() {
        @Override
        public ItemProduct createFromParcel(Parcel in) {
            return new ItemProduct(in);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };
}
