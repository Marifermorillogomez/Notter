package com.codmari.noter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codmari.noter.screens.ListNotes
import com.codmari.noter.screens.NoteEditor

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "list_note"){
        composable(route = AppScreens.ListNotesScreen.route){
            ListNotes(navController)
        }
        composable(route = AppScreens.NoteEditorScreen.route){
            NoteEditor(navController)
        }


    }
}