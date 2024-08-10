package ch09

import kotlin.test.Test
import kotlin.test.assertEquals

class TopArticlesTest {
    @Test
    fun `Top articles are returned in the correct order`() {
        val articles = listOf(
            ArticleStatistics("Article 1", 400),
            ArticleStatistics("Article 2", 100),
            ArticleStatistics("Article 3", 200),
            ArticleStatistics("Article 4", 300),
            ArticleStatistics("Article 5", 500),
            ArticleStatistics("Article 6", 0),

            )
        val generator = TopArticlesGenerator(articles)
        val topArticles = generator.topArticles(100)
        assertEquals(articles, topArticles)
    }

    @Test
    fun `Only n top articles are kept`() {
        val articles = listOf(
            ArticleStatistics("Article 1", 400),
            ArticleStatistics("Article 2", 100),
            ArticleStatistics("Article 3", 200),
            ArticleStatistics("Article 4", 300),
            ArticleStatistics("Article 5", 500),
            ArticleStatistics("Article 6", 0),

            )
        val generator = TopArticlesGenerator(articles)
        val topArticles = generator.topArticles(3)
        assertEquals(articles.slice(listOf(0, 3, 4)), topArticles)
    }

    @Test
    fun `Return empty list if no articles`() {
        val generator = TopArticlesGenerator(emptyList())
        assertEquals(emptyList(),  generator.topArticles(3))
    }
}
