#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# 
import random
import string
 
WORDLIST_FILENAME = "words.txt"


def load_words():
    """
    Returns a list of valid words. Words are strings of lowercase letters.
    
    Depending on the size of the word list, this function may
    take a while to finish.
    """
    print("Loading word list from file...")
    # inFile: file
    inFile = open(WORDLIST_FILENAME, 'r')
    # line: string
    line = inFile.readline()
    # wordlist: list of strings
    wordlist = line.split()
    print("  ", len(wordlist), "words loaded.")
    return wordlist



def choose_word(wordlist):
    """
    wordlist (list): list of words (strings)
    
    Returns a word from wordlist at random
    """
    return random.choice(wordlist)

# end of helper code

# -----------------------------------

# Load the list of words into the variable wordlist
# so that it can be accessed from anywhere in the program
wordlist = load_words()


def is_word_guessed(secret_word, letters_guessed):
    '''
    secret_word: string, the word the user is guessing; assumes all letters are
      lowercase
    letters_guessed: list (of letters), which letters have been guessed so far;
      assumes that all letters are lowercase
    returns: boolean, True if all the letters of secret_word are in letters_guessed;
      False otherwise
    '''
    # FILL IN YOUR CODE HERE AND DELETE "pass"
    return not ('_' in get_guessed_word(secret_word, letters_guessed))



def get_guessed_word(secret_word, letters_guessed):
    '''
    secret_word: string, the word the user is guessing
    letters_guessed: list (of letters), which letters have been guessed so far
    returns: string, comprised of letters, underscores (_), and spaces that represents
      which letters in secret_word have been guessed so far.
    '''
    # FILL IN YOUR CODE HERE AND DELETE "pass"
    word = ""
    for i in range(0, len(secret_word)):
        if secret_word[i] not in letters_guessed:
            word += "_"
        else:
            word += secret_word[i]
    return word



def get_available_letters(letters_guessed):
    '''
    letters_guessed: list (of letters), which letters have been guessed so far
    returns: string (of letters), comprised of letters that represents which letters have not
      yet been guessed.
    '''
    # FILL IN YOUR CODE HERE AND DELETE "pass"
    alpha = ""
    letters = string.ascii_lowercase
    for i in range(0, 26):
        if letters[i] not in letters_guessed:
            alpha += letters[i];
    print (alpha)
    

def hangman(secret_word):
    '''
    secret_word: string, the secret word to guess.
    
    Starts up an interactive game of Hangman.
    
    * At the start of the game, let the user know how many 
      letters the secret_word contains and how many guesses s/he starts with.
      
    * The user should start with 6 guesses

    * Before each round, you should display to the user how many guesses
      s/he has left and the letters that the user has not yet guessed.
    
    * Ask the user to supply one guess per round. Remember to make
      sure that the user puts in a letter!
    
    * The user should receive feedback immediately after each guess 
      about whether their guess appears in the computer's word.

    * After each guess, you should display to the user the 
      partially guessed word so far.
    
    Follows the other limitations detailed in the problem write-up.
    '''
    # FILL IN YOUR CODE HERE AND DELETE "pass"
    
#    word = secret_word
    
#    print("Welcome to the game Hangman!")
#    print("I am thinking of a word that is %i letters long. " % len(word))
#    print("--------------------")
#    letters_guessed = []
#    num_guesses = 6
#    while (not is_word_guessed(word, letters_guessed)) and num_guesses >= 0:
#        if num_guesses == 0:
#            print("Sorry, you ran out of guesses! The word was " + word + ".")
#            break
#        
#        print("You have %i guesses left. \nAvailable letters: " % num_guesses)
#        get_available_letters(letters_guessed)
#        guess = input("Please enter a guess. ")
#        if not(guess in string.ascii_lowercase or guess in string.ascii_uppercase):
#            while not(guess in string.ascii_lowercase or guess in string.ascii_uppercase):
#               guess = input("Please enter a valid guess. ")
#        letters_guessed += guess
#        if (is_word_guessed(word, letters_guessed)):
#            print("Great job! You guessed it! Your total score is %i." % (len(word)*num_guesses))
#            break
#        if guess in word:
#            print ("Your guess is correct.")
#        else:
#            if guess == 'a' or guess == 'e' or guess == 'i' or guess == 'o' or guess == 'u':
#                num_guesses -= 1
#            num_guesses -= 1
#            print ("Sorry, your guess is incorrect.")
#        
#        print get_guessed_word(word, letters_guessed)
        


