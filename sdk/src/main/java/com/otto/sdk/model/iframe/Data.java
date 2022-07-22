
package com.otto.sdk.model.iframe;

import java.io.Serializable;
import javax.annotation.Generated;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "iframe_url"
})
@Generated("jsonschema2pojo")
public class Data implements Serializable, Parcelable
{

    @JsonProperty("iframe_url")
    private String iframeUrl;
    public final static Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Data createFromParcel(android.os.Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5372856740884454892L;

    protected Data(android.os.Parcel in) {
        this.iframeUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Data() {
    }

    @JsonProperty("iframe_url")
    public String getIframeUrl() {
        return iframeUrl;
    }

    @JsonProperty("iframe_url")
    public void setIframeUrl(String iframeUrl) {
        this.iframeUrl = iframeUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Data.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("iframeUrl");
        sb.append('=');
        sb.append(((this.iframeUrl == null)?"<null>":this.iframeUrl));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(iframeUrl);
    }

    public int describeContents() {
        return  0;
    }

}
