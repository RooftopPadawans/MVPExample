package com.flknlabs.mvpexample.Presenter

import com.flknlabs.mvpexample.Model.Person

class PersonPresenter(private val mView: PersonContract.View): PersonContract.Presenter {
    private val mInteractor = PersonInteractor()

    override fun loadMessage() {
        mInteractor.isValidData { person, isValid ->
            if (isValid) {
                val message = "Hi " + person?.firstName.toString() + "!"
                mView.showMessage(message)
            } else {
                mView.showError("No person name found.")
            }
        }
    }

    override fun saveName(firstName: String, lastName: String) {
        /*mPerson.firstName = firstName
        mPerson.lastName = lastName*/
    }

    override fun onPause() { }
}