package com.hopcape.wallpapers.presentation.screen.onboarding

import com.hopcape.wallpapers.R

data class OnBoardingPage(
    val backgroundResId: Int,
    val heading: Int,
    val desc: Int
)

val onBoardingPages = listOf(
    OnBoardingPage(
        backgroundResId = R.drawable.page_1,
        heading = R.string.big_collection,
        desc = R.string.find_wallpapers_for
    ),
    OnBoardingPage(
        backgroundResId = R.drawable.page_2,
        heading = R.string.stylish_look,
        desc = R.string.set_the_same_wallpaper
    ),
    OnBoardingPage(
        backgroundResId = R.drawable.page__3,
        heading = R.string.good_editor,
        desc = R.string.edit_images_to_your
    ),
)
