package cl.gringraz.itunesclient.search.data.entity.remote

data class SearchResult<T>(
    val resultCount: Int,
    val results: List<T>
)
