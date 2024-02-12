package com.natiqhaciyef.kotlinandroidknowledges.android.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CustomViewModel @Inject constructor() : ViewModel() {
    /***
     * In Android, we deal with lots and lots of data. The data of one activity is being used in some
     * other activity or fragment. For example, we can change the UI of an application when there is a
     * change in some data. So, the basic idea is to have efficient communication between the data and
     * the UI of the application and we all know that the best way to do this is by using LiveData which
     * is a part of Android Jetpack.
     * LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware,
     * meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
     *
     * There are subclasses in LiveData that are useful for their properties when updating the UI
     *      1.LiveData
     *      2.MutableLiveData
     *      3.MediatorLiveData
     *
     * LiveData is immutable by default. By using LiveData we can only observe the data and cannot set
     * the data.
     *
     * MutableLiveData is mutable and is a subclass of LiveData. In MutableLiveData we can observe and
     * set the values using postValue() and setValue() methods (the former being thread-safe) so that
     * we can dispatch values to any live or active observers.
     *
     * MediatorLiveData can observe other LiveData objects such as sources and react to their onChange()
     * events. MediatorLiveData will give us control over when we want to perform an action in particular
     * or when we want to propagate an event.
     *
     *
     * Advantages of using LiveData
     *   - Ensures your UI matches your data state.
     *   - No memory leaks.
     *   - No crashes due to stopped activities.
     *   - No more manual lifecycle handling.
     *   - Always up to date data.
     *   - Proper configuration changes.
     *
     * By default using lazy property live data cannot be accessible for post or set value to variable.
     * It creates LiveData object.
     *
     * Difference of set/post value:
     * While using the Main thread to change the data, you should use the setValue method of the
     * MutableLiveData class and while using the background thread to change the LiveData, you should
     * use the postValue method of the MutableLiveData class.
     *
     * So, the duty of the postValue method is to post or add a task to the main thread of the application
     * whenever there is a change in the value. And the value will be updated whenever the main thread
     * will be executed. So, basically, it is requesting the main thread to set the new updated value
     * and then notify the observers.
     * While the setValue method is used to set the changed value from the main thread and if there
     * are some live observers to it, then the updated value will also be sent to those observers as
     * well. This setValue method must be called from the main thread.
     * */

    private val mutableLiveDataByLazy: MutableLiveData<String?> by lazy { MutableLiveData(null) }
    private val mutableLiveDataDefault: MutableLiveData<String?> = MutableLiveData(null)
    private val liveDataDefault: LiveData<String?> = mutableLiveDataDefault
    private val mediatorLiveData: MediatorLiveData<String?> = MediatorLiveData()

    init {
        mediatorLiveData.addSource(mutableLiveDataByLazy) {
            if (it.isNullOrEmpty()) {
                println(it)
            }
        }

        liveDataDefault.value

        mutableLiveDataDefault.postValue("Neyim varki repden qare")
        mutableLiveDataDefault.value = "Neyim varki repden qare"

    }
}