package com.innaval.searchingithub.presentation.user.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.innaval.searchingithub.core.extensions.read
import com.innaval.searchingithub.core.extensions.toJsonString
import com.innaval.searchingithub.core.utils.Status
import com.innaval.searchingithub.domain.model.UserInformationsModel
import com.innaval.searchingithub.domain.model.UserModel
import com.innaval.searchingithub.domain.usecase.UserInformationsUseCase
import com.innaval.searchingithub.domain.usecase.UserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class UserInfoViewModel(
    private val userUseCase: UserUseCase,
    private val userInfoUseCase: UserInformationsUseCase,
) : ViewModel() {

    private val _loadingStatus: MutableLiveData<Status> = MutableLiveData()
    val loadingStatus: LiveData<Status> = _loadingStatus

    private val _userModel = MutableLiveData<UserModel?>()
    val userModel: LiveData<UserModel?> = _userModel

    private val _userInfo = MutableLiveData<List<UserInformationsModel>>()
    val userInfo: LiveData<List<UserInformationsModel>> = _userInfo

    fun getUser(login: String) = viewModelScope.launch {
        _loadingStatus.value = Status.LOADING
        withContext(Dispatchers.IO) {
            userUseCase(login)
        }.read(
            {
                Timber.tag("UserDetailsViewModel/getUserModel").d("Success: ${it.toJsonString()}")
                _userModel.value = (it)
                _loadingStatus.value = Status.SUCCESS
                getUserInfo(login = it.login)
            },
            {
                Timber.tag("UserDetailsViewModel/getUserModel").e("Error: ${it.message}")
                _loadingStatus.value = Status.ERROR
            },
        )
    }

    fun getUserInfo(login: String) = viewModelScope.launch {
        _loadingStatus.value = Status.LOADING
        withContext(Dispatchers.IO) {
            userInfoUseCase(login)
        }.read(
            {
                Timber.tag("UserDetailsViewModel/getUserRepos").d("Success: ${it.toJsonString()}")
                _userInfo.value = (it)
                _loadingStatus.value = Status.SUCCESS
            },
            {
                Timber.tag("UserDetailsViewModel/getUserRepos").e("Error: ${it.message}")
                _loadingStatus.value = Status.ERROR
            },
        )
    }
}