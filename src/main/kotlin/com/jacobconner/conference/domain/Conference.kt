import com.jacobconner.conference.domain.LocationData
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "conference")
data class Conference(
    @Id
    val id: String?,
    val name: String,
    val description: String?,
    val website: String?,
    val location: LocationData?,
    val dateStart: Instant?,
    val dateEnd: Instant?,
)