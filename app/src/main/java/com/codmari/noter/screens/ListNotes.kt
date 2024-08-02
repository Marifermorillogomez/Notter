package com.codmari.noter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.codmari.noter.navigation.AppScreens
import com.codmari.noter.ui.components.ItemNote

import com.codmari.noter.ui.components.NoteData
import com.codmari.noter.ui.theme.GrayText
import com.codmari.noter.ui.theme.MontSerrantAlternativeFamily
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor
import java.time.LocalDate
import java.util.UUID

private val notes: List<NoteData> = listOf(
    NoteData(title="Viaje en el Tiempo", content="¿Qué pasaría si pudiera volver al pasado?", createdAt="2023/12/31"),
    NoteData(title="Miedo a las Alturas", content="Mirar desde un rascacielos es emocionante y aterrador a la vez.", createdAt="2024/01/15"),
    NoteData(title="Receta Secreta", content="Ingredientes desconocidos para un sabor único.", createdAt="2024/02/01"),
    NoteData(title="Sueño lúcido", content="Tomando el control de mis propios sueños.", createdAt="2024/03/08"),
    NoteData(title="Libro Favorito", content="Las aventuras de un hobbit en la Tierra Media.", createdAt="2024/04/20"),
    NoteData(title="Canción pegadiza",  content="Una melodía que no puedo sacar de mi cabeza.", createdAt="2024/05/05"),
    NoteData(title="Objetivo de Vida", content="Dejar una huella positiva en el mundo.", createdAt="2024/06/15"),
    NoteData(title="Momento de Euforia", content="La sensación de volar en una montaña rusa.", createdAt="2024/07/28"),
    NoteData(title="Pensamiento Filosófico", content="La existencia es un misterio fascinante.", createdAt="2024/08/12"),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListNotes (navController: NavController) {
    val showDialog =  remember { mutableStateOf(false) }
//    var itemNotes by remember { mutableStateOf(mutableListOf<NoteData>()) }

//    if(showDialog.value)
//        FormularioAgregarNota(itemNotes) {
//        }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notter") },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(AppScreens.NoteEditorScreen.route)
                        showDialog.value = true
                    }) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = "Agregar nota"
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(notes) { note ->
                    run {
                        ItemNote(dataNote = note)
                    }
                }
                if (notes.isEmpty()) {
                    item {
                        Text("No hay notas :(", modifier = Modifier.fillMaxWidth(), style = TextStyle(textAlign = TextAlign.Center, fontSize = 26.sp))
                    }
                } else {
                    items(notes) { note ->
                        run {
                            ItemNote(dataNote = note)
                        }
                    }
                }
            }
    }
}


fun generarUUID(): String {
    return UUID.randomUUID().toString()
}


//@Composable
//fun FormularioAgregarNota(notes:  MutableList<NoteData>, onDismiss: () -> Unit) {
//    var title by remember { mutableStateOf("") }
//    var content by remember { mutableStateOf("") }
//
//    val commonTextStyle =  TextStyle(fontFamily = MontSerrantAlternativeFamily, color = GrayText)
//    val commonFieldTextModifier =  Modifier.fillMaxWidth()
//
//    val state = rememberRichTextState()
//    Dialog(onDismissRequest = {
//        notes.add(NoteData(title = title, content = content, createdAt = LocalDate.now().toString()))
//    },  ){
//        Card {
//            Column(modifier =  Modifier.padding(start = 13.dp, end = 13.dp, bottom = 15.dp ), verticalArrangement = Arrangement.spacedBy(8.dp)) {
//                TextField(
//                    modifier = commonFieldTextModifier,
//                    textStyle = commonTextStyle.merge(fontSize = 22.sp),
//                    singleLine = true,
//                    value = title,
//                    onValueChange = { title = it },
//                    label = { Text("Titulo") },
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(text = "Contenido", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold, fontFamily = MontSerrantAlternativeFamily))
//                RichTextEditor(
//                    state = state,
//                    modifier = commonFieldTextModifier
//                        .weight(0.5f),
//                    textStyle = commonTextStyle.merge(fontSize = 18.sp),
////                    onValueChange = { content = it },
//                )
//                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
//                    Button(
//                        onClick = {
//                            if (title.value.isEmpty() && state.toMarkdown()
//                            ) {
//                                return@Button
//                            }
//                            setValue(txtField.value)
//                            setShowDialog(false)
//                        },
//                        shape = RoundedCornerShape(50.dp),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(50.dp)
//                    ) {
//                        Text(text = "Done")
//                    }
//                }
//            }
//        }
//
//    }
//}