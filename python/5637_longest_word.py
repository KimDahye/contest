from sys import stdin
import re

# main
p = re.compile('[a-zA-Z-]+')
max_word = ''
should_continue = True
while should_continue:
    line = stdin.readline()
    word_arr = p.findall(line)
    for word in word_arr:
        if len(word) > len(max_word):
            max_word = word
        if word == 'E-N-D':
            should_continue = False
            break

    if not should_continue:
        print(max_word.lower())
