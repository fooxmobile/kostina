package ru.fooxer.devlife.ui.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.fooxer.devlife.domain.interactor.GifPostInteractor
import ru.fooxer.devlife.domain.entiy.GifPostModel
import java.util.*
import javax.inject.Inject

const val TAG = "ViewModel"
class MainViewModel @Inject constructor(
   private val interactor: GifPostInteractor
) {

    init {
        interactor.randomPost()
            .subscribeOn(Schedulers.io())
            .doOnSuccess {
                Log.d(TAG, it.toString())
                postList.add(it)
                _currentPost.value = it
                _isErrorState.value = false
                _backButtonEnabled.value = postList.listIterator().hasPrevious()
            }
            .doOnError {
                Log.e(TAG, it.message)
                _isErrorState.value = true
            }
    }
    // список скачанных постов
    private val postList = LinkedList<GifPostModel>()
    // текущий пост
    private val _currentPost = MutableLiveData<GifPostModel>()
    internal val currentPost : LiveData<GifPostModel> = _currentPost
    // доступность кнопки назад
    private val _backButtonEnabled = MutableLiveData<Boolean>().apply {
        value = false
    }
    internal val backButtonEnabled: LiveData<Boolean> = _backButtonEnabled

    private val _isErrorState = MutableLiveData<Boolean>()
    internal val isErrorState: LiveData<Boolean> = _isErrorState

    internal fun loadNextPost() {
        if (_currentPost.value?.id == postList.last.id) {
            interactor.randomPost()
                .subscribeOn(Schedulers.io())
                .doOnSuccess {
                    postList.add(it)
                    _currentPost.value = it
                    _isErrorState.value = false
                   _backButtonEnabled.value = postList.listIterator().hasPrevious()
                }
                .doOnError {
                    Log.e(TAG, it.message)
                    _isErrorState.value = true
                }
        }
            else {
                _currentPost.value = postList.listIterator().next()
            }
        }

    internal fun retry() {
        loadNextPost()
    }

    internal fun loadPreviousPost() {
        _currentPost.value = postList.listIterator().previous()
    }
    }
