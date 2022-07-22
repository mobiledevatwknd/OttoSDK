
package com.otto.sdk.model.menu;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "features"
})
@Generated("jsonschema2pojo")
public class Menu implements Serializable, Parcelable
{

    @JsonProperty("features")
    private List<Feature> features = null;
    public final static Creator<Menu> CREATOR = new Creator<Menu>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Menu createFromParcel(android.os.Parcel in) {
            return new Menu(in);
        }

        public Menu[] newArray(int size) {
            return (new Menu[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4799763356458147338L;

    protected Menu(android.os.Parcel in) {
        in.readList(this.features, (com.otto.sdk.model.menu.Feature.class.getClassLoader()));
    }

    public Menu() {
    }

    @JsonProperty("features")
    public List<Feature> getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Menu.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("features");
        sb.append('=');
        sb.append(((this.features == null)?"<null>":this.features));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(features);
    }

    public int describeContents() {
        return  0;
    }

}
