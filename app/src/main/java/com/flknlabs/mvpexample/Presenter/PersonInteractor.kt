package com.flknlabs.mvpexample.Presenter

import com.flknlabs.mvpexample.Model.Person

class PersonInteractor {
    private val mPerson: Person = Person()

    fun isValidData(callback: (Person?, Boolean) -> Unit ) {
        if (mPerson.firstName.isEmpty() && mPerson.lastName.isEmpty()) {
            callback(null, false)
        } else {
            callback(mPerson, true)
        }
    }
}