
package com.otto.sdk.model.login;

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
    "token_code",
    "refresh_token",
    "user_id"
})
@Generated("jsonschema2pojo")
public class Data implements Serializable, Parcelable
{

    @JsonProperty("token_code")
    private String tokenCode;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("user_id")
    private Integer userId;
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
    private final static long serialVersionUID = -8246385062640718732L;

    protected Data(android.os.Parcel in) {
        this.tokenCode = ((String) in.readValue((String.class.getClassLoader())));
        this.refreshToken = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Data() {
    }

    @JsonProperty("token_code")
    public String getTokenCode() {
        return tokenCode;
    }

    @JsonProperty("token_code")
    public void setTokenCode(String tokenCode) {
        this.tokenCode = tokenCode;
    }

    @JsonProperty("refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    @JsonProperty("refresh_token")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @JsonProperty("user_id")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Data.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("tokenCode");
        sb.append('=');
        sb.append(((this.tokenCode == null)?"<null>":this.tokenCode));
        sb.append(',');
        sb.append("refreshToken");
        sb.append('=');
        sb.append(((this.refreshToken == null)?"<null>":this.refreshToken));
        sb.append(',');
        sb.append("userId");
        sb.append('=');
        sb.append(((this.userId == null)?"<null>":this.userId));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(tokenCode);
        dest.writeValue(refreshToken);
        dest.writeValue(userId);
    }

    public int describeContents() {
        return  0;
    }

}
