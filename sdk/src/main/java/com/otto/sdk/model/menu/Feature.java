
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
    "key",
    "item"
})
@Generated("jsonschema2pojo")
public class Feature implements Serializable, Parcelable
{

    @JsonProperty("key")
    private String key;
    @JsonProperty("item")
    private List<Item> item = null;
    public final static Creator<Feature> CREATOR = new Creator<Feature>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Feature createFromParcel(android.os.Parcel in) {
            return new Feature(in);
        }

        public Feature[] newArray(int size) {
            return (new Feature[size]);
        }

    }
    ;
    private final static long serialVersionUID = 3779657868479285545L;

    protected Feature(android.os.Parcel in) {
        this.key = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.item, (com.otto.sdk.model.menu.Item.class.getClassLoader()));
    }

    public Feature() {
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("item")
    public List<Item> getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(List<Item> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Feature.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("key");
        sb.append('=');
        sb.append(((this.key == null)?"<null>":this.key));
        sb.append(',');
        sb.append("item");
        sb.append('=');
        sb.append(((this.item == null)?"<null>":this.item));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(key);
        dest.writeList(item);
    }

    public int describeContents() {
        return  0;
    }

}
