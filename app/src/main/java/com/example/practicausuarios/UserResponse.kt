package com.example.practicausuarios

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserResponse (
    val results: MutableList<Result>
) : Parcelable