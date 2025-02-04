package ui.noteScreen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note.ui.theme.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import models.Notes
import javax.inject.Inject

@HiltViewModel
class NoteViewModel  @Inject constructor(
    private val repository: NotesRepository
) : ViewModel() {

/*    private val _listNotes = MutableStateFlow<List<Notes>>(emptyList())
    val listNotes = _listNotes.asStateFlow()*/

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

    fun addNote(note: Notes) = viewModelScope.launch {
        repository.addNote(note)
    }

}

