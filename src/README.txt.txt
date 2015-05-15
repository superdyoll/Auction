=Parts Of the Spec Met:=

==Part One (Users)==
This part is implemented with the Users being able to be managed by the Auction Manager

==Part Two (Items)==
Items has been split into 2 parts Items and Auctions this means multiple people can sell the same thing

==Part Three (Communication Layer)==
Within the Comms Package are 2 classes the Comms and SocketComms Class

Socket Comms is an implementation of the Comms class

both the server and client use the SocketComms class to communicate

==Part Four (Client Application)==
Unfortunately this part was left until the last minute so is not fully implemented.
All the parts needed inorder to complete communication to the server is there however the gui does not work

==Part Five (Server Application)==
This is where alot of my time was spent in development

Some of the features i'm proud of are:

# The use of the Filter Design Pattern to get specific items
# Serialisation of classes. (This caused an issue in that JPanel's are unable 
to be serialized which the whole project had been leading up to meaning it could not 
be completed)
# The GUI - compared to the client the server had a very nice gui. The Text area would take any text that had been output via System.out.print() and display it
The other nice part of the GUI is the System Tray Icon that allows the server to be minimised by quitting but still run and be accessible via the system tray
When Running the Tray Icon displays a simple logo that when clicked on allows you either to view the server or shut down the server


==Part Six (Persistence Layer)==
Use of an SQLite Database (Again this caused more issues than it was worth. 
I tried making so that you could have a database interface so that you could choose 
between having MySQL or SQLite however the use of SQL confused things when trying to use the Filter Design Pattern Aswell)

If I were to do this again I would finish the project without SQL then add data persistance in afterwards

==Part Seven (Extensions)==

I tried to add alot of extensions from the start which overcomplicated the whole project and made it into something that should have probably taken a couple of months

1. Hashing and Salting of passwords - Security is important so implemented the use of SHA512 to hash the passwords and create a random salt
2. Config files - The config is able to read in .PROPERTIES files and they can then be used throughout the program
3. Filter Design Pattern - as described earlier
4. Message Serialisation - Instead of just sending string commands across a whole system was designed to send serialized classes accross which worked until it was discovered that JPanels cannot be serialized
5. Server Tray Icon - as described earlier
6. SQLite - as described earlier


All in all the number of extenstions i tried to build in led to an unfinished coursework