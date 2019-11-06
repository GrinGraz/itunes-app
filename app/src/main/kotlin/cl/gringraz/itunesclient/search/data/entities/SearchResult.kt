package cl.gringraz.itunesclient.search.data.entities

data class SearchResult<T>(
    val resultCount: Int,
    val results: List<T>
)
