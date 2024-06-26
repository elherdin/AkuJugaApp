package com.example.akujuga.view

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.akujuga.data.UserRepository
import com.example.akujuga.di.Injection
import com.example.akujuga.view.feature.AlphabetViewModel
import com.example.akujuga.view.feature.KamusViewModel
import com.example.akujuga.view.feature.NumberViewModel
import com.example.akujuga.view.fragment.camera.CameraViewModel
import com.example.akujuga.view.login.LoginViewModel
import com.example.akujuga.view.main.MainViewModel
import com.example.akujuga.view.fragment.profile.ProfileViewModel
import com.example.akujuga.view.guest.GuestProfileViewModel

class ViewModelFactory(private val repository: UserRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repository) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                ProfileViewModel(repository) as T
            }
            modelClass.isAssignableFrom(GuestProfileViewModel::class.java) -> {
                GuestProfileViewModel(repository) as T
            }
            modelClass.isAssignableFrom(AlphabetViewModel::class.java) -> {
                AlphabetViewModel(repository) as T
            }
            modelClass.isAssignableFrom(KamusViewModel::class.java) -> {
                KamusViewModel(repository) as T
            }
            modelClass.isAssignableFrom(NumberViewModel::class.java) -> {
                NumberViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CameraViewModel::class.java) -> {
                CameraViewModel(repository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(Injection.provideRepository(context))
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }

}