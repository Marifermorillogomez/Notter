package com.codmari.noter.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.versionedparcelable.VersionedParcelize
import com.codmari.noter.ui.theme.GrayText
import com.codmari.noter.ui.theme.MontSerrantAlternativeFamily
import java.time.LocalDate
import com.codmari.noter.R
import kotlinx.serialization.Serializable

@Serializable
// Data class representing a note item
data class NoteData(val title: String, val content: String, val createdAt: String)

// Función componible para mostrar un elemento de nota
@Composable
fun ItemNote(dataNote: NoteData){
    val commonTextStyle =  TextStyle(fontFamily = MontSerrantAlternativeFamily, color = GrayText)
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 5.dp), colors = CardDefaults.cardColors(
        containerColor = Color(0xFFD1D1D1)
    )) {
        // Columna para organizar el título y el contenido verticalmente
        Column(Modifier.padding(horizontal = 9.dp, vertical = 6.dp)) {
            Text(
                text = dataNote.title,
                style = commonTextStyle.merge(fontSize = 20.sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = dataNote.content, maxLines = 3, overflow = TextOverflow.Ellipsis, style = commonTextStyle.merge(fontSize = 16.sp, fontWeight =  FontWeight.Normal ))
            Spacer(modifier = Modifier.height(8.dp))
            Row(   modifier = Modifier
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End
            ) {
                Text(text = dataNote.createdAt)
                Icon(
                    painter = painterResource(id = R.drawable.ic_clock_outline),
                    contentDescription = "Fecha creacion",
                )
            }
        }

    }
}


@Preview( name =  "ItemNote", showBackground = true, showSystemUi = true)
@Composable
private fun ItemNotePreview(){
    ItemNote(NoteData(title = "Una nota para ti", content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
        createdAt = LocalDate.now().toString()
        ))
}
