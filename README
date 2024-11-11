# Project #1: Player Cache

* Author: Brian Wu
* Class: CS321 Section #001
* Semester: Spring 2023

## Overview

This program uses a linked-list in order to mimic a cache. 

## Reflection

I think this project put a lot more anxiety than it should have. The reason 
why I say this is because I and many others are a little "rusty".
It has been over a year since I took CS221 and I was questioning my coding
skills. I should've done some refreshing now and then but I was focused
on completing the majority of my general classes. Needless to say, it went well. 
It was surprisingly easy to settle back in. Coding the Cache class took around 20
minutes. It was in a rough state(I would soon learn) and I felt confident
setting up everything else. One big thing that kept being an obstacle was
my choice of using Visual Studio Code. To be fair, it wasn't the IDE's fault but
rather my lack of understanding. Several times when I would compile all the files
my CacheTest class kept perceiving my Cache class as foreign. It didn't recognize
it and it made me frustrated at first but it turns out all I had to do was to
set the file registry for compiling the files one back. AKA the root file that holds
everything. I didn't have to do that on Eclipse and Onyx which is why I was so
confused when it happened. I genuinely thought my code was broken at the time.

Another issue I ran into was when I was testing the program. For tests 5 and 6 the
data gets amped up and the pool is MUCH bigger. I didn't realize it at first but my
code was insanely unoptimized. At a glance, it seemed to work perfectly fine all
be it a little slower than the output files times. It turns out my original code took
over 4 minutes to complete test 5! I didn't even bother with test 6. I was too impatient 
and wanted to know what I screwed up. It took some deep diving but then I realized the
issue. The problem was that I kept using methods that used index values. It's 
simple to understand the code, but man, did it destroy the time. The big Oh value was 
definitely no n or n^2. Using index values is a terrible idea because I'm using a 
linked list. That means every single time the getObject() method is called I have to
climb all the way to the value it's looking for ONE BY ONE. That means when I'm done
with looking at one value and want to look at the next value I HAVE TO START OVER.
It's a good thing I didn't submit that because no one in this world ever needs to
have their sight go blind from such horrible code. The solution to the problem was using
a ListIterator. That way my spot is always saved. Overall, I enjoyed this project 
and hit some bumps but I overcame them.

## Compiling and Using

Compiling this code is relatively simple to do. 
First you compile all the files(in the correct directory) by using this command:

javac *.java

Then, you call the CacheTest class by using this command structure:

java CacheTest <cache-size> <serialized-data-fliename>

You can create all sorts of data using the PlayerGenerator class that can
be tested with this CacheTest class. There isn't anything else to note. The
program should output results and tell you how successful the cache-like list
was. 

## Results 

Testing this code was a breeze but there were some hitches along the way. 
For tests 1-4 the timings went great and overperformed compared to the provided
output files. On the other hand, tests 5 and 6 struggled with time. They 
aren't ideal, but they certainly work well. Especially when compared to my original
code. Even if some tests took a little longer than expected all the data matched
up and everything was correct. As it turns out a linked list has the ability to
act like a cache with the right code. 

## Sources used

One thing that I needed a little help on was setting up the ObjectInputStream
and the FileInputStream. I wasn't exactly sure what was going on when I read the
psuedocode provided and all the Stream and Writer classes are very fuzzy to me.
I found a page on stackoverflow that helped me.

https://stackoverflow.com/questions/4709151/fileinputstream-and-objectinputstream

Also, when I was struggling with compiling my code in VSC I found this page.

https://stackoverflow.com/questions/32598120/cannot-find-symbol-in-same-package-and-directory

----------

## Notes

* This README template is using Markdown. Here is some help on using Markdown: 
[markdown cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)


* Markdown can be edited and viewed natively in most IDEs such as Eclipse and VS Code. Just toggle
between the Markdown source and preview tabs.

* To preview your README.md output online, you can copy your file contents to a Markdown editor/previewer
such as [https://stackedit.io/editor](https://stackedit.io/editor).
