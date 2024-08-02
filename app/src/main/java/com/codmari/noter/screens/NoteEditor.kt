package com.codmari.noter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.codmari.noter.R
import com.codmari.noter.navigation.AppScreens
import com.codmari.noter.ui.theme.GrayText
import com.codmari.noter.ui.theme.MontSerrantAlternativeFamily
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteEditor(navController: NavController){
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    val commonTextStyle =  TextStyle(fontFamily = MontSerrantAlternativeFamily, color = GrayText)
    val commonFieldTextModifier =  Modifier.fillMaxWidth()

    val state = rememberRichTextState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nueva nota") },
                actions = {
                    IconButton(onClick = ({navController.navigate(AppScreens.ListNotesScreen.route)})) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_content_save),
                            contentDescription = "Agregar nota"
                        )
                    }
                }
            )
        }
    ) {
        innerPadding ->
            Column(modifier =  Modifier.padding(innerPadding).padding(start = 13.dp, end = 13.dp, bottom = 15.dp ), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                TextField(
                    modifier = commonFieldTextModifier,
                    textStyle = commonTextStyle.merge(fontSize = 22.sp),
                            singleLine = true,
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Titulo") },
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Contenido", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold, fontFamily = MontSerrantAlternativeFamily))
                RichTextEditor(
                    state = state,
                    modifier = commonFieldTextModifier
                        .weight(1f),
                    textStyle = commonTextStyle.merge(fontSize = 18.sp),
//                    onValueChange = { content = it },
                )
            }

    }
}

Host github.com
AddKeysToAgent yes
UseKeychain yes
IdentityFile ~/.ssh/id_ed25519