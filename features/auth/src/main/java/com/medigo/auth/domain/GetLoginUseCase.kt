package com.medigo.auth.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.medigo.model.Profile
import com.medigo.repository.AuthRepository
import com.medigo.repository.utils.Resource

class GetLoginUseCase(private val authRepository: AuthRepository){

    suspend operator fun invoke(id: String, password: String): LiveData<Resource<Profile>> {
        return Transformations.map(authRepository.login(id, password)) {
            it
        }
    }

}