package ui.mainScreen

import android.util.Log
import androidx.collection.mutableIntListOf
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note.ui.theme.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import models.Notes
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: NotesRepository
) : ViewModel() {

    private val _listNotes = MutableStateFlow<List<Notes>>(emptyList())
    val listNotes = _listNotes.asStateFlow()

    private val _listState = MutableStateFlow("")
    val listState = _listState.asStateFlow()

    init {
        getAllNotes()
    }

    fun getAllNotes() = viewModelScope.launch(Dispatchers.IO) {
        repository.getAllNotes().distinctUntilChanged()
            .collect() { list ->
                if (list.isEmpty()) {
                    _listState.value = "Without Notes  \uD83D\uDCED"
                }
                _listNotes.value = list

            }
    }

    fun getOnlyFavoriteNotes() = viewModelScope.launch(Dispatchers.IO) {
        repository.getOnlyFavoriteNote().distinctUntilChanged().collect() { list ->
            if (list.isEmpty()) {
                _listState.value = "Without Favorite Notes \uD83D\uDE15"
            }
            _listNotes.value = list
        }
    }


}