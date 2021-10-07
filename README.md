# Life of the Ants

This console application was done to practice the OOP, algorithms and creation of class diagrams, it 
simulates the life of the ants.


## General information

In an ant colony there are four different castes: *Workers*, *Soldiers*, *Drones*, and there is one 
*Queen*. The colony area is square (has a *width*), and the ants live and move within the borders of 
the colony.

Each ant changes position in every time step, according to a caste-specific rule:

* the *Queen* sits in the middle and does not move

* the *Workers* normally make one step in one of the four directions, chosen randomly before each move

* the *Soldiers* "patrol" close to their starting position; this means that in a 4-cycle they step one 
  and turn to the left (towards North, East, South, and West, and then they start the cycle again)

* the *Drones* always try to make one step towards the *Queen*. When they get next to the *Queen*, they 
  have a chance that she is in the mood of mating. In this happy case they stay there for 10 time steps. 
  After that they are kicked off to a random position at the edge of the colony. If the *Queen* isn't 
  in the mood, *Drones* are kicked away instantly.

The *Queen*’s mating mood is following this rule: after a successful mating she sets a countdown timer 
(starting from some time between 50 and 100 time steps) to get in the mood again.


## Setup

Run the application in your IDE! The ANSI escape sequences used to produce color output to the console
may not be supported by other environments. 


## Use

1. When asked, specify the *width* of the colony, the number of *Workers*, *Soldiers* and *Drones*.

2. The application advances the simulation by one time step and prints the actual state of the colony 
   after hitting ```Enter```.

3. To quit the program, hit ```q``` and ```Enter```.


## Technologies

* Java

* PlantUML