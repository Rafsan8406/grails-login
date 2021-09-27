package main

class Document {
    String fileName
    String fullPath

    static constraints = {
        fileName (nullable: false, blank: false)
        fullPath (nullable: false, blank: false)
    }
}
