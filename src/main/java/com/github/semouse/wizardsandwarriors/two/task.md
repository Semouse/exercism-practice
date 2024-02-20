In this exercise you're playing a role-playing game named "Wizard and Warriors" with your best
friends. You are the Game Master, the person tasked with making the game world come alive for the
players. A key aspect of this is describing the game to the players: what is a character's status,
what the town they're visiting looks like, etc.

1. **Describe a character**  
   Each character has a class, level and number of hit points and is described as: `"You're a
   level <LEVEL> <CLASS> with <HIT_POINTS> hit points."`. Implement the `GameMaster.describe` method
   that takes a Character as its sole parameter and returns its description.
2. **Describe a destination**  
   Each destination has a name and a number of inhabitants and is described
   as: `"You've arrived at <NAME>, which has <INHABITANTS> inhabitants."`. Implement the
   `GameMaster.describe` method that takes a Destination as its sole parameter and returns its
   description.
3. **Describe the travel method**  
   Characters can travel to a destination using one of two options:
    * Walking, described as: `"You're traveling to your destination by walking."`
    * On horseback, described as: `"You're traveling to your destination on horseback."`

   Implement the `GameMaster.describe` method that takes a TravelMethod as its sole parameter and
   returns its description.
4. **Describe a character traveling to the destination**
   When a character is traveling to a destination, this is described as a combination of the
   individual descriptions: `"<CHARACTER> <TRAVEL_METHOD> <DESTINATION>"`. Implement the
   `GameMaster.describe` method that takes a Character, a Destination and a TravelMethod as its
   parameters and return its description.
5. **Describe a character traveling to a destination without specifying the travel method**  
   In the majority of cases, characters are traveling to a destination by walking. For convenience,
   players are allowed to omit mentioning their travel method, in which case walking will be assumed
   to be the travel method. Implement the `GameMaster.describe` method that takes a Character and a
   Destination as its parameters and return its description.
