package com.otto.sdk.parser;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Volley Request for passing JSON string with Jackson
 *
 * @TODO - Extend this class
 * <p>
 * saggaf@area54labs.net
 */
public class JacksonRequest<T> extends Request<T> {
  private final Class<T> mClass;
  private final Response.Listener<T> mListener;
  private final HashMap<String, String> mParams;
  private final HashMap<String, String> mHeaders;

  private final ObjectMapper jacksonMapper = new ObjectMapper();

  public JacksonRequest(
      Class<T> cls,
      int method,
      HashMap<String, String> headers,
      HashMap<String, String> params,
      String url,
      Response.Listener listener,
      final FailureListener errorListener) {
    super(method, url, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        int code;
        NetworkResponse net = error.networkResponse;

        if (net != null) {
          code = net.statusCode;
        } else {
          if (error instanceof TimeoutError) {
            code = Failure.TIMEOUT;
          } else if (error instanceof ParseError) {
            code = Failure.PARSE;
          } else if (error instanceof NoConnectionError) {
            code = Failure.NO_CONNECTION;
          } else {
            code = Failure.UNKNOWN;
          }
        }

        errorListener.onRequestFailure(code, error.getMessage());
      }
    });

    mClass = cls;
    mListener = listener;
    mParams = params;
    mHeaders = headers;
  }

  @Override
  protected Map<String, String> getParams() throws AuthFailureError {
    return mParams;
  }

  @Override
  public Map<String, String> getHeaders() throws AuthFailureError {
    return mHeaders;
  }

  @Override
  protected Response<T> parseNetworkResponse(NetworkResponse response) {
    try {
      String json = new String(response.data,
          HttpHeaderParser.parseCharset(response.headers));
      return Response.success(jacksonMapper.readValue(json, mClass),
          HttpHeaderParser.parseCacheHeaders(response));
    } catch (UnsupportedEncodingException e) {
      return Response.error(new ParseError(e));
    } catch (JsonMappingException e) {
      return Response.error(new ParseError(e));
    } catch (JsonParseException e) {
      return Response.error(new ParseError(e));
    } catch (IOException e) {
      return Response.error(new ParseError(e));
    }
  }

  @Override
  protected void deliverResponse(T response) {
    mListener.onResponse(response);
  }

  public interface FailureListener {
    void onRequestFailure(int code, String message);
  }

  public static class Failure {
    public static final int UNKNOWN = 0;
    public static final int NO_CONNECTION = 1;
    public static final int TIMEOUT = 2;
    public static final int PARSE = 3;
  }
}
