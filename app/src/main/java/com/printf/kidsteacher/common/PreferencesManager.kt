package com.printf.kidsteacher.common

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {
    private val PREF_NAME = "user_preference"
    private var sharedPref: SharedPreferences? = null

    //Main List
    private val KEY_VIDEO_AD_HOME_SCREEN_ON_OPEN = "VideoAdHomeScreenOnOpen"
    private val KEY_INTER_AD_HOME_SCREEN_ON_OPEN = "InterAdHomeScreenOnOpen"
    private val KEY_VIDEO_AD_HOME_SCREEN_ON_CLOSE = "VideoAdHomeScreenOnClose"
    private val KEY_INTER_AD_HOME_SCREEN_ON_CLOSE = "InterAdHomeScreenOnClose"

    //Category
    private val KEY_VIDEO_AD_CATEGORY_SCREEN_ON_OPEN = "VideoAdCategoryScreenOnOpen"
    private val KEY_INTER_AD_CATEGORY_SCREEN_ON_OPEN = "InterAdCategoryScreenOnOpen"
    private val KEY_VIDEO_AD_CATEGORY_SCREEN_ON_CLOSE = "VideoAdCategoryScreenOnClose"
    private val KEY_INTER_AD_CATEGORY_SCREEN_ON_CLOSE = "InterAdCategoryScreenOnClose"

    //Sub Category
    private val KEY_VIDEO_AD_SUB_CATEGORY_SCREEN_ON_OPEN = "VideoAdSubCategoryScreenOnOpen"
    private val KEY_INTER_AD_SUB_CATEGORY_SCREEN_ON_OPEN = "InterAdSubCategoryScreenOnOpen"
    private val KEY_VIDEO_AD_SUB_CATEGORY_SCREEN_ON_CLOSE = "VideoAdSubCategoryScreenOnClose"
    private val KEY_INTER_AD_SUB_CATEGORY_SCREEN_ON_CLOSE = "InterAdSubCategoryScreenOnClose"

    //Detail Screen
    private val KEY_VIDEO_AD_DETAIL_SCREEN_ON_OPEN = "VideoAdDetailScreenOnOpen"
    private val KEY_INTER_AD_DETAIL_SCREEN_ON_OPEN = "InterAdDetailScreenOnOpen"
    private val KEY_VIDEO_AD_DETAIL_SCREEN_ON_CLOSE = "VideoAdDetailScreenOnClose"
    private val KEY_INTER_AD_DETAIL_SCREEN_ON_CLOSE = "InterAdDetailScreenOnClose"


    //Video 
    private val KEY_VIDEO_AD_VIDEO_SCREEN_ON_OPEN = "VideoAdVideoScreenOnOpen"
    private val KEY_INTER_AD_VIDEO_SCREEN_ON_OPEN = "InterAdVideoScreenOnOpen"
    private val KEY_VIDEO_AD_VIDEO_SCREEN_ON_CLOSE = "VideoAdVideoScreenOnClose"
    private val KEY_INTER_AD_VIDEO_SCREEN_ON_CLOSE = "InterAdVideoScreenOnClose"
    

    private val KEY_SHOW_BANNER_AD = "key_show_banner_ad"
    private val KEY_GEO_LOCATION = "key_geo_location"



    companion object {
        private var preferencesManager: PreferencesManager? = null
        fun instance(context: Context): PreferencesManager {
            if (preferencesManager == null)
                preferencesManager = PreferencesManager(context)

            return preferencesManager!!
        }
    }

    init {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }


    fun isShowVideoAdHomeScreenOnOpen() : Boolean{
        return sharedPref!!.getBoolean(KEY_VIDEO_AD_HOME_SCREEN_ON_OPEN, false)
    }
    fun setIsShowVideoAdHomeScreenOnOpen(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_VIDEO_AD_HOME_SCREEN_ON_OPEN, isShow)
        edit.apply()
    }
    fun isShowInterAdHomeScreenOnOpen() : Boolean{
        return sharedPref!!.getBoolean(KEY_INTER_AD_HOME_SCREEN_ON_OPEN, false)
    }
    fun setIsShowInterAdHomeScreenOnOpen(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_INTER_AD_HOME_SCREEN_ON_OPEN, isShow)
        edit.apply()
    }
    fun isShowVideoAdHomeScreenOnClose() : Boolean{
        return sharedPref!!.getBoolean(KEY_VIDEO_AD_HOME_SCREEN_ON_CLOSE, false)
    }
    fun setIsShowVideoAdHomeScreenOnClose(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_VIDEO_AD_HOME_SCREEN_ON_CLOSE, isShow)
        edit.apply()
    }
    fun isShowInterAdHomeScreenOnClose() : Boolean{
        return sharedPref!!.getBoolean(KEY_INTER_AD_HOME_SCREEN_ON_CLOSE, false)
    }
    fun setIsShowInterAdHomeScreenOnClose(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_INTER_AD_HOME_SCREEN_ON_CLOSE, isShow)
        edit.apply()
    }


    fun isShowVideoAdCategoryScreenOnOpen() : Boolean{
        return sharedPref!!.getBoolean(KEY_VIDEO_AD_CATEGORY_SCREEN_ON_OPEN, false)
    }

    fun setIsShowVideoAdCategoryScreenOnOpen(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_VIDEO_AD_CATEGORY_SCREEN_ON_OPEN, isShow)
        edit.apply()
    }
    fun isShowInterAdCategoryScreenOnOpen() : Boolean{
        return sharedPref!!.getBoolean(KEY_INTER_AD_CATEGORY_SCREEN_ON_OPEN, false)
    }
    fun setIsShowInterAdCategoryScreenOnOpen(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_INTER_AD_CATEGORY_SCREEN_ON_OPEN, isShow)
        edit.apply()
    }
    fun isShowVideoAdCategoryScreenOnClose() : Boolean{
        return sharedPref!!.getBoolean(KEY_VIDEO_AD_CATEGORY_SCREEN_ON_CLOSE, false)
    }
    fun setIsShowVideoAdCategoryScreenOnClose(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_VIDEO_AD_CATEGORY_SCREEN_ON_CLOSE, isShow)
        edit.apply()
    }
    fun isShowInterAdCategoryScreenOnClose() : Boolean{
        return sharedPref!!.getBoolean(KEY_INTER_AD_CATEGORY_SCREEN_ON_CLOSE, false)
    }
    fun setIsShowInterAdCategoryScreenOnClose(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_INTER_AD_CATEGORY_SCREEN_ON_CLOSE, isShow)
        edit.apply()
    }


    fun isShowVideoAdVideoScreenOnOpen() : Boolean{
        return sharedPref!!.getBoolean(KEY_VIDEO_AD_VIDEO_SCREEN_ON_OPEN, false)
    }
    fun setIsShowVideoAdVideoScreenOnOpen(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_VIDEO_AD_VIDEO_SCREEN_ON_OPEN, isShow)
        edit.apply()
    }
    fun isShowInterAdVideoScreenOnOpen() : Boolean{
        return sharedPref!!.getBoolean(KEY_INTER_AD_VIDEO_SCREEN_ON_OPEN, false)
    }
    fun setIsShowInterAdVideoScreenOnOpen(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_INTER_AD_VIDEO_SCREEN_ON_OPEN, isShow)
        edit.apply()
    }
    fun isShowVideoAdVideoScreenOnClose() : Boolean{
        return sharedPref!!.getBoolean(KEY_VIDEO_AD_VIDEO_SCREEN_ON_CLOSE, false)
    }
    fun setIsShowVideoAdVideoScreenOnClose(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_VIDEO_AD_VIDEO_SCREEN_ON_CLOSE, isShow)
        edit.apply()
    }
    fun isShowInterAdVideoScreenOnClose() : Boolean{
        return sharedPref!!.getBoolean(KEY_INTER_AD_VIDEO_SCREEN_ON_CLOSE, false)
    }
    fun setIsShowInterAdVideoScreenOnClose(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_INTER_AD_VIDEO_SCREEN_ON_CLOSE, isShow)
        edit.apply()
    }
    
    
    fun isShowVideoAdSubCategoryScreenOnOpen() : Boolean{
        return sharedPref!!.getBoolean(KEY_VIDEO_AD_SUB_CATEGORY_SCREEN_ON_OPEN, false)
    }
    fun setIsShowVideoAdSubCategoryScreenOnOpen(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_VIDEO_AD_SUB_CATEGORY_SCREEN_ON_OPEN, isShow)
        edit.apply()
    }
    fun isShowInterAdSubCategoryScreenOnOpen() : Boolean{
        return sharedPref!!.getBoolean(KEY_INTER_AD_SUB_CATEGORY_SCREEN_ON_OPEN, false)
    }
    fun setIsShowInterAdSubCategoryScreenOnOpen(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_INTER_AD_SUB_CATEGORY_SCREEN_ON_OPEN, isShow)
        edit.apply()
    }
    fun isShowVideoAdSubCategoryScreenOnClose() : Boolean{
        return sharedPref!!.getBoolean(KEY_VIDEO_AD_SUB_CATEGORY_SCREEN_ON_CLOSE, false)
    }
    fun setIsShowVideoAdSubCategoryScreenOnClose(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_VIDEO_AD_SUB_CATEGORY_SCREEN_ON_CLOSE, isShow)
        edit.apply()
    }
    fun isShowInterAdSubCategoryScreenOnClose() : Boolean{
        return sharedPref!!.getBoolean(KEY_INTER_AD_SUB_CATEGORY_SCREEN_ON_CLOSE, false)
    }
    fun setIsShowInterAdSubCategoryScreenOnClose(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_INTER_AD_SUB_CATEGORY_SCREEN_ON_CLOSE, isShow)
        edit.apply()
    }
    

    fun isShowVideoAdDetailScreenOnOpen() : Boolean{
        return sharedPref!!.getBoolean(KEY_VIDEO_AD_DETAIL_SCREEN_ON_OPEN, false)
    }
    fun setIsShowVideoAdDetailScreenOnOpen(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_VIDEO_AD_DETAIL_SCREEN_ON_OPEN, isShow)
        edit.apply()
    }
    fun isShowInterAdDetailScreenOnOpen() : Boolean{
        return sharedPref!!.getBoolean(KEY_INTER_AD_DETAIL_SCREEN_ON_OPEN, false)
    }
    fun setIsShowInterAdDetailScreenOnOpen(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_INTER_AD_DETAIL_SCREEN_ON_OPEN, isShow)
        edit.apply()
    }
    fun isShowVideoAdDetailScreenOnClose() : Boolean{
        return sharedPref!!.getBoolean(KEY_VIDEO_AD_DETAIL_SCREEN_ON_CLOSE, false)
    }
    fun setIsShowVideoAdDetailScreenOnClose(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_VIDEO_AD_DETAIL_SCREEN_ON_CLOSE, isShow)
        edit.apply()
    }
    fun isShowInterAdDetailScreenOnClose() : Boolean{
        return sharedPref!!.getBoolean(KEY_INTER_AD_DETAIL_SCREEN_ON_CLOSE, false)
    }
    fun setIsShowInterAdDetailScreenOnClose(isShow : Boolean){
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_INTER_AD_DETAIL_SCREEN_ON_CLOSE, isShow)
        edit.apply()
    }

    fun getGEOLocation(): String {
        return sharedPref!!.getString(KEY_GEO_LOCATION, "").toString()
    }

    fun setGEOLocation(geoLocation : String) {
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putString(KEY_GEO_LOCATION, geoLocation)
        edit.apply()
    }

    fun isShowBannerAd(): Boolean {
        return sharedPref!!.getBoolean(KEY_SHOW_BANNER_AD, false)
    }

    fun setIsShowBannerAd(isShow : Boolean) {
        val edit: SharedPreferences.Editor = sharedPref!!.edit()
        edit.putBoolean(KEY_SHOW_BANNER_AD, isShow)
        edit.apply()
    }
}