package com.example.note.ui.theme.data

import models.Notes

class NotaDataSource {
    fun loadNotes(): List<Notes> {
        return listOf(
            Notes(
                0,
                " este es el titulo de la nota",
                "esta es la descripcion de la nota",
                true,
            ),
            Notes(
                0,
                " este es el titulo de la nota",
                "esta es la descripcion de la nota",
                false,

                ),
            Notes(
                0,
                " este es el titulo de la nota",
                "esta es la descripcion de la nota",
                false,

                ),
            Notes(
                0,
                " este es el titulo de la nota",
                "esta es la descripcion de la nota",
                false,

                )

        )
    }
}