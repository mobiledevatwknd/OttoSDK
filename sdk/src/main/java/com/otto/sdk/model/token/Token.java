
package com.otto.sdk.model.token;

import java.io.Serializable;
import javax.annotation.Generated;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "token_code",
    "refresh_token"
})
@Generated("jsonschema2pojo")
public class Token implements Serializable, Parcelable
{

    @JsonProperty("token_code")
    private String tokenCode;
    @JsonProperty("refresh_token")
    private String refreshToken;
    public final static Creator<Token> CREATOR = new Creator<Token>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Token createFromParcel(android.os.Parcel in) {
            return new Token(in);
        }

        public Token[] newArray(int size) {
            return (new Token[size]);
        }

    }
    ;
    private final static long serialVersionUID = -9073350762576883747L;

    protected Token(android.os.Parcel in) {
        this.tokenCode = ((String) in.readValue((String.class.getClassLoader())));
        this.refreshToken = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Token() {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Token.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("tokenCode");
        sb.append('=');
        sb.append(((this.tokenCode == null)?"<null>":this.tokenCode));
        sb.append(',');
        sb.append("refreshToken");
        sb.append('=');
        sb.append(((this.refreshToken == null)?"<null>":this.refreshToken));
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
    }

    public int describeContents() {
        return  0;
    }

}
