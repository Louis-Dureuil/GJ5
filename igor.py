import random

size = random.randint(3,7)

letters = [ 'a', 'b' , 'c' , 'd' ,
        'e', 'f', 'g', 'h', 'i',
        'j', 'k' , 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's',
        't', 'u', 'v', 'w', 'x',
        'y', 'z', 
        'A', 'E', 'I', 'O', 'U','Y']



msg = ''

for i in range(0, size+1):
    index = random.randint(0,31)
    msg += letters[index]

print msg


