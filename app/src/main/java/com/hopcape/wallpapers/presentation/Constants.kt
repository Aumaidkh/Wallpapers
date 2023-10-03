package com.hopcape.wallpapers.presentation

import android.content.Context


fun getAppUrl(context: Context):String{
    return "https://play.google.com/store/apps/details?id=${context.packageName}"
}