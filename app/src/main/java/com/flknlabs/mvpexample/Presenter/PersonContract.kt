package com.flknlabs.mvpexample.Presenter

interface PersonContract {
    interface View {
        fun showMessage(message: String)
        fun showError(error: String)
    }

    interface Presenter {
        fun loadMessage()
        fun saveName(firstName: String, lastName: String)
        fun onPause()
    }
}