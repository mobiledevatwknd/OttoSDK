
package com.otto.sdk.model.token;

import java.io.Serializable;

import javax.annotation.Generated;

import android.os.Parcelable;

import androidx.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "api_version",
    "memory_usage",
    "elapse_time",
    "lang",
    "code",
    "error",
    "data"
})
@Generated("jsonschema2pojo")
public class BaseResponse implements Serializable, Parcelable {

  @JsonProperty("api_version")
  private String apiVersion;
  @JsonProperty("memory_usage")
  private String memoryUsage;
  @JsonProperty("elapse_time")
  private String elapseTime;
  @JsonProperty("lang")
  private String lang;
  @JsonProperty("code")
  private Integer code;
  @JsonProperty("error")
  private Error error;
  @JsonProperty("data")
  private Token token;
  public final static Creator<BaseResponse> CREATOR = new Creator<BaseResponse>() {


    @SuppressWarnings({
        "unchecked"
    })
    public BaseResponse createFromParcel(android.os.Parcel in) {
      return new BaseResponse(in);
    }

    public BaseResponse[] newArray(int size) {
      return (new BaseResponse[size]);
    }

  };
  private final static long serialVersionUID = -1241310841343240545L;

  protected BaseResponse(android.os.Parcel in) {
    this.apiVersion = ((String) in.readValue((String.class.getClassLoader())));
    this.memoryUsage = ((String) in.readValue((String.class.getClassLoader())));
    this.elapseTime = ((String) in.readValue((String.class.getClassLoader())));
    this.lang = ((String) in.readValue((String.class.getClassLoader())));
    this.code = ((Integer) in.readValue((Integer.class.getClassLoader())));
    this.error = ((Error) in.readValue((Error.class.getClassLoader())));
    this.token = ((Token) in.readValue((Token.class.getClassLoader())));
  }

  public BaseResponse() {
  }

  @JsonProperty("api_version")
  public String getApiVersion() {
    return apiVersion;
  }

  @JsonProperty("api_version")
  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  @JsonProperty("memory_usage")
  public String getMemoryUsage() {
    return memoryUsage;
  }

  @JsonProperty("memory_usage")
  public void setMemoryUsage(String memoryUsage) {
    this.memoryUsage = memoryUsage;
  }

  @JsonProperty("elapse_time")
  public String getElapseTime() {
    return elapseTime;
  }

  @JsonProperty("elapse_time")
  public void setElapseTime(String elapseTime) {
    this.elapseTime = elapseTime;
  }

  @JsonProperty("lang")
  public String getLang() {
    return lang;
  }

  @JsonProperty("lang")
  public void setLang(String lang) {
    this.lang = lang;
  }

  @JsonProperty("code")
  public Integer getCode() {
    return code;
  }

  @JsonProperty("code")
  public void setCode(Integer code) {
    this.code = code;
  }

  @JsonProperty("error")
  public Error getError() {
    return error;
  }

  @JsonProperty("error")
  public void setError(Error error) {
    this.error = error;
  }

  @JsonProperty("data")
  public Token getToken() {
    return token;
  }

  @JsonProperty("data")
  public void setToken(@Nullable Token token) {
    this.token = token;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(BaseResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("apiVersion");
    sb.append('=');
    sb.append(((this.apiVersion == null) ? "<null>" : this.apiVersion));
    sb.append(',');
    sb.append("memoryUsage");
    sb.append('=');
    sb.append(((this.memoryUsage == null) ? "<null>" : this.memoryUsage));
    sb.append(',');
    sb.append("elapseTime");
    sb.append('=');
    sb.append(((this.elapseTime == null) ? "<null>" : this.elapseTime));
    sb.append(',');
    sb.append("lang");
    sb.append('=');
    sb.append(((this.lang == null) ? "<null>" : this.lang));
    sb.append(',');
    sb.append("code");
    sb.append('=');
    sb.append(((this.code == null) ? "<null>" : this.code));
    sb.append(',');
    sb.append("error");
    sb.append('=');
    sb.append(((this.error == null) ? "<null>" : this.error));
    sb.append(',');
    sb.append("data");
    sb.append('=');
    sb.append(((this.token == null) ? "<null>" : this.token));
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

  public void writeToParcel(android.os.Parcel dest, int flags) {
    dest.writeValue(apiVersion);
    dest.writeValue(memoryUsage);
    dest.writeValue(elapseTime);
    dest.writeValue(lang);
    dest.writeValue(code);
    dest.writeValue(error);
    dest.writeValue(token);
  }

  public int describeContents() {
    return 0;
  }

}
