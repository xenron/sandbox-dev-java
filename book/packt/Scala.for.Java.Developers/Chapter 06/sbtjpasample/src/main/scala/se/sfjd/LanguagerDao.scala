package se.sfjd

trait LanguageDao {
    def save(language: Language): Unit
    def find(id: Int): Option[Language]
    def getAll: List[Language]
    def getByName(name : String): List[Language]
}