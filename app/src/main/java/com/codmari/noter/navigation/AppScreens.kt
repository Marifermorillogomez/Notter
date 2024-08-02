package com.codmari.noter.navigation

sealed class AppScreens(val route: String) {
    object ListNotesScreen : AppScreens("list_note")
    object NoteEditorScreen : AppScreens("note_editor")
}