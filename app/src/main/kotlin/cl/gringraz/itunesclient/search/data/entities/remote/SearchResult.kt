package cl.gringraz.itunesclient.search.data.entities.remote

data class SearchResult<T>(
    val resultCount: Int,
    val results: List<T>
)
