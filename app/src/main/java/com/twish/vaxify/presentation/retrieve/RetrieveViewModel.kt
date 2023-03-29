package com.twish.vaxify.presentation.retrieve

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twish.vaxify.app.data.AgeGroupDto
import com.twish.vaxify.app.data.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RetrieveViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
    var vaccinesResponse: MutableLiveData<List<AgeGroupDto>> = MutableLiveData(emptyList())
        private set

    fun getAllVaccines(){
        viewModelScope.launch{
            try {
                vaccinesResponse.value = apiService.getAllVaccines().data
            } catch (e: java.lang.Exception){
                Timber.e("ERROR FETCHING VACCINES!")
                Timber.e(e.localizedMessage)
            }
        }
    }
}