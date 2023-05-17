package ua.kpi.its.lab.rest.entity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name="article")
data class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val name: String,
    val author: String,
    val dateofwriting: LocalDate,
    val numberofwords: Int,
    val numberoflinks: Int,
    val originallanguage: Boolean,
    @ManyToOne
    @JoinColumn(name = "magazine_id")
    val magazine: Magazine
) : Comparable<Article> {
    override fun compareTo(other: Article): Int {
        val cmp = numberofwords.compareTo(other.numberofwords)
        return if (cmp != 0) cmp else numberoflinks.compareTo(other.numberoflinks)
    }
}