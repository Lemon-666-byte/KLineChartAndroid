package com.app.klinechart.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @Author lihu hu_li888@foxmail.com
 * @Date 2019-05-14-18:12
 */
@Parcelize
data class VrModel(
    val vr: Double?,
    val maVr: Double?
): Parcelable