package com.printf.kidsteacher.been.aphabet;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Alphabet {

@SerializedName("Status")
@Expose
private Integer status;
@SerializedName("Message")
@Expose
private String message;
@SerializedName("Data")
@Expose
private List<Datum> data = null;

public Integer getStatus() {
return status;
}

public void setStatus(Integer status) {
this.status = status;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public List<Datum> getData() {
return data;
}

public void setData(List<Datum> data) {
this.data = data;
}

}

