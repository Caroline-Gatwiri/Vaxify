package com.twish.vaxify.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twish.vaxify.app.data.ApiService
import com.twish.vaxify.app.data.ChildModel
import com.twish.vaxify.app.data.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
    val message: MutableLiveData<Message> = MutableLiveData(Message.DEFAULT)

    fun clearMessage(){
        message.value = Message.DEFAULT
    }

    fun postData(childModel: ChildModel){
        viewModelScope.launch {
            apiService.postRequestModel(childModel).enqueue(object: Callback<ChildModel>{
                override fun onResponse(
                    call: Call<ChildModel>,
                    response: Response<ChildModel>
                ) {
                    if (response.isSuccessful){
                        message.value = Message.SUCCESS
                    }
                }

                override fun onFailure(call: Call<ChildModel>, t: Throwable) {
                    message.value = Message.FAILED
                }
            })
        }
    }
}