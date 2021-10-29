package com.example.globalkinetic.ui.forecast

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.entity.FiveforecastEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * created by {Bennette Molepo} on {10/29/2021}.
 */
class MoreForecastInfoViewModel(application: Application): AndroidViewModel(application) {

    companion object{
        private val TAG = "MoreForecastInfoViewModel"
    }

}


