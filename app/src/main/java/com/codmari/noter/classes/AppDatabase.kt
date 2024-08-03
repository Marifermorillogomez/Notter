import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Database
import androidx.room.RoomDatabase
import com.codmari.noter.data_access.NoteDao
import android.content.Context
import androidx.room.Room

// Anotación @Database define la base de datos y sus entidades, en este caso 'Note'
// También establece la versión de la base de datos
@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    // Función abstracta que proporciona acceso a las operaciones CRUD de la tabla 'Note'
    abstract fun noteDao(): NoteDao

    companion object {
        // Volatile garantiza que el valor más reciente de INSTANCE siempre se vea en todos los hilos
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Método para obtener la instancia de la base de datos. Si no existe, la crea usando un patrón singleton
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                // Crea la base de datos usando Room.databaseBuilder y asigna la instancia
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "note_database" // Nombre de la base de datos
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
