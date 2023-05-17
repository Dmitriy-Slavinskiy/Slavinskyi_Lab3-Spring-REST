package ua.kpi.its.lab.rest.entity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate
@Entity
@Table(name = "magazine")
data class Magazine(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val name: String,
    val subject: String,
    val language: String,
    val dateofestablishment:  LocalDate,
    val ISSN: Int,
    val periodicity: Boolean,
    @OneToMany(mappedBy = "magazine", cascade = [CascadeType.ALL], orphanRemoval = true)
    val listofarticles: List<Article>
) : Comparable<Magazine> {
    override fun compareTo(other: Magazine): Int {
        val cmp = subject.compareTo(other.subject)
        return if (cmp != 0) cmp else language.compareTo(other.language)
    }
}