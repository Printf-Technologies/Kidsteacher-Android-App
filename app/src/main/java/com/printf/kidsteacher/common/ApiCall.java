package com.printf.kidsteacher.common;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;
import com.printf.kidsteacher.dialog.CommonDialog;
import com.roger.catloadinglibrary.CatLoadingView;

import java.util.HashMap;
import java.util.Map;

public class ApiCall
{
//    ApiResponce apiResponce;
    public static CatLoadingView mView;
    //mView.setBackgroundColor(Color.parseColor("#000000"));

    public static void GetApi(final boolean isLoder, boolean isShoDialog, Context context, String url, final ApiResponce apiResponce)
    {
        mView = new CatLoadingView();
        mView.setCanceledOnTouchOutside(false);
        //final Loader loader = new Loader(context);
        CommonDialog commonDialog = new CommonDialog(context);

        if(CheckInternet.networkAvailability(context))
        {
            //loader.show();
            if(isLoder)
            {mView.show(((FragmentActivity)context).getSupportFragmentManager(), "");}
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,new Response.Listener<String>() {
                @Override
                public void onResponse(String responce)
                {
                    if(isLoder)
                    {mView.dismiss();}
                    //loader.hide();
//                    Log.e("TAG","login responce = "+responce);
                    apiResponce.Responce(responce);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError)
                {
                    if(isLoder)
                    {mView.dismiss();}
                    //loader.hide();
                    apiResponce.Error(volleyError.getMessage());
                }
            })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError
                {
                    HashMap<String,String> param = new HashMap<>();
                    return param;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError
                {
                    HashMap<String,String> param = new HashMap<>();
                    param.put(WebServices.HEADER_KEY,WebServices.HEADER_VALUE);
                    return param;
                }
            };

            stringRequest.setShouldCache(false);
            requestQueue.getCache().clear();
            requestQueue.add(stringRequest);
        }
        else
        {
            if(isShoDialog)
            {commonDialog.show("Please check your internet connection.");}
        }
    }
}
