package ui.noteScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import models.Notes

class NoteViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(Notes())
    val uiState: StateFlow<Notes> = _uiState.asStateFlow()



    fun updateTextField(newTitle: String, newNote: String, changeFavorite: Boolean) {
        _uiState.value = _uiState.value.copy(
            title = newTitle,
            note = newNote,
            favorite = changeFavorite
        )
    }

    fun passValues(note: Notes){
        _uiState.value = _uiState.value.copy(
            title = note.title,
            note = note.note,
            favorite = note.favorite
        )
    }
}

