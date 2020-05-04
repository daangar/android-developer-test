package com.dgarcia.data.common.utils

import android.content.Context

class FakeConnectivityImpl(private val context: Context): Connectivity {
    override fun hasNetworkAccess() = false
}