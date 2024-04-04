"""
wolf
-> 1

wwoollff
-> 1

wwwooolllfff
-> 1

wolfwwoollff
-> 1

wolfwwoollffwolf
-> 1

wfol
-> 0

wwolfolf
-> 0

wwwoolllfff
-> 0

wolfff
-> 0
"""

import sys, re

from collections import deque

input = lambda:sys.stdin.readline().strip()

string = input()

def solution(string):
    chunks = re.findall(r'w+o+l+f+', string)

    if "".join(chunks) != string:
        return 0

    for chunk in chunks:
        if not (chunk.count('w') == chunk.count('o') == chunk.count('l') == chunk.count('f')):
            return 0

    return 1

print(solution(string))
