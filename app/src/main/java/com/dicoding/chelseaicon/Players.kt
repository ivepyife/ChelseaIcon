package com.dicoding.chelseaicon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Players(
    val name: String,
    val nationality: String,
    val position: String,
    val marketValue: String,
    val career: String,
    val photo: String
) : Parcelable
