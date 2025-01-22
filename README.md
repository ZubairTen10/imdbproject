This spring application has two repositories, one that writes the data from IMDb's title.basics.tsv.gz dataset, and another that writes the data from IMDb's title.ratings.tsv.gz. With a relationship established with a foreign key
and the ratings repo joining the title.basics repo, with the title.basics table owning the foreign key.


This spring application has two functionalities.
First functionality: A user searches for a movie by title and the program returns the specified movie, regardless of whether they have inputted the movie's original title or  movie's primary title(which can be different to the original title if it is a foreign movie). 
The repo returns the corresponding movie object without the user having to specify whether what they inputted was a primary title or orignial title,  as I have a custom JPA query with an "Or" operator that checks if the input title matches any of the primary or original title columns.
![image](https://github.com/user-attachments/assets/358ee41b-0a84-4117-88ae-c11c9dc9c2c1)


Second functionality: User can search for all movies that have a greater rating than their specified input. Returning all movies that have a rating greater than what was inputted in the user prompt.
