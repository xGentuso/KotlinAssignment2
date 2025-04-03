
/**
 * Challenge A: Caesar Cipher Encryption
 * Encrypts a string by shifting each letter by the specified key value.
 * Non-letter characters remain unchanged.
 */
fun encryptCaesarCipher(text: String, key: Int): String {
    val result = StringBuilder()

    for (char in text) {
        // Only encrypt letters, leave other characters unchanged
        if (char.isLetter()) {
            val base = if (char.isUpperCase()) 'A' else 'a'
            // Calculate the shift with modulo to handle wrapping (e.g., z -> a)
            val shifted = ((char.code - base.code + key) % 26 + base.code).toChar()
            result.append(shifted)
        } else {
            result.append(char)
        }
    }

    return result.toString()
}

/**
 * Challenge B: Anagram Checker
 * Checks if two words are anagrams of each other.
 * Two words are anagrams if they contain the same letters in different orders.
 */
fun areAnagrams(word1: String, word2: String): Boolean {
    // If lengths differ, they can't be anagrams
    if (word1.length != word2.length) return false

    // Compare sorted character arrays
    val sortedWord1 = word1.lowercase().toCharArray().sorted()
    val sortedWord2 = word2.lowercase().toCharArray().sorted()

    return sortedWord1 == sortedWord2
}

/**
 * Challenge C: Substring Checker (without using String.contains)
 * Checks if the second string is a substring of the first string.
 */
fun isSubstring(mainString: String, subString: String): Boolean {
    // Empty substring is always contained in any string
    if (subString.isEmpty()) return true

    // If subString is longer than mainString, it can't be a substring
    if (subString.length > mainString.length) return false

    // Check each possible starting position in mainString
    for (i in 0..mainString.length - subString.length) {
        var match = true

        // Compare characters from this position
        for (j in subString.indices) {
            if (mainString[i + j] != subString[j]) {
                match = false
                break
            }
        }

        if (match) return true
    }

    return false
}

/**
 * Challenge D: Longest Word Finder
 * Finds the longest word in a string.
 * Words are considered to be separated by spaces.

 */
fun findLongestWord(text: String): String {
    // Split the text into words by spaces
    val words = text.split("\\s+".toRegex())

    // Find the longest word
    return words.maxByOrNull { it.length } ?: ""
}

/**
 * Main function with test cases for all challenges
 */
fun main() {
    // Test Challenge A: Caesar Cipher
    val plainText = "Hello, World!"
    val key = 3
    val encrypted = encryptCaesarCipher(plainText, key)
    println("Original: $plainText")
    println("Encrypted (key=$key): $encrypted")
    println("Decrypted: ${encryptCaesarCipher(encrypted, 26 - key)}")

    // Test Challenge B: Anagram Checker
    val word1 = "dusty"
    val word2 = "study"
    println("'$word1' and '$word2' are anagrams: ${areAnagrams(word1, word2)}")

    // Test Challenge C: Substring Checker
    val mainString = "Programming is fun"
    val subString = "gram"
    println("'$subString' is a substring of '$mainString': ${isSubstring(mainString, subString)}")

    // Test Challenge D: Longest Word Finder
    val sentence = "The quick brown fox jumps over the lazy dog"
    println("Longest word in '$sentence': ${findLongestWord(sentence)}")
}