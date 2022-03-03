package com.example.practicausuarios
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

class Users {

    @Parcelize
    data class Welcome (
        val results: List<Result>,
        val info: Info
    ) : Parcelable

    @Parcelize
    data class Info (
        val seed: String,
        val results: Long,
        val page: Long,
        val version: String
    ) : Parcelable

    @Parcelize
    data class Result (
        val gender: String,
        val name: Name,
        val location: Location
    ) : Parcelable

    @Parcelize
    data class Location (
        val street: Street,
        val city: String,
        val state: String,
        val country: String,
        val postcode: Long,
        val coordinates: Coordinates,
        val timezone: Timezone
    ) : Parcelable

    @Parcelize
    data class Coordinates (
        val latitude: String,
        val longitude: String
    ) : Parcelable

    @Parcelize
    data class Street (
        val number: Long,
        val name: String
    ) : Parcelable

    @Parcelize
    data class Timezone (
        val offset: String,
        val description: String
    ) : Parcelable

    @Parcelize
    data class Name (
        val title: String,
        val first: String,
        val last: String
    ) : Parcelable

}