# AI-Project-One: Live Long and Prosper 

## Project Description:
A town requires critical resources (food, materials, and energy) to support its residents and
develop new structures. The town's prosperity level reflects the well-being of its residents.
Buildings are essential for increasing the town's wealth, and these constructions
necessitate specialized resources. The goal of this project is to create a search agent
tasked with designing a plan to increase the town's prosperity to 100. The consequences of
various activities on prosperity and resource levels differ. We are given a $100,000 budget
with no other sources of income. The town has a resource storage limit of 50 units per
resource, and each action the agent does depletes these resources. A delivery must be
ordered to replenish the level of a resource. Using resources incurs costs, which indicate
the cost of these resources. Our objective is to develop a search agent capable of
investigating and, if possible, devising a plan to raise the town's prosperity to level 100.

## A discussion of our implementation of the LLAP problem.
Our LLAP problem is structured using object-oriented programming principles with classes
like Initials and Actions. This helps organize the code and encapsulate related
functionalities.
- Initials Class:
Initialization: The Initials class efficiently initializes the state of the town based on the
provided input string. The use of a constructor that parses the input string ensures a clean
and organized way to set initial parameters.
Attributes: The class effectively represents the state of the town with attributes like
prosperity, food, materials, energy, and various parameters for requests and building
constructions.
- State Class
The State class represents the state of the town in the LLAP problem. It encapsulates
essential information, including prosperity level, resource quantities (food, materials,
energy), money spent, delays, depth in the search tree, the action performed, and a
reference to the parent state.
- Actions Class
The Actions class provides methods to perform various actions in the town, such as
requesting food, materials, or energy, waiting, and building. It calculates the effects of these
actions on the state and returns the resulting state. The performAction method serves as a
dispatcher for different actions, making the code modular and easy to extend
- Search Algorithms
Our implementation incorporates several search algorithms to find an optimal plan for
achieving a prosperity level of 100. These algorithms include Breadth-First Search (BFS),
Depth-First Search (DFS), Uniform Cost Search (UCS), Iterative Deepening Search (IDS),
Greedy Search with two heuristics (Greedy1 and Greedy2), and A* Search with two
heuristics (A1 and A2).
    1. BFS: The Breadth-First Search explores states level by level, utilizing a priority
    queue based on the depth of each state. This ensures that shallower states are
    explored first, making it complete and optimal for finding the deepest path to the goal
    state.
    2. DFS: The Depth-First Search explores deeper states first using a stack. While not
    guaranteed to be optimal, DFS can be more memory-efficient than BFS.
    3. UCS: The Uniform Cost Search prioritizes states based on the total money spent. It
    guarantees optimality by always selecting the path with the minimum cumulative
    cost.
    4. IDS: The Iterative Deepening Search is a depth-limited strategy that systematically
    increases the depth limit until the goal state is found. It combines the advantages of
    DFS and BFS, providing an efficient and complete solution.
    5. Greedy Search: The Greedy Search algorithm uses two heuristics (Greedy1 and
    Greedy2) to prioritize states. Greedy1 estimates the remaining distance to the goal
    based on prosperity, while Greedy2 considers the prosperity-to-cost ratio.
    6. A* Search: The A* Search algorithm utilizes two admissible heuristics (A1 and A2)
    to guide the search efficiently. A1 estimates the remaining prosperity needed, and A2
    estimates resource shortages. Both heuristics ensure admissibility and optimality.

Our implementation demonstrates a comprehensive approach to solving the LLAP problem.
The State class, along with the Actions class, forms a solid foundation for representing and
manipulating states in the LLAP problem. The use of different search algorithms and
heuristics allows for a thorough exploration of the state space, providing flexibility in finding
optimal solutions based on different criteria.
