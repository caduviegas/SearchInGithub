package com.innaval.searchingithub.core.extensions

import com.innaval.searchingithub.data.datasource.ResponseAny
import com.innaval.searchingithub.data.datasource.ResponseEmpty
import com.innaval.searchingithub.data.datasource.ResponseError
import com.innaval.searchingithub.data.datasource.ResponseSuccess

fun <T> ResponseAny<T>.read(
    success: (T) -> Unit,
    error: ((Exception) -> Unit)? = null,
    empty: ((Int) -> Unit)? = null,
) {
    when (this) {
        is ResponseSuccess -> success(this.body)
        is ResponseError -> error?.invoke(this.exception)
        is ResponseEmpty -> empty?.invoke(this.code)
    }
}