# When you've completed your hangman function, scroll down to the bottom
# of the file and uncomment the first two lines to test
#(hint: you might want to pick your own
# secret_word while you're doing your own testing)


# -----------------------------------



def match_with_gaps(my_word, other_word):
    '''
    my_word: string with _ characters, current guess of secret word
    other_word: string, regular English word
    returns: boolean, True if all the actual letters of my_word match the 
        corresponding letters of other_word, or the letter is the special symbol
        _ , and my_word and other_word are of the same length;
        False otherwise: 
    '''
    # FILL IN YOUR CODE HERE AND DELETE "pass"
    ok = True
    if len(my_word) != len(other_word):
        return False
    else:
        for i in range(0, len(my_word)):
            if my_word[i] != '_':
                if my_word[i] != other_word[i]:
                    ok = False;
                    return False
                    break;
        if ok:
            return True



def show_possible_matches(my_word):
    '''
    my_word: string with _ characters, current guess of secret word
    returns: nothing, but should print out every word in wordlist that matches my_word
             Keep in mind that in hangman when a letter is guessed, all the positions
             at which that letter occurs in the secret word are revealed.
             Therefore, the hidden letter(_ ) cannot be one of the letters in the word
             that has already been revealed.

    '''
    # FILL IN YOUR CODE HERE AND DELETE "pass"
    found = False
    for i in range(0, len(wordlist)):
        if match_with_gaps(my_word, wordlist[i]):
            print(wordlist[i])
            found = True
    if not found:
        print ("No matches found.")



def hangman_with_hints(secret_word):
    '''
    secret_word: string, the secret word to guess.
    
    Starts up an interactive game of Hangman.
    
    * At the start of the game, let the user know how many 
      letters the secret_word contains and how many guesses s/he starts with.
      
    * The user should start with 6 guesses
    
    * Before each round, you should display to the user how many guesses
      s/he has left and the letters that the user has not yet guessed.
    
    * Ask the user to supply one guess per round. Make sure to check that the user guesses a letter
      
    * The user should receive feedback immediately after each guess 
      about whether their guess appears in the computer's word.

    * After each guess, you should display to the user the 
      partially guessed word so far.
      
    * If the guess is the symbol *, print out all words in wordlist that
      matches the current guessed word. 
    
    Follows the other limitations detailed in the problem write-up.
    '''
    word = secret_word
    
    print("Welcome to the game Hangman!")
    print("I am thinking of a word that is %i letters long. " % len(word))
    print("--------------------")
    letters_guessed = []
    num_guesses = 6
    while (not is_word_guessed(word, letters_guessed)) and num_guesses >= 0:
        if num_guesses == 0:
            print("Sorry, you ran out of guesses! The word was " + word + ".")
            break
        
        print("You have %i guesses left. \nAvailable letters: " % num_guesses)
        get_available_letters(letters_guessed)
        guess = input("Please enter a guess. ")
        if not(guess in string.ascii_lowercase or guess in string.ascii_uppercase or guess == '*'):
            while not(guess in string.ascii_lowercase or guess in string.ascii_uppercase):
               guess = input("Please enter a valid guess. ")
        if guess == '*':
            str = get_guessed_word(word, letters_guessed)
            show_possible_matches(str)
        else:
            letters_guessed += guess
            if (is_word_guessed(word, letters_guessed)):
                print("Great job! You guessed it! Your total score is %i." % (len(word)*num_guesses))
                break
            if guess in word:
                print ("Your guess is correct.")
            else:
                if guess == 'a' or guess == 'e' or guess == 'i' or guess == 'o' or guess == 'u':
                    num_guesses -= 1
                num_guesses -= 1
                print ("Sorry, your guess is incorrect.")
            
        print (get_guessed_word(word, letters_guessed))
       



# When you've completed your hangman_with_hint function, comment the two similar
# lines above that were used to run the hangman function, and then uncomment
# these two lines and run this file to test!
# Hint: You might want to pick your own secret_word while you're testing.


if __name__ == "__main__":
    # pass

    # To test part 2, comment out the pass line above and
    # uncomment the following two lines.
    
    #secret_word = choose_word(wordlist)
    #hangman(secret_word)

###############
    
    # To test part 3 re-comment out the above lines and 
    # uncomment the following two lines. 

    secret_word = choose_word(wordlist)
    hangman_with_hints(secret_word)
