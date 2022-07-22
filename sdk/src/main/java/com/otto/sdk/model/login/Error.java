
package com.otto.sdk.model.login;

import java.io.Serializable;
import javax.annotation.Generated;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

})
@Generated("jsonschema2pojo")
public class Error implements Serializable, Parcelable
{

    public final static Creator<Error> CREATOR = new Creator<Error>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Error createFromParcel(android.os.Parcel in) {
            return new Error(in);
        }

        public Error[] newArray(int size) {
            return (new Error[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2403095125997862837L;

    protected Error(android.os.Parcel in) {
    }

    public Error() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Error.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
    }

    public int describeContents() {
        return  0;
    }

}
