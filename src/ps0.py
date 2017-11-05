#!/usr/bin/env python3
import math

num1 = int(input ("Enter a number: "))
num2 = int(input ("Enter another number: "))
print (("%i to the %i power is %i.") % (num1, num2, num1 ** num2))
print("The log base 2 of %i is %i." % (num1, math.log2(num1)))