# Project idea
The project is a simulation of natural selection and evolution. Different Organisms with random genomes are generated and thrown onto a map. The condition for survival declares if the organism is allowed to replicate. The organisms are generated and deleted in generations. If the organism doesn't have a specific genome, which declares otherwise, it will die after one generation. The condition of survival is up to the developer. Mutations randomly occurr when replicating, with a chance of 1/128.

# Use Cases
### Generate a specific number of Organisms
The user can generate a number of organisms with random genomes. The organisms are then randomly placed over the grid.

### Advance a certain number of generations
The user is able to declare the number of generations, which pass between the different displays.

### Set a condition of survival
The user is able to select a condition for survival

# Genomes
### What are genomes?
Genomes are the composition of an organism. Each organism has 10 genomes. The different genomes have affect the behaviour of the organism. By increasing/decreasing speed, dictating direction of movement etc. the genome directly influences its host.

### Different types of genomes

|Type    	| Affect   	|
|---	|---	|
|   Speed	| Dictates the number of tiles, which the organism moves, each speed genome adds 1 extra tile  	|
|   Direction	| Dictates the direction, in which the organism will move, if multiple direction genomes exist, the direction with the most direction genomes will be chosen. If an equal amount of direction genomes exist, one direction will randomly take over and the other genomes will be overwritten with that direction genome.  	|
|   Aggression	|   If the organism has an aggression genome, it will devour any organism which is within a 1 tile range at the end of the generation and replicate. It can only devour a single organism per generation  |
|   Defense	|   The organism becomes capable of defending itself against aggressors. If it has the same number or less defense genomes then the aggressor has aggression genomes, it will die. If it has more defense genomes then the aggressor has aggression genomes, the aggressor will die and the defending organism will replicate.  |
|   Charm	|   If the organism with a charm genome is within a 1 tile range of another organism, it will mate and replicate. The range will be increased by 1 for each additional charm genome. The Offspring will then contain both 50% of the paternal genome and 50% of the maternal genome randomly  |

### Order of evaluation
At the start of the generation, the direction and speed genome will dictate the movement of the organism. If no direction genome exists, it will move in a random direction, if no speed genome exists, it will move at it's default speed of 1 tile. 
At the end of the generation, the aggression, defense and charm genome will come into effect. Firstly the aggressors will make their move, if the victim has defense genomes, the calculation of the winner will be start. The winner will then replicate. Lastly, organisms with charm genomes will start to replicate if there is a mate.
