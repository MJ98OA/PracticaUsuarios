package com.example.practicausuarios


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName



@Parcelize
data class UsuariosApi(
    val results: List<Result>,
) : Parcelable


@Parcelize
data class Result (
    val gender: String,
    val name: Name,
    val location: Location
) : Parcelable

@Parcelize
data class Location (
    val state: String
) : Parcelable


@Parcelize
data class Name (
    val title: String,
    val first: String,
    val last: String
) : Parcelable
