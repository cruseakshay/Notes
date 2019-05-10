# Statistical Simulation in Python
# ch-1 Basics of randomness & simulation
# Poisson random variable
# Initialize seed and parameters
np.random.seed(123) 
lam, size_1, size_2 = 5, 3, 1000  

# Draw samples & calculate absolute difference between lambda and sample mean
samples_1 = np.random.poisson(lam, size_1)
samples_2 = np.random.poisson(lam, size_2)
answer_1 = abs(np.mean(samples_1)-lam)
answer_2 = abs(np.mean(samples_2)-lam) 

print("|Lambda - sample mean| with {} samples is {} and with {} samples is {}. ".format(size_1, answer_1, size_2, answer_2))

# Shuffling a deck of cards
# Shuffle the deck
np.random.shuffle(deck_of_cards)

# Print out the top three cards
card_choices_after_shuffle = deck_of_cards[0:3]
print(card_choices_after_shuffle)

# Throwing a fair die
# first two steps of running a simulation - defining a random variable and assigning probabilities.
# Define die outcomes and probabilities
die, probabilities, throws = [1,2,3,4,5,6], [1/6,1/6,1/6,1/6,1/6,1/6], 1

# Use np.random.choice to throw the die once and record the outcome
outcome = np.random.choice(die, size=1, p=probabilities)
print("Outcome of the throw: {}".format(outcome[0]))

# Throwing two fair dice
# Initialize number of dice, simulate & record outcome
die, probabilities, num_dice = [1,2,3,4,5,6], [1/6, 1/6, 1/6, 1/6, 1/6, 1/6], 2
outcomes = np.random.choice(die, size=2, p=probabilities) 

# Win if the two dice show the same number
if outcomes[0] == outcomes[1]: 
    answer = 'win' 
else:
    answer = 'lose'

print("The dice show {} and {}. You {}!".format(outcomes[0], outcomes[1], answer))

# Simulating the dice game
# Initialize model parameters & simulate dice throw
die, probabilities, num_dice = [1,2,3,4,5,6], [1/6, 1/6, 1/6, 1/6, 1/6, 1/6], 2
sims, wins = 100, 0

for i in range(sims):
    outcomes = np.random.choice(die, size=2, p=probabilities) 
    # Increment `wins` by 1 if the dice show same number
    if outcomes[0] == outcomes[1]: 
        wins = wins + 1 

print("In {} games, you win {} times".format(sims, wins))

# Simulating one lottery drawing
lottery_ticket_cost, num_tickets, grand_prize = 10, 1000, 1000000

# Probability of winning
chance_of_winning = 1/num_tickets

# Code to simulate a single drawing of the lottery
gains = [-lottery_ticket_cost, grand_prize-lottery_ticket_cost]
probability = [1-chance_of_winning, chance_of_winning]
outcome = np.random.choice(a=gains, size=1, p=probability, replace=True)

print("Outcome of one drawing of the lottery is {}".format(outcome))

# Should we buy?
# Initialize size and simulate outcome
lottery_ticket_cost, num_tickets, grand_prize = 10, 1000, 1000000
chance_of_winning = 1/num_tickets
size = 2000
payoffs = [-lottery_ticket_cost, grand_prize-lottery_ticket_cost]
probs = [1 - chance_of_winning, chance_of_winning]

outcomes = np.random.choice(a=payoffs, size=size, p=probs, replace=True)

# Mean of outcomes.
answer = outcomes.mean()
print("Average payoff from {} simulations = {}".format(size, answer))

# Calculating a break-even lottery price
# Initialize simulations and cost of ticket
sims, lottery_ticket_cost = 3000, 0

# Use a while loop to increment `lottery_ticket_cost` till average value of outcomes falls below zero
while 1:
    outcomes = np.random.choice([-lottery_ticket_cost, grand_prize-lottery_ticket_cost],
                 size=sims, p=[1-chance_of_winning, chance_of_winning], replace=True)
    if outcomes.mean() < 0:
        break
    else:
        lottery_ticket_cost += 1
answer = lottery_ticket_cost - 1

print("The highest price at which it makes sense to buy the ticket is {}".format(answer))

# Problem Statement:
# National elections
# This exercise will give you a taste of how you can model a DGP at different levels of complexity.

# Consider national elections in a country with two political parties - Red and Blue. This country has 50 states and the party that wins the most states wins the elections. 
# You have the probability p of Red winning in each individual state and want to know the probability of Red winning nationally.

# Let's model the DGP to understand the distribution. Suppose the election outcome in each state follows a binomial distribution with probability p such that 0 indicates a loss for Red and 1 indicates a win. 
# We then simulate a number of election outcomes. Finally, we can ask rich questions like what is the probability of Red winning less than 45% of the states?
outcomes, sims, probs = [], 1000, p

for _ in range(sims):
    # Simulate elections in the 50 states
    election = np.random.binomial(p = probs, n = 1)
    # Get average of Red wins and add to `outcomes`
    outcomes.append(election.mean())

# Calculate probability of Red winning in less than 45% of the states
prob_red_wins = sum([(x < 0.45) for x in outcomes]) / len(outcomes)
print("Probability of Red winning in less than 45% of the states = {}".format(prob_red_wins))