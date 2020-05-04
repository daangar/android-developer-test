package com.dgarcia.domain.base

import com.dgarcia.domain.model.Result

interface BaseUseCase<T : Any?, R : Any> {
    suspend operator fun invoke(param: T): Result<R>
}